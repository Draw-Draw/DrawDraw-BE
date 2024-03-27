package com.samtilee.drawdraw.diaryBook.dto.request;

import com.samtilee.drawdraw.diaryCover.entity.CoverType;
import lombok.NonNull;

public record DiaryBookRequest(
        @NonNull CoverType coverType,
        @NonNull String diaryName,
        @NonNull String group,
        @NonNull String owner,
        @NonNull Boolean open
) {
}
