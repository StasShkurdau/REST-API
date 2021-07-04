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


    @PostMapping(path = "/addPerson")
    public ResponseEntity<Object> addPerson(@RequestBody AddPersonDTO personDTO){
        if(isNull(personDTO)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        adminService.addPerson(personDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping(path = "/addAddress")
    public ResponseEntity<Object> addAddress(@RequestParam String newAddress){
        if(isNull(newAddress)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        adminService.addAddress(newAddress);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(path = "/changeName")
    public ResponseEntity<Object> changeName(@RequestParam String oldName,@RequestParam String newName){
        if(isNull(oldName)||isNull(newName)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        adminService.changeName(oldName, newName);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(path = "/changeAddress")
    public ResponseEntity<Object> changeAddress(@RequestParam String address,@RequestParam String name){
        if(isNull(address)||isNull(name)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        adminService.changeAddressByName(address, name);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/deletePerson")
    public ResponseEntity<Object> deletePerson(@RequestParam String name){
        if(isNull(name)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        adminService.deletePerson(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "/deleteAddress")
    public ResponseEntity<Object> deleteAddress(@RequestParam String name){
        if(isNull(name)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        adminService.deletePerson(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path = "/fillDB")
    public ResponseEntity<Object> fillDB(){
        adminService.fillDB();
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
