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

    public Student setStudentWorkingStatus(Long userId, boolean isWorking) {
        Optional<Student> student = studentRepo.findById(userId);

        if (!student.isPresent()) return null;
        student.get().setIsWorking(isWorking);
        return studentRepo.save(student.get());
    }
}
