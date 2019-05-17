
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
Understanding the code
Bufferedimage: It is used to handle and manipulate the image data.
ImageIO.read: To perform the image read-write operation we will import the ImageIO class.
LuminanceSource: The examples are extracted from open source    Java projects.
BufferedImageLuminanceSource: Always use the returned object, and ignore the length of the array.
BinayBitmap: This class is the core bitmap class used by ZXing to represent 1-bit data. Reader objects accept a BinaryBitmap and attempt to decode it.
HybridBinarizer: It is designed for high scale images of QR code with black data on white backgrounds. This Binarizer is the default for the unit tests and the recommended class for library users.
MultiFormatReader(): By default, it attempts to decode all QR Code formats that the library supports. Optionally, you can provide a hints object to request different behavior, for example only decoding QR codes.
