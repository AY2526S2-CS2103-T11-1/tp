package seedu.clinkedin.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.clinkedin.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's email in the address book.
 * Guarantees: immutable; valid according to {@link #getEmailValidationError(String)}.
 */
public class Email {

    private static final String SPECIAL_CHARACTERS = "+_.-";

    public static final String MESSAGE_CONSTRAINTS =
            "Email must be in a valid format, like local-part@domain, with no spaces.";

    // alphanumeric and special characters
    private static final String ALPHANUMERIC_NO_UNDERSCORE = "[^\\W_]+"; // alphanumeric characters except underscore
    private static final String LOCAL_PART_REGEX = "^" + ALPHANUMERIC_NO_UNDERSCORE + "([" + SPECIAL_CHARACTERS + "]"
            + ALPHANUMERIC_NO_UNDERSCORE + ")*";
    private static final String DOMAIN_PART_REGEX = ALPHANUMERIC_NO_UNDERSCORE
            + "(-" + ALPHANUMERIC_NO_UNDERSCORE + ")*";
    private static final String DOMAIN_LAST_PART_REGEX = "(" + DOMAIN_PART_REGEX + "){2,}$"; // At least two chars
    private static final String DOMAIN_REGEX = "(" + DOMAIN_PART_REGEX + "\\.)*" + DOMAIN_LAST_PART_REGEX;
    public static final String VALIDATION_REGEX = LOCAL_PART_REGEX + "@" + DOMAIN_REGEX;

    public static final String MESSAGE_EMPTY =
            "Email cannot be empty.";

    public static final String MESSAGE_SPACE_NOT_ALLOWED =
            "Email cannot contain spaces.";

    public static final String MESSAGE_INVALID_AT =
            "Email must contain exactly one '@'.";

    public static final String MESSAGE_INVALID_DOMAIN =
            "Email must contain at least one '.' after '@'.";

    public final String value;

    /**
     * Constructs an {@code Email}.
     *
     * @param email A valid email address.
     */
    public Email(String email) {
        requireNonNull(email);
        String error = getEmailValidationError(email);
        checkArgument(error == null, error);
        value = email;
    }

    /**
     * Returns the error message if the email is invalid, otherwise null.
     */
    public static String getEmailValidationError(String test) {
        if (test.isEmpty()) {
            return MESSAGE_EMPTY;
        }

        if (test.contains(" ")) {
            return MESSAGE_SPACE_NOT_ALLOWED;
        }

        long atCount = test.chars().filter(ch -> ch == '@').count();
        if (atCount != 1) {
            return MESSAGE_INVALID_AT;
        }

        int atIndex = test.indexOf('@');
        String domainPart = test.substring(atIndex + 1);

        if (!domainPart.contains(".")) {
            return MESSAGE_INVALID_DOMAIN;
        }

        if (!test.matches(VALIDATION_REGEX)) {
            return MESSAGE_CONSTRAINTS;
        }

        return null;
    }
    /**
     * Returns if a given string is a valid email.
     */
    public static boolean isValidEmail(String test) {
        return getEmailValidationError(test) == null;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Email)) {
            return false;
        }

        Email otherEmail = (Email) other;
        return value.equals(otherEmail.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
