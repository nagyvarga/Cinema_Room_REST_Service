package cinema;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class TicketAlreadyPurchasedException extends RuntimeException {

    public TicketAlreadyPurchasedException(String cause) {
        super(cause);
    }
}
