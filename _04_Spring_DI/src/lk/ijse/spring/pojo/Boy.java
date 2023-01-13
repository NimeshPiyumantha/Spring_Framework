package lk.ijse.spring.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author : Nimesh Piyumantha
 * @since : 0.1.0
 **/
@Component
public class Boy {
    @Autowired
    @Qualifier("girlOne")
    GoodGirl girl;//property injection

    public Boy() {
        System.out.println("Boy : Instantiated ");
    }

    public void chatWithGirl() {
//        Girl girl = new Girl();
        girl.chat();
    }
}
