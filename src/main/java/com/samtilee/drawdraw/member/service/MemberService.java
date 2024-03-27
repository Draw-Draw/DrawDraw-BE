package com.samtilee.drawdraw.member.service;

import com.samtilee.drawdraw.member.dto.request.MemberProfileRequest;

public interface MemberService {

    void createMemberProfile(long memberId, MemberProfileRequest request);
}
