package com.Guru.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties prop;  // creating object for Properties
	
	public ReadConfig() // Created constructor 
	{
		File src = new File("./Configurations\\config.properties"); //config file location in project
		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		}  
		catch (Exception e){
			System.out.println("Exception is" + e.getMessage());
		}
	}
	
	public String getAppURL()
	{
		String url = prop.getProperty("baseURL");
		return url;
	}
	
	public String getUserName() 
	{
		String uname = prop.getProperty("username");
		return uname;
	}
	
	public String getPassword()
	{
		String password = prop.getProperty("password");
		return password;
	}

	public String getChromePath()
	{
		String chromePath = prop.getProperty("chromepath");
		return chromePath;
	}
	
	public String getIePath()
	{  
		String IePath = prop.getProperty("iepath");
		return IePath;
	}
		
	public String getFireFoxPath()
	{
		String geckopath = prop.getProperty("firefoxpath");
		return geckopath;
	}
}
