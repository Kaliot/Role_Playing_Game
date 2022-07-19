public class Trader {

    public static void checkHp(Player player) { // �������� ������ ��������
        System.out.println("������� ��������: " + player.getHp());
    }

    public static void buyHealingPotion(Player player) { // ������� ����� ��������
        if (player.getGold() >= 30) {
            player.setGold(player.getGold() - 30);
            player.setHp(Math.min(player.getHp() + 50, player.getMaxHp()));
        } else System.out.println("� ��� ������������ ������");
    }
}
