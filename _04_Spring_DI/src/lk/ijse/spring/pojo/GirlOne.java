package lk.ijse.spring.pojo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @author : Nimesh Piyumantha
 * @since : 0.1.0
 **/
@Component
public class GirlOne implements GoodGirl {
    public GirlOne() {
        System.out.println("Girl One : Instantiated");
    }

    public void chat() {
        System.out.println("Boy Chat with Girl One.");
    }

}
