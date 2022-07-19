public class Goblin extends Creatures {

    public Goblin() {
        super("√облин", 80, 0, 30, 50, 10, 15);
        this.setGold((int) Math.round(Math.random() * 10 + 10)); // мен€ет количество золота на случайное
    }
}
