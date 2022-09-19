package cinema;

import java.util.UUID;

public class Purchase {

    Token token;
    Seat ticket;

    public Purchase() {}

    public Purchase(Seat seat) {
        this.ticket = seat;
        this.token = new Token();
    }

    public UUID getToken() {
        return token.getToken();
    }

    public Seat getTicket() {
        return ticket;
    }

    public void setTicket(Seat seat) {
        this.ticket = seat;
    }

}
