package com.gon.demo.web.dto;

import com.gon.demo.web.HelloController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class HelloResponseDtoTest {

    @Test
    void test01() throws Exception{
        //given
        String name = "test";
        int amount = 1000;

        HelloResponseDto dto = new HelloResponseDto(name, amount);

        Assertions.assertThat(dto.getAmount()).isEqualTo(amount);
        Assertions.assertThat(dto.getName()).isEqualTo(name);

        //when


        //then
    }


}