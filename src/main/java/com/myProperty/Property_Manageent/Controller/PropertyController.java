package com.myProperty.Property_Manageent.Controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.myProperty.Property_Manageent.Model.PropertyDataTransferDTO;
import com.myProperty.Property_Manageent.Service.PropertyService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/properties")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;
    @GetMapping("/hello")
    public String HelloWorld(){
        return "Hello Dear!";
    }

    @PostMapping("/save")
    public ResponseEntity<PropertyDataTransferDTO> saveProperty(@RequestBody PropertyDataTransferDTO propertyDataTransferDTO){
        propertyDataTransferDTO=propertyService.saveProperty(propertyDataTransferDTO);
        ResponseEntity<PropertyDataTransferDTO> responseEntity= new ResponseEntity<>(propertyDataTransferDTO, HttpStatus.CREATED);
        return responseEntity;

    }
    @GetMapping("/save")
    public ResponseEntity<List<PropertyDataTransferDTO>> getAllProperties(){
        List<PropertyDataTransferDTO> p=propertyService.getAllProperties();
        ResponseEntity<List<PropertyDataTransferDTO>> responseEntity = new ResponseEntity<>(p,HttpStatus.ACCEPTED);
        return responseEntity;
    }

    @PutMapping("/save/{id}")
    public ResponseEntity<PropertyDataTransferDTO> updateAllProperty(@RequestBody PropertyDataTransferDTO propertyDataTransferDTO, @PathVariable Long id){
        propertyDataTransferDTO = propertyService.updateAllProperties(propertyDataTransferDTO,id);
        ResponseEntity<PropertyDataTransferDTO> responseEntity = new ResponseEntity<>(propertyDataTransferDTO,HttpStatus.ACCEPTED);
        return responseEntity;
    }

    @PatchMapping("/save/update-Description/{id}")
    public ResponseEntity<PropertyDataTransferDTO> updatePropertyDescription(@RequestBody PropertyDataTransferDTO propertyDataTransferDTO, @PathVariable Long id){
        propertyDataTransferDTO = propertyService.updatePropertyDescription(propertyDataTransferDTO,id);
        ResponseEntity<PropertyDataTransferDTO> responseEntity = new ResponseEntity<>(propertyDataTransferDTO,HttpStatus.ACCEPTED);
        return responseEntity;
    }

    @PatchMapping("/save/update-Price/{id}")
    public ResponseEntity<PropertyDataTransferDTO> updatePropertyPrice(@RequestBody PropertyDataTransferDTO propertyDataTransferDTO, @PathVariable Long id){
        propertyDataTransferDTO = propertyService.updatePropertyPrice(propertyDataTransferDTO,id);
        ResponseEntity<PropertyDataTransferDTO> responseEntity = new ResponseEntity<>(propertyDataTransferDTO,HttpStatus.ACCEPTED);
        return responseEntity;
    }

    @DeleteMapping("property/delete/{id}")
    public void deleteProperty(@PathVariable Long id){
        propertyService.deleteProperty(id);
    }


}
