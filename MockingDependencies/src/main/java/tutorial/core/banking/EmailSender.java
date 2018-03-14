package tutorial.core.banking;

import java.net.ConnectException;
import java.util.concurrent.TimeUnit;

/*
 *  This is an external Dependency
 */

public class EmailSender implements ExternalDependency {

	Logger logger=Logger.getInstance();
	
	public EmailSender() {
		
	}
	
	public void SendEmail(String emailAddress, String mailSubject, String mailBody) throws ConnectException {
		
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		logger.log("email sent");
		
	}

}
