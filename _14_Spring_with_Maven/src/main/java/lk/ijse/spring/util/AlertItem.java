package lk.ijse.spring.util;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.ItemDTO;
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
public class AlertItem {
    String state;
    String message;
    ArrayList<ItemDTO> data;

}
