package com.example.Speedrun.REST.API.service;

import com.example.Speedrun.REST.API.DTO.GetPersonDTO;
import com.example.Speedrun.REST.API.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    GetPersonDTO getPerson(String getPersonDTO);

    Page<Person> getAllPersons(Pageable pageable);

}
