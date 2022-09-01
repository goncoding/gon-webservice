package com.gon.demo.service;

import com.gon.demo.domain.Guestbook.Guestbook;
import com.gon.demo.domain.Guestbook.GuestbookRepository;
import com.gon.demo.web.dto.guestbook.GuestbookDto;
import com.gon.demo.web.dto.guestbook.GuestbookSaveRequestDto;
import com.gon.demo.web.dto.pages.PageRequestDto;
import com.gon.demo.web.dto.pages.PageResultDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class GuestbookService {

    private final GuestbookRepository guestbookRepository;

    @Transactional
    public Long register(GuestbookSaveRequestDto dto){
        System.out.println("dto = " + dto);
        return guestbookRepository.save(dto.toEntity()).getGno();
    }

    @Transactional
    public PageResultDto<GuestbookDto, Guestbook> getList(PageRequestDto requestDto){

        Pageable pageable = requestDto.getPageable(Sort.by("gno").descending());

        Page<Guestbook> result = guestbookRepository.findAll(pageable);

        Function<Guestbook, GuestbookDto> fn = (Guestbook::toDto);

        return new PageResultDto<>(result, fn);

    }







}
