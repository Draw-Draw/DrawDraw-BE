package com.samtilee.drawdraw.diaryBook.entity;

import com.samtilee.drawdraw.common.entity.BaseTime;
import com.samtilee.drawdraw.diary.entity.Diary;
import com.samtilee.drawdraw.diaryCover.entity.DiaryCover;
import com.samtilee.drawdraw.member.entity.Member;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    private String owner;

    private boolean open;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "diaryBook")
    private final List<Diary> diaries = new ArrayList<>();

    @Builder
    public DiaryBook(DiaryCover diaryCover, String diaryName, String group, String owner, Boolean open, Member member) {
        this.diaryCover = diaryCover;
        this.diaryName = diaryName;
        this.group = group;
        this.owner = owner;
        this.open = open;
        setMember(member);
    }

    private void setMember(Member member) {
        if (Objects.isNull(this.member)) {
            this.member = member;
        }
        this.member.getDiaryBooks().add(this);
    }
}
