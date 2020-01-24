import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class Basic_test_Admin_Philips {

    private static String parseDate(LocalDateTime localDate) throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MM_dd__HH_mm_ss");
        return localDate.format(formatter);
    }

    private static boolean faszaklikk(WebDriver webDriver, Logger logger, String webElement, WebDriverWait wait) throws InterruptedException, TimeoutException {
        boolean bul = true;
        int counter = 0;

        while ((bul) && (counter < 2)) {
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
            webDriver.quit();
            return false;
        }
    }

    public static void login(Logger logger, WebDriver webDriver, WebDriverWait wait, String user, String userpasswd) throws IOException, org.json.simple.parser.ParseException, InterruptedException {
        //String UserJsonPath = "c:\\Users\\Rendszergazda\\IdeaProjects\\platformtest\\src\\main\\java\\user.json";
        String UserJsonPath = "c:\\Users\\randr\\IdeaProjects\\platformtest\\src\\main\\java\\user.json";
        Object obj = new JSONParser().parse(new FileReader(UserJsonPath));
        JSONObject jo = (JSONObject) obj;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Object_repo_Philips.selector_user_email))).sendKeys((String) jo.get(user));
        Thread.sleep(100);
        webDriver.findElement(By.xpath(Object_repo_Philips.selector_user_password)).sendKeys((String) jo.get(userpasswd));
        Thread.sleep(100);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_login_button, wait);
        Thread.sleep(100);
        logger.info("Logged in to test.Philips website OK");
    }

    static void gotourl(Logger logger, WebDriver webDriver, String url) throws MalformedURLException, InterruptedException {
        webDriver.manage().window().maximize();
        webDriver.navigate().to(new URL(url));
        Thread.sleep(100);
        logger.info("Opened test.Philips website OK");
    }

    private static void navigatetoprofile(Logger logger, WebDriver webDriver, WebDriverWait wait) throws InterruptedException {
        Thread.sleep(100);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_admin_profile_Philips, wait);
        Thread.sleep(100);
        logger.info("Navigated to user profile page OK");
    }

    static void navigatetousergroups(Logger logger, WebDriver webDriver, WebDriverWait wait, String user) throws InterruptedException {
        Thread.sleep(100);
        switch (user) {
            case "admin": faszaklikk(webDriver, logger, Object_repo_Philips.selector_admin_users_Philips, wait);
                break;
            case "trainer": faszaklikk(webDriver, logger, Object_repo_Philips.selector_trainer_users_Philips, wait);
                break;
        }
        Thread.sleep(100);
        webDriver.navigate().refresh();
        Thread.sleep(100);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_admin_user_groups, wait);
        Thread.sleep(100);
        logger.info("Navigated to user groups page OK");
    }

    static String createstudentusergroup(Logger logger, WebDriver webDriver, WebDriverWait wait, String user) throws InterruptedException, ParseException {
        Thread.sleep(100);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_create_user_group_btn, wait);
        Thread.sleep(100);
        String sendkey_testgroup = ("Aut QS test group " + parseDate(LocalDateTime.now()));
        wait.until(elementToBeClickable(By.xpath(Object_repo_Philips.selector_usergroup_add_name))).sendKeys(sendkey_testgroup);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Philips.selector_usergroup_add_description))).sendKeys(sendkey_testgroup);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Philips.selector_usergroup_add_user_search))).sendKeys(user);
        Thread.sleep(100);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_usergroup_add_user_select_first, wait);
        Thread.sleep(100);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_usergroup_add_user, wait);
        Thread.sleep(100);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_usergroup_save, wait);
        Thread.sleep(100);
        webDriver.navigate().refresh();
        Thread.sleep(100);
        logger.info("Created" + user + " user group page OK");
        return sendkey_testgroup;

    }

    private static void editprofile(Logger logger, WebDriver webDriver, WebDriverWait wait) throws InterruptedException {
        Thread.sleep(100);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_profile_edit_button, wait);
        Thread.sleep(100);
        logger.info("Opened user profile page for editing OK");
    }

    private static void changepreferreddevicetotablet(Logger logger, WebDriver webDriver, WebDriverWait wait) throws InterruptedException {
        Thread.sleep(100);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_preferred_device_dropdown, wait);
        Thread.sleep(100);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_preferred_device_totablet, wait);
        Thread.sleep(100);
        logger.info("Changed user's preferred device to tablet OK");
    }

    private static void changepreferreddevicetosmartphone(Logger logger, WebDriver webDriver, WebDriverWait wait) throws InterruptedException {
        Thread.sleep(100);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_preferred_device_dropdown, wait);
        Thread.sleep(100);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_preferred_device_tosmatphone, wait);
        Thread.sleep(100);
        logger.info("Changed user's preferred device to smartphone OK");
    }

    private static void saveprofile(Logger logger, WebDriver webDriver, WebDriverWait wait) throws InterruptedException {
        Thread.sleep(100);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_profile_edit_Save, wait);
        Thread.sleep(100);
        logger.info("Saved user profile OK");
    }

    static void navigatetocommunication(Logger logger, WebDriver webDriver, WebDriverWait wait, String user) throws InterruptedException {
        Thread.sleep(100);
        switch (user) {
            case "admin": faszaklikk(webDriver, logger, Object_repo_Philips.selector_communication, wait);
                break;
            case "trainer": faszaklikk(webDriver, logger, Object_repo_Philips.selector_communication, wait);
                break;
        }
        Thread.sleep(100);
        logger.info("Navigated to communication page OK");
    }

    private static void deletecommunication(Logger logger, WebDriver webDriver, WebDriverWait wait) throws InterruptedException {
        navigatetocommunication(logger, webDriver, wait, "admin");
        Thread.sleep(100);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Philips.selector_comm_search_input))).sendKeys("Aut QS test group");
        Thread.sleep(100);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_comm_search_input_searchbtn, wait);
        Thread.sleep(200);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_comm_search_result_sort_dropdown, wait);
        Thread.sleep(100);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_comm_result_list_sort_descending_date, wait);
        Thread.sleep(200);
        for (int j=1; j<6; j++){
            String tempxpath = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[4]/div[2]/div[" + j + "]/div/div[2]/div/div/button";
            try {
                WebElement tempelement = webDriver.findElement(By.xpath(tempxpath));
                if (tempelement.isDisplayed()) {
                    tempelement.click();
                    Thread.sleep(200);
                    faszaklikk(webDriver, logger, "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[4]/div[2]/div[" + j + "]/div/div[2]/div/div/div/button", wait);
                    Thread.sleep(200);
                    faszaklikk(webDriver, logger, "/html/body/div[2]/div/div/div/div[2]/div[2]/button[1]", wait);
                    Thread.sleep(3000);
                }
            }
            catch (NoSuchElementException E){}

        }
        logger.info("Deleted communication OK");
    }

    static void createcommunication(Logger logger, WebDriver webDriver, WebDriverWait wait, String groupname) throws InterruptedException {
        Thread.sleep(100);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_create_communication_button, wait);
        Thread.sleep(100);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Philips.selector_comm_add_title))).sendKeys(groupname);
        Thread.sleep(100);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Philips.selector_comm_add_description))).sendKeys(groupname);
        Thread.sleep(100);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_comm_check_news, wait);
        Thread.sleep(100);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Philips.selector_comm_search_group))).sendKeys(groupname);
        Thread.sleep(100);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_comm_select_first_group, wait);
        Thread.sleep(100);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_comm_add_group_btn, wait);
        Thread.sleep(100);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_comm_check_now, wait);
        Thread.sleep(100);
        ((JavascriptExecutor) webDriver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_communication_save, wait);
        //click comm on dashboard
        webDriver.navigate().refresh();
        Thread.sleep(100);
        logger.info("Created communication OK");
    }

    private static boolean checkcommunicationispublished(Logger logger, WebDriver webDriver, WebDriverWait wait, String communicationname) throws InterruptedException {
        faszaklikk(webDriver, logger, Object_repo_Philips.Selector_admin_dashboard_comm_list_first_item, wait);
        Thread.sleep(1000);
        if (webDriver.findElement((By.xpath(Object_repo_Philips.Selector_admin_dashboard_comm_list_first_item_title))).getText().contains(communicationname)) {
            faszaklikk(webDriver, logger, Object_repo_Philips.Selector_admin_dashboard_closecomm_modal, wait);
            logger.info("Communication was published OK");
            return true;
        }
        else{
            faszaklikk(webDriver, logger, Object_repo_Philips.Selector_admin_dashboard_closecomm_modal, wait);
            logger.info("Communication was not published NOT OK");
            return false;
        }
    }

    private static void navigatetomodules(Logger logger, WebDriver webDriver, WebDriverWait wait, String user) throws InterruptedException {
        switch (user) {
            case "admin": faszaklikk(webDriver, logger, Object_repo_Philips.selector_modules, wait);
            case "trainer": faszaklikk(webDriver, logger, Object_repo_Philips.selector_modules, wait);
        }
        Thread.sleep(200);
        logger.info("Navigated to modules page OK");
    }

    private static void navigate_to_translate (Logger logger, WebDriver webDriver, WebDriverWait wait) throws InterruptedException {
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_admin_modules_first_action_dropdown, wait);
        Thread.sleep(200);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_admin_modules_first_dropdown_translate, wait);
        Thread.sleep(200);
        logger.info("Navigated to module translation page OK");
    }

    private static void navigatetomoduledetails (Logger logger, WebDriver webDriver, WebDriverWait wait) throws InterruptedException {
        webDriver.navigate().refresh();
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_admin_module_translate_module_details, wait);
        Thread.sleep(200);
        logger.info("In module translation page, navigated to module details tab OK");
    }

    private static void change_first_translation_and_save (Logger logger, WebDriver webDriver, WebDriverWait wait) throws InterruptedException {
        wait.until(elementToBeClickable(By.xpath(Object_repo_Philips.selector_admin_translate_moduledetails_first_input ))).sendKeys("Auto_translate_test");
        Thread.sleep(200);
        ((JavascriptExecutor) webDriver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(100);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_admin_translate_changed_save, wait);
        Thread.sleep(200);
        logger.info("Changed first item translation OK");
    }

    private static void deletecreatedcommunication(Logger logger, WebDriver webDriver, WebDriverWait wait, String communicationname, String user) throws  InterruptedException {
        navigatetocommunication(logger, webDriver, wait, user);
        Thread.sleep(100);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Philips.selector_comm_search_input))).sendKeys(communicationname);
        Thread.sleep(100);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_comm_search_input_searchbtn, wait);
        Thread.sleep(200);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_trainer_comm_found_list_first_action_dropdown, wait);
        Thread.sleep(100);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_comm_found_list_first_action_deletebtn, wait);
        Thread.sleep(100);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_comm_action_delete_confirm, wait);
        logger.info("Deleted created communication OK");
    }

    private static void navigatetocontacts(Logger logger, WebDriver webDriver, WebDriverWait wait, String user) throws InterruptedException {
        Thread.sleep(100);
        switch (user) {
            case "admin": faszaklikk(webDriver, logger, Object_repo_Philips.selector_contact, wait);
            case "trainer": faszaklikk(webDriver, logger, Object_repo_Philips.selector_contact, wait);
        }
        Thread.sleep(100);
        logger.info("Navigated to contacts OK");
    }

    private static void navigatetodashboard(Logger logger, WebDriver webDriver, WebDriverWait wait) throws InterruptedException {
        Thread.sleep(100);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_dashboard, wait);
        Thread.sleep(100);
        logger.info("Navigated to dashboard OK");
    }

    public static void main(String[] argv) throws Exception {
        FileHandler fh;
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

        //Init webdriver
        WebDriver webDriver = new ChromeDriver();
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(webDriver, 10).ignoring(StaleElementReferenceException.class);

        FirefoxDriver ffDriver = new FirefoxDriver();
        WebDriverWait wait_ff = (WebDriverWait) new WebDriverWait(ffDriver, 5).ignoring(StaleElementReferenceException.class);

        gotourl(logger, webDriver, "https://test.philipsohcacademy.com/login");
        gotourl(logger, ffDriver, "https://test.philipsohcacademy.com/login");

        login(logger, webDriver, wait, "philipsadmin", "philipsadminpassword");
        login(logger, ffDriver, wait_ff, "philipsadmin", "philipsadminpassword");

        navigatetoprofile(logger, webDriver, wait);
        navigatetoprofile(logger, ffDriver, wait_ff);

        //todo create trainer group for quince trainer for comm
        //faszaklikk(webDriver, logger, Object_repo_Bissell.selector_trainer_users, wait);
        navigatetousergroups(logger, webDriver, wait, "admin");
        navigatetousergroups(logger, ffDriver, wait_ff, "admin");
        String userGroupNameChrome1 = createstudentusergroup(logger, webDriver, wait, "Quince Trainer");
        String userGroupNameFF1 = createstudentusergroup(logger, ffDriver, wait_ff, "Quince Trainer");
        //todo create trainer group for quince trainer for comm

        //todo create student group for quince student for training
        navigatetousergroups(logger, webDriver, wait, "admin");
        navigatetousergroups(logger, ffDriver, wait_ff, "admin");
        String userGroupNameChrome2 = createstudentusergroup(logger, webDriver, wait, "Quince Student");
        String userGroupNameFF2 = createstudentusergroup(logger, ffDriver, wait_ff, "Quince Student");
        //todo create student group for quince student for training

        //todo creating comm for trainer group. userGroupName1 will be the name of the comm for trainer group
        navigatetocommunication(logger, webDriver, wait, "admin");
        navigatetocommunication(logger, ffDriver, wait_ff, "admin");
        createcommunication(logger, webDriver, wait, userGroupNameChrome1);
        createcommunication(logger, ffDriver, wait_ff, userGroupNameFF1);
        //todo creating comm for trainer group. userGroupName1 will be the name of the comm for trainer group

        //todo create test training for pohc student group

        faszaklikk(webDriver, logger, Object_repo_Philips.selector_training_lib, wait);
        faszaklikk(ffDriver, logger, Object_repo_Philips.selector_training_lib, wait_ff);
        webDriver.navigate().refresh();
        ffDriver.navigate().refresh();
        Thread.sleep(100);

        faszaklikk(webDriver, logger, Object_repo_Philips.selector_create_training_button, wait);
        faszaklikk(ffDriver, logger, Object_repo_Philips.selector_create_training_button, wait_ff);

        if (faszaklikk(webDriver, logger, Object_repo_Philips.selector_trainer_training_add_name, wait))
            webDriver.findElement(By.xpath(Object_repo_Philips.selector_trainer_training_add_name)).sendKeys(userGroupNameChrome2);
        if (faszaklikk(ffDriver, logger, Object_repo_Philips.selector_trainer_training_add_name, wait_ff))
            ffDriver.findElement(By.xpath(Object_repo_Philips.selector_trainer_training_add_name)).sendKeys(userGroupNameFF2);

        if (faszaklikk(webDriver, logger, Object_repo_Philips.selector_trainer_training_add_description, wait))
            webDriver.findElement(By.xpath(Object_repo_Philips.selector_trainer_training_add_description)).sendKeys(userGroupNameChrome2);
        if (faszaklikk(ffDriver, logger, Object_repo_Philips.selector_trainer_training_add_description, wait_ff))
            ffDriver.findElement(By.xpath(Object_repo_Philips.selector_trainer_training_add_description)).sendKeys(userGroupNameFF2);

        faszaklikk(webDriver, logger, Object_repo_Philips.selector_create_training_modules_tab, wait);
        faszaklikk(ffDriver, logger, Object_repo_Philips.selector_create_training_modules_tab, wait_ff);

        faszaklikk(webDriver, logger, Object_repo_Philips.selector_trainer_create_training_add_module_btn, wait);
        faszaklikk(ffDriver, logger, Object_repo_Philips.selector_trainer_create_training_add_module_btn, wait_ff);

        faszaklikk(webDriver, logger, Object_repo_Philips.selector_trainer_create_tr_add_mod_checkbox, wait);
        faszaklikk(ffDriver, logger, Object_repo_Philips.selector_trainer_create_tr_add_mod_checkbox, wait_ff);

        faszaklikk(webDriver, logger, Object_repo_Philips.selector_trainer_create_tr_add_selected_module_btn, wait);
        faszaklikk(ffDriver, logger, Object_repo_Philips.selector_trainer_create_tr_add_selected_module_btn, wait_ff);

        faszaklikk(webDriver, logger, Object_repo_Philips.selector_trainer_create_tr_exam_tab, wait);
        faszaklikk(ffDriver, logger, Object_repo_Philips.selector_trainer_create_tr_exam_tab, wait_ff);

        faszaklikk(webDriver, logger, Object_repo_Philips.selector_save_training_button, wait);
        faszaklikk(ffDriver, logger, Object_repo_Philips.selector_save_training_button, wait_ff);

        webDriver.navigate().refresh();
        ffDriver.navigate().refresh();
        Thread.sleep(100);

        logger.info("Trainer Test finished OK");
        webDriver.quit();
        ffDriver.quit();
        //todo create test training for pohc student group
    }
}