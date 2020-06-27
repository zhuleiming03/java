package jdbc.test;

import jdbc.util.JdbcUtil;

import java.sql.Connection;
import java.sql.Statement;

public class ExecuteBatchTest {

    public static void main(String[] args) {

        try (Connection connection = JdbcUtil.getConnection();
             Statement statement = connection.createStatement();) {

            connection.setAutoCommit(false);

            statement.addBatch("drop table if exists t_customer;");
            statement.addBatch("create table `t_customer` (" +
                    "`id` int not null auto_increment primary key,`name` varchar(10) null,`amount` float null" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;");

            statement.executeBatch();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
