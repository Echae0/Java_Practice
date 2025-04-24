package lab.bank.control;

import lab.bank.entity.*;
import lab.bank.exception.*;

public class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank();

        System.out.println("=== 계좌 생성 ===");
        Account a1 = bank.createSavingsAccount("홍길동", 10000, 3.0);
        Account a2 = bank.createCheckingAccount("김철수", 20000, 5000);
        Account a3 = bank.createSavingsAccount("이영희", 30000, 2.0);

        bank.showAllAccounts();

        System.out.println("\n=== 입금/출금 테스트 ===");
        try {
            a1.deposit(5000);
            a1.withdraw(3000);
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        System.out.println("\n=== 이자 적용 테스트 ===");
        if (a1 instanceof SavingsAccount) {
            ((SavingsAccount) a1).applyInterest();
        }

        System.out.println("\n=== 계좌 이체 테스트 ===");
        try {
            bank.transfer("AC1002", "AC1001", 5000);
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        bank.showAllAccounts();

        System.out.println("\n=== 예외 테스트 ===");
        try {
            a2.withdraw(6000);
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        try {
            bank.findAccount("AC9999");
        } catch (AccountNotFoundException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }
}
