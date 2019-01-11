package library;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfigFile {
	Properties pro;
	public ReadConfigFile(String filepath) {
		
		try {
			FileInputStream fis = new FileInputStream(filepath);
			pro= new Properties();
			pro.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			
		}
		
	}
	public String getKeyValue(String key)
	{
	 return pro.getProperty(key);
	 
	}
}
