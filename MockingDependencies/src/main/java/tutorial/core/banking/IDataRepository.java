package tutorial.core.banking;

public interface IDataRepository {

	double GetBalanceOfAccount(String accountNumber);

	void SetBalanceOfAccount(String accountNumber, double amount);

}