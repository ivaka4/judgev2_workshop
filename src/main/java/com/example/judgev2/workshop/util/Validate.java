package com.example.judgev2.workshop.util;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = GitAddressExistValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Validate {
    String message() default "Invalid git address";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}