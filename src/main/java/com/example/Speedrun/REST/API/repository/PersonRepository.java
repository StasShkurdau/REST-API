package com.example.Speedrun.REST.API.repository;

import com.example.Speedrun.REST.API.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    void deleteByName(String name);

    String findAddressByName(String name);

    List<String> findAllPhoneNumbersByName(String personName);

    String findJobByName(String personName);

    Person getByName(String name);

    Page<Person> findByAddress(String address,Pageable pageable);

    Page<Person> findAll(Pageable pageable);
}
