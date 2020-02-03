import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;
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
                    //logger.info("NOT OK, " + e.toString() + what);
                    Thread.sleep(1000);
                    counter++;
                }
            }
        }
        if (!bul) {
            //logger.info(what + "faszaklikkelt lett");
            return true;
        } else {
            logger.info(what + " NOT OK");
            return false;
        }
    }

    static void gotourl(Logger logger, WebDriver webDriver, String url) throws MalformedURLException, InterruptedException {
        webDriver.navigate().to(new URL(url));
        Thread.sleep(1000);
        logger.info("Opened website OK");
    }

    public static void login(Logger logger, WebDriver webDriver, WebDriverWait wait, String user, String userpasswd) throws IOException, org.json.simple.parser.ParseException, InterruptedException {
        //String UserJsonPath = "c:\\Users\\Rendszergazda\\IdeaProjects\\platformtest\\src\\main\\java\\user.json";
        String UserJsonPath = "c:\\Users\\randr\\IdeaProjects\\platformtest\\src\\main\\java\\user.json";
        Object obj = new JSONParser().parse(new FileReader(UserJsonPath));
        JSONObject jo = (JSONObject) obj;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Object_repo_Philips.selector_user_email))).sendKeys((String) jo.get(user));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Object_repo_Philips.selector_user_password))).sendKeys((String) jo.get(userpasswd));
        Thread.sleep(1000);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_login_button, wait,"selector_login_button");
        Thread.sleep(2000);
        logger.info("Logged in to website OK");
    }

    static void navigatetodashboard(Logger logger, WebDriver webDriver, WebDriverWait wait) throws InterruptedException {
        Thread.sleep(100);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_dashboard, wait, "selector_admin_dashboard");
        Thread.sleep(100);
        logger.info("Navigated to dashboard OK");
    }

    static void navigatetoprofile(Logger logger, WebDriver webDriver, String url) throws InterruptedException, MalformedURLException {
        gotourl(logger, webDriver,url);
    }

    static void editprofile(Logger logger, WebDriver webDriver, WebDriverWait wait) throws InterruptedException {
        Actions actions = new Actions(webDriver);
        actions.sendKeys(Keys.END).perform();
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_profile_edit_button, wait, "selector_profile_edit_button");
        Thread.sleep(1000);
        logger.info("Opened user profile page for editing OK");
    }

    static void changepreferreddevicetotablet(Logger logger, WebDriver webDriver, WebDriverWait wait) throws InterruptedException {
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_preferred_device_dropdown, wait, "selector_preferred_device_dropdown");
        Thread.sleep(100);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_preferred_device_totablet, wait, "selector_preferred_device_totablet");
        Thread.sleep(100);
        logger.info("Changed user's preferred device to tablet OK");
    }

    static void changepreferreddevicetotablet_EMEA(Logger logger, WebDriver webDriver, WebDriverWait wait) throws InterruptedException {
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_EMEA_preferred_device_dropdown, wait, "selector_preferred_device_dropdown");
        Thread.sleep(100);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_EMEA_pref_dev_totablet, wait, "selector_preferred_device_totablet");
        Thread.sleep(100);
        logger.info("Changed user's preferred device to tablet OK");
    }

    static void changepreferreddevicetosmartphone(Logger logger, WebDriver webDriver, WebDriverWait wait) throws InterruptedException {
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_preferred_device_dropdown, wait, "selector_preferred_device_dropdown");
        Thread.sleep(100);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_preferred_device_tosmatphone, wait, "selector_preferred_device_tosmatphone");
        Thread.sleep(100);
        logger.info("Changed user's preferred device to smartphone OK");
    }

    static void saveprofile(Logger logger, WebDriver webDriver, WebDriverWait wait) throws InterruptedException {
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_profile_edit_Save, wait, "selector_profile_edit_Save");
        Thread.sleep(1000);
        logger.info("Saved user profile OK");
    }

    static void navigatetousergroups(Logger logger, WebDriver webDriver, WebDriverWait wait, String user) throws InterruptedException {
        switch (user) {
            case "admin": faszaklikk(webDriver, logger, Object_repo_Philips.selector_users, wait, "selector_admin_users");
                break;
            case "trainer": faszaklikk(webDriver, logger, Object_repo_Philips.selector_users, wait, "selector_trainer_users");
                break;
        }
        Thread.sleep(1000);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_user_groups, wait, "selector_user_groups");
        Thread.sleep(1000);
        logger.info("Navigated to user groups page OK");
    }

    static String create_usergroup(Logger logger, WebDriver webDriver, WebDriverWait wait, String user) throws InterruptedException, ParseException {
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_user_create_usergroup_button, wait, "selector_create_user_group_btn");
        Thread.sleep(1000);
        String testgroup_name_to_be_used_later = ("Aut " + user+ " " + parseDate(LocalDateTime.now()));
        wait.until(elementToBeClickable(By.xpath(Object_repo_Philips.selector_usergroup_add_name))).sendKeys(testgroup_name_to_be_used_later);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Philips.selector_usergroup_add_description))).sendKeys(testgroup_name_to_be_used_later);
        wait.until(elementToBeClickable(By.xpath(Object_repo_Philips.selector_usergroup_add_user_search))).sendKeys(user);
        Thread.sleep(1000);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_usergroup_add_user_select_first, wait, "selector_usergroup_add_user_select_first");
        Thread.sleep(1000);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_usergroup_add_user, wait, "selector_usergroup_add_user");
        Thread.sleep(1000);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_usergroup_save, wait, "selector_usergroup_save");
        Thread.sleep(1000);
        logger.info("Created student user group page OK");
        return testgroup_name_to_be_used_later;
    }

    static void navigatetocommunication(Logger logger, WebDriver webDriver, WebDriverWait wait, String user) throws InterruptedException {
        switch (user) {
            case "admin": faszaklikk(webDriver, logger, Object_repo_Philips.selector_admin_communication_Bissell, wait, "selector_admin_communication");
                break;
            case "trainer": faszaklikk(webDriver, logger, Object_repo_Philips.selector_communication, wait, "selector_trainer_communication");
                break;
        }
        Thread.sleep(1000);
        logger.info("Navigated to communication page OK");
    }

    static void createcommunication(Logger logger, WebDriver webDriver, WebDriverWait wait, String groupname) throws InterruptedException {
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_create_communication_button, wait, "selector_create_communication_button");
        Thread.sleep(1000);
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
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_communication_save, wait, "selector_comm_save");
        Thread.sleep(1000);
        logger.info("Created communication OK");
    }

    static String create_comm(WebDriver webDriver, Logger logger, WebDriverWait wait, String userGroupNameChrome2) throws ParseException, InterruptedException {
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_communication, wait, "");
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
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_communication_save, wait, "");
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
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_communication, wait, "");
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
            case "admin": faszaklikk(webDriver, logger, Object_repo_Philips.selector_modules, wait, "selector_admin_modules");
                break;
            case "trainer": faszaklikk(webDriver, logger, Object_repo_Philips.selector_modules, wait, "selector_trainer_modules");
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
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_training_lib, wait, "selector_training_lib");
        Thread.sleep(1000);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_create_training_button, wait, "selector_create_training_button");
        webDriver.navigate().refresh();
        Thread.sleep(1000);
        if (faszaklikk(webDriver, logger, Object_repo_Philips.selector_trainer_training_add_name, wait, "selector_trainer_training_add_name"))
            webDriver.findElement(By.xpath(Object_repo_Philips.selector_trainer_training_add_name)).sendKeys(userGroupNameChrome2);

        if (faszaklikk(webDriver, logger, Object_repo_Philips.selector_trainer_training_add_description, wait, "selector_trainer_training_add_description"))
            webDriver.findElement(By.xpath(Object_repo_Philips.selector_trainer_training_add_description)).sendKeys(userGroupNameChrome2);

        faszaklikk(webDriver, logger, Object_repo_Philips.selector_create_training_modules_tab, wait, "selector_trainer_create_training_modules_tab");
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_trainer_create_training_add_module_btn, wait, "selector_trainer_create_training_add_module_btn");
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_trainer_create_tr_add_mod_checkbox, wait, "selector_trainer_create_tr_add_mod_checkbox");
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_trainer_create_tr_add_selected_module_btn, wait, "selector_trainer_create_tr_add_selected_module_btn");
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_trainer_create_tr_exam_tab, wait, "selector_trainer_create_tr_exam_tab");
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_save_training_button, wait, "");
        Thread.sleep(1000);
    }

    static void create_LP ( WebDriver webDriver, WebDriverWait wait, Logger logger, String userGroupNameChrome2) throws InterruptedException {
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_learning_paths, wait, "selector_trainer_learning_path");
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_create_LP_btn, wait, "selector_trainer_create_learning_path_button");
        webDriver.navigate().refresh();
        Thread.sleep(1000);
        if (faszaklikk(webDriver, logger, Object_repo_Philips.selector_trainer_add_LP_name, wait, "selector_trainer_add_LP_name"))
            webDriver.findElement(By.xpath(Object_repo_Philips.selector_trainer_add_LP_name)).sendKeys(userGroupNameChrome2);

        if (faszaklikk(webDriver, logger, Object_repo_Philips.selector_trainer_add_LP_description, wait, "selector_trainer_add_LP_description"))
            webDriver.findElement(By.xpath(Object_repo_Philips.selector_trainer_add_LP_description)).sendKeys(userGroupNameChrome2);

        faszaklikk(webDriver, logger, Object_repo_Philips.selector_trainer_cr_LP_participants_tab, wait, "selector_trainer_cr_LP_participants_tab");

        if (faszaklikk(webDriver, logger, Object_repo_Philips.selector_trainer_LP_search_group, wait, "selector_trainer_LP_search_group"))
            webDriver.findElement(By.xpath(Object_repo_Philips.selector_trainer_LP_search_group)).sendKeys(userGroupNameChrome2);
        Thread.sleep(1000);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_trainer_LP_select_group, wait, "selector_trainer_LP_select_group");

        faszaklikk(webDriver, logger, Object_repo_Philips.selector_trainer_LP_add_first_group, wait, "selector_trainer_LP_add_first_group");

        faszaklikk(webDriver, logger, Object_repo_Philips.selector_trainer_LP_path_tab, wait, "selector_trainer_LP_path_tab");

        faszaklikk(webDriver, logger, Object_repo_Philips.selector_trainer_LP_open_path_selector, wait, "selector_trainer_LP_open_path_selector");

        if (faszaklikk(webDriver, logger, Object_repo_Philips.selector_trainer_LP_search_for_path, wait, "selector_trainer_LP_search_for_path"))
            webDriver.findElement(By.xpath(Object_repo_Philips.selector_trainer_LP_search_for_path)).sendKeys(userGroupNameChrome2);

        faszaklikk(webDriver, logger, Object_repo_Philips.selector_LP_search_for_path_button, wait, "selector_LP_search_for_path_button");
        Thread.sleep(1000);
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_trainer_LP_select_path_checkbox, wait, "selector_trainer_LP_select_path_checkbox");

        faszaklikk(webDriver, logger, Object_repo_Philips.selector_trainer_LP_add_selected_path, wait, "selector_trainer_LP_add_selected_path");

        faszaklikk(webDriver, logger, Object_repo_Philips.selector_LP_save_button, wait, "selector_trainer_LP_save_LP_button");
        Thread.sleep(1000);
    }

    public static void navigatetocontacts(Logger logger, WebDriver webDriver, WebDriverWait wait) throws InterruptedException {
        faszaklikk(webDriver, logger,Object_repo_Philips.selector_contact, wait, "selector_contact");
    }

    public static void navigatetohelp(Logger logger, WebDriver webDriver, WebDriverWait wait) throws InterruptedException {
        faszaklikk(webDriver, logger,Object_repo_Philips.selector_help, wait, "selector_contact");
    }

    static void opentraining(WebDriver webDriver, Logger logger, WebDriverWait wait) throws InterruptedException, MalformedURLException {
        //Boolean iscardpresent = false;
        Thread.sleep(1000);
        if (faszaklikk(webDriver, logger, Object_repo_Philips.selector_student_dashboard_training_card_start, wait, "selector_student_dashboard_training_card_start")) {
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
            faszaklikk(webDriver, logger, Object_repo_Philips.selector_student_training_lib_, wait, "selector_student_traininglib");
            String tempurl = webDriver.getCurrentUrl() + "browse/page/1";
            //gotourl(logger, webDriver, tempurl);
            logger.info("Opened student training lib OK");
            Thread.sleep(1100);
            webDriver.navigate().refresh();
            Thread.sleep(1100);
            faszaklikk(webDriver, logger, Object_repo_Philips.selector_student_traininglib_completed, wait, "selector_student_traininglib_completed");
            logger.info("Opened student completed trainings tab OK");
            Thread.sleep(1100);
            faszaklikk(webDriver, logger, Object_repo_Philips.selector_student_traininglib_completed_retryexam, wait, "selector_student_traininglib_completed_retryexam");
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

    static boolean exam(WebDriver webDriver, Logger logger, WebDriverWait wait) throws InterruptedException, TimeoutException {
        try {
            while ((webDriver.findElement(By.xpath(Object_repo_Philips.selector_player_exam_counter))).isDisplayed()) {
                logger.info((webDriver.findElement(By.xpath(Object_repo_Philips.selector_player_exam_type))).getText());
                switch (webDriver.findElement(By.xpath(Object_repo_Philips.selector_player_exam_type)).getText()) {
                    case "Match":

                    case "Select":

                    case "Fill":
                        faszaklikk(webDriver, logger, Object_repo_Philips.selector_player_exam_check_answer_button, wait, "selector_player_exam_check_answer_button");
                        faszaklikk(webDriver, logger, Object_repo_Philips.selector_player_exam_next_question, wait, "selector_player_exam_next_question");
                        break;
                    case "Is it true":
                        faszaklikk(webDriver, logger, Object_repo_Philips.selector_player_exam_false, wait, "selector_player_exam_false");
                        logger.info("True in exam pressed!");
                        Thread.sleep(500);
                        faszaklikk(webDriver, logger, Object_repo_Philips.selector_player_exam_next_question, wait, "selector_player_exam_next_question");
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

    public static boolean player (WebDriver webDriver, Logger logger, WebDriverWait wait) throws InterruptedException {
        faszaklikk(webDriver, logger,Object_repo_Philips.selector_player_open_contents, wait, "selector_player_open_contents");
        logger.info("Opened Player window contents tab OK");
        //select first training from contents
        faszaklikk(webDriver, logger,Object_repo_Philips.selector_player_contents_first_item, wait, "selector_player_contents_first_item");
        logger.info("Clicked first training from contents OK");
        Thread.sleep(1100);
        Boolean temp = true;
        while (temp) {
            try {
                //First training
                Thread.sleep(2000);
                if (faszaklikk(webDriver, logger, Object_repo_Philips.selector_Player_training_explore_button, wait, "selector_Player_training_explore_button")) {
                    temp = true;
                    logger.info("Clicked training's Explore button in Player OK");
                    Thread.sleep(2000);
                    Actions actions = new Actions(webDriver);
                    actions.sendKeys(Keys.END).perform();
                    logger.info("Scrolled down to the bottom of training in Player window OK");
                    Thread.sleep(2000);
                    faszaklikk(webDriver, logger, Object_repo_Philips.selector_player_next_training_button, wait, "selector_player_next_training_button");
                    logger.info("Clicked on Next training in PLayer window");
                    Thread.sleep(1100);
                }
                else temp = false;
                logger.info("Test gone through modules, reached exam.");

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
    static void opentraining_EMEA(WebDriver webDriver, Logger logger, WebDriverWait wait) throws InterruptedException, MalformedURLException {
        gotourl(logger, webDriver, "https://test.emeacampus-whirlpoolcorp.com/browse/page/1");
        faszaklikk(webDriver, logger, Object_repo_Philips.selector_EMEA_first_training, wait, "selector_EMEA_first_training");
        //switch selenium handle to player tab
        Set<String> handles = webDriver.getWindowHandles();
        String currentWindowHandle = webDriver.getWindowHandle();
        for (String handle : handles) {
            if (!currentWindowHandle.equals(handle)) {
                webDriver.switchTo().window(handle);
            }
        }

    }
}
