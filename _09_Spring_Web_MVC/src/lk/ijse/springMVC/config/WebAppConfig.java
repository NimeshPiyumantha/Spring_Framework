package lk.ijse.springMVC.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author : Nimesh Piyumantha
 * @since : 0.1.0
 **/
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "lk.ijse.springMVC")
public class WebAppConfig {

    public WebAppConfig(){
        System.out.println("WebAppConfig :Instantiated");
    }
}
