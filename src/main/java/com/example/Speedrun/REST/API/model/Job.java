package com.example.Speedrun.REST.API.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String job;

    public Job() {
    }
}
