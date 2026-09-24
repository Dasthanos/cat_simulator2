import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CatRepository {
    private final String filePath = "src/cats.json";

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

    public void saveCats(List<Cat> cats){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(filePath)){
            gson.toJson(cats, writer);
        } catch (IOException e){
            System.err.println("Ошибка при сохранении: " + e.getMessage());
        }
    }
}
