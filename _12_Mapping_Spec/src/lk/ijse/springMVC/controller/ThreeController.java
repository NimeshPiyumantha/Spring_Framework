package lk.ijse.springMVC.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Nimesh Piyumantha
 * @since : 0.1.0
 **/
@RestController
@RequestMapping("/three")
public class ThreeController {

    public ThreeController(){
        System.out.println("ThreeController :Instantiated");
    }
    @GetMapping(path = "/id/{id:[C]{1}[0-9]{3}}/{name:[A-Z]{4}}")
    public String testOne(@PathVariable String id,@PathVariable String name) {
        System.out.println(id +" "+ name);
        return "Get Method Invoked in Path.";
    }

    @GetMapping(path = "/id/{id:[C]{1}[0-9]{4}}/{name:[A-Z]{5}}")
    public String testTwo(@PathVariable String id,@PathVariable String name) {
        System.out.println(id +" "+ name);
        return "Get Method Invoked in Path Two.";
    }


}
