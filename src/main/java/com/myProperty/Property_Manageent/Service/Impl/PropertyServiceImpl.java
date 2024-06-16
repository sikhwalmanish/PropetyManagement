package com.myProperty.Property_Manageent.Service.Impl;

import com.myProperty.Property_Manageent.Entity.PropertyEntity;
import com.myProperty.Property_Manageent.Mapper.PropertyMapper;
import com.myProperty.Property_Manageent.Model.PropertyDataTransferDTO;
import com.myProperty.Property_Manageent.Repository.PropertyRepository;
import com.myProperty.Property_Manageent.Service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;
    @Autowired
    private PropertyMapper propertyMapper;

    @Override
    public PropertyDataTransferDTO saveProperty(PropertyDataTransferDTO propertyDataTransferDTO) {
        //Adapter Design Pattern
        PropertyEntity pe = new PropertyEntity();
        pe=propertyMapper.convertDTOtoEnitity(propertyDataTransferDTO);
        pe=propertyRepository.save(pe);
        propertyDataTransferDTO=propertyMapper.convertEntityToDTO(pe);
        return propertyDataTransferDTO;
    }

    @Override
    public List<PropertyDataTransferDTO> getAllProperties() {
        List<PropertyEntity> propertyEntities = (List<PropertyEntity>) propertyRepository.findAll();
        List<PropertyDataTransferDTO> propertyDataTransferDTOS = new ArrayList<>();
        for(PropertyEntity pe:propertyEntities){
            PropertyDataTransferDTO propertyDataTransferDTO = propertyMapper.convertEntityToDTO(pe);
            propertyDataTransferDTOS.add(propertyDataTransferDTO);
        }

        return propertyDataTransferDTOS;
    }

    @Override
    public PropertyDataTransferDTO updateAllProperties(PropertyDataTransferDTO propertyDataTransferDTO, Long id) {
        Optional<PropertyEntity> optEnt= propertyRepository.findById(id);
        PropertyDataTransferDTO dto = null;
        if(optEnt.isPresent()){
            PropertyEntity pe = optEnt.get();
            pe.setTitle(propertyDataTransferDTO.getTitle());
            pe.setDescription(propertyDataTransferDTO.getDescription());
            pe.setPrice(propertyDataTransferDTO.getPrice());
            pe.setAddress(propertyDataTransferDTO.getAddress());
            dto = propertyMapper.convertEntityToDTO(pe);
            propertyRepository.save(pe);
        }
        return dto;
    }

    @Override
    public PropertyDataTransferDTO updatePropertyDescription(PropertyDataTransferDTO propertyDataTransferDTO, Long id) {
        Optional<PropertyEntity> optEnt= propertyRepository.findById(id);

        if(optEnt.isPresent()){
            PropertyEntity pe = optEnt.get();
            pe.setDescription(propertyDataTransferDTO.getDescription());
            propertyDataTransferDTO = propertyMapper.convertEntityToDTO(pe);
            propertyRepository.save(pe);
        }
        return propertyDataTransferDTO;
    }

    @Override
    public PropertyDataTransferDTO updatePropertyPrice(PropertyDataTransferDTO propertyDataTransferDTO, Long id) {
        Optional<PropertyEntity> optEnt= propertyRepository.findById(id);

        if(optEnt.isPresent()){
            PropertyEntity pe = optEnt.get();
            pe.setPrice(propertyDataTransferDTO.getPrice());
            propertyDataTransferDTO = propertyMapper.convertEntityToDTO(pe);
            propertyRepository.save(pe);
        }
        return propertyDataTransferDTO;
    }

    @Override
    public void deleteProperty(Long id) {
        propertyRepository.deleteById(id);

    }


}
