package lk.ijse.springMVC.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Nimesh Piyumantha
 * @since : 0.1.0
 **/
@RestController
@RequestMapping("/five")
public class FiveController {

    public FiveController() {
        System.out.println("FiveController :Instantiated");
    }

    //Wild Card Mapping - more characters in one segments
    @GetMapping(path = "/path/*/A/B")
    public String callOne() {
        return "Character Mapping Invoke 1";
    }

    @GetMapping(path = "/*/mypath/A/C")
    public String callTwo() {
        return "Character Mapping Invoke 2";
    }

    //Duel Wild Card Mapping - 0 or more segments
    @GetMapping(path = "/**/mypath/A/C")
    public String callThree() {
        return "Character Mapping Invoke 3";
    }

}
