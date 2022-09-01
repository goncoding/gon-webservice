package com.gon.demo.web.dto.guestbook;

import com.gon.demo.domain.Guestbook.Guestbook;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class GuestbookSaveRequestDto {

    private String title;
    private String content;
    private String writer;

    @Builder
    public GuestbookSaveRequestDto(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
    }

    public Guestbook toEntity(){
        return Guestbook.builder()
                .title(title)
                .content(content)
                .writer(writer)
                .build();
    }

}
