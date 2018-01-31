package tutorial.core.banking;

/*
 *  This is an external Dependency
 */
public class DataRepository implements ExternalDependency {

	public double GetBalanceOfAccount(String accountNumber) {
	
		// this method reads the balance amount from the database.
		
		return 0;
	}

	public void SetBalanceOfAccount(String accountNumber, double amount) {
		
		throw new UnsupportedOperationException("this feature is not implemented yet. another team is working on it"); 
	}

}
