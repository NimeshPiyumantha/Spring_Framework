package lk.ijse.springMVC.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/six")
public class FController {

    //Duel Wild Card Mapping
    //0  or more inside a segment or more segments
    //http://localhost:8080/mapping/six/path//A/B
    //http://localhost:8080/mapping/six/path/aaaaa/A/B
    //http://localhost:8080/mapping/six/path/aaaaa/aaaaa/aaaaa/A/B

    @GetMapping(path = "/path/**/A/B")
    public String testOne(){
        return "Method One Invoked";
    }

    @GetMapping(path = "/**/myPath/A/C")
    public String testTwo(){
        return "Method Two Invoked";
    }

}
