package lk.ijse.spring.pojo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author : Nimesh Piyumantha
 * @since : 0.1.0
 **/
@Component
public class Girl implements GoodGirl,BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {
    public Girl() {
        System.out.println("Girl : Instantiated");
    }

    public void chat() {
        System.out.println("Boy Chat with Girl.");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("Girl: Bean Factory Aware");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Girl: Bean Name Aware");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Girl : Destroyed");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Girl : Initializing Bean : Bean is ready to use");
        System.out.println("======================");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Girl: Application Context Aware");
    }
}
