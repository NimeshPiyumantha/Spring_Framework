package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

/**
 * @author : Nimesh Piyumantha
 * @since : 0.1.0
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Order {
    private String id;
    private String date;
    private String customerId;
    private List<OrderDetail> orderDetails;

}
