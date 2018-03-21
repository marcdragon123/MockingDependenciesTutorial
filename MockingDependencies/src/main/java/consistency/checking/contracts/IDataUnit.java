package consistency.checking.contracts;

public interface IDataUnit<TValue> {

	String getKey();
	
	TValue getValue();
	
	void setValue(TValue value);
}
