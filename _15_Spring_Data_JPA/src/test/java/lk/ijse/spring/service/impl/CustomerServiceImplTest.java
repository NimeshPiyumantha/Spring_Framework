package lk.ijse.spring.service.impl;

import lk.ijse.spring.config.WebRootConfig;
import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : Nimesh Piyumantha
 * @since : 0.1.0
 **/
@WebAppConfiguration//creat the testing context
@ContextConfiguration(classes = {WebRootConfig.class}) // add configuration for that context
@ExtendWith(SpringExtension.class) // integrate junit with Spring
@Transactional
class CustomerServiceImplTest {

    @Autowired
    CustomerService service;
    @Test
    void saveCustomer() {
        //valid data test ok
        CustomerDTO customerDTO = new CustomerDTO("C011","Ramal Wasuka","Galle",1000);
        assertDoesNotThrow(() -> {
            service.saveCustomer(customerDTO);
        });

        //set invalid data if this throws error
        CustomerDTO customerDTO2 = new CustomerDTO("C001","Ramal Wasuka","Galle",1000);
        assertThrows(RuntimeException.class,()->{
            service.saveCustomer(customerDTO2);
        });
    }

    @Test
    void updateCustomer() {
        //in-valid
        assertThrows(RuntimeException.class,()->{
            service.updateCustomer(new CustomerDTO("C700","Kasun","Galle",100));
        });

        //valid
        assertDoesNotThrow(()->{
            service.updateCustomer(new CustomerDTO("C001","Kasun","Galle",100));
        });
    }

    @Test
    void deleteCustomer() {
        //in-valid
        assertThrows(RuntimeException.class,()->{
            service.deleteCustomer(new CustomerDTO("C700","Kasun","Galle",100));
        });

        //valid
        assertDoesNotThrow(()->{
            service.deleteCustomer(new CustomerDTO("C00-001","Kasun","Galle",100));
        });

    }

    @Test
    void loadAllCustomer() {
        ArrayList<CustomerDTO> allCustomers = service.loadAllCustomer();
        assertTrue(allCustomers.size()>0);

    }
}