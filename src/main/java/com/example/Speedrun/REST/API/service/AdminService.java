package com.example.Speedrun.REST.API.service;

import com.example.Speedrun.REST.API.DTO.AddPersonDTO;
import com.example.Speedrun.REST.API.model.Address;

public interface AdminService {
    String addPerson(AddPersonDTO addPersonDTO);

    Address addAddress(String newAddress);

    void changeName(String oldName, String newName);

    String deletePhoneNumbersByName(String name);

    String changeAddressByName(String address);

    String deletePerson(String name);

    String deleteAddress(String address);

}
