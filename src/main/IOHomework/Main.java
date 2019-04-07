import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String fileFrom = "src/main/IOHomework/ByteIORW.java";
        String fileByteTo = "src/main/IOHomework/byteResult.txt";
        String fileCharTo = "src/main.IOHomework/charResult.txt";

        ByteIORW.countWithBytes(fileFrom, fileByteTo);
        CharIORW.countWithChars(fileFrom, fileCharTo);

    }
}