package BankManagementSystem;


import java.time.LocalDate;
import java.util.Scanner;
import java.util.function.Predicate;



public class BankTester {

	public static void main(String[] args) {
		  String AccountHolderName;
	      int AccountNo;
	      double Balance;
	      String address;
	      long PhoneNo;
	      String aadharNumber;
	      int choice;
	      double amount;
	     LocalDate accountCreationDate;
	     int day,month,year;
	      int index=0;
		  Scanner sc =new Scanner(System.in);
		  System.out.println("How many account records you want");
		  
		  Bank b;
		  Bank_DaoImpl impl =new  Bank_DaoImpl();
		  
		  do {
			  System.out.println("1.Open account\n"
			  		+ "2. Deposit Money\n"
			  		+ "3. Withdraw Money\n"
			  		+ "4. Display Account\n"
			  		+ "5.Search Account");
			  System.out.println("Enter your choice: ");
				choice=Integer.parseInt(sc.nextLine());
			  switch(choice) {
			  case 1:
				  System.out.print("Enter Account Number: ");
				  AccountNo= Integer.parseInt(sc.nextLine());
				  System.out.println("Enter your AccountHolde rName :");
				  AccountHolderName=sc.nextLine();
				  
				  while(true) {
					try {  
				  
				  System.out.println("Enter your Aadhar no :");
				  aadharNumber=sc.nextLine();
				  
				  if(aadharNumber.length()!=12) {
					  throw new InvalidAdharException();
				  }
				  break;
					}catch(NumberFormatException e) {
						System.out.println("Error: Invalid input. Please enter valid Aadhar Number");
					}catch (InvalidAdharException e) {
        		        System.out.println("Error: " + e.getMessage());
        		    }
				  
				  }
				  
				  while(true) {
				  System.out.println("Enter your phone No :");
				  PhoneNo=(long)Double.parseDouble(sc.nextLine());
				  Predicate<Long>isContactValid=BankTester::validateContact;
				  if(!isContactValid.test(PhoneNo)) {
					  System.out.println("Invalid contact number. Contact number should be 10 digits.");
	                     System.out.println("Try again... ");
	                     
	     	
	                 }
	                 else {
	                	 break;//to exit the while loop
	                	 //else it will go continuosly even after valid age.
	                 }
		        	 
				  }
				  
				  System.out.print("Enter your address : ");
				 address=sc.nextLine();
				 
				
	        	 while (true) {
	        		    try {
	        		        System.out.print("Enter day: ");
	        		        day = Integer.parseInt(sc.nextLine());

	        		        System.out.print("Enter month: ");
	        		        month = Integer.parseInt(sc.nextLine());

	        		        System.out.print("Enter year: ");
	        		        year = Integer.parseInt(sc.nextLine());

	        		        if (day > 31 || month > 12) {
	        		            throw new CustomDateException();
	        		        }

	        		        accountCreationDate = LocalDate.of(year, month, day);
	        		        break; // Exit the loop when a valid date is entered
	        		    } catch (NumberFormatException e) {
	        		        System.out.println("Error: Invalid input. Please enter valid numbers for day, month, and year.");
	        		    } catch (CustomDateException e) {
	        		        System.out.println("Error: " + e.getMessage());
	        		    }
	        		}
				  
				  b=new Bank(AccountHolderName,  AccountNo,   address,  PhoneNo, aadharNumber, accountCreationDate);
				  boolean openAcc=impl.OpenAccount(b);
				  if(openAcc) {
					  System.out.print("Account opened successfully...\n");
					  
				  }else {
					  System.out.print("Error occured while opening bank details....");
				  }
				 break;
			
	                
			  case 2:
				  System.out.println("For depositing money you have to open your account...");
				  System.out.println("Enter your account no: ");
				  AccountNo= Integer.parseInt(sc.nextLine());
				  System.out.println("Enter your Aadhar no :");
				  aadharNumber=sc.nextLine();
				 
				  boolean depositMoney=impl.DepositMoney(AccountNo);
				  if(depositMoney) {
					  System.out.println("Amount deposited successfully...");
					  
				  }else {
					  System.out.println("Failed to deposit.Please try again ...");
					  
				  }
				  break;
				  
			  case 3:
				  System.out.println("For withdrawing money you have to open your account...");
				  System.out.println("Enter your account no: ");
				  AccountNo= Integer.parseInt(sc.nextLine());
				  System.out.println("Enter your Aadhar no :");
				  aadharNumber=sc.nextLine();
				
				  
				  boolean WithdrawMoney=impl.WithdrawMoney(AccountNo);
				  if(WithdrawMoney) {
					  System.out.println("Amount withdraw successfully...");
					  
				  }else {
					  System.out.println("Failed to withdraw.Insufficient Balanace ...");
					  
				  }
				  break;
				  
				  
			  case 4:
				  
				  Bank[] accountlist=impl.DisplayAccount();
					for(int i=0;i<impl.getIndex();i++){
						
						System.out.println(accountlist[i]);
					}
					break;
					
			  case 5:
				  System.out.print("Enter Account Number: ");
				  AccountNo= Integer.parseInt(sc.nextLine());
				  b=impl.SearchAccount(AccountNo);
				  if(null==b) {
		        		 System.out.println("No record found");
		        		 
		        	 }else {
		        		 System.out.println("details of User Account found"+b);
		        	 }
	        		break;
				  
				  
				  
				  
			  default:
	                System.out.println("Invalid choice!");
				  
			  
			  }
		  }while(choice!=6); {
			  sc.close();
		  }
		  
	      
	      

	}
	 static boolean validateContact(long PhoneNo) {
	        String contactStr1 = String.valueOf(PhoneNo);
	        return contactStr1.length() == 10;
	    }

}
