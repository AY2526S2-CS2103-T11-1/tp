package seedu.clinkedin.logic.parser.tag;

import static seedu.clinkedin.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.clinkedin.logic.commands.tag.TagCreateCommand;
import seedu.clinkedin.logic.parser.Parser;
import seedu.clinkedin.logic.parser.ParserUtil;
import seedu.clinkedin.logic.parser.exceptions.ParseException;
import seedu.clinkedin.model.tag.Tag;

public class TagCreateCommandParser implements Parser<TagCreateCommand> {

    public TagCreateCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, TagCreateCommand.MESSAGE_USAGE));
        }

        Tag tag = ParserUtil.parseTag(trimmedArgs);

        return new TagCreateCommand(tag);
    }
}
