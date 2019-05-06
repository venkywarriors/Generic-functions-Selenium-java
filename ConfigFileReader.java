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
