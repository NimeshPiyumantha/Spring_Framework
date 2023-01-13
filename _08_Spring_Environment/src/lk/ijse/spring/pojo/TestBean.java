package lk.ijse.spring.pojo;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class TestBean implements InitializingBean {

    @Autowired
    Environment environment;


    public TestBean(){
        System.out.println("TestBean:Instantiated");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        String property = environment.getProperty("use.email");// if the key is not available it returns null
        System.out.println("Test Bean "+property);

        String requiredProperty = environment.getRequiredProperty("user.email");//if the key is not available it throws an exception
        System.out.println("Test Bean "+requiredProperty);

    }
}
