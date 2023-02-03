package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;

/**
 * @author : Nimesh Piyumantha
 * @since : 0.1.0
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderDetail {
    private String orderId;
    private String itemId;
    private int qty;
    private double unitPrice;

}
