import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Index {

    public static void main(String[] args) {

        try (Connection connection = JdbcUtil.getConnection();
             Statement statement = connection.createStatement();) {

            // 执行 dml 操作
            String sql = "truncate table t_user;";
            statement.execute(sql);

            // 执行 ddl 操作
            sql = "insert t_user(id,name,balance)value(1,'sean',123.11),(2,'tom',341.12);";
            statement.executeUpdate(sql);

            // 执行 只读 操作
            sql = "select * from t_user where id in (1,2);";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                System.out.println(String.format("id: %s , name: %s , balance: %s ",
                        resultSet.getObject("id"),
                        resultSet.getObject("name"),
                        resultSet.getObject("balance")));
            }

            resultSet.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
