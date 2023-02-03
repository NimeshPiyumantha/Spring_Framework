package lk.ijse.spring.controller;

import lk.ijse.spring.dto.OrderDTO;
import lk.ijse.spring.dto.OrderDetailDTO;
import lk.ijse.spring.entity.Orders;
import lk.ijse.spring.repo.ItemRepo;
import lk.ijse.spring.repo.PlaceOrderRepo;
import lk.ijse.spring.util.ResponseUtil;
import org.modelmapper.ModelMapper;
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
@RequestMapping("/orders")
public class PlaceOrder {

    @Autowired
    private PlaceOrderRepo repo;
    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper mapper;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseUtil placeOrder(@RequestBody OrderDTO dto) {

       /* List<OrderDetailDTO> orderDetails = dto.getOrderDetails();
        arrayList2.addAll(orderDetails);
        arrayList.add(dto);

        System.out.println(arrayList);
        System.out.println(arrayList2);*/
        System.out.println("-------------------");
        System.out.println(dto.toString());
        System.out.println(mapper.map(dto,Orders.class));
        repo.save(mapper.map(dto, Orders.class));

        return new ResponseUtil("OK", "Successfully Place Order.!", dto);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/LoadOrders")
    public ResponseUtil LoadOrders() {
        return new ResponseUtil("OK", "Successfully Loaded. :", null);
    }


    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/LoadOrderDetails")
    public ResponseUtil LoadOrderDetails() {
        return new ResponseUtil("OK", "Successfully Loaded. :", null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/OrderIdGenerate")
    public @ResponseBody String OrderIdGenerate() {
        String orderId =repo.getLastIndex();
        System.out.println(orderId);
        return orderId;
    }
}
