package lk.ijse.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan(basePackages = "lk.ijse.spring")
@Import({ConfigOne.class,ConfigTwo.class})
//@ImportResource("classpath:abcd.xml")// class path
//@ImportResource("filepath:abcd.xml")//absolute path
public class AppConfig {
    public AppConfig(){
        System.out.println("AppConfig:Instantiated");
    }
}
