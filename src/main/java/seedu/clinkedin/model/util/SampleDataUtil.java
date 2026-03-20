package seedu.clinkedin.model.util;

import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.clinkedin.model.CLinkedin;
import seedu.clinkedin.model.ReadOnlyCLinkedin;
import seedu.clinkedin.model.person.Address;
import seedu.clinkedin.model.person.Company;
import seedu.clinkedin.model.person.DateAdded;
import seedu.clinkedin.model.person.Email;
import seedu.clinkedin.model.person.Link;
import seedu.clinkedin.model.person.Name;
import seedu.clinkedin.model.person.Person;
import seedu.clinkedin.model.person.Phone;
import seedu.clinkedin.model.tag.Tag;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Person[] getSamplePersons() {
        return new Person[] {
            new Person(new Name("Alex Yeoh"), new Phone("87438807"), new Email("alexyeoh@example.com"),
                    new Company("Google"), new Address("Blk 30 Geylang Street 29, #06-40"),
                    Optional.of(new Link("https://www.linkedin.com/in/alexyeoh")),
                    new DateAdded("16-02-2026"),
                    getTagSet("friends")),
            new Person(new Name("Bernice Yu"), new Phone("99272758"), new Email("berniceyu@example.com"),
                    new Company("Shopee"), new Address("Blk 30 Lorong 3 Serangoon Gardens, #07-18"),
                    Optional.of(new Link("https://www.linkedin.com/in/berniceyu")),
                    new DateAdded("25-02-2026"),
                    getTagSet("colleagues", "friends")),
            new Person(new Name("Charlotte Oliveiro"), new Phone("93210283"), new Email("charlotte@example.com"),
                    new Company("Grab"), new Address("Blk 11 Ang Mo Kio Street 74, #11-04"),
                    Optional.of(new Link("https://www.linkedin.com/in/charlotteoliveiro")),
                    new DateAdded("08-03-2026"),
                    getTagSet("neighbours")),
            new Person(new Name("David Li"), new Phone("91031282"), new Email("lidavid@example.com"),
                    new Company("GovTech"), new Address("Blk 436 Serangoon Gardens Street 26, #16-43"),
                    Optional.empty(),
                    new DateAdded("13-03-2026"),
                    getTagSet("family")),
            new Person(new Name("Irfan Ibrahim"), new Phone("92492021"), new Email("irfan@example.com"),
                    new Company("NUS Computing"), new Address("Blk 47 Tampines Street 20, #17-35"),
                    Optional.empty(),
                    new DateAdded("15-03-2026"),
                    getTagSet("classmates")),
            new Person(new Name("Roy Balakrishnan"), new Phone("92624417"), new Email("royb@example.com"),
                    new Company("DBS"), new Address("Blk 45 Aljunied Street 85, #11-31"),
                    Optional.of(new Link("https://www.linkedin.com/in/roybalakrishnan")),
                    new DateAdded("20-03-2026"),
                    getTagSet("colleagues"))
            };
    }

    public static ReadOnlyCLinkedin getSampleAddressBook() {
        CLinkedin sampleAb = new CLinkedin();
        for (Person samplePerson : getSamplePersons()) {
            sampleAb.addPerson(samplePerson);
            for (Tag tag : samplePerson.getTags()) {
                if (!sampleAb.hasTag(tag)) {
                    sampleAb.addTag(tag);
                }
            }
        }
        return sampleAb;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings).map(Tag::new).collect(Collectors.toSet());
    }

}
