import java.util.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.stream.Collectors;


/**
 * Represents a collection of some movies.
 * <p>
 *      *Дана коллекция фильмов,содержащая информацию об актерах,
        *снимавшихся в главных ролях(один актер мог сниматься и в нескольких фильмах).
        *
        *Необходимо написать приложение,позволяющее при запуске восстанавливать коллекцию фильмов,
        *позволять ее модифицировать,а по завершении работы приложения – сохранять(в файл).
        *
        *Для восстановления/сохранения коллекции использовать сериализацию/десериализацию.
        *
**/

public class MovieCollection implements java.io.Serializable {
    private Set<Movie> myCollection;

    public MovieCollection() {
        myCollection = new HashSet<>();
    }

    public static MovieCollection setFromFile(final String fileName) {
        MovieCollection temp = new MovieCollection();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            temp = (MovieCollection) inputStream.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("File " + fileName + " not found.");
        } catch (IOException e) {
            System.out.println("IO error.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found.");
        }
        return temp;
    }

    public boolean addMovie(final Movie movie) {
        if (movie != null) {
            if (!myCollection.contains(movie)) {
                myCollection.add(movie);
                return true;
            }
        }
        return false;
    }

    public boolean removeMovie(final Movie movie) {
        if (movie != null && myCollection.contains(movie)) {
            myCollection.remove(movie);
            return true;
        }
        return false;
    }

    public boolean writeToFile(final String fileName) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(this);
        } catch (IOException e) {
            System.out.println("There was an error occurred while IO.");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean editMovieTitle(final String editedMovie, final String newTitle) {
        if (!"".equals(editedMovie) && !"".equals(newTitle)) {
            for(Movie temp:myCollection) {
                if(temp.getTitle().equals(editedMovie)) {
                    temp.setTitle(newTitle);
                    return true;
                }
            }
        }
        return false;
    }

    public int getMoviesCount() {
        return myCollection.size();
    }

    public List<String> getTitles() {
        return myCollection.stream().map(entry -> entry.getTitle()).sorted().collect(Collectors.toList());
    }

    public boolean addActorToMovie(final Actor actor, final String movie) {
        if (null != actor && !"".equals(movie)) {
            for (Movie temp : myCollection) {
                if (temp.getTitle().equals(movie)) {
                    temp.addActor(actor);
                    return true;
                }
            }
        }
        return false;
    }

}
