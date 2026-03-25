package seedu.clinkedin.logic.parser.tag;

import static seedu.clinkedin.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.clinkedin.logic.commands.tag.TagColorCommand;
import seedu.clinkedin.logic.parser.Parser;
import seedu.clinkedin.logic.parser.ParserUtil;
import seedu.clinkedin.logic.parser.exceptions.ParseException;
import seedu.clinkedin.model.tag.Tag;

/**
 * Parses input arguments and creates a new TagColorCommand object
 */
public class TagColorCommandParser implements Parser<TagColorCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the TagColorCommand
     * and returns a TagColorCommand object for execution.
     *
     * @throws ParseException if the user input does not conform to the expected format
     */
    @Override
    public TagColorCommand parse(String args) throws ParseException {
        String trimmed = args.trim();
        String[] parts = trimmed.split("\\s+", 2);

        if (parts.length < 2 || parts[0].isEmpty() || parts[1].isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, TagColorCommand.MESSAGE_USAGE));
        }

        Tag tag = ParserUtil.parseTag(parts[0], parts[1]);

        return new TagColorCommand(tag, parts[1]);
    }
}
