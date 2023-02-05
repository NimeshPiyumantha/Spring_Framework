package lk.ijse.spring.config;

import lk.ijse.spring.advisor.AppWideExceptionHandler;
import lk.ijse.spring.controller.CustomerController;
import lk.ijse.spring.controller.ItemController;
import lk.ijse.spring.controller.PlaceOrderController;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author : Nimesh Piyumantha
 * @since : 0.1.0
 **/
@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = {AppWideExceptionHandler.class},basePackages = "lk.ijse.spring.controller")
public class WebAppConfig {

    public WebAppConfig() {
        System.out.println("WebAppConfig :Instantiated");
    }

}
