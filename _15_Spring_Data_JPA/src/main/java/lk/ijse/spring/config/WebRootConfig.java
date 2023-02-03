package lk.ijse.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author : Nimesh Piyumantha
 * @since : 0.1.0
 **/
@Configuration
@Import(JPAConfig.class)
public class WebRootConfig {

    public WebRootConfig() {
        System.out.println("WebRootConfig :Instantiated");
    }
}
