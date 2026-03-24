package seedu.clinkedin.logic.parser;

import static seedu.clinkedin.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.clinkedin.logic.commands.SortComCommand;
import seedu.clinkedin.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new SortComCommand object.
 */
public class SortComCommandParser implements Parser<SortComCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the SortComCommand
     * and returns a SortComCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public SortComCommand parse(String args) throws ParseException {
        if (!args.trim().isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, SortComCommand.MESSAGE_USAGE));
        }

        return new SortComCommand();
    }
}
