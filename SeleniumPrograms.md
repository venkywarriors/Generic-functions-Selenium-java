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
### :dart:Get Webpage Links Using Selenium Example Program: <br> 
```
```
### :dart:Get Webpage Links Using Selenium Example Program: <br> 
```
```
### :dart:Get Webpage Links Using Selenium Example Program: <br> 
```
```
### :dart:Get Webpage Links Using Selenium Example Program: <br> 
```
```
 



	
