package com.scholarsync.service;

import java.util.List;

import com.scholarsync.model.StudentsModel;
import com.scholarsync.request.StudentRequest;

public interface StudentService {

    StudentsModel addStudent(StudentRequest studentRequest);
    StudentsModel updateStudent(Long id, StudentRequest studentRequest);
    List<StudentsModel> getAllStudents();
    StudentsModel getStudentByName(String name);
    void deleteStudent(String name);
}
