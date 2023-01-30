package lk.ijse.spring.controller;

import lk.ijse.spring.dto.OrderDTO;
import lk.ijse.spring.dto.OrderDetailDTO;
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
@RequestMapping("/orders")
public class PlaceOrder {

    ArrayList<OrderDTO> arrayList = new ArrayList<>();
    ArrayList<OrderDetailDTO> arrayList2 = new ArrayList<>();

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseUtil saveOrder(@RequestBody OrderDTO dto, @RequestBody OrderDetailDTO dto2) { //@ModelAttribute - not Required annotation

        arrayList.add(dto);
        arrayList2.add(dto2);
        return new ResponseUtil("OK", "Successfully Place Order.!", null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/LoadOrders")
    public ResponseUtil LoadOrders() {
        return new ResponseUtil("OK", "Successfully Loaded. :", arrayList);
    }


    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/LoadOrderDetails")
    public ResponseUtil LoadOrderDetails() {
        return new ResponseUtil("OK", "Successfully Loaded. :", arrayList2);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/OrderIdGenerate")
    public  @ResponseBody String  CustomerIdGenerate() {
        String iCode= arrayList.get(arrayList.size() - 1).getId();
        System.out.println(iCode);
        return iCode;
    }
}
