package lk.ijse.spring.config;

import lk.ijse.spring.service.impl.CustomerServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author : Nimesh Piyumantha
 * @since : 0.1.0
 **/
@Configuration
@Import(JPAConfig.class)
@ComponentScan(basePackages = "lk.ijse.spring.service")
public class WebRootConfig {

    public WebRootConfig() {
        System.out.println("WebRootConfig :Instantiated");
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}

