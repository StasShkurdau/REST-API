package com.example.Speedrun.REST.API.repository;

import com.example.Speedrun.REST.API.model.Job;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends PagingAndSortingRepository<Job, Long> {
}
