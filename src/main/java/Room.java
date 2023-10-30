import java.util.ArrayList;
import java.util.List;

public class Room {
    private int roomNumber;
    private int pricePerNight;

    private int numberOfGuests;

    private List<Reservation> roomReservations;

    public Room(int roomNumber, int pricePerNight, int numberOfGuests) {
        this.roomNumber = roomNumber;
        this.pricePerNight = pricePerNight;
        this.numberOfGuests = numberOfGuests;
        this.roomReservations = new ArrayList<>();
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(int pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public List<Reservation> getRoomReservations() {
        return roomReservations;
    }

    public void setRoomReservations(List<Reservation> roomReservations) {
        this.roomReservations = roomReservations;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber=" + roomNumber +
                ", pricePerNight=" + pricePerNight +
                ", numberOfGuests=" + numberOfGuests +
                ", roomReservations=" + roomReservations +
                '}';
    }
}
