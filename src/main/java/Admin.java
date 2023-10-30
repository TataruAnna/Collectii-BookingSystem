import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Admin {
    private String name;
    private List<Room> roomList;
    private List<Guest> guestList;

    public Admin(String name) {
        this.name = name;
        this.roomList = new ArrayList<>();
        this.guestList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    public List<Guest> getGuestList() {
        return guestList;
    }

    public void setGuestList(List<Guest> guestList) {
        this.guestList = guestList;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "name='" + name + '\'' +
                ", roomList=" + roomList +
                ", guestList=" + guestList +
                '}';
    }

    public boolean addRoom(Room room) throws Exception {
        if(roomList.contains(room)){
            throw new Exception("Camera exista deja");
        }else{
            roomList.add(room);
        }

        return true;
    }
    public boolean removeRoom(Room room) throws Exception {
        if(!roomList.contains(room)){
            throw new Exception("Camera nu exista");
        }else{
            roomList.remove(room);
        }
        return true;
    }

    public void viewRooms(){
        roomList.toString();
    }

    public boolean editPrice(Room room, int price) throws Exception {
        int roomNumber = room.getRoomNumber();
        if(!roomList.contains(room)){
            throw new Exception("Pretul nu poate fii editat pt ca nu exista camera");
        }else{
           room.setPricePerNight(price);
        }
        return true;
    }
    //Sa vada cate camere sunt libere/ocupate pentru o anumita perioada
    public long findNumberOfAvailableRooms (LocalDate startDate, LocalDate endDate){

        return roomList.stream()
                .flatMap(room->room.getRoomReservations().stream())
                .filter(reservation -> !endDate.isBefore(reservation.getCheckIn()) && !startDate.isAfter(reservation.getCheckOut()))
                .count();

    }
    public long findNumberOfBookedRooms (LocalDate startDate, LocalDate endDate){

        return roomList.stream()
                .flatMap(room->room.getRoomReservations().stream())
                .filter(reservation -> endDate.isBefore(reservation.getCheckIn()) && startDate.isAfter(reservation.getCheckOut()))
                .count();

    }


    //Sa vada care este pretul obtinut din toate rezervarile dintr-o anumita perioada


}
