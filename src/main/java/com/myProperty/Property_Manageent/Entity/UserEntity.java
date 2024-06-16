package com.myProperty.Property_Manageent.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="USER_TABLE")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String ownerName;
    private String ownerEmail;
    private String phoneNo;
    private String password;
}
