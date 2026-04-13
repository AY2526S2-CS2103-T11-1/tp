package seedu.clinkedin.logic.parser;

import static seedu.clinkedin.logic.Messages.MESSAGE_FIND_REPEATED_NAMES;
import static seedu.clinkedin.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.Arrays;

import seedu.clinkedin.logic.commands.FindCommand;
import seedu.clinkedin.logic.parser.exceptions.ParseException;
import seedu.clinkedin.model.person.NameContainsKeywordsPredicate;

/**
 * Parses input arguments and creates a new FindCommand object
 */
public class FindCommandParser implements Parser<FindCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the FindCommand
     * and returns a FindCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public FindCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindCommand.MESSAGE_USAGE));
        }

        String[] nameKeywords = trimmedArgs.split(";");
        for (String keywords : nameKeywords) {
            if (keywords.trim().isEmpty()) {
                throw new ParseException(
                        String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindCommand.MESSAGE_USAGE));
            }
        }

        nameKeywords = Arrays.stream(nameKeywords).map(x -> x.trim()).toArray(String[]::new);

        long distinct = Arrays.stream(nameKeywords).map(String::toLowerCase).distinct().count();
        if (distinct != nameKeywords.length) {
            throw new ParseException(MESSAGE_FIND_REPEATED_NAMES);
        }

        return new FindCommand(new NameContainsKeywordsPredicate(Arrays.asList(nameKeywords)));
    }

}
