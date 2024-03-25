package com.samtilee.drawdraw.diary.entity;

import com.samtilee.drawdraw.comment.entity.Comment;
import com.samtilee.drawdraw.common.entity.BaseTime;
import com.samtilee.drawdraw.diaryBook.entity.DiaryBook;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
public class Diary extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "diary_id")
    private Long id;

    private LocalDate date;

    @Enumerated(value = EnumType.STRING)
    private Weather weather;

    private String imageUrl;

    private String contents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "diary_book_id")
    private DiaryBook diaryBook;

    @OneToMany(mappedBy = "diary")
    private final List<Comment> comments = new ArrayList<>();
}
