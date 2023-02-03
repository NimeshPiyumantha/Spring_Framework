package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.ItemDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.entity.Item;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.repo.ItemRepo;
import lk.ijse.spring.util.ResponseUtil;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
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
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemRepo repo;

    @Autowired
    private ModelMapper mapper;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseUtil saveItem(@ModelAttribute ItemDTO dto) {
        if (repo.existsById(dto.getCode())) {
            throw new RuntimeException("Item Already Exist. Please enter another id..!");
        }
        repo.save(mapper.map(dto, Item.class));
        return new ResponseUtil("OK", "Successfully Registered.!", null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping
    public ResponseUtil updateItem(@RequestBody ItemDTO dto) {
        if (!repo.existsById(dto.getCode())) {
            throw new RuntimeException("Item Not Exist. Please enter Valid id..!");
        }
        repo.save(mapper.map(dto, Item.class));
        return new ResponseUtil("OK", "Successfully Updated. :" + dto.getCode(), null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @DeleteMapping
    public ResponseUtil deleteItem(@RequestBody ItemDTO dto) {
        if (!repo.existsById(dto.getCode())) {
            throw new RuntimeException("Wrong ID..Please enter valid id..!");
        }
        repo.delete(mapper.map(dto, Item.class));
        return new ResponseUtil("OK", "Successfully Deleted. :" + dto.getCode(), null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/searchItemCode", params = {"code"})
    public ItemDTO searchItemCode(String code) {
        if (!repo.existsById(code)) {
            throw new RuntimeException("Wrong ID. Please enter Valid id..!");
        }
        Item item = repo.findById(code).get();
        return mapper.map(item, ItemDTO.class);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/loadAllItem")
    public ResponseUtil loadAllItem() {
        ArrayList <ItemDTO> allList= mapper.map(repo.findAll(),new TypeToken<ArrayList<Item>>(){}.getType());
        return new ResponseUtil("OK", "Successfully Loaded. :",allList);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/ItemIdGenerate")
    public @ResponseBody String ItemIdGenerate() {
        String code =repo.getLastIndex();
        System.out.println(code);
        return code;
    }
}
