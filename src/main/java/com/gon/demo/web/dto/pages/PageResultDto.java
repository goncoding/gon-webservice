package com.gon.demo.web.dto.pages;

import com.gon.demo.domain.Guestbook.Guestbook;
import com.gon.demo.web.dto.guestbook.GuestbookDto;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
public class PageResultDto<DTO, EN> {

    private  List<DTO> dtoList;

    //entity를 dto로 변경해서 list로 담아줌
    public PageResultDto(Page<EN> result, Function<EN, DTO> fn){
        dtoList = result.stream().map(fn).collect(Collectors.toList());
    }


}
