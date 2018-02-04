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
	
	/*
	 * Here we want to test the happy path of CoreService.TransferMoneyToAnotherAccount method.
	 * in happy paths nothing bad happens and everything should work as expected.
	 * Exercise1: there is an inconsistency between the test and the SUT (System Under Test). 
	 * Find and remove the given bug in the test method. 
	 */
	@Test
	public void testHappyPathExercise1() throws ConnectException {
		 
		//arrange
		
		Account from= new Account("accountNumber1");
		Account to= new Account("accountNumber2");
		double transferAmount= 100;
		
		// mock external dependencies
		EmailSender emailSender = new EmailSender();
		DataRepository dataRepository = mock(DataRepository.class);
		InterBankingService interBankingService = mock(InterBankingService.class);
		// stub
		when(dataRepository.GetBalanceOfAccount("accountNumber1")).thenReturn(4000d);
		when(dataRepository.GetBalanceOfAccount("accountNumber2")).thenReturn(2000d);
		// instantiate the System Under Test (SUT)
		CoreService bankingCoreService =  new CoreService (emailSender,dataRepository,interBankingService);
		
		//act
		
		InternalTransferStatus transferStatus= bankingCoreService.TransferMoneyToAnotherAccount(transferAmount, from, to);
		
		//assert
		
		assertThat(transferStatus,is(InternalTransferStatus.Fraud));
	}
	
	/*
	 * Here we want to verify the behaviour of implemented business logic.
	 * In fact, we want to check whether the SUT has used its dependencies in a correct manner.
	 * in behavioural verification order of calls and passed parameters are crucial.
	 * Exercise2: there is an inconsistency between the test and the SUT. Find and remove the given bug.
	 * Hint: The bug is in the production code
	 */
	@Test
	public void testHappyPathBehaviourExercise2() throws ConnectException {
	
		//arrange
		
		Account from= new Account("accountNumber1");
		Account to= new Account("accountNumber2");
		double transferAmount= 100;
		
		// mock external dependencies
		EmailSender emailSender = new EmailSender();
		DataRepository dataRepository = mock(DataRepository.class);
		InterBankingService interBankingService = mock(InterBankingService.class);
		// stub
		when(dataRepository.GetBalanceOfAccount("accountNumber1")).thenReturn(1000d);
		when(dataRepository.GetBalanceOfAccount("accountNumber2")).thenReturn(2000d);
		// instantiate the System Under Test (SUT)
		CoreService bankingCoreService =  new CoreService (emailSender,dataRepository,interBankingService);
		
		//act
		
		InternalTransferStatus transferStatus= bankingCoreService.TransferMoneyToAnotherAccount(transferAmount, from, to);
		
		// assert (verfiy the behaviour)
		// we use times(1) to assert that this method has been called only once
		// according to business needs, we don't want to deposit or withdraw money more that once in this operation
		InOrder inOrder = inOrder(dataRepository);
		inOrder.verify(dataRepository).GetBalanceOfAccount(from.AccountNumber);
		inOrder.verify(dataRepository).GetBalanceOfAccount(to.AccountNumber);
		inOrder.verify(dataRepository,times(1)).SetBalanceOfAccount(from.AccountNumber, 1000-transferAmount);
		inOrder.verify(dataRepository,times(2)).SetBalanceOfAccount(to.AccountNumber,2000+transferAmount);
		
	}
	
	/*
	 * Exercise3: An exception is thrown when we run this test. Find the reason and correct the test code accordingly.
	 */
	@Test
	public void testFraudPathExercise3() throws ConnectException {
		
		//arrange
		
		// define a fraud scenario
		Account from= new Account("accountNumber1");
		Account to= new Account("accountNumber2");
		double transferAmount= 1001;
				
		// mock external dependencies
		EmailSender emailSender =mock(EmailSender.class);
		DataRepository dataRepository = mock(DataRepository.class);
		InterBankingService interBankingService = mock(InterBankingService.class);
		// stub
		when(dataRepository.GetBalanceOfAccount("accountNumber1")).thenReturn(4000d);
		when(dataRepository.GetBalanceOfAccount("accountNumber2")).thenReturn(2000d);
		// instantiate the System Under Test (SUT)
		CoreService bankingCoreService =  new CoreService (emailSender,dataRepository,interBankingService);
		
		//act
				
		InternalTransferStatus transferStatus= bankingCoreService.TransferMoneyToAnotherAccount(transferAmount, from, to);
		
		//assert
		
		assertThat(transferStatus,is(InternalTransferStatus.Fraud));
	}
		
	
	/*
	 * Here we want to see what happens if an error occurs in the middle of email sending operation.
	 * In fact, we want to check how robust our method is against unexpected situations. 
	 * Look how we stubbed the mocked EmailSender with anyString() Matcher
	 * Exercise4: 
	 */
	
	@Test
	public void testFraudUnSuccessfulEmailToSecurityCenterExercise4() throws ConnectException {
		
		//arrange
		
		// define a fraud scenario
		Account from= new Account("accountNumber1");
		Account to= new Account("accountNumber2");
		double transferAmount= 1001;
				
		// mock external dependencies
		EmailSender emailSender = mock(EmailSender.class);
		DataRepository dataRepository = mock(DataRepository.class);
		InterBankingService interBankingService = mock(InterBankingService.class);
		// stub
		doThrow(new Exception()).when(emailSender).SendEmail(anyString(), anyString(), anyString());
		when(dataRepository.GetBalanceOfAccount("accountNumber1")).thenReturn(4000d);
		when(dataRepository.GetBalanceOfAccount("accountNumber2")).thenReturn(2000d);
		// instantiate the System Under Test (SUT)
		CoreService bankingCoreService =  new CoreService (emailSender,dataRepository,interBankingService);
			
		//act
					
		InternalTransferStatus transferStatus= bankingCoreService.TransferMoneyToAnotherAccount(transferAmount, from, to);
				
		//assert
		
		assertThat(transferStatus,is(InternalTransferStatus.Fraud));
		
	}
	
	
	/*
	 * Exercise5: Here we want to test whether the implemented method sends an email to security in case of fraud.
	 *  
	 */
	
	@Test
	public void testFraudEmailToSecurityCenterExercise5() {
		
		//arrange
		
		//act
		
		//assert
		
	}
	
	@Test
	public void testNoBalancePathExercise6() {
	
		//arrange
		
		//act
		
		//assert
		
	}
	


}
