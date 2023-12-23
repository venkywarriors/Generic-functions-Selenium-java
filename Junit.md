### :dart: Parameterize Test cases in JUnit 4
JUnit 4 provides parameterized tests using the `@Parameters` annotation and the Parameterized runner
```
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ParameterizedTestExample {

    private int a;
    private int b;
    private int expectedSum;

    // Constructor with parameters
    public ParameterizedTestExample(int a, int b, int expectedSum) {
        this.a = a;
        this.b = b;
        this.expectedSum = expectedSum;
    }

    // Define the parameters using the @Parameters annotation
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {2, 3, 5},
                {5, 7, 12},
                {10, 5, 15}
        });
    }

    // Test method that uses the parameters
    @Test
    public void testAddition() {
        int sum = Calculator.add(a, b);
        assertEquals(expectedSum, sum);
    }
}
```
- The `@RunWith(Parameterized.class)` annotation indicates that the test class will use the Parameterized runner.
- The constructor of the test class takes parameters, and the `@Parameters` annotation is used on a method (data()) to provide parameter values.
- The data() method returns a collection of arrays, where each array represents a set of parameters for a test run.
- The `@Test` annotation is used to indicate the test method (testAddition).

### :dart: Parameterize Test cases in JUnit 5
In JUnit 5, parameterized tests can be achieved using the `@ParameterizedTest` annotation along with various argument sources
#### @CsvSource Example
```
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParameterizedTestExample {

    @ParameterizedTest
    @CsvSource({ "2, 3, 5", "5, 7, 12", "10, 5, 15" })
    @DisplayName("Addition Test")
    public void testAddition(int a, int b, int expectedSum) {
        int sum = Calculator.add(a, b);
        assertEquals(expectedSum, sum, () -> a + " + " + b + " should equal " + expectedSum);
    }
}
```
#### `@CsvFileSource` Example
```
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CsvFileSourceExample {

    @ParameterizedTest
    @CsvFileSource(resources = "/test_data.csv")
    public void testAddition(int a, int b, int expectedSum) {
        int sum = Calculator.add(a, b);
        assertEquals(expectedSum, sum, () -> a + " + " + b + " should equal " + expectedSum);
    }
}
```
#### `@ValueSource` Example
```
 import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValueSourceExample {

    @ParameterizedTest
    @ValueSource(strings = { "apple", "banana", "cherry" })
    public void testStringLength(String fruit) {
        assertTrue(fruit.length() > 0, () -> "Length of " + fruit + " should be greater than 0");
    }
}
```
### :dart: Parallel execution of test cases <br>
JUnit 5 does not inherently provide built-in support for parallel execution of test cases, as each test method is designed to be independent of others. However, you can leverage external tools or plugins to achieve parallel execution. One such tool is the `junit-platform-parallel` plugin.
<br>You can then run your tests with parallel execution using the following command:
```
mvn test -Djunit.jupiter.extensions.autodetection.enabled=true
```
```
./gradlew test --tests * --rerun-tasks
```
### :dart: Selenium JUnit test class 
```
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class ScreenshotTest {

    private WebDriver driver;

    @Rule
    public TestWatcher screenshotOnFailure = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            captureScreenshot(description.getMethodName());
        }
    };

    @Test
    public void testLoginWithValidCredentials() {
        initializeWebDriver();
        // Your test logic here for a successful scenario
    }

    @Test
    public void testLoginWithInvalidCredentials() {
        initializeWebDriver();
        // Your test logic here for a failed scenario
        WebElement errorMessage = driver.findElement(By.id("error-message"));
        assert errorMessage.isDisplayed() : "Error message should be displayed";
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private void initializeWebDriver() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://example.com");
    }

    private void captureScreenshot(String methodName) {
        try {
            if (driver instanceof TakesScreenshot) {
                TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
                File screenshotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

                Path destinationPath = Path.of("screenshots", methodName + ".png");
                Files.copy(screenshotFile.toPath(), destinationPath, StandardCopyOption.REPLACE_EXISTING);

                System.out.println("Screenshot captured: " + destinationPath.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

```
### :dart: @DisplayName Annotation
- Allows you to provide a custom display name for a test class or method.
- Useful for creating more human-readable and expressive test names.
```
@DisplayName("Custom Test Class")
public class MyTestClass {
    // Test methods go here...
}

@Test
@DisplayName("Custom Test Method")
public void myTestMethod() {
    // Test logic goes here...
}

```
### :dart: @Disabled Annotation 
- Marks a test class or method as disabled or ignored.
- Test methods annotated with @Disabled will not be executed.
```
@Disabled("Not ready for execution")
@Test
public void disabledTest() {
    // Test logic goes here...
}
```
### :dart: @EnabledIfEnvironmentVariable Annotation 
Enables or disables a test based on the value of an environment variable.
```
@EnabledIfEnvironmentVariable(named = "ENV", matches = "stage")
@Test
public void testForStageEnvironment() {
    // Test logic goes here...
}
```
### :dart: @EnabledOnOs / @DisabledOnOs Annotation 
Enables or disables a test based on the operating system
```
@EnabledOnOs(OS.WINDOWS)
@Test
void testForWindows() {
    // Test logic
}

@DisabledOnOs(OS.LINUX)
@Test
void disabledForLinux() {
    // Test logic
}
```
### :dart: @EnabledIfSystemProperty / @DisabledIfSystemProperty Annotation 
Enables or disables a test based on the value of a system property.
```
@EnabledIfSystemProperty(named = "environment", matches = "dev")
@Test
void testForDevEnvironment() {
    // Test logic
}

@DisabledIfSystemProperty(named = "ci", matches = "true")
@Test
void disabledForCI() {
    // Test logic
}
```
### :dart: Create custom annotations to group test cases
Define Custom Annotation
```
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Tag("nightRun")
@Test
public @interface NightRun {
}
```
Apply the Custom Annotation and Extension in Tests
```
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

public class Regression1TestClass {

    @NightRun
    void regression1Test1() {
        // Test logic for regression1
    }

    @Test
    void regression1Test2() {
        // Test logic for regression1
    }
}

```
