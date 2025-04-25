package lab.book.control;

import java.text.DecimalFormat;
import java.util.ArrayList;
import lab.book.entity.*;

public class ShoppingCart {
    private ArrayList<Publication> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    // ��ٱ��Ͽ� �׸� �߰�
    public void addItem(Publication item) {
        items.add(item);
        System.out.println("'" + item.getTitle() + "'��(��) ��ٱ��Ͽ� �߰��Ǿ����ϴ�.");
    }

    // �������� �׸� ����
    public boolean removeItem(String title) {
        for (Publication item : items) {
            if (item.getTitle().equals(title)) {
                items.remove(item);
                System.out.println("'" + title + "'��(��) ��ٱ��Ͽ��� ���ŵǾ����ϴ�.");
                return true;
            }
        }
        System.out.println("'" + title + "'��(��) ã�� �� �����ϴ�.");
        return false;
    }

    // ��ٱ��� ��� ���
    public void displayCart() {
        DecimalFormat df = new DecimalFormat("#,###");
        System.out.println("\n===== ��ٱ��� ��� =====");
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i));
        }

        int total = calculateTotalPrice();
        int discounted = calculateDiscountedPrice();
        System.out.println("\n�� ����: " + df.format(total) + "��");
        System.out.println("���� ���� ����: " + df.format(discounted) + "��");
    }

    // ��ü ���� ���
    public int calculateTotalPrice() {
        int total = 0;
        for (Publication item : items) {
            total += item.getPrice();
        }
        return total;
    }

    // ���� ���� ���� ���
    public int calculateDiscountedPrice() {
        int total = 0;
        for (Publication item : items) {
            if (item instanceof Magazine) {
                total += item.getPrice() * 0.9;
            } else if (item instanceof Novel) {
                total += item.getPrice() * 0.85;
            } else if (item instanceof ReferenceBook) {
                total += item.getPrice() * 0.8;
            } else {
                total += item.getPrice();
            }
        }
        return total;
    }

    // Ÿ�Ժ� ���ǹ� ���� ���
    public void printStatistics() {
        int novels = 0, magazines = 0, references = 0, etc = 0;
        for (Publication item : items) {
            if (item instanceof Novel) novels++;
            else if (item instanceof Magazine) magazines++;
            else if (item instanceof ReferenceBook) references++;
            else etc++;
        }

        System.out.println("\n===== ��ٱ��� ��� =====");
        System.out.println("�Ҽ�: " + novels + "��");
        System.out.println("����: " + magazines + "��");
        System.out.println("����: " + references + "��");
        System.out.println("��Ÿ: " + etc + "��");
    }

    // �׽�Ʈ�� ���� �޼���
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        Publication n1 = new Novel("���߿�", "2007-07-01", 396, 9800, "����������������", "����Ҽ�");
        Publication n2 = new Novel("�ҳ��̿´�", "2014-05-01", 216, 15000, "�Ѱ�", "����Ҽ�");
        Publication m1 = new Magazine("����ũ�μ���Ʈ", "2007-10-01", 328, 9900, "�ſ�");
        Publication r1 = new ReferenceBook("�ǿ��������α׷���", "2007-01-14", 496, 25000, "����Ʈ�������");

        cart.addItem(n1);
        cart.addItem(n2);
        cart.addItem(m1);
        cart.addItem(r1);

        cart.displayCart();
        cart.printStatistics();

        cart.removeItem("���߿�");

        cart.displayCart();
        cart.printStatistics();
    }
}
