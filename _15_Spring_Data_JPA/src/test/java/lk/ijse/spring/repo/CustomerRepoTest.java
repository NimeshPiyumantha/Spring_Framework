package lk.ijse.spring.repo;

import lk.ijse.spring.config.WebRootConfig;
import lk.ijse.spring.entity.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : Nimesh Piyumantha
 * @since : 0.1.0
 **/
@WebAppConfiguration
@ContextConfiguration(classes = {WebRootConfig.class})
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
    void findByName(){
        Customer cus = repo.findByName("Nimesh");
        System.out.println(cus.toString());
    }
}