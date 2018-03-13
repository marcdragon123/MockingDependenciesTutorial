package tutorial.core.banking;

import java.net.ConnectException;


import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {

	public static void main(String[] args) throws ConnectException {
		
		Injector injector = Guice.createInjector(new ObjectGraphModule());
		CoreService coreService = injector.getInstance(CoreService.class);
		
		
		coreService.TransferMoneyToAnotherAccount(10, new Account("0"), new Account("0"));

	}
	


}
