package tutorial.core.banking;

import java.net.ConnectException;

public interface IEmailSender {

	void SendEmail(String emailAddress, String mailSubject, String mailBody) throws ConnectException;

}