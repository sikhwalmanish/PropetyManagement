package com.myProperty.Property_Manageent.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {

    private  Long id;
    private String ownerName;
    @NotNull(message = "Owner Email is madnatory")
    @Size(message = "It is necessary to be less than 50  characters", min = 1, max = 50)
    private String ownerEmail;

    private String phoneNo;
    @NotNull(message = "Password cannot be is Empty")
    @Size(message = "It is necessary to be less than 20  characters", min = 1, max = 20)
    private String password;
}
