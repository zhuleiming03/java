package mybatis.mapper;

import mybatis.pojo.Customer;

public interface CustomerMapper {

    Customer select(String name);

    Integer insert(Customer customer);

    Integer update(Customer customer);

    Integer delete(Integer id);
}
