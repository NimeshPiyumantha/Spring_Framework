package lk.ijse.springMVC.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seven")
public class GController {

    //http://localhost:8080/mapping/seven?id=C001&name=IJSE
    //Narrow down request with query String Parameters

    //how to use query params for request narrow down
//    @GetMapping(params = {"id","name"})
//    public String testOne(){
//        return "Method One Invoked ";
//    }
//
//    @GetMapping(params = {"address","salary"})
//    public String testTwo(){
//        return "Method Two Invoked ";
//    }

    //How to get the values of query params in Java EE way
//    @GetMapping(params = {"address","salary"})
//    public String testTwo(HttpServletRequest request){
//        String address = request.getParameter("address");
//        return "Method Two Invoked "+address;
//    }

    //How to get values from query params with Spring Way
    @GetMapping(params = {"id","name"})
    public String testOne(@RequestParam("id") String myID, @RequestParam String name){
        return "Method One Invoked "+myID+" "+name;
    }

//    @RequestParam = not an required annotation

    @GetMapping(params = {"address","salary"})
    public String testTwo(String address,String salary){
        return "Method Two Invoked "+address+" "+salary;
    }

}
