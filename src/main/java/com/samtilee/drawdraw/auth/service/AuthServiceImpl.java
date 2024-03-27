package com.samtilee.drawdraw.auth.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.samtilee.drawdraw.auth.dto.response.SignInResponse;
import com.samtilee.drawdraw.auth.exception.AuthException;
import com.samtilee.drawdraw.auth.jwt.JwtTokenProvider;
import com.samtilee.drawdraw.auth.jwt.UserAuthentication;
import com.samtilee.drawdraw.auth.vo.Token;
import com.samtilee.drawdraw.common.config.ValueConfig;
import com.samtilee.drawdraw.member.entity.Member;
import com.samtilee.drawdraw.member.exception.MemberException;
import com.samtilee.drawdraw.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

import static com.samtilee.drawdraw.auth.message.ErrorMessage.INVALID_TOKEN;
import static com.samtilee.drawdraw.member.message.ErrorMessage.INVALID_MEMBER;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthServiceImpl implements AuthService {

    private final ValueConfig valueConfig;
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private final MemberRepository memberRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    @Transactional
    public SignInResponse signIn(String socialAccessToken) {
        val member = getMember(socialAccessToken);
        val token = getToken(member);
        return SignInResponse.of(token);
    }

    @Override
    @Transactional
    public void signOut(long memberId) {
        val member = findMember(memberId);
        member.resetRefreshToken();
    }

    private Member getMember(String socialAccessToken) {
        val socialId = getSocialId(socialAccessToken);
        return signUp(socialId);
    }

    private String getSocialId(String socialAccessToken) {
        try {
            val headers = new HttpHeaders();
            headers.add("Authorization", socialAccessToken);
            val httpEntity = new HttpEntity<JsonArray>(headers);
            val responseData = restTemplate.postForEntity(valueConfig.getKakaoUri(), httpEntity, Object.class);
            return objectMapper.convertValue(responseData.getBody(), Map.class).get("id").toString();
        } catch (Exception exception) {
            throw new AuthException(INVALID_TOKEN);
        }
    }

    private Member signUp(String socialId) {
        return memberRepository.findBySocialId(socialId)
                .orElseGet(() -> saveMember(socialId));
    }

    private Member saveMember(String socialId) {
        val member = Member.builder()
                .socialId(socialId)
                .build();
        return memberRepository.save(member);
    }

    private Token getToken(Member member) {
        val token = generateToken(new UserAuthentication(member.getId(), null, null));
        member.updateRefreshToken(token.getRefreshToken());
        return token;
    }

    private Token generateToken(Authentication authentication) {
        return Token.builder()
                .accessToken(jwtTokenProvider.generateToken(authentication, valueConfig.getAccessTokenExpired()))
                .refreshToken(jwtTokenProvider.generateToken(authentication, valueConfig.getRefreshTokenExpired()))
                .build();
    }

    private Member findMember(long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new MemberException(INVALID_MEMBER));
    }
}
