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
        StudentsModel student = new StudentsModel();
        student.setFirstName(studentRequest.getFirstName().toUpperCase());
        student.setLastName(studentRequest.getLastName().toUpperCase());
        student.setStudentAddress(studentRequest.getStudentAddress().toUpperCase());
        student.setStudentEmail(studentRequest.getStudentEmail());
        student.setStudentMobileNumber(studentRequest.getStudenttMobileNumber());
        student.setStream(studentRequest.getStream().toUpperCase());
        StudentsModel studentsModel = studentsRepository.save(student);
        StudentBatch studentBatch = new StudentBatch();
        Optional<Batch> batch = batchRepository.findById(studentRequest.getBatchId());
        if(batch.isEmpty()){
            throw new ResourceNotFoundException("Batch not found");
        }
        studentBatch.setBatch(batch.get());
        studentBatch.setStudentsModel(studentsModel);
        studentBatchRepository.save(studentBatch);
        return studentsModel;
    }

    @Override
    public StudentsModel updateStudent(Long id, StudentRequest studentRequest) {
        StudentsModel student = studentsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with ID: " + id));
        student.setFirstName(studentRequest.getFirstName().toUpperCase());
        student.setLastName(studentRequest.getLastName().toUpperCase());
        student.setStudentAddress(studentRequest.getStudentAddress());
        student.setStudentEmail(studentRequest.getStudentEmail());
        student.setStudentMobileNumber(studentRequest.getStudenttMobileNumber());
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
    
}
