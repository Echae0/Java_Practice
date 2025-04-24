package lab.bank.control;

import lab.bank.entity.*;
import lab.bank.exception.*;

public class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank();

        System.out.println("=== ���� ���� ===");
        Account a1 = bank.createSavingsAccount("ȫ�浿", 10000, 3.0);
        Account a2 = bank.createCheckingAccount("��ö��", 20000, 5000);
        Account a3 = bank.createSavingsAccount("�̿���", 30000, 2.0);

        bank.showAllAccounts();

        System.out.println("\n=== �Ա�/��� �׽�Ʈ ===");
        try {
            a1.deposit(5000);
            a1.withdraw(3000);
        } catch (Exception e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }

        System.out.println("\n=== ���� ���� �׽�Ʈ ===");
        if (a1 instanceof SavingsAccount) {
            ((SavingsAccount) a1).applyInterest();
        }

        System.out.println("\n=== ���� ��ü �׽�Ʈ ===");
        try {
            bank.transfer("AC1002", "AC1001", 5000);
        } catch (Exception e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }

        bank.showAllAccounts();

        System.out.println("\n=== ���� �׽�Ʈ ===");
        try {
            a2.withdraw(6000);
        } catch (Exception e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }

        try {
            bank.findAccount("AC9999");
        } catch (AccountNotFoundException e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }
    }
}
