package com.example.learnSpringBoot.JPACriteria.dto;

import com.example.learnSpringBoot.JPACriteria.entity.Address;
import lombok.Data;

@Data
public class AddressDto {
    private int id;

    private String city;
    private String state;
    private String country;
    private String landmark;
    private int pin;

    public AddressDto(int id, String city, String state, String country, String landmark, int pin) {
        this.id=id;
        this.city=city;
        this.state=state;
        this.country=country;
        this.landmark=landmark;
        this.pin=pin;
    }
}
