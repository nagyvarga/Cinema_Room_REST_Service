package cinema;

import org.springframework.web.bind.annotation.*;


@RestController
public class SeatsController {
    private final Room room = new Room(9, 9);
    private final Purchases purchases = new Purchases();
    private final Password superPassword = new Password("super_secret");

    @GetMapping("/seats")
    public Room getSeats() {
        return room;
    }

    @PostMapping("/purchase")
    public Purchase purchaseSeat(@RequestBody Seat seat) {
        if (seat.getRow() < 0 || seat.getRow() > room.getTotal_rows() || seat.getColumn() < 0 || seat.getColumn() > room.getTotal_columns()) {
            throw new OutOfBoundsException("The number of a row or a column is out of bounds!");
        }
        if (room.setAvailability(seat.getRow(), seat.getColumn())) {
            seat.setPrice();
            Purchase purchase = new Purchase(seat);
            purchases.add(purchase);
            return purchase;
        } else {
            throw new TicketAlreadyPurchasedException("The ticket has been already purchased!");
        }
    }


    @PostMapping("/return")
    public ReturnedTicket returnedTicket(@RequestBody Token token) {
        // return purchases;
        return new ReturnedTicket(purchases.getReturnedTicket(token, room));
    }


    @PostMapping(value = "/stats")
    public Statistics returnedStats(@RequestParam(value = "password", required = false) String password) {
        if (null == password) {
            throw new WrongPasswordException("The password is wrong!");
        }
        Password writtenPassword = new Password(password);
        if (writtenPassword.isEquals(superPassword)) {
            return new Statistics(room, purchases);
        } else {
            throw new WrongPasswordException("The password is wrong!");
        }
    }

}
