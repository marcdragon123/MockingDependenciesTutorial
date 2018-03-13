package tutorial.core.banking;

import java.net.ConnectException;
import java.net.SocketException;

public class CoreService {

	private EmailSender emailSender=new EmailSender(); // External Dependency
	private DataRepository  dataRepository= new DataRepository(); // External Dependency

	
	// We want to be able to test our code. So, our code should be testable.
	// The first step in having a testable code is that you should pass dependencies through the constructor of the class.
	// This way, you can pass fake and mocked objects instead of actual implementations during the test
	
	
	
	public InternalTransferStatus TransferMoneyToAnotherAccount(double amount, Account from, Account to) throws ConnectException {
		
		double fromBalance=dataRepository.GetBalanceOfAccount(from.AccountNumber);
		
		double toBalance = dataRepository.GetBalanceOfAccount(to.AccountNumber);
		
		
		double toNewBalanace = toBalance+amount;
		double fromNewBalanace = fromBalance-amount;
		
		// critical business logic ends here
		
		dataRepository.SetBalanceOfAccount(from.AccountNumber,toNewBalanace);
		dataRepository.SetBalanceOfAccount(to.AccountNumber,fromNewBalanace);
		
		SendEmailTo(amount,from,to);
		
		return InternalTransferStatus.Valid;
	}

	private void SendEmailTo(double amount, Account from, Account to) throws ConnectException {
	
		String emailAddress="security@mock.co";
		String mailSubject="Hello Secutiry Center!";
		String mailBody="Go and catch him";
		emailSender.SendEmail(emailAddress,mailSubject,mailBody);
	}


	public enum InternalTransferStatus{
		
		Valid,
		Fraud,
		Error
		
	}
	
	public enum InteracTransferStatus{
		
		Valid,
		Fraud,
		Error
		
	}
}
