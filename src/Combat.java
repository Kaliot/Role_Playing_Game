public class Combat extends Thread {

    private final Player player;

    public Combat(Player player) {
        this.player = player;
    }

    public void run() {
        Creatures enemy = Math.random() < .5 ? new Goblin() : new Skeleton(); // генерирует случайного противника
        int playerDex = player.getDex();
        int enemyDex = enemy.getDex();
        Creatures winner;
        Creatures fighter1;
        Creatures fighter2;
        System.out.println("Вы вошли в тёмный лес");
        if (playerDex >= enemyDex) { // определяет, кто отакует первым
            fighter1 = player;
            fighter2 = enemy;
        } else {
            fighter1 = enemy;
            fighter2 = player;
        }
        System.out.println("Вам навстречу выходит " + enemy.getName());
        System.out.println("Бой начался!");
        while (true) { // цикл поочередной атаки и проверки уровня здоровья
            attack(fighter1, fighter2);
            if (fighter2.getHp() <= 0) {
                winner = fighter1;
                break;
            }
            attack(fighter2, fighter1);
            if (fighter1.getHp() <= 0) {
                winner = fighter2;
                break;
            }
        }
        System.out.println("Бой окончен, " + winner.getName() + " победил!");
        if (winner.getClass().getName().equals("Player")) { // проверяет, что игрок победил
            player.setExp(player.getExp() + enemy.getExp()); // добавляет опыт
            player.setGold(player.getGold() + enemy.getGold()); // добавляет золото
            System.out.println("Вы победили!");
            System.out.println(player.getName() + " получает " + enemy.getExp() + " опыта и " + enemy.getGold() + " золота");
        } else System.out.println("Вы проиграли!");
    }

    private void attack(Creatures attacker, Creatures defender) { // проводит атаку
        int damage;
        if (attacker.getDex() * 3 >= Math.random() * 100) { // проверка на промах атаки
            if (attacker.getCriticalRate() >= Math.random() * 100) // проверка на критический урон
                damage = attacker.getStr() * 2;
            else damage = attacker.getStr();
            defender.setHp(defender.getHp() - damage); // меняет количество здоровья
            System.out.println(attacker.getName() + " атакует и наносит " + damage + " урона");
        } else System.out.println(attacker.getName() + " атакует, но промахнулся");
    }
}
