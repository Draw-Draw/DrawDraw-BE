package com.samtilee.drawdraw.comment.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Stamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stamp_id")
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private StampType stampType;

    private String stampImageUrl;

    @OneToOne(mappedBy = "stamp")
    private Comment comment;
}
