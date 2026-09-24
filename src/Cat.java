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

    // Кормить: увеличивает сытость и настроение
    public void feed() {
        int up = getStepUp();
        this.satiety = clamp(this.satiety + up);
        this.mood = clamp(this.mood + up);
    }

    // Лечить: увеличивает здоровье; настроение и сытость уменьшаются
    public void heal() {
        int up = getStepUp();
        int down = getStepDown();
        this.health = clamp(this.health + up);
        this.mood = clamp(this.mood - down);
        this.satiety = clamp(this.satiety - down);
    }

    // Играть: увеличивает настроение и здоровье; сытость уменьшается
    public void play() {
        int up = getStepUp();
        int down = getStepDown();
        this.mood = clamp(this.mood + up);
        this.health = clamp(this.health + up);
        this.satiety = clamp(this.satiety - down);
    }

    // Возвращает шаг увеличения в зависимости от возраста
    private int getStepUp() {
        if (this.age <= 5) return 7;
        if (this.age <= 10) return 5;
        return 4;
    }

    // Возвращает шаг уменьшения в зависимости от возраста
    private int getStepDown() {
        if (this.age <= 5) return 3;
        if (this.age <= 10) return 5;
        return 6;
    }

    // Утилита для удержания значения в рамках [0, 100]
    private int clamp(int value) {
        return Math.max(0, Math.min(100, value));
    }



}
