package consistency.checking.main;

import consistency.checking.contracts.INotifier;

public class ConsoleNotifier implements INotifier {

	@Override
	public void notifyOnViolationDetectedOnFile(String event) {
		System.out.println("Integrity Violation on a file: " + event);
	}

	@Override
	public void notifyOnViolationDetectedOnDirectory(String event) {
		System.out.println("Integrity Violation on a dir: " + event);
	}

}
