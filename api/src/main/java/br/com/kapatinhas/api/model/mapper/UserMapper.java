package br.com.kapatinhas.api.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import br.com.kapatinhas.api.model.dto.UserDTO;
import br.com.kapatinhas.api.model.entity.User;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    
    UserDTO convertToDto(User user);

    User convertToEntity(UserDTO user);
}
