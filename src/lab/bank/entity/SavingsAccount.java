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
        System.out.println("���� " + interest + "���� ����Ǿ����ϴ�. ���� �ܾ�: " + balance + "��");
    }

    @Override
    public void withdraw(double amount) throws Exception {
        if (amount > balance) {
            throw new lab.bank.exception.InsufficientBalanceException("�ܾ� ����: " + balance + "��");
        }
        balance -= amount;
        System.out.println(amount + "���� ��ݵǾ����ϴ�. ���� �ܾ�: " + balance + "��");
    }

    @Override
    public String toString() {
        return super.toString() + ", ������: " + interestRate + "%";
    }
}
