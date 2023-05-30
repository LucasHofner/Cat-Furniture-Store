package br.com.kapatinhas.api.controllers;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.kapatinhas.api.model.dto.PostDTO;

@RestController
@RequestMapping("/post")
public class PostController {
    
    @GetMapping("/find-all")
    public ResponseEntity<PostDTO> findPosts(@RequestParam LocalDateTime fromDate, @RequestParam LocalDateTime toDate){
        return null;
    }

    @PostMapping("/create")
    public void createPost(@RequestBody PostDTO post){
        System.out.println(post);
    }
}
