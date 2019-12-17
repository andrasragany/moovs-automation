
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
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


public class Basic_test_Admin_Fiskars {

    private static String parseDate(LocalDateTime localDate) throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MM_dd__HH_mm_ss");
        return localDate.format(formatter);
    }

    public static void login(Logger logger, WebDriver webDriver, WebDriverWait wait, String user, String userpasswd) throws IOException, org.json.simple.parser.ParseException, InterruptedException {
        String UserJsonPath = "C:\\Users\\Rendszergazda\\IdeaProjects\\platformtest\\src\\main\\java\\user.json";
        Object obj = new JSONParser().parse(new FileReader(UserJsonPath));
        JSONObject jo = (JSONObject) obj;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_user_email))).sendKeys((String) jo.get(user));
        Thread.sleep(100);
        webDriver.findElement(By.xpath(Object_repo_Fiskars.selector_user_password)).sendKeys((String) jo.get(userpasswd));
        Thread.sleep(100);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_login_button))).click();
        Thread.sleep(100);
        logger.info("Logged in to test.fiskars website OK");
    }

    static void gotourl(Logger logger, WebDriver webDriver, WebDriverWait wait, String url) throws MalformedURLException, InterruptedException {
        webDriver.manage().window().maximize();
        webDriver.navigate().to(new URL("https://test.fiskarsacademy.com/login"));
        Thread.sleep(100);
        logger.info("Opened test.fiskars website OK");
    }

    private static void navigatetoprofile(Logger logger, WebDriver webDriver, WebDriverWait wait) throws InterruptedException {
        Thread.sleep(100);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_admin_user_dropdown))).click();
        Thread.sleep(100);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_admin_profile))).click();
        Thread.sleep(100);
        logger.info("Navigated to user profile page OK");
    }

    private static void navigatetousergroups(Logger logger, WebDriver webDriver, WebDriverWait wait) throws InterruptedException {
        Thread.sleep(100);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_admin_users))).click();
        Thread.sleep(100);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_admin_user_groups))).click();
        Thread.sleep(100);
        logger.info("Navigated to user groups page OK");
    }

    static String createstudentusergroup(Logger logger, WebDriver webDriver, WebDriverWait wait, String user) throws InterruptedException, ParseException {
        Thread.sleep(100);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_create_user_group_btn))).click();
        Thread.sleep(100);
        String sendkey_testgroup = ("Aut QS test group " + parseDate(LocalDateTime.now()));
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_usergroup_add_name))).sendKeys(sendkey_testgroup);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_usergroup_add_description))).sendKeys(sendkey_testgroup);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_usergroup_add_user_search))).sendKeys(user);
        Thread.sleep(100);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_usergroup_add_user_select_first))).click();
        Thread.sleep(100);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_usergroup_add_user))).click();
        Thread.sleep(100);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_usergroup_save))).click();
        Thread.sleep(100);
        webDriver.navigate().refresh();
        Thread.sleep(100);
        logger.info("Created" + user + " user group page OK");
        return sendkey_testgroup;

    }

    private static void editprofile(Logger logger, WebDriver webDriver, WebDriverWait wait) throws InterruptedException {
        //((JavascriptExecutor) webDriver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(100);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_admin_profile_edit_button))).click();
        Thread.sleep(100);
        logger.info("Opened user profile page for editing OK");
    }

    private static void changepreferreddevicetotablet(Logger logger, WebDriver webDriver, WebDriverWait wait) throws InterruptedException {
        Thread.sleep(100);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_preferred_device_dropdown))).click();
        Thread.sleep(100);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_preferred_device_totablet))).click();
        Thread.sleep(100);
        logger.info("Changed user's preferred device to tablet OK");
    }

    private static void changepreferreddevicetosmartphone(Logger logger, WebDriver webDriver, WebDriverWait wait) throws InterruptedException {
        Thread.sleep(100);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_preferred_device_dropdown))).click();
        Thread.sleep(100);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_preferred_device_tosmatphone))).click();
        Thread.sleep(100);
        logger.info("Changed user's preferred device to smartphone OK");
    }

    private static void saveprofile(Logger logger, WebDriver webDriver, WebDriverWait wait) throws InterruptedException {
        Thread.sleep(100);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_profile_edit_Save))).click();
        Thread.sleep(100);
        logger.info("Saved user profile OK");
    }

    static void navigatetocommunication(Logger logger, WebDriver webDriver, WebDriverWait wait) throws InterruptedException {
        Thread.sleep(100);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_admin_communication))).click();
        Thread.sleep(100);
        logger.info("Navigated to communication page OK");
    }

    private static void deletecommunication(Logger logger, WebDriver webDriver, WebDriverWait wait) throws InterruptedException {
        navigatetocommunication(logger, webDriver, wait);
        Thread.sleep(100);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_comm_search_input))).sendKeys("Aut QS test group");
        Thread.sleep(100);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_comm_search_input_searchbtn))).click();
        Thread.sleep(200);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_comm_search_result_sort_dropdown))).click();
        Thread.sleep(100);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_comm_result_list_sort_descending_date))).click();
        Thread.sleep(200);
        for (int j=1; j<6; j++){
            String tempxpath = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[4]/div[2]/div[" + j + "]/div/div[2]/div/div/button";
            try {
                WebElement tempelement = webDriver.findElement(By.xpath(tempxpath));
                if (tempelement.isDisplayed()) {
                    tempelement.click();
                    Thread.sleep(200);
                    wait.until(elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[2]/div[4]/div[2]/div[" + j + "]/div/div[2]/div/div/div/button"))).click();
                    Thread.sleep(200);
                    wait.until(elementToBeClickable(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/button[1]"))).click();
                    Thread.sleep(3000);
                }
            }
            catch (NoSuchElementException E){}

        }
        logger.info("Deleted communication OK");
    }

    private static void createcommunication(Logger logger, WebDriver webDriver, WebDriverWait wait, String groupname) throws InterruptedException {
        Thread.sleep(100);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_create_communication_button))).click();
        Thread.sleep(100);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_comm_add_title))).sendKeys(groupname);
        Thread.sleep(100);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_comm_add_description))).sendKeys(groupname);
        Thread.sleep(100);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_comm_check_news))).click();
        Thread.sleep(100);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_comm_search_group))).sendKeys(groupname);
        Thread.sleep(100);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_comm_select_first_group))).click();
        Thread.sleep(100);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_comm_add_group_btn))).click();
        Thread.sleep(100);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_comm_check_now))).click();
        Thread.sleep(100);
        ((JavascriptExecutor) webDriver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_comm_save))).click();
        //click comm on dashboard
        webDriver.navigate().refresh();
        Thread.sleep(100);
        logger.info("Created communication OK");
    }

    private static boolean checkcommunicationispublished(Logger logger, WebDriver webDriver, WebDriverWait wait, String communicationname) throws InterruptedException {
        wait.until(elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[2]/div[1]/div[1]/div/div/div[1]/div/span"))).click();
        Thread.sleep(1000);
        if (webDriver.findElement((By.xpath("/html/body/div[2]/div/div/div/div[1]/h1"))).getText().contains(communicationname)) {
            wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.Selector_admin_dashboard_closecomm_modal))).click();
            logger.info("Communication was published OK");
            return true;
        }
        else{
            wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.Selector_admin_dashboard_closecomm_modal))).click();
            logger.info("Communication was not published NOT OK");
            return false;
        }
    }

    private static void navigatetomodules(Logger logger, WebDriver webDriver, WebDriverWait wait) throws InterruptedException {
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_admin_modules))).click();
        Thread.sleep(200);
        logger.info("Navigated to modules page OK");
    }

    private static void navigate_to_translate (Logger logger, WebDriver webDriver, WebDriverWait wait) throws InterruptedException {
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_admin_modules_first_action_dropdown))).click();
        Thread.sleep(200);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_admin_modules_first_dropdown_translate))).click();
        Thread.sleep(200);
        logger.info("Navigated to module translation page OK");
    }

    private static void navigatetomoduledetails (Logger logger, WebDriver webDriver, WebDriverWait wait) throws InterruptedException {
        webDriver.navigate().refresh();
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_admin_module_translate_module_details))).click();
        Thread.sleep(200);
        logger.info("In module translation page, navigated to module details tab OK");
    }

    private static void change_first_translation_and_save (Logger logger, WebDriver webDriver, WebDriverWait wait) throws InterruptedException {
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_admin_translate_moduledetails_first_input ))).sendKeys("Auto_translate_test");
        Thread.sleep(200);
        ((JavascriptExecutor) webDriver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(100);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_admin_translate_changed_save ))).click();
        Thread.sleep(200);
        logger.info("Changed first item translation OK");
    }

    private static void deletecreatedcommunication(Logger logger, WebDriver webDriver, WebDriverWait wait, String communicationname) throws  InterruptedException {
        navigatetocommunication(logger, webDriver, wait);
        Thread.sleep(100);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_comm_search_input))).sendKeys(communicationname);
        Thread.sleep(100);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_comm_search_input_searchbtn))).click();
        Thread.sleep(200);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_trainer_comm_found_list_first_action_dropdown))).click();
        Thread.sleep(100);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_comm_found_list_first_action_deletebtn))).click();
        Thread.sleep(100);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_comm_action_delete_confirm))).click();
        logger.info("Deleted created communication OK");
    }

    private static void navigatetocontacts(Logger logger, WebDriver webDriver, WebDriverWait wait) throws InterruptedException {
        Thread.sleep(100);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_admin_contact))).click();
        Thread.sleep(100);
        logger.info("Navigated to contacts OK");
    }

    private static void navigatetodashboard(Logger logger, WebDriver webDriver, WebDriverWait wait) throws InterruptedException {
        Thread.sleep(100);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Fiskars.selector_admin_dashboard))).click();
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
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(webDriver, 5).ignoring(StaleElementReferenceException.class);

        //open testfiskars
        gotourl(logger, webDriver, wait, "https://test.fiskarsacademy.com/login");

        //Login
        login(logger, webDriver, wait, "admin", "adminpassword");


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

        navigatetousergroups(logger, webDriver, wait);
        Thread.sleep(200);

        String userGroupName = createstudentusergroup(logger, webDriver, wait, "Quince Student");

        navigatetocommunication(logger, webDriver, wait);
        Thread.sleep(200);

        createcommunication(logger, webDriver, wait, userGroupName);
        Thread.sleep(200);

        navigatetodashboard(logger, webDriver, wait);
        Thread.sleep(200);

        checkcommunicationispublished(logger, webDriver, wait, userGroupName);
        Thread.sleep(200);

        //deletecommunication(logger, webDriver, wait);
        deletecreatedcommunication(logger, webDriver,wait, userGroupName);
        Thread.sleep(200);

        navigatetomodules(logger, webDriver, wait);
        navigate_to_translate(logger, webDriver, wait);
        navigatetomoduledetails(logger, webDriver, wait);
        change_first_translation_and_save(logger, webDriver, wait);

        navigatetocontacts(logger, webDriver, wait);

        webDriver.quit();
    }


}