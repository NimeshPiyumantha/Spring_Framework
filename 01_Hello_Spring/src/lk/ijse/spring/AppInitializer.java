package lk.ijse.spring;

import lk.ijse.spring.config.AppConfig;
import lk.ijse.spring.pojo.BasicDataSource;
import lk.ijse.spring.pojo.Customer;
import lk.ijse.spring.pojo.DBConnection;
import lk.ijse.spring.pojo.PojoOne;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppInitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx= new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();

        //Context Invocation
        Customer c1 = ctx.getBean(Customer.class);
        Customer c2 = ctx.getBean(Customer.class);
        System.out.println(c1);
        System.out.println(c2);
        c1.getCustomerName();

        DBConnection db1 = ctx.getBean(DBConnection.class);
        DBConnection db2 = ctx.getBean(DBConnection.class);
        System.out.println(db1);
        System.out.println(db2);

        BasicDataSource bean1 = ctx.getBean(BasicDataSource.class);
        BasicDataSource bean2 = ctx.getBean(BasicDataSource.class);
        System.out.println(bean1);
        System.out.println(bean2);

        System.out.println("====Bean ID=====");
        //@Component
        //Customer -> customer (beanID) get the class name and then
        //convert the first letter into simple letter

        Customer customer = (Customer) ctx.getBean("ijse");
        System.out.println(customer);

        PojoOne pojoOne = (PojoOne) ctx.getBean("pojoOne");
        System.out.println(pojoOne);


        //How the @Bean bean id is created.?
        //Generate bean id with bean method name
        BasicDataSource bds = (BasicDataSource) ctx.getBean("ac");
        System.out.println(bds);
/**
 * Hooking Process
 * hooking process ekak run krla jvm shutdown wenna mohothkta kalim run krgnna ona code run krnna

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                ctx.close();
                System.out.println("JVM is about to shutdown");
            }
        }));

 **/

        ctx.registerShutdownHook();
    }
}
