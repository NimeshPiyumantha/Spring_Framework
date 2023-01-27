package lk.ijse.springMVC.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/four")
public class DController {

    //Character Mapping
    // If you want to narrow down request using path segments
    //you can use character mapping
    //http://localhost:8080/mapping/C1DEF

    //if we have a doubt in exact mapping
    //we can use ? for that character
    @GetMapping(path = "/C?DEF")
    public String testOne(){
        return "Method One Invoked";
    }

    @GetMapping(path = "/C??DEF")
    public String testTwo(){
        return "Method Two Invoked";
    }

}
