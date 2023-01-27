package lk.ijse.spring.controller;

import lk.ijse.spring.dto.ItemDTO;
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
@RequestMapping("/item")
public class ItemController {

    ArrayList<ItemDTO> itemDTOS = new ArrayList<>();

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public utilAlert saveItem(@ModelAttribute ItemDTO dto) throws Exception { //@ModelAttribute - not Required annotation
        if(dto.getCode().equals("I00-001")){
            throw new Exception("Worng Id......!");
        }
        itemDTOS.add(dto);
        System.out.println(dto.toString());
        return new utilAlert("200", "Successfully Add");
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping
    public utilAlert getItem() { //@ModelAttribute - not Required annotation
        System.out.println(itemDTOS);
        return new utilAlert("200", "Successfully Get All");
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping
    public utilAlert updateItem(@RequestBody ItemDTO dto) throws Exception { //@ModelAttribute - not Required annotation
        if(dto.getCode().equals("I00-001")){
            throw new Exception("Please Enter Valid Id......!");
        }
        itemDTOS.get(0).setCode(dto.getCode());
        System.out.println(dto);
        return new utilAlert("200", "Successfully Update");
    }

    @ResponseStatus(HttpStatus.CREATED)
    @DeleteMapping
    public utilAlert deleteItem(@RequestBody ItemDTO dto) throws Exception { //@ModelAttribute - not Required annotation
        if(dto.getCode().equals("I00-001")){
            throw new Exception("Please Enter Valid Id......!");
        }
        itemDTOS.remove(dto);
        System.out.println(dto.toString());
        return new utilAlert("200", "Successfully Delete");
    }

}
