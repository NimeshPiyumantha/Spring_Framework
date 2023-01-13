package lk.ijse.spring.pojo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @author : Nimesh Piyumantha
 * @since : 0.1.0
 **/
@Component
@Primary
public class GirlTwo implements GoodGirl {
    public GirlTwo() {
        System.out.println("Girl Two : Instantiated");
    }

    public void chat() {
        System.out.println("Boy Chat with Girl Two.");
    }

}
