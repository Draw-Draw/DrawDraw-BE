package com.samtilee.drawdraw.member.service;

import com.samtilee.drawdraw.diaryBook.service.DiaryBookService;
import com.samtilee.drawdraw.member.dto.request.MemberProfileRequest;
import com.samtilee.drawdraw.member.entity.Member;
import com.samtilee.drawdraw.member.exception.MemberException;
import com.samtilee.drawdraw.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.samtilee.drawdraw.member.message.ErrorMessage.INVALID_MEMBER;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final DiaryBookService diaryBookService;

    @Override
    @Transactional
    public void createMemberProfile(long memberId, MemberProfileRequest request) {
        val member = findMember(memberId);
        member.setName(request.name());
        diaryBookService.saveDiaryBook(member, request.request());
    }

    private Member findMember(long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new MemberException(INVALID_MEMBER));
    }
}
