package seedu.clinkedin.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.logging.Logger;

import seedu.clinkedin.commons.core.LogsCenter;
import seedu.clinkedin.commons.util.ToStringBuilder;
import seedu.clinkedin.logic.Messages;
import seedu.clinkedin.model.Model;
import seedu.clinkedin.model.person.CompanyContainsKeywordsPredicate;

/**
 * Finds and lists all persons in address book whose company name contains any of the argument keywords.
 * Keyword matching is case insensitive.
 */
public class FindComCommand extends Command {

    public static final String COMMAND_WORD = "findcom";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all contacts whose company matches "
            + "the specified company name (case-insensitive).\n"
            + "Parameters: COMPANY\n"
            + "Example: " + COMMAND_WORD + " Google";

    private static final Logger logger = LogsCenter.getLogger(FindComCommand.class);

    private final CompanyContainsKeywordsPredicate predicate;

    /**
     * Creates a FindComCommand with the given predicate.
     *
     * @param predicate Predicate used to filter persons by company keywords.
     */
    public FindComCommand(CompanyContainsKeywordsPredicate predicate) {
        assert predicate != null : "Predicate should not be null";
        this.predicate = predicate;
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        logger.info("Executing findcom with keywords: " + predicate.getKeywordsString());

        model.updateFilteredPersonList(predicate);

        assert model.getFilteredPersonList() != null : "Filtered person list should not be null";
        logger.info("findcom matched contacts count: " + model.getFilteredPersonList().size());

        return new CommandResult(
                String.format(Messages.MESSAGE_COMPANIES_LISTED_OVERVIEW, model.getFilteredPersonList().size(),
                        predicate.getKeywordsString()));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof FindComCommand)) {
            return false;
        }

        FindComCommand otherFindCommand = (FindComCommand) other;
        return predicate.equals(otherFindCommand.predicate);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("predicate", predicate)
                .toString();
    }
}
