package com.myProperty.Property_Manageent.Mapper;

import com.myProperty.Property_Manageent.Entity.PropertyEntity;
import com.myProperty.Property_Manageent.Model.PropertyDataTransferDTO;
import org.springframework.stereotype.Component;

@Component
public class PropertyMapper {

    public PropertyEntity convertDTOtoEnitity(PropertyDataTransferDTO propertyDataTransferDTO){

        PropertyEntity pe = new PropertyEntity();
        pe.setTitle(propertyDataTransferDTO.getTitle());
        pe.setDescription(propertyDataTransferDTO.getDescription());
        pe.setPrice(propertyDataTransferDTO.getPrice());
        pe.setAddress(propertyDataTransferDTO.getAddress());

        return pe;
    }

    public PropertyDataTransferDTO convertEntityToDTO(PropertyEntity propertyEntity){
        PropertyDataTransferDTO propertyDataTransferDTO = new PropertyDataTransferDTO();
        propertyDataTransferDTO.setId(propertyEntity.getId());
        propertyDataTransferDTO.setTitle(propertyEntity.getTitle());
        propertyDataTransferDTO.setDescription(propertyEntity.getDescription());
        propertyDataTransferDTO.setPrice(propertyEntity.getPrice());
        propertyDataTransferDTO.setAddress(propertyEntity.getAddress());
        return propertyDataTransferDTO;
    }


}
