package com.gon.demo.service;

import com.gon.demo.domain.posts.Posts;
import com.gon.demo.domain.posts.PostsRepository;
import com.gon.demo.web.dto.PostsListResponseDto;
import com.gon.demo.web.dto.PostsResponseDto;
import com.gon.demo.web.dto.PostsSaveRequestDto;
import com.gon.demo.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());
//        postsRepository.save(posts);
        //entity의 값만 변경하면 별도로 update 쿼리를 날릴 필요가 없다 -> 더티체킹
        return id;
    }

    @Transactional
    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc(){

        return postsRepository.findAllDesc().stream().map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void deleteById(Long id){
        Posts posts = postsRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시물이 없습니다. id=" + id));

        postsRepository.delete(posts);

        }






















}
