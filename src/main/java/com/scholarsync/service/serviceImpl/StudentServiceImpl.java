package com.scholarsync.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scholarsync.exception.ResourceNotFoundException;
import com.scholarsync.model.Batch;
import com.scholarsync.model.StudentBatch;
import com.scholarsync.model.StudentsModel;

import com.scholarsync.repository.BatchRepository;
import com.scholarsync.repository.StudentBatchRepository;
import com.scholarsync.repository.StudentsRepository;
import com.scholarsync.request.StudentRequest;
import com.scholarsync.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
    @Autowired
    private StudentsRepository studentsRepository;

    @Autowired
    private BatchRepository batchRepository;

    @Autowired
    private StudentBatchRepository studentBatchRepository;

    @Override
    public StudentsModel addStudent(StudentRequest studentRequest) {
    	
        Optional<StudentsModel> existingStudentOptional = 
        studentsRepository.findByStudentEmailOrStudentMobileNumber(
            studentRequest.getStudentEmail(), 
            studentRequest.getStudentMobileNumber()
        );
    
	    if (existingStudentOptional.isPresent()) {
	        throw new ResourceNotFoundException("Student with email or mobile number already exists");
	    }
	
	    
	    StudentsModel student = new StudentsModel();
	    student.setFirstName(studentRequest.getFirstName().toUpperCase());
	    student.setLastName(studentRequest.getLastName().toUpperCase());
	    student.setStudentAddress(studentRequest.getStudentAddress().toUpperCase());
	    student.setStudentEmail(studentRequest.getStudentEmail());
	    student.setStudentMobileNumber(studentRequest.getStudentMobileNumber());
	    student.setStream(studentRequest.getStream().toUpperCase());
	    
	    student.setCourseType(studentRequest.getCourseType());
	    student.setFeesPaid(studentRequest.getFeesPaid());
	    student.setDiscount(studentRequest.getDiscount());
	    
	    student.setTotalFees(studentRequest.getTotalFees());

;
	    
	    
	    StudentsModel savedStudent = studentsRepository.save(student);
	
	  
	    Batch batch = batchRepository.findById(studentRequest.getBatchId())
	        .orElseThrow(() -> new ResourceNotFoundException("Batch not found"));
	
	    boolean associationExists = studentBatchRepository.existsByStudentsModelAndBatch(student, batch);
	   
	    if(!associationExists){
	        StudentBatch studentBatch = new StudentBatch();
	    studentBatch.setBatch(batch);
	    studentBatch.setStudentsModel(savedStudent);
	    studentBatchRepository.save(studentBatch);
	    }
	
	    return savedStudent;
    }

    @Override
    public StudentsModel updateStudent(Long id, StudentRequest studentRequest) {
        StudentsModel student = studentsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with ID: " + id));
        student.setFirstName(studentRequest.getFirstName().toUpperCase());
        student.setLastName(studentRequest.getLastName().toUpperCase());
        student.setStudentAddress(studentRequest.getStudentAddress());
        student.setStudentEmail(studentRequest.getStudentEmail());
        student.setStudentMobileNumber(studentRequest.getStudentMobileNumber());
        student.setStream(studentRequest.getStream());
        return studentsRepository.save(student);
    }

    @Override
    public List<StudentsModel> getAllStudents() {
        return studentsRepository.findAll();
    }

    @Override
    public StudentsModel getStudentByName(String name) {
        return studentsRepository.findByFirstNameOrLastName(name, name)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with name: " + name));
    }

    @Override
    public void deleteStudent(String name) {
        StudentsModel student = studentsRepository.findByFirstNameOrLastName(name, name)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with name: " + name));
        studentsRepository.delete(student);
    }

	@Override
	public StudentsModel getStudentByEmail(String studentEmail) {
		return studentsRepository.findByStudentEmail(studentEmail)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with studentEmail: " + studentEmail));	
	}
	
}
