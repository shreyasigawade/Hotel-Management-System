package BankManagementSystem;

public class InvalidAdharException extends Exception{
	public InvalidAdharException() {
        super("Error : InvalidAdharException(Adhar Number should be 8 digits");
}
}