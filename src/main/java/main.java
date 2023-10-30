import java.time.LocalDate;

public class main {
    public static void main(String[] args) {
        Room room1 = new Room(1,25,2);
        Room room2 = new Room(2,22,1);
        Room room3 = new Room(3,24,2);
        Room room4 = new Room(4,20,1);

        Admin admin = new Admin("Tudor");
        Guest guest1 = new Guest("guest1","G");
        try {
            guest1.addReservation(room1, LocalDate.of(2024, 4, 12), LocalDate.of(2024, 4, 16));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println(guest1.isRoomAvailable(room1, LocalDate.of(2024, 4, 17), LocalDate.of(2024, 4, 19)));




    }
}
