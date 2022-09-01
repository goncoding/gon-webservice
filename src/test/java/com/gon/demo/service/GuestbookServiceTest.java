package com.gon.demo.service;

import com.gon.demo.domain.Guestbook.Guestbook;
import com.gon.demo.web.dto.guestbook.GuestbookDto;
import com.gon.demo.web.dto.pages.PageRequestDto;
import com.gon.demo.web.dto.pages.PageResultDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class GuestbookServiceTest {

    @Autowired
    GuestbookService service;

    @Test
    public void test01() throws Exception {
        //given
        PageRequestDto pageRequestDto = PageRequestDto.builder().page(1).size(10).build();

        PageResultDto<GuestbookDto, Guestbook> resultDto = service.getList(pageRequestDto);

        for (GuestbookDto guestbookDto : resultDto.getDtoList()) {
            System.out.println("guestbookDto = " + guestbookDto);
        }

        //when


        //then
    }

}