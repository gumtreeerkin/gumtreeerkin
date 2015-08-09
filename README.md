# gumtreeerkin
It is a simple java application which answers the questions in the gumtree code challange. 


# installation 
java 7 and maven is required to install the application run:

mvn clean install  assembly:single

This will compile the project,run the tests and  create a runnable jar file.

Project uses junit and jodatime libraries.

# to run the application
After the application is intalled simply run:

java -jar target/gumtreeerkin-1.0.0-SNAPSHOT-jar-with-dependencies.jar

It will show the answers on the screen. eg:

- How many males are in the address book?. The answer is=3
- Who is the oldest person in the address book?. The answer is=Person{name=Wes Jackson, gender=Male, birthday=Wed Aug 14 00:00:00 BST 1974}
- How many days older is Bill than Paul?. The answer is=2862

