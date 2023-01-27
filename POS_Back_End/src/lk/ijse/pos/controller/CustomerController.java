package lk.ijse.pos.controller;

import lk.ijse.pos.dto.CustomerDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * @author : Nimesh Piyumantha
 * @since : 0.1.0
 **/
@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CustomerController {

    @PostMapping
    public  void saveCustomer(@ModelAttribute CustomerDTO dto){ //@ModelAttribute - not Required annotation
        System.out.println(dto.toString());
    }


    //converter - request,response ekakdi ena data tika MIME wlata data convert krna eka.
    @PutMapping
    public ArrayList<CustomerDTO> updateCustomer(@RequestBody CustomerDTO dto) { //@RequestBody - Required annotation
        ArrayList<CustomerDTO> customerDTOS= new ArrayList<>();
        customerDTOS.add(dto);
        customerDTOS.add(dto);
        customerDTOS.add(dto);
        customerDTOS.add(dto);
        return customerDTOS;
    }
}
