package consistency.checking.contracts;

public interface IHashGenerator<TValue> {

	String hash(TValue dataUnit);
	
}
