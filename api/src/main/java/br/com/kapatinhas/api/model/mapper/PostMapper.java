package br.com.kapatinhas.api.model.mapper;

import java.time.LocalDateTime;

import org.mapstruct.Mapper;

import br.com.kapatinhas.api.model.dto.PostDTO;
import br.com.kapatinhas.api.model.entity.Post;

@Mapper(componentModel = "spring")
public interface PostMapper {
    
    default PostDTO convertToDto(Post post){
        return new PostDTO(post.getId(), post.getUser(), post.getPostDate(), post.getDescription(),post.getImage());
    };

    default Post convertToEntity(PostDTO post){
        Post newPost = new Post();
        newPost.setUser(post.user());
        newPost.setDescription(post.description());
        newPost.setImage(post.image());
        newPost.setPostDate(LocalDateTime.now());
        return newPost;
    }
}
