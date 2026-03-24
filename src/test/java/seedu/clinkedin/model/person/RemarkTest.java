package seedu.clinkedin.model.person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.clinkedin.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class RemarkTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Remark(null));
    }

    @Test
    public void constructor_invalidRemark_throwsIllegalArgumentException() {
        // empty string
        assertThrows(IllegalArgumentException.class, () -> new Remark(""));

        // too long
        assertThrows(IllegalArgumentException.class, () -> new Remark("a".repeat(201)));
    }

    @Test
    public void constructor_validRemark_success() {
        Remark remark = new Remark("Met during internship");
        assertEquals("Met during internship", remark.value);
    }

    @Test
    public void getRemarkValidationError() {
        // null
        assertEquals(Remark.MESSAGE_NULL,
                Remark.getRemarkValidationError(null));

        // empty
        assertEquals(Remark.MESSAGE_EMPTY,
                Remark.getRemarkValidationError(""));

        // too long
        assertEquals(Remark.MESSAGE_TOO_LONG,
                Remark.getRemarkValidationError("a".repeat(201)));

        // valid
        assertEquals(null,
                Remark.getRemarkValidationError("Hello"));
        assertEquals(null,
                Remark.getRemarkValidationError("Follow up with recruiter"));
    }

    @Test
    public void isValidRemark() {
        // null
        assertThrows(NullPointerException.class, () -> Remark.isValidRemark(null));

        // invalid
        assertFalse(Remark.isValidRemark(""));
        assertFalse(Remark.isValidRemark("a".repeat(201)));

        // valid
        assertTrue(Remark.isValidRemark("Met at career fair"));
        assertTrue(Remark.isValidRemark("Follow up next week"));
    }

    @Test
    public void equals() {
        Remark remark = new Remark("Valid Remark");

        // same values -> true
        assertTrue(remark.equals(new Remark("Valid Remark")));

        // same object -> true
        assertTrue(remark.equals(remark));

        // null -> false
        assertFalse(remark.equals(null));

        // different type -> false
        assertFalse(remark.equals(5));

        // different value -> false
        assertFalse(remark.equals(new Remark("Other Remark")));
    }
}
