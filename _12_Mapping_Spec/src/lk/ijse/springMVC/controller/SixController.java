package lk.ijse.springMVC.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author : Nimesh Piyumantha
 * @since : 0.1.0
 **/
@RestController
@RequestMapping("/six")
public class SixController {
    public SixController() {
        System.out.println("SixController :Instantiated");
    }

    @GetMapping(params = {"id","name"})
    public String testOne(@RequestParam String id,@RequestParam String name){
        return "Invoked Method One. " +id +" "+name;
    }

    /*@GetMapping(params = {"id","name","salary"})
    public String testTwo(HttpServletRequest request){
        String id = request.getParameter("id");
        System.out.println(id);
        return "Invoked Method Two.";
    }*/

    @GetMapping(params = {"id","name","salary"})
//    @RequestParam - not an required annotation
//    public String testTwo(@RequestParam String id,@RequestParam String name,@RequestParam String salary){
        public String testTwo(String id,String name,String salary){
        return "Invoked Method Two. "+id +" "+name+ " "+salary;
    }

}
