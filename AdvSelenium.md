### :dart:What is Page Object Model in Selenium? <br> 
Page Object Model, also known as POM is a design pattern in Selenium that creates an object repository for storing all web elements. It is useful in reducing code duplication and improves test case maintenance.
<br> Code Snippet: Without page factory 
```
package StackPages;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BrowserStackHomePage {

WebDriver driver;
By Header=By.xpath("//h1");
By getStarted=By.xpath("//*[@id='signupModalButton']");

public BrowserStackHomePage(WebDriver driver) {
this.driver=driver;
}

public void veryHeader() {
String getheadertext=driver.findElement(Header).getText();
assertEquals("App & Browser Testing Made Easy", getheadertext);
}
public void clickOnGetStarted() {
driver.findElement(getStarted).click();
}
}
```
<strong>What is Page Factory in Selenium? </strong> <br> 
Page Factory is a class provided by Selenium WebDriver to support Page Object Design patterns. In Page Factory, testers use @FindBy annotation. The initElements method is used to initialize web elements.<br> 
<strong>@FindBy :</strong>An annotation used in Page Factory to locate and declare web elements using different locators. Below is an example of declaring an element using @FindBy <br> 
<strong>initElements() :</strong>initElements is a static method in Page Factory class. Using the initElements method, one can initialize all the web elements located by @FindBy annotation. <br> 
```
initElements(WebDriver driver, java.lang.Class pageObjectClass)
```
<strong>@FindBys :</strong> When the required WebElement objects need to match all of the given criteria use @FindBys annotation <br> 
```
@Findbys({
    @FindBy(className = "A"),
    @FindBy(className = "B")
})
public WebElement AB;
```
<strong>@FindAll :</strong> When required WebElement objects need to match at least one of the given criteria use @FindAll annotation <br> 
```
@FindAll({ 
    @FindBy(how = How.NAME, using = "x"), 
    @FindBy(className = "gLFyf gsfi") 
})
private WebElement searchText;
```
<strong>lazy initialization :</strong> AjaxElementLocatorFactory is a lazy load concept in Page Factory. This is used to identify web elements only when they are used in any operation or activity. It assigns a timeout for WebElements to the object page class. One of the key advantages of using PageFactory pattern is AjaxElementLocatorFactory Class.
Here, when an operation is performed on an element the wait for its visibility starts from that moment only. If the element is not found in the given time interval, Test Case execution will throw 'NoSuchElementException' exception.
![Ajax Pom](https://www.guru99.com/images/AdvanceSelenium/071514_0722_PageObjectM11.png)
<br><strong>'How’ </strong> is a class and it has static variables like ID, XPATH, CLASSNAME, LINKTEXT, etc. <br> 
<strong>‘using’ </strong> – To assign a value to a static variable.<br>
```
@FindBy(how = How.ID, using="EmailAddress") 
WebElement Email;

@FindBy(id="EmailAddress") 
WebElement Email;
```
<strong>@CacheLookUp :</strong>
PageFactory annotation @CacheLookup is used to mark the WebElements once located so that the same instance in the DOM can always be used. CacheLookup attribute can be used to instruct the InitElements() method to cache the element once its located and so that it will not be searched over and over again. 

It is useful when the elements that are always going to be there. For AJAX based applications, it may not work where the DOM changes based on user action on the page, otherwise every time when we use a Web Element the WebDriver will go and search it again
```
@FindBy(id="firstname") 
@CacheLookup 
private WebElement userName;
```
<strong>We should also understand that POM follows OOPS principles.</strong>
1) WebElements are declared as private member variables (Data Hiding).
2) Binding WebElements with corresponding methods (Encapsulation).<br> 
Code Snippet: With page factory
```
package StackPages;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrowserStackHomePage {

WebDriver driver;

@FindBy(xpath = "//h1")
WebElement Header;
@FindBy(xpath = "//*[@id='signupModalButton']")
WebElement getStarted;

public BrowserStackHomePage(WebDriver driver) {
this.driver = driver;
PageFactory.initElements(driver, this);
}

public void veryHeader() {
String getheadertext = Header.getText();
assertEquals("App & Browser Testing Made Easy", getheadertext);
}

public void clickOnGetStarted() {
getStarted.click();
}
}
```
### :dart:Record your Test Execution in Selenium : <br> 
Monte Screen Recorder, a Java library that can assist you in creating videos of your Selenium tests. Add Screen Recorder
Maven Dependencies

How to Implement in our project :

We have one Java File of Recording screen functionality written and have attached as java file name as 'MyScreenRecorder.java' file

