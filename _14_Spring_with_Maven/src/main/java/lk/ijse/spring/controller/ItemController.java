package lk.ijse.spring.controller;

import lk.ijse.spring.dto.ItemDTO;
import lk.ijse.spring.util.AlertItem;
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
    public AlertItem saveItem(@ModelAttribute ItemDTO dto) { //@ModelAttribute - not Required annotation
        itemDTOS.add(dto);
        System.out.println(dto.toString());
        return new AlertItem("200", "Successfully Add", itemDTOS);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping
    public AlertItem getItem() { //@ModelAttribute - not Required annotation
        System.out.println(itemDTOS);
        return new AlertItem("200", "Successfully Get All", itemDTOS);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping
    public AlertItem updateItem(@RequestBody ItemDTO dto) { //@ModelAttribute - not Required annotation
        itemDTOS.get(0).setCode(dto.getCode());
        System.out.println(dto);
        return new AlertItem("200", "Successfully Update", itemDTOS);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @DeleteMapping
    public AlertItem deleteItem(@RequestBody ItemDTO dto) { //@ModelAttribute - not Required annotation
        itemDTOS.remove(dto);
        System.out.println(dto.toString());
        return new AlertItem("200", "Successfully Delete", itemDTOS);
    }

}
