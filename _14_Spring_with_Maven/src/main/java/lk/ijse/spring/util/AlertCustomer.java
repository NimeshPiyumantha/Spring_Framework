package lk.ijse.spring.util;

import lk.ijse.spring.dto.CustomerDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

/**
 * @author : Nimesh Piyumantha
 * @since : 0.1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlertCustomer {
    String state;
    String message;
    ArrayList<CustomerDTO> data;

}
