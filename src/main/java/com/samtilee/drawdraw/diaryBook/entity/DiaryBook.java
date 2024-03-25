package com.samtilee.drawdraw.diaryBook.entity;

import com.samtilee.drawdraw.common.entity.BaseTime;
import com.samtilee.drawdraw.diary.entity.Diary;
import com.samtilee.drawdraw.diaryCover.entity.DiaryCover;
import com.samtilee.drawdraw.member.entity.Member;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
public class DiaryBook extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "diary_book_id")
    private Long id;

    @OneToOne
    private DiaryCover diaryCover;

    private String diaryName;

    private String group;

    private String name;

    private boolean open;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "diaryBook")
    private final List<Diary> diaries = new ArrayList<>();
}
