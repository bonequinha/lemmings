
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;


public class CharIORW extends ByteIORW {
    /**
     * Search keywords in the file, output them and their count to another file.
     * <p>
     * Прочитайте файл, содержащий код на языке Java. Определите, какие ключевые слова языка Java это код содержит.
     * Выведите эти слова и их количество в другой файл. Используйте только символьные потоки ввода-вывода.
     *
     * @param fileFrom - where to search words
     * @param fileTo - where to past results
     * @exception  FileNotFoundException - specified file does not exist
     * @exception  IOException - something else went wrong
     */
    public static void countWithChars(final String fileFrom, final String fileTo) {
        try (BufferedReader inputReader = new BufferedReader(new FileReader(fileFrom));
             FileWriter outputWriter = new FileWriter(fileTo)) {

            String stringFormFile;
            StringBuilder buffer = new StringBuilder();

            while ((stringFormFile = inputReader.readLine()) != null) {
                buffer.append(stringFormFile);
            }

            Matcher m = getPattern().matcher(buffer);

            String stringFromBuffer;
            int count = 0;

            while (m.find()) {
                stringFromBuffer = buffer.substring(m.start(), m.end()) + " ";
                outputWriter.write(stringFromBuffer);
                count++;
            }

            String words = "Words found: " + count;
            outputWriter.write(words);

        } catch (FileNotFoundException e) {
            System.out.println("File " + fileFrom + " is not found.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("There was an error occurred while IO.");
            e.printStackTrace();
        }
    }
}
