package cinema;

public class Statistics {
    Room room;
    Purchases purchases;
    private int income;
    private int availableSeats;
    private int purchasedTickets;

    public Statistics() {}

    public Statistics(Room room, Purchases purchases) {
        this.room = room;
        this.purchases = purchases;
        this.availableSeats = this.room.countAvailableSeats();
    }

    public int getCurrent_income() {
        return purchases.returnAllIncome();
    }

    public int getNumber_of_available_seats() {
        return this.availableSeats;
    }

    public int getNumber_of_purchased_tickets() {
        return room.getTotal_rows() * room.getTotal_columns() - availableSeats;
    }
}
