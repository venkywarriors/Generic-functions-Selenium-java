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
### :dart:Get Webpage Links Using Selenium Example Program: <br> 
```
```
### :dart:Get Webpage Links Using Selenium Example Program: <br> 
```
```
 



	
