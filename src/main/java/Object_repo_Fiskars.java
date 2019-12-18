

public class Object_repo_Fiskars {

    //input user email
    static String selector_user_email = "//*[@id=\"root\"]/div/div/div[1]/div[2]/div[1]/form/div[1]/div/input";

    //input user password
    static String selector_user_password = "//*[@id=\"root\"]/div/div/div[1]/div[2]/div[1]/form/div[2]/div/input";
    //login button
    static String selector_login_button = "//*[@id=\"root\"]/div/div/div[1]/div[2]/div[1]/form/button";

    //admin menu system

    //admin dashboard
    static String selector_admin_dashboard = "//*[@id=\"root\"]/div/div/div[2]/div[1]/ul[2]/li[1]/a";
    static String Selector_admin_dashboard_opencomm_modal = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[1]/div[1]/div/div/div[2]/div/span";
    static String Selector_admin_dashboard_closecomm_modal = "/html/body/div[2]/div/div/div/div[1]/button/img";
    //admin_user_dropdown
    static String selector_admin_user_dropdown = "//button[@class='Button__button___3oG9T Button__dropdown___3EdAW Button__menuDropdown___2A-kk']";
    //admin profile
    static String selector_admin_profile = "//*[@id=\"root\"]/div/div/div[2]/div[1]/ul[1]/div/div/div/a[1]";
    //admin profile edit
    static String selector_admin_profile_edit_button = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[2]/div/div[5]/div/a";
    //admin profile preferred device
    static String selector_preferred_device_dropdown = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[2]/div/form/div[14]/div[2]/div/div/button";
    //Preferred device tablet
    static String selector_preferred_device_totablet = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[2]/div/form/div[14]/div[2]/div/div/div/div[2]";
    //Preferred device smartphone
    static String selector_preferred_device_tosmatphone = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[2]/div/form/div[14]/div[2]/div/div/div/div[1]";
    //profile edited Save button
    static String selector_profile_edit_Save = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[2]/div/form/div[20]/div/button[1]";
    //Preferred deice text
    static String selector_preferred_device = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[2]/div/div[3]/div[2]/div[2]";
    //admin logout
    static String selector_admin_logout = "//*[@id=\"root\"]/div/div/div[2]/div[1]/ul[1]/div/div/div/a[2]";
    //admin goals
    static String selector_admin_goals = "//*[@id=\"root\"]/div/div/div[2]/div[1]/ul[2]/li[2]/a";
    //admin learning path
    static String selector_admin_learning_path = "//*[@id=\"root\"]/div/div/div[2]/div[1]/ul[2]/li[3]/a";
    //admin training library student view
    static String selector_admin_training_lib_student = "//*[@id=\"root\"]/div/div/div[2]/div[1]/ul[2]/li[4]/a";
    //admin training library trainer view
    static String selector_admin_training_lib_trainer = "//*[@id=\"root\"]/div/div/div[2]/div[1]/ul[2]/li[5]/a";
    //admin modules
    static String selector_admin_modules = "//*[@id=\"root\"]/div/div/div[2]/div[1]/ul[2]/li[6]/a";
    // admin modules Action dropdown
    static String selector_admin_modules_first_action_dropdown = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[4]/div[2]/div[1]/div/div[2]/div/div/button";
    //admin modules action dropdown Translate button
    static String selector_admin_modules_first_dropdown_translate = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[4]/div[2]/div[1]/div/div[2]/div/div/div/button[2]";
    //admin module translate module details
    static String selector_admin_module_translate_module_details = "//*[@id=\"react-tabs-4\"]";
    //admin module translate first input field
    static String selector_admin_translate_moduledetails_first_input = "//*[@id=\"react-tabs-5\"]/form/div[1]/div[1]/div[2]/div/div/textarea";
    //save translate
    static String selector_admin_translate_changed_save = "//*[@id=\"react-tabs-5\"]/form/div[2]/div[1]/button[1]";
    //admin communication
    static String selector_admin_communication = "//*[@id=\"root\"]/div/div/div[2]/div[1]/ul[2]/li[7]";
    //create communication
    static String selector_create_communication_button = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[4]/div[1]/div[2]/a";
    //communication add title and description, news type checkbox, publish now radiobtn, save btn
    static String selector_comm_add_title = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div/div/form/div[1]/div[2]/div/div/input";
    static String selector_comm_add_description = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div/div/form/div[2]/div[2]/div/textarea";
    static String selector_comm_check_news = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div/div/form/div[4]/div[2]/div[2]/label/div";
    static String selector_comm_search_group = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div/div/form/div[5]/div[2]/div/div[1]/div/div[1]/div/input";
    static String selector_comm_select_first_group = "//*[@id=\"react-autowhatever-1--item-0\"]/div";
    static String selector_comm_add_group_btn = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div/div/form/div[5]/div[2]/div/div[1]/div/div[1]/button";
    static String selector_comm_check_now = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div/div/form/div[6]/div[2]/div/div[1]/div/div[1]/label";
    static String selector_comm_save = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div/div/form/div[7]/div[2]/button[1]";
    static String selector_comm_search_input = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[3]/div/div/div[1]/form/input";
    static String selector_comm_search_input_searchbtn = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[3]/div/div/div[1]/form/button/img";
    static String selector_comm_search_result_sort_dropdown = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[3]/div/div/div[3]/div[2]/div/div/button";
    static String selector_comm_result_list_sort_descending_date = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[3]/div/div/div[3]/div[2]/div/div/div/div[4]";
    static String selector_comm_found_list_first_action_dropdown = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[4]/div[2]/div/div/div[2]/div/div/button";
    static String selector_comm_found_list_first_action_deletebtn = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[4]/div[2]/div[1]/div/div[2]/div/div/div/button";
    static String selector_comm_action_delete_confirm = "/html/body/div[2]/div/div/div/div[2]/div[2]/button[1]";
    static String selector_comm_action_delete_cancel= "/html/body/div[2]/div/div/div/div[2]/div[2]/button[2]";
    //admin users
    static String selector_admin_users = "//*[@id=\"root\"]/div/div/div[2]/div[1]/ul[2]/li[8]/a";
    // #root > div > div > div.Page__contentWrapper___2q8ya.row > div.Sidebar__sideBar___1xZie > ul:nth-child(3) > li:nth-child(8) > a
    static String selector_admin_user_groups = "//*[@id=\"react-tabs-2\"]";
    static String selector_create_user_group_btn = "//*[@id=\"react-tabs-3\"]/div/div[2]/div[2]/a";
    static String selector_usergroup_add_name = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div/form/div[1]/div[2]/div/div/input";
    static String selector_usergroup_add_description = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div/form/div[3]/div[2]/div/textarea";
    static String selector_usergroup_add_user_search = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div/form/div[4]/div[2]/div[2]/div/div/input";
    static String selector_usergroup_add_user_select_first = "//*[@id=\"react-autowhatever-1--item-0\"]/div";
    static String selector_usergroup_add_user = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div/form/div[4]/div[2]/div[2]/div/button";
    static String selector_usergroup_save = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div/form/div[5]/div/button[1]";
    //admin glossary
    static String selector_admin_glossary = "//*[@id=\"root\"]/div/div/div[2]/div[1]/ul[2]/li[9]/a";
    //admin contact
    static String selector_admin_contact = "//*[@id=\"root\"]/div/div/div[2]/div[1]/ul[2]/li[10]/a";
    //admin help
    static String selector_admin_help = "//*[@id=\"root\"]/div/div/div[2]/div[1]/ul[2]/li[11]/a";

