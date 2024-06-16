package com.myProperty.Property_Manageent.Service;

import com.myProperty.Property_Manageent.Model.UserDTO;

public interface UserInterface {

    UserDTO register(UserDTO userDTO);
    UserDTO login(String email,String password);
}
