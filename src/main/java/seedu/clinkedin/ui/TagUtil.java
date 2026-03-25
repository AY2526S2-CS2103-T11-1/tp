package seedu.clinkedin.ui;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;

/**
 * Utility class for tag-related operations
 */
public class TagUtil {

    /**
     * Returns a Label for tag styled with its color.
     */
    public static Label tagLabel(String tagName, String tagColor) {
        Label tag = new Label(tagName);
        String color = String.format("-fx-background-color: %s;", tagColorToHexString(tagColor));
        tag.setStyle(color);
        return tag;
    }

    // Helper method
    private static String format(double val) {
        String in = Integer.toHexString((int) Math.round(val * 255));
        return in.length() == 1 ? "0" + in : in;
    }

    /**
     * Converts a valid color to a hex string for css styling
     */
    public static String tagColorToHexString(String color) {
        Color value = Color.web(color);
        return "#" + (
                format(value.getRed())
                        + format(value.getGreen())
                        + format(value.getBlue())
                        + format(value.getOpacity()))
                .toUpperCase();
    }
}
