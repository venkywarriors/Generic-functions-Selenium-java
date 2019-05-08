# Need for JavaScriptExecutor? 

### JavaScriptExecutor is an Interface that helps to execute JavaScript through Selenium Webdriver. Possibility that locators may not work, You can use JavaScriptExecutor to perform an desired operation on a web element. You need to import (org.openqa.selenium.JavascriptExecutor) in the script as to use JavaScriptExecutor. 
### :dart:The basic syntax for JavascriptExecutor is given below: <br> 
```
JavascriptExecutor js = (JavascriptExecutor) driver;  
js.executeScript(Script,Arguments);
```
* Script – This is the JavaScript that needs to execute.
* Arguments – It is the arguments to the script. It's optional.
### :dart:Generate Alert Pop Window using JavaScriptExecutor: 
```
JavascriptExecutor js = (JavascriptExecutor)driver;
Js.executeScript("alert('hello world');");
```
### :dart:Perform Click Action using JavaScriptExecutor: 
```
JavascriptExecutor js = (JavascriptExecutor)driver;
js.executeScript("arguments[0].click();", element);
```
### :dart:Refresh Browser using JavaScriptExecutor: 
```
JavascriptExecutor js = (JavascriptExecutor)driver;
driver.executeScript("history.go(0)");
```
### :dart:Get InnerText of a Webpage using JavaScriptExecutor: 
```
JavascriptExecutor js = (JavascriptExecutor)driver;
string sText =  js.executeScript("return document.documentElement.innerText;").toString();
```
### :dart:Get Title of a WebPage using JavaScriptExecutor: 
```
JavascriptExecutor js = (JavascriptExecutor)driver;
string sText =  js.executeScript("return document.title;").toString();
```
### :dart:Get Title of a WebPage using JavaScriptExecutor: 
```
JavascriptExecutor js = (JavascriptExecutor)driver;
string sText =  js.executeScript("return document.title;").toString();
```
### :dart:Scroll Page using JavaScriptExecutor: 
```
JavascriptExecutor js = (JavascriptExecutor)driver;
  //Vertical scroll - down by 150  pixels
  js.executeScript("window.scrollBy(0,150)");
```
### :dart:Getting Element Attributes using JavaScriptExecutor: 
```
String className = Driver.executeScript("return document.getElementById('gsc-i-id1').getAttribute('class');"));
```
### :dart:Count number of frames inside a webpage using JavaScriptExecutor: 
```
JavascriptExecutor js = (JavascriptExecutor)driver;
js.executeScript("document.frames.length;");
```



