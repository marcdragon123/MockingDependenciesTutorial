package tutorial.core.banking;

import java.net.ConnectException;
import java.util.concurrent.TimeUnit;

import com.google.inject.Inject;

/*
 *  This is an external Dependency
 */

public class EmailSender implements ExternalDependency, IEmailSender {

	
	private ILogger logger;

	@Inject
	public EmailSender(ILogger logger) {
		this.logger=logger;
	}
	
	/* (non-Javadoc)
	 * @see tutorial.core.banking.IEmailSender#SendEmail(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
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
