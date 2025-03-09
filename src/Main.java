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