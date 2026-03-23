package seedu.clinkedin.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TagUtilTest {

    @Test
    public void tagUtil_blueColor_hasRightHex() {
        String blueHex = TagUtil.tagColorToHexString("blue");
        assertEquals("#0000FFFF", blueHex);
    }
}
