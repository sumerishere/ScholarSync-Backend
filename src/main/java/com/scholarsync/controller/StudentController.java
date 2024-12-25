package com.scholarsync.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.scholarsync.emailService.EmailServiceClass;
import com.scholarsync.model.StudentsModel;
import com.scholarsync.request.StudentRequest;
import com.scholarsync.service.StudentService;

import io.jsonwebtoken.io.IOException;
import jakarta.mail.MessagingException;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin("*")
@RestController
@RequestMapping("api/students")
@Slf4j
public class StudentController {

    private final StudentService studentService;
    private final EmailServiceClass emailServiceClass; 
    
    @Autowired  // Add explicit autowiring
    public StudentController(StudentService studentService, EmailServiceClass emailServiceClass) {
        this.studentService = studentService;
        this.emailServiceClass = emailServiceClass;  // Fixed variable name
    }

    
    @PostMapping("/add-student")
    public ResponseEntity<?> addStudent(@RequestBody StudentRequest studentRequest) {
    	
        try {
            StudentsModel createdStudent = studentService.addStudent(studentRequest);
            
            try {
                emailServiceClass.studentMail(studentRequest.getFirstName(), studentRequest.getStudentEmail(), "coursetype");
            } 
            catch (IOException | MessagingException e) {
                log.error("Failed to send email to student: " + e.getMessage());
                return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
            }
            
            return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
        }
        catch (Exception e) {
            log.error("Error creating student: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An internal unexpected error occurred. Please try again later.");
        }
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
