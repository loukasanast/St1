package io.anastasiou.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class DobConstraintValidator implements ConstraintValidator<Dob, Date> {

    @Override
    public void initialize(Dob dob) {
    }

    @Override
    public boolean isValid(Date dob, ConstraintValidatorContext ctx) {
        if(dob != null && dob.before(Date.from(Instant.now()))) {
            return true;
        } else {
            return false;
        }
    }

}