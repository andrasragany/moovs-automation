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

public class Basic_test_Trainer_WLearn extends Thread{
    private WebDriver driver;
    private WebDriverWait waiter;
    private String browsertype;

    public Basic_test_Trainer_WLearn(String name, String browsertype) {
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
            options.setBinary(new File("c:\\Users\\randr\\AppData\\Local\\Programs\\Opera\\66.0.3515.44\\opera.exe"));
            //options.setBinary(new File("c:\\Users\\Rendszergazda\\AppData\\Local\\Programs\\Opera\\66.0.3515.44\\opera.exe"));
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            driver = new OperaDriver(options);
            waiter = new WebDriverWait(driver, 5);
        } else if (browsertype.contains("Edge")) {
            System.setProperty("webdriver.edge.driver", "c:\\chromedriver\\msedgedriver.exe");
            //System.setProperty("webdriver.edge.driver", "c:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2019.2.3\\bin\\msedgedriver.exe");
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

        _fc.gotourl(logger,driver,"http://ec2-3-125-142-193.eu-central-1.compute.amazonaws.com:90/");
        _fc.login_WL(logger, driver, waiter, "wlearntrainer", "wlearntrainerpassword");
        //_fc.create_course_WL(driver, waiter, logger, "trainer");
        //_fc.navigatetomodules_and_switchto_listview_WL(logger, driver, waiter);
        //_fc.create_Program_WL(driver, waiter, logger, "trainer");
        _fc.navigatetousers_WL(logger, driver, waiter);
        _fc.navigatetousergroups_WL(logger, driver, waiter);
        _fc.Create_Usergroup_WL(logger, driver, waiter, "Trainer");



    }

    public static void main(String[] argv) throws Exception {
        Thread ChromeThread = new Basic_test_Trainer_WLearn("Thread Chrome", "Chrome");
        Thread FireFoxThread = new Basic_test_Trainer_WLearn("Thread FireFox", "Firefox");
        Thread OperaThread = new Basic_test_Trainer_WLearn("Thread Opera", "Opera");
        Thread EdgeThread = new Basic_test_Trainer_WLearn("Thread Opera", "Edge");

        System.out.println("Starting MyThreads");
        ChromeThread.start();
        //ChromeThread.sleep(1000);
        FireFoxThread.start();
        //FireFoxThread.sleep(1000);
        OperaThread.start();
        //OperaThread.sleep(1000);
        EdgeThread.start();
        //EdgeThread.sleep(1000);
    }
}