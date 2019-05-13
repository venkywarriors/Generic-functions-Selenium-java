
### :dart:The basic syntax for JavascriptExecutor is given below: <br> 

```




public class testbase {
	
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
	
	public static String timestamp() 
		{
				
		Calendar calaender = Calendar.getInstance();
		String timestp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(calaender.getTime());
		return timestp;
		
		}
	
	public static void selctvalue(WebElement element, String value ) 
	{
			
		Select drpvalue = new Select(element);
		drpvalue.selectByVisibleText(value);
	
	}
	
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
	
	public static boolean isElementdisplayed(WebDriver driver, String Xpath) 
	{
		
		if(driver.findElements(By.xpath(Xpath)).size() != 0){
			return true;
			}else{
				return false;
			}				
	}
	
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
	

	
	public static void scrollANDhighlight(WebDriver driver, WebElement element) throws InterruptedException  {
		// Creating JavaScriptExecuter Interface
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		js.executeScript("arguments[0].style.border='4px solid yellow'", element);
		Thread.sleep(2000);
		js.executeScript("arguments[0].style.border=''", element);
	}
	
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
	
	public static void highlightElement(WebDriver driver, WebElement element) throws InterruptedException {
		// Creating JavaScriptExecuter Interface
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='4px solid yellow'", element);
		Thread.sleep(2000);
		js.executeScript("arguments[0].style.border=''", element);
	}
	
	public static String captureScreen(WebDriver driver, String screenshotPath, String fileName, String status) {
		if (fileName == "") {
			fileName = "blank";
		}
		File destFile = null;
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			
			destFile = new File((String) screenshotPath +"/" + fileName + "_" + status + ".png");
			FileUtils.copyFile(scrFile, destFile);
			// This will help us to link the screen shot in testNG report
			//Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destFile.getAbsolutePath().toString();
	}
	
	
	
	public static String fullPageScreenshot (WebDriver driver, String screenshotPath, String fileName, String status) {
		if (fileName == "") {
			fileName = "blank";
		}
		String destFile = null;
				
		try {
			
			destFile = screenshotPath +"/" + fileName + "_" + status + ".png";
			Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		     ImageIO.write(fpScreenshot.getImage(),"PNG",new File(destFile));

		} catch (IOException e) {
			e.printStackTrace();
		}
		return destFile;
	}
	
	public static String webElementScreenshot (WebDriver driver, WebElement element ,String screenshotPath, String fileName, String status) {
		if (fileName == "") {
			fileName = "blank";
		}
		String destFile = null;
				
		try {
			
			destFile = screenshotPath +"/" + fileName + "_" + status + ".png";
			Screenshot fpScreenshot = new AShot().takeScreenshot(driver,element);
		     ImageIO.write(fpScreenshot.getImage(),"PNG",new File(destFile));

		} catch (IOException e) {
			e.printStackTrace();
		}
		return destFile;
	}
	
	

}
```

