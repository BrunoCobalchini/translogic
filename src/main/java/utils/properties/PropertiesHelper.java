package utils.properties;

import utils.browserManager.ChromeDriverManager;

import java.io.File;
import java.net.URISyntaxException;

public class PropertiesHelper {

    //Dir path to upload (path na estrutura do projeto)
    public static final String pathToUpload = System
            .getProperty("user.dir")
            .concat(File.separator)
            .concat("src")
            .concat(File.separator)
            .concat("test")
            .concat(File.separator)
            .concat("java")
            .concat(File.separator)
            .concat("resources")
            .concat(File.separator)
            .concat("upload")
            .concat(File.separator);

    public static final String pathToDownload = System
            .getProperty("user.dir")
            .concat(File.separator)
            .concat("src")
            .concat(File.separator)
            .concat("test")
            .concat(File.separator)
            .concat("java")
            .concat(File.separator)
            .concat("resources")
            .concat(File.separator)
            .concat("download")
            .concat(File.separator);

    //Dir path (pasta Downloads do windows)
    public static String uploadPath;
    public static String downloadPath;

    //Dir path do chromedriver
    public static final String pathToWebDriver = System
            .getProperty("user.dir")
            .concat(File.separator)
            .concat("src")
            .concat(File.separator)
            .concat("main")
            .concat(File.separator)
            .concat("resources")
            .concat(File.separator)
            .concat("drivers")
            .concat(File.separator);

    //Selenium GRID
    public static String urlSeleniumGRID;
    public static String executionType;

    //Framework settings
    public static String waitTime;
    public static String highlight;

    //URL Systems
    public static String urlMvn;
    public static String urlGoogle;

    //DB settings
    public static String driverDB;
    public static String urlDB;
    public static String usernameDB;
    public static String passwordDb;

    //GOP Users
    public static String username;
    public static String password;

    public static void initializeProps(){
        PropertiesManager setupProperties = null;
        try {
            setupProperties = new PropertiesManager(ChromeDriverManager.class.getClassLoader().getResource("setup.properties").toURI().getPath());
        } catch (URISyntaxException e) {
            try {
                throw new Exception("Erro ao carregar o aquivo setup.properties");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
        urlSeleniumGRID = setupProperties.getProps().getProperty("urlSeleniumHub");
        executionType = setupProperties.getProps().getProperty("executionType");
        waitTime = setupProperties.getProps().getProperty("waitTime");
        highlight = setupProperties.getProps().getProperty("highlight");
        uploadPath = setupProperties.getProps().getProperty("uploadPath");
        urlMvn = setupProperties.getProps().getProperty("urlMvn");
        urlGoogle = setupProperties.getProps().getProperty("urlGoogle");
        username = setupProperties.getProps().getProperty("userGOP");
        password = setupProperties.getProps().getProperty("passGOP");
        driverDB = setupProperties.getProps().getProperty("driverDB");
        urlDB = setupProperties.getProps().getProperty("urlDB");
        usernameDB = setupProperties.getProps().getProperty("usernameDB");
        passwordDb = setupProperties.getProps().getProperty("passwordDb");


    }

}
