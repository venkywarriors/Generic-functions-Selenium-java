<a href="https://www.softwaretestingmaterial.com/webdriver-driver-new-firefoxdriver/">why-we-assign-firefoxdriver-instance-to-webdriver</a><br> 
<a href="https://youtu.be/I2Dc6TOzPVQ">Type casting of webdriver instance to javascript</a><br>
### :dart:How to switch to a specific window? <br> 
```
public static void switchWindow(String text) {
    WebDriver popup = null;
    Set<String>s=driver.getWindowHandles();

// Now iterate using Iterator
    Iterator<String> windowIterator = s.iterator();

    while (windowIterator.hasNext()) {
        String windowHandle = windowIterator.next();
        popup = driver.switchTo().window(windowHandle);
        String title = popup.getTitle();
        if (title.contains(text)) {
            break;
        }
    }
}
```
### :dart:How to get browser name using Selenium WebDriver with Java?
```
Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
    String browserName = cap.getBrowserName().toLowerCase();
    System.out.println(browserName);
    String os = cap.getPlatform().toString();
    System.out.println(os);
    String v = cap.getVersion().toString();
    System.out.println(v);

packages you need to import

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver
```
### :dart:How to block the pop-up windows by Selenium
```
System.setProperty("webdriver.chrome.driver", "//chrome path in system//");
    ChromeOptions options  = new ChromeOptions();
    //options.addArguments("incognito");
    options.addArguments("--disable-popup-blocking");  //chrome 42 older
    options.setExperimentalOption("excludeSwitches", "disable-popup-blocking"); // chrome 43
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability(ChromeOptions.CAPABILITY, options);
    driver = new ChromeDriver(capabilities);
```
```
import org.openqa.selenium.chrome.FirefoxDriver;
import org.openqa.selenium.chrome.Preferences;

FirefoxProfile customProfile = new FirefoxProfile();
customProfile.setPreference("dom.disable_beforeunload", true);
FirefoxDriver driver = new FirefoxDriver(customProfile);
```
IE 11 Popup Blocker issue
```
Registry Location: HKEY_CURRENT_USER\Software\Microsoft\Internet Explorer\New Windows

Registry Value Name: PopupMgr

String cmd = "REG ADD \"HKEY_CURRENT_USER\\Software\\Microsoft\\
       Internet Explorer\\New Windows\" /F /V \"PopupMgr\" /T REG_SZ /D \"yes\"";
try {
    Runtime.getRuntime().exec(cmd);
} catch (Exception e) {
    System.out.println("Error ocured!");
}

DesiredCapabilities ieCapabilities =new DesiredCapabilities();
ieCapabilities.setCapability("disable-popup-blocking", true);
or
ieCapabilities.setCapability("unexpectedAlertBehaviour","accept");
or
ieCapabilities.setCapability("browserstack.ie.enablePopups","accept");

To completely disable the pop-up, go to Tools > Options > Content and check the option for Block pop-up windows
```
### :dart:Read CSV File in selenium Sample Java code given below: <br> 
```
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class csvread
{
 //getting the last data count(rowcount)
 public static int getRowCount(String csvPath) throws FileNotFoundException
 {
 int rc=0;
 try (Scanner scanner = new Scanner(new File(csvPath)))
 {
 scanner.useDelimiter("\n");
 while(scanner.hasNext())
 {
 rc++;
 scanner.next();
 }
 }
 return rc;
 }
 //getting the value from csv cell
 public static String getValue(String csvPath,int rc,int cc) throws FileNotFoundException
 {
 String v="";
 try (Scanner scanner = new Scanner(new File(csvPath)))
 {
 scanner.useDelimiter("\n");
 for(int i=1;i<=rc;i++)
 {
 if(scanner.hasNext())
 v=scanner.next();
 }
 }
 return v.split(",")[cc-1];
 }
 //main method
 public static void main(String[] args) throws FileNotFoundException
 {
 int v = csvread.getRowCount("E:/new.csv");
 for(int i=1;i<=v;i++)
 {
 String t = csvread.getValue("E:/new.csv", i, 1);
 System.out.println(t);
 }
 }
}
```
### :dart:Get Webpage Links Using Selenium Example Program: <br> 
```
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
public class RetriveAllLinks 
{
 @org.testng.annotations.Test
 public void importlink() throws InterruptedException
 {
 WebDriver driver=new FirefoxDriver();
 driver.get("http://www.softwaretestingblog.in/");
 Thread.sleep(3000);
 List<WebElement> li=driver.findElements(By.tagName("a"));
 System.out.println(li.size());
 for(int i=1;i<li.size();i++)
 {
 String t1=li.get(i).getText();
 String t2=li.get(i).getAttribute("href");
 System.out.println(t1+" --- >> "+t2); 
 } 
 driver.close();
 }
}
```
### :dart:Connect DB Using Java Selenium: <br> 
Before building a connection, make sure to add connector dependency in your POM [Ex. MySQL Connector].
<br>
DriverManager – to establish a connection | Connection – to create a Statement object | Statement – to execute the query | Resultset – to store the query results.
* Load & register the driver | Class.forName("com.mysql.jdbc.Driver");
* Establish connection | Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee","user","pwd");
* Create a Statement object | Statement st= con.createStatement();
* Execute a query & get the Resultset | Resultset rs = st.executeQuery("Select * from Employee");

