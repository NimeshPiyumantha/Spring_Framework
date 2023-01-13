import lk.ijse.spring.config.AppConfig;
import lk.ijse.spring.pojo.SpringBeanOne;
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

        SpringBeanOne bean1 = ctx.getBean(SpringBeanOne.class);
        System.out.println(bean1);

        SpringBeanOne bean2 = ctx.getBean(SpringBeanOne.class);
        System.out.println(bean2);

        ctx.registerShutdownHook();
    }
}
