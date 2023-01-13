package lk.ijse.spring2.pojo;

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
public class SpringBeanThree implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {
    public SpringBeanThree() {
        System.out.println("Spring Bean Three : Instantiated");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Spring Bean Three : Bean Name Aware");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("Spring Bean Three : Bean Factory Aware");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Spring Bean Three : Application Context Aware");
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Spring Bean Three : Initializing Bean : Ready");
        System.out.println("====================");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Spring Bean Three : Disposable Bean");
    }
}
