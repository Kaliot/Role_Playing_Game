import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String name;
        boolean isPlaying = true;
        Scanner scanner = new Scanner(System.in);
        int choice;
        System.out.println("����� ���������� � ����");
        System.out.println("������� ��� ������");
        name = scanner.nextLine();
        GameWorld gameWorld = new GameWorld(name);

        while (isPlaying) { // ���� �������� ����
            System.out.println();
            System.out.println("���� �� ������ �����?");
            System.out.println("1. � ��������");
            System.out.println("2. � ����� ���");
            System.out.println("3. ��������� ����");
            System.out.println("4. ��������� ����");
            System.out.println("5. ��������� " + name);
            System.out.println("6. �� �����");
            while (true) {
                try {
                    choice = scanner.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("�������� ����");
                }
            }
            switch (choice) { // ����� ������ ����
                case 1 -> gameWorld.goToTrader();
                case 2 -> isPlaying = gameWorld.beginCombat();
                case 3 -> gameWorld.saveGame();
                case 4 -> gameWorld.loadGame();
                case 5 -> gameWorld.checkPlayer();
                case 6 -> {
                    isPlaying = false;
                    System.out.println("���� ���������");
                }
                default -> System.out.println("��������� �����");
            }
        }
    }
}
