package com.example.Speedrun.REST.API.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetPersonDTO {

    private String name;

    private String address;

    private List<String> phoneNumber;

    private String job;
}
