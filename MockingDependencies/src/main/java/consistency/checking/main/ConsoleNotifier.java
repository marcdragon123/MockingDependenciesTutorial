package consistency.checking.main;

import consistency.checking.contracts.INotifier;

public class ConsoleNotifier implements INotifier {

	@Override
	public void notifyOnModifiedFile(String event) {
		System.out.println("Integrity Violation on a modified file: " + event);
	}

	@Override
	public void notifyOnNewFile(String event) {
		System.out.println("Integrity Violation on a new file: " + event);
	}

	@Override
	public void notifyOnDeletedFile(String event) {
		System.out.println("Integrity Violation on a deleted file: " + event);
	}

}
