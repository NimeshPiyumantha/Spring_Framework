package lk.ijse.spring.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class Customer {

    @Autowired
    public Customer(@Value("IJSE") String name){
        System.out.println("Customer:Instantiated " +name);
    }


    public Customer(@Value("Nimesh,Akila,Pasan") String names[]){
        System.out.println("Customer:Instantiated ");
        for (String name:names) {
            System.out.println(name);
        }
    }

//    public Customer(){
//        System.out.println("Customer: Default Contractor Instantiated");
//    }

    //what you ca assign with@Value annotation
    //Primitive data type
    //String Data
    //Arrays
}
