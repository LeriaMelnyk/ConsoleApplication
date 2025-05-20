import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class BookStorage {
    private static final String FILE_PATH = "books.json";
    private static final Gson gson = new Gson();


    public static void saveBooksToFile(List<Book> books) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(books, writer);
        } catch (IOException e) {
            System.err.println("Помилка запису у файл: " + e.getMessage());
        }
    }

    public static List<Book> loadBooksFromFile() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            try {
                file.createNewFile();
                return new ArrayList<>();
            } catch (IOException e) {
                System.err.println("Не вдалося створити файл: " + e.getMessage());
                return new ArrayList<>();
            }
        }
        try (FileReader reader = new FileReader(String.valueOf(file))) {
            Type listType = new TypeToken<List<Book>>() {
            }.getType();
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            System.err.println("Помилка читання файлу: " + e.getMessage());
            return new ArrayList<>();
        }}



}