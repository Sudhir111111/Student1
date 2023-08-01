package com.Student.Service;

import com.Student.Entity.Student;
import com.Student.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(Student student) {

        calculateResult(student);
        return studentRepository.save(student);
    }

    public Student updateStudentMarks(int id, int marks1, int marks2, int marks3) {
        Student studentToUpdate = studentRepository.findById(id).orElse(null);

        if (studentToUpdate == null) {
            return null;
        }

        studentToUpdate.setMarks1(marks1);
        studentToUpdate.setMarks2(marks2);
        studentToUpdate.setMarks3(marks3);

        calculateResult(studentToUpdate);

        return studentRepository.save(studentToUpdate);
    }

    private void calculateResult(Student student) {
        int total = student.getMarks1() + student.getMarks2() + student.getMarks3();
        double average = total / 3.0;
        student.setTotal(total);
        student.setAverage(average);

        if (student.getMarks1() >= 35 && student.getMarks2() >= 35 && student.getMarks3() >= 35) {
            student.setResult("Pass");
        } else {
            student.setResult("Fail");
        }
    }
}
