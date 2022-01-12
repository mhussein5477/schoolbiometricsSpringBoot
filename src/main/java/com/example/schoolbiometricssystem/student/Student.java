package com.example.schoolbiometricssystem.student;

import javax.persistence.*;

@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    private String studentname;
    private Integer addmissionnumber;
    private Integer fingerprintnumber;
    private String parentname;
    private String phonenumber;

    public Student(Long id, String studentname, Integer addmissionnumber, Integer fingerprintnumber, String parentname, String phonenumber) {
        this.setId(id);
        this.setStudentname(studentname);
        this.setAddmissionnumber(addmissionnumber);
        this.setFingerprintnumber(fingerprintnumber);
        this.setParentname(parentname);
        this.setPhonenumber(phonenumber);
    }

    public Student(String studentname,
                   Integer addmissionnumber,
                   Integer fingerprintnumber,
                   String parentname,
                   String phonenumber) {
        this.setStudentname(studentname);
        this.setAddmissionnumber(addmissionnumber);
        this.setFingerprintnumber(fingerprintnumber);
        this.setParentname(parentname);
        this.setPhonenumber(phonenumber);
    }

    public Long getId() {
        return id;
    }

    public String getStudentname() {
        return studentname;
    }

    public Integer getAddmissionnumber() {
        return addmissionnumber;
    }

    public Integer getFingerprintnumber() {
        return fingerprintnumber;
    }

    public String getParentname() {
        return parentname;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + getId() +
                ", studentname='" + getStudentname() + '\'' +
                ", addmissionnumber=" + getAddmissionnumber() +
                ", fingerprintnumber=" + getFingerprintnumber() +
                ", parentname='" + getParentname() + '\'' +
                ", phonenumber='" + getPhonenumber() + '\'' +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public void setAddmissionnumber(Integer addmissionnumber) {
        this.addmissionnumber = addmissionnumber;
    }

    public void setFingerprintnumber(Integer fingerprintnumber) {
        this.fingerprintnumber = fingerprintnumber;
    }

    public void setParentname(String parentname) {
        this.parentname = parentname;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}
