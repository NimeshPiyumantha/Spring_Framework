package lk.ijse.spring.pojo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author : Nimesh Piyumantha
 * @since : 0.1.0
 **/

@Component
//@Scope("singleton")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SpringBeanOne implements BeanNameAware,BeanFactoryAware, ApplicationContextAware, InitializingBean,DisposableBean {

    public SpringBeanOne(){
        System.out.println("SpringBeanOne : Instantiated");
    }


    @Override
    public void setBeanName(String name) {
        System.out.println("SpringBeanOne: Bean Name Aware");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("SpringBeanOne: Bean Factory Aware");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("SpringBeanOne: Application Context Aware");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("SpringBeanOne: Initializing Bean : Bean is ready to use");
        System.out.println("======================");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("SpringBeanOne :SpringBeanOne : Destroyed");
    }
}
