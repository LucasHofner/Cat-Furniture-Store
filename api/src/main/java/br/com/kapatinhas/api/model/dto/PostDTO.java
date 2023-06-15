package br.com.kapatinhas.api.model.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonView;

import br.com.kapatinhas.api.model.CustomViewConfig;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record PostDTO (
    
    @Valid
    @JsonView(CustomViewConfig.Public.class)
    UserDTO user, 

    @JsonView(CustomViewConfig.Public.class)
    UUID uuid, 
    
    @JsonView(CustomViewConfig.Public.class)
    LocalDateTime postDate, 
    
    @JsonView(CustomViewConfig.Public.class)
    String description, 
    
    @NotBlank
    @JsonView(CustomViewConfig.Public.class)
    String image) {

}
