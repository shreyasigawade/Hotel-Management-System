package hotelManagementSystem;

import java.util.Scanner;



public class Tester {

	public static void main(String[] args) {
		 int roomNumber;
		  String roomType;
		    double price;
		    int capacity;
		    boolean isOccupied;
		    int choice;
		    String  name;
		    
		    int index=0;
			  Scanner sc =new Scanner(System.in);
			 
			 
			  
			  Room room;
			  RoomDaoImpl impl =new  RoomDaoImpl();
			  do {
				  System.out.println("1. Manage Rooms \n2.Get available Rooms  \n3.Search room by room number \n4.Check in room  \n5.Check out room "
				  		+ " \n6.Search by customer name \n7.Get Guest summary report");
				  System.out.println("Enter your choice: ");
					choice=Integer.parseInt(sc.nextLine());
					switch(choice) {
					case 1:
						 System.out.print("Enter Room Number: ");
						 roomNumber= Integer.parseInt(sc.nextLine());
						 
						 System.out.print("Enter Room Type: ");
						 roomType=sc.nextLine();
						 
						 System.out.print("Enter RooM price: ");
						 price=Double.parseDouble(sc.nextLine());
						 
						 System.out.print("Enter Room capacity: ");
		                 capacity = Integer.parseInt(sc.nextLine());
						
						 System.out.print("Is the Room occupied? (true/false): ");
		                 isOccupied = Boolean.parseBoolean(sc.nextLine());
		                  
		                 room = new Room(roomNumber, roomType, price, capacity, isOccupied);
		                 boolean roomAdded = impl.addRoom(room);

		                 if (roomAdded) {
		                        System.out.println("Room added successfully.");
		                    } else {
		                        System.out.println("Failed to add room. The room list is full.");
		                    }
		                    break;
		                    
					case 2:
						System.out.println("Here are room lists given below");
						Room[] roomlist=impl.getAllRooms();
						for(int i=0;i<impl.getIndex();i++) {
							System.out.println(roomlist[i]);
						}

						 break;
						 
					case 3:
						 System.out.print("Enter Room Number to search: ");
		                   roomNumber = Integer.parseInt(sc.nextLine());
		                    Room searchedRoom = impl.SearchRoom(roomNumber);
		                    if (searchedRoom == null) {
		                        System.out.println("No room found with the specified room number.");
		                    } else {
		                        System.out.println("Details of room found:\n" + searchedRoom);
		                    }
		                   
					    break;
					    
					case 4:
						 System.out.print("Enter Room Number to check-in: ");
						    roomNumber = Integer.parseInt(sc.nextLine());
						    System.out.print("Enter Guest Name: ");
						    name = sc.nextLine();
						    boolean checkedIn = impl.checkInGuest(roomNumber, new Guest(name));
						    if (checkedIn) {
						        System.out.println("Checked-in successfully.");
						    } else {
						         room = impl.SearchRoom(roomNumber);
						        if (room == null) {
						            System.out.println("Room not found.");
						        } else if (room.isOccupied()) {
						            System.out.println("Room is already occupied.");
						        } else {
						            System.out.println("Failed to check-in. Unknown issue.");
						        }
						    }
						break;
						
					case 5:
						System.out.print("Enter Room Number to check-out: ");
	                    roomNumber = Integer.parseInt(sc.nextLine());
	                    boolean checkedOut = impl.checkOutGuest(roomNumber);
	                    if (checkedOut) {
	                        System.out.println("Checked-out successfully.");
	                    } else {
	                        System.out.println("Failed to check-out. Room not found or not occupied.");
	                    }
						break;
						
					case 6:
						System.out.print("Enter the name of the customer to search: ");
					    String customerName = sc.nextLine();
					    Guest searchedCustomer = impl.searchCustomerByName(customerName);
					    if (searchedCustomer != null) {
					        System.out.println("Customer found: " + searchedCustomer.getName());
					    } else {
					        System.out.println("Customer not found.");
					    }
						break;
						
					case 7:
						String guestReport = impl.getGuestSummaryReport();
					    System.out.println("Guest Summary Report:\n" + guestReport);
					    break;
					}
					
				
				
						
						
						
					
					
					
					
					
					
					
					
					
					
					
					
			  }while(choice!=6);
			  

	}

}
