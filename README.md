# Logging Tutorial

* log4j log levels are: Trace < Debug < Info < Warn < Error < Fatal
* A good logging should provides us with the exact answers for *WHO, WHAT, WHEN* questions. Otherwise it's simple useless logging. You can learn about this on [DZONE](https://dzone.com/articles/application-logging-what-when) and [OWASP](https://www.owasp.org/index.php/Logging_Cheat_Sheet) websites.




1. Set the Root Logger to use the defined ConsoleAppender. So, you can see the logs inside the console. Then, run the main method inside tutorial.core.banking package to see the logs.
2. Enrich the logs, by adding additional fields to the PatternLayout of ConsoleAppender. So, we can diagnose our application more easily. Add Log Level,Date, Mehtod Name, Class Name, Line Number, and Thread Name to the pattern layout. You can use log4j documents.
3. Logging in wild should help us to answer What, When, Who questions. So, usually we need to enrich our logs with some information about the context of the application. For example, for each log we need to know the username, the ip address, the requested url and the session id. Use the current HttpContext to add contextual logging to your logs.
