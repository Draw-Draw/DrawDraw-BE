package com.samtilee.drawdraw.member.entity;

import com.samtilee.drawdraw.common.entity.BaseTime;
import com.samtilee.drawdraw.diaryBook.entity.DiaryBook;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
public class Member extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private SocialType socialType;

    private String socialId;

    private String refreshToken;

    private String name;

    @OneToMany(mappedBy = "member")
    private final List<DiaryBook> diaryBooks = new ArrayList<>();

}
