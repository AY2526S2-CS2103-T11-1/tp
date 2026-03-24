package seedu.clinkedin.logic.parser;

import static seedu.clinkedin.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.clinkedin.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.clinkedin.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.clinkedin.logic.commands.SortComCommand;

public class SortComCommandParserTest {

    private final SortComCommandParser parser = new SortComCommandParser();

    @Test
    public void parse_emptyArg_success() {
        assertParseSuccess(parser, "", new SortComCommand());
    }

    @Test
    public void parse_whitespaceOnly_success() {
        assertParseSuccess(parser, "   ", new SortComCommand());
    }

    @Test
    public void parse_nonEmptyArg_failure() {
        assertParseFailure(parser, " extra",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, SortComCommand.MESSAGE_USAGE));
    }
}
