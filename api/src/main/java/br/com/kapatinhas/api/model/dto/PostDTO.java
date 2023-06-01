package br.com.kapatinhas.api.model.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;

public record PostDTO (

    Long id,
    
    @NotBlank
    String user, 
    
    LocalDateTime postDate, 
    
    String description, 
    
    @NotBlank
    String image) {

}
