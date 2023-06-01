package br.com.kapatinhas.api.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.kapatinhas.api.model.dto.PostDTO;
import br.com.kapatinhas.api.model.entity.Post;
import br.com.kapatinhas.api.model.mapper.PostMapper;
import br.com.kapatinhas.api.repository.PostRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostMapper postMapper;
    
    @GetMapping("/find")
    public ResponseEntity<List<PostDTO>> findPosts(){
        return ResponseEntity.ok(postRepository
                    .findAll()
                    .stream()
                    .map(postMapper::convertToDto)
                    .collect(Collectors.toList()));
    }

    @PostMapping("/create")
    public void createPost(@RequestBody @Valid PostDTO postDto){
        Post post = postMapper.convertToEntity(postDto);
        postRepository.saveAndFlush(post);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<PostDTO> deletePost(@RequestParam Long postId){
        Optional<Post> postToBeDeletedOpt = postRepository.findById(postId);

        if(!postToBeDeletedOpt.isPresent()) return ResponseEntity.notFound().build();

        Post postToBeDeleted = postToBeDeletedOpt.get();
        postRepository.delete(postToBeDeleted);

        return ResponseEntity.ok(
            postMapper.convertToDto(postToBeDeleted)
        );
    }
}
