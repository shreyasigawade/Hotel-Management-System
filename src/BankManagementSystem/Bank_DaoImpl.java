package BankManagementSystem;

import java.util.Scanner;

public class Bank_DaoImpl implements BankDAO {
	
	Bank bankArray[]=new Bank[10];
	int index=0;
	

	@Override
	public boolean OpenAccount(Bank b) {
		if(index<bankArray.length) {
			bankArray[index++]=b;
			return true;
			
		}
		
		return false;
	}


	@Override
	public boolean DepositMoney(int AccountNo) {
		Scanner sc=new Scanner (System.in);
		 System.out.println("Enter the amount you want to deposit: ");
	     double amount = Double.parseDouble(sc.nextLine());
		for(int i = 0; i < index; i++) {
			if(bankArray[i].getAccountNo()==AccountNo) {
				Double newBalance=bankArray[i].getBalance()+amount;
				bankArray[i].setBalance(newBalance);
				return true;
				
			}
		}
		return false;
	}


	@Override
	public boolean WithdrawMoney(int AccountNo) {
		Scanner sc=new Scanner (System.in);
		 System.out.println("Enter the amount you want to withdraw: ");
		 double amount = Double.parseDouble(sc.nextLine());
		for(int i = 0; i < index; i++) {
			if(bankArray[i].getAccountNo()==AccountNo ) {
				if(bankArray[i].getBalance()>=amount) {
					double newBalance = bankArray[i].getBalance() - amount;
                    bankArray[i].setBalance(newBalance);
                    return true;
				}
			}
			}
		return false;
	}

	public int getIndex() {
		return index;
		
	}


	@Override
	public Bank[] DisplayAccount() {
		
		return bankArray;
	}


	@Override
	public Bank SearchAccount(int AccountNo) {
		Bank b=null;
		for(int i = 0; i < index; i++) {
			if(bankArray[i]!=null && bankArray[i].getAccountNo()==AccountNo ) {
				b=bankArray[i];
				break;
			}
			}
		return b;
	}






	


}