    //manager menu system

    //manager user dropdown
    String selector_user_dropdown = "#root > div > div > div.Page__contentWrapper___2q8ya.row > div.Sidebar__sideBar___1xZie > ul:nth-child(2) > div > div > button";
    //manager dashboard
    String selector_manager_dashboard = "#root > div > div > div.Page__contentWrapper___2q8ya.row > div.Sidebar__sideBar___1xZie > ul:nth-child(3) > li:nth-child(1) > a";
    //manager profile
    String selector_manager_profile = "#root > div > div > div.Page__contentWrapper___2q8ya.row > div.Sidebar__sideBar___1xZie > ul:nth-child(2) > div > div > div > a:nth-child(1)";
    //manager logout
    String selector_manager_logout = "#root > div > div > div.Page__contentWrapper___2q8ya.row > div.Sidebar__sideBar___1xZie > ul:nth-child(2) > div > div > div > a:nth-child(2)";
    //manager goals
    String selector_manager_goals = "#root > div > div > div.Page__contentWrapper___2q8ya.row > div.Sidebar__sideBar___1xZie > ul:nth-child(3) > li:nth-child(2) > a";
    //manager learning path
    String selector_manager_learning_path = "#root > div > div > div.Page__contentWrapper___2q8ya.row > div.Sidebar__sideBar___1xZie > ul:nth-child(3) > li:nth-child(3) > a";
    //manager training library
    String selector_manager_training_library = "#root > div > div > div.Page__contentWrapper___2q8ya.row > div.Sidebar__sideBar___1xZie > ul:nth-child(3) > li:nth-child(4) > a";
    //manager modules
    String selector_manager_modules = "#root > div > div > div.Page__contentWrapper___2q8ya.row > div.Sidebar__sideBar___1xZie > ul:nth-child(3) > li:nth-child(5) > a";
    //manager communications
    String selector_manager_communications = "#root > div > div > div.Page__contentWrapper___2q8ya.row > div.Sidebar__sideBar___1xZie > ul:nth-child(3) > li:nth-child(6) > a";
    //manager users
    String selector_manager_users = "#root > div > div > div.Page__contentWrapper___2q8ya.row > div.Sidebar__sideBar___1xZie > ul:nth-child(3) > li:nth-child(7) > a";
    //manager glossary
    String selector_manager_glossary = "#root > div > div > div.Page__contentWrapper___2q8ya.row > div.Sidebar__sideBar___1xZie > ul:nth-child(3) > li:nth-child(8) > a";
    //manager contact
    String selector_manager_contact = "#root > div > div > div.Page__contentWrapper___2q8ya.row > div.Sidebar__sideBar___1xZie > ul:nth-child(3) > li:nth-child(9) > a";
    //manager help
    String selector_manager_help = "#root > div > div > div.Page__contentWrapper___2q8ya.row > div.Sidebar__sideBar___1xZie > ul:nth-child(3) > li:nth-child(10) > a";

