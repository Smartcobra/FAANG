package strategy.filevalidator;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {
        ValidationContext context = new ValidationContext();

        // Add validators
        context.addValidator("a", new StringValidator(3, 20));
        context.addValidator("b", new StringValidator(5, 50));
        context.addValidator("c", new StringValidator(1, 100));
        context.addValidator("d", new DateValidator());
        context.addValidator("e", new IntegerValidator(1, 1000));

        try {
            // Test data
            context.validate("a", "Hello");
            context.validate("b", "This is a test string.");
            context.validate("c", "C");
            context.validate("d", new SimpleDateFormat("yyyy-MM-dd").parse("2023-01-01"));
            context.validate("e", 500);

            System.out.println("All validations passed!");

        } catch (ValidationException | ParseException e) {
            System.err.println("Validation failed: " + e.getMessage());
        }
    }
}
