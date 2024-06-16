package com.myProperty.Property_Manageent.Controller;

import com.myProperty.Property_Manageent.Model.UserDTO;
import com.myProperty.Property_Manageent.Service.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserInterface userInterface;
    @PostMapping("/post")
    public ResponseEntity<UserDTO> postUser(@RequestBody UserDTO userDTO){
        userDTO = userInterface.register(userDTO);
        ResponseEntity<UserDTO> responseEntity = new ResponseEntity<>(userDTO, HttpStatus.CREATED);
        return responseEntity;
    }

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody UserDTO userDTO){
        userDTO = userInterface.login(userDTO.getOwnerEmail(), userDTO.getPassword());
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }
}
