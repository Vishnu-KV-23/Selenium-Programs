import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static ConfigReader instance;
    private static Properties properties;
    private static final String filePath="RegistationDetails.properties";

    private ConfigReader() {
        
        //  It takes the filePath as input, sets up a FileInputStream to read the contents of the specified file.
        //  It loads the properties into the properties object.
    	try {
            FileInputStream fis = new FileInputStream(filePath);
            properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ConfigReader getInstance() {
        
        // Creates a new ConfigReader instance and returns it.
    	if (instance == null) {
            instance = new ConfigReader();
        }
        return instance;
    } // Inserted semicolon here

    public String getProperty(String key) {
        // Returns the value associated with the specified key from the properties file.
    	return properties.getProperty(key);
    }
}