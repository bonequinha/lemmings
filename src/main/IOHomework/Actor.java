public class Actor implements java.io.Serializable  {
    private String name;

    public Actor(final String name) {
        this.name = name;
    }

    public void setName(final String newname) {
        this.name = newname;
    }

    public String getName() {
        return name;
    }
}
