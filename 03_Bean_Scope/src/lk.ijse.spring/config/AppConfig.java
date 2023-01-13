package lk.ijse.spring.config;

import lk.ijse.spring.pojo.BasicDataSource;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author : Nimesh Piyumantha
 * @since : 0.1.0
 **/
@Configuration
@ComponentScan(basePackages = "lk.ijse.spring")
public class AppConfig {
    @Bean
//    @Scope("prototype")
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public BasicDataSource basicDataSource(){
        return new BasicDataSource();
    }
}
