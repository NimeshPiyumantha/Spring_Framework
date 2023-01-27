package lk.ijse.spring.controller;

import lk.ijse.spring.util.AlertCustomer;
import lk.ijse.spring.dto.CustomerDTO;
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

    ArrayList<CustomerDTO> customerDTOS = new ArrayList<>();
    @PostMapping
    public AlertCustomer saveCustomer(@ModelAttribute CustomerDTO dto) { //@ModelAttribute - not Required annotation
        customerDTOS.add(dto);
        System.out.println(dto.toString());
        return new AlertCustomer("200","Successfully Add",customerDTOS);
    }

    @GetMapping
    public AlertCustomer getCustomer() { //@ModelAttribute - not Required annotation
        System.out.println(customerDTOS);
        return new AlertCustomer("200","Successfully Get All",customerDTOS);
    }

    @PutMapping
    public AlertCustomer updateCustomer(@RequestBody CustomerDTO dto) { //@ModelAttribute - not Required annotation
        customerDTOS.get(0).setId(dto.getId());
        System.out.println(dto.toString());
        return new AlertCustomer("200","Successfully Update",customerDTOS);
    }

    @DeleteMapping
    public AlertCustomer deleteCustomer(@RequestBody CustomerDTO dto) { //@ModelAttribute - not Required annotation
        customerDTOS.remove(dto);
        System.out.println(dto.toString());
        return new AlertCustomer("200","Successfully Delete",customerDTOS);
    }

}
