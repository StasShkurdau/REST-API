package com.example.Speedrun.REST.API.controllers;

import com.example.Speedrun.REST.API.DTO.AddPersonDTO;
import com.example.Speedrun.REST.API.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.util.Objects.isNull;

@RestController
@RequestMapping("api/v1/admin")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

/*
    @PostMapping(path = "/addPerson")
    public ResponseEntity<Object> addPerson(@RequestBody AddPersonDTO personDTO){
        if(isNull(personDTO)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        adminService.addPerson(personDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


 */
    @PostMapping(path = "/addAddress")
    public ResponseEntity<Object> addAddress(@RequestBody String newAddress){
        if(isNull(newAddress)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        adminService.addAddress(newAddress);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(path = "/changeName")
    public ResponseEntity<Object> changeName(@RequestBody String oldName, String newName){
        if(isNull(oldName)||isNull(newName)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        adminService.changeName(oldName, newName);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }




}
