package io.anastasiou.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class GpaConstraintValidator implements ConstraintValidator<Gpa, Float> {

    @Override
    public void initialize(Gpa gpa) {
    }

    @Override
    public boolean isValid(Float gpa, ConstraintValidatorContext ctx) {
        if(gpa == null || gpa < 0.0f || gpa > 4.0f) {
            return false;
        } else {
            return true;
        }
    }

}