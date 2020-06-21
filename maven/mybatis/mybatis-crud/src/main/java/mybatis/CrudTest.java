package mybatis;

import mybatis.mapper.CustomerMapper;
import mybatis.pojo.Customer;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class CrudTest {

    public static void main(String[] args) throws IOException {

        // 根据 mybatis-config.xml 配置的信息得到 sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 然后根据 sqlSessionFactory 得到 session
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {

            CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);

            // 新增对象 修改数据(增删改)需要 commit
            Customer customer = new Customer();
            customer.setName("Janey");
            customer.setAmount(998f);
            customerMapper.insert(customer);
            sqlSession.commit();

            // 查询对象
            customer = customerMapper.select("Janey");
            System.out.println(customer);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
