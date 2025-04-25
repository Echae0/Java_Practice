package lab.book.entity;

public class Magazine extends Publication {
    private String publishPeriod;

    public Magazine(String title, String publishDate, int page, int price, String publishPeriod) {
        super(title, publishDate, page, price);
        this.publishPeriod = publishPeriod;
    }

    public String toString() {
        return getTitle() + " [����] �����ֱ�:" + publishPeriod + ", " + getPage() + "��, " + getPrice() + "��, ������:" + getPublishDate();
    }
}
