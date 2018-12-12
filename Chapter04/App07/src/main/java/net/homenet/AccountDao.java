package net.homenet;

public interface AccountDao {
    int getBalance(String accountNo);
    void setBalance(Account account);
}
