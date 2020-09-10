# Java-Getting-Started
## HelloWorld Program Execution
~~~~~~~~
@src/
$ javac HelloWorld.java
$ java HelloWorld
  Hello World
~~~~~~~~ 
#Basic Java Application with package
~~~~
//Main and Person which are in package named hhuda.com. It accept environment variable(path), system property(user.name) and a argument.
//Set Environment Variable
$set name=hanuman(In Windows)
$export name=hanuman(In Unix) 
@src/
$javac hhuda/com/Main.java hhuda/com/Person.java
$java Main Java
Hello World! Java
Environment Property as Name : hanuman
System Property as Username : Hanuman
Person Name: hanuman, age : 22

~~~~~~~~

#Basic Java Application with Jar Deployment
~~~~
//Basic of Java programs and deploying simple application using java
@src/

//Compiles Java Classes
$javac hhuda/com/Main.java hhuda/com/Person.java

//Generate Jar file by adding menifest file
$jar cvfm ../JavaGettingStarted.jar ../JavaGettingStarted.mf hhuda/com/*.class

//Extract Jar file
$jar -xvf GettingStarted.jar

//Executing Program using Jar file
$java -jar ../JavaGettingStarted.jar Java
Hello World! Java
Environment Property as Name : hanuman
System Property as Username : Hanuman
Person Name: hanuman, age : 22

~~~~~~~~

#Basic Java Application with JUnit Test Cases
~~~~~~~~
//Compilation with dependencies
$src/
$javac -cp "../lib/*;." hhuda/com/DIDemoTest.java hhuda/com/DIDemo.java

//Run Test Case
java -cp "../lib/*;." org.junit.runner.JUnitCore DIDemoTest
~~~~~~~~