
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
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

public class Basic_test_Trainer_Fiskars{

    private static String parseDate(LocalDateTime localDate) throws ParseException
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MM_dd__HH_mm_ss");
        return localDate.format(formatter);
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
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(webDriver, 10).ignoring(StaleElementReferenceException.class);

        String UserJsonPath = "C:\\Users\\Rendszergazda\\IdeaProjects\\platformtest\\src\\main\\java\\user.json";
        Object obj = new JSONParser().parse(new FileReader(UserJsonPath));
        JSONObject jo = (JSONObject) obj;

        webDriver.manage().window().maximize();
        //Open page
        Basic_test_Admin_Fiskars.gotourl(logger,webDriver,wait,"https://test.fiskarsacademy.com/login");
        //Login
        Basic_test_Admin_Fiskars.login(logger, webDriver, wait, "fiskarstrainer", "fiskarstrainerpassword");

        //Create user group for communication
        webDriver.navigate().refresh();
        Thread.sleep(100);

        String userGroupName = Basic_test_Admin_Fiskars.createstudentusergroup(logger, webDriver, wait, "Quince Trainer");
        Thread.sleep(100);

        //Create communication, check dashboard, delete this communication, check dashboard again
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_trainer_communication))).click();
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_trainer_create_communication_button))).click();
        String sendkey_communication = ("Communication autotest " +parseDate(LocalDateTime.now()));
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_trainer_comm_add_title))).sendKeys(sendkey_communication);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_trainer_comm_add_description))).sendKeys(sendkey_communication);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_trainer_comm_check_news))).click();
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_trainer_comm_search_group))).sendKeys(userGroupName);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_trainer_comm_select_first_group))).click();
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_trainer_comm_add_group_btn))).click();
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_trainer_comm_check_now))).click();
        ((JavascriptExecutor) webDriver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_trainer_comm_save))).click();
        //click comm on dashboard
        webDriver.navigate().refresh();
        Thread.sleep(100);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_trainer_dashboard))).click();
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_trainer_dashboard_tracking_tab))).click();
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.Selector_trainer_dashboard_opencomm_modal))).click();
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.Selector_trainer_dashboard_closecomm_modal))).click();
        //Delete previously created communication
        webDriver.navigate().refresh();
        Thread.sleep(200);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_trainer_communication))).click();
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_trainer_comm_search_input))).sendKeys(sendkey_communication);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_trainer_comm_search_input_searchbtn))).click();
        Thread.sleep(200);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_trainer_comm_found_list_first_action_dropdown))).click();
        Thread.sleep(200);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_trainer_comm_found_list_first_action_deletebtn))).click();
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_trainer_comm_action_delete_confirm))).click();

        //todo create student group for pohc student
        Thread.sleep(100);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_trainer_users))).click();
        webDriver.navigate().refresh();
        Thread.sleep(100);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_trainer_user_groups))).click();
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_trainer_user_create_usergroup_btn))).click();
        String sendkey_testgroup2 = ("Aut test group for student " + parseDate(LocalDateTime.now()));
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_trainer_usergroup_add_name))).sendKeys(sendkey_testgroup2);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_trainer_usergroup_add_description))).sendKeys(userGroupName);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_trainer_usergroup_add_user_search))).sendKeys("Quince Student");
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_trainer_usergroup_add_user_select_first))).click();
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_trainer_usergroup_add_user))).click();
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_trainer_usergroup_save))).click();
        webDriver.navigate().refresh();
        Thread.sleep(100);

        //todo create test training for pohc student group
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_trainer_training_lib_trainer))).click();
        webDriver.navigate().refresh();
        Thread.sleep(100);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_trainer_create_training_btn))).click();
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_trainer_training_add_name))).sendKeys(sendkey_testgroup2);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_trainer_training_add_description))).sendKeys(sendkey_testgroup2);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_trainer_create_training_modules_tab))).click();
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_trainer_create_training_add_module_btn))).click();
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_trainer_create_tr_add_mod_checkbox))).click();
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_trainer_create_tr_add_selected_module_btn))).click();
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_trainer_create_tr_exam_tab))).click();
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_trainer_save_training_btn))).click();
        webDriver.navigate().refresh();
        Thread.sleep(100);

        //todo create Learning path for student group
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_trainer_learning_path))).click();
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_trainer_create_learning_path_button))).click();
        webDriver.navigate().refresh();
        Thread.sleep(100);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_trainer_add_LP_name))).sendKeys(sendkey_testgroup2);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_trainer_add_LP_description))).sendKeys(sendkey_testgroup2);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_trainer_cr_LP_participants_tab))).click();
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_trainer_LP_search_group))).sendKeys(sendkey_testgroup2);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_trainer_LP_select_group))).click();
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_trainer_LP_add_first_group))).click();
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_trainer_LP_path_tab))).click();
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_trainer_LP_open_path_selector))).click();
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_trainer_LP_search_for_path))).sendKeys(sendkey_testgroup2);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_trainer_LP_select_path_checkbox))).click();
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_trainer_LP_add_selected_path))).click();
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_trainer_LP_save_LP_button))).click();



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