import java.util.ArrayList;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;


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
    private ArrayList<Movie> movies;

    public MovieCollection() {
        movies = new ArrayList<>();
    }
    public boolean setFromFile(final String fileName) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            movies = (ArrayList<Movie>) inputStream.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("File " + fileName + " not found.");
            return false;
        } catch (IOException e) {
            System.out.println("IO error.");
            e.printStackTrace();
            return false;
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found.");
            return false;
        }
        return true;
    }

    public boolean addMovie(final Movie movie) {
        if (!movies.contains(movie)) {
            return movies.add(movie);
        }
        return false;
    }
    public boolean removeMovie(final Movie movie) {
        if (movies.contains(movie)) {
            return movies.remove(movie);
        }
        return false;
    }

    public boolean writeToFile(final String fileName) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(movies);
        } catch (IOException e) {
            System.out.println("There was an error occurred while IO.");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean editMovieTitle(final String editedMovie, final String newTitle) {
        for (Movie movie : movies) {
            if (movie.getTitle().equals(editedMovie)) {
                movie.setTitle(newTitle);
                return true;
            }
        }
        return false;
    }

    public boolean addActor(final String name, final String title) {
        for (Movie movie : movies) {
            if (movie.getTitle().equals(title)) {
                return movie.removeActor(name);
            }
        }
        return false;
    }
    public boolean removeActor(final String name, final String title) {
        for (Movie movie : movies) {
            if (movie.getTitle().equals(title)) {
                return movie.removeActor(name);
            }
        }
        return false;
    }
}
