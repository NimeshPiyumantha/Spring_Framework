package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author : Nimesh Piyumantha
 * @since : 0.1.0
 **/
public interface CustomerRepo extends JpaRepository<Customer, String> {
    @Query(value = "SELECT id FROM Customer ORDER BY id DESC LIMIT 1", nativeQuery = true)
    String getLastIndex();

    @Query(value = "SELECT COUNT(id) FROM Customer", nativeQuery = true)
    int getSumCustomer();

    Customer findByName(String name);

    Customer findCustomerByName(String name);
    Customer readCustomerByName(String name);
    Customer getCustomerByName(String name);
    Customer queryCustomerByName(String name);
    Customer streamCustomerByName(String name);
    Customer searchCustomerByName(String name);

    int countCustomerByName(String name);
    boolean existsCustomerByName(String name);
    void deleteCustomerByName(String name);
    void removeCustomerByName(String name);

    @Query(value = "SELECT * FROM Customer", nativeQuery = true)
    List<Customer> getAllCustomer();

    Customer findCustomerByNameAndAddress(String name,String address);


    //Native SQL
    @Query(value = "select * from Customer",nativeQuery = true)
    List<Customer> methodOne();

    @Query(value = "select * from Customer where id='C001'",nativeQuery = true)
    Customer methodTwo();

    //Positional Params
    //Named Prams

    //Positional Params
    @Query(value = "select * from Customer where id=?1 and name=?2",nativeQuery = true)
    Customer methodThree(String id,String name);
    //1 = id param value
    //2 = name param value


    //Named Params
    @Query(value = "select * from Customer where id=:a and name=:b",nativeQuery = true)
    Customer methodFour(@Param("a") String id, @Param("b") String name);
    //a = id param value
    //b = name param value


    //JPQL
    @Query(value = "select u from Customer u")
    List<Customer> getCustomerWithJPQL();


    //HQL
    @Query(value = "from Customer")
    List<Customer> getCustomerWithHQL();



}