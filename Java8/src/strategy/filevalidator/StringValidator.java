package strategy.filevalidator;

public class StringValidator implements FieldValidator<String> {
    private final int minLength;
    private final int maxLength;

    public StringValidator(int minLength, int maxLength) {
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    @Override
    public void validate(String fieldName, String value) throws ValidationException {
        if (value == null || value.length() < minLength || value.length() > maxLength) {
            throw new ValidationException();
        }
    }
}
