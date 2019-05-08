# Need for JavaScriptExecutor? 

## JavaScriptExecutor is an Interface that helps to execute JavaScript through Selenium Webdriver. JavaScriptExecutor provides two methods "executescript" & "executeAsyncScript" to run javascript on the selected window or current page.
### In Selenium Webdriver, sometimes locators may not work, You can use JavaScriptExecutor to perform an desired operation on a web element. You need to import (org.openqa.selenium.JavascriptExecutor) in the script as to use JavaScriptExecutor. 
### executeScript Method <br>
This method executes JavaScript in the context of the currently selected frame or window in Selenium. The script used in this method runs in the body of an anonymous function (a function without a name). The script can return values. <br>
Data types returned are<br>  
<li>Boolean</li> <li>Boolean</li> <li>Long</li> <li>String</li><li>List</li><li>WebElement</li>
:dart:The basic syntax for JavascriptExecutor is given below: <br> 
```Java
JavascriptExecutor js = (JavascriptExecutor) driver;  
js.executeScript(Script,Arguments);
```
•Script – This is the JavaScript that needs to execute.
•Arguments – It is the arguments to the script. It's optional.


