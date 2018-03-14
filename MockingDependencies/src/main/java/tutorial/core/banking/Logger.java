package tutorial.core.banking;

import java.util.concurrent.TimeUnit;

public class Logger {

	// singleton instance
	private static Logger instance=null;
	
	public static Logger getInstance() {
		
		if(instance==null)
			instance=new Logger();
		
		return instance;
		
	}
	
	private Logger() {
		
	}
	
	public void log(String string) {
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
