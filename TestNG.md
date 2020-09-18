### :dart:TestNG Group Annotation: <br> 
```
public class GroupingTests 
{
 @BeforeGroups
 public void login()
 {
 System.out.println("Login Sucessfully");
 }
 @AfterGroups
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
### :dart: Skip few cases Without using annotation 
Without using annotation , we can skip few cases in selenium testing by following the script in testng Suite

With Include Option:
```
<suite name = "Suite"> 
   <test name = "test">  
      <classes> 
         <class name = "TestClass"> 
			<methods> 
					<include name= "FirstCase"/> 
					<include name= "SecondCase"/> 
					<include name= "ThirdCase"/> 
			</methods> 
		</class> 
      </classes>    
   </test> 		 
</suite> 
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
 list.add("G:\\Git_Base_Folder\\softwaretestingblog\\Daily_Practice\\test-output\\testng-failed.xml");
 runner.setTestSuites(list);
 runner.run();
 }
}
```
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
### :dart:Get Webpage Links Using Selenium Example Program: <br> 
The maximum number of milliseconds this test should take for the cumulated time of all the invocationcounts. This attribute will be ignored if invocationCount is not specified.
```
public class TestNGInvocationcountTimeoutEx 
{
 @Test(invocationTimeOut=5)
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
##### Running testng-failed.xml file from Command line
if you have three test cases if all the test cases are executed successfully means you are not able to see this folder under the test-output folder. This folder will appear only when one of the test case is failed. Then run this file, it will going to run only failed test cases.
<br>
java –cp "path of lib folder present in workspace\*; path of bin folder present in project workspace; path of testing.jar file present in lib folder of project workspace" org.testng.TestNG test-output/testng-failed.xml
<br>
```
Java –cp "C:\Users\User\Desktop\Blitz\TestProject\lib\*;
C:\Users\User\Desktop\Blitz\TestProject\bin" org.testng.TestNG test-output/testng-failed.xml
```
```














