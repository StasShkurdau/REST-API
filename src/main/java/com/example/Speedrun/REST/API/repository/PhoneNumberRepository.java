package com.example.Speedrun.REST.API.repository;

import com.example.Speedrun.REST.API.model.PhoneNumber;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneNumberRepository extends CrudRepository<PhoneNumber, Long> {

    PhoneNumber getByPhoneNumber(String phoneNumber);

}
