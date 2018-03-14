-# Mockito Tutorial	+# Dependency Injection & Dependency Inversion Tutorial
 	 
-The code contains a simple [banking example](https://github.com/mirsaeedi/MockingDependencies/tree/master/MockingDependencies/src/main/java/tutorial/core/banking) to transfer money from one account to another. There are also 6 [unit tests](https://github.com/mirsaeedi/MockingDependencies/tree/master/MockingDependencies/src/test/java/tutoria/core/banking/transfer/test) to check different corners of the domain logic. However, all of these tests are failing because of a bug in the production code or test code. Students should try to find the bugs and modify the code to fix the tests.	+* Clone the Repo
+* Checkout the branch dependency_injection
+* Import the gradle project into eclipse
+* Run the test 
+* We are using actual dependencies here instead of mocks.
+* it will take more that 12 seconds. But unit test should be super fast. 
+* We cannot mock CoreService’s dependencies, because they are highly coupled and hard-coded. (CoreService, EmailSender, DataRepository, Logger)
+* Refactor the code and make things decouple to make it easier to test.
+* After decoupling classes you need to modify the main method in Main.java
+* Instead of creating the dependencies by hand, use Guice to handle everything for you
+* In Guice’s module you need to define Logger as a singleton instance
 	 
-# Answers	
-	
-the answers to the exercises are in the branches of this repo.
