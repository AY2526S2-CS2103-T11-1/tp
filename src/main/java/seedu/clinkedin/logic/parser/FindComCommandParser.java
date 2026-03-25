package seedu.clinkedin.logic.parser;

import static seedu.clinkedin.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.Arrays;
import java.util.logging.Logger;

import seedu.clinkedin.commons.core.LogsCenter;
import seedu.clinkedin.logic.commands.FindComCommand;
import seedu.clinkedin.logic.parser.exceptions.ParseException;
import seedu.clinkedin.model.person.CompanyContainsKeywordsPredicate;

/**
 * Parses input arguments and creates a new FindComCommand object
 */
public class FindComCommandParser implements Parser<FindComCommand> {

    private static final Logger logger = LogsCenter.getLogger(FindComCommandParser.class);

    /**
     * Parses the given {@code String} of arguments in the context of the FindComCommand
     * and returns a FindComCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public FindComCommand parse(String args) throws ParseException {
        assert args != null : "FindComCommandParser arguments should not be null";

        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            logger.warning("Invalid findcom command: empty input");
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindComCommand.MESSAGE_USAGE));
        }

        String[] companyNameKeywords = trimmedArgs.split(";");
        companyNameKeywords = Arrays.stream(companyNameKeywords)
                .map(String::trim)
                .filter(keyword -> !keyword.isEmpty())
                .toArray(String[]::new);

        assert companyNameKeywords.length > 0 : "Parsed company keywords should not be empty";
        logger.info("Parsed findcom keywords: " + Arrays.toString(companyNameKeywords));

        return new FindComCommand(new CompanyContainsKeywordsPredicate(Arrays.asList(companyNameKeywords)));
    }
}
