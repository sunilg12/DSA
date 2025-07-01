package com.naukri.database_api.controllers;

import com.naukri.database_api.models.Job;
import com.naukri.database_api.repositories.JobRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/job")
public class JobController {

    JobRepository jobRepository;

    @Autowired
    public  JobController(JobRepository jobRepository){
        this.jobRepository=jobRepository;
    }

    @PostMapping("/save")
    public ResponseEntity saveJob(@RequestBody Job job){
        job = jobRepository.save(job);
        return new ResponseEntity(job, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable UUID id){
        Job job = jobRepository.findById(id).orElse(null);
        return new ResponseEntity<>(job, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity updateJob(@RequestBody Job job){
        jobRepository.save(job);
        return new ResponseEntity(job, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable UUID id){
        jobRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
