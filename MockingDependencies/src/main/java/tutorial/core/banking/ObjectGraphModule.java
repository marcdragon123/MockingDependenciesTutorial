package tutorial.core.banking;

import com.google.inject.AbstractModule;

public class ObjectGraphModule extends AbstractModule {

	@Override
	protected void configure() {
		
		bind(IDataRepository.class).to(DataRepository.class);
		bind(IEmailSender.class).to(EmailSender.class);
		Logger logger = new Logger(); // singleton logger
		bind(ILogger.class).toInstance(logger);
	}

}