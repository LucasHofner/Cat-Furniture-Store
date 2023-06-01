package br.com.kapatinhas.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.kapatinhas.api.model.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long>{
    
}
