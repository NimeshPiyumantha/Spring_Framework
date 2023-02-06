package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.CustomDTO;
import lk.ijse.spring.dto.OrderDetailsDTO;
import lk.ijse.spring.dto.OrdersDTO;
import lk.ijse.spring.entity.Item;
import lk.ijse.spring.entity.OrderDetails;
import lk.ijse.spring.entity.Orders;
import lk.ijse.spring.repo.ItemRepo;
import lk.ijse.spring.repo.OrderDetailsRepo;
import lk.ijse.spring.repo.PlaceOrderRepo;
import lk.ijse.spring.service.PlaceOrderService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

/**
 * @author : Nimesh Piyumantha
 * @since : 0.1.0
 **/
@Service
@Transactional
public class PlaceOrderServiceImpl implements PlaceOrderService {
    @Autowired
    private PlaceOrderRepo repo;

    @Autowired
    private OrderDetailsRepo orRepo;
    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void placeOrder(OrdersDTO dto) {
        Orders ord = mapper.map(dto, Orders.class);
        if (repo.existsById(ord.getOid())) {
            throw new RuntimeException("Order" + ord.getOid() + " Already added.!");
        }
        repo.save(ord);

        //Update Item Qty
        for (OrderDetails od : ord.getOrderDetails()) {
            Item item = itemRepo.findById(od.getItemCode()).get();
            item.setQty(item.getQty() - od.getQty());
            itemRepo.save(item);
        }
    }

    @Override
    public ArrayList<OrdersDTO> LoadOrders() {
        ArrayList<OrdersDTO> allList = mapper.map(repo.findAll(), new TypeToken<ArrayList<OrdersDTO>>() {
        }.getType());
        System.out.println(allList);
        return allList;
    }

    @Override
    public ArrayList<OrderDetailsDTO> LoadOrderDetails() {
        ArrayList<OrderDetailsDTO> allList2 = mapper.map(orRepo.findAll(), new TypeToken<ArrayList<OrderDetailsDTO>>() {
        }.getType());
        System.out.println(allList2);
        return allList2;
    }

    @Override
    public CustomDTO OrderIdGenerate() {
        CustomDTO customDTO = new CustomDTO(repo.getLastIndex());
        System.out.println(customDTO);
        return customDTO;
    }

    @Override
    public CustomDTO getSumOrders() {
        CustomDTO customDTO = new CustomDTO(repo.getSumOrders());
        System.out.println(customDTO);
        return customDTO;
    }
}
