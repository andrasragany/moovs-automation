import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.LocalDateTime;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Basic_test_Trainer_Bissell{
    
    public static void main(String[] argv) throws Exception {
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

        FirefoxDriver ffDriver = new FirefoxDriver();
        WebDriverWait wait_ff = (WebDriverWait) new WebDriverWait(ffDriver, 5).ignoring(StaleElementReferenceException.class);

        OperaOptions options = new OperaOptions();
        options.setBinary(new File("c:\\Users\\randr\\AppData\\Local\\Programs\\Opera\\66.0.3515.44\\opera.exe"));
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        OperaDriver opDriver = new OperaDriver(options);
        WebDriverWait wait_op = (WebDriverWait) new WebDriverWait(opDriver, 10).ignoring(StaleElementReferenceException.class);

        webDriver.manage().window().maximize();
        ffDriver.manage().window().maximize();
        opDriver.manage().window().maximize();

        //Open page
        _fc.gotourl(logger,webDriver,"https://test.bissellexpert.com/login");
        _fc.gotourl(logger,ffDriver,"https://test.bissellexpert.com/login");
        _fc.gotourl(logger, opDriver, "https://test.bissellexpert.com/login");
        Thread.sleep(1000);

        //Login
        _fc.login(logger, webDriver, wait, "bisselltrainer", "bisselltrainerpassword");
        _fc.login(logger, ffDriver, wait_ff, "bisselltrainer", "bisselltrainerpassword");
        _fc.login(logger, opDriver, wait_op, "bisselltrainer", "bisselltrainerpassword");

        Thread.sleep(2000);

        //create trainer group for quince trainer for comm
        _fc.navigatetousergroups(logger, webDriver, wait, "trainer");
        _fc.navigatetousergroups(logger, ffDriver, wait_ff, "trainer");
        _fc.navigatetousergroups(logger, opDriver, wait_op, "trainer");

        String userGroupNameChrome1 = _fc.create_usergroup(logger, webDriver, wait, "Quince Trainer");
        String userGroupNameChrome_2 = _fc.create_usergroup(logger, webDriver, wait, "Quince Student");

        String userGroupNameFF1 = _fc.create_usergroup(logger, ffDriver, wait_ff, "Trainer");
        String userGroupNameFF_2 = _fc.create_usergroup(logger, ffDriver, wait_ff, "Student");

        String userGroupNameOP1 = _fc.create_usergroup(logger, opDriver, wait_op, "Trainer");
        String userGroupNameOP_2 = _fc.create_usergroup(logger, opDriver, wait_op, "Student");

        _fc.navigatetocommunication(logger, webDriver, wait, "trainer");
        _fc.navigatetocommunication(logger, ffDriver, wait_ff, "trainer");
        _fc.navigatetocommunication(logger, opDriver, wait_op, "trainer");

        _fc.createcommunication(logger, webDriver, wait, userGroupNameChrome1);
        _fc.createcommunication(logger, ffDriver, wait_ff, userGroupNameFF1);
        _fc.createcommunication(logger, opDriver, wait_op, userGroupNameOP1);

        _fc.create_training(webDriver, wait, logger, userGroupNameChrome_2);
        _fc.create_training(ffDriver, wait_ff, logger, userGroupNameFF_2);
        _fc.create_training(opDriver, wait_op, logger, userGroupNameOP_2);

        _fc.create_LP(webDriver, wait, logger,userGroupNameChrome_2);
        _fc.create_LP(ffDriver, wait_ff, logger,userGroupNameFF_2);
        _fc.create_LP(opDriver, wait_op, logger,userGroupNameOP_2);

        logger.info("Trainer Test finished OK");
        webDriver.quit();
        ffDriver.quit();
        opDriver.quit();
    }
}