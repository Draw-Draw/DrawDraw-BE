package com.samtilee.drawdraw.diary.repository;

import com.samtilee.drawdraw.diary.entity.Diary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaryRepository extends JpaRepository<Diary, Long> {
}
