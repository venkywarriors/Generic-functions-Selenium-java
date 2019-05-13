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
		// Creating JavaScriptExecuter Interface
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();
		js.executeScript("arguments[0].style.border='4px solid red'", element);
		Thread.sleep(2000);
		js.executeScript("arguments[0].style.border=''", element);
	}
```
### :dart:Highlight Webelement: <br> 
```	
	public static void highlightElement(WebDriver driver, WebElement element) throws InterruptedException {
		// Creating JavaScriptExecuter Interface
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
### :dart:Capture full Page ScreenShot using AShot : <br> 
```	
	public static String fullPageScreenshot (WebDriver driver, String screenshotPath, String fileName, String status) {
		if (fileName == "") {
			fileName = "blank";
		}
		String destFile = null;
				
		try {
			
			destFile = screenshotPath +"/" + fileName + "_" + status + ".png";
			Screenshot fpScreenshot = new  AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		     ImageIO.write(fpScreenshot.getImage(),"PNG",new File(destFile));

		} catch (IOException e) {
			e.printStackTrace();
		}
		return destFile;
	}
```

