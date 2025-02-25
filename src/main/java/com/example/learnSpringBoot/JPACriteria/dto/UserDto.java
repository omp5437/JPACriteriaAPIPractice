package com.example.learnSpringBoot.JPACriteria.dto;

import com.example.learnSpringBoot.JPACriteria.entity.Address;
import lombok.Data;

@Data
public class UserDto {
    private int id;
    private String firstName;
    private String lastName;
    private long contact;
    private String email;
    private AddressDto address;

    public UserDto(int id, String firstName, String lastName, long contact, String email, Address address) {
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.contact=contact;
        this.email=email;
        this.address=address.toDto();
    }
}
