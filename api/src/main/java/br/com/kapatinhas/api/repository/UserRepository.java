package br.com.kapatinhas.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.kapatinhas.api.model.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

    Optional<User> findByUserEmail(String userEmail);

    Optional<User> getReferenceByUuid(String uuid);
}
