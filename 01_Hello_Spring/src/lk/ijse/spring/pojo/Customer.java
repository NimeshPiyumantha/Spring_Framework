package lk.ijse.spring.pojo;

import org.springframework.stereotype.Component;

@Component("ijse")
public class Customer {
    public Customer(){
        System.out.println("Customer:Instantiated");
    }

    public void getCustomerName(){
        System.out.println("Customer Name is Sunil");
    }
}
