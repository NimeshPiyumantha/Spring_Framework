package lk.ijse.springMVC.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Nimesh Piyumantha
 * @since : 0.1.0
 **/
@RestController
@RequestMapping("/customer")
public class CustomerController {

    public CustomerController(){
        System.out.println("CustomerController :Instantiated");
    }
    @GetMapping
    public void callMe(){
        System.out.println("Call me method Invoked by the web Browser.");
    }
}
