package lk.ijse.springMVC.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/one")
public class AController {

    @GetMapping
    public  String testOne1(){
        return "Get Method Invoked";
    }

//    @GetMapping //ambiguous
//    public  String testOne2(){
//        return "Get Method Invoked";
//    }


    @PostMapping
    public  String testTwo(){
        return "Post Method Invoked";
    }


    @PutMapping
    public  String testThree(){
        return "Put Method Invoked";
    }

    @DeleteMapping
    public  String testFour(){
        return "Delete Method Invoked";
    }

}
