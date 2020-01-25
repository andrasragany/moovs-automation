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

public class Basic_test_Admin_Philips {

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
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(webDriver, 10).ignoring(StaleElementReferenceException.class);

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

        _fc.gotourl(logger, webDriver, "https://test.philipsohcacademy.com/login");
        _fc.gotourl(logger, ffDriver, "https://test.philipsohcacademy.com/login");
        _fc.gotourl(logger, opDriver, "https://test.philipsohcacademy.com/login");

        _fc.login(logger, webDriver, wait, "philipsadmin", "philipsadminpassword");
        _fc.login(logger, ffDriver, wait_ff, "philipsadmin", "philipsadminpassword");
        _fc.login(logger, opDriver, wait_op, "philipsadmin", "philipsadminpassword");

        _fc.navigatetoprofile(logger, webDriver, "https://test.philipsohcacademy.com/profile");
        _fc.navigatetoprofile(logger, ffDriver, "https://test.philipsohcacademy.com/profile");
        _fc.navigatetoprofile(logger, opDriver, "https://test.philipsohcacademy.com/profile");

        ((JavascriptExecutor) webDriver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        ((JavascriptExecutor) ffDriver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        ((JavascriptExecutor) opDriver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(100);


        _fc.editprofile(logger, webDriver, wait);
        _fc.editprofile(logger, ffDriver, wait_ff);
        _fc.editprofile(logger, opDriver, wait_op);
        Thread.sleep(200);

        _fc.changepreferreddevicetotablet(logger, webDriver, wait);
        _fc.changepreferreddevicetotablet(logger, ffDriver, wait_ff);
        _fc.changepreferreddevicetotablet(logger, opDriver, wait_op);
        Thread.sleep(200);

        _fc.saveprofile(logger, webDriver, wait);
        _fc.saveprofile(logger, ffDriver, wait_ff);
        _fc.saveprofile(logger, opDriver, wait_op);
        Thread.sleep(200);

        ((JavascriptExecutor) webDriver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        ((JavascriptExecutor) ffDriver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        ((JavascriptExecutor) opDriver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(100);

        _fc.editprofile(logger, webDriver, wait);
        _fc.editprofile(logger, ffDriver, wait_ff);
        _fc.editprofile(logger, opDriver, wait_op);
        Thread.sleep(200);


        _fc.changepreferreddevicetosmartphone(logger, webDriver, wait);
        _fc.changepreferreddevicetosmartphone(logger, ffDriver, wait_ff);
        _fc.changepreferreddevicetosmartphone(logger, opDriver, wait_op);
        Thread.sleep(200);

        _fc.saveprofile(logger, webDriver, wait);
        _fc.saveprofile(logger, ffDriver, wait_ff);
        _fc.saveprofile(logger, opDriver, wait_op);
        Thread.sleep(200);

        _fc.navigatetousergroups(logger, webDriver, wait, "admin");
        _fc.navigatetousergroups(logger, ffDriver, wait_ff, "admin");
        _fc.navigatetousergroups(logger, opDriver, wait_op, "admin");
        Thread.sleep(200);

        String userGroupNameChrome1 = _fc.create_usergroup(logger, webDriver, wait, "Quince Student");
        String userGroupNameFF1 = _fc.create_usergroup(logger, ffDriver, wait_ff, "Quince Student");
        String userGroupNameOP1 = _fc.create_usergroup(logger, opDriver, wait_op, "Quince Student");

        _fc.navigatetousergroups(logger, webDriver, wait, "admin");
        _fc.navigatetousergroups(logger, ffDriver, wait_ff, "admin");
        _fc.navigatetousergroups(logger, opDriver, wait_op, "admin");
        String userGroupNameChrome2 = _fc.create_usergroup(logger, webDriver, wait, "Quince Student");
        String userGroupNameFF2 = _fc.create_usergroup(logger, ffDriver, wait_ff, "Quince Student");
        String userGroupNameOP2 = _fc.create_usergroup(logger, opDriver, wait_op, "Quince Student");

        _fc.navigatetocommunication(logger, webDriver, wait, "admin");
        _fc.navigatetocommunication(logger, ffDriver, wait_ff, "admin");
        _fc.navigatetocommunication(logger, opDriver, wait_op, "admin");
        _fc.createcommunication(logger, webDriver, wait, userGroupNameChrome1);
        _fc.createcommunication(logger, ffDriver, wait_ff, userGroupNameFF1);
        _fc.createcommunication(logger, opDriver, wait_op, userGroupNameOP1);

        _fc.navigatetodashboard(logger, webDriver, wait);
        _fc.navigatetodashboard(logger, ffDriver, wait_ff);
        _fc.navigatetodashboard(logger, opDriver, wait_op);
        Thread.sleep(200);

        _fc.checkcommunicationispublished(logger, webDriver, wait, userGroupNameChrome1);
        _fc.checkcommunicationispublished(logger, ffDriver, wait_ff, userGroupNameFF1);
        _fc.checkcommunicationispublished(logger, opDriver, wait_op, userGroupNameOP1);
        Thread.sleep(200);

        //deletecommunication(logger, webDriver, wait);
        _fc.deletecreatedcommunication(logger, webDriver,wait, userGroupNameChrome1, "admin");
        _fc.deletecreatedcommunication(logger, ffDriver, wait_ff, userGroupNameFF1, "admin");
        _fc.deletecreatedcommunication(logger, opDriver, wait_op, userGroupNameOP1, "admin");
        Thread.sleep(200);

        _fc.navigatetomodules(logger, webDriver, wait, "admin");
        _fc.navigatetomodules(logger, ffDriver, wait_ff, "admin");
        _fc.navigatetomodules(logger, opDriver, wait_op, "admin");

        _fc.navigate_to_translate(logger, webDriver, wait);
        _fc.navigate_to_translate(logger, ffDriver, wait_ff);
        _fc.navigate_to_translate(logger, opDriver, wait_op);

        //_fc.navigatetomoduledetails(logger, webDriver, wait);
        //_fc.navigatetomoduledetails(logger, ffDriver, wait_ff);

        //_fc.change_first_translation_and_save(logger, webDriver, wait);
        //_fc.change_first_translation_and_save(logger, ffDriver, wait_ff);

        _fc.navigatetocontacts(logger, webDriver, wait);
        _fc.navigatetocontacts(logger, ffDriver, wait_ff);
        _fc.navigatetocontacts(logger, opDriver, wait_op);

        Thread.sleep(100);

        webDriver.quit();
        ffDriver.quit();
        opDriver.quit();
    }
}