package BankManagementSystem;

public interface BankDAO {
        boolean OpenAccount(Bank b);
        boolean DepositMoney(int AccountNo);  
        boolean WithdrawMoney(int AccountNo);  
       
        Bank SearchAccount(int AccountNo);
        Bank[] DisplayAccount();
}
