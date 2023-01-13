package lk.ijse.spring.pojo;

import org.springframework.stereotype.Component;

/**
 * @author : Nimesh Piyumantha
 * @since : 0.1.0
 **/
@Component
public class Girl implements GoodGirl {
    public Girl() {
        System.out.println("Girl : Instantiated");
    }

    public void chat() {
        System.out.println("Boy Chat with Girl.");
    }

}
