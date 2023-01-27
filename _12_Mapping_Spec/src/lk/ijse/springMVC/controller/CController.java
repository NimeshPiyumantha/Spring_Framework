package lk.ijse.springMVC.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/three")
public class CController {

    //http://localhost:8080/mapping/three/id/C002/Uvindu
    //we can access path variables with spring easily
    //{id} -> path variables
    // id/name -> path segments

//    @GetMapping(path = "/id/{C001}/{Dasun}")
//    public  String testOne11(@PathVariable("C001") String id, @PathVariable("Dasun") String name){
//        System.out.println(id+" "+name);
//        return "Get Method Invoked 1";
//    }

    //http://localhost:8080/mapping/three/id/name/dddd
//    @GetMapping(path = "/id/name/{ijse}")
//    public  String testOne22(@PathVariable("ijse") String id){
//        return "Get Method Invoked 2";
//    }


    //furthermore if we want we can validate the path variables as
    // we wanted
    //{id : [a-z]{2}} -> validate with reg ex

    //http://localhost:8080/mapping/three/id/C002/Uvindu //Ok
    //http://localhost:8080/mapping/three/id/CKK2/U38383 // wrong
    @GetMapping(path = "/id/{id:[C]{1}[0-9]{3}}/{name:[A-Z]{4}}") //()
    public  String testOne22(@PathVariable String id,@PathVariable String name){
        return "Get Method 1 Invoked "+id+" "+name;
    }


    @GetMapping(path = "/id/{id:[C]{2}[0-9]{3}}/{name:[a-z]{5}}") //()
    public  String testOne221(@PathVariable String id,@PathVariable String name){
        return "Get Method 2 Invoked "+id+" "+name;
    }





}
