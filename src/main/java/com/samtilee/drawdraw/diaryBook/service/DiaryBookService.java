package com.samtilee.drawdraw.diaryBook.service;

import com.samtilee.drawdraw.diaryBook.dto.request.DiaryBookRequest;
import com.samtilee.drawdraw.member.entity.Member;

public interface DiaryBookService {

    void saveDiaryBook(Member member, DiaryBookRequest request);
}
