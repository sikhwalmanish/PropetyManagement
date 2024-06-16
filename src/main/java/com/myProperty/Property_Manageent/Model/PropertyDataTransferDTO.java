package com.myProperty.Property_Manageent.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PropertyDataTransferDTO {

    private Long id;
    private String title;
    private String description;
    private Double price;
    private String address;

}
