package lab.bank.entity;

public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountNumber, String ownerName, double balance, double interestRate) {
        super(accountNumber, ownerName, balance);
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        double interest = balance * (interestRate / 100);
        deposit(interest);
        System.out.println("이자 " + interest + "원이 적용되었습니다. 현재 잔액: " + balance + "원");
    }

    @Override
    public void withdraw(double amount) throws Exception {
        if (amount > balance) {
            throw new lab.bank.exception.InsufficientBalanceException("잔액 부족: " + balance + "원");
        }
        balance -= amount;
        System.out.println(amount + "원이 출금되었습니다. 현재 잔액: " + balance + "원");
    }

    @Override
    public String toString() {
        return super.toString() + ", 이자율: " + interestRate + "%";
    }
}
