package lk.ijse.spring.adviser;

import lk.ijse.spring.util.utilAlert;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author : Nimesh Piyumantha
 * @since : 0.1.0
 **/

@RestControllerAdvice
@CrossOrigin
public class AppWideExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({RuntimeException.class})
    public utilAlert handleMyExceptions(RuntimeException e){
        System.out.println(e.getMessage());
        return new utilAlert("Error", e.getMessage());
    }
}