    //trainer menu system

    static String selector_trainer_dashboard = "//*[@id=\"root\"]/div/div/div[2]/div[1]/ul[2]/li[1]/a";
    static String selector_trainer_dashboard_tracking_tab = "//*[@id=\"react-tabs-2\"]";

    static String Selector_trainer_dashboard_opencomm_modal = "//*[@id=\"react-tabs-7\"]/div/div[1]/div/div/div[1]/div/span";
    static String Selector_trainer_dashboard_closecomm_modal = "/html/body/div[2]/div/div/div/div[1]/button/img";
    //trainer_user_dropdown
    static String selector_trainer_user_dropdown = "//*[@id=\"root\"]/div/div/div[2]/div[1]/ul[1]/div/div/button";
    //trainer profile
    static String selector_trainer_profile = "//*[@id=\"root\"]/div/div/div[2]/div[1]/ul[1]/div/div/div/a[1]";
    //trainer profile edit
    static String selector_trainer_profile_edit_button = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[2]/div/div[5]/div/a";
    //trainer profile preferred device
    static String selector_trainer_preferred_device_dropdown = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[2]/div/form/div[14]/div[2]/div/div/button";
    //trainer Preferred device tablet
    static String selector_trainer_preferred_device_totablet = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[2]/div/form/div[14]/div[2]/div/div/div/div[2]";
    //trainer Preferred device smartphone
    static String selector_trainer_preferred_device_tosmatphone = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[2]/div/form/div[14]/div[2]/div/div/div/div[1]";
    //trainer profile edited Save button
    static String selector_trainer_profile_edit_Save = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[2]/div/form/div[20]/div/button[1]";
    //trainer Preferred deice text
    static String selector_trainer_preferred_device = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[2]/div/div[3]/div[2]/div[2]";
    //trainer logout
    static String selector_trainer_logout = "//*[@id=\"root\"]/div/div/div[2]/div[1]/ul[1]/div/div/div/a[2]";
    //trainer goals
    static String selector_trainer_goals = "//*[@id=\"root\"]/div/div/div[2]/div[1]/ul[2]/li[2]/a";
    //trainer learning path
    static String selector_trainer_learning_path = "//*[@id=\"root\"]/div/div/div[2]/div[1]/ul[2]/li[2]/a";
    //trainer create learning path button
    static String selector_trainer_create_learning_path_button = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[2]/div/a";
    //add LP name
    static String selector_trainer_add_LP_name = "//*[@id=\"react-tabs-1\"]/form/div[1]/div[2]/div/div/input";
    //add LP description
    static String selector_trainer_add_LP_description = "//*[@id=\"react-tabs-1\"]/form/div[2]/div[2]/div/textarea";
    //create LP participants tab
    static String selector_trainer_cr_LP_participants_tab = "//*[@id=\"react-tabs-2\"]";
    //create LP search user group
    static String selector_trainer_LP_search_group = "//*[@id=\"react-tabs-3\"]/form/div[1]/div/div/div/input";
    //create LP select first user group
    static String selector_trainer_LP_select_group = "//*[@id=\"react-autowhatever-1--item-0\"]/div";
    //create LP add first group
    static String selector_trainer_LP_add_first_group = "//*[@id=\"react-tabs-3\"]/form/div[1]/div/div/button";
    //create LP Path tab
    static String selector_trainer_LP_path_tab = "//*[@id=\"react-tabs-4\"]";
    //create LP open path selector
    static String selector_trainer_LP_open_path_selector = "//*[@id=\"react-tabs-5\"]/form/div/div/div";
    //create LP search for path
    static String selector_trainer_LP_search_for_path = "/html/body/div[2]/div/div/div/div[2]/form/input";
    //create LP select path
    static String selector_trainer_LP_select_path_checkbox = "/html/body/div[2]/div/div/div/div[3]/ul[1]/li[1]/label/div";
    //create LP add selected path
    static String selector_trainer_LP_add_selected_path = "/html/body/div[2]/div/div/div/div[4]/button";
    //create LP save LP button
    static String selector_trainer_LP_save_LP_button = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[2]/div/div/button[1]";

