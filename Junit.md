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
