package lk.ijse.spring.controller;

import lk.ijse.spring.util.ResponseUtil;
import lk.ijse.spring.dto.CustomerDTO;
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

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseUtil saveCustomer(@ModelAttribute CustomerDTO dto) { //@ModelAttribute - not Required annotation
        if (dto.getId().equals("C00-001")) {
            throw new RuntimeException("Customer Already Exist. Please enter another id..!");
        }
        return new ResponseUtil("OK", "Successfully Registered.!", null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping
    public ResponseUtil getCustomer() { //@ModelAttribute - not Required annotation
        ArrayList<CustomerDTO> arrayList = new ArrayList<>();
        arrayList.add(new CustomerDTO("C001", "Ushan", "Galle", 1000));
        arrayList.add(new CustomerDTO("C002", "Ashan", "Galle", 2000));
        arrayList.add(new CustomerDTO("C003", "Malshan", "Panadura", 3000));
        arrayList.add(new CustomerDTO("C004", "Kalshan", "Kaluthara", 4000));
        arrayList.add(new CustomerDTO("C005", "Rashan", "Panaudra", 5000));
        return new ResponseUtil("OK", "Successfully Loaded. :", arrayList);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO dto) { //@ModelAttribute - not Required annotation
        if (dto.getId().equals("C00-001")) {
            throw new RuntimeException("Wrong ID..No Such a Customer to Update..!");
        }
        return new ResponseUtil("OK", "Successfully Updated. :" + dto.getId(), null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @DeleteMapping
    public ResponseUtil deleteCustomer(@RequestBody CustomerDTO dto) { //@ModelAttribute - not Required annotation
        if (dto.getId().equals("C00-001")) {
            throw new RuntimeException("Wrong ID..Please enter valid id..!");
        }
        return new ResponseUtil("OK", "Successfully Deleted. :" + dto.getId(), null);
    }

}
