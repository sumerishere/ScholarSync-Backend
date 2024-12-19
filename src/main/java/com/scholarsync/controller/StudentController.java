package com.scholarsync.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.scholarsync.model.StudentsModel;
import com.scholarsync.request.StudentRequest;
import com.scholarsync.service.StudentService;

@CrossOrigin("*")
@RestController
@RequestMapping("api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @PostMapping("/add-student")
    public ResponseEntity<StudentsModel> addStudent(@RequestBody StudentRequest studentRequest) {
        StudentsModel createdStudent = studentService.addStudent(studentRequest);
        return ResponseEntity.ok(createdStudent);
    }


    @PutMapping("/{id}")
    public ResponseEntity<StudentsModel> updateStudent(@PathVariable Long id, @RequestBody StudentRequest studentRequest) {
        StudentsModel updatedStudent = studentService.updateStudent(id, studentRequest);
        return ResponseEntity.ok(updatedStudent);
    }

    @GetMapping("/get-all-students")
    public ResponseEntity<List<StudentsModel>> getStudents() {
        List<StudentsModel> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/{name}")
    public ResponseEntity<StudentsModel> getStudent(@PathVariable String name) {
        StudentsModel student = studentService.getStudentByName(name);
        return ResponseEntity.ok(student);
    }
    
    @GetMapping("/get-by-email")
    public ResponseEntity<StudentsModel> getStudentByEmail(@RequestParam("studentEmail") String studentEmail){
        StudentsModel student = studentService.getStudentByEmail(studentEmail);    	
    	return ResponseEntity.ok(student);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteStudent(@PathVariable String name) {
        studentService.deleteStudent(name);
        return ResponseEntity.noContent().build();
    }
}
