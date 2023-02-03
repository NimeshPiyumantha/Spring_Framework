package lk.ijse.spring.repo;

import lk.ijse.spring.entity.OrderDetails;
import lk.ijse.spring.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author : Nimesh Piyumantha
 * @since : 0.1.0
 **/
public interface OrderDetailsRepo extends JpaRepository<OrderDetails, String> {
}
