package Raga;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestNGExtentreports {
	ExtentHtmlReporter htmlReporter;
    ExtentReports extent;
    ExtentTest test;
    ConfigFileReader proconfig = new ConfigFileReader();
    String filename = proconfig.getExtentreportPath() +"/Fund launch result_"+CommonMethods.timestamp()+".html";
         
    @BeforeTest
    public void startReport() throws UnknownHostException
    {
        htmlReporter = new ExtentHtmlReporter(filename);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        //htmlReporter.loadConfig(System.getProperty("user.dir")+"/test-output/extent-config.xml");
        htmlReporter.config().setDocumentTitle("Title of the Report Comes here "); 
        htmlReporter.config().setReportName("Name of the Report Comes here "); 
        htmlReporter.config().setTheme(Theme.DARK);        
       
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
