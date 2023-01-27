package lk.ijse.springMVC.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/two")
public class BController {

    //Mapping Methods
    //Handler methods
    ///b/c -> path segments
    @GetMapping
    public  String defaultMethod(){
        return "Default Get Method Invoked";
    }
    @GetMapping(path = "/b/c")
    public  String testOne11(){
        return "Get Method Invoked 1";
    }
    @GetMapping(path = "/b/d")
    public  String testOne12(){
        return "Get Method Invoked 1";
    }

    //two/a
    @GetMapping (path = "/a")
    public  String testOne2(){
        return "Get Method Invoked 2";
    }



}
