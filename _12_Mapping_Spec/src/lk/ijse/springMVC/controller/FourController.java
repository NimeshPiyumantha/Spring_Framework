package lk.ijse.springMVC.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Nimesh Piyumantha
 * @since : 0.1.0
 **/
@RestController
@RequestMapping("/four")
public class FourController {
    //Character Mapping

    @GetMapping(path = "/C?DEF")
    public String callOne(){
        return "Character Mapping Invoke 1";
    }

    @GetMapping(path = "/C?D?EF")
    public String callTwo(){
        return "Character Mapping Invoke 2";
    }
    public FourController() {
        System.out.println("FourController :Instantiated");
    }

}
