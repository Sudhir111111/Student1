package com.Student.Entity;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.Period;

public class AgeConstraintValidator implements ConstraintValidator<AgeConstraint, LocalDate> {

    private int minAge;
    private int maxAge;

    @Override
    public void initialize(AgeConstraint constraint) {
        this.minAge = constraint.minAge();
        this.maxAge = constraint.maxAge();
    }

    @Override
    public boolean isValid(LocalDate dob, ConstraintValidatorContext context) {
        if (dob == null) {
            return false;
        }

        LocalDate today = LocalDate.now();
        int age = Period.between(dob, today).getYears();
        return age >= minAge && age <= maxAge;
    }
}
