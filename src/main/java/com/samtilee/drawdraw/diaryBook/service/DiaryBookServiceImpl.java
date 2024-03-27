package com.samtilee.drawdraw.diaryBook.service;

import com.samtilee.drawdraw.diaryBook.dto.request.DiaryBookRequest;
import com.samtilee.drawdraw.diaryBook.entity.DiaryBook;
import com.samtilee.drawdraw.diaryBook.repository.DiaryBookRepository;
import com.samtilee.drawdraw.diaryCover.entity.CoverType;
import com.samtilee.drawdraw.diaryCover.entity.DiaryCover;
import com.samtilee.drawdraw.diaryCover.exception.DiaryCoverException;
import com.samtilee.drawdraw.diaryCover.repository.DiaryCoverRepository;
import com.samtilee.drawdraw.member.entity.Member;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.samtilee.drawdraw.diaryCover.message.ErrorMessage.INVALID_TYPE;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DiaryBookServiceImpl implements DiaryBookService {

    private final DiaryBookRepository diaryBookRepository;
    private final DiaryCoverRepository diaryCoverRepository;

    @Override
    @Transactional
    public void saveDiaryBook(Member member, DiaryBookRequest request) {
        val diaryBook = createDiaryBook(member, request);
        diaryBookRepository.save(diaryBook);
    }

    private DiaryCover findDiaryCover(CoverType coverType) {
        return diaryCoverRepository.findByCoverType(coverType)
                .orElseThrow(() -> new DiaryCoverException(INVALID_TYPE));
    }

    private DiaryBook createDiaryBook(Member member, DiaryBookRequest request) {
        return DiaryBook.builder()
                .diaryName(request.diaryName())
                .diaryCover(findDiaryCover(request.coverType()))
                .group(request.group())
                .owner(request.owner())
                .open(request.open())
                .member(member)
                .build();
    }
}
