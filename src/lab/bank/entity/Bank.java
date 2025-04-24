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
        System.out.println("Saving(저축) 계좌가 생성되었습니다: " + account);
        return account;
    }

    public Account createCheckingAccount(String owner, double balance, double limit) {
        String accountNumber = "AC" + nextAccountNumber++;
        CheckingAccount account = new CheckingAccount(accountNumber, owner, balance, limit);
        accounts.add(account);
        System.out.println("체킹 계좌가 생성되었습니다: " + account);
        return account;
    }

    public Account findAccount(String accountNumber) throws AccountNotFoundException {
        return accounts.stream()
            .filter(acc -> acc.getAccountNumber().equals(accountNumber))
            .findFirst()
            .orElseThrow(() -> new AccountNotFoundException("계좌번호 " + accountNumber + "에 해당하는 계좌를 찾을 수 없습니다."));
    }

    public void transfer(String from, String to, double amount) throws Exception {
        Account src = findAccount(from);
        Account dest = findAccount(to);
        src.withdraw(amount);
        dest.deposit(amount);
        System.out.println(amount + "원이 " + from + "에서 " + to + "로 송금되었습니다.");
    }

    public void showAllAccounts() {
        System.out.println("=== 모든 계좌 목록 ===");
        for (Account acc : accounts) {
            System.out.println(acc);
        }
        System.out.println("===================");
    }
}
