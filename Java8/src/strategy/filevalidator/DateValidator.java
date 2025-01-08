package strategy.filevalidator;

import java.util.Date;

public class DateValidator implements FieldValidator<Date> {
    @Override
    public void validate(String fieldName, Date value) throws ValidationException {
        if (value == null) {
            throw new ValidationException();
        }
        if (value.after(new Date())) {
            throw new ValidationException();
        }
    }
}
