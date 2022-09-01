package com.gon.demo.domain.Guestbook;

import com.gon.demo.domain.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@ToString
public class Guestbook extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gno;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 1500, nullable = false)
    private String content;

    @Column(length = 50, nullable = false)
    private String writer;

    @Builder
    public Guestbook(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
    }

    public void updateGuestbook(String title, String content) {
        this.title = title;
        this.content = content;
    }


}
