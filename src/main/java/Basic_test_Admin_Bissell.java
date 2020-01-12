import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class Basic_test_Admin_Bissell {

    private static String parseDate(LocalDateTime localDate) throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MM_dd__HH_mm_ss");
        return localDate.format(formatter);
    }

    private static boolean faszaklikk(WebDriver webDriver, Logger logger, String webElement, WebDriverWait wait) throws InterruptedException, TimeoutException {
        boolean bul = true;
        int counter = 0;

        while ((bul) && (counter < 3)) {
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

        public static void login(Logger logger, WebDriver webDriver, WebDriverWait wait, String user, String userpasswd) throws IOException, org.json.simple.parser.ParseException, InterruptedException {
            String UserJsonPath = "c:\\Users\\randr\\IdeaProjects\\platformtest\\src\\main\\java\\user.json";
            Object obj = new JSONParser().parse(new FileReader(UserJsonPath));
            JSONObject jo = (JSONObject) obj;
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Object_repo_Bissell.selector_user_email))).sendKeys((String) jo.get(user));
            webDriver.findElement(By.xpath(Object_repo_Bissell.selector_user_password)).sendKeys((String) jo.get(userpasswd));
            Thread.sleep(1000);
            faszaklikk(webDriver, logger, Object_repo_Bissell.selector_login_button, wait);
            Thread.sleep(1000);
            logger.info("Logged in to test.bissell website OK");
        }

        static void gotourl(Logger logger, WebDriver webDriver, String url) throws MalformedURLException, InterruptedException {
            webDriver.manage().window().maximize();
            webDriver.navigate().to(new URL(url));
            Thread.sleep(100);
            logger.info("Opened test.bissell website OK");
        }

        private static void navigatetoprofile(Logger logger, WebDriver webDriver, WebDriverWait wait) throws InterruptedException {
            Thread.sleep(1000);
            faszaklikk(webDriver, logger, Object_repo_Bissell.selector_admin_user_dropdown, wait);
            Thread.sleep(1000);
            faszaklikk(webDriver, logger, Object_repo_Bissell.selector_admin_profile, wait);
            Thread.sleep(500);
            logger.info("Navigated to user profile page OK");
        }

        static void navigatetousergroups(Logger logger, WebDriver webDriver, WebDriverWait wait, String user) throws InterruptedException {
            Thread.sleep(100);
            switch (user) {
                case "admin": faszaklikk(webDriver, logger, Object_repo_Bissell.selector_admin_users, wait);
                case "trainer": faszaklikk(webDriver, logger, Object_repo_Bissell.selector_trainer_users, wait);
            }
            Thread.sleep(100);
            webDriver.navigate().refresh();
            Thread.sleep(100);
            faszaklikk(webDriver, logger, Object_repo_Bissell.selector_admin_user_groups, wait);
            Thread.sleep(100);
            logger.info("Navigated to user groups page OK");
        }

        static String createstudentusergroup(Logger logger, WebDriver webDriver, WebDriverWait wait, String user) throws InterruptedException, ParseException {
            Thread.sleep(100);
            faszaklikk(webDriver, logger, Object_repo_Bissell.selector_create_user_group_btn, wait);
            Thread.sleep(100);
            String sendkey_testgroup = ("Aut " + user+ " " + parseDate(LocalDateTime.now()));
            wait.until(elementToBeClickable(By.xpath(Object_repo_Bissell.selector_usergroup_add_name))).sendKeys(sendkey_testgroup);
            wait.until(elementToBeClickable(By.xpath(Object_repo_Bissell.selector_usergroup_add_description))).sendKeys(sendkey_testgroup);
            wait.until(elementToBeClickable(By.xpath(Object_repo_Bissell.selector_usergroup_add_user_search))).sendKeys(user);
            Thread.sleep(200);
            faszaklikk(webDriver, logger, Object_repo_Bissell.selector_usergroup_add_user_select_first, wait);
            Thread.sleep(100);
            faszaklikk(webDriver, logger, Object_repo_Bissell.selector_usergroup_add_user, wait);
            Thread.sleep(100);
            faszaklikk(webDriver, logger, Object_repo_Bissell.selector_usergroup_save, wait);
            Thread.sleep(100);
            webDriver.navigate().refresh();
            Thread.sleep(100);
            logger.info("Created student user group page OK");
            return sendkey_testgroup;

        }

        private static void editprofile(Logger logger, WebDriver webDriver, WebDriverWait wait) throws InterruptedException {
            //((JavascriptExecutor) webDriver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
            Thread.sleep(100);
            faszaklikk(webDriver, logger, Object_repo_Bissell.selector_admin_profile_edit_button, wait);
            Thread.sleep(100);
            logger.info("Opened user profile page for editing OK");
        }

        private static void changepreferreddevicetotablet(Logger logger, WebDriver webDriver, WebDriverWait wait) throws InterruptedException {
            Thread.sleep(100);
            faszaklikk(webDriver, logger, Object_repo_Bissell.selector_preferred_device_dropdown, wait);
            Thread.sleep(100);
            faszaklikk(webDriver, logger, Object_repo_Bissell.selector_preferred_device_totablet, wait);
            Thread.sleep(100);
            logger.info("Changed user's preferred device to tablet OK");
        }

        private static void changepreferreddevicetosmartphone(Logger logger, WebDriver webDriver, WebDriverWait wait) throws InterruptedException {
            Thread.sleep(100);
            faszaklikk(webDriver, logger, Object_repo_Bissell.selector_preferred_device_dropdown, wait);
            Thread.sleep(100);
            faszaklikk(webDriver, logger, Object_repo_Bissell.selector_preferred_device_tosmatphone, wait);
            Thread.sleep(100);
            logger.info("Changed user's preferred device to smartphone OK");
        }

        private static void saveprofile(Logger logger, WebDriver webDriver, WebDriverWait wait) throws InterruptedException {
            Thread.sleep(100);
            faszaklikk(webDriver, logger, Object_repo_Bissell.selector_profile_edit_Save, wait);
            Thread.sleep(100);
            logger.info("Saved user profile OK");
        }

        static void navigatetocommunication(Logger logger, WebDriver webDriver, WebDriverWait wait, String user) throws InterruptedException {
            Thread.sleep(100);
            switch (user) {
                case "admin": faszaklikk(webDriver, logger, Object_repo_Bissell.selector_admin_communication, wait);
                case "trainer": faszaklikk(webDriver, logger, Object_repo_Bissell.selector_trainer_communication, wait);
            }
            Thread.sleep(100);
            logger.info("Navigated to communication page OK");
        }

        private static void deletecommunication(Logger logger, WebDriver webDriver, WebDriverWait wait) throws InterruptedException {
            navigatetocommunication(logger, webDriver, wait, "admin");
            Thread.sleep(100);
            wait.until(elementToBeClickable(By.xpath(Object_repo_Bissell.selector_comm_search_input))).sendKeys("Aut QS test group");
            Thread.sleep(100);
            faszaklikk(webDriver, logger, Object_repo_Bissell.selector_comm_search_input_searchbtn, wait);
            Thread.sleep(200);
            faszaklikk(webDriver, logger, Object_repo_Bissell.selector_comm_search_result_sort_dropdown, wait);
            Thread.sleep(100);
            faszaklikk(webDriver, logger, Object_repo_Bissell.selector_comm_result_list_sort_descending_date, wait);
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
            faszaklikk(webDriver, logger, Object_repo_Bissell.selector_create_communication_button, wait);
            Thread.sleep(100);
            wait.until(elementToBeClickable(By.xpath(Object_repo_Bissell.selector_comm_add_title))).sendKeys(groupname);
            Thread.sleep(100);
            wait.until(elementToBeClickable(By.xpath(Object_repo_Bissell.selector_comm_add_description))).sendKeys(groupname);
            Thread.sleep(100);
            faszaklikk(webDriver, logger, Object_repo_Bissell.selector_comm_check_news, wait);
            Thread.sleep(100);
            wait.until(elementToBeClickable(By.xpath(Object_repo_Bissell.selector_comm_search_group))).sendKeys(groupname);
            Thread.sleep(100);
            faszaklikk(webDriver, logger, Object_repo_Bissell.selector_comm_select_first_group, wait);
            Thread.sleep(100);
            faszaklikk(webDriver, logger, Object_repo_Bissell.selector_comm_add_group_btn, wait);
            Thread.sleep(100);
            faszaklikk(webDriver, logger, Object_repo_Bissell.selector_comm_check_now, wait);
            Thread.sleep(100);
            ((JavascriptExecutor) webDriver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
            faszaklikk(webDriver, logger, Object_repo_Bissell.selector_comm_save, wait);
            //click comm on dashboard
            webDriver.navigate().refresh();
            Thread.sleep(100);
            logger.info("Created communication OK");
        }

        private static boolean checkcommunicationispublished(Logger logger, WebDriver webDriver, WebDriverWait wait, String communicationname) throws InterruptedException {
            faszaklikk(webDriver, logger, Object_repo_Bissell.Selector_admin_dashboard_comm_list_first_item, wait);
            Thread.sleep(1000);
            if (webDriver.findElement((By.xpath(Object_repo_Bissell.Selector_admin_dashboard_comm_list_first_item_title))).getText().contains(communicationname)) {
                faszaklikk(webDriver, logger, Object_repo_Bissell.Selector_admin_dashboard_closecomm_modal, wait);
                logger.info("Communication was published OK");
                return true;
            }
            else{
                faszaklikk(webDriver, logger, Object_repo_Bissell.Selector_admin_dashboard_closecomm_modal, wait);
                logger.info("Communication was not published NOT OK");
                return false;
            }
        }

        private static void navigatetomodules(Logger logger, WebDriver webDriver, WebDriverWait wait, String user) throws InterruptedException {
            switch (user) {
                case "admin": faszaklikk(webDriver, logger, Object_repo_Bissell.selector_admin_modules, wait);
                case "trainer": faszaklikk(webDriver, logger, Object_repo_Bissell.selector_trainer_modules, wait);
            }
            Thread.sleep(200);
            logger.info("Navigated to modules page OK");
        }

        private static void navigate_to_translate (Logger logger, WebDriver webDriver, WebDriverWait wait) throws InterruptedException {
            faszaklikk(webDriver, logger, Object_repo_Bissell.selector_admin_modules_first_action_dropdown, wait);
            Thread.sleep(200);
            faszaklikk(webDriver, logger, Object_repo_Bissell.selector_admin_modules_first_dropdown_translate, wait);
            Thread.sleep(200);
            logger.info("Navigated to module translation page OK");
        }

        private static void navigatetomoduledetails (Logger logger, WebDriver webDriver, WebDriverWait wait) throws InterruptedException {
            webDriver.navigate().refresh();
            faszaklikk(webDriver, logger, Object_repo_Bissell.selector_admin_module_translate_module_details, wait);
            Thread.sleep(200);
            logger.info("In module translation page, navigated to module details tab OK");
        }

        private static void change_first_translation_and_save (Logger logger, WebDriver webDriver, WebDriverWait wait) throws InterruptedException {
            wait.until(elementToBeClickable(By.xpath(Object_repo_Bissell.selector_admin_translate_moduledetails_first_input ))).sendKeys("Auto_translate_test");
            Thread.sleep(200);
            ((JavascriptExecutor) webDriver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
            Thread.sleep(100);
            faszaklikk(webDriver, logger, Object_repo_Bissell.selector_admin_translate_changed_save, wait);
            Thread.sleep(200);
            logger.info("Changed first item translation OK");
        }

        private static void deletecreatedcommunication(Logger logger, WebDriver webDriver, WebDriverWait wait, String communicationname, String user) throws  InterruptedException {
            navigatetocommunication(logger, webDriver, wait, user);
            Thread.sleep(100);
            wait.until(elementToBeClickable(By.xpath(Object_repo_Bissell.selector_comm_search_input))).sendKeys(communicationname);
            Thread.sleep(100);
            faszaklikk(webDriver, logger, Object_repo_Bissell.selector_comm_search_input_searchbtn, wait);
            Thread.sleep(200);
            faszaklikk(webDriver, logger, Object_repo_Bissell.selector_trainer_comm_found_list_first_action_dropdown, wait);
            Thread.sleep(100);
            faszaklikk(webDriver, logger, Object_repo_Bissell.selector_comm_found_list_first_action_deletebtn, wait);
            Thread.sleep(100);
            faszaklikk(webDriver, logger, Object_repo_Bissell.selector_comm_action_delete_confirm, wait);
            logger.info("Deleted created communication OK");
        }

        private static void navigatetocontacts(Logger logger, WebDriver webDriver, WebDriverWait wait, String user) throws InterruptedException {
            Thread.sleep(100);
            switch (user) {
                case "admin": faszaklikk(webDriver, logger, Object_repo_Bissell.selector_admin_contact, wait);
                case "trainer": faszaklikk(webDriver, logger, Object_repo_Bissell.selector_trainer_contact, wait);
            }
            Thread.sleep(100);
            logger.info("Navigated to contacts OK");
        }

        private static void navigatetodashboard(Logger logger, WebDriver webDriver, WebDriverWait wait) throws InterruptedException {
            Thread.sleep(100);
            faszaklikk(webDriver, logger, Object_repo_Bissell.selector_admin_dashboard, wait);
            Thread.sleep(100);
            logger.info("Navigated to dashboard OK");
        }

        public static void main(String[] argv) throws Exception {
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

            //Init webdriver
            WebDriver webDriver = new ChromeDriver();
            WebDriverWait wait = (WebDriverWait) new WebDriverWait(webDriver, 10).ignoring(StaleElementReferenceException.class);

            gotourl(logger, webDriver, "https://test.bissellexpert.com/login");
            login(logger, webDriver, wait, "bisselladmin", "bisselladminpassword");
            navigatetoprofile(logger, webDriver, wait);

            ((JavascriptExecutor) webDriver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
            Thread.sleep(100);

            editprofile(logger, webDriver, wait);
            Thread.sleep(200);


            changepreferreddevicetotablet(logger, webDriver, wait);
            Thread.sleep(200);

            saveprofile(logger, webDriver, wait);
            Thread.sleep(200);

            ((JavascriptExecutor) webDriver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
            Thread.sleep(100);

            editprofile(logger, webDriver, wait);
            Thread.sleep(200);

            changepreferreddevicetosmartphone(logger, webDriver, wait);
            Thread.sleep(200);

            saveprofile(logger, webDriver, wait);
            //Thread.sleep(200);

            navigatetousergroups(logger, webDriver, wait, "admin");
            Thread.sleep(200);

            String userGroupName = createstudentusergroup(logger, webDriver, wait, "Quince Student");

            navigatetocommunication(logger, webDriver, wait, "admin");
            Thread.sleep(200);

            createcommunication(logger, webDriver, wait, userGroupName);
            Thread.sleep(200);

            navigatetodashboard(logger, webDriver, wait);
            Thread.sleep(200);

            checkcommunicationispublished(logger, webDriver, wait, userGroupName);
            Thread.sleep(200);

            //deletecommunication(logger, webDriver, wait);
            deletecreatedcommunication(logger, webDriver,wait, userGroupName, "admin");
            Thread.sleep(200);

            navigatetomodules(logger, webDriver, wait, "admin");
            //navigate_to_translate(logger, webDriver, wait);
            //navigatetomoduledetails(logger, webDriver, wait);
            //change_first_translation_and_save(logger, webDriver, wait);

            navigatetocontacts(logger, webDriver, wait, "admin");

            webDriver.quit();
        }

}
