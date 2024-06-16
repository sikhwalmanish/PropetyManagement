package com.myProperty.Property_Manageent.Service;

import com.myProperty.Property_Manageent.Model.PropertyDataTransferDTO;

import java.util.List;

public interface PropertyService {

    PropertyDataTransferDTO saveProperty(PropertyDataTransferDTO propertyDataTransferDTO);

    List<PropertyDataTransferDTO> getAllProperties();
    PropertyDataTransferDTO updateAllProperties(PropertyDataTransferDTO propertyDataTransferDTO, Long id);
    PropertyDataTransferDTO updatePropertyDescription(PropertyDataTransferDTO propertyDataTransferDTO, Long id);

    PropertyDataTransferDTO updatePropertyPrice(PropertyDataTransferDTO propertyDataTransferDTO, Long id);

    void deleteProperty(Long id);

}
