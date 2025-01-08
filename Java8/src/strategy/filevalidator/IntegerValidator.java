package strategy.filevalidator;

public class IntegerValidator implements FieldValidator<Integer> {
    private final int minValue;
    private final int maxValue;

    public IntegerValidator(int minValue, int maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    @Override
    public void validate(String fieldName, Integer value) throws ValidationException {
        if (value == null || value < minValue || value > maxValue) {
            throw new ValidationException();
        }
    }
}
