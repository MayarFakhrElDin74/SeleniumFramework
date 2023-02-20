package data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {
	
	
	// Load the properties file from the folder
	
	public static Properties userData = LoadProperties
		(System.getProperty("user.dir") + "\\src\\main\\java\\properties\\userdata.properties") ;
	

	
	private static Properties LoadProperties (String path) throws IOException

{
	Properties pro = new Properties() ;
	
	// stream for reading file
	FileInputStream stream = new FileInputStream(path) ;
	pro.load(stream);
	
	return pro ;
}

}
