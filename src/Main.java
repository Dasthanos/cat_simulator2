import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CatRepository catRepository = new CatRepository();
        List<Cat> cats = catRepository.getCats();
        cats.sort(Comparator.comparingDouble(Cat::getAverageLevel).reversed());


        printCatTable(cats);

        while (true) {

            break;
        }
    }

    private static void printCatTable(List<Cat> cats) {
        String line = "---+---------+---------+----------+------------+---------+----------------+";

        System.out.println(line);
        System.out.printf("%-3s| %-8s| %-8s| %-9s| %-11s| %-8s| %-15s|\n",
                " # ", "имя", "возраст", "здоровье", "настроение", "сытость", "средний уровень");
        System.out.println(line);

        int index = 1;
        for (Cat cat : cats) {
            System.out.printf("%-3d| %-8s| %-8d| %-9d| %-11d| %-8d| %-15d|\n",
                    index++,
                    cat.getName(),
                    cat.getAge(),
                    cat.getHealth(),
                    cat.getMood(),
                    cat.getSatiety(),
                    cat.getAverageLevel());
        }

        System.out.println(line);
    }
}
