package com.samtilee.drawdraw.diaryBook.repository;

import com.samtilee.drawdraw.diaryBook.entity.DiaryBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaryBookRepository extends JpaRepository<DiaryBook, Long> {
}
