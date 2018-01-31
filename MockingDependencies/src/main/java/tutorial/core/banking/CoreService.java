package tutorial.core.banking;

import java.net.ConnectException;
import java.net.SocketException;

public class CoreService {

	private EmailSender emailSender; // External Dependency
	private DataRepository dataRepository; // External Dependency
	private InterBankingService interBankingService; // External Dependency
	
	// We want to be able to test our code. So, our code should be testable.
	// The first step in having a testable code is that you should pass dependencies through the constructor of the class.
	// This way, you can pass fake and mocked objects instead of actual implementations during the test
	
	public CoreService(EmailSender emailSender, DataRepository dataRepository,InterBankingService interBankingService){
		
		this.emailSender=emailSender;
		this.dataRepository=dataRepository;
		this.interBankingService=interBankingService;
	}
	
	
	public InternalTransferStatus TransferMoneyToAnotherAccount(double amount, Account from, Account to) throws ConnectException {
		
		double fromBalance=dataRepository.GetBalanceOfAccount(from.AccountNumber);
		
		double toBalance = dataRepository.GetBalanceOfAccount(to.AccountNumber);
		
		// critical business logic starts here
		
		if(fromBalance<amount)
			return  InternalTransferStatus.Error;
		
		if(IsThisAFraudTransfer(amount,from)) {
			SendEmailToSecutiryCenter(amount,from,to);
			return InternalTransferStatus.Fraud;
		}
			
		
		double toNewBalanace = toBalance+amount;
		double fromNewBalanace = fromBalance-amount;
		
		// critical business logic ends here
		
		dataRepository.SetBalanceOfAccount(from.AccountNumber,toNewBalanace);
		dataRepository.SetBalanceOfAccount(to.AccountNumber,fromNewBalanace);
		
		return InternalTransferStatus.Valid;
	}

	
	public InteracTransferStatus TransferMoneyWithInterac(double amount, Account from, String phoneNumber) throws SocketException {
		
		double fromBalance=dataRepository.GetBalanceOfAccount(from.AccountNumber);
		
		if(fromBalance<amount)
			return  InteracTransferStatus.Error;
		
		return interBankingService.Interac(amount,from,phoneNumber);
	}

	private void SendEmailToSecutiryCenter(double amount, Account from, Account to) throws ConnectException {
	
		String emailAddress="security@mock.co";
		String mailSubject="Hello Secutiry Center!";
		String mailBody="Go and catch him";
		emailSender.SendEmail(emailAddress,mailSubject,mailBody);
	}


	private boolean IsThisAFraudTransfer(double amount, Account from) {
		
		// Use some fancy machine learning techniques to detect fraud
		
		if(amount>1000)
			return true;
		
		return false;
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
