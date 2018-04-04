package tutorial.core.banking;

import java.net.ConnectException;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.ThreadContext;

import com.google.inject.Inject;

public class CoreService {

	private IEmailSender emailSender; // External Dependency
	private IDataRepository  dataRepository; // External Dependency
	private	static final org.apache.logging.log4j.Logger logger = LogManager.getRootLogger(); // singleton pattern - code smell!!!

	
	// We want to be able to test our code. So, our code should be testable.
	// The first step in having a testable code is that you should pass dependencies through the constructor of the class.
	// This way, you can pass fake and mocked objects instead of actual implementations during the test
	
	@Inject
	public CoreService(IEmailSender emailSender,IDataRepository dataRepository) {
		
		this.emailSender=emailSender;
		this.dataRepository=dataRepository;
	}
	
	
	public InternalTransferStatus TransferMoneyToAnotherAccount(double amount, Account from, Account to) {
	
		logger.debug("Started: TransferMoneyToAnotherAccount");
		
		double fromBalance=dataRepository.GetBalanceOfAccount(from.AccountNumber);
		
		double toBalance = dataRepository.GetBalanceOfAccount(to.AccountNumber);
		
		
		double toNewBalanace = toBalance+amount;
		double fromNewBalanace = fromBalance-amount;
		
		dataRepository.SetBalanceOfAccount(from.AccountNumber,toNewBalanace);
		dataRepository.SetBalanceOfAccount(to.AccountNumber,fromNewBalanace);
		
		try {
			SendEmailTo(amount,from,to);
		} catch (ConnectException e) {
			logger.error("Error: TransferMoneyToAnotherAccount",e);
		}
		
		logger.debug("Finished: TransferMoneyToAnotherAccount");
		
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
