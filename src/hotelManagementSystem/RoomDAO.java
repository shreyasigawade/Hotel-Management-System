package hotelManagementSystem;

public interface RoomDAO {
	 boolean addRoom(Room room);
	 Room SearchRoom(int roomNumber);

	    Room[] getAllRooms();
	    boolean checkInGuest(int roomNumber,Guest guest);
	    boolean checkOutGuest(int roomNumber);
	    Guest searchCustomerByName(String name);
	    String getGuestSummaryReport(); 
}
