package lk.ijse.spring.pojo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class PojoTwo  implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {
    public PojoTwo(){
        System.out.println("PojoTwo:Instantiated");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("PojoTwo:Bean Factory Aware");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("PojoTwo:Bean Name Aware");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("PojoTwo:Disposable Bean");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("PojoTwo:Initializing Bean");
        System.out.println("================");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("PojoTwo:Application Context Aware");
    }
}
