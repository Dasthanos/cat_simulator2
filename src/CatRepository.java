import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CatRepository {
    private final String filePath = "cats.json";

    List<Cat> getCats() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(filePath)) {
            Cat[] catsArray = gson.fromJson(reader, Cat[].class);
            if (catsArray != null) {
                return new ArrayList<>(Arrays.asList(catsArray));
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
        return new ArrayList<>();
    }
}
