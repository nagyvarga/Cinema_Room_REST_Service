package cinema;

import java.util.ArrayList;
import java.util.List;

public class Room {

    private int totalRows;
    private int totalColumns;
    private boolean[][] availableSeats;

    public Room() {}

    public Room(int rows, int columns) {
        this.totalRows = rows;
        this.totalColumns = columns;
        availableSeats = new boolean[totalRows][totalColumns];
        resetRoom();
    }

    private void resetRoom() {
        for (int i = 0; i < totalRows; i++) {
            for (int j = 0; j < totalColumns; j++) {
                availableSeats[i][j] = true;
            }
        }
    }

    public boolean setAvailability(int row, int column) {
        if (availableSeats[row - 1][column - 1]) {
            availableSeats[row - 1][column - 1] = false;
            return true;
        } else {
            return false;
        }
    }

    public void setRefundSeatStatus(int row, int column) {
        availableSeats[row - 1][column - 1] = true;
    }

    public int getTotal_rows() {
        return totalRows;
    }

    public int getTotal_columns() {
        return totalColumns;
    }

    public List<Seat> getAvailable_seats() {
        List<Seat> available = new ArrayList<>();
        for (int i = 0; i < totalRows; i++) {
            for (int j = 0; j < totalColumns; j++) {
                if (availableSeats[i][j]) {
                    available.add(new Seat(i + 1, j + 1));
                }
            }
        }
        return available;
    }

    public int countAvailableSeats() {
        int countSeats = 0;
        for (boolean[] row : availableSeats) {
            for (boolean seatAvailable : row) {
                if (seatAvailable) {
                    countSeats++;
                }
            }
        }
        return countSeats;
    }
}
