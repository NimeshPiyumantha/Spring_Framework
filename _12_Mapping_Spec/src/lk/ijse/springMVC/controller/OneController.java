package lk.ijse.springMVC.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @author : Nimesh Piyumantha
 * @since : 0.1.0
 **/
@RestController
@RequestMapping("/one")
public class OneController {

    public OneController(){
        System.out.println("OneController :Instantiated");
    }
    @GetMapping
    public String testOne(){
        return "Get Method Invoked.";
    }

    @PostMapping
    public String testTwo(){
        return "Post Method Invoked.";
    }

    @PutMapping
    public String testThree(){
        return "Put Method Invoked.";
    }

    @DeleteMapping
    public String testFour(){
        return "Delete Method Invoked.";
    }

}
