package lab.library.control;

import lab.library.entity.*;

public class LibraryManagementSystem {

    public static void main(String[] args) {
        Library library = new Library("�߾� ������");

        addSampleBooks(library);

        System.out.println();
        System.out.println(library);

        testFindBook(library);
        testCheckOut(library);
        testReturn(library);
        displayAvailableBooks(library);
    }

    private static void addSampleBooks(Library library) {
        library.addBook(new Book("�ڹ� ���α׷���", "���ڹ�", "978-89-01-12345-6", 2022));
        library.addBook(new Book("��ü������ ��ǰ� ����", "����ȣ", "978-89-01-67890-1", 2015));
        library.addBook(new Book("Clean Code", "Robert C. Martin", "978-0-13-235088-4", 2008));
        library.addBook(new Book("Effective Java", "Joshua Bloch", "978-0-13-468599-1", 2018));
        library.addBook(new Book("Head First Java", "Kathy Sierra", "978-0-596-00920-5", 2005));
        library.addBook(new Book("�ڹ��� ����", "���ü�", "978-89-01-14077-4", 2019));
    }

    private static void testFindBook(Library library) {
        System.out.println("\n===== ���� �˻� �׽�Ʈ =====");

        System.out.println("�������� �˻� ���:");
        Book book = library.findBookByTitle("�ڹ��� ����");
        if (book != null) System.out.println(book);

        System.out.println("\n���ڷ� �˻� ���:");
        for (Book b : library.findBooksByAuthor("Robert C. Martin")) {
            System.out.println(b);
        }
    }

    private static void testCheckOut(Library library) {
        System.out.println("\n===== ���� ���� �׽�Ʈ =====");
        boolean success = library.checkOutBook("978-89-01-14077-4");
        if (success) {
            System.out.println("���� ���� ����!");
            System.out.println("����� ���� ����:");
            System.out.println(library.findBookByISBN("978-89-01-14077-4"));
        } else {
            System.out.println("���� ���� ����: �ش� ������ ã�� �� ���ų� �̹� ���� ���Դϴ�.");
        }
        System.out.println("\n������ ���� ����:");
        System.out.println(library);
    }

    private static void testReturn(Library library) {
        System.out.println("===== ���� �ݳ� �׽�Ʈ =====");
        library.returnBook("978-89-01-14077-4");
        System.out.println("���� �ݳ� ����!");
        System.out.println("�ݳ��� ���� ����:");
        System.out.println(library.findBookByISBN("978-89-01-14077-4"));

        System.out.println("\n������ ���� ����:");
        System.out.println(library);
    }

    private static void displayAvailableBooks(Library library) {
        System.out.println("===== ���� ������ ���� ��� =====");
        for (Book book : library.getAvailableBooks()) {
            System.out.println(book);
            System.out.println("------------------------");
        }
    }
}
