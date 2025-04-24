package lab.bank.entity;

import lab.bank.exception.*;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts;
    private int nextAccountNumber;

    public Bank() {
        accounts = new ArrayList<>();
        nextAccountNumber = 1000;
    }

    public Account createSavingsAccount(String owner, double balance, double interestRate) {
        String accountNumber = "AC" + nextAccountNumber++;
        SavingsAccount account = new SavingsAccount(accountNumber, owner, balance, interestRate);
        accounts.add(account);
        System.out.println("Saving(����) ���°� �����Ǿ����ϴ�: " + account);
        return account;
    }

    public Account createCheckingAccount(String owner, double balance, double limit) {
        String accountNumber = "AC" + nextAccountNumber++;
        CheckingAccount account = new CheckingAccount(accountNumber, owner, balance, limit);
        accounts.add(account);
        System.out.println("üŷ ���°� �����Ǿ����ϴ�: " + account);
        return account;
    }

    public Account findAccount(String accountNumber) throws AccountNotFoundException {
        return accounts.stream()
            .filter(acc -> acc.getAccountNumber().equals(accountNumber))
            .findFirst()
            .orElseThrow(() -> new AccountNotFoundException("���¹�ȣ " + accountNumber + "�� �ش��ϴ� ���¸� ã�� �� �����ϴ�."));
    }

    public void transfer(String from, String to, double amount) throws Exception {
        Account src = findAccount(from);
        Account dest = findAccount(to);
        src.withdraw(amount);
        dest.deposit(amount);
        System.out.println(amount + "���� " + from + "���� " + to + "�� �۱ݵǾ����ϴ�.");
    }

    public void showAllAccounts() {
        System.out.println("=== ��� ���� ��� ===");
        for (Account acc : accounts) {
            System.out.println(acc);
        }
        System.out.println("===================");
    }
}
