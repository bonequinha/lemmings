import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class MovieTest {

    private Movie movie1;
    private Actor actor1, actor2, actor3;

    @Before
    public void setUp() throws Exception {
        actor1 = new Actor("Jackie Chan");
        actor2 = new Actor("Natalie Portman");
        actor3 = new Actor("Darth Vader");

        movie1 = new Movie("Great fight", new HashSet<>() {{
            add(actor1);
            add(actor2);
        }});
    }

    @Test
    public void getTitle() {
        assertEquals("Great fight", movie1.getTitle());
    }

    @Test
    public void setTitleAccess() {
        assertTrue(movie1.setTitle("Other title"));
        assertSame("Other title", movie1.getTitle());
    }

    @Test
    public void setTitleEmpty() {
        assertFalse(movie1.setTitle(""));
    }

    @Test
    public void addActorSuccess() {
        assertTrue(movie1.addActor(actor3));
    }

    @Test
    public void addActorAlreadyAdded() {
        assertFalse(movie1.addActor(actor1));
    }

    @Test
    public void addActorNull() {
        assertFalse(movie1.addActor(null));
    }

    @Test
    public void removeActorSuccess() {
        assertTrue(movie1.removeActor(actor1));
    }

    @Test
    public void removeActorFail() {
        assertFalse(movie1.removeActor(actor3));
    }

    @Test
    public void removeActorNull() {
        assertFalse(movie1.removeActor(null));
    }

    @Test
    public void getAllActors() {
        HashSet<Actor> temp = new HashSet<>();
        temp.add(actor1);
        temp.add(actor2);
        assertEquals(temp, movie1.getAllActors());
    }
}