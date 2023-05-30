package br.com.kapatinhas.api.model.dto;

import java.time.LocalDateTime;

public record PostDTO (String user, LocalDateTime postDate, String description, String image) {

}
