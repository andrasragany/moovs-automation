import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.LocalDateTime;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Basic_test_Trainer_Fiskars extends Thread{
    private WebDriver driver;
    private WebDriverWait waiter;
    private String browsertype;

    public Basic_test_Trainer_Fiskars(String name, String browsertype) {
        super(name);
        this.browsertype = browsertype;
    }

    @Override
    public void run() {
        System.out.println("Thread- Started" + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
            setUp(this.browsertype);
            student();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            tearDown();
        }
        System.out.println("Thread- END " + Thread.currentThread().getName());
    }
    public void setUp(String browsertype) throws Exception {

        if (browsertype.contains("Chrome")) {
            driver = new ChromeDriver();
            waiter = new WebDriverWait(driver, 5);
        } else if (browsertype.contains("Firefox")) {
            driver = new FirefoxDriver();
            waiter = new WebDriverWait(driver, 5);
        } else if (browsertype.contains("Opera")) {
            OperaOptions options = new OperaOptions();
            //options.setBinary(new File("c:\\Users\\randr\\AppData\\Local\\Programs\\Opera\\66.0.3515.44\\opera.exe"));
            options.setBinary(new File("c:\\Users\\Rendszergazda\\AppData\\Local\\Programs\\Opera\\66.0.3515.44\\opera.exe"));
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            driver = new OperaDriver(options);
            waiter = new WebDriverWait(driver, 5);
        } else if (browsertype.contains("Edge")) {
            //System.setProperty("webdriver.edge.driver", "c:\\chromedriver\\msedgedriver.exe");
            System.setProperty("webdriver.edge.driver", "c:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2019.2.3\\bin\\msedgedriver.exe");
            driver = new EdgeDriver();
            waiter = new WebDriverWait(driver, 5);
        }
        driver.manage().window().maximize();
    }
    public void tearDown() {
        driver.quit();
    }

    public void student() throws Exception {
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

        _fc.gotourl(logger,driver,"https://test.fiskarsacademy.com/login");
        _fc.login(logger, driver, waiter, "fiskarstrainer", "fiskarstrainerpassword");
        _fc.navigatetoprofile(logger, driver, "https://test.fiskarsacademy.com/profile");
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        _fc.editprofile(logger, driver, waiter);
        _fc.changepreferreddevicetotablet(logger, driver, waiter);
        _fc.saveprofile(logger, driver, waiter);
        _fc.navigatetousergroups(logger, driver, waiter, "trainer");
        String userGroupName_1 = _fc.create_usergroup(logger, driver, waiter, "Trainer");
        String userGroupName_2 = _fc.create_usergroup(logger, driver, waiter, "Student");
        _fc.navigatetocommunication(logger, driver, waiter, "trainer");
        _fc.createcommunication(logger, driver, waiter, userGroupName_1);
        _fc.create_training(driver, waiter, logger, userGroupName_2);
        _fc.create_LP(driver, waiter, logger,userGroupName_2);


    }

    public static void main(String[] argv) throws Exception {
        Thread ChromeThread = new Basic_test_Trainer_Fiskars("Thread Chrome", "Chrome");
        Thread FireFoxThread = new Basic_test_Trainer_Fiskars("Thread FireFox", "Firefox");
        Thread OperaThread = new Basic_test_Trainer_Fiskars("Thread Opera", "Opera");
        Thread EdgeThread = new Basic_test_Trainer_Fiskars("Thread Opera", "Edge");

        System.out.println("Starting MyThreads");
        ChromeThread.start();
        ChromeThread.sleep(1000);
        FireFoxThread.start();
        FireFoxThread.sleep(1000);
        OperaThread.start();
        OperaThread.sleep(1000);
        EdgeThread.start();
        EdgeThread.sleep(1000);
        System.out.println("Threads has been started");


    }
}