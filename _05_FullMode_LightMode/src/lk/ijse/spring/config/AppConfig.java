package lk.ijse.spring.config;

import lk.ijse.spring.pojo.PojoThree;
import lk.ijse.spring.pojo.PojoTwo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "lk.ijse.spring")
public class AppConfig {

    @Bean
    public PojoTwo pojoTwo(){
        return new PojoTwo();
    }

    @Bean
    public PojoThree pojoThree(){
        return new PojoThree();
    }
}
