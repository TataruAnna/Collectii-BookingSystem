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
            admin.addRoom(room1);
            admin.addRoom(room2);
            admin.addRoom(room3);
            admin.addRoom(room4);
            admin.editPrice(room3,45);

            guest1.addReservation(room1, LocalDate.of(2024, 4, 12), LocalDate.of(2024, 4, 16));
//            guest1.addReservation(room2, LocalDate.of(2024, 4, 12), LocalDate.of(2024, 4, 16));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println(guest1.isRoomAvailable(room1, LocalDate.of(2024, 4, 17), LocalDate.of(2024, 4, 19)));

        System.out.println(admin.viewRooms());
        System.out.println(admin.findNumberOfBookedRooms(LocalDate.of(2024,4,12),LocalDate.of(2024, 4, 16)));
        System.out.println(admin.findNumberOfAvailableRooms(LocalDate.of(2024,4,12),LocalDate.of(2024, 4, 16)));




    }
}
