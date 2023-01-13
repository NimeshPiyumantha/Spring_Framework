package lk.ijse.spring.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class A implements DI{
    //    @Autowired
    SuperB superB;//property injection

    //    @Autowired
    public A(SuperB s){
//        this.superB=s;//constructor injection
        System.out.println("A:instantiated");
    }

    @Autowired
    public void setInjection(SuperB s){
        this.superB=s;
    }

    public void test(){
        superB.methodUseByA();
    }


    @Autowired
    @Override
    public void inject(SuperB b) {
        //interface through injection
        this.superB=b;
    }
}