import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.FileReader;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class Basic_test_Student_Philips{
    private static void startFfBrowser() {
        System.setProperty("webdriver.gecko.driver","c:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2019.2.3\\bin\\geckodriver.exe");
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("http://www.tutorialspoint.com");
    }

    private static String parseDate(LocalDateTime localDate) throws ParseException
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MM_dd__HH_mm_ss");
        return localDate.format(formatter);
    }

    private static boolean faszaklikk(WebDriver webDriver, Logger logger, String webElement, WebDriverWait wait) throws InterruptedException, TimeoutException {
        boolean bul = true;
        int counter = 0;

        while ((bul) && (counter < 1)) {
            try {
                wait.until(elementToBeClickable(By.xpath(String.valueOf(webElement)))).click();
                bul = false;
            } catch (Exception f) {
                try {
                    wait.until(elementToBeClickable(By.id(String.valueOf(webElement)))).click();
                    bul = false;
                } catch (Exception e) {
                    logger.info(webElement + "NOT OK");
                    Thread.sleep(1000);
                    counter++;
                }
            }
        }
        if (!bul) {
            logger.info("faszaklikkelt lett");
            return true;
        } else {
            logger.info(webElement + "NOT OK");
            webDriver.quit();
            return false;
        }
    }


    private static void editprofile (WebDriver webDriver, Logger logger, WebDriverWait wait) throws InterruptedException {
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_student_user_profile, wait);
        Actions actions = new Actions(webDriver);
        actions.sendKeys(Keys.END).perform();

        //Edit profile, change preferred device to tablet, Save, Check
        faszaklikk(webDriver,logger, Object_repo_Philips.selector_student_edit_profile_btn, wait);
        Thread.sleep(250);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_student_profile_preferred_device_dropdown, wait);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_student_pref_dev_smarttotablet, wait);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_student_edit_profile_save_btn, wait);
        actions.sendKeys(Keys.END).perform();
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_student_edit_profile_btn, wait);
        //Change tablet to smartphone
        Thread.sleep(250);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_student_profile_preferred_device_dropdown, wait);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_student_pref_dev_tablettosmart, wait);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_trainer_profile_edit_Save, wait);
        Thread.sleep(250);
    }

    private static void opentraining (WebDriver webDriver,Logger logger, WebDriverWait wait) throws InterruptedException {
        //Boolean iscardpresent = false;
        Thread.sleep(1000);
        if (faszaklikk(webDriver, logger, Object_repo_Philips.selector_student_dashboard_training_card_start, wait)) {
            logger.info("Opened training card from dashboard OK");
            Thread.sleep(1100);
            //switch selenium handle to player tab
            Set<String> handles = webDriver.getWindowHandles();
            String currentWindowHandle = webDriver.getWindowHandle();
            for (String handle : handles) {
                if (!currentWindowHandle.equals(handle)) {
                    webDriver.switchTo().window(handle);
                }
            }
            String playerWindow = webDriver.getWindowHandle();

            logger.info("Opened and switched to Player window OK");
            Thread.sleep(2000);
        } else {
            faszaklikk(webDriver, logger, Object_repo_Philips.selector_student_training_lib_, wait);
            logger.info("Opened student training lib OK");
            Thread.sleep(1100);
            webDriver.navigate().refresh();
            Thread.sleep(1100);
            faszaklikk(webDriver, logger, Object_repo_Philips.selector_student_traininglib_completed, wait);
            logger.info("Opened student completed trainings tab OK");
            Thread.sleep(1100);
            faszaklikk(webDriver, logger, Object_repo_Philips.selector_student_traininglib_completed_retryexam, wait);
            logger.info("Student opened a finished training in player via retry exam button OK");
            Thread.sleep(1100);
            //switch selenium handle to player tab
            Set<String> handles = webDriver.getWindowHandles();
            String currentWindowHandle = webDriver.getWindowHandle();
            for (String handle : handles) {
                if (!currentWindowHandle.equals(handle)) {
                    webDriver.switchTo().window(handle);
                }
            }
            //save player tab handle for later use
            String playerWindow = webDriver.getWindowHandle();
            logger.info("Opened and switched to Player window OK");
            Thread.sleep(2000);
        }
    }

    private static boolean exam(WebDriver webDriver,Logger logger, WebDriverWait wait) throws InterruptedException, TimeoutException {
        try {
            while ((webDriver.findElement(By.xpath(Object_repo_Philips.selector_player_exam_counter))).isDisplayed()) {
                logger.info((webDriver.findElement(By.xpath(Object_repo_Philips.selector_player_exam_type))).getText());
                switch (webDriver.findElement(By.xpath(Object_repo_Philips.selector_player_exam_type)).getText()) {
                    case "Match":

                    case "Select":

                    case "Fill":
                        faszaklikk(webDriver, logger, Object_repo_Philips.selector_player_exam_check_answer_button, wait);
                        faszaklikk(webDriver, logger, Object_repo_Philips.selector_player_exam_next_question, wait);
                        break;
                    case "Is it true":
                        faszaklikk(webDriver, logger, Object_repo_Philips.selector_player_exam_false, wait);
                        logger.info("True in exam pressed!");
                        Thread.sleep(500);
                        faszaklikk(webDriver, logger, Object_repo_Philips.selector_player_exam_next_question, wait);
                        break;
                    default:
                }
            }
        }
        catch(org.openqa.selenium.NoSuchElementException E) {
            logger.info("Test finished OK");
            webDriver.quit();
        }
        logger.info("exam fuggveny lefutott");
        return true;
    }

    public static boolean player (WebDriver webDriver,Logger logger, WebDriverWait wait) throws InterruptedException {
        faszaklikk(webDriver, logger,Object_repo_Philips.selector_player_open_contents, wait);
        logger.info("Opened Player window contents tab OK");
        //select first training from contents
        faszaklikk(webDriver, logger,Object_repo_Philips.selector_player_contents_first_item, wait);
        logger.info("Clicked first training from contents OK");
        Thread.sleep(1100);
        Boolean temp = true;
        while (temp) {
            try {
                //First training
                Thread.sleep(2000);
                if (faszaklikk(webDriver, logger, Object_repo_Philips.selector_Player_training_explore_button, wait)) {
                    temp = true;
                    logger.info("Clicked training's Explore button in Player OK");
                }
                else temp = false;
                Thread.sleep(2000);
                Actions actions = new Actions(webDriver);
                actions.sendKeys(Keys.END).perform();
                logger.info("Scrolled down to the bottom of training in Player window OK");
                Thread.sleep(2000);
                //((JavascriptExecutor) webDriver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
                //List<WebElement> buttons = webDriver.findElements(By.tagName("button"));
                //WebElement lastElement = buttons.get(buttons.size() - 1);
                //Thread.sleep(2000);
                //Actions actions = new Actions(webDriver);
                //actions.moveToElement(lastElement);
                //Thread.sleep(2000);
                //((JavascriptExecutor) webDriver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
                faszaklikk(webDriver, logger, Object_repo_Philips.selector_player_next_training_button, wait);
                logger.info("Clicked on Next training in PLayer window");
                Thread.sleep(1100);
            } catch (org.openqa.selenium.TimeoutException e) {
                temp = false;
                logger.info("Test gone through modules, reached exam.");
            }
            catch (org.openqa.selenium.NoSuchElementException e) {
                temp = false;
                logger.info("Test gone through modules, reached exam.");
            }
            catch (org.openqa.selenium.ElementNotInteractableException e) {
                temp = false;
                logger.info("Test gone through modules, reached exam.");
            }
        }
        return true;
    }

    public static void main(String[] argv) throws Exception {
        String filename = "Mylogfile" + parseDate(LocalDateTime.now()) + ".log";
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

        String UserJsonPath = "c:\\Users\\randr\\IdeaProjects\\platformtest\\src\\main\\java\\user.json";
        //String UserJsonPath = "c:\\Users\\Rendszergazda\\IdeaProjects\\platformtest\\src\\main\\java\\user.json";
        Object obj = new JSONParser().parse(new FileReader(UserJsonPath));
        JSONObject jo = (JSONObject) obj;

        webDriver.manage().window().maximize();
        ffDriver.manage().window().maximize();
        //Open page
        Basic_test_Admin_Philips.gotourl(logger,webDriver,"https://test.philipsohcacademy.com/login");
        Basic_test_Admin_Philips.gotourl(logger,ffDriver,"https://test.philipsohcacademy.com/login");
        //Login
        Basic_test_Admin_Philips.login(logger, webDriver, wait, "philipsstudent", "philipsstudentpassword");
        Basic_test_Admin_Philips.login(logger, ffDriver, wait_ff, "philipsstudent", "philipsstudentpassword");

        Thread.sleep(1100);

        //String mainWindow = webDriver.getWindowHandle();

        editprofile(webDriver, logger, wait);
        editprofile(ffDriver, logger, wait_ff);


        //go to dashboard
        faszaklikk(webDriver, logger, Object_repo_Fiskars.selector_student_dashboard, wait);
        faszaklikk(ffDriver, logger, Object_repo_Fiskars.selector_student_dashboard, wait_ff);
        Thread.sleep(1100);

        opentraining(webDriver, logger, wait);
        opentraining(ffDriver, logger, wait_ff);

        player(webDriver, logger, wait);
        player(ffDriver, logger, wait_ff);

        exam(webDriver, logger, wait);
        exam(ffDriver, logger, wait_ff);

        Thread.sleep(2000);
        logger.info("Test finished OK");
        webDriver.quit();
        ffDriver.quit();
    }
}