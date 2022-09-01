package com.gon.demo.service;

import com.gon.demo.web.dto.guestbook.GuestbookSaveRequestDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class GuestbookServicTest {

    @Autowired
    private GuestbookService servic;

    @Test
    @Transactional
    @Commit
    public void test01() throws Exception {

        //given
        GuestbookSaveRequestDto dto = GuestbookSaveRequestDto.builder()
                .title("title..")
                .content("content..")
                .writer("user0")
                .build();

        //when
        Long savedId = servic.register(dto);

        //then
        System.out.println("savedId = " + savedId);


    }

}