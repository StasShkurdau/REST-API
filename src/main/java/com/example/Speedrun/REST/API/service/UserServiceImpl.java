package com.example.Speedrun.REST.API.service;

import com.example.Speedrun.REST.API.DTO.GetPersonDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    @Override
    public String getPerson(String inputPersonName) {
        return null;
    }
}
