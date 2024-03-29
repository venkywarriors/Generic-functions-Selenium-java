# Need for JavaScriptExecutor? 

### JavaScriptExecutor is an Interface that helps to execute JavaScript through Selenium Webdriver. Possibility that locators may not work, You can use JavaScriptExecutor to perform an desired operation on a web element. You need to import (org.openqa.selenium.JavascriptExecutor) in the script as to use JavaScriptExecutor. 
The executeScript method is used to execute synchronous JavaScript code. It returns a value, which can be used in your Selenium test scripts. This method is commonly used for operations like clicking on an element, scrolling to a specific element, or handling pop-ups in Selenium.

On the other hand, the executeAsyncScript method is used to execute asynchronous JavaScript code. This method does not return a value directly, but it allows you to perform asynchronous operations and handle callbacks. It is particularly useful when dealing with AJAX requests or waiting for dynamic web elements to load.

#### Difference between executeAsyncScript vs executeScript
The main difference between the executeAsyncScript and executeScript methods lies in their behavior and how they handle the execution of JavaScript code.

The executeScript method executes JavaScript code synchronously, meaning that it waits for the script to complete before moving on to the next operation. This can be useful when you need to ensure that a certain JavaScript operation is completed before proceeding further in your test script.

On the other hand, the executeAsyncScript method executes JavaScript code asynchronously, allowing other operations to be performed simultaneously. This is particularly useful when dealing with long-running JavaScript operations or when you want to perform multiple operations in parallel.

The JavaScriptExecutor interface provides several methods that can be used to interact with the web page using JavaScript. Here are some commonly used methods:
<br>
- executeScript: Executes synchronous JavaScript code and returns a value.<br>
- executeAsyncScript: Executes asynchronous JavaScript code without returning a value directly.<br>
- scrollIntoView: Scrolls the web page to bring a specific element into view.<br>
- click: Performs a click operation on a web element.<br>
- getElement: Retrieves a web element using a specified locator.<br>
- performSnippet: Executes a snippet of JavaScript code without returning a value.<br>
- executeVoidScript: Executes JavaScript code without returning a value.<br>

These methods provide a flexible approach to interact with web elements, handle alerts, perform scrolling, and execute custom JavaScript operations within your Selenium test scripts.

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
### :dart:Browser name using JavaScriptExecutor: 
```
String s = (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;");
```
### :dart:Highlight the web elements using JavaScriptExecutor: 
```
WebElement ele = driver.findElement(By.xpath(“xpath_expression”));
JavascriptExecutor js = (JavascriptExecutor)driver;
Js.executeScript(“arguments[0].setAttribute(‘style’, ’background: blue; border: 2px solid red;’);”,ele);
```
### :dart:Wait for Page Load using JavaScriptExecutor in Selenium: 
```
	public static void untilPageLoadComplete(WebDriver driver, Long timeoutInSeconds){
		until(driver, (d) ->
			{
				Boolean isPageLoaded = (Boolean)((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
				if (!isPageLoaded) System.out.println("Document is loading");
				return isPageLoaded;
			}, timeoutInSeconds);
	}
```
### :dart: Total Frames in Browser:
```
JS.executeScript("document.frames.length;");
Or
JS.executeScript("document.getElementsByTagName("iframe").length;");
```
### :dart: Selenium WebDriver get Current frame:
```
JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
String currentFrame = jsExecutor.executeScript("return self.name");
```
### :dart:Scroll Element into View using JavaScriptExecutor: 
```
WebElement element = driver.findElement(By.id("id_of_element"));
((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
```
### :dart:Set value of input instead of sendKeys() using JavaScriptExecutor: 
```
WebElement element = driver.findElement(By.id("id_of_element"));
((JavascriptExecutor) driver).executeScript("arguments[0].value='"+ value +"';", element);
```
```
String value= "your value"; 
driver.execute_script("document.getElementById('q').value=' "+value+" ' ");
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
or
executor.executeScript("arguments[0].checked = true;", element);
```
### :dart:Refresh Browser using JavaScriptExecutor: 
```
JavascriptExecutor js = (JavascriptExecutor)driver;
js.executeScript("history.go(0)");
or
js.executeScript(“location.reload()”);
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
### :dart:Open a new window with a specific URL a new window with a specific URL
```
  jsExecutor.executeScript("window.open('https://www.google.com', '_blank');");
or 
  jsExecutor.executeScript("window.open('', '_blank');"); //Open a new window
```
### :dart:Navigating to URL using JavaScriptExecutor: 
```
js.executeScript("window.location = 'https://www.google.co.in'");
or
js.executeScript("window.location.href = 'https://www.example.com';");
// Execute JavaScript to open a new tab
jsExecutor.executeScript("window.open('about:blank','_blank');");
```
# Handle Ajax call Using JavaScriptExecutor in Selenium? 
### What is Ajax?
AJAX is a technique to do an XMLHttpRequest (out of band Http request) from a web page to the server and send/retrieve data to be used on the web page. AJAX stands for Asynchronous Javascript And XML.

Means: Ajax is way for the client-side browser to communicate with the server (for example: retrieve data from a database) without having to perform a page refresh.
### What is JQuery?
JQuery (website) is a javascript framework that makes working with the DOM easier by building lots of high level functionality that can be used to search and interact with the DOM. Part of the functionality of jQuery implements a high-level interface to do AJAX requests. 

* JQuery is a lightweight client side scripting library while AJAX is a combination of technologies used to provide asynchronous data transfer
* JQuery and AJAX are often used in conjunction with each other
* JQuery is primarily used to modify data on the screen dynamically and it uses AJAX to retrieve data that it needs without changing the current state of the displayed page

### Wait for Ajax call to finish
sample code to showcase the handling of AJAX controls using Selenium Webdriver. You can integrate it in your test execution class.

<strong> Boolean isJqueryCallDone = (Boolean)((JavascriptExecutor) driver).executeScript(“return jQuery.active==0“); </strong>

As the above script would return either True or False. But we need to run this code till the time either we get true or the specified time is over. To do that we need to have the Selenium WebDriver Wait, which would provide us untill method.

### :dart:Selenium WebDriver Wait-untill method: <br> 
```
	private static void until(WebDriver driver, Function<WebDriver, Boolean> waitCondition, Long timeoutInSeconds){
		WebDriverWait webDriverWait = new WebDriverWait(driver, timeoutInSeconds);
		webDriverWait.withTimeout(timeoutInSeconds, TimeUnit.SECONDS);
		try{
			webDriverWait.until(waitCondition);
		}catch (Exception e){
			System.out.println(e.getMessage());
		}          
	}
```
### :dart:Wait for Jquery using JavaScriptExecutor in Selenium: <br> 
```
Java
public static void untilJqueryIsDone(WebDriver driver, Long timeoutInSeconds){
	until(driver, (d) ->
		{
		Boolean isJqueryCallDone = (Boolean)((JavascriptExecutor) driver).executeScript("return jQuery.active==0");
		if (!isJqueryCallDone) System.out.println("JQuery call is in Progress");
		return isJqueryCallDone;
		}, timeoutInSeconds);
}
```



