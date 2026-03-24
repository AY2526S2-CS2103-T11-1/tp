package seedu.clinkedin.model.person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.clinkedin.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class CompanyTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Company(null));
    }

    @Test
    public void constructor_invalidCompany_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Company(""));
    }

    @Test
    public void constructor_validCompany_success() {
        Company company = new Company("Google");
        assertEquals("Google", company.companyName);
    }

    @Test
    public void getCompanyNameValidationError() {
        assertEquals(Company.MESSAGE_NULL, Company.getCompanyNameValidationError(null));
        assertEquals(Company.MESSAGE_EMPTY, Company.getCompanyNameValidationError(""));

        assertEquals(Company.MESSAGE_TOO_LONG,
                Company.getCompanyNameValidationError("a".repeat(51)));

        assertEquals(Company.MESSAGE_MULTIPLE_SPACES,
                Company.getCompanyNameValidationError(" Google"));
        assertEquals(Company.MESSAGE_MULTIPLE_SPACES,
                Company.getCompanyNameValidationError("Google "));
        assertEquals(Company.MESSAGE_MULTIPLE_SPACES,
                Company.getCompanyNameValidationError("Google  Singapore"));

        assertEquals(Company.MESSAGE_INVALID_CHARACTERS,
                Company.getCompanyNameValidationError("Google!"));
        assertEquals(Company.MESSAGE_INVALID_CHARACTERS,
                Company.getCompanyNameValidationError("Meta@"));

        assertEquals(null, Company.getCompanyNameValidationError("Google"));
        assertEquals(null, Company.getCompanyNameValidationError("Google Singapore"));
        assertEquals(null, Company.getCompanyNameValidationError("A1 Holdings"));
        assertEquals(null, Company.getCompanyNameValidationError("Procter & Gamble"));
        assertEquals(null, Company.getCompanyNameValidationError("Dell-EMC"));
        assertEquals(null, Company.getCompanyNameValidationError("Company, Inc."));
    }

    @Test
    public void isValidCompanyName() {
        assertThrows(NullPointerException.class, () -> Company.isValidCompanyName(null));

        assertFalse(Company.isValidCompanyName(""));
        assertFalse(Company.isValidCompanyName(" "));
        assertFalse(Company.isValidCompanyName(" Google"));
        assertFalse(Company.isValidCompanyName("Google "));
        assertFalse(Company.isValidCompanyName("Google  Singapore"));
        assertFalse(Company.isValidCompanyName("Google!"));
        assertFalse(Company.isValidCompanyName("Meta@"));
        assertFalse(Company.isValidCompanyName("a".repeat(51)));

        assertTrue(Company.isValidCompanyName("Google"));
        assertTrue(Company.isValidCompanyName("Google Singapore"));
        assertTrue(Company.isValidCompanyName("A1 Holdings"));
        assertTrue(Company.isValidCompanyName("Procter & Gamble"));
        assertTrue(Company.isValidCompanyName("Dell-EMC"));
        assertTrue(Company.isValidCompanyName("Company, Inc."));
    }

    @Test
    public void equals() {
        Company company = new Company("Valid Company");

        assertTrue(company.equals(new Company("Valid Company")));
        assertTrue(company.equals(company));
        assertFalse(company.equals(null));
        assertFalse(company.equals(5.0f));
        assertFalse(company.equals(new Company("Other Valid Company")));
    }
}
