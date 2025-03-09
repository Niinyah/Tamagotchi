class Cat extends Tamagotchi {
    private int lives;

    public Cat(String name) {
        super(name);
        this.lives = 9;
    }

    @Override
    public void play() {
        if (getEnergy() <= getMinEnergy()) {
            System.out.println(getName() + " is too tired to play!");
        } else {
            setMood(getMood() + 3);
            setEnergy(getEnergy() - 2);
            System.out.println(getName() + " the cat is playing! Mood increased, but energy dropped.");
            meow();
        }
    }

    @Override
    public void feed() {
        super.feed();
        meow();
    }

    @Override
    public void status() {
        super.status();
        if (getMood() > 5) {
            meow();
        }
    }

    public void meow() {
        System.out.println(getName() + " says: Meow!");
    }

    public int getLives() {
        return lives;
    }
}