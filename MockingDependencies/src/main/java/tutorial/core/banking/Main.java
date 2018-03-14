package tutorial.core.banking;

import java.net.ConnectException;

public class Main {

	public static void main(String[] args) throws ConnectException {
		
		CoreService coreService=new CoreService();
		coreService.TransferMoneyToAnotherAccount(10, new Account("Alice"), new Account("Bob"));
	}

}
