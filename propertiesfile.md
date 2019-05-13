# How do I read a properties file?
### The Java Properties class offers a very convenient method of storing data for your application. It consists of various String values and String keys that you use to look up these values. It is basically a hashtable. The load method of the Properties class offers a very convenient mechanism for loading key/value String pairs from a properties file in the file system.
### An Advantage of the properties file
#### Recompilation is not required if the information is changed from a properties file: If any information is changed from the properties file, you don't need to recompile the java class. It is used to store information which is to be changed frequently.
### :dart:Sample JAVA code to read data from properties file is given below: <br> 

```
package Raga;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;

public class ConfigFileReader {
	
	private Properties prop;
	private static String propertyFilePath = System.getProperty("user.dir")+"/Configuation.properties";
		
	public ConfigFileReader(){
		
		try {
		BufferedReader reader = new BufferedReader(new FileReader(propertyFilePath));
		prop = new Properties();
		prop.load(reader);
		reader.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getdataSheetPath() {
		
		String dataSheetPath = prop.getProperty("dataSheetPath");
		if(dataSheetPath!=null)
			return dataSheetPath;
		else
			throw new RuntimeException("Driver Path not Specified");
		
	}
	
	
	public String getScreenshotsPath() {
		
		String screenshots = prop.getProperty("screenshots");
		if(screenshots!=null)
			return screenshots;
		else
			throw new RuntimeException("excelPath not Specified");
		
	}
	
	public String getExtentreportPath() {
		
		String screenshots = prop.getProperty("screenshots");
		if(screenshots!=null)
			return screenshots;
		else
			throw new RuntimeException("excelPath not Specified");
		
	}


}
```
