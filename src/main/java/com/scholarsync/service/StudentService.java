package com.scholarsync.service;

import java.util.List;

import com.scholarsync.model.StudentsModel;

public interface StudentService {

    StudentsModel addStudent(StudentsModel studentsModel);
    StudentsModel updateStudent(StudentsModel studentsModel);
    List<StudentsModel> getStudents();
    StudentsModel getStudent(String name);
    void deleteStudent(String name);
}
