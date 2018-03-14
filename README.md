# Dependency Injection & Dependency Inversion Tutorial

* Clone the Repo
* Checkout the branch dependency_injection
* Import the gradle project into eclipse
* Run the test 
* We are using actual dependencies here instead of mocks.
* it will take more that 12 seconds. But unit test should be super fast. 
* We cannot mock CoreService’s dependencies, because they are highly coupled and hard-coded. (CoreService, EmailSender, DataRepository, Logger)
* Refactor the code and make things decouple to make it easier to test.
* After decoupling classes you need to modify the main method in Main.java
* Instead of creating the dependencies by hand, use Guice to handle everything for you
* In Guice’s module you need to define Logger as a singleton instance

