import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.regex.Matcher;


public class ByteIORW extends JavaIORW {
    /**
     * Search keywords in the file, output them and their count to another file.
     * <p>
     * Прочитайте файл, содержащий код на языке Java. Определите, какие ключевые слова языка Java это код содержит.
     * Выведите эти слова и их количество в другой файл. Используйте только байтовые потоки ввода-вывода.
     *
     * @param fileFrom - where to search words
     * @param fileTo - where to past results
     * @exception  FileNotFoundException - specified file does not exist
     * @exception  IOException - something else went wrong
     */
    public static void countWithBytes(final String fileFrom, final String fileTo) {
        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(fileFrom));
             FileOutputStream outputStream = new FileOutputStream(fileTo)) {

            int bytesFromFile;
            StringBuilder buffer = new StringBuilder();

            while ((bytesFromFile = inputStream.read()) != -1) {
                buffer.append((char) bytesFromFile);
            }

            Matcher m = getPattern().matcher(buffer);

            String stringFromBuffer;
            int count = 0;

            while (m.find()) {
                stringFromBuffer = buffer.substring(m.start(), m.end()) + " ";
                outputStream.write(stringFromBuffer.getBytes());
                count++;
            }

            String words = "Words found: " + count;
            outputStream.write(words.getBytes());

        } catch (FileNotFoundException e) {
            System.out.println("File " + fileFrom + " is not found.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("There was an error occurred while IO.");
            e.printStackTrace();
        }
    }
}

