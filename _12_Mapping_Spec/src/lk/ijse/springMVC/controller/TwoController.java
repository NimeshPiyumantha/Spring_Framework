package lk.ijse.springMVC.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @author : Nimesh Piyumantha
 * @since : 0.1.0
 **/
@RestController
@RequestMapping("/two")
public class TwoController {

    public TwoController(){
        System.out.println("CustomerController :Instantiated");
    }
    @GetMapping
    public String testOne(){
        return "Get Method Invoked.";
    }

    @GetMapping(path = "/a")
    public String testTwo(){
        return "Get Method 2 Invoked.";
    }

    @GetMapping(path = "/b")
    public String testThree(){
        return "Get Method 3 Invoked.";
    }

    @GetMapping(path = "/c")
    public String testFour(){
        return "Get Method 4 Invoked.";
    }
}
