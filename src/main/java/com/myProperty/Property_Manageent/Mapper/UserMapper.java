package com.myProperty.Property_Manageent.Mapper;

import com.myProperty.Property_Manageent.Entity.UserEntity;
import com.myProperty.Property_Manageent.Model.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDTO convertEntitytoDTO(UserEntity userEntity){
        UserDTO userDTO=new UserDTO();
        userDTO.setOwnerName(userEntity.getOwnerName());
        userDTO.setId(userEntity.getId());
        userDTO.setOwnerEmail(userEntity.getOwnerEmail());
        userDTO.setPhoneNo(userEntity.getPhoneNo());
        return userDTO;
    }

    public UserEntity convertDTOtoEntity(UserDTO userDTO){
        UserEntity userEntity=new UserEntity();
        userEntity.setOwnerName(userDTO.getOwnerName());
        userEntity.setPassword(userDTO.getPassword());
        userEntity.setOwnerEmail(userDTO.getOwnerEmail());
        userEntity.setPhoneNo(userDTO.getPhoneNo());
        return userEntity;
    }
}
