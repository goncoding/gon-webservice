package com.gon.demo.web.dto.pages;

import lombok.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Getter
@ToString
@NoArgsConstructor
public class PageRequestDto {

    private int page;
    private int size;

    @Builder
    public PageRequestDto(int page, int size) {
        this.page = 1;
        this.size = 10;
    }

    public Pageable getPageable(Sort sort){
        return PageRequest.of(page -1, size, sort);
    }



}
