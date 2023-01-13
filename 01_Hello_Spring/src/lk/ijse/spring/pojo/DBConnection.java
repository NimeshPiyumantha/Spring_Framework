package lk.ijse.spring.pojo;

import org.springframework.stereotype.Component;

@Component
public class DBConnection {
    public DBConnection(){
        System.out.println("DBConnection:Instantiated");
    }

    public void testConnection(){
        System.out.println("Connection Received");
    }
}
