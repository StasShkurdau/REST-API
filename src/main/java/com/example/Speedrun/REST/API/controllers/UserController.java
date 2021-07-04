package com.example.Speedrun.REST.API.controllers;

import com.example.Speedrun.REST.API.DTO.GetPersonDTO;
import com.example.Speedrun.REST.API.model.Person;
import com.example.Speedrun.REST.API.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.util.Objects.isNull;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping(path = "/getPerson")
    public ResponseEntity<Object> getPerson(@RequestParam String name){
        if(isNull(name)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        GetPersonDTO personDTO = service.getPerson(name);
        return new ResponseEntity<>(personDTO , HttpStatus.OK);
    }

    @GetMapping(path = "/getAllPerson")
    public ResponseEntity<Object> getAllPerson(@PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC)Pageable pageable){
        Page<Person> page = service.getAllPersons(pageable);
        return new ResponseEntity<>(page , HttpStatus.OK);
    }

}
