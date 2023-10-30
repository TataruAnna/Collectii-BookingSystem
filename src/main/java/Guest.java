import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Guest {
    private String name;
    private String surName;
    private List<Reservation> reservationList;

    public Guest(String name, String surName) {
        this.name = name;
        this.surName = surName;
        this.reservationList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", reservationList=" + reservationList +
                '}';
    }
    public boolean isRoomAvailable(Room room, LocalDate startDate, LocalDate endDate){
        List<Reservation> reservations = room.getRoomReservations();
        return reservations.stream()
                .noneMatch(reservation -> !endDate.isBefore(reservation.getCheckIn()) && !startDate.isAfter(reservation.getCheckOut()));

    }

    public boolean addReservation(Room room, LocalDate startDate, LocalDate endDate) throws Exception {
        if(!isRoomAvailable(room,startDate,endDate)){
            throw new Exception("Camera nu e disponibila");
        }
        else{
            Reservation reservation = new Reservation(startDate,endDate);
            room.getRoomReservations().add(reservation);
        }

        return true;
    }
}
