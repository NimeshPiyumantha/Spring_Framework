package lk.ijse.spring.controller;

import lk.ijse.spring.dto.ItemDTO;
import lk.ijse.spring.util.ResponseUtil;
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

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseUtil saveItem(@ModelAttribute ItemDTO dto) { //@ModelAttribute - not Required annotation
        if (dto.getCode().equals("I00-001")) {
            throw new RuntimeException("Item Already Exist. Please enter another id..!");
        }
        return new ResponseUtil("OK", "Successfully Registered.!", null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping
    public ResponseUtil getItem() { //@ModelAttribute - not Required annotation
        ArrayList<ItemDTO> arrayList = new ArrayList<>();
        arrayList.add(new ItemDTO("I001", "Lux", 100, 1000));
        arrayList.add(new ItemDTO("I002", "Signal", 200, 2000));
        arrayList.add(new ItemDTO("I003", "Clougard", 300, 3000));
        arrayList.add(new ItemDTO("I004", "Supiriwiki", 400, 4000));
        arrayList.add(new ItemDTO("I005", "Danthalepa", 500, 5000));
        return new ResponseUtil("OK", "Successfully Loaded. :", arrayList);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping
    public ResponseUtil updateItem(@RequestBody ItemDTO dto) { //@ModelAttribute - not Required annotation
        if (dto.getCode().equals("I00-001")) {
            throw new RuntimeException("Wrong ID..No Such a Item to Update..!");
        }
        return new ResponseUtil("OK", "Successfully Updated. :" + dto.getCode(), null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @DeleteMapping
    public ResponseUtil deleteItem(@RequestBody ItemDTO dto) { //@ModelAttribute - not Required annotation
        if (dto.getCode().equals("I00-001")) {
            throw new RuntimeException("Wrong ID..Please enter valid id..!");
        }
        return new ResponseUtil("OK", "Successfully Deleted. :" + dto.getCode(), null);
    }

}
