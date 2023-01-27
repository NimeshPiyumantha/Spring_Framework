package lk.ijse.springMVC.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/eight")
public class HController {

    //How many parts are there in an HTTP request.?
    // There are two parts
    //Headers (Meta Data) "Content-Type=application/json"
    //Body (Context)

    //We can narrow down a request using the content type
    // of its body using headers
    //consume = (this method expect content-type header with the request)

//    @GetMapping(consumes = {"application/json"})
    @GetMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public String testOne(){
        return "Method One Invoked";
    }

    @GetMapping(consumes = {MediaType.TEXT_HTML_VALUE})
    public String testTwo(){
        return "Method Two Invoked";
    }
}
