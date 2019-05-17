
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

