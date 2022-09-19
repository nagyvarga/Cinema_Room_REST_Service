package cinema;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.ResponseEntity;


@ControllerAdvice
public class ControllerExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler
    @ResponseBody
    public ResponseEntity<ErrorMessage> showCustomMessage(Exception e) {
        ErrorMessage message = new ErrorMessage(e.getMessage());
        int code = 400;
        if (e.getMessage().equals("The password is wrong!")) {
            code = 401;
        }

        return new ResponseEntity<>(message, HttpStatus.valueOf(code));
    }
}

