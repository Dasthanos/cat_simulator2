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

    public void feed(){

    }

    public void play(){

    }

    public void heal(){}


}
