package lab.book.control;

import lab.book.entity.*;

public class ManageBook {
    public static void main(String[] args) {
        Publication[] books = {
            new Magazine("����ũ�μ���Ʈ", "2007-10-01", 328, 9900, "�ſ�"),
            new Magazine("�濵����ǻ��", "2007-10-03", 316, 9000, "�ſ�"),
            new Novel("���߿�", "2007-07-01", 396, 9800, "����������������", "����Ҽ�"),
            new Novel("���ѻ꼺", "2007-04-14", 383, 11000, "����", "���ϼҼ�"),
            new ReferenceBook("�ǿ��������α׷���", "2007-01-14", 496, 25000, "����Ʈ�������"),
            new Novel("�ҳ��̿´�", "2014-05-01", 216, 15000, "�Ѱ�", "����Ҽ�"),
            new Novel("�ۺ������ʴ´�", "2021-09-09", 332, 15120, "�Ѱ�", "����Ҽ�")
        };

        System.out.println("==== ���� ���� ��� ====");
        for (int i = 0; i < books.length; i++) {
            System.out.println((i + 1) + ". " + books[i]);
        }

        Publication target = books[6];
        int originalPrice = target.getPrice();
        modifyPrice(target);
        int newPrice = target.getPrice();
        System.out.println("\n==== ���� ���� ====");
        System.out.println(target.getTitle() + " ���� �� ����: " + originalPrice + "��");
        System.out.println(target.getTitle() + " ���� �� ����: " + newPrice + "��");
        System.out.println("����: " + (originalPrice - newPrice) + "��");

        StatisticAnalyzer analyzer = new StatisticAnalyzer();
        analyzer.printStatistics(books);
    }

    public static void modifyPrice(Publication pub) {
        if (pub instanceof Magazine) {
            pub.setPrice((int)(pub.getPrice() * 0.6));
        } else if (pub instanceof Novel) {
            pub.setPrice((int)(pub.getPrice() * 0.8));
        } else if (pub instanceof ReferenceBook) {
            pub.setPrice((int)(pub.getPrice() * 0.9));
        }
    }
}
