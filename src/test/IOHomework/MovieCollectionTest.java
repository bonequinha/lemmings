import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.io.IOException;

public class MovieCollectionTest {

    private MovieCollection myCollection;
    private Movie movie1, movie2, movie3;
    private Actor actor1, actor2, actor3;
    //private String filename = "src/main/IOHomework/serializedCollection.txt";

    @Before
    public void setUp() throws Exception {
        actor1 = new Actor("Jackie Chan");
        actor2 = new Actor("Natalie Portman");
        actor3 = new Actor("Darth Vader");

        movie1 = new Movie("Great fight", new HashSet<>(Arrays.asList(actor1, actor3)));
        movie2 = new Movie("Love story", new HashSet<> (Arrays.asList(actor1, actor2, actor3)));
        movie3 = new Movie("Some test movie", new HashSet<>());

        myCollection = new MovieCollection();
        myCollection.addMovie(movie1);
        myCollection.addMovie(movie2);
    }

    @Test
    public void setFromFile() throws IOException {
        File file = File.createTempFile("tmp", ".txt");
        myCollection.writeToFile(file.getAbsolutePath());
        MovieCollection temp = MovieCollection.setFromFile(file.getAbsolutePath());
        assertEquals(temp.getMoviesCount(), myCollection.getMoviesCount());
    }

    @Test
    public void addMovie() {
        assertEquals(true, myCollection.addMovie(movie3));
        assertEquals(false, myCollection.addMovie(movie1));
        assertEquals(false, myCollection.addMovie(null));
    }

    @Test
    public void removeMovie() {
        assertEquals(true, myCollection.removeMovie(movie1));
        assertEquals(false, myCollection.removeMovie(movie3));
        assertEquals(false, myCollection.removeMovie(null));
    }

    @Test
    public void writeToFile() {

        assertEquals(true, myCollection.writeToFile("src/main/IOHomework/serializedCollection.txt"));
    }

    @Test
    public void editMovieTitle() {

        assertEquals(true, myCollection.editMovieTitle("Great fight", "New strange things"));
        assertEquals(false, myCollection.editMovieTitle("NOT FOUND", "Some title"));
        assertEquals(false, myCollection.editMovieTitle("",""));
    }

    @Test
    public void getMoviesCount() {
        assertEquals(2, myCollection.getMoviesCount());
    }

    @Test
    public void getTitles() {
        assertArrayEquals(new String[] {"Great fight", "Love story"}, myCollection.getTitles());
    }

    @Test
    public void addActorToMovie() {
        assertEquals(true, myCollection.addActorToMovie(actor2, movie1.getTitle()));
        assertEquals(false, myCollection.addActorToMovie(actor2, movie3.getTitle()));
        assertEquals( false, myCollection.addActorToMovie(null, ""));
    }
}