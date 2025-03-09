import java.util.Random;

class Dog extends Tamagotchi {
    private int loyalty;

    public Dog(String name) {
        super(name);
        Random rand = new Random();
        this.loyalty = rand.nextInt(10) + 1;
    }

    @Override
    public void play() {
        if (getEnergy() <= getMinEnergy()) {
            System.out.println(getName() + " is too tired to play!");
        } else {
            setMood(getMood() + 4);
            setEnergy(getEnergy() - 2);
            loyalty += 1;
            System.out.println(getName() + " the dog is playing! Mood and loyalty increased, but energy decreased.");
            bark();
        }
    }

    @Override
    public void feed() {
        super.feed();
        bark();
    }

    @Override
    public void status() {
        super.status();
        if (getMood() > 5) {
            bark();
        }
    }

    public void bark() {
        System.out.println(getName() + " says: Woof woof!");
    }

    public int getLoyalty() {
        return loyalty;
    }
}