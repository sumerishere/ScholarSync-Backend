package com.scholarsync.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.scholarsync.model.StudentsModel;
import com.scholarsync.repository.StudentRepository;
import com.scholarsync.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentRepository studentRepository;

    @Override
    public ResponseEntity<Object> addStudent(StudentsModel studentsModel) {
    	
    	if(studentsModel == null) {
    		throw new RuntimeException("student data null!!");
    	}
        return new ResponseEntity<>(studentRepository.save(studentsModel), HttpStatus.CREATED);
    }

    @Override
    public StudentsModel updateStudent(StudentsModel studentsModel) {
        return null;
    }

    @Override
    public List<StudentsModel> getStudents() {
        return null;
    }

    @Override
    public StudentsModel getStudent(String name) {
       return null;
    }

    @Override
    public void deleteStudent(String name) {
       
    }
    
}
