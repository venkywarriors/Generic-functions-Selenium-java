# Creating extent reports in selenium webdriver 
### Extent Reports are the most popular reporting used with Selenium. Extent Reports is a customizable HTML report developed by Anshoo Arora which can be integrated into Selenium WebDriver using JUnit and TestNG frameworks.<br>
### Extent Reports offer several advantages when compared to the built-in reports that are generated through JUnit and TestNG such as pie chart representation, test stepwise report generation, adding screenshots etc., at every test step and a presentable user interface that can be shared with all stakeholders of the project.<br> 
* Click this link to view sample <a href="http://extentreports.com/img/bdd/dashboard.png" title="Extent report dashboard image">Extent report dashboard image</a> <br>
* Click this link to view sample <a href="http://extentreports.com/img/bdd/bug.png" title="Extent report tests image">Extent report test image</a> <br>

### :dart:Sample JAVA class for Extent Reports is given below: <br> 
```
public class TestNGExtentreports {

  //builds a new report using the html template 
	  ExtentHtmlReporter htmlReporter;
    ExtentReports extent;
   //helps to generate the logs in test report.
    ExtentTest test;
    ConfigFileReader proconfig = new ConfigFileReader();
    String filename = proconfig.getExtentreportPath() +"/Fund launch result".html";
         
    @BeforeTest
    public void startReport() throws UnknownHostException
    {
        // initialize the HtmlReporter
        htmlReporter = new ExtentHtmlReporter(filename);
        //initialize ExtentReports and attach the HtmlReporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    
        //configuration items to Extent Reports like Name, Title etc. 
        htmlReporter.config().setDocumentTitle("Title of the Report Comes here "); 
        htmlReporter.config().setReportName("Name of the Report Comes here "); 
        htmlReporter.config().setTheme(Theme.DARK); // Theme for Report htmlReporter.config().setTheme(Theme.STANDARD); 
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
        
        //To add system or environment info by using the setSystemInfo method.
        extent.setSystemInfo("Host Name", CommonMethods.getHostName());
        extent.setSystemInfo("User Name", System.getProperty("user.name"));
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("IP Address",InetAddress.getLocalHost().getHostAddress());
         
    }
     
    @Test
    public void demoTestPass()
    {
        test = extent.createTest("demoTestPass", "This test will demonstrate the PASS test case");
        Assert.assertTrue(true);
    }
     
    @Test
    public void demoTestFail()
    {
        test = extent.createTest("demoTestFail", "This test will demonstrate the FAIL test case");
        Assert.assertTrue(false);
    }
     
    @Test
    public void demoTestSkip()
    {
        test = extent.createTest("demoTestSkip", "This test will demonstrate the SKIP test case");
        throw new SkipException("This test case not ready for execution");
    }
     
    @AfterMethod
    public void getResult(ITestResult result)
    {
        if(result.getStatus() == ITestResult.FAILURE)
        {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test case FAILED due to below issues:", ExtentColor.RED));
            test.fail(result.getThrowable());
        }
        else if(result.getStatus() == ITestResult.SUCCESS)
        {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
        }
        else
        {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" Test Case SKIPPED", ExtentColor.ORANGE));
            test.skip(result.getThrowable());
        }
    }
     
    @AfterTest
    public void tearDown()
    {
        extent.flush();
    }

}
```
### :dart:Insert Screenshot in Extent Reports for failed test cases: <br> 
```
public void getResult(ITestResult result,) throws IOException
    {
        if(result.getStatus() == ITestResult.FAILURE)
        {
            String screenShotPath = GetScreenShot.capture(driver, "screenShotName");
            test.log(LogStatus.FAIL, result.getThrowable());
            test.log(LogStatus.FAIL, "Snapshot below: " + test.addScreenCapture(screenShotPath));
        }
        extent.endTest(test);
    }
    
 public static String capture(WebDriver driver,String screenShotName) throws IOException
    {
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String dest = System.getProperty("user.dir") +"\\ErrorScreenshots\\"+screenShotName+".png";
        File destination = new File(dest);
        FileUtils.copyFile(source, destination);        
                     
        return dest;
    }
```

 <img src="http://automationtesting.in/wp-content/uploads/2016/12/Capture-Screenshot-in-Extent-Reports.png" alt="Capture Screenshot in Extent Reports" width="1000" height="400">
 
 ### :dart:Adding Child Tests in Extent Reports: <br> 
```
// To add a test node as a child of another test, use the createNode method.	
ExtentTest parentTest = extent.createTest("MyFirstTest");
ExtentTest childTest1 = parentTest.createNode("MyFirstChildTest", "Node Description");
ExtentTest childTest2 = childTest1.createNode("MySecondChildTest", "Node Description");
ExtentTest childTest3 = childTest2.createNode("MyThirdChildTest", "Node Description");
childTest1.log(Status.PASS, MarkupHelper.createLabel(" MyFirstChildTest is available", ExtentColor.RED));
childTest2.log(Status.FAIL, MarkupHelper.createLabel(" MySecondChildTest is not available", ExtentColor.RED));
childtest3.log(Status.INFO, "<a href='" + screenshotpath + "'> Click here to view Screenshot </a>");
```
 ### :dart:Create BDD-style Tests in Extent Reports: <br> 
```
// gherkin classes

// feature
ExtentTest feature = extent.createTest(Feature.class, "Refund item");

// scenario
ExtentTest scenario = feature.createNode(Scenario.class, "Jeff returns a faulty microwave");
scenario.createNode(Given.class, "Jeff has bought a microwave for $100").pass("pass");
scenario.createNode(And.class, "he has a receipt").pass("pass");
scenario.createNode(When.class, "he returns the microwave").pass("pass");
scenario.createNode(Then.class, "Jeff should be refunded $100").fail("fail");

// using keyword names

// feature
ExtentTest feature = extent.createTest(new GherkinKeyword("Feature"), "Refund item");

// scenario
ExtentTest scenario = feature.createNode(new GherkinKeyword("Scenario") , "Jeff returns a faulty microwave");
scenario.createNode(new GherkinKeyword("Given"), "Jeff has bought a microwave for $100").pass("pass");
scenario.createNode(new GherkinKeyword("And"), "he has a receipt").pass("pass");
scenario.createNode(new GherkinKeyword("When"), "he returns the microwave").pass("pass");
scenario.createNode(new GherkinKeyword("Then"), "Jeff should be refunded $100").fail("fail");
```
 ### :dart:Creating Log Events in Extent Reports: <br> 
```
ExtentTest test = extent.createTest("TestName");
test.log(Status.PASS, "pass");
// or:
test.pass("pass");

test.log(Status.FAIL, "fail");
// or:
test.fail("fail");
```
 ### :dart:Logging Exceptions in Extent Reports: <br> 
```
Catch (Exception e);
{
test.fail(e);
}
```
 ### :dart:Assign Categories to Tests in Extent Reports: <br> 
```
test.assignCategory("Regression");
test.assignCategory("Regression", "ExtentAPI");
test.assignCategory("Regression", "ExtentAPI", "category-3", "cagegory-4", ..);
```
 ### :dart:Assign Authors to Tests in Extent Reports: <br> 
```
test.assignAuthor("aventstack");
```
 ### :dart:Attach screenshots to test and logs in Extent Reports: <br> 
```
test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
```

