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
### :TestNg Description Annotation: <br> 
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
public class ParameterEx 
{
 @Test
 @Parameters("myName") //This Values Comes From The Respective XML File
 //This Program Should Be Run From XML Not Here
 public void parameterTest(String myName) {
 System.out.println("Parameterized value is : " + myName);
 }
}
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
in beforeSuite

in beforeTest

in beforeClass

in beforeMethod

in test case 1

in afterMethod

in beforeMethod

in test case 2

in afterMethod

in afterClass

in afterTest

in afterSuite

Total tests run: 2, Failures: 0, Skips: 0

### :dart:Get Webpage Links Using Selenium Example Program: <br> 
```
```
### :dart:Get Webpage Links Using Selenium Example Program: <br> 
```
```
### :dart:Get Webpage Links Using Selenium Example Program: <br> 
```
```

