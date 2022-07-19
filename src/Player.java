public class Player extends Creatures {

    private int lvl; // уровень
    private int expToNextLvl; // количество очков опыта до следующего уровня
    private int maxHp; // максимальное количество очков здоровья

    public Player(String name) {
        super(name, 100, 0, 25, 0, 20, 10);
        this.lvl = 1;
        this.expToNextLvl = 100;
        this.maxHp = super.getHp();
    }

    public Player(Player player) { // создание копии героя для сохранения
        super(player.getName(), player.getHp(), player.getGold(), player.getDex(), player.getExp(), player.getStr(), player.getCriticalRate());
        this.lvl = player.getLvl();
        this.expToNextLvl = player.getExpToNextLvl();
        this.maxHp = player.getMaxHp();
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl() {
        this.lvl += 1;
    }

    public int getExpToNextLvl() {
        return expToNextLvl;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public void levelUp() { // получение следующего уровня
        setDex((int) (getDex() * 1.1));
        setStr((int) (getStr() * 1.1));
        setMaxHp((int) (getMaxHp() * 1.1));
        setHp(getMaxHp());
        setCriticalRate((int) (getCriticalRate() * 1.1));
        expToNextLvl = (int) (expToNextLvl * 1.5);
        setLvl();
        setExp(0);
    }
}
