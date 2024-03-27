package com.samtilee.drawdraw.member.controller;

import com.samtilee.drawdraw.common.dto.Response;
import com.samtilee.drawdraw.member.dto.request.MemberProfileRequest;
import com.samtilee.drawdraw.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.security.Principal;

import static com.samtilee.drawdraw.common.dto.Response.success;
import static com.samtilee.drawdraw.member.message.SuccessMessage.SUCCESS_CREATE_PROFILE;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<Response> createMemberProfile(Principal principal, @RequestBody MemberProfileRequest request) {
        val memberId = Long.parseLong(principal.getName());
        memberService.createMemberProfile(memberId, request);
        return ResponseEntity.created(getURI())
                .body(success(SUCCESS_CREATE_PROFILE.getMessage()));
    }

    private URI getURI() {
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/")
                .buildAndExpand()
                .toUri();
    }
}
