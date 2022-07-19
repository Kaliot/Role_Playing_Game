import java.util.InputMismatchException;
import java.util.Scanner;

public class GameWorld {

    private Player player;
    private Player savedPlayer = null;

    public GameWorld(String name) {
        this.player = new Player(name);
    }

    public boolean beginCombat() { // ���������� ���
        Combat combat = new Combat(player);
        combat.start();
        try {
            combat.join(); // �������� ��������� ���
        } catch (InterruptedException e) {
            e.getStackTrace();
        }
        if (player.getHp() <= 0) { // �������� �� ���������
            return lostCombat();
        }
        if (player.getExp() >= player.getExpToNextLvl()) { // �������� �� ��������� ���������� ������
            player.levelUp();
            System.out.println(player.getName() + " ������� " + player.getLvl() + " �������");
        }
        return true;
    }

    private boolean lostCombat() { // ���� ��� ���������
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("1. ��������� ����");
        System.out.println("2. �� �����");
        while (true) {
            try {
                choice = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("�������� ����");
            }
        }
        if (choice == 1) {
            return lostLoadGame();
        }
        return false;
    }

    public void saveGame() { // ���������� ����
        savedPlayer = new Player(player);
        System.out.println("���� ���������");
    }

    public void loadGame() { // �������� ���� �� �������� ����
        if (savedPlayer != null) {
            player = new Player(savedPlayer);
            System.out.println("���� ���������");
        } else {
            System.out.println("� ��� ��� ����������");
        }
    }

    private boolean lostLoadGame() { // �������� ���� ��� ���������
        if (savedPlayer != null) {
            player = new Player(savedPlayer);
            System.out.println("���� ���������");
            return true;
        } else {
            System.out.println("� ��� ��� ����������");
            System.out.println("���� ���������");
            return false;
        }
    }

    public void goToTrader() { // ���� ��������
        Scanner scanner = new Scanner(System.in);
        int choice;
        boolean isTrade = true;
        while (isTrade) {
            System.out.println("1. ��������� ������� ��������");
            System.out.println("2. ������ ����� ������� (��������: +50, ������: -30)");
            System.out.println("3. �� �����");
            while (true) {
                try {
                    choice = scanner.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("�������� ����");
                }
            }
            switch (choice) {
                case 1 -> Trader.checkHp(player);
                case 2 -> Trader.buyHealingPotion(player);
                case 3 -> isTrade = false;
                default -> System.out.println("��������� �����");
            }
        }
    }

    public void checkPlayer() { // ������� ��������� �����
        System.out.println(
                "�������: " + player.getLvl() + '\n' +
                        "������: " + player.getGold() + '\n' +
                        "��������: " + player.getHp() + '\n' +
                        "����: " + player.getStr() + '\n' +
                        "��������: " + player.getDex() + '\n' +
                        "����: " + player.getExp() + '\n' +
                        "���� �� ���������� ������: " + (player.getExpToNextLvl() - player.getExp())
        );
    }
}
