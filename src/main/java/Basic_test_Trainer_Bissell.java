import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class Basic_test_Trainer_Bissell{

    private static boolean faszaklikk(WebDriver webDriver, Logger logger, String webElement, WebDriverWait wait) throws InterruptedException, TimeoutException {
        boolean bul = true;
        int counter = 0;

        while ((bul) && (counter < 5)) {
            try {
                wait.until(elementToBeClickable(By.xpath(String.valueOf(webElement)))).click();
                bul = false;
            } catch (Exception f) {
                try {
                    wait.until(elementToBeClickable(By.id(String.valueOf(webElement)))).click();
                    bul = false;
                } catch (Exception e) {
                    logger.info("Faszaklikk exception NOT OK");
                    Thread.sleep(1000);
                    counter++;
                }
            }
        }
        if (!bul) {
            logger.info(webElement + "faszaklikkelt lett");
            return true;
        } else {
            logger.info(webElement + "NOT OK");
            return false;
        }
    }

    private static String parseDate(LocalDateTime localDate) throws ParseException
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MM_dd__HH_mm_ss");
        return localDate.format(formatter);
    }

    private static String create_comm(WebDriver webDriver, Logger logger, WebDriverWait wait, String string) throws ParseException, InterruptedException {
        faszaklikk(webDriver, logger, Object_repo_Bissell.selector_trainer_communication, wait);
        faszaklikk(webDriver, logger, Object_repo_Bissell.selector_trainer_create_communication_button, wait);
        String sendkey_communicationname = ("Communication autotest " +parseDate(LocalDateTime.now()));
        if (faszaklikk(webDriver, logger, Object_repo_Bissell.selector_trainer_comm_add_title, wait))
            webDriver.findElement(By.xpath(Object_repo_Bissell.selector_trainer_comm_add_title)).sendKeys(sendkey_communicationname);
        if (faszaklikk(webDriver, logger, Object_repo_Bissell.selector_trainer_comm_add_description, wait))
            webDriver.findElement(By.xpath(Object_repo_Bissell.selector_trainer_comm_add_description)).sendKeys(sendkey_communicationname);
        faszaklikk(webDriver, logger, Object_repo_Bissell.selector_trainer_comm_check_news, wait);
        if (faszaklikk(webDriver, logger, Object_repo_Bissell.selector_trainer_comm_search_group, wait))
            webDriver.findElement(By.xpath(Object_repo_Bissell.selector_trainer_comm_search_group)).sendKeys(string);
        faszaklikk(webDriver, logger, Object_repo_Bissell.selector_trainer_comm_select_first_group, wait);
        faszaklikk(webDriver, logger, Object_repo_Bissell.selector_trainer_comm_add_group_btn, wait);
        faszaklikk(webDriver, logger, Object_repo_Bissell.selector_trainer_comm_check_now, wait);
        ((JavascriptExecutor) webDriver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        faszaklikk(webDriver, logger, Object_repo_Bissell.selector_trainer_comm_save, wait);
        return sendkey_communicationname;
    }
    private static void openclose_comm(WebDriver webDriver, Logger logger, WebDriverWait wait) throws InterruptedException {
        faszaklikk(webDriver, logger, Object_repo_Bissell.selector_trainer_dashboard, wait);
        faszaklikk(webDriver, logger, Object_repo_Bissell.selector_trainer_dashboard_tracking_tab, wait);
        faszaklikk(webDriver, logger, Object_repo_Bissell.Selector_trainer_dashboard_opencomm_modal, wait);
        faszaklikk(webDriver, logger, Object_repo_Bissell.Selector_trainer_dashboard_closecomm_modal, wait);
    }

    private static void deletecomm(WebDriver webDriver, Logger logger, WebDriverWait wait, String sendkey_communicationname) throws InterruptedException {
        Thread.sleep(200);
        faszaklikk(webDriver, logger, Object_repo_Bissell.selector_trainer_communication, wait);
        if (faszaklikk(webDriver, logger, Object_repo_Bissell.selector_trainer_comm_search_input, wait))
            webDriver.findElement(By.xpath(Object_repo_Bissell.selector_trainer_comm_search_input)).sendKeys(sendkey_communicationname);
        faszaklikk(webDriver, logger, Object_repo_Bissell.selector_trainer_comm_search_input_searchbtn, wait);
        Thread.sleep(200);
        faszaklikk(webDriver, logger, Object_repo_Bissell.selector_trainer_comm_found_list_first_action_dropdown, wait);
        Thread.sleep(200);
        faszaklikk(webDriver, logger, Object_repo_Bissell.selector_trainer_comm_found_list_first_action_deletebtn, wait);
        faszaklikk(webDriver, logger, Object_repo_Bissell.selector_trainer_comm_action_delete_confirm, wait);
    }

    public static void main(String[] argv) throws Exception
    {
        FileHandler fh;

        // This block configure the logger with handler and formatter

        //logfile name contains actual date and time of run
        String filename = "Mylogfile" + parseDate(LocalDateTime.now()) + ".log";
        String pathname = "c://temp//";
        String abspath = pathname + filename;

        //Creating actual file
        File file = new File(pathname, filename);
        file.createNewFile();

        //Setting up logger, handler etc
        fh = new FileHandler(abspath);
        Logger logger = Logger.getLogger(abspath);
        logger.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);
        WebDriver webDriver = new ChromeDriver();
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(webDriver, 5).ignoring(StaleElementReferenceException.class);

        String UserJsonPath = "c:\\Users\\randr\\IdeaProjects\\platformtest\\src\\main\\java\\user.json";
        Object obj = new JSONParser().parse(new FileReader(UserJsonPath));
        JSONObject jo = (JSONObject) obj;

        webDriver.manage().window().maximize();
        //Open page
        Basic_test_Admin_Bissell.gotourl(logger,webDriver,wait,"https://test.bissellexpert.com/login");
        Thread.sleep(1000);
        //Login
        Basic_test_Admin_Bissell.login(logger, webDriver, wait, "bisselltrainer", "bisselltrainerpassword");
        Thread.sleep(1000);
        //openclose_comm(webDriver, logger, wait);
        //webDriver.navigate().refresh();
        //deletecomm(webDriver,  logger, wait, tempString);
        //todo create trainer group for quince trainer for comm
        //faszaklikk(webDriver, logger, Object_repo_Bissell.selector_trainer_users, wait);
        Basic_test_Admin_Bissell.navigatetousergroups(logger, webDriver, wait);
        String userGroupName1 = Basic_test_Admin_Bissell.createstudentusergroup(logger, webDriver, wait, "Quince Trainer");
        //todo create trainer group for quince trainer for comm

        //todo create student group for quince student for training
        Basic_test_Admin_Bissell.navigatetousergroups(logger, webDriver, wait);
        String userGroupName2 = Basic_test_Admin_Bissell.createstudentusergroup(logger, webDriver, wait, "Quince Student");
        //todo create student group for quince student for training

        //todo creating comm for trainer group. userGroupName1 will be the name of the comm for trainer group
        Basic_test_Admin_Bissell.navigatetocommunication(logger, webDriver, wait);
        Basic_test_Admin_Bissell.createcommunication(logger, webDriver, wait, userGroupName1);
        //todo creating comm for trainer group. userGroupName1 will be the name of the comm for trainer group


        //todo create test training for pohc student group

        faszaklikk(webDriver, logger, Object_repo_Bissell.selector_trainer_training_lib_trainer, wait);
        webDriver.navigate().refresh();
        Thread.sleep(100);
        faszaklikk(webDriver, logger, Object_repo_Bissell.selector_trainer_create_training_btn, wait);
        if (faszaklikk(webDriver, logger, Object_repo_Bissell.selector_trainer_training_add_name, wait))
            webDriver.findElement(By.xpath(Object_repo_Bissell.selector_trainer_training_add_name)).sendKeys(userGroupName2);

        if (faszaklikk(webDriver, logger, Object_repo_Bissell.selector_trainer_training_add_description, wait))
            webDriver.findElement(By.xpath(Object_repo_Bissell.selector_trainer_training_add_description)).sendKeys(userGroupName2);

        faszaklikk(webDriver, logger, Object_repo_Bissell.selector_trainer_create_training_modules_tab, wait);
        faszaklikk(webDriver, logger, Object_repo_Bissell.selector_trainer_create_training_add_module_btn, wait);
        faszaklikk(webDriver, logger, Object_repo_Bissell.selector_trainer_create_tr_add_mod_checkbox, wait);
        faszaklikk(webDriver, logger, Object_repo_Bissell.selector_trainer_create_tr_add_selected_module_btn, wait);
        faszaklikk(webDriver, logger, Object_repo_Bissell.selector_trainer_create_tr_exam_tab, wait);
        faszaklikk(webDriver, logger, Object_repo_Bissell.selector_trainer_save_training_btn, wait);
        webDriver.navigate().refresh();
        Thread.sleep(100);
        //todo create test training for pohc student group

        //todo create Learning path for student group
        faszaklikk(webDriver, logger, Object_repo_Bissell.selector_trainer_learning_path, wait);
        faszaklikk(webDriver, logger, Object_repo_Bissell.selector_trainer_create_learning_path_button, wait);
        webDriver.navigate().refresh();
        Thread.sleep(100);
        if (faszaklikk(webDriver, logger, Object_repo_Bissell.selector_trainer_add_LP_name, wait))
            webDriver.findElement(By.xpath(Object_repo_Bissell.selector_trainer_add_LP_name)).sendKeys(userGroupName2);

        if (faszaklikk(webDriver, logger, Object_repo_Bissell.selector_trainer_add_LP_description, wait))
            webDriver.findElement(By.xpath(Object_repo_Bissell.selector_trainer_add_LP_description)).sendKeys(userGroupName2);

        faszaklikk(webDriver, logger, Object_repo_Bissell.selector_trainer_cr_LP_participants_tab, wait);

        if (faszaklikk(webDriver, logger, Object_repo_Bissell.selector_trainer_LP_search_group, wait))
            webDriver.findElement(By.xpath(Object_repo_Bissell.selector_trainer_LP_search_group)).sendKeys(userGroupName2);
        faszaklikk(webDriver, logger, Object_repo_Bissell.selector_trainer_LP_select_group, wait);
        faszaklikk(webDriver, logger, Object_repo_Bissell.selector_trainer_LP_add_first_group, wait);
        faszaklikk(webDriver, logger, Object_repo_Bissell.selector_trainer_LP_path_tab, wait);
        faszaklikk(webDriver, logger, Object_repo_Bissell.selector_trainer_LP_open_path_selector, wait);

        if (faszaklikk(webDriver, logger, Object_repo_Bissell.selector_trainer_LP_search_for_path, wait))
            webDriver.findElement(By.xpath(Object_repo_Bissell.selector_trainer_LP_search_for_path)).sendKeys(userGroupName2);
        faszaklikk(webDriver, logger, Object_repo_Bissell.selector_trainer_LP_select_path_checkbox, wait);
        faszaklikk(webDriver, logger, Object_repo_Bissell.selector_trainer_LP_add_selected_path, wait);
        faszaklikk(webDriver, logger, Object_repo_Bissell.selector_trainer_LP_save_LP_button, wait);
        //todo create Learning path for student group



        //todo Check deletion // admin always sees deleted stuff, maybe it should be checked by trainer
        //todo create aut student group
        //todo create aut training
        //todo create aut LP, milestone, overview exam, final exam for aut student group
        //todo create aut goal for trainer about this aut LP (with manager)
        //todo login aut student
        //todo start aut student LP
        //todo check how to switch to player tab in chrom with selenium to be able to do trainings, milestone, oveerview exam, final exam and then back to dashboard
        //todo Checks for student: dashboard card, training library tabs
        //todo check goal? Check student point?
        //todo check that somehow run tests from different files, but in the same browser.
        //todo check how to use test runners, pipeline config, using git to commit testcode
        webDriver.quit();
    }
}