package com.samtilee.drawdraw.diaryCover.entity;

import com.samtilee.drawdraw.diaryBook.entity.DiaryBook;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class DiaryCover {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "diary_cover_id")
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private CoverType coverType;

    private String coverImageUrl;

    @OneToOne(mappedBy = "diaryCover")
    private DiaryBook diaryBook;
}
