import java.util.HashSet;
import java.util.Set;

/**
 * Represents one movie.
 * <p>
 * Содержит один фильм с названием и списком актёров
 */
public class Movie implements java.io.Serializable {

    private String title;
    private HashSet<Actor> actors;

    public Movie(final String title, final HashSet<Actor> actors) {
        this.title = title;
        this.actors = actors;
    }

    public String getTitle() {
        return title;
    }

    public boolean setTitle(final String title) {
        if (!"".equals(title)) {
            this.title = title;
            return true;
        }
        return false;
    }

    public boolean addActor(final Actor actor) {
        if (actor != null && !actors.contains(actor)) {
            return actors.add(actor);
        }
        return false;
    }

    public boolean removeActor(final Actor actor) {
        if (actor != null && actors.contains(actor)) {
            return actors.remove(actor);
        }
        return false;
    }

    public Set getAllActors() {
        return actors;
    }
}
