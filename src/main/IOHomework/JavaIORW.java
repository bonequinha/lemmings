import java.util.regex.Pattern;

public class JavaIORW {
    protected static Pattern getPattern() {
        return Pattern.compile("abstract|assert|boolean|break|byte|case|catch|char|class|const|continue|default|"+
                "double|do|else|enum|extends|final|finally|float|for|goto|if|implements|import|instanceof|"+
                "int|interface|long|native|new|package|private|protected|public|return|short|static|strictfp|"+
                "super|switch|synchronized|this|throw|throws|transient|try|void|volatile|while");
    }

}
