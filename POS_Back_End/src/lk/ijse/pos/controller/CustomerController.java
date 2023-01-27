package lk.ijse.pos.controller;

import lk.ijse.pos.dto.CustomerDTO;
import org.springframework.web.bind.annotation.*;

/**
 * @author : Nimesh Piyumantha
 * @since : 0.1.0
 **/
@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CustomerController {

    @PostMapping
    public  void saveCustomer(CustomerDTO dto){
        System.out.println(dto.toString());
    }
}
