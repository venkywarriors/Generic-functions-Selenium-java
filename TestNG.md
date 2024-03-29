### :dart: What is the difference between @Factory and @Dataprovider annotations?
```
@Factory()
	public Object[] getTestClasses() {
		Object[] tests = new Object[2];
		tests[0] = new Test1();
		tests[1] = new Test2();
		return tests;
}
```
@Factory: The use of the factory annotation is when the tester needs to execute the test methods multiple times, which are present in the same class. Additionally, we achieve this by creating different instances of the same class.

@Dataprovider: The dataprovider annotation enables the tester to run a test method multiple times using a different set of data provided by the dataprovider.

### :dart: Define the correct order of tags in the TestNG XML file
```
<suite>
  <test>
    <classes>
   <class>
<methods>
```
### :dart: Annotations In JUnit and TestNG <br>
[Click here to read about TestNG Listeners](https://www.toolsqa.com/testng/testng-listeners/) <br>
[Click here to read about TestNG vs JUnit](https://www.toolsqa.com/testng/testng-vs-junit/)

| Feature                                 | JUnit 5                        | TestNG                               |
| ----------------------------------------|---------------------------------|--------------------------------------|
| Test annotation                         | `@Test`                         | `@Test`                              |
| Execute before the first test method in the current class is invoked. | `@BeforeAll`                    | `@BeforeClass`                       |
| Execute after all the test methods in the current class have been run. | `@AfterAll`                     | `@AfterClass`                        |
| Execute before each test method         | `@BeforeEach`                   | `@BeforeMethod`                      |
| Execute after each test method          | `@AfterEach`                    | `@AfterMethod`                       |
| Ignore Test                             | `@Ignore`                       | `@Test(enabled = false)`             |
| Expected exception                      | `@Test(expected=ArithmeticException.class)` | `@Test(expectedException=ArithmeticException.class)` |
| Timeout                                 | `@Test(timeout = 1000)`         | `@Test(timeout = 1000)`              |
| Groups tests for configuration and execution                                 | `@tag("group")`         | `@Test(groups = "group1")`              |
| Execute before all tests in this suite have run | N/A                         | `@BeforeSuite`                       |
| Execute after all tests in this suite have run. | N/A                        | `@AfterSuite`                        |
| Execute before the test                 | N/A                             | `@BeforeTest`                        |
| Execute after the test                  | N/A                             | `@AfterTest`                         |
| Run a given test method multiple times                  | `@RepeatedTest(5)`                           | `@Test(invocationCount = 5)`                         |
| Oorder of test method execution                  | @TestMethodOrder annotation with MethodOrderer.OrderAnnotation.class allows ordering `@Order(1)`                            | `@Test(priority = 1)`                         |
| Execute before the first test method that belongs to any of these groups is invoked | N/A | `@BeforeGroups`                    |
| Execute after the last test method that belongs to any of these groups is invoked | N/A | N/A                                |

Click this link to view <a href="https://github.com/venkywarriors/Generic-functions-Selenium-java/blob/master/Junit.md" title="Click here to view Junit Sample Programs">*Junit Sample Programs* </a><br>
### :dart:TestNG Parallel Execution: <br> 
There are different ways to achieve parallel execution in TestNG, such as parallel execution of methods, classes, or suites. The TestNG has a default value of thread = 5 for parallel testing. To run them parallelly, head over to the testng.xml file, and write the following code:
```
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd" >
<suite name = "Parallel Testing Suite">
   <test name = "Parallel Tests" parallel = "methods">
      <classes>
         <class name = "ParallelTest" />
      </classes>
   </test>
</suite>
```
Methods: This will run the parallel tests on all @Test methods in TestNG.
Tests: All the test cases present inside the <test> tag will run with this value.
Classes: All the test cases present inside the classes that exist in the XML will run in parallel.
Instances: This value will run all the test cases parallelly inside the same instance.
```
The function that returns the thread id is Thread.currentThread().getId() method as in the following code snippet:
```
Mention the thread-count inside the XML file.
```
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd" >
<suite name = "Parallel Testing Suite">
   <test name = "Parallel Tests" parallel = "methods" thread-count = "2">
      <classes>
         <class name = "ParallelTest" />
      </classes>
   </test>
</suite>

```
In this approach, entire test suites are executed in parallel.
```
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
<suite name="Parallel Testing Suite" parallel="tests" thread-count="2">
    <test name="Test1">
        <classes>
            <class name="path.to.TestClass1" />
        </classes>
    </test>
    <test name="Test2">
        <classes>
            <class name="path.to.TestClass2" />
        </classes>
    </test>
</suite>
```
### :dart:TestNG Group Annotation: <br> 
```
public class GroupingTests 
{
 @BeforeGroups("Test1")
 public void login()
 {
 System.out.println("Login Sucessfully");
 }
 @AfterGroups("Test1")
 public void logout()
 {
 System.out.println("Logout Sucessfully");
 }
 @Test(groups={"Test1"})
 public void FundTransfer()
 {
 System.out.println("Fund Transfer");
 }
 @Test(groups={"Test1","Test2"})
 public void search()
 {
 System.out.println("Search Sucessfully");
 }
 @Test(groups="Test2")
 public void bill()
 {
 System.out.println("Bill Generated");
 }
}
```
```
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="TestSuite">
    <test name="Test">
        <groups>
            <run>
                <include name="groupA" />
            </run>
        </groups>
        <classes>
            <class name="path.to.TestClassA" />
            <class name="path.to.TestClassB" />
        </classes>
    </test>
</suite>

```
Running TestNG suite in parallel with groups involves specifying the parallel attribute in the TestNG XML file along with specifying the groups that should be executed in parallel
```
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
<suite name="Parallel Group Testing Suite" parallel="methods" thread-count="2">
    <test name="GroupTests">
        <groups>
            <run>
                <include name="group1" />
                <include name="group2" />
            </run>
        </groups>
        <classes>
            <class name="path.to.TestClass1" />
            <class name="path.to.TestClass2" />
        </classes>
    </test>
</suite>
```
### :dart:TestNG AlwaysRun Annotation : <br> 
```
public class AlwaysRunExample 
{
 @Test(alwaysRun=true)
 public void method1()
 {
 System.out.println("Inside Method 1");
 }
 @Test(alwaysRun=false)
 public void method2()
 {
 System.out.println("Inside Method 1");
 }
}
```
### :dart: Skip few cases Without using annotation/Using preserve-order in the testng.xml file
Without using annotation , we can skip few cases in selenium testing by following the script in testng Suite

With Include Option:
```
<test name="OrderedTestNGTests" preserve-order="true">
	<classes>
		<class name="TestNGTestClass">
			<methods>
				<include name="testOne" />
				<include name="testTwo" />
			</methods>
		</class>
	</classes>
</test>
```
With Exclude Option:
```
<suite name = "Suite">  
   <test name = "test">    
      <classes> 
         <class name = "TestClass"> 
			<methods> 
					<exclude name= "FourthCase"/> 
					<exclude name= "FifthCase"/> 
			</methods> 
		</class> 
      </classes>    
   </test> 		 
</suite> 
```
### :dart:TestNG Dependson Annotation: <br> 
In this example, search depends on the successful execution of login. If login fails, search will be skipped. If login passes, search will be executed.
```
public class DependsonTest
{
 @Test
 public void login()
 {
 System.out.println("Login");
 }
 @Test(dependsOnMethods="login")
 public void search()
 {
 System.out.println("Search");
 Assert.assertEquals("Manoj", "Monoj");
 }
 @Test(dependsOnMethods="search")
 public void advsearch()
 {
 System.out.println("Adv Search");
 }
 @Test(dependsOnMethods="advsearch")
 public void logout()
 {
 System.out.println("Logout");
 }
}
```
```
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd" >
<suite name="TestNG XML Dependency Suite" >
   <test name="ToolsQA" >
   	<groups>
   		<dependencies>
   			<group depends-on= "openbrowser" name= "login"></group>
   		</dependencies>
   		</groups>
       <classes> 
          <class name="GroupDependency" />
       </classes>
   </test>
 </suite>
```
### :dart:TestNg Description Annotation: <br> 
```
public class TestNg_Description 
{
 @Test(description="Simple TestNG Program")
 public void show()
 {
 System.out.println("Hi Method");
 }
}
```
### :dart:Rerun Failed test cases TestNG By Programmatically: <br> 
```
public class RerunFailedtestcases 
{
 public static void main(String[] args) 
 {
 TestNG runner=new TestNG();
 List <String> list=new ArrayList<String>();
 list.add("G:\\Git_Base_Folder\\softwaretestingblog\\Daily_Practice\\test-output\\testng-failed.xml"); //Path of failed testng xml file under test-output folder
 runner.setTestSuites(list);
 runner.run();
 }
}
```
### :dart:Re-Run Failed Test Cases Using TestNG in Selenium WebDriver: <br> 
Create a class to implement IRetryAnalyzer. The steps are explained further below.

```
package Analyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private int retryCnt = 0;
    private int maxRetryCnt = 2; //You could mentioned maxRetryCnt (Maximiun Retry Count) as per your requirement.
 /*
 * (non-Javadoc)
 * @see org.testng.IRetryAnalyzer#retry(org.testng.ITestResult)
 * 
 * This method decides how many times a test needs to be rerun.
 * TestNg will call this method every time a test fails. So we 
 * can put some code in here to decide when to rerun the test.
 * 
 * Note: This method will return true if a tests needs to be retried
 * and false it not.
 *
 */
    public boolean retry(ITestResult result) {
        if (retryCnt < maxRetryCnt) {
            System.out.println("Retrying " + result.getName() + " again and the count is " + (retryCnt+1));
            retryCnt++;
            return true;
        }
        return false;
    }
   
}
```
There are two ways to include retry analyser in your tests
By specifying retryAnalyzer value in the @Test annotation
By adding Retry analyser during run time by implementing on the of the Listener interfaces

#### First way Specifying retryAnalyzer attribute in the @Test annotation
We can do this by simply using following syntax to @Test(retryAnalyzer=”IRetryAnalyzer Implementing class”). Below is the code to do that
```
import org.testng.Assert;
import org.testng.annotations.Test;
 
public class Test001 {
 
 @Test(retryAnalyzer = Analyzer.RetryAnalyzer.class)
 public void Test1()
 {
 Assert.assertEquals(false, true);
 }
 
 @Test
 public void Test2()
 {
 Assert.assertEquals(false, true);
 }
}
```
#### Second way of adding retryAnalyzer to your test.
Specifying retryAnalyzer during runtime. Create another class ‘RetryListenerClass’ by Implementing ‘IAnnotationTransaformer’ interface. transform method is called for every test during test run. A simple implementation of this ‘IAnnotationTransformer’ interface can help us set the ‘setRetryAnalyzer’ for ‘ITestAnnotation’. Add the above class name (RetryAnalyzer.class) in the below program. This interface does its work in run time by adding annotation to the test methods.
```
package Analyzer;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
 
import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;
 
public class AnnotationTransformer implements IAnnotationTransformer {
 
@Override
public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
	annotation.setRetryAnalyzer(RetryAnalyzer.class);
}
}
}
``` 
Once we have the implementation of IAnnotationTransformer, we just need to add it as a listener in the testng run xml. Like this
``` 
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd" >

<suite name="RetryFailedTests" verbose="1" >
 <listeners>
        <listener class-name="Analyzer.AnnotationTransformer"/>
  </listeners>
  <test name="RetryMulitple">
    <classes>
      <class name="Tests.Test001"/>
    </classes>
  </test>
</suite>
```
### :dart:Retry Failed tests in TestNG using Custom Java Annotation <br>
Lets say the name of the annotation is RetryCountIfFailed. This annotation is a pure Java annotation
```
package CustomAnnotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface RetryCountIfFailed  {

	// Specify how many times you want to 
	// retry the test if failed.
	// Default value of retry count is 0
	int value() default 0;
}
```
You can see that there is only one variable "value" inside the RetryCountIfFailed annotation. This value specifies how many times a test needs to be re-executed in case of failures. Note that the default value is set to 0. Also, one key point to note is that its a runtime annotation. 
```
@Retention(RetentionPolicy.RUNTIME)
```
#### Use the Custom Created Java Annotation in TestNG Automation Test
```
package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import CustomAnnotations.RetryCountIfFailed;

public class Test001 {

	@Test
	@RetryCountIfFailed(10)
	public void Test1()
	{
		Assert.assertEquals(false, true);
	}

	@Test
	public void Test2()
	{
		Assert.assertEquals(false, true);
	}
}
```
#### Implement IRetryAnalyzer to Retry Failed Test in TestNG Framework <br>
Check if the Test method for which retry is called has RetryCountIfFailed annotation, Then compare current retry attempt with value of this annotation.
Here is the new implementation of RetryAnalyzer Class
```

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import CustomAnnotations.RetryCountIfFailed;

public class RetryAnalyzer implements IRetryAnalyzer {

	int counter = 0;
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.testng.IRetryAnalyzer#retry(org.testng.ITestResult)
	 * 
	 * This method decides how many times a test needs to be rerun. TestNg will
	 * call this method every time a test fails. So we can put some code in here
	 * to decide when to rerun the test.
	 * 
	 * Note: This method will return true if a tests needs to be retried and
	 * false it not.
	 *
	 */

	@Override
	public boolean retry(ITestResult result) {

		// check if the test method had RetryCountIfFailed annotation
		RetryCountIfFailed annotation = result.getMethod().getConstructorOrMethod().getMethod()
				.getAnnotation(RetryCountIfFailed.class);
		// based on the value of annotation see if test needs to be rerun
		if((annotation != null) && (counter < annotation.value()))
		{
			counter++;
			return true;
		}
		return false;
	}
}
```
This way retry decision is taken based on the count specified in the RetryCountIfFailed annotation <br>
### :dart:Run Test Multiple Times Using TestNG: <br> 
```
public class RunTestMultipleTime 
{
 @Test(invocationCount=10)
 public void display()
 {
 System.out.println("Manoj");
 }
 @Test
 public void display1()
 {
 System.out.println("Manoj1");
 }
}
```
```
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="YourTestSuite">
    <test name="YourTest" invocationCount="3">
        <classes>
            <class name="path.to.YourTestClass" />
        </classes>
    </test>
</suite>
```
### :dart:TestNG Priority Annotation: <br> 
```
public class PriorityTest
{
 @Test(priority=1)
 public void login()
 {
 System.out.println("Login");
 }
 @Test(priority=2)
 public void search()
 {
 System.out.println("Search");
 Assert.assertEquals("Manoj", "Monoj");
 }
 @Test(priority=3)
 public void advsearch()
 {
 System.out.println("Adv Search");
 }
 @Test(priority=4)
 public void logout()
 {
 System.out.println("Logout");
 }
}
```
### :dart:Parameter TestNG Example Program: <br> 
```
public class TestParameters {
	
	@Parameters({ "browser" })
	@Test
	public void testCaseOne(String browser) {
		System.out.println("browser passed as :- " + browser);
	}

	@Parameters({ "username", "password" })
	@Test
	public void testCaseTwo(String username, String password) {
		System.out.println("Parameter for User Name passed as :- " + username);
		System.out.println("Parameter for Password passed as :- " + password);
	}
}
```
The below is the testng.xml file, in which we need to pass the parameter values for the test method
```
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="Parameterization Test Suite">
	<test name="Testing Parameterization">
	<parameter name="browser" value="Firefox"/>
	<parameter name="username" value="testuser"/>
	<parameter name="password" value="testpassword"/>
		<classes>
			<class name="com.parameterization.TestParameters" />
		</classes>
	</test>
</suite>
```
Parameterize @BeforeMethod method in TestNG <br> 
```
public class AppTest {
    @Parameters({"par1", "par2"})
    @BeforeMethod()
    public void setUp(String a, String b) {
        System.out.println("a = [" + a + "], b = [" + b + "]");
    }

    @Test
    public void testApp() {
    }
}
```
```
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
<suite name="Suite1" verbose="1" >

    <test name="Run1" >
        <parameter name="par1"  value="val"/>
        <parameter name="par2"  value="anotherval"/>
        <packages>
            <package name="dummy.java" />
        </packages>
    </test>

    <test name="Run2" >
        <parameter name="par1"  value="newValue"/>
        <parameter name="par2"  value="yetAnotherVal"/>
        <packages>
            <package name="dummy.java" />
        </packages>
    </test>
</suite>
```
### :dart:TestNg ExpectedException Annotation: <br> 
```
public class TestNg_ExpectedException 
{
 @Test (expectedExceptions=ArithmeticException.class)
 public void show()
 {
 //System.out.println("Hi Method");
 int a=10/0;
 System.out.println(a);
 }
}
```
### :dart:timeOut attribute of the @Test annotation.: <br> 
The maximum number of milliseconds this test should take for the cumulated time of all the invocationcounts. This attribute will be ignored if invocationCount is not specified.
```
public class TestNGInvocationcountTimeoutEx 
{
 @Test(invocationTimeOut=5000) // Timeout in milliseconds 
 public void test()
 {
 System.out.println("The Value Of I"); 
 } 
}
```
### :dart:Ignore Test enabled Annotation: <br> 
Whether methods on this class/method are enabled. 
```
public class IgnoreTest {
   String message = "Manisha";
   MessageUtil messageUtil = new MessageUtil(message);

   @Test(enabled = false)
   public void testPrintMessage() {
      System.out.println("Inside testPrintMessage()");
      message = "Manisha";
      Assert.assertEquals(message, messageUtil.printMessage());
   }

   @Test(enabled = true)
   public void testSalutationMessage() {
      System.out.println("Inside testSalutationMessage()");
      message = "Hi!" + "Manisha";
      Assert.assertEquals(message, messageUtil.salutationMessage());
   }
}
```
Now, when you combine both attributes (enabled = false, alwaysRun = true), it results in a somewhat contradictory scenario. The test method is disabled (enabled = false), so TestNG won't execute it under normal circumstances. However, because of alwaysRun = true, if this method is a dependency for other methods and those dependencies fail, TestNG will still attempt to run this method.
### :dart:TestNG Annotation Execution Flow: <br> 
```
public class TestngAnnotation { 

// test case 1
@Test
public void testCase1() { 
System.out.println("in test case 1"); 
} 

// test case 2
@Test 
public void testCase2() { 
System.out.println("in test case 2"); 
}
 
@BeforeMethod
public void beforeMethod() {
System.out.println("in beforeMethod");
}
 
@AfterMethod
public void afterMethod() {
System.out.println("in afterMethod");
}
 
@BeforeClass
public void beforeClass() {
System.out.println("in beforeClass");
}
 
@AfterClass
public void afterClass() {
System.out.println("in afterClass");
}
 
@BeforeTest 
public void beforeTest() {
System.out.println("in beforeTest");
}
 
@AfterTest
public void afterTest() {
System.out.println("in afterTest");
}
 
@BeforeSuite
public void beforeSuite() {
System.out.println("in beforeSuite");
}
 
@AfterSuite
public void afterSuite() { 
System.out.println("in afterSuite");
} 
}
```
The output:<br>

in beforeSuite<br>
in beforeTest<br>
in beforeClass<br>
in beforeMethod<br>
in test case 1<br>
in afterMethod<br>
in beforeMethod<br>
in test case 2<br>
in afterMethod<br>
in afterClass<br>
in afterTest<br>
in afterSuite<br>

Total tests run: 2, Failures: 0, Skips: 0 <br>
### :dart:Including and excluding groups: <br> 
TestNG also allows you to include and exclude certain groups from test execution. This helps in executing only a particular set of tests and excluding certain tests. A simple example can be when a feature is broken and you need to exclude a fixed set of tests from execution since these test will fail upon execution. Once the feature is fixed you can then verify the feature by just executing the respective group of tests.<br>
Let’s create a sample program and learn how to exclude a group of tests.
```
public class ExcludeGroupTest
{
    @Test(groups = { "include-group" })
    public void testMethodOne() {
        System.out.println("Test method one belonging to include group.");
    }
 
    @Test(groups = { "include-group" })
    public void testMethodTwo() {
        System.out.println("Test method two belonging to include group.");
    }
 
    @Test(groups = { "include-group", "exclude-group" })
    public void testMethodThree() {
        System.out.println("Test method three belonging to exclude/include groups.");
    }
}
```
The preceding class contains three test methods that print a message onto console when executed. All the three methods belong to a group include-group whereas the testMethodThree() method also belongs to the group exclude-group.
```
<suite name="Exclude Group Suite" verbose="1">
  <test name="Exclude Group Test">
    <groups>
      <run>
        <include name="include-group" />
        <exclude name="exclude-group" />
      </run>
    </groups>
    <classes>
      <class name="com.howtodoinjava.groupExamples.ExcludeGroupTest" />
    </classes>
  </test>
</suite>
```
Now run above testng.xml file and it will produce below result.
```
Test method one belonging to include group.
Test method two belonging to include group.
 
===============================================
Exclude Group Suite
Total tests run: 2, Failures: 0, Skips: 0
===============================================
```
##### Using regular expressions in groups: <br> 
testng.xml file.
```
<suite name="Regular Exp. Group Suite" verbose="1">
  <test name="Regular Exp. Test">
    <groups>
      <run>
        <include name="include.*" />
        <exclude name=".*exclude" />
      </run>
    </groups>
    <classes>
      <class name="com.howtodoinjava.groupExamples.RegularExpressionGroupTest" />
    </classes>
  </test>
</suite>
```
Now run the testng.xml file and you will get below result in console.
```
Test method one
Test method two
 
===============================================
Regular Exp. Group Suite
Total tests run: 2, Failures: 0, Skips: 0
===============================================
```
##### Tests belonging to multiple Groups
```
import org.testng.annotations.Test;  
public class Groups {  
@Test(groups= {"Group A"})  
public void testcase1()   
{  
System.out.println("Test case belonging to Group A");  
}  
@Test(groups= {"Group A","Group B"})  
public void testcase2()   
{  
System.out.println("Test case belonging to both Group A and Group B");  
}  
@Test(groups= {"Group B"})  
public void testcase3()   
{  
System.out.println("Test case belonging to Group B");  
}  
}  
```
```
<?xml version="1.0" encoding="UTF-8"?>  
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">  
<suite name="test_suite">  
<test name="Group A">  
<groups>  
<run>  
<include name="Group A"/>  
</run>  
</groups>  
<classes>  
<class name="com.javatpoint.Groups"/>  
</classes>  
</test> <!-- Test -->  
<test name="Group B">  
<groups>  
<run>  
<include name="Group B"/>  
</run>  
</groups>  
<classes>  
<class name="com.javatpoint.Groups"/>  
</classes>  
</test> <!-- Test -->  
</suite> <!-- Suite -->  
```
```
Test case belonging to Group A
Test case belonging to both Group A and Group B
Test case belonging to both Group A and Group B
Test case belonging to Group B
 
===============================================
Group of group Suite
Total tests run: 2, Failures: 0, Skips: 0
===============================================
```
##### Group of groups or ‘MetaGroups’: <br> 
Let’s create a sample test program and learn how to create group of groups called MetaGroups.
```
package com.howtodoinjava.groupExamples;
 
import org.testng.annotations.Test;
 
public class RegularExpressionGroupTest
{
    @Test(groups = { "include-test-one" })
    public void testMethodOne() {
        System.out.println("Test method one");
    }
 
    @Test(groups = { "include-test-two" })
    public void testMethodTwo() {
        System.out.println("Test method two");
    }
 
    @Test(groups = { "test-one-exclude" })
    public void testMethodThree() {
        System.out.println("Test method three");
    }
 
    @Test(groups = { "test-two-exclude" })
    public void testMethodFour() {
        System.out.println("Test method Four");
    }
}
```
Now create testng.xml file like below:
```
<suite name="Group of group Suite" verbose="1">
  <test name="Group of group Test">
    <groups>
      <define name="include-group">
        <include name="include-test-one" />
        <include name="include-test-two" />
      </define>
      <define name="exclude-group">
        <include name="test-one-exclude" />
        <include name="test-two-exclude" />
      </define>
      <run>
        <include name="include-group" />
        <exclude name="exclude-group" />
      </run>
    </groups>
    <classes>
      <class name="com.howtodoinjava.groupExamples.RegularExpressionGroupTest" />
    </classes>
  </test>
</suite>
```
Here two groups of groups have been defined inside the test, and then these groups are used for test execution. The MetaGroup is created using the define tag inside the groups tag. The name of the new group is defined using the name attribute under the define tag. Groups are included and excluded from the new group by using the include and exclude tags.
Now run the testng.xml test and it will produce below result in console:
```
Test method one
Test method two
 
===============================================
Group of group Suite
Total tests run: 2, Failures: 0, Skips: 0
===============================================
```
### :dart:TestNG SoftAssert and HardAssert: <br> 
```
	@Test
	public void testCaseOne() {
		System.out.println("*** test case one started ***");
		Assert.assertEquals(5, 5, "First hard assert failed");
		System.out.println("hard assert success....");
		Assert.assertTrue("Hello".equals("hello"), "Second hard assert failed");
		System.out.println("*** test case one executed successfully ***");
	}

	@Test
	public void testCasetwo() {
		SoftAssert softAssert = new SoftAssert();
		System.out.println("*** test case two started ***");
		softAssert.assertEquals("Hello", "Hello", "First soft assert failed");
		System.out.println("hard assert success....");
		softAssert.assertTrue("Hello".equals("hello"), "Second soft assert failed");
		softAssert.assertTrue("Welcome".equals("welcomeeee"), "Third soft assert failed");
		System.out.println("*** test case two executed successfully ***");
		softAssert.assertAll();
	}
```
Once you execute the above code, you should see output something like below : -
```
[RemoteTestNG] detected TestNG version 6.14.3
*** test case one started ***
hard assert success....
*** test case two started ***
hard assert success....
*** test case two executed successfully ***
FAILED: testCaseOne
java.lang.AssertionError: Second hard assert failed expected [true] but found [false]
```
Points to remember : - <br> 
1. We should instantiate a SoftAssert object within a @Test method. Scope of SoftAssert should only be within the Test method as seen the above example. <br> 
2. We should never use the same Soft Assertions with multiple test cases. In the below example, we are using the same object of SoftAssert class with multiple test cases and see the result which includes multiple test cases.
### :dart:TestNG DataProviders: <br> 
```
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
 
public class DProvider {
 @DataProvider (name = "data-provider")
 public Object[][] dpMethod(){
 return new Object[][] {{2, 3 , 5}, {5, 7, 9}};
 }
 
   @Test (dataProvider = "data-provider")
     public void myTest (int a, int b, int result) {
         int sum = a + b;
         Assert.assertEquals(result, sum);
     }
}
```
##### Inherited DataProvider In TestNG <br>
@Test file below :
```
public class DataProvider {
	  @Test (dataProvider = "data-provider", dataProviderClass = DP.class)
	    public void myTest (String val) {
	        System.out.println("Current Status : " + val);
	    }
}
```
DP.java looks like this
```
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DP
{
	@DataProvider (name = "data-provider")
	public Object[][] dpMethod(){
		return new Object[][] {{"Value Passed"}};
	}  
}
```
##### Read data from Excel to DataProvider
```
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
 
public class ExcelToDataProvider {
     
    String xlFilePath = "/KRISHNA VOLUME/Jar Files/poi-3.16-beta1/TestData.xlsx";
    String sheetName = "Credentials";
    ExcelApiTest eat = null;
     
    @Test(dataProvider = "userData")
    public void fillUserForm(String userName, String passWord, String dateCreated, String noOfAttempts, String result)
    {
       System.out.println("UserName: "+ userName);
       System.out.println("PassWord: "+ passWord);
       System.out.println("DateCreated: "+ dateCreated);
       System.out.println("NoOfAttempts: "+ noOfAttempts);
       System.out.println("Result: "+ result);
       System.out.println("*********************");
    }    
     
    @DataProvider(name="userData")
    public Object[][] userFormData() throws Exception
    {
        Object[][] data = testData(xlFilePath, sheetName);
        return data;
    }
     
    public Object[][] testData(String xlFilePath, String sheetName) throws Exception
    {
        Object[][] excelData = null;
        eat = new ExcelApiTest(xlFilePath);
        int rows = eat.getRowCount(sheetName);
        int columns = eat.getColumnCount(sheetName);
                 
        excelData = new Object[rows-1][columns];
         
        for(int i=1; i<rows; i++)
        {
            for(int j=0; j<columns; j++)
            {
                excelData[i-1][j] = eat.getCellData(sheetName, j, i);
            }
             
        }
        return excelData;
    }
}
```
### :dart:Run All Test Classes in a Package from testng.xml Suite: <br> 
```
<suite name="Suite1" verbose="1">
    <test name="all-tests">
        <packages>
            <package name="io.devqa.tests.ui"/>
        </packages>
    </test>
</suite>
```
##### If you need to run all tests from multiple packages, you can use:
```
<suite name="Suite2" verbose="1">
    <test name="all-tests">
        <packages>
            <package name="io.devqa.tests.ui"/>
            <package name="io.devqa.tests.api"/>
        </packages>
    </test>
</suite>
```
### :dart:Run testng.xml via cmd prompt <br> 
java –cp "path of lib folder present in workspace\*; path of bin folder present in project workspace; path of testng.jar file present in lib folder of project workspace" org.testng.TestNG testng.xml

but for our project you need to write the following command.
```
Java –cp  "C:\Users\User\Desktop\Blitz\TestProject\lib\*;
  C:\Users\User\Desktop\Blitz\TestProject\bin" org.testng.TestNG testng.xml
```
### :dart:How To Use Soft Assert In TestNG 
```
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
 
public class SoftAssertion {
 
@Test
public void softAssert(){
SoftAssert softAssertion= new SoftAssert();
System.out.println("softAssert Method Was Started");
softAssertion.assertTrue(false);
System.out.println("softAssert Method Was Executed");
softAssertion.assertAll();
}
@Test
public void hardAssert(){
System.out.println("hardAssert Method Was Started");
Assert.assertTrue(false);
System.out.println("hardAssert Method Was Executed");
}
}
```
### :dart: what is verbose in testng.xml
<a href="http://seleniumworks.blogspot.com/2014/01/testng-verbose-attribute-selenium-users.html?m=1
">Verbose Attribute </a>lets you obtain clear reports through IDE console. This attribute will be placed inside the <Suite> tag of testng.xml as shown below
<img src="http://1.bp.blogspot.com/-6VeGziyKtYI/UZs9AcKhB2I/AAAAAAAATrc/1tHdY9ihZdI/s1600/1.jpg" alt="Flowers in Chania">
### :dart: Rerun failed test cases after the completion of the entire suite
#### Create a Custom Reporter Class (RetryReporter):

Create a class that implements the IReporter interface. This class will be responsible for identifying failed test cases and rerunning them after the suite has completed.
```
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestNG;
import org.testng.xml.XmlSuite;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RetryReporter implements IReporter {

    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        for (ISuite suite : suites) {
            Map<String, ISuiteResult> results = suite.getResults();
            for (ISuiteResult suiteResult : results.values()) {
                ITestContext testContext = suiteResult.getTestContext();
                rerunFailedTests(testContext.getFailedTests().getAllResults());
            }
        }
    }

    private void rerunFailedTests(List<ITestResult> failedTests) {
        List<Class<?>> classesToRerun = new ArrayList<>();

        for (ITestResult failedTest : failedTests) {
            ITestContext failedTestContext = failedTest.getTestContext();
            Class<?> testClass = failedTestContext.getCurrentXmlTest().getClasses().get(0).getSupportClass();
            classesToRerun.add(testClass);
        }

        if (!classesToRerun.isEmpty()) {
            rerunTests(classesToRerun);
        }
    }

    private void rerunTests(List<Class<?>> classesToRerun) {
        TestNG reRunTestNG = new TestNG();
        reRunTestNG.setTestClasses(classesToRerun.toArray(new Class<?>[0]));

        Reporter.log("Rerunning failed tests...");

        reRunTestNG.run();
    }
}
```
In the RetryReporter class, the generateReport method is called after the suite has completed. It then calls the rerunFailedTests method to identify failed test cases and the corresponding test classes. The rerunTests method creates a new TestNG instance, sets the test classes to rerun, and runs the tests again.

#### Modify TestNG XML to Include RetryReporter:
```
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="YourTestSuite">
    <listeners>
        <listener class-name="path.to.RetryReporter"/>
    </listeners>
    <!-- Include your test classes and configurations here -->
</suite>
```
Replace path.to.RetryReporter with the actual package path to your RetryReporter class.

Create a Test Class (YourTestClass):
```
import org.testng.annotations.Test;
import org.testng.Assert;

public class YourTestClass {

    @Test
    public void testPass() {
        Assert.assertTrue(true);
    }

    @Test
    public void testFail() {
        Assert.fail("Intentional failure");
    }

    @Test
    public void testAnotherPass() {
        Assert.assertTrue(true);
    }
}
```
After the initial run, the RetryReporter will identify the failed tests and rerun them.
