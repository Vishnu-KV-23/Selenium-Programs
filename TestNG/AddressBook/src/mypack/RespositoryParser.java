package mypack;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

public class RespositoryParser {
	private FileInputStream stream;
	private String RepositoryFile;
	private Properties propertyFile = new Properties();

	public RespositoryParser(String fileName) throws IOException
	{
		this.RepositoryFile = fileName;
		stream = new FileInputStream(RepositoryFile);
		propertyFile.load(stream);
	}

	public String getObjectLocator(String locatorName)
	{
		String locatorProperty = null;
		// write code to return the value based on the given input property
		locatorProperty = propertyFile.getProperty(locatorName);
		return locatorProperty;
	}
}