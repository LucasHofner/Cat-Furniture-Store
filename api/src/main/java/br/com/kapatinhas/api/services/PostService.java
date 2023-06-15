package br.com.kapatinhas.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.kapatinhas.api.model.dto.PostDTO;
import br.com.kapatinhas.api.model.entity.Post;
import br.com.kapatinhas.api.model.mapper.PostMapper;
import br.com.kapatinhas.api.repository.PostRepository;

@Service
public class PostService {
    
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostMapper postMapper;

    public Page<PostDTO> findPosts(Pageable pageable){
        return postRepository
                    .findAll(pageable)
                    .map(postMapper::convertToDto);
    }

    public void createPost(PostDTO postDto){
        Post post = postMapper.convertToEntity(postDto);
        postRepository.saveAndFlush(post);
    }

    public PostDTO deletePost(String uuid){
        Optional<Post> postToBeDeletedOpt = postRepository.getReferenceByUuid(uuid);

        if(!postToBeDeletedOpt.isPresent()) throw new ResponseStatusException(HttpStatusCode.valueOf(404));

        Post postToBeDeleted = postToBeDeletedOpt.get();
        postRepository.delete(postToBeDeleted);

        return postMapper.convertToDto(postToBeDeleted);
    }
}
