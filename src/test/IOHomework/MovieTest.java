import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class MovieTest {

    private Movie movie1, movie2;
    private String actor1, actor2, actor3;

    @Before
    public void setUp() throws Exception {
        actor1 = "Jackie Chan";
        actor2 = "Natalie Portman";
        actor3 = "Darth Vader";

        movie1 = new Movie("Great fight", new ArrayList<String>(Arrays.asList(actor1, actor3)));
    }

    @Test
    public void getTitle() {
        assertEquals("Great fight", movie1.getTitle());
    }

    @Test
    public void setTitle() {
        movie1.setTitle("Other title");
        assertSame("Other title", movie1.getTitle());
    }

    @Test
    public void addActor() {
        assertEquals(true, movie1.addActor("Some new actor"));
    }

    @Test
    public void removeActor() {
        assertEquals(true, movie1.removeActor("Darth Vader"));
    }
}