This <a href="https://github.com/venkywarriors619/Generic-functions-Selenium-java/blob/master/MyScreenRecorder.java">'MyScreenRecorder.java'</a> file is the base function and we can use the method as 'MyScreenRecorder.startRecording("yourtestcase_recording")' in our own test case file.

For Example : Your Java file has the navigation function and if you want to record some scenarios, then we can use the method as 'MyscreenRecorder.startRecording' to start record and 'MyScreenRecorder.stopRecording' to stop the record.
Reference Link: http://www.randelshofer.ch/monte/
```
@Test
public void navigation() throws Exception{

  MyScreenRecorder.startRecording("Navigation_recording");
  
  /*
                       your code goes here
                */
               MyScreenRecorder.stopRecording();

}
```
### :dart:Sample Script-Integrate Sikuli with Selenium Webdriver
```
```
### :dart:How to read QR Code or Barcode from Images: <br> 
Add Zxing libraries 'zxing-core-*.*.jar' , 'zxing-javase-*.*.jar' from the maven repository.
```
public void testQRCode()
{
    System.setProperty("webdriver.chrome.driver", "chromedriver.exe path");
    WebDriver driver = new chromeDriver();
    driver.manage().window().maximize();
    driver.get(" C:\\Users\\Prateek\\Desktop\\QR_Code_Updated.png");

    String qrCodeFileUrl =         driver.findElement(By.tagName("img")).getAttribute("src");
    System.out.println("QR Code Image URL is : " +qrCodeFileUrl);

    URL urlOfImage = new URL(qrCodeFileUrl);
    BufferedImage bufferedImage = ImageIO.read(urlOfImage);
    LuminanceSource luminanceSource = new BufferedImageLuminanceSource(bufferedImage);
    BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(LuminanceSource));
    Result result = new MultiFormatReader().decode(binaryBitmap);
    String textInQrCode = result.getText();
    System.out.println("The Text in QR Code is : "+textInQrCode);
}
```
<strong>Understanding the code</strong><br>
<strong>Bufferedimage: </strong>It is used to handle and manipulate the image data.<br>
<strong>ImageIO.read: </strong>To perform the image read-write operation we will import the ImageIO class.<br>
<strong>LuminanceSource:</strong> The examples are extracted from open source    Java projects.<br>
<strong>BufferedImageLuminanceSource: </strong>Always use the returned object, and ignore the length of the array.<br>
<strong>BinayBitmap: </strong>This class is the core bitmap class used by ZXing to represent 1-bit data. Reader objects accept a BinaryBitmap and attempt to decode it.<br>
<strong>HybridBinarizer:</strong> It is designed for high scale images of QR code with black data on white backgrounds. This Binarizer is the default for the unit tests and the recommended class for library users.<br>
<strong>MultiFormatReader():</strong> By default, it attempts to decode all QR Code formats that the library supports. Optionally, you can provide a hints object to request different behavior, for example only decoding QR codes.<br>
### :dart:Test Data Generation Using FAKER API in JAVA: <br> 
Add faker libraries 'javafaker' from the maven repository.
```
Faker faker = new Faker();

String name = faker.name().fullName(); // Miss Samanta Schmidt
String firstName = faker.name().firstName(); // Emory
String lastName = faker.name().lastName(); // Barton
String streetAddress = faker.address().streetAddress(); // 60018 Sawayn Brooks Suite 449
```
### :dart:Test Data Generation Using JFairy in JAVA: <br> 
Add faker libraries 'jfairy' from the maven repository.
```
Fairy fairy = Fairy.create();
Person person = fairy.person();

System.out.println(person.getFirstName()); // Chloe Barker
System.out.println(person.getEmail()); // barker@yahoo.com
System.out.println(person.getTelephoneNumber()); // 690-950-802

Person adultMale = fairy.person(PersonProperties.male(), PersonProperties.minAge(21));
System.out.println(adultMale.isMale()); // true
System.out.println(adultMale.getDateOfBirth()); // at least 21 years earlier

Person salesman = fairy.person(PersonProperties.withCompany(company));
System.out.println(salesman.getFullName()); // Juan Camacho
System.out.println(salesman.getCompanyEmail()); // juan.camacho@robuteniaassociates.com

fairy.networkProducer().ipAddress(); //12.205.88.19
fairy.textProducer().latinWord(); //pede consequat aliquet
fairy.creditCard().getVendor(); //Visa
fairy.company().getUrl(); //http://www.quisuc.biz
```
### :dart:Test Data Generation Using JFairy in JAVA: <br> 
Add faker libraries 'fabricator_2.10' from the maven repository.
Alphanumeric
------------
This module allows you to generate any random number or string. As for strings, you can generate either fully random string,
or you can generate string basing on a pattern.

