package com.gon.demo.web.dto.guestbook;

import com.gon.demo.domain.BaseTimeEntity;
import com.gon.demo.domain.Guestbook.Guestbook;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;


import javax.persistence.*;
import java.time.LocalDateTime;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GuestbookDto  {

    private Long gno;
    private String title;
    private String content;
    private String writer;

    private LocalDateTime regDate;

    private LocalDateTime modDate;


    public Guestbook toEntity(){
        return Guestbook.builder()
                .gno(gno)
                .title(title)
                .content(content)
                .writer(writer)
                .build();
    }


}
