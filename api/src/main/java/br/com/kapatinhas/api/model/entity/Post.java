package br.com.kapatinhas.api.model.entity;

import java.time.LocalDateTime;

import br.com.kapatinhas.api.model.dto.PostDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "post")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "user", nullable = false)
    private String user;

    @Column(name = "post_date", nullable = false)
    private LocalDateTime postDate;

    @Column(name = "post_description", nullable = true)
    private String description;

    @Column(name = "post_image", nullable = false)
    private String image;
}
