package utils.properties;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesManager {
    private final Properties props = new Properties();
    private final String filePath;

    /**
     * Constructor for getting data from a properties file
     *
     * @param filePath set path of the properties file
     */
    public PropertiesManager(String filePath) {
        this.filePath = filePath;
    }

    /**
     * @return java.util.Properties
     */
    public Properties getProps() {
        try {
            File file = new File(filePath);
            FileInputStream fileInputStream = new FileInputStream(file);
            props.load(fileInputStream);
            fileInputStream.close();
        } catch (Exception e) {
            //addLogToReport(e.getMessage());
        }
        return props;
    }

}
