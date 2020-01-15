
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class proba {
    WebDriver webDriver = new ChromeDriver();
    WebDriverWait wait = (WebDriverWait) new WebDriverWait(webDriver, 10).ignoring(StaleElementReferenceException.class);
    FirefoxDriver webDriver2 = new FirefoxDriver();

    private String parseDate(LocalDateTime localDate) throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd--HH:mm:ss");
        return localDate.format(formatter);
    }

    private void login1(String user, String userpasswd ) throws IOException, org.json.simple.parser.ParseException {

        String UserJsonPath = "c:\\Users\\Rendszergazda\\IdeaProjects\\untitled\\src\\main\\java\\com\\firstfewlines\\user.json";
        Object obj = new JSONParser().parse(new FileReader(UserJsonPath));
        JSONObject jo = (JSONObject) obj;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_user_email))).sendKeys((String) jo.get(user));
        webDriver.findElement(By.xpath(Object_repo_Fiskars.selector_user_password)).sendKeys((String) jo.get(userpasswd));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_login_button))).click();
    }
    private void gotourl1(String url) throws MalformedURLException {
        webDriver.manage().window().maximize();
        webDriver.navigate().to(new URL("https://test.fiskarsacademy.com/login"));
    }

    private void startFfBrowser () {
        System.setProperty("webdriver.gecko.driver","c:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2019.2.3\\bin\\geckodriver.exe");
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("http://www.tutorialspoint.com");
    }

    public void main(String[] argv) throws Exception {
        WebDriver webDriver = new ChromeDriver();
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(webDriver, 10).ignoring(StaleElementReferenceException.class);

        gotourl1("https://test.fiskarsacademy.com/login");
        login1("student", "studentpassword");

        //Profil page
        Thread.sleep(2000);
        startFfBrowser();





    }

}