    //trainer training library trainer view
    static String selector_trainer_training_lib_trainer = "//*[@id=\"root\"]/div/div/div[2]/div[1]/ul[2]/li[3]/a";
    //create training button
    static String selector_trainer_create_training_btn = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[4]/div[1]/div[2]/a";
    //add name for training
    static String selector_trainer_training_add_name = "//*[@id=\"react-tabs-1\"]/form/div[1]/div[2]/div/div/input";
    //add description for training
    static String selector_trainer_training_add_description = "//*[@id=\"react-tabs-1\"]/form/div[2]/div[2]/div/textarea";
    //create training modules tab
    static String selector_trainer_create_training_modules_tab = "//*[@id=\"react-tabs-2\"]";
    //create training add module btn
    static String selector_trainer_create_training_add_module_btn = "//*[@id=\"react-tabs-3\"]/form/div/div/div";
    //create training add module select module checkbox
    static String selector_trainer_create_tr_add_mod_checkbox = "/html/body/div[2]/div/div/div/div[3]/ul[1]/li[1]/label/div";
    //create training add selected module button
    static String selector_trainer_create_tr_add_selected_module_btn = "/html/body/div[2]/div/div/div/div[4]/button";
    // create training Exam tab
    static String selector_trainer_create_tr_exam_tab = "//*[@id=\"react-tabs-4\"]";
    //create training Save button
    static String selector_trainer_save_training_btn = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[2]/div/div/button[1]";
    //trainer modules
    static String selector_trainer_modules = "//*[@id=\"root\"]/div/div/div[2]/div[1]/ul[2]/li[4]/a";
    //trainer communication
    static String selector_trainer_communication = "//*[@id=\"root\"]/div/div/div[2]/div[1]/ul[2]/li[5]/a";
    //trainer create communication
    static String selector_trainer_create_communication_button = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[4]/div[1]/div[2]/a";
    //communication add title and description, news type checkbox, publish now radiobtn, save btn
    static String selector_trainer_comm_add_title = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div/div/form/div[1]/div[2]/div/div/input";
    static String selector_trainer_comm_add_description = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div/div/form/div[2]/div[2]/div/textarea";
    static String selector_trainer_comm_check_news = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div/div/form/div[4]/div[2]/div[2]/label/div";
    static String selector_trainer_comm_search_group = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div/div/form/div[5]/div[2]/div/div[1]/div/div[1]/div/input";
    static String selector_trainer_comm_select_first_group = "//*[@id=\"react-autowhatever-1--item-0\"]/div";
    static String selector_trainer_comm_add_group_btn = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div/div/form/div[5]/div[2]/div/div[1]/div/div[1]/button";
    static String selector_trainer_comm_check_now = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div/div/form/div[6]/div[2]/div/div[1]/div/div[1]/label";
    static String selector_trainer_comm_save = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div/div/form/div[7]/div[2]/button[1]";
    static String selector_trainer_comm_search_input = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[3]/div/div/div[1]/form/input";
    static String selector_trainer_comm_search_input_searchbtn = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[3]/div/div/div[1]/form/button/img";
    static String selector_trainer_comm_found_list_first_action_dropdown = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[4]/div[2]/div[1]/div/div[2]/div/div/button";
    static String selector_trainer_comm_found_list_first_action_deletebtn = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[4]/div[2]/div[1]/div/div[2]/div/div/div/button";
    static String selector_trainer_comm_action_delete_confirm = "/html/body/div[2]/div/div/div/div[2]/div[2]/button[1]";
    static String selector_trainer_comm_action_delete_cancel= "/html/body/div[2]/div/div/div/div[2]/div[2]/button[2]";
    //trainer users
    static String selector_trainer_users = "//*[@id=\"root\"]/div/div/div[2]/div[1]/ul[2]/li[6]/a";
    static String selector_trainer_user_groups = "//*[@id=\"react-tabs-2\"]";
    static String selector_trainer_user_create_usergroup_btn = "//*[@id=\"react-tabs-3\"]/div/div[2]/div[2]/a";
    static String selector_trainer_usergroup_add_name = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div/form/div[1]/div[2]/div/div/input";
    static String selector_trainer_usergroup_add_description = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div/form/div[3]/div[2]/div/textarea";
    static String selector_trainer_usergroup_add_user_search = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div/form/div[4]/div[2]/div[2]/div/div/input";
    static String selector_trainer_usergroup_add_user_select_first = "//*[@id=\"react-autowhatever-1--item-0\"]/div";
    static String selector_trainer_usergroup_add_user = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div/form/div[4]/div[2]/div[2]/div/button";
    static String selector_trainer_usergroup_save = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div/form/div[5]/div/button[1]";
    //trainer glossary
    static String selector_trainer_glossary = "//*[@id=\"root\"]/div/div/div[2]/div[1]/ul[2]/li[7]/a";
    //admin contact
    static String selector_trainer_contact = "//*[@id=\"root\"]/div/div/div[2]/div[1]/ul[2]/li[8]/a";
    //admin help
    static String selector_trainer_help = "//*[@id=\"root\"]/div/div/div[2]/div[1]/ul[2]/li[9]/a";

