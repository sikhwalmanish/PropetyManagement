package com.myProperty.Property_Manageent.Service.Impl;

import com.myProperty.Property_Manageent.Entity.UserEntity;
import com.myProperty.Property_Manageent.Exception.BusinessException;
import com.myProperty.Property_Manageent.Exception.ErrorModel;
import com.myProperty.Property_Manageent.Mapper.UserMapper;
import com.myProperty.Property_Manageent.Model.UserDTO;
import com.myProperty.Property_Manageent.Repository.UserRepository;
import com.myProperty.Property_Manageent.Service.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserServiceImpl implements UserInterface {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDTO register(UserDTO userDTO) {
        Optional<UserEntity> optionalUserEntity = userRepository.findByOwnerEmail(userDTO.getOwnerEmail());
        if(optionalUserEntity.isPresent()){
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("USER ALEADY PRESENT");
            errorModel.setMessage("This User is alreday registered please try with different Email");
            errorModelList.add(errorModel);
            throw new BusinessException(errorModelList);

        }
        UserEntity userEntity = new UserEntity();
        userEntity=userMapper.convertDTOtoEntity(userDTO);
        userRepository.save(userEntity);
        userDTO=userMapper.convertEntitytoDTO(userEntity);
        return userDTO;
    }

    @Override
    public UserDTO login(String email, String password) {
        UserDTO userDTO = null;
        Optional<UserEntity> opt = userRepository.findByOwnerEmailAndPassword(email, password);
        if(opt.isPresent()){
            userDTO = userMapper.convertEntitytoDTO(opt.get());
        }
        else {
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("E202");
            errorModel.setMessage("INVALID USER EMAIL AND PASSWORD");
            errorModelList.add(errorModel);
            throw new BusinessException(errorModelList);

        }
        return userDTO;
    }
}
