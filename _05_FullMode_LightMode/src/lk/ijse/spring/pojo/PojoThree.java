package lk.ijse.spring.pojo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class PojoThree implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {
    public PojoThree(){
        System.out.println("PojoThree:Instantiated");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("PojoThree:Bean Factory Aware");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("PojoThree:Bean Name Aware");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("PojoThree:Disposable Bean");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("PojoThree:Initializing Bean");
        System.out.println("================");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("PojoThree:Application Context Aware");
    }
}
