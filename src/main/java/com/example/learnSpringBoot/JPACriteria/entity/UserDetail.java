package com.example.learnSpringBoot.JPACriteria.entity;

import com.example.learnSpringBoot.JPACriteria.dto.UserDto;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;


@Entity
@Data
public class UserDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private int id;

    private String firstName;
    private String lastName;
    private long contact;
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_address", referencedColumnName = "address_id")
    private Address address;

    public UserDto toDto(){
        return new UserDto(this.id, this.firstName,this.lastName,this.contact,this.email,this.address);
    }


}
