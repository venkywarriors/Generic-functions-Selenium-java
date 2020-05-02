## generate browser logs
```
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Getlogs {

	static String path = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
	private static WebDriver driver;

	public static void main(String[] args) throws Exception {
		
		System.setErr(new PrintStream(new FileOutputStream("Errorlog.txt")));
		
		String downloadPath = String.format("%s/target/downloads/", System.getProperty("user.dir"));

		//Timed out receiving message from renderer: 0.100
		System.setProperty("webdriver.chrome.silentOutput", "true");
		System.setProperty("webdriver.chrome.driver", path);

		ChromeOptions options = new ChromeOptions();
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		Map<String, Object> prefs = new HashMap<>();

		prefs.put("profile.default_content_settings.popups", 0);
		prefs.put("download.prompt_for_download", "false");
		prefs.put("profile.default_content_settings.popups", 0);
		prefs.put("download.default_directory", new File(downloadPath).getPath());
		
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("disable-infobars");
		options.setAcceptInsecureCerts(true);
		options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT_AND_NOTIFY);
		options.addArguments("test-type");
		options.addArguments("--start-maximized");
		options.addArguments("--disable-web-security");
		options.addArguments("--allow-running-insecure-content");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--disable-browser-side-navigation");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--disable-gpu");
		options.addArguments("--disable-extensions");
		options.addArguments("--dns-prefetch-disable");
		options.addArguments("--disable-geolocation");
				
		capabilities.setCapability(CapabilityType.SUPPORTS_APPLICATION_CACHE, false);
		capabilities.setCapability(ChromeOptions.CAPABILITY,options);

		driver = new ChromeDriver(capabilities);

		driver.manage().window().maximize(); // maximize window
		driver.manage().deleteAllCookies(); // delete all the cookies

		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://boattrader.com");
		driver.quit();
	}
}
```
:page_facing_up::page_facing_up::page_facing_up::page_facing_up::page_facing_up::page_facing_up::page_facing_up::page_facing_up:
`May 02, 2020 10:46:47 AM org.openqa.selenium.remote.DesiredCapabilities chrome
INFO: Using `new ChromeOptions()` is preferred to `DesiredCapabilities.chrome()`
Starting ChromeDriver 81.0.4044.69 (6813546031a4bc83f717a2ef7cd4ac6ec1199132-refs/branch-heads/4044@{#776}) on port 14800
Only local connections are allowed.
Please protect ports used by ChromeDriver and related test frameworks to prevent access by malicious code.
May 02, 2020 10:46:55 AM org.openqa.selenium.remote.ProtocolHandshake createSession
INFO: Detected dialect: W3C
[1588396617.397][SEVERE]: Timed out receiving message from renderer: 0.100
[1588396617.503][SEVERE]: Timed out receiving message from renderer: 0.100
[1588396617.608][SEVERE]: Timed out receiving message from renderer: 0.100
[1588396617.712][SEVERE]: Timed out receiving message from renderer: 0.100
[1588396617.815][SEVERE]: Timed out receiving message from renderer: 0.100`
