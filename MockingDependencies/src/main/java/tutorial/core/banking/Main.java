package tutorial.core.banking;

import java.net.ConnectException;


import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {

	public static void main(String[] args) throws ConnectException {
		
		Injector injector = Guice.createInjector(new ObjectGraphModule());
		CoreService coreService = injector.getInstance(CoreService.class);
		
		InitializeHttpContext();
		IntializeContextualLogging();
		
		coreService.TransferMoneyToAnotherAccount(10, new Account("0"), new Account("1"));

	}


	private static void IntializeContextualLogging() {
		
	}


	// In web applications, there is a Http Context per request which contains some information about the user and its request
	// Here we have just filled the http context with some fake information 
	private static void InitializeHttpContext() {
		
		HttpContext.IpAddress="1.1.1.1";
		HttpContext.Username="Bob";
		HttpContext.SessionId="231312419238012DKASL2";
		HttpContext.RequestedUrl="./accounts/transfer?from=0&to=1";
		
		
	}
	


}
