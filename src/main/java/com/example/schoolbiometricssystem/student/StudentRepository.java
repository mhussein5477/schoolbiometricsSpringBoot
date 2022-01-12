package com.example.schoolbiometricssystem.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface StudentRepository
        extends JpaRepository<Student, Long> {

        //get student by certain id
        @Query("SELECT s FROM Student s WHERE s.addmissionnumber = ?1")
        Optional<Student> findStudentByAddmissionnumber(Integer addmissionnumber);

}
