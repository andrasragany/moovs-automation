import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.LocalDateTime;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Basic_test_Student_Bissell{

    public static void main(String[] argv) throws Exception {
        String filename = "Mylogfile" + _fc.parseDate(LocalDateTime.now()) + ".log";
        String pathname = "c:\\temp\\";
        String abspath = pathname + filename;
        File file = new File(pathname, filename);
        file. createNewFile();
        FileHandler fh = new FileHandler(abspath);
        Logger logger = Logger.getLogger(abspath);
        logger.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);

        WebDriver webDriver = new ChromeDriver();
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(webDriver, 5).ignoring(StaleElementReferenceException.class);

        FirefoxDriver ffDriver = new FirefoxDriver();
        WebDriverWait wait_ff = (WebDriverWait) new WebDriverWait(ffDriver, 5).ignoring(StaleElementReferenceException.class);

        webDriver.manage().window().maximize();
        ffDriver.manage().window().maximize();
        //Open page
        _fc.gotourl(logger,webDriver,"https://test.bissellexpert.com/login");
        _fc.gotourl(logger,ffDriver,"https://test.bissellexpert.com/login");
        //Login
        _fc.login(logger, webDriver, wait, "bissellstudent", "bissellstudentpassword");
        _fc.login(logger, ffDriver, wait_ff, "bissellstudent", "bissellstudentpassword");

        Thread.sleep(1100);

        _fc.navigatetoprofile(logger, webDriver, "https://test.bissellexpert.com/profile");
        _fc.navigatetoprofile(logger, ffDriver, "https://test.bissellexpert.com/profile");

        _fc.editprofile(logger, webDriver, wait);
        _fc.editprofile(logger, ffDriver, wait_ff);

        _fc.changepreferreddevicetotablet(logger, webDriver, wait);
        _fc.changepreferreddevicetotablet(logger, ffDriver, wait_ff);

        _fc.saveprofile(logger, webDriver, wait);
        _fc.saveprofile(logger, ffDriver, wait_ff);

        //go to dashboard
        _fc.navigatetodashboard(logger, webDriver, wait);
        _fc.navigatetodashboard(logger, ffDriver, wait_ff);
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