import cs3500.hw01.publication.Book;
import cs3500.hw01.publication.Person;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * A JUnit test class for the Person class.
 */
public class BookTest {

    private Book Cprimer;
    private Person john;
    @Before
    public void setUp() {
        john = new Person("John", "Doe", 1945);
        Cprimer = new Book("Cprimer", john, 69);
    }

    @Test
    public void testFirst() {
        assertEquals("Cprimer", Cprimer.getTitle());

    }

    @Test
    public void testSecond() {
        assertEquals(69, Cprimer.getPrice(),0);
    }

    @Test
    public void testYearOfBirth() {
        assertEquals(john, Cprimer.getAuthor());
    }

}