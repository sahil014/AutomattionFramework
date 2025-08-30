package com.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.constants.Environment;

public class PropertiesUtil {

	 public static String readProperty(Environment env, String propertyname) {
		 System.out.println(System.getProperty("user.dir"));
		 File propFile=new File(System.getProperty("user.dir")+"//config"+"//"+env+".properties");
		 FileReader fileReader=null;
		 Properties properties=new Properties();
		 try {
		 fileReader=new FileReader(propFile);
		 properties.load(fileReader);
		 }
		 catch(FileNotFoundException e){
			 e.printStackTrace();
		 }
		 
		 catch(IOException e) {
			 e.printStackTrace();
		 }
		 return properties.getProperty(propertyname.toUpperCase());
	 }
}
