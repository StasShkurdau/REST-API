package com.example.Speedrun.REST.API.service;

import com.example.Speedrun.REST.API.DTO.GetPersonDTO;
import com.example.Speedrun.REST.API.model.Person;
import com.example.Speedrun.REST.API.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final PersonRepository personRepository;


    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    public UserServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public GetPersonDTO getPerson(String personName) {
        GetPersonDTO personDTO = new GetPersonDTO();
        personDTO.setName(personName);
        personDTO.setAddress(personRepository.findAddressByName(personName));
        personDTO.setPhoneNumber(personRepository.findAllPhoneNumbersByName(personName));
        personDTO.setJob(personRepository.findJobByName(personName));
        return personDTO;
    }

    @Override
    public Page<Person> getAllPersons(Pageable pageable) {
        Page<Person> page = personRepository.findAll(pageable);
        return page;
    }

}