Note: PreparedStatement [instead of Statement] has methods to bind various object types, including files and arrays.
```
public static ArrayList<String> tableSQL(String dbURL,String dbUserID,String dbPwd,String query) throws ClassNotFoundException, SQLException {
	
	Class.forName("com.ibm.db2.jcc.DB2Driver");
	 ArrayList<String> moneytypeTable = new ArrayList<String>();
	Connection conn = DriverManager.getConnection(dbURL, dbUserID, dbPwd);
	Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	ResultSet rs = stmt.executeQuery(query);
	ResultSetMetaData rsmd = rs.getMetaData();
	 int columnCount = rsmd.getColumnCount();
	 
		while(rs.next())
		{				
			for (int i = 1; i <= columnCount; i++ ) {
				 
				  String val =(rs.getString(i)).trim();	
				  
				  moneytypeTable.add(val); 		  
				}
		}	
			
		 rs.close();
		 stmt.close();
		 conn.close();

		return moneytypeTable;
}
```
### :dart:Running a vbs file Using Java Selenium: <br> 
Vbs file to make system idle
```
set wsc = CreateObject("WScript.Shell")

Do Until WScript.Sleep (60*1000)

wsc.SendKeys ("{SCROLLLOCK 2}")

Loop
```
Save the file as test.vbs
```
public static void main(String[] args) {
   try {
     // Runtime.getRuntime().exec( "wscript D:/test.vbs" ); 
            Runtime.getRuntime().exec(new String[] {
        "wscript.exe", "C:\\path\\example.vbs"
        }); 
   }
   catch( IOException e ) {
      System.out.println(e);
      System.exit(0);
   }
}
```
### :dart:Firefox Headless Browser Using Java Selenium: <br> 
```
public class Firefox_Headless
{
 System.setProperty("webdriver.gecko.driver","./driver/geckodriver.exe");
 FirefoxOptions options=new FirefoxOptions();
 File pathToFirefoxBinary=new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
 FirefoxBinary path=new FirefoxBinary(pathToFirefoxBinary);
 options.setBinary(path);
 options.addArguments("-headless");
 WebDriver driver = new FirefoxDriver(options);
 driver.get("http://google.com/");
System.out.println(driver.getTitle());
}
```
### :dart:Disable Chrome Notification Selenium: <br> 
```
public class DisableChromeNotificationEx 
{
 public static void main(String[] args) 
 {
 // Create object of HashMap Class
 Map<String, Object> prefs = new HashMap<String, Object>();
 
 // Set the notification setting it will override the default setting
 prefs.put("profile.default_content_setting_values.notifications", 2);
 
 // Create object of ChromeOption class
 ChromeOptions options = new ChromeOptions();
 
 // Set the experimental option
 options.setExperimentalOption("prefs", prefs);
 
 // pass the options object in Chrome driver
 System.setProperty("webdriver.chrome.driver", "G:\\Testing_Utilities\\BrowsersDriver\\chromedriver.exe");
 WebDriver driver = new ChromeDriver(options);
 driver.get("https://www.facebook.com/");
 driver.manage().window().maximize();
```
### :dart:Save Reports in specific Path using Selenium: <br> 
```
public static void saveiReport(WebDriver driver,String reportPath,String reportName, ExtentTest addToReport) throws InterruptedException, AWTException  {
	
	String reportFolderPath=reportPath+"\\"+reportName+".pdf";
	 Robot robot = new Robot();
	 try{ 
		 	CommonMethods.isAlertPresent(driver);
		 	
		 	String mainWindow=driver.getWindowHandle();
			 
			Set<String> set =driver.getWindowHandles();
			
			Iterator<String> itr= set.iterator();
			 	while(itr.hasNext()){
			 		String childWindow=itr.next();
			 			if(!mainWindow.equals(childWindow)){
			 				
			 				 driver.switchTo().window(childWindow);
			 				driver.manage().window().maximize();			 				
			 				CommonMethods.waitForPageLoad(driver);
			 				 Thread.sleep(9000);
			 				robot.keyPress(KeyEvent.VK_CONTROL );		
							robot.keyPress(KeyEvent.VK_P );		
							robot.keyRelease(KeyEvent.VK_CONTROL);
							robot.keyRelease(KeyEvent.VK_P );
							robot.delay(5000);
					        robot.keyPress(KeyEvent.VK_ENTER);
					        robot.keyRelease(KeyEvent.VK_ENTER); //enter
					        robot.delay(2000);
				 StringSelection selection = new StringSelection(reportFolderPath);
				 Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				 clipboard.setContents(selection, null);

				 for(int waitforPOPup=1; waitforPOPup<300; waitforPOPup++)
				 {
						robot.keyPress(KeyEvent.VK_CONTROL);			        
				        robot.keyPress(KeyEvent.VK_V);
				        robot.keyRelease(KeyEvent.VK_V);
				        robot.keyRelease(KeyEvent.VK_CONTROL); //paste the copied string into the dialog box
				        robot.delay(1000);
				        robot.keyPress(KeyEvent.VK_ENTER);
				        robot.keyRelease(KeyEvent.VK_ENTER); //enter
				        Thread.sleep(4000);
				       
						    if (CommonMethods.checkFileExists(reportFolderPath))
						    {
						        System.out.println("Report generated in "+reportFolderPath);
						    	addToReport.log(Status.PASS, MarkupHelper.createLabel(reportName+" report is generated successfully...", null));
				 			}							
						    driver.close();
			 				driver.switchTo().window(mainWindow);
			 				Thread.sleep(1000);
			 				break;
			 			}
			 		}
			 	}
		 	
	 }

	catch(Exception e) {
		System.out.println(e);	
		addToReport.log(Status.PASS, MarkupHelper.createLabel(reportName+" report is not generated", null));
	}						
}

public static void saveCSVeport(WebDriver driver,String reportPath,String reportName, ExtentTest addToReport) throws InterruptedException, AWTException  {
	
	String reportFolderPath=reportPath+"\\"+reportName;
	 Robot robot = new Robot();
	 try{ 
		 	CommonMethods.isAlertPresent(driver);
		 	
		 	Thread.sleep(5000);
		 		        
				 StringSelection selection = new StringSelection(reportFolderPath);
				 Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				 clipboard.setContents(selection, null);

				 for(int waitforPOPup=1; waitforPOPup<100; waitforPOPup++)
				 {	robot.delay(3000);
			        robot.keyPress(KeyEvent.VK_CONTROL);			        
			        robot.keyPress(KeyEvent.VK_V);
			        robot.keyRelease(KeyEvent.VK_V);
			        robot.keyRelease(KeyEvent.VK_CONTROL); //paste the copied string into the dialog box
			        robot.delay(1000);
			        robot.keyPress(KeyEvent.VK_ENTER);
			        robot.keyRelease(KeyEvent.VK_ENTER); //enter
			        robot.delay(2000);
			        
			        if (CommonMethods.checkFileExists(reportFolderPath+".csv"))
				    {
				        System.out.println("Report generated in "+reportFolderPath);
				    	addToReport.log(Status.PASS, MarkupHelper.createLabel(reportName+" report is generated successfully...", null));
		 				Thread.sleep(2000);
		 				break;
				    }
				 }
		    	CommonMethods.handleAlert(driver);
	 }

	catch(Exception e) {
		System.out.println(e);	
		addToReport.log(Status.PASS, MarkupHelper.createLabel(reportName+" report is not generated", null));
	}						
}
```
### :dart:Close Second Window Using Selenium: <br> 
```
public class Close2ndWindiw 
{
 WebDriver driver=new FirefoxDriver();
 @BeforeTest
 public void open()
 {
 driver.manage().window().maximize();
 driver.get("http://demoqa.com/frames-and-windows/");
 driver.manage().timeouts().implicitlyWait(15000, TimeUnit.SECONDS);
 }
 @Test
 public void operation() throws InterruptedException
 {
 //String parent=driver.getWindowHandle();
 driver.findElement(By.xpath(".//*[@id='tabs-1']/div/p/a")).click();
 Thread.sleep(2000);
 Set<String> handles=driver.getWindowHandles();
 int count=0;
 for(String h:handles)
 {
 count++;
 System.out.println(count);
 if(count==1)
 {
 driver.switchTo().window(h);
 driver.close(); 
 }
 else
 {
 continue;
 }
 }
 //driver.switchTo().window(parent);
 //driver.close();
 }

```
### :dart:Get Default Text Of a TextBox Using Java: <br> 
```
public class GetUsernameText 
{
 public static void main(String[] args)
 {
 Logger log=Logger.getLogger(GetUsernameText.class);
 WebDriver driver=new FirefoxDriver();
 driver.get("https://www.facebook.com/");
 log.info("Facebook Opened");
 driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
 //driver.findElement(By.name("firstname")).sendKeys("abc@gmail.com");
 String st=driver.findElement(By.name("firstname")).getAttribute("aria-label");
 System.out.println(st);
 }
}
```
### :dart:Handle SSL Certificate Issue: <br> 
```
public class SSLCertificateIssue 
{
 public static void main(String[] args) 
 {
 DesiredCapabilities cap=new DesiredCapabilities();
 cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
 WebDriver driver=new FirefoxDriver();
 driver.get("http://www.cacert.org/");
 driver.close();
 }
}
```
### :dart:BrowserUtility function using Web Driver Manager: <br> 
```
public static  WebDriver browserUtility(String browser, String URL) 
	{
        if(browser.equalsIgnoreCase("chrome")) {                   
            System.out.println("*** launching chrome browser ***");
            WebDriverManager.chromedriver().setup();
            //System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/driver/chromedriver.exe");
            driver=new ChromeDriver(); 
   }else if (browser.equalsIgnoreCase("ie")) {                 
                 System.out.println("*** launching IE browser ***");
                 WebDriverManager.iedriver().arch32().setup();
                 //System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"/driver/IEDriverServer.exe");
                 driver = new InternetExplorerDriver();
  }else if (browser.equalsIgnoreCase("edge")) {                     
                        System.out.println("*** launching Microsoft Edge browser ***");
                        WebDriverManager.edgedriver().setup();
                      // System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"/driver/MicrosoftWebDriver.exe"); 
                        driver = new EdgeDriver();
  }else if (browser.equalsIgnoreCase("Firefox")) {                  
           System.out.println("*** launching Firefox browser ***");
           //System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"/driver/geckodriver.exe"); 
           WebDriverManager.firefoxdriver().setup();
           driver = new FirefoxDriver();
  }else if (browser.equalsIgnoreCase("headless browser")) {                      
           driver = new HtmlUnitDriver(); 
   }            
   driver.navigate().to(URL);
  driver.manage().deleteAllCookies();
  driver.manage().window().maximize();
  driver.manage().timeouts().pageLoadTimeout(property.getpageTimeOut(), TimeUnit.SECONDS);
  return driver;
}
```
### :dart:Auto Suggestion & Auto Complete Text Box validation: <br> 
```
public class AutoSuggest {
 
	@Test(description="Auto Suggest")
	public void selectValues()
	{
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://in.yahoo.com/?p=us");
		driver.findElement(By.id("uh-search-box")).sendKeys("Selenium");
		
		/**
		 * Example for Visibility of Elements located by
		 */
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@role='listbox']//li")));
		
		List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li"));
		
		System.out.println("Auto Suggest List ::" + list.size());
		
		for(int i = 0 ;i< list.size();i++)
		{
			System.out.println(list.get(i).getText());
			
			if(list.get(i).getText().equals("selenium interview questions"))
			{
				list.get(i).click();
				break;
			}
		}
		
		/**
		 * Verify the Search Results
		 */
		
		
	}
	
}
```

 



	
