import java.util.ArrayList;
import java.util.Arrays;

/**
 * Represents one movie.
 * <p>
 * Содержит один фильм с названием и списком актёров
 */
public class Movie implements java.io.Serializable {

        private String title;
        private ArrayList<String> actors;

        public Movie(final String title, final ArrayList<String> actors) {
            this.title = title;
            this.actors = actors;
        }
        public String getTitle() {
            return title;
        }
        public void setTitle(String title) {
            this.title = title;
        }

        public boolean addActor(final String actor) {
            if (!Arrays.asList(actors).contains(actor)) {
                return actors.add(actor);
            }
            return false;
        }

        public boolean removeActor(final String actor) {
            if (actors.contains(actor)) {
                return actors.remove(actor);
            }
            return false;
        }
}
