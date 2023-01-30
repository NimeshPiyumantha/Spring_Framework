package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
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

    ArrayList<ItemDTO> arrayList = new ArrayList<>();

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseUtil saveItem(@ModelAttribute ItemDTO dto) { //@ModelAttribute - not Required annotation
        if (dto.getCode().equals("I00-001")) {
            throw new RuntimeException("Item Already Exist. Please enter another id..!");
        }
        for (ItemDTO itemDTO : arrayList) {
            if (itemDTO.getCode().equals(dto.getCode())) {
                throw new RuntimeException("Item Already Exist. Please enter another id..!");
            }
        }
        arrayList.add(dto);
        return new ResponseUtil("OK", "Successfully Registered.!", null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping
    public ResponseUtil updateItem(@RequestBody ItemDTO dto) { //@ModelAttribute - not Required annotation
        if (dto.getCode().equals("I00-001")) {
            throw new RuntimeException("Wrong ID..No Such a Item to Update..!");
        }
        for (ItemDTO itemDTO : arrayList) {
            if (itemDTO.getCode().equals(dto.getCode())) {
                itemDTO.setDescription(dto.getDescription());
                itemDTO.setQty(dto.getQty());
                itemDTO.setUnitPrice(dto.getUnitPrice());
            }
        }
        return new ResponseUtil("OK", "Successfully Updated. :" + dto.getCode(), null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @DeleteMapping
    public ResponseUtil deleteItem(@RequestBody ItemDTO dto) { //@ModelAttribute - not Required annotation
        if (dto.getCode().equals("I00-001")) {
            throw new RuntimeException("Wrong ID..Please enter valid id..!");
        }
        for(int i = 0 ; i < arrayList.size() ; i++){
            if(dto.getCode().equalsIgnoreCase(arrayList.get(i).getCode())){
                arrayList.remove(i);
            }
        }
        return new ResponseUtil("OK", "Successfully Deleted. :" + dto.getCode(), null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/searchItemCode",params = {"code"})
    public ItemDTO searchItemCode(String code) {
        for (ItemDTO itemDTO : arrayList) {
            if (itemDTO.getCode().equals(code)) {
                return itemDTO;
            }
        }
        return null;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/loadAllItem")
    public ResponseUtil loadAllItem() {
        arrayList.add(new ItemDTO("I001","Lux",100,1000));
        arrayList.add(new ItemDTO("I002","Signal",200,2000));
        arrayList.add(new ItemDTO("I003","Clougard",300,3000));
        arrayList.add(new ItemDTO("I004","Supiriwiki",400,4000));
        arrayList.add(new ItemDTO("I005","Danthalepa",500,5000));
        return new ResponseUtil("OK", "Successfully Loaded. :", arrayList);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/ItemIdGenerate")
    public  @ResponseBody String  CustomerIdGenerate() {
        String iCode= arrayList.get(arrayList.size() - 1).getCode();
        System.out.println(iCode);
        return iCode;
    }
}
