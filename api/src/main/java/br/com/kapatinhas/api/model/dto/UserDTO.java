package br.com.kapatinhas.api.model.dto;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;

import br.com.kapatinhas.api.model.CustomViewConfig;
import jakarta.validation.constraints.NotBlank;

@JsonIgnoreProperties(ignoreUnknown=true)
public record UserDTO (

    @NotBlank
    @JsonView(CustomViewConfig.Public.class)
    String userName, 

    @NotBlank
    @JsonView(CustomViewConfig.Public.class)
    String userEmail,

    @JsonView(CustomViewConfig.Public.class)
    UUID uuid, 
    
    @JsonView(CustomViewConfig.Internal.class)
    @NotBlank
    String userPassword) {

        public UserDTO(String userName, String userEmail, UUID uuid){
            this(userName, userEmail, uuid, null);
        }
}
