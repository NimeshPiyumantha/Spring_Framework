package lk.ijse.spring.pojo;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author : Nimesh Piyumantha
 * @since : 0.1.0
 **/
@Component
public class Item implements InitializingBean {

    @Value("IJSE")
    private  String name;

    public Item(){
        System.out.println("Item : Instantiated");
//        System.out.println(name);//null still not ready
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(name);
    }
}
