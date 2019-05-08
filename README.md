# Need for JavaScriptExecutor? 

### JavaScriptExecutor is an Interface that helps to execute JavaScript through Selenium Webdriver. Possibility that locators may not work, You can use JavaScriptExecutor to perform an desired operation on a web element. You need to import (org.openqa.selenium.JavascriptExecutor) in the script as to use JavaScriptExecutor. 
### :dart:The basic syntax for JavascriptExecutor is given below: <br> 
```
JavascriptExecutor js = (JavascriptExecutor) driver;  
js.executeScript(Script,Arguments);
```
* Script – This is the JavaScript that needs to execute.
* Arguments – It is the arguments to the script. It's optional.
* Returns –One of Boolean, Long, String, List, WebElement, or null.
### :dart:Change attribute value of an element using JavaScriptExecutor: 
Let's say i have below button which is hidden I need perform to click on but selenium detect it as Invisible.
```
<button id="datasubmit" name="btndubmit" style="display:none;">data submit</button>
```
If I try to locate, selenium will throw me the ElementNotVisibleException. So here you can set or change the attribute value of any element and perform your intended action. Here I'm going to change attribute value
```
WebElement element = driver.findElement(By.id("datasubmit"));
JavascriptExecutor js = (JavascriptExecutor)driver;
js.executeScript("arguments[0].style.display = 'block'", element );
```
### :dart:Generate Alert Pop Window using JavaScriptExecutor: 
```
JavascriptExecutor js = (JavascriptExecutor)driver;
js.executeScript("alert('hello world');");
```
### :dart:Highlight the web elements using JavaScriptExecutor: 
```
WebElement ele = driver.findElement(By.xpath(“xpath_expression”));
JavascriptExecutor js = (JavascriptExecutor)driver;
Js.executeScript(“arguments[0].setAttribute(‘style’, ’background: blue; border: 2px solid red;’);”,ele);
```
### :dart:Scroll Element into View using JavaScriptExecutor: 
```
WebElement element = driver.findElement(By.id("id_of_element"));
((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
```
### :dart:Perform Click Action using JavaScriptExecutor: 
```
JavascriptExecutor js = (JavascriptExecutor)driver;
js.executeScript("arguments[0].click();", element);
```
### :dart:To click on a SubMenu which is only visible on mouse hover on Menu: 
```
js.executeScript("$('ul.menus.menu-secondary.sf-js-enabled.sub-menu li').hover()");
```
### :dart:Handling Checkbox using JavaScriptExecutor: 
```
js.executeScript("document.getElementById('enter element id').checked=false;");
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
### :dart:Get Domain of a Webpage using JavaScriptExecutor: 
```
String sText =  js.executeScript("return document.domain;").toString();
```
### :dart:Get Title of a WebPage using JavaScriptExecutor: 
```
JavascriptExecutor js = (JavascriptExecutor)driver;
string sText =  js.executeScript("return document.title;").toString();
```
### :dart:Fetching the URL of the WebPage using JavaScriptExecutor: 
```
JavascriptExecutor js = (JavascriptExecutor)driver;
string url = js.executeScript("return document.URL;").toString();
```
### :dart:Scroll Page using JavaScriptExecutor: 
```
JavascriptExecutor js = (JavascriptExecutor)driver;
  //Vertical scroll - down by 150  pixels
js.executeScript("window.scrollBy(0,150)");
  //scroll till the bottom of the page 
js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
//scroll till the Top of the page 
js.executeScript("window.scrollBy(0,0)");
```
### :dart:Getting Element Attributes using JavaScriptExecutor: 
```
String className = Driver.executeScript("return document.getElementById('gsc-i-id1').getAttribute('class');"));
```
### :dart:Count number of frames inside a webpage using JavaScriptExecutor: 
```
js.executeScript("document.frames.length;");
```
### :dart:Adding an Element in DOM using JavaScriptExecutor: 
```
Driver.executeScript("var btn=document.createElement('BUTTON');"
                     + "document.body.appendChild(btn);");
```
### :dart:Finding the size of browser window using JavaScriptExecutor: 
```
Driver.executeScript("return window.innerHeight;")
Driver.executeScript("return window.innerWidth;")
```
### :dart:Navigating to URL using JavaScriptExecutor: 
```
js.executeScript("window.location = 'https://www.google.co.in'");
```



