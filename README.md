![Selenium webdriver with Java](https://1.bp.blogspot.com/-bY5Js-Plm8Y/V1aBSPTLz5I/AAAAAAAABio/Rew-CBamQwkv7K2HfpX_xFvmTjFZLkAPwCPcBGAYYCw/s1600/selenium-webdriver-java-online-courses-techtutorr.jpg)
This repository contains generic functions used in selenium java <br>
:+1: Click this link to view <a href="https://github.com/venkywarriors619/Generic-functions-Selenium-java/blob/master/JavaScriptExecutor.md" title="Click here to view JavaScriptExecutor functions">*JavaScriptExecutor methods* </a><br>
:+1: Click this link to view <a href="https://github.com/venkywarriors619/Generic-functions-Selenium-java/blob/master/Excelfunctions.md" title="Click here to view Excel operation">*Excel Operation using Apache POI* </a><br>
:+1: Click this link to view <a href="https://github.com/venkywarriors619/Generic-functions-Selenium-java/blob/master/Extent%20reports.md" title="Click here to view Extent Reports in Selenium">*Extent Reports in Selenium WebDriver* </a><br>
:+1: Click this link to view <a href="https://github.com/venkywarriors619/Generic-functions-Selenium-java/blob/master/propertiesfile.md" title="Click here to view Read data from Properties File ">*Access data from Properties File* </a><br>
:+1: Click this link to view <a href="https://github.com/venkywarriors619/Generic-functions-Selenium-java/blob/master/Testbase.md" title="Click here to view Common methods used in selenium webdriver ">*Common methods used in selenium webdriver* </a><br>
:+1: Click this link to view <a href="https://github.com/venkywarriors619/Generic-functions-Selenium-java/blob/master/SeleniumPrograms.md" title="Click here to view basic methods used in selenium webdriver ">*Sample selenium programs* </a><br>
:+1: Click this link to view <a href="https://github.com/venkywarriors619/Generic-functions-Selenium-java/blob/master/TestNG.md" title="Click here to view TestNG methods used in selenium webdriver ">*Sample TestNG programs* </a><br>
:+1: Click this link to view <a href="https://github.com/venkywarriors619/Generic-functions-Selenium-java/blob/master/AdvSelenium.md" title="Click here to view Advance selenium concepts">*Advance selenium concepts* </a><br>
:+1: Click this link to view <a href="https://github.com/venkywarriors619/Generic-functions-Selenium-java/blob/master/jenkins.md" title="Click here to view Jenkins concepts">*Jenkins concepts* </a><br>
:+1: Click this link to view <a href="https://github.com/venkywarriors619/Generic-functions-Selenium-java/blob/master/JavaTitBits.md" title="Click here to view Java TitBits">*Java TitBits* </a><br>
:+1: Click this link to view <a href="https://github.com/venkywarriors/Generic-functions-Selenium-java/blob/master/Interview%20Java%20programs.md" title="Click here to view Java Programs">*Java Programs* </a><br>
## Why Do We Need Waits In Selenium?
Most of the web applications are developed using Ajax and Javascript. When a page is loaded by the browser the elements which we want to interact with may load at different time intervals.<br>
<a href="https://www.browserstack.com/guide/wait-commands-in-selenium-webdriver">Selenium Wait</a><br>
<a href="https://www.toolsqa.com/selenium-webdriver/wait-commands/">Wait commands</a>
## Action Class in Selenium
Action Class in Selenium is a built-in feature provided by the selenium for handling keyboard and mouse events. It includes various operations such as multiple events clicking by control key, drag and drop events and many more. These operations from the action class are performed using the advanced user interaction API in Selenium Webdriver.
<br>
<a href="https://www.toolsqa.com/selenium-webdriver/actions-class-in-selenium/">How to use Action Class</a><br>
## Need for Robot class
Selenium scripts use Robot class for automating the browser and desktop pop-ups, but the exciting thing is this class is not part of org.openqa.selenium package of Web Driver API.
<br>Then from where does this class come?<br>It doesn’t reside in Web Driver API; it is part of the Java API awt package<br>
<a href="https://www.softwaretestinghelp.com/java-robot-class-in-selenium/amp/">How to use Robot Class</a><br>
## Test Automation for Windows Desktop Applications 
### Winium 
Winium is a Selenium-based tool for testing and automating desktop applications on a Windows desktop. It uses selenium-based libraries however the community has made only two releases and there is no active work or maintenance since then<br>
<a href="https://defectracker.com/2019/09/20/1363/">Winium sample code snippet</a>
```
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class sampleTest {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        WiniumDriver driver = null;
        String appPath = "C:/windows/system32/calc.exe";
        DesktopOptions option = new DesktopOptions();
        option.setApplicationPath(appPath);
        option.setDebugConnectToRunningApp(false);
        option.setLaunchDelay(2);
        driver = new WiniumDriver(new URL("http://localhost:9999"),option);
        Thread.sleep(1000);
        WebElement window =  driver.findElementByClassName("CalcFrame");
        WebElement menuItem = window.findElement(By.id("MenuBar")).findElement(By.name("View"));
        menuItem.click();
        driver.findElementByName("Scientific").click();

        window.findElement(By.id("MenuBar")).findElement(By.name("View")).click();
        driver.findElementByName("History").click();

        window.findElement(By.id("MenuBar")).findElement(By.name("View")).click();
        driver.findElementByName("History").click();

        window.findElement(By.id("MenuBar")).findElement(By.name("View")).click();
        driver.findElementByName("Standard").click();

        driver.findElementByName("4").click();
        driver.findElementByName("Add").click();
        driver.findElementByName("5").click();
        driver.findElementByName("Equals").click();
        driver.close();
    }
}
```
### WinAppDriver Test Automation Framework
WinAppDriver uses selenium-like libraries and is actively supported by the community and is developed by the makers of Windows OS – Microsoft. Windows Application Driver supports Selenium-like UI test automation for Windows applications. The service supports automated testing of Universal Windows Platform (UWP), Windows Forms (WinForms), Windows Presentation Foundation (WPF), and Classic Windows (Win32) apps on the Windows 10 operating system. Winappdriver complies with the JSON Wire Protocol and some application management functionalities defined by Appium. This service provides better support for using Appium to test Windows Applications.
<br><a href="https://medium.com/software-testing-break-and-improve/tutorial-windows-app-automation-using-winappdriver-and-java-5be661335b25">WinAppDriver with Java</a><br>
<a href="https://www.automatetheplanet.com/automate-windows-desktop-apps-winappdriver/">WinAppDriver with C#</a><br>
<a href="https://www.softwaretestingmaterial.com/headless-browser-testing-using-htmlunitdriver/">HTML unit driver</a><br>
### What is the sequence in which Maven searches for dependency libraries?
When we execute Maven build commands, Maven starts looking for dependency libraries in the following sequence −<br>
* Step 1 − Search dependency in local repository, if not found, move to step 2.
* Step 2 − Search dependency in central repository, if not found and remote repository/repositories is/are mentioned then move to step 4. Else it is downloaded to local repository for future reference.
* Step 3 − If a remote repository has not been mentioned, Maven simply stops the processing and throws error (Unable to find dependency).
* Step 4 − Search dependency in remote repository or repositories, if found then it is downloaded to local repository for future reference. Otherwise, Maven stops processing and throws error (Unable to find dependency).
