package com.example.Speedrun.REST.API.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddPersonDTO {

    private String name;

    private String address;

    private String phoneNumber;

    private String job;
}
