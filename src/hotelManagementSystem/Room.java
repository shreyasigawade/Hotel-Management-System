package hotelManagementSystem;

public class Room {
  
   private int roomNumber;
   private String roomType;
   private double price;
   private int capacity;
   private boolean isOccupied;
   private Guest guest;
   
   
   public Room(int roomNumber, String roomType, double price, int capacity,boolean isOccupied) {
	super();
	this.roomNumber = roomNumber;
	this.roomType = roomType;
	this.price = price;
	this.capacity = capacity;
	this.isOccupied=isOccupied;
	 this.guest = null;
}


@Override
public String toString() {
	return "Room [roomNumber=" + roomNumber + ", roomType=" + roomType + ", price=" + price + ", capacity=" + capacity
			+ ", isOccupied=" + isOccupied + "]";
}


public int getRoomNumber() {
	return roomNumber;
}
public void setRoomNumber(int roomNumber) {
	this.roomNumber = roomNumber;
}
public String getRoomType()  {
    this.isOccupied = true;
    this.guest = guest;
	return roomType;
}
public void setRoomType(String roomType) {
	this.roomType = roomType;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public int getCapacity() {
	return capacity;
}
public void setCapacity(int capacity) {
	this.capacity = capacity;
}

public boolean isOccupied() {
    return isOccupied;
}

public Guest getGuest() {
    return guest;
}
public void checkIn(Guest guest) {
    this.isOccupied = true;
    this.guest = guest;
}

public void checkOut() {
    this.isOccupied = false;
    this.guest = null;
}
   
}
