package lab.library.entity;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private int publishYear;
    private boolean isAvailable;

    public Book() {
        this.isAvailable = true;
    }

    public Book(String title, String author, String isbn, int publishYear) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publishYear = publishYear;
        this.isAvailable = true;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public int getPublishYear() { return publishYear; }
    public boolean isAvailable() { return isAvailable; }

    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public void setPublishYear(int publishYear) { this.publishYear = publishYear; }
    public void setAvailable(boolean isAvailable) { this.isAvailable = isAvailable; }

    public boolean checkOut() {
        if (isAvailable) {
            isAvailable = false;
            return true;
        }
        return false;
    }

    public void returnBook() {
        isAvailable = true;
    }

    @Override
    public String toString() {
        return "å ����: " + title +
               "\t����: " + author +
               "\tISBN: " + isbn +
               "\t���ǳ⵵: " + publishYear +
               "\t���� ���� ����: " + (isAvailable ? "����" : "���� ��");
    }
}
