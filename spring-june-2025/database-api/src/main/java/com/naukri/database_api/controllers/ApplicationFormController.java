package com.naukri.database_api.controllers;

import com.naukri.database_api.models.ApplicationForm;
import com.naukri.database_api.repositories.ApplicationFormRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/form")
public class ApplicationFormController {

    ApplicationFormRepository applicationFormRepository;

    @Autowired
    public ApplicationFormController(ApplicationFormRepository applicationFormRepository){
        this.applicationFormRepository = applicationFormRepository;
    }

    @PostMapping("/save")
    public ResponseEntity saveApplicationForm(@RequestBody ApplicationForm applicationForm){
        ApplicationForm form = applicationFormRepository.save(applicationForm);
        return new ResponseEntity(form, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity getApplicationFormById(@PathVariable UUID id){
        ApplicationForm form = applicationFormRepository.findById(id).orElse(null);
        return new ResponseEntity(form, HttpStatus.OK);
    }

    @GetMapping("/getAllForms")
    public  ResponseEntity<List<ApplicationForm>> GetAllApplicationForms(){
        List<ApplicationForm> forms = applicationFormRepository.findAll();
        return new ResponseEntity<>(forms, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateForm(@RequestBody ApplicationForm form){
        applicationFormRepository.save(form);
        return new ResponseEntity(form, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable UUID id){
        applicationFormRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
