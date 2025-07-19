package com.example.testcrud.controller;

import com.example.testcrud.entity.Student;
import com.example.testcrud.repository.StudentRepository;
import com.example.testcrud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable("id") long id) {
        Optional<Student> student = studentRepo.findById(id);
        if (student.isPresent()) {
            return student.get();
        } else {
            return null;
        }
    }

    @PostMapping
    public Student create(@RequestBody Student student) {
        return studentRepo.save(student);
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable("id") long id,
                          @RequestBody Student updatedStudent) {
        Optional<Student> existingStudentOpt = studentRepo.findById(id);

        if (existingStudentOpt.isPresent()) {
            Student existingStudent = existingStudentOpt.get();


            existingStudent.setName(updatedStudent.getName());
            existingStudent.setSurname(updatedStudent.getSurname());
            existingStudent.setIsWorking(updatedStudent.getIsWorking());


            if (updatedStudent.getId() != id) {
                studentRepo.deleteById(id);
                return studentRepo.save(updatedStudent);
            } else {
                return studentRepo.save(existingStudent);
            }
        } else {
            return null;
        }
    }

    @PatchMapping("/{id}/working")
    public void updateWorkingStatus(@PathVariable("id") long id,
                                    @RequestParam("working") boolean working) {
        studentService.setStudentWorkingStatus(id, working);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        studentRepo.deleteById(id);
    }
}