    //student menu system

    //student user dropdown
    static String selector_student_user_dropdown = "//*[@id=\"root\"]/div/div/div[2]/div[1]/ul[1]/div/div/button";
    //student profile
    static String selector_student_user_profile = "//*[@id=\"root\"]/div/div/div[2]/div[1]/ul[1]/div/div/div/a[1]";
    //student logout
    static String selector_student_logout = "//*[@id=\"root\"]/div/div/div[2]/div[1]/ul[1]/div/div/div/a[2]";
    //student edit profile button
    static String selector_student_edit_profile_btn = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[2]/div/div[5]/div/a";
    //student profile preferred device
    static String selector_student_profile_preferred_device_dropdown = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[2]/div/form/div[14]/div[2]/div/div/button";
    //student profile pref device smartphone to tablet
    static String selector_student_pref_dev_smarttotablet = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[2]/div/form/div[14]/div[2]/div/div/div/div[2]";
    //student profile pref device tablet to smart
    static String selector_student_pref_dev_tablettosmart = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[2]/div/form/div[14]/div[2]/div/div/div/div[1]";
    //student edit profile save button
    static String selector_student_edit_profile_save_btn = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[2]/div/form/div[20]/div/button[1]";
    //student dashboard
    static String selector_student_dashboard = "//*[@id=\"root\"]/div/div/div[2]/div[1]/ul[2]/li[1]/a";
    //student dashboard training card "continue/start course"
    static String selector_student_dashboard_training_card_start = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[1]/div[2]/div[2]/a";
    //student training library
    static String selector_student_training_lib_ = "//*[@id=\"root\"]/div/div/div[2]/div[1]/ul[2]/li[2]/a";
    static String selector_student_traininglib_completed = "//*[@id=\"react-tabs-4\"]";
    static String selector_student_traininglib_completed_retryexam = "//*[@id=\"react-tabs-5\"]/div/div[1]/div/div[2]/div/a/span";

