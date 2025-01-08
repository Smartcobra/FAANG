package strategy.filevalidator;

import java.util.HashMap;
import java.util.Map;

public class ValidationContext {
    private final Map<String, FieldValidator<?>> validators = new HashMap<>();

    public <T> void addValidator(String fieldName, FieldValidator<T> validator) {
        validators.put(fieldName, validator);
    }

    @SuppressWarnings("unchecked")
    public <T> void validate(String fieldName, T value) throws ValidationException {
        FieldValidator<T> validator = (FieldValidator<T>) validators.get(fieldName);
        if (validator == null) {
            throw new ValidationException();
        }
        validator.validate(fieldName, value);
    }
}
