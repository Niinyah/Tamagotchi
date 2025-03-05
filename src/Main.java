import java.util.Random;
import java.util.Scanner;

class Game {
    private Tamagotchi pet;
    private Scanner scanner;

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }

    public Game() {
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.print("Do you want a cat or a dog? ");
        String petType = scanner.nextLine().trim().toLowerCase();
        System.out.print("What is your pet's name? ");
        String name = scanner.nextLine().trim();

        if (petType.equals("cat")) {
            pet = new Cat(name);
        } else if (petType.equals("dog")) {
            pet = new Dog(name);
        } else {
            System.out.println("Invalid choice, try again.");
            start();
            return;
        }

        System.out.println(name + " has been created!");
        gameLoop();
    }

    public void gameLoop() {
        while (true) {
            System.out.print("What would you like to do? (play, feed, sleep, status, quit) ");
            String action = scanner.nextLine().trim().toLowerCase();

            switch (action) {
                case "play":
                    pet.play();
                    break;
                case "feed":
                    pet.feed();
                    break;
                case "sleep":
                    pet.sleep();
                    break;
                case "status":
                    pet.status();
                    break;
                case "quit":
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid action, try again.");
            }
        }
    }
}

abstract class Tamagotchi {
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

    // Getter methods for the constants
    protected int getMinEnergy() { return MIN_ENERGY; }
    protected int getMaxEnergy() { return MAX_ENERGY; }
    protected int getMinFood() { return MIN_FOOD; }
    protected int getMaxFood() { return MAX_FOOD; }

    public abstract void play();

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

class Cat extends Tamagotchi {
    private static final int MIN_ENERGY = 1;
    private int lives;

    public Cat(String name) {
        super(name);
        this.lives = 9;
    }

    @Override
    public void play() {
        if (getEnergy() <= MIN_ENERGY) {
            System.out.println(getName() + " is too tired to play!");
        } else {
            setMood(getMood() + 3);
            setEnergy(getEnergy() - 2);
            System.out.println(getName() + " the cat is playing! Mood increased, but energy dropped.");
        }
    }

    public void meow() {
        System.out.println(getName() + " says: Meow!");
    }
}

class Dog extends Tamagotchi {
    private int loyalty;
    private static final int MIN_ENERGY = 1;

    public Dog(String name) {
        super(name);
        Random rand = new Random();
        this.loyalty = rand.nextInt(10) + 1;
    }

    @Override
    public void play() {
        if (getEnergy() <= MIN_ENERGY) {
            System.out.println(getName() + " is too tired to play!");
        } else {
            setMood(getMood() + 4);
            setEnergy(getEnergy() - 2);
            loyalty += 1;
            System.out.println(getName() + " the dog is playing! Mood and loyalty increased, but energy decreased.");
        }
    }

    public void bark() {
        System.out.println(getName() + " says: Woof woof!");
    }
}