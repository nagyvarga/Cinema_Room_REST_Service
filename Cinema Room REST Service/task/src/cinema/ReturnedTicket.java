package cinema;

public class ReturnedTicket {

    private Seat returnedTicket;

    public ReturnedTicket() {}

    public ReturnedTicket(Seat seat) {
        this.returnedTicket = seat;
    }

    public Seat getReturned_ticket() {
        return returnedTicket;
    }
}
