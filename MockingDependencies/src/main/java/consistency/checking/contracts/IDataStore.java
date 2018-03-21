package consistency.checking.contracts;

public interface IDataStore<TDataUnit> {

	TDataUnit getDataUnit(String key);
	
	void store(TDataUnit unit);
	
}
