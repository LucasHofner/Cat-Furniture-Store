package br.com.kapatinhas.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.kapatinhas.api.model.dto.UserDTO;
import br.com.kapatinhas.api.model.entity.User;
import br.com.kapatinhas.api.model.mapper.UserMapper;
import br.com.kapatinhas.api.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public void creatUser(UserDTO userDto){
        User user = userMapper.convertToEntity(userDto);
        userRepository.save(user);
    }

    public User findUserByEmail(String email){
        Optional<User> userOpt = userRepository.findByUserEmail(email);
        if(!userOpt.isPresent()) throw new ResponseStatusException(HttpStatusCode.valueOf(404));

        return userOpt.get();
    }

    public Page<UserDTO> findAll(Pageable pageable){
        return userRepository.findAll(pageable)
                    .map(userMapper::convertToDto);
    }

    public UserDTO deleteUser(String uuid){
        Optional<User> userToBeDeletedOpt = userRepository.getReferenceByUuid(uuid);

        if(!userToBeDeletedOpt.isPresent()) throw new ResponseStatusException(HttpStatusCode.valueOf(404));

        User userToBeDeleted = userToBeDeletedOpt.get();
        userRepository.delete(userToBeDeleted);

        return userMapper.convertToDto(userToBeDeleted);
    }
}
