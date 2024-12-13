package com.scholarsync.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.scholarsync.model.StudentsModel;
import com.scholarsync.service.StudentService;


@RestController
@RequestMapping("/student/api")
public class StudentConroller {
	
	@Autowired
	StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity<Object> addStudent(@RequestBody StudentsModel studentsModel){
        return studentService.addStudent(studentsModel);
    }

    @PutMapping()
    public ResponseEntity<StudentsModel> updateStudent(@RequestBody StudentsModel studentsModel){
        return null;
    }

    @GetMapping()
    public ResponseEntity<List<StudentsModel>> getStudents(){
        return null;
    }

    public ResponseEntity<StudentsModel> getStudent(String name){
        return null;
    }

    public ResponseEntity<Void> deleteStudent(@RequestParam String name){
        return null;
    }

}
