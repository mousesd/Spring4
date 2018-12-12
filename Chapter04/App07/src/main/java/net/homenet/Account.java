package net.homenet;

@SuppressWarnings("WeakerAccess")
public class Account {
    private String accountNo;
    private Integer balance;

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Account() { }

    public Account(String accountNo, Integer balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }
}
