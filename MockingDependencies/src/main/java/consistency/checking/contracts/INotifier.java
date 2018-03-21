package consistency.checking.contracts;

public interface INotifier {

	void notifyOnViolationDetectedOnFile(String event);
	
	void notifyOnViolationDetectedOnDirectory(String event);
}
