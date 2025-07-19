package com.example.testcrud.service;

import com.example.testcrud.entity.Student;
import com.example.testcrud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepo;

    public void setStudentWorkingStatus(Long userId, boolean isWorking) {
        Optional<Student> student = studentRepo.findById(userId);

        if (!student.isPresent()) return;
        student.get().setIsWorking(isWorking);
        studentRepo.save(student.get());
    }
}
