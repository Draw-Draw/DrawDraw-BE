package com.samtilee.drawdraw.member.entity;

import com.samtilee.drawdraw.common.entity.BaseTime;
import com.samtilee.drawdraw.diaryBook.entity.DiaryBook;
import com.samtilee.drawdraw.member.exception.MemberException;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.samtilee.drawdraw.member.message.ErrorMessage.EXIST_PROFILE;

@Entity
@Getter
@NoArgsConstructor
public class Member extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String socialId;

    private String refreshToken;

    private String name;

    @OneToMany(mappedBy = "member")
    private final List<DiaryBook> diaryBooks = new ArrayList<>();

    @Builder
    public Member(String socialId) {
        this.socialId = socialId;
    }

    public void updateRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public void setName(String name) {
        if (Objects.nonNull(this.name)) {
            throw new MemberException(EXIST_PROFILE);
        }
        this.name = name;
    }
}
