# ThreadLocal in Selenium Java

This repository holds begineer code to help you understand how using ThreadLocal in Selenium Java for complex web automtion projects helps to build robust frameworks and execute them in parallel ensuring thread safety at the samme time.

## What is ThreadLocal?
In Java programming, ThreadLocal is a class that facilitates usage of thread local variables. This means, it allows the user to store data that is specific to a particular thread independently. Each thread that accesses a ThreadLocal variable, accesses its own unique copy of the variable, thus ensuring that changes made by any thread are specific to variables of that thread and does not affect the value of same variable in other thread.

## About Project
It is created using Selenium with Java, TestNG and Maven for Web-based automation to demonstrate usage of ThreadLocal.

This is the list of tools, being used in this framework:
1. Apache Maven
2. Java 8
3. TestNG Framework
4. Selenium WebDrvier

## Steps for Local Execution
1. Import this project in Eclipse/IntelliJ as “Existing Maven Project”
2. Execute any one of the testng.xml as per your requirement.
3. You can see the logs coming up on Console as your execution progresses.
