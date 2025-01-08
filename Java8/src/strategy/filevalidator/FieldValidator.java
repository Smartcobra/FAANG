package strategy.filevalidator;

public interface FieldValidator <T> {
    void validate(String fieldName, T value) throws ValidationException;

}
