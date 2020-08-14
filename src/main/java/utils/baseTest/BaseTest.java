package utils.baseTest;

import io.cucumber.java.Scenario;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.annotation.Nullable;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.*;

import static utils.browserManager.ChromeDriverManager.getDriver;
import static org.testng.Assert.*;
import static utils.properties.PropertiesHelper.*;


public class BaseTest {
    int TIME_WAIT = Integer.parseInt(waitTime);
    public static ThreadLocal<Scenario> testScenario = new ThreadLocal<>();
    private static final int LIMIT_RANDOM = 99999999; //variável usada no método getRandomNumber
    private static String typeOfFormat = "dd/MM/yyyy HH:mm:ss";
    private static DateFormat df = null;


    public WebDriver driver = getDriver();

    //**** Navigate methods ****
    public void goToURL(String url){
        driver.navigate().to(url);
    }

    public void getCurrentURL(){
        driver.getCurrentUrl();
    }

    protected void switchTabX(){

        List<String> list = new ArrayList<>();
        String currentWindow = driver.getWindowHandle();
        list.add(currentWindow);

        for(String allWindows : driver.getWindowHandles()){
            list.add(allWindows);
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.isEmpty()){
                throw new IllegalStateException("List can't be empty");
            } else if (!list.get(i).equals(currentWindow)) {
                driver.switchTo().window(list.get(i));
                System.out.println("Switched to: " + list.get(i));
            }
        }

    }
    //**** sendKeys, highlight, scroll, wait and click methods ****
    public void sendKeys(WebElement element, String value) {
        try {
            exist(element);
            highlightElement(element);
            element.sendKeys(value);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
    public void clickAndHighlight(WebElement element) {
        try {
            exist(element);
            highlightElement(element);
            element.click();
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
    public void clickAndHighlightJavaScript(WebElement element){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        highlightElement(element);
        js.executeScript("arguments[0].click();", element);

    }
    public void highlightElement(WebElement element) {
        try {
            if (highlight != null && highlight.equalsIgnoreCase("true")) {
                for (int i = 0; i < 2; i++) {
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    Thread.sleep(150);
                    js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
                    Thread.sleep(200);
                    js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element);
                }
            }
        } catch (Exception e) {
            fail("Elemento não encontrado: " + e);
        }
    }
    public void selectElement(WebElement element, String item) {
        try {
            exist(element);
            highlightElement(element);
            Select select = new Select(element);
            select.selectByVisibleText(item);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
    public void exist(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, TIME_WAIT);
            wait.until(ExpectedConditions.visibilityOf(element));
            //element = wait.until(ExpectedConditions.visibilityOf(element));
            //highlightElement(element);
        } catch (Exception e) {
            fail("Elemento esperado não foi encontrado: " + e.getMessage());
        }
    }
    public void existFrame(String nameOrId) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, TIME_WAIT);
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(nameOrId));
        } catch (Exception e) {
            fail("iFrame esperado não foi encontrado: " + e.getMessage());
        }
    }
    public void waitButtonClickable(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, TIME_WAIT);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            clickAndHighlight(element);
            //element = wait.until(ExpectedConditions.visibilityOf(element));
            //highlightElement(element);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
    public void waitTime(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public boolean isDisplayed(WebElement element){

        try{
            System.out.println("Waiting in isDisplayed method");
            waitTime(1500);
            element.isDisplayed();
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e){
            return false;
        }

    }
    public void scrollToElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public void scrollByPixel(int x, int y){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript ("window.scrollBy (" + x + ", " + y + ")");
    }

    //**** String and text methods ****
    public String getText(WebElement element) {
        try {
            waitTime(2000);
            exist(element);
            highlightElement(element);
            return element.getText();
        } catch (Exception e) {
            fail(e.getMessage());
            return null;
        }
    }

    //**** Number and date methods ****
    public static int getRandomNumber(@Nullable Integer limite) {
        if (limite != null) {
            return new Random().nextInt(limite);
        } else {
            return new Random().nextInt(LIMIT_RANDOM);
        }
    }
    public boolean getRandomBoolean(){
        return Math.random() < 0.5;
    }
    protected String getRandomAlphanumeric(int lenghtString) {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < lenghtString) { //length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
    public static String getRandomString(int lenghtString) {
        String chars = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder(lenghtString);
        Random rnd = new Random();
        for (int i = 0; i < lenghtString; i++) {
            int rndCharAt = rnd.nextInt(chars.length());
            char rndChar = chars.charAt(rndCharAt);
            sb.append(rndChar);
        }
        return sb.toString();

    }
    public static String getRandomText(int tamText){
        String text;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < tamText; i++){
            text = getRandomString(getRandomNumber(10));
            sb.append(text + " ");
        }
        return sb.toString();
    }
    public static char getRandomAlphabetChar(){
        Random r = new Random();
        char c = (char)(r.nextInt(26) + 'a');
        return c;
    }
    public static String getDay() {
        df = new SimpleDateFormat(typeOfFormat);
        return df.format(Calendar.getInstance().getTime()).split(" ")[0].split("/")[0];
    }
    public static String getMonth() {
        df = new SimpleDateFormat(typeOfFormat);
        return df.format(Calendar.getInstance().getTime()).split(" ")[0].split("/")[1];
    }
    public static String getYear() {
        df = new SimpleDateFormat(typeOfFormat);
        return df.format(Calendar.getInstance().getTime()).split(" ")[0].split("/")[2];
    }
    public static String getHour(){
        int hour = getRandomNumber(23);
        if (hour < 3){
            hour = 23;
            return String.valueOf(hour);
        } else {
            return String.valueOf(hour);
        }
    }
    public static String getMinute(){
        int minuteRandom = getRandomNumber(59);
        if (minuteRandom < 7){
            minuteRandom = 10;
            return String.valueOf(minuteRandom);
        } else {
            return String.valueOf(minuteRandom);
        }
    }
    public static String getCurrentDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dataAtual = new Date();
        String dataAtualFormatada = sdf.format(dataAtual);
        return  dataAtualFormatada;
    }

    //**** file methods ****
    public void uploadFile(WebElement element, String fileName) {
        highlightElement(element);
        //element.sendKeys(pathToUpload + "example001.pdf");
        //element.sendKeys(uploadPath + "example001.pdf");
        element.sendKeys(uploadPath + fileName + ".zip");
    }
    public String getNameFile(String fileName){
        String pathFile = uploadPath + fileName;
        File path = new File(pathFile);
        return path.getName();
    }
    public void writeFile(String fileName){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathToDownload + "travelFileName.txt"))) {
            bw.write(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //**** Experimental ****
    public void getAllCookies(){
        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println(cookies);
    }

}