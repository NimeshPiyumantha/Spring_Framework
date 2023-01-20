package lk.ijse.springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author : Nimesh Piyumantha
 * @since : 0.1.0
 **/
@Controller
@RequestMapping("/customer")
public class CustomerController {

    public CustomerController(){
        System.out.println("CustomerController :Instantiated");
    }
    @GetMapping
    public ModelAndView callMe(){
        return new ModelAndView("/customer");
    }
}
