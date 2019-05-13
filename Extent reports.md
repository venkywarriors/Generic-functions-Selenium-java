# Creating extent reports in selenium webdriver 
### Extent Reports are the most popular reporting used with Selenium. Extent Reports is a customizable HTML report developed by Anshoo Arora which can be integrated into Selenium WebDriver using JUnit and TestNG frameworks.<br>
### Extent Reports offer several advantages when compared to the built-in reports that are generated through JUnit and TestNG such as pie chart representation, test stepwise report generation, adding screenshots etc., at every test step and a presentable user interface that can be shared with all stakeholders of the project.<br> 
* Click this link to view sample Extent report images <a href="http://extentreports.com/img/bdd/dashboard.png" title="Extent report dashboard image">Extent report dashboard image</a> <br>
* Click this link to view sample Extent report images <a href="http://extentreports.com/img/bdd/bug.png" title="Extent report tests image">Extent report test image</a> <br>

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

