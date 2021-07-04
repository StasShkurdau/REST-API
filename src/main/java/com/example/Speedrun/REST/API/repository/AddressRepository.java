package com.example.Speedrun.REST.API.repository;

import com.example.Speedrun.REST.API.model.Address;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends PagingAndSortingRepository<Address, Long> {

    Address getByAddress(String address);

}
