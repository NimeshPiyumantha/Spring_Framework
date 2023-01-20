package lk.ijse.springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author : Nimesh Piyumantha
 * @since : 0.1.0
 **/
@Controller
@RequestMapping("/item")
public class ItemController {
    public ItemController(){
        System.out.println("ItemController :Instantiated");
    }
    @GetMapping
    public ModelAndView callMe(){
        return new ModelAndView("/item");
    }
}
