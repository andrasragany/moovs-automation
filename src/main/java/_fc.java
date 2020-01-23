import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class _fc {

    static String parseDate(LocalDateTime localDate) throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MM_dd__HH_mm_ss");
        return localDate.format(formatter);
    }

     static boolean faszaklikk(WebDriver webDriver, Logger logger, String webElement, WebDriverWait wait, String what) throws InterruptedException, TimeoutException {
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
                    logger.info("NOT OK, " + e.toString() + what);
                    Thread.sleep(1000);
                    counter++;
                }
            }
        }
        if (!bul) {
            logger.info(what + "faszaklikkelt lett");
            return true;
        } else {
            logger.info(what + "NOT OK");
            webDriver.quit();
            return false;
        }
    }

    static void gotourl(Logger logger, WebDriver webDriver, String url) throws MalformedURLException, InterruptedException {
        webDriver.manage().window().maximize();
        webDriver.navigate().to(new URL(url));
        Thread.sleep(100);
        logger.info("Opened test.bissell website OK");
    }

    public static void login(Logger logger, WebDriver webDriver, WebDriverWait wait, String user, String userpasswd) throws IOException, org.json.simple.parser.ParseException, InterruptedException {
        //String UserJsonPath = "c:\\Users\\Rendszergazda\\IdeaProjects\\platformtest\\src\\main\\java\\user.json";
        String UserJsonPath = "c:\\Users\\randr\\IdeaProjects\\platformtest\\src\\main\\java\\user.json";
        Object obj = new JSONParser().parse(new FileReader(UserJsonPath));
        JSONObject jo = (JSONObject) obj;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Object_repo_Philips.selector_user_email))).sendKeys((String) jo.get(user));
        webDriver.findElement(By.xpath(Object_repo_Philips.selector_user_password)).sendKeys((String) jo.get(userpasswd));
        Thread.sleep(1000);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_login_button, wait,"selector_login_button");
        Thread.sleep(1000);
        logger.info("Logged in to test.bissell website OK");
    }

    private static void navigatetodashboard(Logger logger, WebDriver webDriver, WebDriverWait wait) throws InterruptedException {
        Thread.sleep(100);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_admin_dashboard_Bissell, wait, "selector_admin_dashboard");
        Thread.sleep(100);
        logger.info("Navigated to dashboard OK");
    }

    private static void navigatetoprofile(Logger logger, WebDriver webDriver, WebDriverWait wait) throws InterruptedException {
        Thread.sleep(1000);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_admin_user_dropdown, wait, "selector_admin_user_dropdown");
        Thread.sleep(1000);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_admin_profile_Bissell, wait, "selector_admin_profile");
        Thread.sleep(500);
        logger.info("Navigated to user profile page OK");
    }

    private static void editprofile(Logger logger, WebDriver webDriver, WebDriverWait wait) throws InterruptedException {
        //((JavascriptExecutor) webDriver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(100);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_admin_profile_edit_button, wait, "selector_admin_profile_edit_button");
        Thread.sleep(100);
        logger.info("Opened user profile page for editing OK");
    }

    private static void changepreferreddevicetotablet(Logger logger, WebDriver webDriver, WebDriverWait wait) throws InterruptedException {
        Thread.sleep(100);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_preferred_device_dropdown, wait, "selector_preferred_device_dropdown");
        Thread.sleep(100);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_preferred_device_totablet, wait, "selector_preferred_device_totablet");
        Thread.sleep(100);
        logger.info("Changed user's preferred device to tablet OK");
    }

    private static void changepreferreddevicetosmartphone(Logger logger, WebDriver webDriver, WebDriverWait wait) throws InterruptedException {
        Thread.sleep(100);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_preferred_device_dropdown, wait, "selector_preferred_device_dropdown");
        Thread.sleep(100);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_preferred_device_tosmatphone, wait, "selector_preferred_device_tosmatphone");
        Thread.sleep(100);
        logger.info("Changed user's preferred device to smartphone OK");
    }

    private static void saveprofile(Logger logger, WebDriver webDriver, WebDriverWait wait) throws InterruptedException {
        Thread.sleep(100);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_profile_edit_Save, wait, "selector_profile_edit_Save");
        Thread.sleep(100);
        logger.info("Saved user profile OK");
    }

    static void navigatetousergroups(Logger logger, WebDriver webDriver, WebDriverWait wait, String user) throws InterruptedException {
        Thread.sleep(100);
        switch (user) {
            case "admin": faszaklikk(webDriver, logger, Object_repo_Philips.selector_admin_users_Bissell, wait, "selector_admin_users");
                break;
            case "trainer": faszaklikk(webDriver, logger, Object_repo_Philips.selector_trainer_users_Bissell, wait, "selector_trainer_users");
                break;
        }
        Thread.sleep(100);
        webDriver.navigate().refresh();
        Thread.sleep(100);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_admin_user_groups, wait, "selector_admin_user_groups");
        Thread.sleep(100);
        logger.info("Navigated to user groups page OK");
    }

    static String create_usergroup(Logger logger, WebDriver webDriver, WebDriverWait wait, String user) throws InterruptedException, ParseException {
        Thread.sleep(100);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_create_user_group_btn, wait, "selector_create_user_group_btn");
        Thread.sleep(100);
        String testgroup_name_to_be_used_later = ("Aut " + user+ " " + parseDate(LocalDateTime.now()));
        wait.until(elementToBeClickable(By.xpath(Object_repo_Philips.selector_usergroup_add_name))).sendKeys(testgroup_name_to_be_used_later);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Philips.selector_usergroup_add_description))).sendKeys(testgroup_name_to_be_used_later);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Philips.selector_usergroup_add_user_search))).sendKeys(user);
        Thread.sleep(200);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_usergroup_add_user_select_first, wait, "selector_usergroup_add_user_select_first");
        Thread.sleep(100);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_usergroup_add_user, wait, "selector_usergroup_add_user");
        Thread.sleep(100);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_usergroup_save, wait, "selector_usergroup_save");
        Thread.sleep(100);
        webDriver.navigate().refresh();
        Thread.sleep(100);
        logger.info("Created student user group page OK");
        return testgroup_name_to_be_used_later;
    }

    static void navigatetocommunication(Logger logger, WebDriver webDriver, WebDriverWait wait, String user) throws InterruptedException {
        Thread.sleep(100);
        switch (user) {
            case "admin": faszaklikk(webDriver, logger, Object_repo_Philips.selector_admin_communication_Bissell, wait, "selector_admin_communication");
                break;
            case "trainer": faszaklikk(webDriver, logger, Object_repo_Philips.selector_trainer_communication_Bissell, wait, "selector_trainer_communication");
                break;
        }
        Thread.sleep(100);
        logger.info("Navigated to communication page OK");
    }

    static void createcommunication(Logger logger, WebDriver webDriver, WebDriverWait wait, String groupname) throws InterruptedException {
        Thread.sleep(100);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_create_communication_button, wait, "selector_create_communication_button");
        Thread.sleep(100);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Philips.selector_comm_add_title))).sendKeys(groupname);
        Thread.sleep(100);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Philips.selector_comm_add_description))).sendKeys(groupname);
        Thread.sleep(100);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_comm_check_news, wait, "selector_comm_check_news");
        Thread.sleep(100);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Philips.selector_comm_search_group))).sendKeys(groupname);
        Thread.sleep(100);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_comm_select_first_group, wait, "selector_comm_select_first_group");
        Thread.sleep(100);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_comm_add_group_btn, wait, "selector_comm_add_group_btn");
        Thread.sleep(100);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_comm_check_now, wait, "selector_comm_check_now");
        Thread.sleep(100);
        ((JavascriptExecutor) webDriver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_comm_save, wait, "selector_comm_save");
        //click comm on dashboard
        webDriver.navigate().refresh();
        Thread.sleep(100);
        logger.info("Created communication OK");
    }

    static String create_comm(WebDriver webDriver, Logger logger, WebDriverWait wait, String userGroupNameChrome2) throws ParseException, InterruptedException {
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_trainer_communication_Bissell, wait, "");
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_trainer_create_communication_button, wait, "");
        String sendkey_communicationname = ("Communication autotest " +parseDate(LocalDateTime.now()));
        if (faszaklikk(webDriver, logger, Object_repo_Philips.selector_trainer_comm_add_title, wait, ""))
            webDriver.findElement(By.xpath(Object_repo_Philips.selector_trainer_comm_add_title)).sendKeys(sendkey_communicationname);
        if (faszaklikk(webDriver, logger, Object_repo_Philips.selector_trainer_comm_add_description, wait, ""))
            webDriver.findElement(By.xpath(Object_repo_Philips.selector_trainer_comm_add_description)).sendKeys(sendkey_communicationname);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_trainer_comm_check_news, wait, "");
        if (faszaklikk(webDriver, logger, Object_repo_Philips.selector_trainer_comm_search_group, wait, ""))
            webDriver.findElement(By.xpath(Object_repo_Philips.selector_trainer_comm_search_group)).sendKeys(userGroupNameChrome2);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_trainer_comm_select_first_group, wait, "");
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_trainer_comm_add_group_btn, wait, "");
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_trainer_comm_check_now, wait, "");
        ((JavascriptExecutor) webDriver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_trainer_comm_save, wait, "");
        return sendkey_communicationname;
    }

    static boolean checkcommunicationispublished(Logger logger, WebDriver webDriver, WebDriverWait wait, String communicationname) throws InterruptedException {
        faszaklikk(webDriver, logger, Object_repo_Philips.Selector_admin_dashboard_comm_list_first_item, wait, "Selector_admin_dashboard_comm_list_first_item");
        Thread.sleep(1000);
        if (webDriver.findElement((By.xpath(Object_repo_Philips.Selector_admin_dashboard_comm_list_first_item_title))).getText().contains(communicationname)) {
            faszaklikk(webDriver, logger, Object_repo_Philips.Selector_admin_dashboard_closecomm_modal, wait, "Selector_admin_dashboard_closecomm_modal");
            logger.info("Communication was published OK");
            return true;
        }
        else{
            faszaklikk(webDriver, logger, Object_repo_Philips.Selector_admin_dashboard_closecomm_modal, wait, "Selector_admin_dashboard_closecomm_modal");
            logger.info("Communication was not published NOT OK");
            return false;
        }
    }

    static void openclose_comm(WebDriver webDriver, Logger logger, WebDriverWait wait) throws InterruptedException {
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_trainer_dashboard_Bissell, wait, "");
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_trainer_dashboard_tracking_tab, wait, "");
        faszaklikk(webDriver, logger, Object_repo_Philips.Selector_trainer_dashboard_opencomm_modal_Bissell, wait, "");
        faszaklikk(webDriver, logger, Object_repo_Philips.Selector_trainer_dashboard_closecomm_modal_Bissell, wait, "");
    }

    static void deletecommunication(Logger logger, WebDriver webDriver, WebDriverWait wait) throws InterruptedException {
        navigatetocommunication(logger, webDriver, wait, "admin");
        Thread.sleep(100);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Philips.selector_comm_search_input))).sendKeys("Aut QS test group");
        Thread.sleep(100);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_comm_search_input_searchbtn, wait, "selector_comm_search_input_searchbtn");
        Thread.sleep(200);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_comm_search_result_sort_dropdown, wait, "selector_comm_search_result_sort_dropdown");
        Thread.sleep(100);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_comm_result_list_sort_descending_date, wait, "selector_comm_result_list_sort_descending_date");
        Thread.sleep(200);
        for (int j=1; j<6; j++){
            String tempxpath = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[4]/div[2]/div[" + j + "]/div/div[2]/div/div/button";
            try {
                WebElement tempelement = webDriver.findElement(By.xpath(tempxpath));
                if (tempelement.isDisplayed()) {
                    tempelement.click();
                    Thread.sleep(200);
                    faszaklikk(webDriver, logger, "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[4]/div[2]/div[" + j + "]/div/div[2]/div/div/div/button", wait, "comm machinálás");
                    Thread.sleep(200);
                    faszaklikk(webDriver, logger, "/html/body/div[2]/div/div/div/div[2]/div[2]/button[1]", wait, "comm machinálás");
                    Thread.sleep(3000);
                }
            }
            catch (NoSuchElementException E){}

        }
        logger.info("Deleted communication OK");
    }

    static void deletecomm(WebDriver webDriver, Logger logger, WebDriverWait wait, String sendkey_communicationname) throws InterruptedException {
        Thread.sleep(200);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_trainer_communication_Bissell, wait, "");
        if (faszaklikk(webDriver, logger, Object_repo_Philips.selector_trainer_comm_search_input, wait, ""))
            webDriver.findElement(By.xpath(Object_repo_Philips.selector_trainer_comm_search_input)).sendKeys(sendkey_communicationname);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_trainer_comm_search_input_searchbtn, wait, "");
        Thread.sleep(200);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_trainer_comm_found_list_first_action_dropdown, wait, "");
        Thread.sleep(200);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_trainer_comm_found_list_first_action_deletebtn, wait, "");
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_trainer_comm_action_delete_confirm, wait, "");
    }

    static void deletecreatedcommunication(Logger logger, WebDriver webDriver, WebDriverWait wait, String communicationname, String user) throws  InterruptedException {
        navigatetocommunication(logger, webDriver, wait, user);
        Thread.sleep(100);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Philips.selector_comm_search_input))).sendKeys(communicationname);
        Thread.sleep(100);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_comm_search_input_searchbtn, wait, "selector_comm_search_input_searchbtn");
        Thread.sleep(200);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_trainer_comm_found_list_first_action_dropdown, wait, "selector_trainer_comm_found_list_first_action_dropdown");
        Thread.sleep(100);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_comm_found_list_first_action_deletebtn, wait, "selector_comm_found_list_first_action_deletebtn");
        Thread.sleep(100);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_comm_action_delete_confirm, wait, "selector_comm_action_delete_confirm");
        logger.info("Deleted created communication OK");
    }

    static void navigatetomodules(Logger logger, WebDriver webDriver, WebDriverWait wait, String user) throws InterruptedException {
        switch (user) {
            case "admin": faszaklikk(webDriver, logger, Object_repo_Philips.selector_admin_modules_Bissell, wait, "selector_admin_modules");
                break;
            case "trainer": faszaklikk(webDriver, logger, Object_repo_Philips.selector_trainer_modules_Bissell, wait, "selector_trainer_modules");
                break;
        }
        Thread.sleep(200);
        logger.info("Navigated to modules page OK");
    }

    static void navigatetomoduledetails (Logger logger, WebDriver webDriver, WebDriverWait wait) throws InterruptedException {
        webDriver.navigate().refresh();
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_admin_module_translate_module_details, wait, "selector_admin_module_translate_module_details");
        Thread.sleep(200);
        logger.info("In module translation page, navigated to module details tab OK");
    }

    static void navigate_to_translate (Logger logger, WebDriver webDriver, WebDriverWait wait) throws InterruptedException {
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_admin_modules_first_action_dropdown, wait, "selector_admin_modules_first_action_dropdown");
        Thread.sleep(200);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_admin_modules_first_dropdown_translate, wait, "selector_admin_modules_first_dropdown_translate");
        Thread.sleep(200);
        logger.info("Navigated to module translation page OK");
    }

    static void change_first_translation_and_save (Logger logger, WebDriver webDriver, WebDriverWait wait) throws InterruptedException {
        wait.until(elementToBeClickable(By.xpath(Object_repo_Philips.selector_admin_translate_moduledetails_first_input ))).sendKeys("Auto_translate_test");
        Thread.sleep(200);
        ((JavascriptExecutor) webDriver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(100);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_admin_translate_changed_save, wait, "selector_admin_translate_changed_save");
        Thread.sleep(200);
        logger.info("Changed first item translation OK");
    }

    static void create_training (WebDriver webDriver, WebDriverWait wait, Logger logger, String userGroupNameChrome2) throws InterruptedException {
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_trainer_training_lib_trainer, wait, "");
        webDriver.navigate().refresh();
        Thread.sleep(100);

        faszaklikk(webDriver, logger, Object_repo_Philips.selector_trainer_create_training_btn, wait, "");

        if (faszaklikk(webDriver, logger, Object_repo_Philips.selector_trainer_training_add_name, wait, ""))
            webDriver.findElement(By.xpath(Object_repo_Philips.selector_trainer_training_add_name)).sendKeys(userGroupNameChrome2);

        if (faszaklikk(webDriver, logger, Object_repo_Philips.selector_trainer_training_add_description, wait, ""))
            webDriver.findElement(By.xpath(Object_repo_Philips.selector_trainer_training_add_description)).sendKeys(userGroupNameChrome2);

        faszaklikk(webDriver, logger, Object_repo_Philips.selector_trainer_create_training_modules_tab, wait, "");

        faszaklikk(webDriver, logger, Object_repo_Philips.selector_trainer_create_training_add_module_btn, wait, "");

        faszaklikk(webDriver, logger, Object_repo_Philips.selector_trainer_create_tr_add_mod_checkbox, wait, "");

        faszaklikk(webDriver, logger, Object_repo_Philips.selector_trainer_create_tr_add_selected_module_btn, wait, "");

        faszaklikk(webDriver, logger, Object_repo_Philips.selector_trainer_create_tr_exam_tab, wait, "");


        faszaklikk(webDriver, logger, Object_repo_Philips.selector_trainer_save_training_btn, wait, "");

        webDriver.navigate().refresh();
    }

    static void create_LP ( WebDriver webDriver, WebDriverWait wait, Logger logger, String userGroupNameChrome2) throws InterruptedException {



        faszaklikk(webDriver, logger, Object_repo_Fiskars.selector_trainer_learning_path, wait, "");

        faszaklikk(webDriver, logger, Object_repo_Fiskars.selector_trainer_create_learning_path_button, wait, "");

        webDriver.navigate().refresh();

        Thread.sleep(100);


        if (faszaklikk(webDriver, logger, Object_repo_Philips.selector_trainer_add_LP_name, wait, ""))
            webDriver.findElement(By.xpath(Object_repo_Fiskars.selector_trainer_add_LP_name)).sendKeys(userGroupNameChrome2);

        if (faszaklikk(webDriver, logger, Object_repo_Fiskars.selector_trainer_add_LP_description, wait, ""))
            webDriver.findElement(By.xpath(Object_repo_Fiskars.selector_trainer_add_LP_description)).sendKeys(userGroupNameChrome2);

        faszaklikk(webDriver, logger, Object_repo_Fiskars.selector_trainer_cr_LP_participants_tab, wait, "");

        if (faszaklikk(webDriver, logger, Object_repo_Fiskars.selector_trainer_LP_search_group, wait, ""))
            webDriver.findElement(By.xpath(Object_repo_Fiskars.selector_trainer_LP_search_group)).sendKeys(userGroupNameChrome2);

        faszaklikk(webDriver, logger, Object_repo_Fiskars.selector_trainer_LP_select_group, wait, "");

        faszaklikk(webDriver, logger, Object_repo_Fiskars.selector_trainer_LP_add_first_group, wait, "");

        faszaklikk(webDriver, logger, Object_repo_Fiskars.selector_trainer_LP_path_tab, wait, "");

        faszaklikk(webDriver, logger, Object_repo_Fiskars.selector_trainer_LP_open_path_selector, wait, "");

        if (faszaklikk(webDriver, logger, Object_repo_Fiskars.selector_trainer_LP_search_for_path, wait, ""))
            webDriver.findElement(By.xpath(Object_repo_Fiskars.selector_trainer_LP_search_for_path)).sendKeys(userGroupNameChrome2);

        faszaklikk(webDriver, logger, Object_repo_Fiskars.selector_trainer_LP_select_path_checkbox, wait, "");

        faszaklikk(webDriver, logger, Object_repo_Fiskars.selector_trainer_LP_add_selected_path, wait, "");

        faszaklikk(webDriver, logger, Object_repo_Fiskars.selector_trainer_LP_save_LP_button, wait, "");
    }
}
