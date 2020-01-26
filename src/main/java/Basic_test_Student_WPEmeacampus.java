import org.openqa.selenium.JavascriptExecutor;
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

public class Basic_test_Student_WPEmeacampus {
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
        _fc.gotourl(logger,webDriver,"https://test.emeacampus-whirlpoolcorp.com/login");
        _fc.gotourl(logger,ffDriver,"https://test.emeacampus-whirlpoolcorp.com/login");
        _fc.gotourl(logger, opDriver, "https://test.emeacampus-whirlpoolcorp.com/login");
        //Login
        _fc.login(logger, webDriver, wait, "wpwmwastudent", "wpemeastudentpassword");
        _fc.login(logger, ffDriver, wait_ff, "wpwmwastudent", "wpemeastudentpassword");
        _fc.login(logger, opDriver, wait_op, "wpwmwastudent", "wpemeastudentpassword");

        Thread.sleep(1100);

        _fc.navigatetoprofile(logger, webDriver, "https://test.emeacampus-whirlpoolcorp.com/profile");
        _fc.navigatetoprofile(logger, ffDriver, "https://test.emeacampus-whirlpoolcorp.com/profile");
        _fc.navigatetoprofile(logger, opDriver, "https://test.emeacampus-whirlpoolcorp.com/profile");

        ((JavascriptExecutor) webDriver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        ((JavascriptExecutor) ffDriver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        ((JavascriptExecutor) opDriver).executeScript("window.scrollTo(0, document.body.scrollHeight)");

        _fc.editprofile(logger, webDriver, wait);
        _fc.editprofile(logger, ffDriver, wait_ff);
        _fc.editprofile(logger, opDriver, wait_op);

        _fc.changepreferreddevicetotablet_EMEA(logger, webDriver, wait);
        _fc.changepreferreddevicetotablet_EMEA(logger, ffDriver, wait_ff);
        _fc.changepreferreddevicetotablet_EMEA(logger, opDriver, wait_op);

        _fc.saveprofile(logger, webDriver, wait);
        _fc.saveprofile(logger, ffDriver, wait_ff);
        _fc.saveprofile(logger, opDriver, wait_op);

        //go to dashboard
        _fc.navigatetodashboard(logger, webDriver, wait);
        _fc.navigatetodashboard(logger, ffDriver, wait_ff);
        _fc.navigatetodashboard(logger, opDriver, wait_op);
        Thread.sleep(1100);

        _fc.opentraining_EMEA(webDriver, logger, wait);
        _fc.opentraining_EMEA(ffDriver, logger, wait_ff);
        _fc.opentraining_EMEA(opDriver, logger, wait_op);

        _fc.player(webDriver, logger, wait);
        _fc.player(ffDriver, logger, wait_ff);
        _fc.player(opDriver, logger, wait_op);

        _fc.exam(webDriver, logger, wait);
        _fc.exam(ffDriver, logger, wait_ff);
        _fc.exam(opDriver, logger, wait_op);

        Thread.sleep(2000);
        logger.info("Test finished OK");
        webDriver.quit();
        ffDriver.quit();
        opDriver.quit();
    }
}
