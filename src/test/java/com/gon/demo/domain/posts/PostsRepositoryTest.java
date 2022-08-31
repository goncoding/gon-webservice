package com.gon.demo.domain.posts;

import org.aspectj.lang.annotation.After;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

//    @AfterEach
//    public void cleanup(){
//        postsRepository.deleteAll();
//    }

    @Test
    @Commit
    void test01() throws Exception{
        //given
        String title = "test 게시글2";
        String content = "테스트 본문2";


        postsRepository.save(Posts.builder()
                        .title(title)
                        .content(content)
                        .author("gon2@gmail.com")
                        .build());


        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);

    }







}