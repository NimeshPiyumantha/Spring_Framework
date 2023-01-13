import lk.ijse.spring.config.AppConfig;
import lk.ijse.spring.pojo.Boy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : Nimesh Piyumantha
 * @since : 0.1.0
 **/
public class AppInitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();


        Boy b1 = ctx.getBean(Boy.class);
        b1.chatWithGirl();

        ctx.registerShutdownHook();

    }
}