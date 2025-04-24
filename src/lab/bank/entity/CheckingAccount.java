package lab.bank.entity;

import lab.bank.exception.WithdrawalLimitExceededException;

public class CheckingAccount extends Account {
    private double withdrawalLimit;

    public CheckingAccount(String accountNumber, String ownerName, double balance, double withdrawalLimit) {
        super(accountNumber, ownerName, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    @Override
    public void withdraw(double amount) throws Exception {
        if (amount > withdrawalLimit) {
            throw new WithdrawalLimitExceededException("��� �ѵ��� �ʰ��߽��ϴ�. �ѵ�: " + withdrawalLimit + "��");
        }
        if (amount > balance) {
            throw new lab.bank.exception.InsufficientBalanceException("�ܾ� ����: " + balance + "��");
        }
        balance -= amount;
        System.out.println(amount + "���� ��ݵǾ����ϴ�. ���� �ܾ�: " + balance + "��");
    }

    @Override
    public String toString() {
        return super.toString() + ", ��� �ѵ�: " + withdrawalLimit + "��";
    }
}
