import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ActorTest {
    private Actor actor1;

    @Before
    public void setUp() throws Exception {
        actor1 = new Actor("Jakie Chan");
    }

    @Test
    public void setName() {
        actor1.setName("Changed name");
        assertEquals("Changed name", actor1.getName());
    }

    @Test
    public void getName() {
        assertEquals("Jakie Chan", actor1.getName());
    }
}