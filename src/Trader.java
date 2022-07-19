public class Trader {

    public static void checkHp(Player player) { // проверка уровня здоровья
        System.out.println("Уровень здоровья: " + player.getHp());
    }

    public static void buyHealingPotion(Player player) { // покупка зелья здоровья
        if (player.getGold() >= 30) {
            player.setGold(player.getGold() - 30);
            player.setHp(Math.min(player.getHp() + 50, player.getMaxHp()));
        } else System.out.println("У вас недостаточно золота");
    }
}
