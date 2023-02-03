package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
        if (repo.existsById(dto.getId())) {
            throw new RuntimeException("Customer Already Exist. Please enter another id..!");
        }
        Customer customer =new Customer(dto.getId(),dto.getName(),dto.getAddress(),dto.getSalary());
        repo.save(customer);
        return new ResponseUtil("OK", "Successfully Registered.!", null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO dto) {
        if (!repo.existsById(dto.getId())) {
            throw new RuntimeException("Customer Not Exist. Please enter Valid id..!");
        }
        Customer customer =new Customer(dto.getId(),dto.getName(),dto.getAddress(),dto.getSalary());
        repo.save(customer);
        return new ResponseUtil("OK", "Successfully Updated. :" + dto.getId(), null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @DeleteMapping
    public ResponseUtil deleteCustomer(@RequestBody CustomerDTO dto) { //@ModelAttribute - not Required annotation
        if (!repo.existsById(dto.getId())) {
            throw new RuntimeException("Wrong ID. Please enter Valid id..!");
        }
        Customer customer =new Customer(dto.getId(),dto.getName(),dto.getAddress(),dto.getSalary());
        repo.delete(customer);
        return new ResponseUtil("OK", "Successfully Deleted. :" + dto.getId(), null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/searchCusId",params = {"id"})
    public Customer searchCusId(String id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Wrong ID. Please enter Valid id..!");
        }
        Customer customer = repo.findById(id).get();
        return customer;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/loadAllCustomer")
    public ResponseUtil loadAllCustomer() {
        List<Customer> all = repo.findAll();
        return new ResponseUtil("OK", "Successfully Loaded. :", all);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/CustomerIdGenerate")
    public  @ResponseBody String  CustomerIdGenerate() {
       String cID= arrayList.get(arrayList.size() - 1).getId();
        System.out.println(cID);
        return cID;
    }

}
