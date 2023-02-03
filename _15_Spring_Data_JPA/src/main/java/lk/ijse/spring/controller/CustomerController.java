package lk.ijse.spring.controller;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.util.ResponseUtil;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
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
    @Autowired
    private ModelMapper mapper;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseUtil saveCustomer(@ModelAttribute CustomerDTO dto) {
        if (repo.existsById(dto.getId())) {
            throw new RuntimeException("Customer Already Exist. Please enter another id..!");
        }
//        Customer map = mapper.map(dto, Customer.class);
//        Customer customer = new Customer(dto.getId(), dto.getName(), dto.getAddress(), dto.getSalary());
        repo.save(mapper.map(dto, Customer.class));
        return new ResponseUtil("OK", "Successfully Registered.!", null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO dto) {
        if (!repo.existsById(dto.getId())) {
            throw new RuntimeException("Customer Not Exist. Please enter Valid id..!");
        }
//        Customer customer = new Customer(dto.getId(), dto.getName(), dto.getAddress(), dto.getSalary());
//        Customer map = mapper.map(dto, Customer.class);
        repo.save(mapper.map(dto, Customer.class));
        return new ResponseUtil("OK", "Successfully Updated. :" + dto.getId(), null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @DeleteMapping
    public ResponseUtil deleteCustomer(@RequestBody CustomerDTO dto) { //@ModelAttribute - not Required annotation
        if (!repo.existsById(dto.getId())) {
            throw new RuntimeException("Wrong ID. Please enter Valid id..!");
        }
//        Customer customer = new Customer(dto.getId(), dto.getName(), dto.getAddress(), dto.getSalary());
//        repo.delete(customer);
        repo.delete(mapper.map(dto, Customer.class));
        return new ResponseUtil("OK", "Successfully Deleted. :" + dto.getId(), null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/searchCusId", params = {"id"})
    public CustomerDTO searchCusId(String id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Wrong ID. Please enter Valid id..!");
        }
        Customer customer = repo.findById(id).get();
        return mapper.map(customer,CustomerDTO.class);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/loadAllCustomer")
    public ResponseUtil loadAllCustomer() {
        ArrayList <CustomerDTO> allList= mapper.map(repo.findAll(),new TypeToken<ArrayList<Customer>>(){}.getType());
        return new ResponseUtil("OK", "Successfully Loaded. :", allList);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/CustomerIdGenerate")
    public @ResponseBody String CustomerIdGenerate() {
        String id =repo.getLastIndex();
        System.out.println(id);
        return id;
    }
}
