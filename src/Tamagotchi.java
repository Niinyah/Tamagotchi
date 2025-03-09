import java.util.Random;

class Tamagotchi {
    private String name;
    private int age;
    private int mood;
    private int energy;
    private int food;
    private static final int MAX_ENERGY = 10;
    private static final int MAX_FOOD = 10;
    private static final int MIN_ENERGY = 1;
    private static final int MIN_FOOD = 1;

    public Tamagotchi(String name) {
        this.name = name;
        Random rand = new Random();
        this.age = rand.nextInt(10) + 1;
        this.mood = rand.nextInt(10) + 1;
        this.energy = rand.nextInt(10) + 1;
        this.food = rand.nextInt(10) + 1;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public int getMood() { return mood; }
    public int getEnergy() { return energy; }
    public int getFood() { return food; }

    public void setMood(int mood) { this.mood = Math.max(0, mood); }
    public void setEnergy(int energy) { this.energy = Math.max(getMinEnergy(), Math.min(energy, getMaxEnergy())); }
    public void setFood(int food) { this.food = Math.max(getMinFood(), Math.min(food, getMaxFood())); }


    public int getMinEnergy() { return MIN_ENERGY; }
    public int getMaxEnergy() { return MAX_ENERGY; }
    public int getMinFood() { return MIN_FOOD; }
    public int getMaxFood() { return MAX_FOOD; }

    public void play() {
        if (energy > MIN_ENERGY && food > MIN_FOOD) {
            energy -= 2;
            food -= 1;
            mood += 2;
            System.out.println(name + " played and is feeling happy!");
        } else {
            System.out.println(name + " is too tired or hungry to play.");
        }
    }

    public void feed() {
        if (food >= MAX_FOOD) {
            System.out.println(name + " is already full!");
        } else {
            setFood(food + 3);
            System.out.println(name + " has been fed! Food level increased.");
        }
    }

    public void sleep() {
        if (energy >= MAX_ENERGY) {
            System.out.println(name + " is already fully rested!");
        } else {
            setEnergy(energy + 5);
            setMood(mood + 1);
            System.out.println(name + " is sleeping! Energy and mood increased.");
        }
    }

    public void status() {
        System.out.println(name + " - Age: " + age + ", Mood: " + mood + ", Energy: " + energy + ", Food: " + food);
    }
}