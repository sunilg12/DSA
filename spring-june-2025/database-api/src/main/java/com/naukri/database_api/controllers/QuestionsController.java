package com.naukri.database_api.controllers;

import com.naukri.database_api.models.Questions;
import com.naukri.database_api.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping
public class QuestionsController {

    QuestionRepository questionRepository;

    @Autowired
    public QuestionsController(QuestionRepository questionRepository){
        this.questionRepository = questionRepository;
    }

    @PostMapping("/save")
    public ResponseEntity saveQuestions(@RequestBody Questions question){
        Questions questions = questionRepository.save(question);
        return new ResponseEntity(questions, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity getQuestions(UUID id){
        Questions question = questionRepository.findById(id).orElse(null);
        return new ResponseEntity(question,HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Questions>> getAllQuestions(){
        return new ResponseEntity<>(questionRepository.findAll(), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity updateQuestions(Questions questions){
        questionRepository.save(questions);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable UUID id){
        questionRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
