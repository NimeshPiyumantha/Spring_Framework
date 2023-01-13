package lk.ijse.spring.pojo;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DBConnection implements InitializingBean {

    @Value("${os.name}")//property placeholder
    private String myOSName;

    @Value("${COMPUTERNAME}")//property placeholder
    private String computerName;

    public DBConnection(){
        System.out.println("DBConnection:Instantiated");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(myOSName);
        System.out.println(computerName);
    }
}
