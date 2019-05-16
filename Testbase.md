## Commonly used functions in Selenium webdriver
### :dart:Wait For Element to load: <br> 
```	
	public static  void waitForElement(WebDriver driver, String xPath, int i) 
	{
				
			WebDriverWait wait = new WebDriverWait(driver,i);

		try{

				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
		}

		catch(Exception e){
			e.printStackTrace();
			System.out.println(e);
		}

		}
```
### :dart:Get current timestamp: <br> 
```	
	public static String timestamp() 
		{
				
		Calendar calaender = Calendar.getInstance();
		String timestp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(calaender.getTime());
		return timestp;
		
		}
```
### :dart:Select value from dropdown by Visibliblty of Text: <br> 
```	
	public static void selctvalue(WebElement element, String value ) 
	{
			
		Select drpvalue = new Select(element);
		drpvalue.selectByVisibleText(value);
	
	}
```
### :dart:Create Folder: <br> 
```	
	public static String checkFolderandCreateFolder(String folderpath) 
	{
			
		File createDir = new File (folderpath);
		if (!createDir.exists())
		{
			createDir.mkdir();
		}
		else
		{
			System.out.println("Folder creted "+folderpath.toString());
		}	
		return createDir.getAbsolutePath().toString();
	
	}
```
### :dart:Check for element exists: <br> 
```	
	public static boolean isElementdisplayed(WebDriver driver, String Xpath) 
	{
		
		if(driver.findElements(By.xpath(Xpath)).size() != 0){
			return true;
			}else{
				return false;
			}				
	}
```
### :dart:Get system Host Name: <br> 
```	
	public static String getHostName()
	{
			
		InetAddress localhost = null;
		try {
			localhost = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			
			e.printStackTrace();
		}
	
		return localhost.getHostName().toString();
	
	}
```
### :dart:Scroll and Highlight Webelement: <br> 
```		
	public static void scrollandhighlight(WebDriver driver, WebElement element) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		js.executeScript("arguments[0].style.border='4px solid red'", element);
		Thread.sleep(2000);
		js.executeScript("arguments[0].style.border=''", element);
	}
```
### :dart:Highlight Webelement: <br> 
```	
	public static void highlightElement(WebDriver driver, WebElement element) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='4px solid yellow'", element);
		Thread.sleep(2000);
		js.executeScript("arguments[0].style.border=''", element);
	}
```
### :dart:Capture ScreenShot: <br> 
```	
	public static String captureScreen(WebDriver driver, String screenshotPath, String fileName, String status) {
		if (fileName == "") {
			fileName = "blank";
		}
		File destFile = null;
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			
			destFile = new File((String) screenshotPath +"/" + fileName + "_" + status + ".png");
			FileUtils.copyFile(scrFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destFile.getAbsolutePath().toString();
	}

```
### :dart:Capture Screenshot Using Robot Class: <br> 
```	
	public static String captureScreen(String screenshotPath, String fileName) {
		if (fileName == "") {
			fileName = "blank";
		}
		Robot r=new Robot();
 		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
 		Rectangle screenRect=new Rectangle(screensize);
 		BufferedImage image=r.createScreenCapture(screenRect);
		try {
			
			destFile = new File((String) screenshotPath +"/" + fileName + ".png");
			 ImageIO.write(image, "png",new File(destFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destFile.getAbsolutePath().toString();
	}

```
### :dart:Capture full Page ScreenShot using AShot : <br> 
```	
	public static String fullPageScreenshot (WebDriver driver, String screenshotPath, String fileName, String status) {
		if (fileName == "") {
			fileName = "blank";
		}
		String destFile = null;
				
		try {
			
			destFile = screenshotPath +"/" + fileName + "_" + status + ".png";
			Screenshot fpScreenshot = new  	AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		     ImageIO.write(fpScreenshot.getImage(),"PNG",new File(destFile));

		} catch (IOException e) {
			e.printStackTrace();
		}
		return destFile;
	}
```
### :dart:Press Tab Key Using Action Class : <br> 
```
	public boolean pressTabKey(Webdriver driver)
 	{
 		Actions act=new Actions(driver);
		act.sendKeys(Keys.TAB).build().perform();
 	}

```
### :dart:Get Browser Name Using JavascriptExecutor : <br> 
```
	public String browserName(Webdriver driver)
 	{
 		JavascriptExecutor js = (JavascriptExecutor) driver;
 		String browsername=js.executeScript("return navigator.appCodeName");
		return browsername;
 	}

```
### :dart:Bootstrap drop down handling in selenium : <br> 
```

	public boolean bootstrapdropdown(WebElement bootstrap, String dropdownValue) 
	{
		// elements and findElements will return list of WebElements

		List<WebElement> list = bootstrap;
		int counter=0;

		for (WebElement ele : list) 
		{ 
			if (ele.getAttribute("innerHTML").contains(dropdownValue)) {
			     ele.click();
			     counter=counter+1;
			     break;
			  }
		 }

		if (counter != 0)    { return true; }
		else { return false; }
	}
```
### :dart:Browser Utility function: <br> 
```
public static  WebDriver browserUtility(String browser, String URL) 
	{
				
		 if(browser.equalsIgnoreCase("chrome")) {			 
			   System.out.println("*** launching chrome browser ***");
			   System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/driver/chromedriver.exe");
			   driver=new ChromeDriver();  			 
		 }else if (browser.equalsIgnoreCase("ie")) { 			 
				  System.out.println("*** launching IE browser ***");
				  System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"/driver/IEDriverServer.exe");
				  driver = new InternetExplorerDriver();
		 }else if (browser.equalsIgnoreCase("edge")) { 			 
					  System.out.println("*** launching Microsoft Edge browser ***");
					  System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"/driver/MicrosoftWebDriver.exe"); 
					  driver = new EdgeDriver();
		 }else if (browser.equalsIgnoreCase("Firefox")) { 			 
			  System.out.println("*** launching Firefox browser ***");
			  System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"/driver/geckodriver.exe"); 
			  driver = new EdgeDriver();
		 }else if (browser.equalsIgnoreCase("headless browser")) { 			 
			  driver = new HtmlUnitDriver(); 
		 } 		
		 driver.navigate().to(URL);
		 driver.manage().window().maximize();
		 driver.manage().timeouts().pageLoadTimeout(property.getpageTimeOut(), TimeUnit.SECONDS);
		 return driver;
	}
```

