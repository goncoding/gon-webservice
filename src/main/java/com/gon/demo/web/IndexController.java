package com.gon.demo.web;

import com.gon.demo.service.PostsService;
import com.gon.demo.web.dto.PostsListResponseDto;
import com.gon.demo.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model){
        List<PostsListResponseDto> allDesc = postsService.findAllDesc();
        System.out.println("allDesc = " + allDesc);
        model.addAttribute("posts", allDesc);
        return "index";
    }

    @GetMapping("/posts/save")
    public String save(){
        return "posts-save";
    }


    @GetMapping("/posts/update/{id}")
    public String postUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post",dto);
        return "posts-update";
    }



}
