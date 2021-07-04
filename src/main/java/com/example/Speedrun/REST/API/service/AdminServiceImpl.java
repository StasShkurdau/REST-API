package com.example.Speedrun.REST.API.service;

import com.example.Speedrun.REST.API.AutoFillingOfDB;
import com.example.Speedrun.REST.API.DTO.AddPersonDTO;
import com.example.Speedrun.REST.API.model.Address;
import com.example.Speedrun.REST.API.model.Person;
import com.example.Speedrun.REST.API.model.PhoneNumber;
import com.example.Speedrun.REST.API.model.Job;
import com.example.Speedrun.REST.API.repository.AddressRepository;
import com.example.Speedrun.REST.API.repository.JobRepository;
import com.example.Speedrun.REST.API.repository.PersonRepository;
import com.example.Speedrun.REST.API.repository.PhoneNumberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import static java.util.Objects.*;

@Service
@Transactional
public class AdminServiceImpl implements  AdminService {

    private final AddressRepository addressRepository;
    private final PersonRepository personRepository;
    private final PhoneNumberRepository phoneNumberRepository;
    private final JobRepository jobRepository;

    private final Logger LOGGER= LoggerFactory.getLogger(this.getClass());

    public AdminServiceImpl(AddressRepository addressRepository, PersonRepository personRepository, PhoneNumberRepository phoneNumberRepository, JobRepository jobRepository) {
        this.addressRepository = addressRepository;
        this.personRepository = personRepository;
        this.phoneNumberRepository = phoneNumberRepository;
        this.jobRepository = jobRepository;
    }


    @Override
    public void addPerson(AddPersonDTO addPersonDTO) {

        Person newPerson = new Person();
        Address address = addAddress(addPersonDTO.getAddress());
        newPerson.setAddress(address);
        PhoneNumber phoneNumber = addPhoneNumber(addPersonDTO.getPhoneNumber());
        newPerson.addPhoneNumber(phoneNumber);
        Job newJob = new Job();
        newJob.setJob(addPersonDTO.getJob());
        newPerson.setJob(newJob);
        newPerson.setName(addPersonDTO.getName());
        personRepository.save(newPerson);
        LOGGER.info("Admin added person");
    }


    public PhoneNumber addPhoneNumber(String inputPhoneNumber) {
        PhoneNumber phoneNumber = phoneNumberRepository.getByPhoneNumber(inputPhoneNumber);
        if(isNull(phoneNumber)) {
            PhoneNumber newPhoneNumber = new PhoneNumber();
            newPhoneNumber.setPhoneNumber(inputPhoneNumber);
            phoneNumber = phoneNumberRepository.save(newPhoneNumber);
        }
        return phoneNumber;
    }


    public Address addAddress(String addressName) {
        Address address = addressRepository.getByAddress(addressName);
        if(isNull(address)) {
            Address newAddress = new Address();
            newAddress.setAddress(addressName);
            address = addressRepository.save(newAddress);
        }
        return address;
    }

    @Override
    public void changeName(String oldName, String newName) {
        Person person = personRepository.getByName(oldName);
        person.setName(newName);
        personRepository.save(person);
        LOGGER.info("Admin changed name from" + oldName + "to" + newName);
    }

    @Override
    public void changeAddressByName(String addressName, String name) {
        Person person = personRepository.getByName(name);
        Address address = changeAddress(addressName);
        person.setAddress(address);
        personRepository.save(person);
        LOGGER.info("Admin changed address of person" + name + " " + addressName);
    }

    @Override
    public void deletePerson(String name) {
        personRepository.deleteByName(name);
        LOGGER.info("Admin deleted person named" + name);
    }

    @Override
    public void fillDB() {
        AutoFillingOfDB autoFillingOfDB = new AutoFillingOfDB(addressRepository,personRepository,phoneNumberRepository,jobRepository);
        autoFillingOfDB.fillDB();
    }

    private Address changeAddress(String addressName) {
        Address address = addressRepository.getByAddress(addressName);
        if(isNull(address)) {
            throw new IllegalArgumentException("This address does not exist");
        }
        return address;
    }


}
