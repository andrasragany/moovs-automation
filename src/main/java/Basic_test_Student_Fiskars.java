import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Basic_test_Student_Fiskars{

    public static void main(String[] argv) throws Exception {
        String filename = "Mylogfile" + _fc.parseDate(LocalDateTime.now()) + ".log";
        String pathname = "c:\\temp\\";
        String abspath = pathname + filename;

        //Creating actual file
        File file = new File(pathname, filename);
        file. createNewFile();

        //Setting up logger, handler etc
        FileHandler fh = new FileHandler(abspath);
        Logger logger = Logger.getLogger(abspath);
        logger.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);
        //System.setProperty("webdriver.chrome.driver","c:\\chromedriver\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(webDriver, 5).ignoring(StaleElementReferenceException.class);

        FirefoxDriver ffDriver = new FirefoxDriver();
        WebDriverWait wait_ff = (WebDriverWait) new WebDriverWait(ffDriver, 5).ignoring(StaleElementReferenceException.class);

        //String UserJsonPath = "c:\\Users\\Rendszergazda\\IdeaProjects\\platformtest\\src\\main\\java\\user.json";
        String UserJsonPath = "c:\\Users\\randr\\IdeaProjects\\platformtest\\src\\main\\java\\user.json";
        Object obj = new JSONParser().parse(new FileReader(UserJsonPath));
        JSONObject jo = (JSONObject) obj;

        webDriver.manage().window().maximize();
        ffDriver.manage().window().maximize();
        //Open page
        _fc.gotourl(logger,webDriver,"https://test.fiskarsacademy.com/login");
        _fc.gotourl(logger,ffDriver,"https://test.fiskarsacademy.com/login");
        //Login
        _fc.login(logger, webDriver, wait, "fiskarsstudent", "fiskarsstudentpassword");
        _fc.login(logger, ffDriver, wait_ff, "fiskarsstudent", "fiskarsstudentpassword");

        Thread.sleep(1100);

        //String mainWindow = webDriver.getWindowHandle();

        _fc.editprofile(logger, webDriver, wait);
        _fc.editprofile(logger, ffDriver, wait_ff);

        //go to dashboard
        _fc.faszaklikk(webDriver, logger, Object_repo_Philips.selector_dashboard, wait, "selector_student_dashboard");
        _fc.faszaklikk(ffDriver, logger, Object_repo_Philips.selector_dashboard, wait_ff, "selector_student_dashboard");
        Thread.sleep(1100);

        _fc.opentraining(webDriver, logger, wait);
        _fc.opentraining(ffDriver, logger, wait_ff);

        _fc.player(webDriver, logger, wait);
        _fc.player(ffDriver, logger, wait_ff);

        _fc.exam(webDriver, logger, wait);
        _fc.exam(ffDriver, logger, wait_ff);

        Thread.sleep(2000);
        logger.info("Test finished OK");
        webDriver.quit();
        ffDriver.quit();
    }
}