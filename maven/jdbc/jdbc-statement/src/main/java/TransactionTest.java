import util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Random;

public class TransactionTest {

    public static void main(String[] args) {

        account("Sean", "Tom", 100f);
    }

    private static void account(String receive, String pay, Float amount) {
        try (Connection connection = JdbcUtil.getConnection()) {

            // 关闭自动提交 开启事务
            connection.setAutoCommit(false);

            String sql = "update t_customer set amount=amount+? where `name`=?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setFloat(1, amount);
            preparedStatement.setString(2, receive);
            preparedStatement.executeUpdate();

            // 二分之一随机发生异常
            int random = 1 / new Random().nextInt(2);

            sql = "update t_customer set amount=amount-? where `name`=?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setFloat(1, amount);
            preparedStatement.setString(2, pay);
            preparedStatement.executeUpdate();

            connection.commit();
            preparedStatement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
