package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
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
@Autowired
private CustomerRepo repo;
    ArrayList<CustomerDTO> arrayList = new ArrayList<>();

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseUtil saveCustomer(@ModelAttribute CustomerDTO dto) { //@ModelAttribute - not Required annotation
        if (dto.getId().equals("C00-001")) {
            throw new RuntimeException("Customer Already Exist. Please enter another id..!");
        }
        for (CustomerDTO customerDTO : arrayList) {
            if (customerDTO.getId().equals(dto.getId())) {
                throw new RuntimeException("Customer Already Exist. Please enter another id..!");
            }
        }
        arrayList.add(dto);
        return new ResponseUtil("OK", "Successfully Registered.!", null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO dto) { //@ModelAttribute - not Required annotation
        if (dto.getId().equals("C00-001")) {
            throw new RuntimeException("Wrong ID..No Such a Customer to Update..!");
        }
        for (CustomerDTO customerDTO : arrayList) {
            if (customerDTO.getId().equals(dto.getId())) {
                customerDTO.setName(dto.getName());
                customerDTO.setAddress(dto.getAddress());
                customerDTO.setSalary(dto.getSalary());
            }
        }
        return new ResponseUtil("OK", "Successfully Updated. :" + dto.getId(), null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @DeleteMapping
    public ResponseUtil deleteCustomer(@RequestBody CustomerDTO dto) { //@ModelAttribute - not Required annotation
        if (dto.getId().equals("C00-001")) {
            throw new RuntimeException("Wrong ID..Please enter valid id..!");
        }
        for(int i = 0 ; i < arrayList.size() ; i++){
            if(dto.getId().equalsIgnoreCase(arrayList.get(i).getId())){
                arrayList.remove(i);
            }
        }
        return new ResponseUtil("OK", "Successfully Deleted. :" + dto.getId(), null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/searchCusId",params = {"id"})
    public CustomerDTO searchCusId(String id) {
        for (CustomerDTO customerDTO : arrayList) {
            if (customerDTO.getId().equals(id)) {
                return customerDTO;
            }
        }
        return null;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/loadAllCustomer")
    public ResponseUtil loadAllCustomer() {

        arrayList.add(new CustomerDTO("C001","Ushan","Galle",1000));
        arrayList.add(new CustomerDTO("C002","Ashan","Galle",2000));
        arrayList.add(new CustomerDTO("C003","Malshan","Panadura",3000));
        arrayList.add(new CustomerDTO("C004","Kalshan","Kaluthara",4000));
        arrayList.add(new CustomerDTO("C005","Rashan","Panaudra",5000));
        return new ResponseUtil("OK", "Successfully Loaded. :", arrayList);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/CustomerIdGenerate")
    public  @ResponseBody String  CustomerIdGenerate() {
       String cID= arrayList.get(arrayList.size() - 1).getId();
        System.out.println(cID);
        return cID;
    }

}
