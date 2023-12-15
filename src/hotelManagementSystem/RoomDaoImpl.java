package hotelManagementSystem;



public class RoomDaoImpl implements RoomDAO {
	Room roomArray[]=new Room[10];
	int index=0;
	

	@Override
	public boolean addRoom(Room room) {
		if(index<roomArray.length) {
			roomArray[index++]=room;
			return true;//Room added successfully
		}
		return false; //Room array is full, cannot add more rooms
	}

	@Override
	public Room SearchRoom(int roomNumber) {
		Room room=null;
		for(int i=0;i<index;i++) {
			if(roomArray[i]!=null && roomArray[i].getRoomNumber()==roomNumber) {
				  // Found the room with the specified roomNumber, return it
				room=roomArray[i];
				break;
			}
		}
		// If no room with the specified roomNumber is found, return null or handle the case as needed
		return room;
	}
	
	public int getIndex() {
		return index;
		
	}

	@Override
	public Room[] getAllRooms() {
		 Room[] allRooms = new Room[index]; // Create an array to hold all the rooms

		    // Copy the rooms from roomArray to allRooms
		    for (int i = 0; i < index; i++) {
		        allRooms[i] = roomArray[i];
		    }

		    return allRooms;
		
	
	}

	

	@Override
	public boolean checkInGuest(int roomNumber, Guest guest) {
		Room room = SearchRoom(roomNumber);
        if (room != null && !room.isOccupied()) {
            room.checkIn(guest);
            return true; // Check-in successful
        }
        return false; // Room not found or already occupied
    }


	@Override
	public boolean checkOutGuest(int roomNumber) {
		   Room room = SearchRoom(roomNumber);
	        if (room != null && room.isOccupied()) {
	            room.checkOut();
	            return true; // Check-out successful
	        }
	        return false; // Room not found or not occupied
	    }

	@Override
	public Guest searchCustomerByName(String name) {
		 for (int i = 0; i < index; i++) {
		        Room room = roomArray[i];
		        if (room != null && room.isOccupied() && room.getGuest()!=null && room.getGuest().getName().equals(name)) {
		            return room.getGuest();
		        }
		    }
		    return null; // Customer not found
	}

	@Override
	public String getGuestSummaryReport() {
		StringBuilder report = new StringBuilder();
	    
	    for (int i = 0; i < index; i++) {
	        Room room = roomArray[i];
	        if (room != null && room.isOccupied() && room.getGuest() != null) {
	            report.append("Room Number: ").append(room.getRoomNumber()).append("\n");
	            report.append("Guest Name: ").append(room.getGuest().getName()).append("\n");
	            // Add any other relevant information to the report
	            report.append("\n"); // Add a separator
	        }
	    }
	    
	    if (report.length() == 0) {
	        report.append("No guests have checked in.");
	    }
	    
	    return report.toString();
	}

}
