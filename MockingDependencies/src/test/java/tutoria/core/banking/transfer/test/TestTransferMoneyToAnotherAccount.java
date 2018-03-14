package tutoria.core.banking.transfer.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.net.ConnectException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import tutorial.core.banking.Account;
import tutorial.core.banking.CoreService;
import tutorial.core.banking.CoreService.InternalTransferStatus;
import tutorial.core.banking.DataRepository;
import tutorial.core.banking.EmailSender;

/*
 * We want to test every corner of our implemented business logic
 * to assure ourselves that it works as expected
 */


@RunWith(MockitoJUnitRunner.class)
public class TestTransferMoneyToAnotherAccount {
	
	 //@Mock
	 //DataRepository dataRepository;
	 
	 //@Mock
	 //EmailSender EmailSender;

	 @InjectMocks
	 CoreService bankingCoreService;
	
	/*
	 * Here we want to test the happy path of CoreService.TransferMoneyToAnotherAccount method.
	 * in happy paths nothing bad happens and everything should work as expected.
	 */
	@Test
	public void testTransferMoneyHappyPath() throws ConnectException {
		 
		//arrange
		
		Account from= new Account("accountNumber1");
		Account to= new Account("accountNumber2");
		double transferAmount= 100;
		
		//act
		
		InternalTransferStatus transferStatus= bankingCoreService.TransferMoneyToAnotherAccount(transferAmount, from, to);
		
		//assert
		
		assertThat(transferStatus,is(InternalTransferStatus.Valid));
	}
	
	
	

}
