package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.util.utilAlert;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public utilAlert saveCustomer(@ModelAttribute CustomerDTO dto) { //@ModelAttribute - not Required annotation
        customerDTOS.add(dto);
        System.out.println(dto.toString());
        return new utilAlert("200","Successfully Add");
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping
    public utilAlert getCustomer() { //@ModelAttribute - not Required annotation
        System.out.println(customerDTOS);
        return new utilAlert("200","Successfully Get All");
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping
    public utilAlert updateCustomer(@RequestBody CustomerDTO dto) { //@ModelAttribute - not Required annotation
        customerDTOS.get(0).setId(dto.getId());
        System.out.println(dto.toString());
        return new utilAlert("200","Successfully Update");
    }

    @ResponseStatus(HttpStatus.CREATED)
    @DeleteMapping
    public utilAlert deleteCustomer(@RequestBody CustomerDTO dto) { //@ModelAttribute - not Required annotation
        customerDTOS.remove(dto);
        System.out.println(dto.toString());
        return new utilAlert("200","Successfully Delete");
    }

}
