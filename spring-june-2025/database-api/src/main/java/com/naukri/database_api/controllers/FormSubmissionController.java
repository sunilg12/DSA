package com.naukri.database_api.controllers;

import com.naukri.database_api.models.FormSubmission;
import com.naukri.database_api.repositories.FormSubmissionRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/formSubmission")
public class FormSubmissionController {

    FormSubmissionRepository formSubmissionRepository;

    @Autowired
    public FormSubmissionController(FormSubmissionRepository formSubmissionRepository){
        this.formSubmissionRepository = formSubmissionRepository;
    }

    @PostMapping("/save")
    public ResponseEntity saveFormSubmission(FormSubmission formSubmission){
        FormSubmission form = formSubmissionRepository.save(formSubmission);
        return new ResponseEntity(form, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity getSubmissionsById(@PathVariable UUID id){
        FormSubmission form = formSubmissionRepository.findById(id).orElse(null);
        return new ResponseEntity(form, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<FormSubmission>>  getAllFormSubmisssions(){
        List<FormSubmission> forms = formSubmissionRepository.findAll();
        return new ResponseEntity<>(forms, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity updateFromSubmisssion(FormSubmission formSubmission){
        FormSubmission formSubmissions = formSubmissionRepository.save(formSubmission);
        return new ResponseEntity(formSubmissions, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable UUID id){
        formSubmissionRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
