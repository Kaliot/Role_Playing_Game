public class Combat extends Thread {

    private final Player player;

    public Combat(Player player) {
        this.player = player;
    }

    public void run() {
        Creatures enemy = Math.random() < .5 ? new Goblin() : new Skeleton(); // ���������� ���������� ����������
        int playerDex = player.getDex();
        int enemyDex = enemy.getDex();
        Creatures winner;
        Creatures fighter1;
        Creatures fighter2;
        System.out.println("�� ����� � ����� ���");
        if (playerDex >= enemyDex) { // ����������, ��� ������� ������
            fighter1 = player;
            fighter2 = enemy;
        } else {
            fighter1 = enemy;
            fighter2 = player;
        }
        System.out.println("��� ��������� ������� " + enemy.getName());
        System.out.println("��� �������!");
        while (true) { // ���� ����������� ����� � �������� ������ ��������
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
        System.out.println("��� �������, " + winner.getName() + " �������!");
        if (winner.getClass().getName().equals("Player")) { // ���������, ��� ����� �������
            player.setExp(player.getExp() + enemy.getExp()); // ��������� ����
            player.setGold(player.getGold() + enemy.getGold()); // ��������� ������
            System.out.println("�� ��������!");
            System.out.println(player.getName() + " �������� " + enemy.getExp() + " ����� � " + enemy.getGold() + " ������");
        } else System.out.println("�� ���������!");
    }

    private void attack(Creatures attacker, Creatures defender) { // �������� �����
        int damage;
        if (attacker.getDex() * 3 >= Math.random() * 100) { // �������� �� ������ �����
            if (attacker.getCriticalRate() >= Math.random() * 100) // �������� �� ����������� ����
                damage = attacker.getStr() * 2;
            else damage = attacker.getStr();
            defender.setHp(defender.getHp() - damage); // ������ ���������� ��������
            System.out.println(attacker.getName() + " ������� � ������� " + damage + " �����");
        } else System.out.println(attacker.getName() + " �������, �� �����������");
    }
}
