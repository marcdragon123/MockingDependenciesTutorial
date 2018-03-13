package tutorial.core.banking;

import java.util.concurrent.TimeUnit;

/*
 *  This is an external Dependency
 */
public class DataRepository implements ExternalDependency, IDataRepository {

	private ILogger logger;
	
	public DataRepository(ILogger logger) {
		this.logger=logger;
	}
	
	/* (non-Javadoc)
	 * @see tutorial.core.banking.IDataRepository#GetBalanceOfAccount(java.lang.String)
	 */
	@Override
	public double GetBalanceOfAccount(String accountNumber) {
	
		// this method reads the balance amount from the database.
		// this operation is very slow and resource consuming. 
		// Using the actual implementation in unit test is not recommended,
		// because we want our unit tests to run very fast. 
		// This way we can test our software without losing any extra seconds
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	/* (non-Javadoc)
	 * @see tutorial.core.banking.IDataRepository#SetBalanceOfAccount(java.lang.String, double)
	 */
	@Override
	public void SetBalanceOfAccount(String accountNumber, double amount) {
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
