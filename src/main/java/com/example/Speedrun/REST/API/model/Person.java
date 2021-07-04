package com.example.Speedrun.REST.API.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String name;

    @ManyToMany
    @JoinTable(name = "person_phone_number",
            joinColumns=@JoinColumn(name="person_id"),
            inverseJoinColumns=@JoinColumn(name="phone_number_id"))
    private List<PhoneNumber> phoneNumbers;

    @OneToOne(optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name="work_id")
    private Job job;

    @ManyToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name="person_id")
    private Address address;

    public void setPhoneNumber(PhoneNumber newPhoneNumber){
       phoneNumbers.add(newPhoneNumber);
    }

}
