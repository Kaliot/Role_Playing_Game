public class Skeleton extends Creatures {

    public Skeleton() {
        super("������", 120, 0, 20, 70, 20, 5);
        this.setGold((int) Math.round(Math.random() * 15 + 25)); // ������ ���������� ������ �� ���������
    }
}
