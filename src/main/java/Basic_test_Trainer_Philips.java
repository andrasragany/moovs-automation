import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.LocalDateTime;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Basic_test_Trainer_Philips{

    public static void main(String[] argv) throws Exception
    {
        String filename = "Mylogfile" + _fc.parseDate(LocalDateTime.now()) + ".log";
        String pathname = "c://temp//";
        String abspath = pathname + filename;
        File file = new File(pathname, filename);
        file.createNewFile();

        FileHandler fh = new FileHandler(abspath);
        Logger logger = Logger.getLogger(abspath);
        logger.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);

        WebDriver webDriver = new ChromeDriver();
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(webDriver, 5).ignoring(StaleElementReferenceException.class);

        //FirefoxDriver ffDriver = new FirefoxDriver();
        //WebDriverWait wait_ff = (WebDriverWait) new WebDriverWait(ffDriver, 5).ignoring(StaleElementReferenceException.class);

        webDriver.manage().window().maximize();
        //ffDriver.manage().window().maximize();

        //Open page
        _fc.gotourl(logger,webDriver,"https://test.philipsohcacademy.com//login");
        //_fc.gotourl(logger,ffDriver,"https://test.philipsohcacademy.com/login");
        //Login
        _fc.login(logger, webDriver, wait, "philipstrainer", "philipstrainerpassword");
        //_fc.login(logger, ffDriver, wait_ff, "philipstrainer", "philipstrainerpassword");
        Thread.sleep(1000);

        //create trainer group for quince trainer for comm
        _fc.navigatetousergroups(logger, webDriver, wait, "trainer");
        //_fc.navigatetousergroups(logger, ffDriver, wait_ff, "trainer");
        String userGroupNameChrome1 = _fc.create_usergroup(logger, webDriver, wait, "Trainer");
        String userGroupNameChrome_2 = _fc.create_usergroup(logger, webDriver, wait, "Student");
        //String userGroupNameFF1 = _fc.create_usergroup(logger, ffDriver, wait_ff, "Trainer");
        //String userGroupNameFF_2 = _fc.create_usergroup(logger, ffDriver, wait_ff, "Student");

        //create communication
        _fc.navigatetocommunication(logger, webDriver, wait, "trainer");
        //_fc.navigatetocommunication(logger, ffDriver, wait_ff, "trainer");

        _fc.createcommunication(logger, webDriver, wait, userGroupNameChrome1);
        //_fc.createcommunication(logger, ffDriver, wait_ff, userGroupNameFF1);

        _fc.create_training(webDriver, wait, logger, userGroupNameChrome_2);
        //_fc.create_training(ffDriver, wait_ff, logger, userGroupNameFF_2);

        _fc.create_LP(webDriver, wait, logger,userGroupNameChrome_2);
        //_fc.create_LP(ffDriver, wait_ff, logger,userGroupNameFF_2);

        logger.info("Trainer Test finished OK");
        webDriver.quit();
        //ffDriver.quit();
    }
}