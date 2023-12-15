package BankManagementSystem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Bank {
     private String AccountHolderName;
     private int AccountNo;
     private double Balance;
     private String address;
     private long PhoneNo;
     private String aadharNumber;
     private LocalDate accountCreationDate;
	
     public Bank(String accountHolderName, int accountNo,  String address, long phoneNo,
			String aadharNumber,LocalDate accountCreationDate) {
		super();
		AccountHolderName = accountHolderName;
		AccountNo = accountNo;
		this.Balance=0.0;
		this.address = address;
		PhoneNo = phoneNo;
		this.aadharNumber = aadharNumber;
		this.accountCreationDate= accountCreationDate;
	}

	@Override
	public String toString() {
		return "Bank [AccountHolderName=" + AccountHolderName + ", AccountNo=" + AccountNo + ", Balance=" + Balance
				+ ", address=" + address + ", PhoneNo=" + PhoneNo + ", aadharNumber=" + aadharNumber + ", accountCreationDate="+ 
				DateTimeFormatter.ofPattern("dd-MM-yyyy").format(accountCreationDate)+"]";
	}

	public String getAccountHolderName() {
		return AccountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		AccountHolderName = accountHolderName;
	}

	public int getAccountNo() {
		return AccountNo;
	}

	public void setAccountNo(int accountNo) {
		AccountNo = accountNo;
	}

	public double getBalance() {
		return Balance;
	}

	public void setBalance(double balance) {
		Balance = balance;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getPhoneNo() {
		return PhoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		PhoneNo = phoneNo;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public LocalDate getAccountCreationDate() {
		return accountCreationDate;
	}

	public void setAccountCreationDate(LocalDate accountCreationDate) {
		this.accountCreationDate = accountCreationDate;
	}
	
     
     
 }
