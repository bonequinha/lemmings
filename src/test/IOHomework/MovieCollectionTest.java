import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;

public class MovieCollectionTest {

    private MovieCollection myCollection;
    private Movie movie1, movie2, movie3;
    private String actor1, actor2, actor3;

    @Before
    public void setUp() throws Exception {
        actor1 = "Jackie Chan";
        actor2 = "Natalie Portman";
        actor3 = "Darth Vader";

        movie1 = new Movie("Great fight", new ArrayList<String> (Arrays.asList(actor1, actor3)));
        movie2 = new Movie("Love story", new ArrayList<String> (Arrays.asList(actor1, actor2, actor3)));
        movie3 = new Movie("Some test movie", new ArrayList<>());

        myCollection = new MovieCollection();
        myCollection.addMovie(movie1);
        myCollection.addMovie(movie2);
    }

    @Test
    public void setFromFile() {
        MovieCollection temp = new MovieCollection();
        temp.setFromFile("src/main/IOHomework/serializedCollection.txt");
        assertEquals(1, Arrays.asList(temp).size());
    }

    @Test
    public void addMovie() {
        assertEquals(true, myCollection.addMovie(movie3));
    }

    @Test
    public void removeMovie() {
        assertEquals(true, myCollection.removeMovie(movie1));
    }

    @Test
    public void writeToFile() {
        assertEquals(true, myCollection.writeToFile("src/main/IOHomework/serializedCollection.txt"));
    }

    @Test
    public void editMovieTitle() {

        assertEquals(true, myCollection.editMovieTitle("Great fight", "New strange things"));
    }

    @Test
    public void addActor() {
        assertEquals(true, myCollection.addActor("John Doe", "Great fight"));
    }

    @Test
    public void removeActor() {
        assertEquals(true, myCollection.removeActor("Darth Vader", "Love story"));
    }
}