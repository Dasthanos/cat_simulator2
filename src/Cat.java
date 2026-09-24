import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Cat {
    private String name;
    private int age;
    private int health;
    private int mood;
    private int satiety;

    public int getAverageLevel(){
        return (health+mood+satiety)/3;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setMood(int mood) {
        this.mood = mood;
    }

    public void setSatiety(int satiety) {
        this.satiety = satiety;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getHealth() {
        return health;
    }

    public int getMood() {
        return mood;
    }

    public int getSatiety() {
        return satiety;
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
        Random random = new Random();
        this.health = 20 + random.nextInt(61);
        this.mood = 20 + random.nextInt(61);
        this.satiety = 20 + random.nextInt(61);
    }

    public void addCat(List<Cat> cats, CatRepository repository){
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
}
