package lab.book.control;

import java.text.DecimalFormat;
import java.util.ArrayList;
import lab.book.entity.*;

public class ShoppingCart {
    private ArrayList<Publication> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    // 장바구니에 항목 추가
    public void addItem(Publication item) {
        items.add(item);
        System.out.println("'" + item.getTitle() + "'이(가) 장바구니에 추가되었습니다.");
    }

    // 제목으로 항목 제거
    public boolean removeItem(String title) {
        for (Publication item : items) {
            if (item.getTitle().equals(title)) {
                items.remove(item);
                System.out.println("'" + title + "'이(가) 장바구니에서 제거되었습니다.");
                return true;
            }
        }
        System.out.println("'" + title + "'을(를) 찾을 수 없습니다.");
        return false;
    }

    // 장바구니 목록 출력
    public void displayCart() {
        DecimalFormat df = new DecimalFormat("#,###");
        System.out.println("\n===== 장바구니 목록 =====");
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i));
        }

        int total = calculateTotalPrice();
        int discounted = calculateDiscountedPrice();
        System.out.println("\n총 가격: " + df.format(total) + "원");
        System.out.println("할인 적용 가격: " + df.format(discounted) + "원");
    }

    // 전체 가격 계산
    public int calculateTotalPrice() {
        int total = 0;
        for (Publication item : items) {
            total += item.getPrice();
        }
        return total;
    }

    // 할인 적용 가격 계산
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

    // 타입별 출판물 수량 통계
    public void printStatistics() {
        int novels = 0, magazines = 0, references = 0, etc = 0;
        for (Publication item : items) {
            if (item instanceof Novel) novels++;
            else if (item instanceof Magazine) magazines++;
            else if (item instanceof ReferenceBook) references++;
            else etc++;
        }

        System.out.println("\n===== 장바구니 통계 =====");
        System.out.println("소설: " + novels + "권");
        System.out.println("잡지: " + magazines + "권");
        System.out.println("참고서: " + references + "권");
        System.out.println("기타: " + etc + "권");
    }

    // 테스트용 메인 메서드
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        Publication n1 = new Novel("빠삐용", "2007-07-01", 396, 9800, "베르나르베르베르", "현대소설");
        Publication n2 = new Novel("소년이온다", "2014-05-01", 216, 15000, "한강", "장편소설");
        Publication m1 = new Magazine("마이크로소프트", "2007-10-01", 328, 9900, "매월");
        Publication r1 = new ReferenceBook("실용주의프로그래머", "2007-01-14", 496, 25000, "소프트웨어공학");

        cart.addItem(n1);
        cart.addItem(n2);
        cart.addItem(m1);
        cart.addItem(r1);

        cart.displayCart();
        cart.printStatistics();

        cart.removeItem("빠삐용");

        cart.displayCart();
        cart.printStatistics();
    }
}
