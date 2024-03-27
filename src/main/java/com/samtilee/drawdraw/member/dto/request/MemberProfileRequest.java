package com.samtilee.drawdraw.member.dto.request;

import com.samtilee.drawdraw.diaryBook.dto.request.DiaryBookRequest;
import lombok.NonNull;

public record MemberProfileRequest(
        @NonNull String name,
        @NonNull DiaryBookRequest request
) {
}
