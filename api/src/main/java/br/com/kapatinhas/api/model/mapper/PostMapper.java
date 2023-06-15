package br.com.kapatinhas.api.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import br.com.kapatinhas.api.model.dto.PostDTO;
import br.com.kapatinhas.api.model.entity.Post;

@Mapper(componentModel = "spring", uses = UserMapper.class, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PostMapper {
    
    PostDTO convertToDto(Post post);

    Post convertToEntity(PostDTO post);
}
