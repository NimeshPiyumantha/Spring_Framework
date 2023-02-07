package lk.ijse.spring.repo;

import lk.ijse.spring.config.WebRootConfig;
import lk.ijse.spring.entity.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author : Nimesh Piyumantha
 * @since : 0.1.0
 **/
@WebAppConfiguration
@ContextConfiguration(classes = {WebRootConfig.class})
@Transactional
@ExtendWith(SpringExtension.class)
class CustomerRepoTest {

    @Autowired
    CustomerRepo repo;

    @Test
    void findCustomerByName() {
        Customer cus = repo.findCustomerByName("Pasan");
        System.out.println(cus.toString());
    }

    @Test
    void findByName() {
        Customer cus = repo.findByName("Nimesh");
        System.out.println(cus.toString());
    }


    @Test
    void testAllMethods1() {
        Customer cus1 = repo.findCustomerByName("Nimesh");
        Customer cus2 = repo.getCustomerByName("Nimesh");
        Customer cus3 = repo.readCustomerByName("Nimesh");
        Customer cus4 = repo.queryCustomerByName("Nimesh");
        Customer cus5 = repo.streamCustomerByName("Nimesh");
        Customer cus6 = repo.searchCustomerByName("Nimesh");

        System.out.println(cus1.toString());
        System.out.println(cus2.toString());
        System.out.println(cus3.toString());
        System.out.println(cus4.toString());
        System.out.println(cus5.toString());
        System.out.println(cus6.toString());
    }

    @Test
    void testAllMethods2() {
        int cus7 = repo.countCustomerByName("Nimesh");
        boolean cus8 = repo.existsCustomerByName("Nimesh");
        repo.deleteCustomerByName("Nimesh");
//        repo.removeCustomerByName("Nimesh");

        System.out.println(cus7);
        System.out.println(cus8);

    }

    @Test
    void testAllMethods3() {
        Customer c1 = repo.findCustomerByNameAndAddress("Danuka Perera", "Colombo");
        System.out.println(c1.toString());
    }

    @Test
    void queryTest() {
        List<Customer> customers = repo.methodOne();
        for (Customer customer : customers) {
            System.out.println(customer.toString());
        }

    }

    @Test
    void queryTest1() {
        Customer customer = repo.methodTwo();
        System.out.println(customer.toString());

        Customer customer1 = repo.methodThree("C002","Kushan Hansaka");
        System.out.println(customer1.toString());

        Customer customer2 = repo.methodFour("C002","Kushan Hansaka");
        System.out.println(customer2.toString());

    }

    @Test
    void queryTest2() {
        List<Customer> jpql = repo.getCustomerWithJPQL();
        for (Customer c : jpql) {
            System.out.println(c.toString());
        }
        System.out.println("=============");

        List<Customer> hql = repo.getCustomerWithHQL();
        for (Customer c1 : hql) {
            System.out.println(c1.toString());
        }
    }

}