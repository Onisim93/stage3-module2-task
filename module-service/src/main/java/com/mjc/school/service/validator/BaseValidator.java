package com.mjc.school.service.validator;
import com.mjc.school.service.exception.ValidatorException;

import static com.mjc.school.service.exception.ServiceErrorCode.*;

public abstract class BaseValidator<T> {
    protected void validateNumber(Long number, String parameter) {
        if (number == null || number < 1) {
            throw new ValidatorException(
                    String.format(VALIDATE_NEGATIVE_OR_NULL_NUMBER.getMessage(), parameter, parameter, number));
        }
    }

    protected void validateString(String value, String parameter, int minLength, int maxLength) {
        if (value == null) {
            throw new ValidatorException(
                    String.format(VALIDATE_NULL_STRING.getMessage(), parameter, parameter));
        }
        if (value.trim().length() < minLength || value.trim().length() > maxLength) {
            throw new ValidatorException(
                    String.format(
                            VALIDATE_STRING_LENGTH.getMessage(),
                            parameter,
                            minLength,
                            maxLength,
                            parameter,
                            value));
        }
    }

    public abstract void validate(T objectDto);

    public abstract void validateId(Long id);


}
