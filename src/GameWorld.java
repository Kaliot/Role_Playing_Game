import java.util.InputMismatchException;
import java.util.Scanner;

public class GameWorld {

    private Player player;
    private Player savedPlayer = null;

    public GameWorld(String name) {
        this.player = new Player(name);
    }

    public boolean beginCombat() { // проведение боя
        Combat combat = new Combat(player);
        combat.start();
        try {
            combat.join(); // ожидание окончания боя
        } catch (InterruptedException e) {
            e.getStackTrace();
        }
        if (player.getHp() <= 0) { // проверка на поражение
            return lostCombat();
        }
        if (player.getExp() >= player.getExpToNextLvl()) { // проверка на получение следующего уровня
            player.levelUp();
            System.out.println(player.getName() + " получил " + player.getLvl() + " уровень");
        }
        return true;
    }

    private boolean lostCombat() { // меню при поражении
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("1. Загрузить игру");
        System.out.println("2. На выход");
        while (true) {
            try {
                choice = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Неверный ввод");
            }
        }
        if (choice == 1) {
            return lostLoadGame();
        }
        return false;
    }

    public void saveGame() { // сохранение игры
        savedPlayer = new Player(player);
        System.out.println("Игра сохранена");
    }

    public void loadGame() { // загрузка игры из главного меню
        if (savedPlayer != null) {
            player = new Player(savedPlayer);
            System.out.println("Игра загружена");
        } else {
            System.out.println("У вас нет сохранения");
        }
    }

    private boolean lostLoadGame() { // загрузка игры при поражении
        if (savedPlayer != null) {
            player = new Player(savedPlayer);
            System.out.println("Игра загружена");
            return true;
        } else {
            System.out.println("У вас нет сохранения");
            System.out.println("Игра завершина");
            return false;
        }
    }

    public void goToTrader() { // меню торговца
        Scanner scanner = new Scanner(System.in);
        int choice;
        boolean isTrade = true;
        while (isTrade) {
            System.out.println("1. Проверить уровень здоровья");
            System.out.println("2. Купить зелье лечения (Здоровье: +50, Золото: -30)");
            System.out.println("3. На выход");
            while (true) {
                try {
                    choice = scanner.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Неверный ввод");
                }
            }
            switch (choice) {
                case 1 -> Trader.checkHp(player);
                case 2 -> Trader.buyHealingPotion(player);
                case 3 -> isTrade = false;
                default -> System.out.println("Повторите выбор");
            }
        }
    }

    public void checkPlayer() { // выводит параметры героя
        System.out.println(
                "Уровень: " + player.getLvl() + '\n' +
                        "Золото: " + player.getGold() + '\n' +
                        "Здоровье: " + player.getHp() + '\n' +
                        "Сила: " + player.getStr() + '\n' +
                        "Ловкость: " + player.getDex() + '\n' +
                        "Опыт: " + player.getExp() + '\n' +
                        "Опыт до следующего уровня: " + (player.getExpToNextLvl() - player.getExp())
        );
    }
}
