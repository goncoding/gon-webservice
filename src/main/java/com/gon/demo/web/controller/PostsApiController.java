package com.gon.demo.web.controller;

import com.gon.demo.service.PostsService;
import com.gon.demo.web.dto.posts.PostsResponseDto;
import com.gon.demo.web.dto.posts.PostsSaveRequestDto;
import com.gon.demo.web.dto.posts.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }
    
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        System.out.println("requestDto = " + requestDto);
        return postsService.update(id, requestDto);
    }
    
    @PostMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id){
        postsService.deleteById(id);
        return id;
    }




}
