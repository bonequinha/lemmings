import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import static org.junit.Assert.*;

public class CharIORWTest {
    String fileFrom;

    @Before
    public void setUp() throws Exception {
        fileFrom = "src/main/IOHomework/ByteIORW.java";
    }

    @Test
    public void countWithChars() throws Exception {
        final File output = File.createTempFile("output", ".txt");
        final File outputFromOutput = File.createTempFile("outputFromOutput", ".txt");

        CharIORW.countWithChars(fileFrom, output.getAbsolutePath());
        CharIORW.countWithChars(output.getAbsolutePath(), outputFromOutput.getAbsolutePath());

        assertEquals((new BufferedReader(new FileReader(output))).readLine(), (new BufferedReader(new FileReader(outputFromOutput))).readLine());
    }
}