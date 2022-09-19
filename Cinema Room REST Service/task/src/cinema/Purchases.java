package cinema;

import java.util.ArrayList;
import java.util.List;

public class Purchases {

    private final List<Purchase> purchaseList;

    public Purchases() {
        purchaseList = new ArrayList<>();
    }

    public void add(Purchase p) {
        purchaseList.add(p);
    }

    public Seat getReturnedTicket(Token token, Room room) {
        for (Purchase p : purchaseList) {
            if (p.getToken().toString().equals(token.getToken().toString())) {
                purchaseList.remove(p);
                room.setRefundSeatStatus(p.ticket.getRow(), p.ticket.getColumn());
                return p.getTicket();
            }
        }
        throw new WrongTokenException("Wrong token!");
    }

    public List<Purchase> getPurchaseList() {
        return purchaseList;
    }

    public int returnAllIncome() {
        int allIncome = 0;
        for (Purchase p : purchaseList) {
            allIncome += p.ticket.getPrice();
        }
        return allIncome;
    }

}
