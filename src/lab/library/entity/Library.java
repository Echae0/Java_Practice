package lab.library.entity;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private String name;
    private List<Book> books;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("도서가 추가되었습니다: " + book.getTitle());
    }

    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) return book;
        }
        return null;
    }

    public List<Book> findBooksByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equals(author)) result.add(book);
        }
        return result;
    }

    public Book findBookByISBN(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) return book;
        }
        return null;
    }

    public boolean checkOutBook(String isbn) {
        Book book = findBookByISBN(isbn);
        if (book != null && book.checkOut()) return true;
        return false;
    }

    public void returnBook(String isbn) {
        Book book = findBookByISBN(isbn);
        if (book != null) book.returnBook();
    }

    public List<Book> getAvailableBooks() {
        List<Book> available = new ArrayList<>();
        for (Book book : books) {
            if (book.isAvailable()) available.add(book);
        }
        return available;
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    public int getTotalBooks() {
        return books.size();
    }

    public int getAvailableBooksCount() {
        return (int) books.stream().filter(Book::isAvailable).count();
    }

    public int getBorrowedBooksCount() {
        return getTotalBooks() - getAvailableBooksCount();
    }

    @Override
    public String toString() {
        return "===== " + name + " =====\n"
            + "전체 도서 수: " + getTotalBooks() + "\n"
            + "대출 가능 도서 수: " + getAvailableBooksCount() + "\n"
            + "대출 중인 도서 수: " + getBorrowedBooksCount() + "\n";
    }
}
