package com.example.Speedrun.REST.API.service;

import com.example.Speedrun.REST.API.DTO.AddPersonDTO;
import com.example.Speedrun.REST.API.model.Address;

public interface AdminService {
    void addPerson(AddPersonDTO addPersonDTO);

    Address addAddress(String newAddress);

    void changeName(String oldName, String newName);

    void changeAddressByName(String address, String name);

    void deletePerson(String name);

    void fillDB();


}
