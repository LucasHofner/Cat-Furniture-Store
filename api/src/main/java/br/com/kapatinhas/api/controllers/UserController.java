package br.com.kapatinhas.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import br.com.kapatinhas.api.model.CustomViewConfig;
import br.com.kapatinhas.api.model.dto.UserDTO;
import br.com.kapatinhas.api.services.UserService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    
    @JsonView(CustomViewConfig.Public.class)
    @GetMapping("/find")
    public ResponseEntity<Page<UserDTO>> findUsers(@PageableDefault(size = 10, sort = {"userName"}) Pageable pageable){
        return ResponseEntity.ok(userService.findAll(pageable));
    }

    @JsonView(CustomViewConfig.Internal.class)
    @PostMapping("/create")
    public void createUser(@RequestBody @Valid UserDTO userDto){
        userService.creatUser(userDto);
    }

    @JsonView(CustomViewConfig.Public.class)
    @DeleteMapping("/delete")
    public ResponseEntity<UserDTO> deleteUser(@RequestParam String uuid){
        try{
            return ResponseEntity.ok(userService.deleteUser(uuid));
        } catch(ResponseStatusException e){
            return ResponseEntity.notFound().build();
        }
    }
}