package com.example.schoolbiometricssystem.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    //Gets all the users from the db
    public List<Student> GetStudents(){
        return studentRepository.findAll();
    }

    //Adding new user and check for existing user
    public void addNewStudent(Student student) {
       Optional<Student> studentOptional = studentRepository.findStudentByAddmissionnumber(student.getAddmissionnumber());
       if (studentOptional.isPresent()){
           throw new IllegalStateException("Addmission number taken");
       }
       studentRepository.save(student);

    }

    //delete a user
    public void deleteStudent(Long studentId) {
       boolean exist =  studentRepository.existsById(studentId);
       if (!exist){
           throw new IllegalStateException("Student with Id " + studentId + " doesn't exist");
       }
       studentRepository.deleteById(studentId);
    }

    //Update a user
    @Transactional
    public void updateStudent(Long studentId, String parentname, String phonenumber) {

    Student student = studentRepository.findById(studentId).
            orElseThrow(() -> new IllegalStateException("Student with the id: " + studentId + " doesn't exist"));

    if(parentname != null && parentname.length() > 0 && !Objects.equals(student.getParentname(), parentname)){
        student.setParentname(parentname);
    }
    if (phonenumber != null && phonenumber.length() > 0 && !Objects.equals(student.getPhonenumber(), phonenumber)){
        student.setPhonenumber(phonenumber);
    }



    }
}
