import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
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

public class Basic_test_Student_Fiskars{

    private static String parseDate(LocalDateTime localDate) throws ParseException
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MM_dd__HH_mm_ss");
        return localDate.format(formatter);
    }

    private static boolean faszaklikk(WebDriver webDriver, Logger logger, String webElement, WebDriverWait wait) throws InterruptedException, TimeoutException {
        boolean bul = true;
        int  counter = 0;

        while ((bul) && (counter < 5)) {
            try {
                wait.until(elementToBeClickable(By.xpath(String.valueOf(webElement)))).click();
                bul = false;
                counter++;
            } catch (Exception e) {
                logger.info(e.toString());
                Thread.sleep(1000);
                counter++;
                return false;
            }
        }
        logger.info("faszaklikk faszán fasza");
        return true;
    }

    public static void main(String[] argv) throws Exception
    {

        // This block configure the logger with handler and formatter

        //logfile name contains actual date and time of run
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
        System.setProperty("webdriver.chrome.driver","c:\\chromedriver\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(webDriver, 5).ignoring(StaleElementReferenceException.class);

        String UserJsonPath = "c:\\Users\\randr\\IdeaProjects\\platformtest\\src\\main\\java\\user.json";
        Object obj = new JSONParser().parse(new FileReader(UserJsonPath));
        JSONObject jo = (JSONObject) obj;

        webDriver.manage().window().maximize();
        //Open page
        Basic_test_Admin_Fiskars.gotourl(logger,webDriver,wait,"https://test.fiskarsacademy.com/login");
        //Login
        Basic_test_Admin_Fiskars.login(logger, webDriver, wait, "student", "studentpassword");

        Thread.sleep(1100);

        //String mainWindow = webDriver.getWindowHandle();
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_student_user_dropdown))).click();
        //Thread.sleep(300);
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_student_user_profile))).click();

        //Edit profile, change preferred device to tablet, Save, Check
        //((JavascriptExecutor) webDriver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_student_edit_profile_btn))).click();
        //Thread.sleep(250);
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_student_profile_preferred_device_dropdown))).click();
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_student_pref_dev_smarttotablet))).click();
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_student_edit_profile_save_btn))).click();
        //Change tablet to smartphone
        //((JavascriptExecutor) webDriver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_student_edit_profile_btn))).click();
        //Thread.sleep(250);
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_student_profile_preferred_device_dropdown))).click();
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_student_pref_dev_tablettosmart))).click();
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_trainer_profile_edit_Save))).click();
        //Thread.sleep(250);

        //go to dashboard
        //wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_student_dashboard))).click();
        Thread.sleep(1100);
        //start training from dashboard, if not, start training from training library

        faszaklikk(webDriver, logger,Object_repo_Fiskars.selector_student_training_lib_, wait);
        logger.info("Opened student training lib OK");
        Thread.sleep(1100);
        webDriver.navigate().refresh();
        Thread.sleep(1100);
        faszaklikk(webDriver, logger,Object_repo_Fiskars.selector_student_traininglib_completed, wait);
        logger.info("Opened student completed trainings tab OK");
        Thread.sleep(1100);
        faszaklikk(webDriver, logger,Object_repo_Fiskars.selector_student_traininglib_completed_retryexam, wait);
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
        //If retry exam was clicked, open player contents
        Thread.sleep(2000);
        //WebElement mapObject = webDriver.findElement(By.xpath(Object_repo_Fiskars.selector_player_open_contents));
        //((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", mapObject);

        faszaklikk(webDriver, logger,Object_repo_Fiskars.selector_player_open_contents, wait);
        logger.info("Opened Player window contents tab OK");
        //select first training from contents
        faszaklikk(webDriver, logger,Object_repo_Fiskars.selector_player_contents_first_item, wait);
        //wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_player_contents_first_item))).click();
        logger.info("Clicked first training from contents OK");
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_Player_select_true))).click();
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_Player_next_question))).click();
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_Player_rewatch_training_button))).click();
        Thread.sleep(1100);
        Boolean temp = true;
        int count = 0;
        while (temp) {
            try {
                //First training
                Thread.sleep(2000);
                //faszaklikk(webDriver, logger, Object_repo_Fiskars.selector_Player_training_explore_button, wait);
                if (faszaklikk(webDriver, logger, Object_repo_Fiskars.selector_Player_training_explore_button, wait)) temp = true;
                    else temp = false;
                logger.info("Clicked training's Explore button in Player OK");
                Thread.sleep(2000);
                //((JavascriptExecutor) webDriver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
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
                faszaklikk(webDriver, logger, Object_repo_Fiskars.selector_player_next_training_button, wait);
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
        faszaklikk(webDriver, logger, Object_repo_Fiskars.selector_player_exam_true, wait);
        logger.info("True in exam pressed!");




        //WebElement mapObject2 = webDriver.findElement(By.xpath(Object_repo_Fiskars.selector_Player_training_next1_button));
        //((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", mapObject2);
        //Thread.sleep(500);
        //Second training
        //WebElement mapObject3 = webDriver.findElement(By.xpath(Object_repo_Fiskars.selector_Player_training_next2_button));
        //((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", mapObject3);
        //Thread.sleep(500);
        //Third training
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_Player_training_explore_button))).click();
        //Thread.sleep(500);
        //((JavascriptExecutor) webDriver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        //Thread.sleep(500);
        //WebElement mapObject4 = webDriver.findElement(By.xpath(Object_repo_Fiskars.Selector_Player_training_next3_button));
        //((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", mapObject4);
        //Thread.sleep(500);
        //Exam 1 true
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_Player_select_true))).click();
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_Player_next_question))).click();

        Thread.sleep(5000);
        logger.info("Test finished OK");
        webDriver.quit();

    }
}