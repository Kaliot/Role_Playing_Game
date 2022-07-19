import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String name;
        boolean isPlaying = true;
        Scanner scanner = new Scanner(System.in);
        int choice;
        System.out.println("Добро пожаловать в игру");
        System.out.println("Введите имя игрока");
        name = scanner.nextLine();
        GameWorld gameWorld = new GameWorld(name);

        while (isPlaying) { // цикл главного меню
            System.out.println();
            System.out.println("Куда вы хотите пойти?");
            System.out.println("1. К торговцу");
            System.out.println("2. В тёмный лес");
            System.out.println("3. Сохранить игру");
            System.out.println("4. Загрузить игру");
            System.out.println("5. Проверить " + name);
            System.out.println("6. На выход");
            while (true) {
                try {
                    choice = scanner.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Неверный ввод");
                }
            }
            switch (choice) { // выбор пункта меню
                case 1 -> gameWorld.goToTrader();
                case 2 -> isPlaying = gameWorld.beginCombat();
                case 3 -> gameWorld.saveGame();
                case 4 -> gameWorld.loadGame();
                case 5 -> gameWorld.checkPlayer();
                case 6 -> {
                    isPlaying = false;
                    System.out.println("Игра завершена");
                }
                default -> System.out.println("Повторите выбор");
            }
        }
    }
}
