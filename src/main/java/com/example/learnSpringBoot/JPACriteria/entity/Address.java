package com.example.learnSpringBoot.JPACriteria.entity;

import com.example.learnSpringBoot.JPACriteria.dto.AddressDto;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="address_id")
    private int id;

    private String city;
    private String state;
    private String country;
    private String landmark;
    private int pin;

    @OneToOne(mappedBy = "address")
    private UserDetail userDetails;

    public AddressDto toDto(){
      return  new AddressDto(this.id,this.city,this.state,this.country,this.landmark,this.pin);
    }


}
