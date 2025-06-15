package com.naukri.database_api.controllers;

import com.naukri.database_api.models.Answer;
import com.naukri.database_api.repositories.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/answer")
public class AnswerController {

    AnswerRepository answerRepository;

    @Autowired
    public AnswerController(AnswerRepository answerRepository){
        this.answerRepository = answerRepository;
    }

    @PostMapping("/save")
    public ResponseEntity saveAnswer(@RequestBody Answer answer){
        Answer answers = answerRepository.save(answer);
        return new ResponseEntity(answers, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Answer>> getAllAnswers(){
        List<Answer> answer = answerRepository.findAll();
        return new ResponseEntity<>(answer, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getAnswer(@PathVariable UUID id){
        Answer answer = answerRepository.findById(id).orElse(null);
        return new ResponseEntity<>(answer, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity updateAnsswers(@RequestBody Answer answer){
        answerRepository.save(answer);
        return new ResponseEntity(answer, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable UUID id){
        answerRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
