package consistency.checking.contracts;

public interface INotifier {

	void notifyOnModifiedFile(String event);
	
	void notifyOnNewFile(String event);
	
	void notifyOnDeletedFile(String event);
}
