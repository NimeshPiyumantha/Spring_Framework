package lk.ijse.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppInitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx= new AnnotationConfigApplicationContext();
        ctx.register();
        ctx.refresh();
        ctx.registerShutdownHook();
    }
}
