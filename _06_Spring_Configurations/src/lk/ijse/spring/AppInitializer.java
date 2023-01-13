package lk.ijse.spring;

import lk.ijse.spring.config.AppConfig;
import lk.ijse.spring.config.ConfigOne;
import lk.ijse.spring.config.ConfigTwo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppInitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx= new AnnotationConfigApplicationContext();

        //If we have more than one config class
        //we can register them to the context as follows
        ctx.register(AppConfig.class);
//        ctx.register(ConfigOne.class);
//        ctx.register(ConfigTwo.class);

        ctx.refresh();
        ctx.registerShutdownHook();
    }
}
