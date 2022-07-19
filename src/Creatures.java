abstract public class Creatures {

    private final String name;
    private int hp; // здоровье
    private int gold; // золото
    private int dex; // ловкость
    private int exp; // опыт
    private int str; // сила
    private int criticalRate; // шанс критического урона


    public Creatures(String name, int hp, int gold, int dex, int exp, int str, int criticalRate) {
        this.name = name;
        this.hp = hp;
        this.gold = gold;
        this.dex = dex;
        this.exp = exp;
        this.str = str;
        this.criticalRate = criticalRate;
    }

    public String getName() {
        return name;
    }


    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getDex() {
        return dex;
    }

    public void setDex(int dex) {
        this.dex = dex;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getStr() {
        return str;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public int getCriticalRate() {
        return criticalRate;
    }

    public void setCriticalRate(int criticalRate) {
        this.criticalRate = criticalRate;
    }
}