    //student glossary
    static String selector_student_glossary = "//*[@id=\"root\"]/div/div/div[2]/div[1]/ul[2]/li[3]/a";
    //student contact
    static String selector_student_contact = "//*[@id=\"root\"]/div/div/div[2]/div[1]/ul[2]/li[4]/a";

    //Player stuff
    static String selector_player_open_contents = "//*[@id=\"app\"]/div/nav/div/div[1]";
    static String selector_player_contents_first_item = "//*[@id=\"navigationOverlay\"]/div/div[1]/span/span";
    static String selector_Player_rewatch_training_button = "//*[@id=\"app\"]/div/div/div/div[2]/div/div[3]/div[2]/div[1]/button";
    static String selector_Player_select_true = "//*[@id=\"app\"]/div/div/div/div[2]/div/div/div/button[1]";
    static String selector_Player_next_question = "//*[@id=\"app\"]/div/div/div/div[2]/div/div/div[2]/button";
    //static String selector_Player_training_explore_button = "//*[@id=\"scene_0\"]/div[2]/div/button";
    static String selector_Player_training_explore_button = "//*[text()='Explore']";
    //static String selector_player_next_training_button = "//*[@id=\"app\"]/div/main/div[9]/div[1]/div/button";
    static String selector_player_next_training_button = "//*[text()='Next']";
    static String selector_player_exam_true = "//*[@id=\"app\"]/div/div/div/div[2]/div/div/div/button[1]";
    static String selector_player_exam_false = "//*[@id=\"app\"]/div/div/div/div[2]/div/div/div/button[2]";
    static String selector_player_exam_next_question = "//*[@id=\"app\"]/div/div/div/div[2]/div/div/div[2]/button";

}
