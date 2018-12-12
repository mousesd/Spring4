package net.homenet;

import org.springframework.dao.DuplicateKeyException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@SuppressWarnings({ "SqlDialectInspection", "SqlNoDataSourceInspection" })
public class JdbcAccountDaoImpl implements AccountDao {
    private final DataSource dataSource;

    public JdbcAccountDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public int getBalance(String accountNo) {
        int balance = 0;
        ResultSet rs = null;
        try (
            Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT BALANCE FROM ACCOUNT WHERE ACCOUNT_NUM = ?")
        ) {
            ps.setString(1, accountNo);
            rs = ps.executeQuery();

            if (rs.next()) {
                balance = rs.getInt("BALANCE");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return balance;
    }

    @Override
    public void setBalance(Account account) {
        try (
            Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("UPDATE ACCOUNT SET BALANCE = ? WHERE ACCOUNT_NUM = ?")
        ) {
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

            ps.setInt(1, account.getBalance());
            ps.setString(2, account.getAccountNo());
            ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
