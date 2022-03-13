package io.anastasiou.models;

import io.anastasiou.validation.Dob;
import io.anastasiou.validation.Gpa;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @NotEmpty(message="is required")
    @Column(name="first_name")
    private String firstName;

    @NotEmpty(message="is required")
    @Column(name="last_name")
    private String lastName;

    @Dob
    @Column(name="dob")
    private Date dob;

    @Gpa
    @Column(name="gpa")
    private Float gpa;

    public Student() {
    }

    public Student(String firstName, String lastName, Date dob, Float gpa) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.gpa = gpa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Float getGpa() {
        return gpa;
    }

    public void setGpa(Float gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob=" + dob +
                ", gpa=" + gpa +
                '}';
    }
}
