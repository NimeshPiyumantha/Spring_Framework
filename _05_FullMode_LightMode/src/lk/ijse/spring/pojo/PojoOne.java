package lk.ijse.spring.pojo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class PojoOne implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {
    public PojoOne(){
        System.out.println("PojoOne:Instantiated");
    }


    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("PojoOne:Bean Factory Aware");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("PojoOne:Bean Name Aware");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("PojoOne:Disposable Bean");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("PojoOne:Initializing Bean");
        System.out.println("================");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("PojoOne:Application Context Aware");
    }
}
