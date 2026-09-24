import javax.imageio.IIOException;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CatRepository catRepository = new CatRepository();
        List<Cat> cats = catRepository.getCats();
        cats.sort(Comparator.comparingDouble(Cat::getAverageLevel).reversed());

        printCatTable(cats);


        while (true) {
            System.out.println("1: покормить");
            System.out.println("2: поиграть");
            System.out.println("3: к ветеринару");
            System.out.println("a: завести нового питомца");
            System.out.print("Выберите действие: ");

            String choice = scanner.nextLine().trim();
            switch (choice){
                case "1":
                case "2":
                case "3":
                    Cat selectedCat = selectedCat(cats, scanner);
                    if(choice.equals("1")){
                        selectedCat.feed();
                        System.out.println("Вы покормили кота " + selectedCat.getName());
                    }
                    else if(choice.equals("2")){
                        selectedCat.play();
                        System.out.println("Вы поиграли с котом " + selectedCat.getName());
                    }
                    else if(choice.equals("3")){
                        selectedCat.heal();
                        System.out.println("Вы отвели кота " + selectedCat.getName() + " к ветеринару");
                    }
                    catRepository.saveCats(cats);
                case "a":
                case "а":
                    addCat(cats, catRepository);
                    break;
                default:
                    System.out.println("Неверная команда, попробуйте снова.");
            }



            break;
        }
    }

    private static Cat selectedCat (List<Cat> cats, Scanner scanner){
        if(cats.isEmpty()){
            System.out.println("Список котов пуст!");
            return null;
        }
        System.out.print("Enter cat number (1-" + cats.size() + ") or name: ");
        String input = scanner.nextLine().trim();

        try {
            int index = Integer.parseInt(input)-1;
            if(index >= 0 && index < cats.size()){
                return cats.get(index);
            } else {
                System.out.println("Кота с таким номером нет!");
                return null;
            }
        } catch (NumberFormatException e){
            for(Cat cat:cats){
                if (cat.getName().equalsIgnoreCase(input)){
                    return cat;
                }
            }
            System.out.println("Кот с именем " + input + " не найден!");
            return null;

        }

    }

    private static void addCat(List<Cat> cats, CatRepository repository){
        System.out.println("Введите имя кота: ");
        Scanner scanner = new Scanner(System.in);
        String catName = scanner.nextLine().trim();
        if(catName.isEmpty()){
            System.out.println("Ошибка: имя не может быть пустым!");
            return;
        }
        System.out.print("Введите возраст кота (1-18): ");
        int age;
        try {
            age = Integer.parseInt(scanner.nextLine().trim());
            if(age<1 || age>18){
                System.out.println("Ошибка: возраст должен быть от 1 до 18!");
                return;
            }
        } catch (NumberFormatException e){
            System.out.println("Ошибка: возраст должен быть числом!");
            return;
        }

        Cat newCat = new Cat(catName, age);
        cats.add(newCat);
        repository.saveCats(cats);
        System.out.println("Кот " + catName + " успешно добавлен!");

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
