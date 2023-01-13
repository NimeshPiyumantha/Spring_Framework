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

    @Value("${db.user.name}")
    private String dbUserName;
    @Value("${db.user.password}")
    private String dbPassWord;

    @Value("${user.email}")
    private String userEmail;


    public DBConnection(){
        System.out.println("DBConnection:Instantiated");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(myOSName);
        System.out.println(computerName);
        System.out.println("====");
        System.out.println(dbUserName);
        System.out.println(dbPassWord);
        System.out.println(userEmail);
    }
}
