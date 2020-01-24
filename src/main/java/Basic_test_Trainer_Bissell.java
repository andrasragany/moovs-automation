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

public class Basic_test_Trainer_Bissell{
    
    public static void main(String[] argv) throws Exception
    {
        String filename = "Mylogfile" + _fc.parseDate(LocalDateTime.now()) + ".log";
        String pathname = "c://temp//";
        String abspath = pathname + filename;

        //Creating actual file
        File file = new File(pathname, filename);
        file.createNewFile();

        //Setting up logger, handler etc
        FileHandler fh = new FileHandler(abspath);
        Logger logger = Logger.getLogger(abspath);
        logger.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);

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
        _fc.gotourl(logger,webDriver,"https://test.bissellexpert.com/login");
        _fc.gotourl(logger,ffDriver,"https://test.bissellexpert.com/login");
        Thread.sleep(1000);
        //Login
        _fc.login(logger, webDriver, wait, "bisselltrainer", "bisselltrainerpassword");
        _fc.login(logger, ffDriver, wait_ff, "bisselltrainer", "bisselltrainerpassword");

        Thread.sleep(1100);

        //openclose_comm(webDriver, logger, wait);
        //webDriver.navigate().refresh();
        //deletecomm(webDriver,  logger, wait, tempString);

        //todo create trainer group for quince trainer for comm
        //_fc.._fc.faszaklikk(webDriver, logger, Object_repo_Philips.selector_trainer_users, wait);
        webDriver.navigate().refresh();
        _fc.navigatetousergroups(logger, webDriver, wait, "trainer");
        ffDriver.navigate().refresh();
        _fc.navigatetousergroups(logger, ffDriver, wait_ff, "trainer");
        String userGroupNameChrome1 = _fc.create_usergroup(logger, webDriver, wait, "Quince Trainer");
        String userGroupNameFF1 = _fc.create_usergroup(logger, webDriver, wait_ff, "Quince Trainer");
        //todo create trainer group for quince trainer for comm

        //todo create student group for quince student for training
        webDriver.navigate().refresh();
        _fc.navigatetousergroups(logger, webDriver, wait, "trainer");
        ffDriver.navigate().refresh();
        _fc.navigatetousergroups(logger, ffDriver, wait, "trainer");
        String userGroupNameChrome_2 = _fc.create_usergroup(logger, webDriver, wait, "Quince Student");
        String userGroupNameFF_2 = _fc.create_usergroup(logger, ffDriver, wait_ff, "Quince Student");
        //todo create communication
        _fc.navigatetocommunication(logger, webDriver, wait, "trainer");
        _fc.navigatetocommunication(logger, ffDriver, wait_ff, "trainer");

        _fc.createcommunication(logger, webDriver, wait, userGroupNameChrome1);
        _fc.createcommunication(logger, ffDriver, wait_ff, userGroupNameFF1);

        _fc.create_training(webDriver, wait, logger, userGroupNameChrome_2);
        _fc.create_training(ffDriver, wait_ff, logger, userGroupNameFF_2);



        logger.info("Trainer Test finished OK");
        webDriver.quit();
        ffDriver.quit();
    }
}