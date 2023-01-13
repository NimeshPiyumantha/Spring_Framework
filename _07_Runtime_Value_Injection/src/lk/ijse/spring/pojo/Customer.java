package lk.ijse.spring.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class Customer {

    @Autowired(required = false)
    public Customer(@Value("IJSE") String name,@Value("10") int i){
        System.out.println("Customer:Instantiated " +name+" "+i);
    }

    @Autowired(required = false)
    public Customer(@Value("Nimesh,Akila,Pasan") String names1[],@Value("Nimeshi,Akilaa,Pasani") String names2[],@Value("Dog,Cat,Rat") String names3[]) {
        System.out.println("Customer:Instantiated ");
        for (String name : names1) {
            System.out.print(name + ",");
        }
        System.out.println();

        for (String name : names2) {
            System.out.print(name + ",");
        }
        System.out.println();

        for (String name : names3) {
            System.out.print(name + ",");
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
