package com.gon.demo.domain.Guestbook;

import com.gon.demo.domain.BaseTimeEntity;
import com.gon.demo.web.dto.guestbook.GuestbookDto;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@ToString
@Builder
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


    public Guestbook(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
    }

    public Guestbook(Long gno, String title, String content, String writer) {
        this.gno = gno;
        this.title = title;
        this.content = content;
        this.writer = writer;
    }

    public void updateGuestbook(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public GuestbookDto toDto(){
        return GuestbookDto.builder()
                .gno(gno)
                .title(title)
                .content(content)
                .writer(writer)
                .regDate(getCreateDate())
                .modDate(getModifiedDate())
                .build();
    }




}
