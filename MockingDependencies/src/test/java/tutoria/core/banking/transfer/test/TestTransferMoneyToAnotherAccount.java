package tutoria.core.banking.transfer.test;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.net.ConnectException;

import org.mockito.InOrder;

import tutorial.core.banking.Account;
import tutorial.core.banking.CoreService;
import tutorial.core.banking.CoreService.InternalTransferStatus;
import tutorial.core.banking.DataRepository;
import tutorial.core.banking.EmailSender;
import tutorial.core.banking.InterBankingService;

/*
 * We want to test every corner of our implemented business logic
 * to assure ourselves that it works as expected
 */

public class TestTransferMoneyToAnotherAccount {
	
	
	@Test
	public void testEncryptTransaction() throws ConnectException {
	
		Account from= new Account("accountNumber1");
		Account to= new Account("accountNumber2");
		double transferAmount= 1001;
				
		// mock external dependencies
		EmailSender emailSender = new EmailSender();
		DataRepository dataRepository = mock(DataRepository.class);
		InterBankingService interBankingService = mock(InterBankingService.class);
		// instantiate the System Under Test (SUT)
		CoreService bankingCoreService =  new CoreService (emailSender,dataRepository,interBankingService);
		
		//act
				
		String encryptedTransaction= bankingCoreService.EncryptTransaction(transferAmount, from, to);
		
		//assert
		
		String expectedResult = transferAmount+"-aldlasdas^@)_(#@!d"
				+from.AccountNumber+"!@#$!@@#$^SDFSAD!@#$"
				+to.AccountNumber+"1239823123120398123";
		
		assertThat(encryptedTransaction,is(expectedResult));
		
	}
	

}