```scala

val alpha = fabricator.Alphanumeric() // initialize alpha numeric module

alpha.numerify("###ABC") // 981ABC

alpha.letterify("???123") // LsQ123

alpha.botify("???###") // AbC329

alpha.randomInteger // random integer in 0 to 1000 range

alpha.randomInteger(100) // random integer in 0 to 100 range

alpha.randomInteger(200, 300) // random integer in 200 to 300 range

alpha.randomIntegerRangeAsScalaList(1,10,1) // will return scala List[1,2,3,4,5,6,7,8,9,10]
 
alpha.randomIntegerRangeAsJavaList(1,10,1) // will return List<Object>[1,2,3,4,5,6,7,8,9,10] . Each element need to be casted to Integer

alpha.randomHash // d750c843c83a3a980082361e72aa41ac48975eab

alpha.randomGuid // ed7592b7-11e4-5f7f-b83f-488733c8bc56
```
Calendar
--------

 This module allows you to generate random time or time.

```scala

val calendar = fabricator.Calendar() // initialize calendar module

calendar.time12h // 03:15

calendar.time24h // 15:15

calendar.month(asNumber = false) // December

calendar.month(asNumber = true) // 12

calendar.date.asString // 10-02-2014

calendar.date.asString(DateFormat.dd_MMM_yyyy_SEMICOLON) // 10:DEC:2014

calendar.date.asDate // random Date object

calendar.date.inYear(2014).inDay(10).inMinute(10).asString // random date in 2014 year, that happened in 10th day of random month in 10th minute of random hour

calendar.relativeDate.years(2).weeks(1).seconds(-20).asDate // get relative date that is 2 years and 1 weeks in the future and 20 seconds behind (since current time)

calendar.relativeDate(DateTime.now().plusDays(1)).tomorrow().asString // 2 days since now as a string with default formatting

calendar.relativeDate(DateTimeZone.UTC).tomorrow().asString(DateFormat.dd_MM_yy) // tomorrows date in UTC time zone with custom formatting

calendar.datesRange
        .startYear(2010)
        .startMonth(1)
        .startDay(1)
        .stepEvery(1, DateRangeType.DAYS)
        .endYear(2011)
        .endMonth(1)
        .endDay(1)
        .asList // list of dates between 2010-1-1 and 2011-1-1 with a step of 1 day between each date 
```

Contact
--------

  This module allows you to generate random person data

```scala

val contact = fabricator.Contact()

contact.fullName // Betty Corwin

contact.birthday(25) // 26.12.1989 (current year - 25 with default format dd.MM.yyyy)

contact.bsn // 730550370 (equivalent of a national ID number)

contact.eMail // Rebecca_Kohler506@yahoo.com

contact.phoneNumber // (792)273-4251 x012

contact.postCode //  44274-6580

contact.state // Alaska

contact.height(true) // 188 cm

contact.height(false) // 1.88 m

contact.weight // 108 kg

contact.bloodType // A-

contact.occupation // Craft Artist

contact.religion // sikhism

contact.zodiac // Taurus

``` 
Finance
--------
  
This module allows you to generate random finance data
  
```scala

val finance = fabricator.Finance() // initialize finance module

finance.iban // GB91ROYC80901351879409

finance.bic // CLSBUS33XXX

finance.visacreditCard // 4556623851035641

finance.visacreditCard(15) // 455662622900006

finance.pincode // 1234
```
Mobile
--------

This module allows you to generate random mobile operating systems push tokens

```scala

val mobile = fabricator.Mobile() // initialize mobile module

mobile.androidGsmId // APA91fCUNiRP-xKj0qBUoJgGWYnN3zFoznbFL61BkWktXCPTYgw4Xe7phJ3zhOEVYJ4ToZvYTp2f0PPHeNSmYHajXr9fwbDarFh8zTGVz3I54ffViW4Nl8s6XLs7i9lIi3oUeRI5bOx49wIC9EF-IwBcuOT-MQ-Nrw1GUW0cJco1Dti4nAtW7Xx

mobile.applePushToken // a6cc474cd81a9697c2a232744dfdb7ec3f8c72977cd91c23e6ac8e8f75c56697

mobile.wp8_anid2 // Windows Phone 8 ANID2 - YjBUN0hmYWV1VVEyZ2xIYnZWOWMwaGFoVUhlYlFq

mobile.wp7_anid // Windows Phone 7 ANID - A=AC59226C42245673ABE85A32A8EBCACE&E=aed&W=3
```

Words
--------

This module allows you to generate random words, sentences and even blocks of text

```scala

val words = fabricator.Words() // initialize word module

words.word // random word

words.words(10) // array with 10 words

words.sentence(20) // sentence out of 20 words

words.paragraph // 100 chars length block of text

words.paragraph(2000) // 2000 chars length block of text
```

