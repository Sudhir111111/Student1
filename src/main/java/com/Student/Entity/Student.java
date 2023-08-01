package com.Student.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min = 3, message = "First name must have at least 3 characters")
    private String firstName;

    @Size(min = 3, message = "Last name must have at least 3 characters")
    private String lastName;

    @NotNull(message = "DOB is mandatory")

    @AgeConstraint(minAge = 15, maxAge = 20, message = "Age should be between 15 and 20 years")
    private LocalDate dob;

    @Pattern(regexp = "[ABC]", message = "Section must be A, B, or C")
    private String section;

    @Pattern(regexp = "[MF]", message = "Gender must be M or F")
    private String gender;

    private Integer marks1;
    private Integer marks2;
    private Integer marks3;
    private Integer total;
    private Double average;
    private String result;

    // Constructor, getters, setters, and other methods
}
