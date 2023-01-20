package lk.ijse.springMVC.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Nimesh Piyumantha
 * @since : 0.1.0
 **/
@RestController
@RequestMapping("/seven")
public class SevenController {
    public SevenController() {
        System.out.println("SevenController :Instantiated");
    }
    // http request has two parts
    //Header(meta data) {"content-type":"application/json"}
    //body(context)

    @GetMapping(consumes = {"application/json"})
    public String testOne(){
        return "Invoked method One";
    }
    @GetMapping
    public String testTwo(){
        return "Invoked method Two";
    }
}
