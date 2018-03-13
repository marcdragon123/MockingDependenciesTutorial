package tutorial.core.banking;

import java.util.concurrent.TimeUnit;

public class Logger implements ILogger {

	/* (non-Javadoc)
	 * @see tutorial.core.banking.ILogger#log(java.lang.String)
	 */
	@Override
	public void log(String string) {
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
