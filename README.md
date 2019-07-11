Transaction Management

Technology Used :
Java 1.8
Maven

Java application to read and process the data from the csv file and convert to the TransactionRecord to Filter and Process the Transaction.


Input :
AccountNumber,From(Date&Time) ,To (Date&Time)

Main Class :
src/main/java/com/assignment/transactionmanagment/App.java is the handler class that calls TransactionProcessor to run the application.

TestCase :
src/test/java/com/assignment/transactionmanagment/AppTest.java
 1. testDefaultTestCase() : Runs the test on the sample data provided in the example.
 2. testPaymentTransactions() :Run the test on the Payment Transactions.
 3. testReversalTransactions(): Run the test on the Payment and Reversal Transactions.

ConfigFile :
src/main/resources/config.properties
Config.properties contains the transFilePath that has the file path of the InputFile.
TransactionDetails.csv contains in the package by default.
External Input File can be used by providing the FilePath in the transFilePath property in config.properties.

TransactionProcessor.java : Main business logic that calls other classes to Read,Filter and Process the transaction to calculate the Relative Balance.
TransactionReader.java : Reader class to read the data from input csv file.
TransactionUtil.java : Util class containing common method to be used across the application.
TransactionRecord.java : POJO class to contain a transaction.
TransactionConstants.java : Constants defined .
ConfigProperties.java : Reads the config file.
