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

    public Cat(String name, int age, int health, int mood, int satiety) {
        this.name = name;
        this.age = age;
        this.health = health;
        this.mood = mood;
        this.satiety = satiety;
    }
}
