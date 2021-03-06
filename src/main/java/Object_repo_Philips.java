public class Object_repo_Philips {

    //input user email
    static String selector_user_email = "//*[@id=\"root\"]/div/div/div[1]/div[2]/div[1]/form/div[1]/div/input";

    //input user password
    static String selector_user_password = "//*[@id=\"root\"]/div/div/div[1]/div[2]/div[1]/form/div[2]/div/input";
    //login button
    static String selector_login_button = "//*[text()='Login']";


    static String selector_admin_user_dropdown = "//*[@id=\"root\"]/div/div/div[2]/div[1]/div/div[2]/ul/div/div/button";



    //admin dashboard
    static String selector_dashboard = "//*[text()='Dashboard']";
    static String Selector_admin_dashboard_opencomm_modal = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[1]/div[1]/div/div/div[2]/div/span";
    static String Selector_admin_dashboard_closecomm_modal = "/html/body/div[2]/div/div/div/div[1]/button/img";
    static String Selector_admin_dashboard_comm_list_first_item = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[1]/div[1]/div/div/div[1]/div/span";
    static String Selector_admin_dashboard_comm_list_first_item_title = "/html/body/div[2]/div/div/div/div[1]/h1";
    //admin_user_dropdown
    static String selector_admin_user_dropdown_Bissell = "//*[@id=\"root\"]/div/div/div[2]/div[1]/div/div[2]/ul/div/div/button";
    //admin profile
    static String selector_admin_profile_Bissell = "//*[@id=\"root\"]/div/div/div[2]/div[1]/div/div[2]/ul/div/div/div/a[1]";
    //admin profile edit
    static String selector_admin_profile_Philips = "//*[@id=\"root\"]/div/div/div[2]/div[1]/ul[1]/li[2]";
    //admin profile edit
    static String selector_profile_edit_button = "//*[text()='Edit']";
    //admin profile preferred device
    static String selector_preferred_device_dropdown = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[2]/div/form/div[14]/div[2]/div/div/button";
    static String selector_EMEA_preferred_device_dropdown = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[2]/div/form/div[7]/div[2]/div/div/button";
    //Preferred device tablet
    static String selector_preferred_device_totablet = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[2]/div/form/div[14]/div[2]/div/div/div/div[2]";
    static  String selector_EMEA_pref_dev_totablet = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[2]/div/form/div[7]/div[2]/div/div/div/div[2]";
    //Preferred device smartphone
    static String selector_preferred_device_tosmatphone = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[2]/div/form/div[14]/div[2]/div/div/div/div[1]";
    //profile edited Save button
    static String selector_profile_edit_Save = "//*[text()='Save']";
    //Preferred deice text
    static String selector_preferred_device = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[2]/div/div[3]/div[2]/div[2]";
    //admin logout
    static String selector_admin_logout_Philips = "//*[@id=\"root\"]/div/div/div[2]/div[1]/ul[1]/li[3]";
    static String selector_admin_logout_Bissell = "//*[@id=\"root\"]/div/div/div[2]/div[1]/ul[1]/div/div/div/a[2]";
    //admin goals
    static String selector_goals = "//*[text()='Goals']";
    //admin learning path
    static String selector_learning_paths = "//*[text()='Learning paths']";

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
    static String selector_admin_communication_Philips = "//*[@id=\"root\"]/div/div/div[2]/div[1]/ul[2]/li[6]";
    static String selector_admin_communication_Bissell = "//*[text()='Communication']";

    //create communication
    static String selector_create_communication_button = "//*[text()='Create']";
    //communication add title and description, news type checkbox, publish now radiobtn, save btn
    static String selector_comm_add_title = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div/div/form/div[1]/div[2]/div/div[1]/input";
    static String selector_comm_add_description = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div/div/form/div[2]/div[2]/div/textarea";
    static String selector_comm_check_news = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div/div/form/div[4]/div[2]/div[2]/label/div";
    static String selector_comm_search_group = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div/div/form/div[5]/div[2]/div/div[1]/div/div[1]/div/input";
    static String selector_comm_select_first_group = "//*[@id=\"react-autowhatever-1--item-0\"]/div";
    static String selector_comm_add_group_btn = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div/div/form/div[5]/div[2]/div/div[1]/div/div[1]/button";
    static String selector_comm_check_now = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div/div/form/div[6]/div[2]/div/div[1]/div/div[1]/label";
    static String selector_communication_save = "//*[text()='Save']";
    static String selector_comm_search_input = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[3]/div/div/div[1]/form/input";
    static String selector_comm_search_input_searchbtn = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[3]/div/div/div[1]/form/button/img";
    static String selector_comm_search_result_sort_dropdown = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[3]/div/div/div[3]/div[2]/div/div/button";
    static String selector_comm_result_list_sort_descending_date = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[3]/div/div/div[3]/div[2]/div/div/div/div[4]";
    static String selector_comm_found_list_first_action_dropdown = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[4]/div[2]/div/div/div[2]/div/div/button";
    static String selector_comm_found_list_first_action_deletebtn = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[4]/div[2]/div[1]/div/div[2]/div/div/div/button";
    static String selector_comm_action_delete_confirm = "/html/body/div[2]/div/div/div/div[2]/div[2]/button[1]";
    static String selector_comm_action_delete_cancel= "/html/body/div[2]/div/div/div/div[2]/div[2]/button[2]";
    //admin users
    static String selector_admin_users_Philips = "//*[@id=\"root\"]/div/div/div[2]/div[1]/ul[2]/li[7]";
    static String selector_admin_users_Bissell = "//*[@id=\"root\"]/div/div/div[2]/div[1]/div/div[3]/ul/li[8]/a";
    // #root > div > div > div.Page__contentWrapper___2q8ya.row > div.Sidebar__sideBar___1xZie > ul:nth-child(3) > li:nth-child(8) > a

    static String selector_admin_user_groups_Philips = "//*[@id=\"react-tabs-2\"]";
    static String selector_admin_user_groups = "//*[text()='User groups']";
    static String selector_create_user_group_btn = "//*[@id=\"react-tabs-3\"]/div/div[2]/div[2]/a";
    static String selector_usergroup_add_name = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div/form/div[1]/div[2]/div/div/input";
    static String selector_usergroup_add_description = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div/form/div[3]/div[2]/div/textarea";
    static String selector_usergroup_add_user_search = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div/form/div[4]/div[2]/div[2]/div/div/input";
    static String selector_usergroup_add_user_select_first = "//*[@id=\"react-autowhatever-1--item-0\"]";
    static String selector_usergroup_add_user = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div/form/div[4]/div[2]/div[2]/div/button";
    static String selector_usergroup_save = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div/form/div[5]/div/button[1]";
    //admin reports
    static String selector_admin_reports = "//*[@id=\"root\"]/div/div/div[2]/div[1]/ul[2]/li[8]";
    //admin glossary
    static String selector_admin_glossary_Philips = "//*[@id=\"root\"]/div/div/div[2]/div[1]/ul[2]/li[9]";
    static String selector_admin_glossary_Bissell = "//*[@id=\"root\"]/div/div/div[2]/div[1]/ul[2]/li[9]/a";

    static String selector_contact = "//*[text()='Contact']";

    static String selector_help= "//*[text()='Help']";
    //trainer menu system
    static String selector_trainer_dashboard_Philips = "//*[@id=\"root\"]/div/div/div[2]/div[1]/ul[1]/li[1]";
    static String selector_trainer_dashboard_Bissell = "//*[@id=\"root\"]/div/div/div[2]/div[1]/ul[2]/li[1]/a";
    static String selector_trainer_dashboard_tracking_tab = "//*[@id=\"react-tabs-2\"]";



    static String Selector_trainer_dashboard_opencomm_modal_Philips = "//*[@id=\"react-tabs-1\"]/div/div[2]/div/div/div[1]/div/span";
    static String Selector_trainer_dashboard_closecomm_modal_Philips = "/html/body/div[2]/div/div/div/div[1]/button/img";
    static String Selector_trainer_dashboard_opencomm_modal_Bissell = "//*[@id=\"react-tabs-7\"]/div/div[1]/div/div/div[1]/div/span";
    static String Selector_trainer_dashboard_closecomm_modal_Bissell = "/html/body/div[2]/div/div/div/div[1]/button/img";

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
    static String selector_trainer_logout_Philips = "//*[@id=\"root\"]/div/div/div[2]/div[1]/ul[1]/li[3]";
    static String selector_trainer_logout_Bissell = "//*[@id=\"root\"]/div/div/div[2]/div[1]/ul[1]/div/div/div/a[2]";
    static String selector_create_LP_btn = "//*[text()='Create']";
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
    static String selector_LP_search_for_path_button = "/html/body/div[2]/div/div/div/div[2]/form/button/img";
    //create LP select path
    static String selector_trainer_LP_select_path_checkbox = "/html/body/div[2]/div/div/div/div[3]/ul/li[1]/label/div";
    //create LP add selected path
    static String selector_trainer_LP_add_selected_path = "/html/body/div[2]/div/div/div/div[4]/button";
    //create LP save LP button
    static String selector_LP_save_button = "//*[text()='Save']";

    static  String selector_training_lib = "//*[text()='Training library']";
    //create training button
    static String selector_create_training_button = "//*[text()='Create']";
    //add name for training
    static String selector_trainer_training_add_name = "//*[@id=\"react-tabs-1\"]/form/div[1]/div[2]/div/div[1]/input";
    //add description for training
    static String selector_trainer_training_add_description = "//*[@id=\"react-tabs-1\"]/form/div[2]/div[2]/div/textarea";
    //create training modules tab
    static String selector_create_training_modules_tab = "//*[@id=\"react-tabs-2\"]";
    //create training add module btn
    static String selector_trainer_create_training_add_module_btn = "//*[@id=\"react-tabs-3\"]/form/div/div/div";
    //create training add module select module checkbox
    static String selector_trainer_create_tr_add_mod_checkbox = "/html/body/div[2]/div/div/div/div[3]/ul[1]/li[1]/label/div";
    //create training add selected module button
    static String selector_trainer_create_tr_add_selected_module_btn = "/html/body/div[2]/div/div/div/div[4]/button";
    // create training Exam tab
    static String selector_trainer_create_tr_exam_tab = "//*[text()='Exam']";

    static String selector_save_training_button = "//*[text()='Save']";
    static String selector_modules = "//*[text()='Modules']";
    //trainer communication

    static String selector_communication = "//*[text()='Communication']";
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
    static String selector_trainer_comm_search_input = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[3]/div/div/div[1]/form/input";
    static String selector_trainer_comm_search_input_searchbtn = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[3]/div/div/div[1]/form/button/img";
    static String selector_trainer_comm_found_list_first_action_dropdown = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[4]/div[2]/div[1]/div/div[2]/div/div/button";
    static String selector_trainer_comm_found_list_first_action_deletebtn = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[4]/div[2]/div[1]/div/div[2]/div/div/div/button";
    static String selector_trainer_comm_action_delete_confirm = "/html/body/div[2]/div/div/div/div[2]/div[2]/button[1]";
    static String selector_trainer_comm_action_delete_cancel= "/html/body/div[2]/div/div/div/div[2]/div[2]/button[2]";
    //trainer users
    static String selector_trainer_users_Philips = "//*[@id=\"root\"]/div/div/div[2]/div[1]/ul[2]/li[5]";
    static String selector_trainer_users_Bissell = "//*[@id=\"root\"]/div/div/div[2]/div[1]/div/div[3]/ul/li[6]/a";
    static String selector_users = "//*[text()='Users']";
    static String selector_trainer_user_groups_Philips = "//*[@id=\"react-tabs-2\"]";
    static String selector_user_groups = "//*[text()='User groups']";
    static String selector_trainer_user_create_usergroup_btn = "//*[@id=\"react-tabs-3\"]/div/div[2]/div[2]/a";
    static String selector_user_create_usergroup_button = "//*[text()='Create user group']";
    static String selector_trainer_usergroup_add_name = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div/form/div[1]/div[2]/div/div/input";
    static String selector_trainer_usergroup_add_description = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div/form/div[3]/div[2]/div/textarea";
    static String selector_trainer_usergroup_add_user_search = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div/form/div[4]/div[2]/div[2]/div/div/input";
    static String selector_trainer_usergroup_add_user_select_first = "//*[@id=\"react-autowhatever-1--item-0\"]/div";
    static String selector_trainer_usergroup_add_user = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div/form/div[4]/div[2]/div[2]/div/button";
    static String selector_trainer_usergroup_save = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div/form/div[5]/div/button[1]";
    //trainer glossary
    static String selector_trainer_glossary_Philips = "//*[@id=\"root\"]/div/div/div[2]/div[1]/ul[2]/li[7]/a";
    static String selector_trainer_glossary_Bissell = "//*[@id=\"root\"]/div/div/div[2]/div[1]/div/div[3]/ul/li[9]/a";

    //admin contact
    static String selector_trainer_contact = "//*[@id=\"root\"]/div/div/div[2]/div[1]/ul[2]/li[8]/a";
    //admin help
    static String selector_trainer_help = "//*[@id=\"root\"]/div/div/div[2]/div[1]/ul[2]/li[9]/a";

    //student menu system
    static  String selector_student_dashboard_card_Philips = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]";
    static String selector_student_dashboard_training_card_start_Bissell = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[1]/div[2]/div[2]/a";

    //student user dropdown
    static String selector_student_user_dropdown = "//*[@id=\"root\"]/div/div/div[2]/div[1]/div/div[2]/ul/div/div/button";
    static String selector_student_user_dashboard_Philips = "//*[@id=\"root\"]/div/div/div[2]/div[1]/ul[1]/li[1]";
    static String selector_student_dashboard_Bissell = "//*[@id=\"root\"]/div/div/div[2]/div[1]/div/div[3]/ul/li[1]/a";
    //student profile
    static String selector_student_user_profile_Philips = "//*[@id=\"root\"]/div/div/div[2]/div[1]/ul[1]/li[2]";
    static String selector_student_user_profile_Bissell = "//*[@id=\"root\"]/div/div/div[2]/div[1]/div/div[2]/ul/div/div/div/a[1]";
    //student logout
    static String selector_student_logout_Philips = "//*[@id=\"root\"]/div/div/div[2]/div[1]/ul[1]/li[3]";
    static String selector_student_logout_Bissell = "//*[@id=\"root\"]/div/div/div[2]/div[1]/ul[1]/div/div/div/a[2]";
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
    //student dashboard training card "continue/start course"
    //static String selector_student_dashboard_training_card_start = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[1]/div[2]/div[2]/a";
    static String selector_student_dashboard_training_card_start = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[1]/div[2]/div[2]/a";
    static  String selector_student_dashboard_card = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]";
    //student training library
    static String selector_student_training_lib_ = "//*[text()='Training library']";
    //*[@id="root"]/div/div/div[2]/div[1]/ul[2]/li[2]/a
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
    static String selector_player_exam_counter = "//*[@id=\"app\"]/div/div/div/div[1]/h4/span";
    static String selector_player_exam_type = "//*[@id=\"app\"]/div/div/div/div[1]/h3/span/strong";
    static String selector_player_exam_check_answer_button = "//*[@id=\"app\"]/div/div/div/div[2]/div/div/div[2]/button";
    static String selector_EMEA_first_training = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[5]/div[2]/div[1]/div[2]/div/div/div[1]/h3";

    //WLearn selectors
    static String WLearn_selector_login_email = "//*[@id=\"root\"]/div/div/div/div/div[1]/div/form/div/div[1]/div[1]/div/input";
    static String WLearn_selector_login_password = "//*[@id=\"root\"]/div/div/div/div/div[1]/div/form/div/div[2]/div[1]/div/input";
    static String WLearn_selector_login_button = "//*[@id=\"root\"]/div/div/div/div/div[1]/div/form/div/div[4]/button";
    static String WLearn_selector_Courses = "//*[text()='Courses']";
    static String WLearn_selector_Courses_Search_input = "//*[@id=\"root\"]/div/div/div/div[2]/div[1]/div[1]/div[1]/div/div/div/input";
    static String WLearn_selector_Create_Course = "//*[text()='Create new course']";
    static String WLearn_selector_CC_Gen_Lang_dropdown_input = "//*[@id=\"root\"]/div/div/div/div[2]/form/div[1]/div/div[2]/div/div[1]/div/div[1]";
    static String WLearn_selector_CC_Gen_Lang_selectlang = "//*[text()='English']";
    static String WLearn_selector_CC_Gen_Name_input = "//*[@id=\"name\"]";
    static String WLearn_selector_CC_Gen_Description_input = "//*[@id=\"description\"]";
    static String WLearnd_selector_CC_Gen_Next_btn = "//*[@id=\"root\"]/div/div/div/div[2]/form/div[2]/div/div/button/span";
    static String WLearn_selector_CC_Mod_Next_btn = "//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div/button/span";
    static String WLearn_selector_CC_Exam_Next_btn = "//*[@id=\"root\"]/div/div/div/div[2]/form/div[2]/div/div/button/span";
    static String WLearn_selector_CC_Save_created_course = "//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div/button/span";
    static String WLearn_selector_CC_Modules_Add_btn = "//*[@id=\"root\"]/div/div/div/div[2]/div[1]/div[2]/ul/div[2]/li/div";
    static String WLearn_selector_CC_Modules_Select_first_module = "/html/body/div[2]/div[3]/div/div[2]/li[1]/div[2]/div[1]/div/h4";
    static String WLearn_selector_CC_Modules_Save_added_modules = "/html/body/div[2]/div[3]/div/div[3]/div/div/button/span";
    static String WLearn_selector_CC_Exam_Skillpoints_input = "//*[@id=\"skillPoints\"]";
    static String WLearn_selector_Course_more_menu = "//*[@id=\"root\"]/div/div/div/div[1]/div[1]/div[2]";
    static String WLearn_selector_Course_more_menu_delete = "//*[text()='Delete']";
    static String WLearn_selector_Course_delete_delete = "/html/body/div[2]/div[3]/div/div[3]/div/div/button/span";
    static String WLearn_selector_Modules = "//*[@id=\"root\"]/div/nav/div/div/ul/li[1]/ul/a[4]/div[2]/span";
    static String WLearn_selector_Modules_listview = "//*[@id=\"root\"]/div/div/div/div[2]/div[1]/div[1]/div[2]/div[2]/button[2]/span";
    static String WLearn_selector_Modules_list_openfirst = "//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div[1]";
    static String WLearn_selector_Modules_details_Loc_tab = "//*[text()='Localization']";
    static String WLearn_selector_Modules_details_Loc_Translatebtn = "//*[text()='Translate']";
    static String WLearn_selector_Modules_details_loc_Trans_Content_Dropdown = "//*[@id=\"root\"]/div/div/div/div[2]/div/div[1]/div/div/div/div";
    static String WLearn_selector_Mod_Trans_dropdwn_select_mod_details = "//*[text()='Module details']";
    static String WLearn_selector_Programs = "//*[@id=\"root\"]/div/nav/div/div/ul/li[1]/ul/a[2]/div[2]/span";
    static String Wlearn_selector_Programs_CreateProgBtn = "//*[@id=\"root\"]/div/div/div/div[1]/div/div/a/span";
    static String WLearn_selector_Cr_Pr_User_tab_Add_UserGroupBtn = "//*[@id=\"root\"]/div/div/div/div[2]/div[1]/button/span";
    static String WLearn_selector_Cr_Pr_select_first_suggested_group = "/html/body/div[2]/div[3]/div/div[2]/div/div[1]/div[2]/div/div/div/div/div/li[1]";
    static String WLearn_selector_Cr_Pr_add_selected_suggested_group = "/html/body/div[2]/div[3]/div/div[3]/div/div/button/span";
    static String WLearn_selector_Cr_Pr_user_Next_Btn = "//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div/button/span";
    static String WLearn_selector_Cr_Pr_courses_Next_Btn = "//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div/button";
    static String WLearn_selector_Cr_Pr_fin_exam_Next_Btn = "//*[@id=\"root\"]/div/div/div/div[2]/form/div[2]/div/div/button/span";
    static String WLearn_selector_Pr_Search_autofilter_field = "//*[@id=\"root\"]/div/div/div/div[2]/div[1]/div[1]/div[1]/div/div/div/input";
    static String WLearn_selector_Programs_filtered_list_element = "//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div[1]/div/div[2]";
    static String WLearn_selector_Programs_sorter_dropdown = "//*[@id=\"root\"]/div/div/div/div[2]/div[1]/div[1]/div[2]/div[1]/div/div";
    static String Wlearn_selector_Programs_sorter_select_Oldest = "//*[text()='Oldest']";
    static String Wlearn_selector_Programs_delete_program_btn = "//*[text()='Delete program']";
    static String WLearn_selector_Programs_delete_OK = "//*[text()='OK']";

    static String WLearn_selector_Users = "//*[text()='Users']";
    static String WLearn_selector_Usergroups = "//*[text()='Groups']";
    static String WLearn_selector_Usergroup_finder = "//*[@id=\"root\"]/div/div/div/div[2]/div[1]/div[1]/div[1]/div/div/div/input";
    static String WLearn_selector_usergroups_filtered_list_first_element_moremenu = "//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div[1]/li/div/div[2]/div[2]";
    static String WLearn_selector_usergroups_filtered_list_first_element_moremenu_delete = "//*[text()='Delete']";
    static String WLearn_selector_usergroups_filtered_list_first_element_moremenu_delete_confirm = "//*[text()='Delete']";
    static String WLearn_selector_Notification_close = "//*[@id=\"root\"]/div/div/div/div[2]/div[1]/div/div[2]/button";
    static String WLearn_selector_CreateGroup_btn = "//*[text()='Create group']";
    static String WLearn_selector_CreateGroup_Title = "//*[@id=\"title\"]";
    static String WLearn_selector_CreateGroup_Description = "//*[@id=\"description\"]";
    static String WLearn_selector_SaveGroup_btn = "//*[text()='Save group']";
    static String WLearn_selector_News = "//*[text()='News']";
    static String WLearn_selector_CreateNews_btn = "//*[text()='Create news']";
    static String WLearn_selector_CreateNews_Title = "//*[@id=\"title\"]";
    static String WLearn_selector_CreateNews_Body = "//*[@id=\"description\"]";
    static String WLearn_selector_CreateNews_AddTargetGroup = "//*[text()='Add target group']";
    static String WLearn_selector_CreateNews_AddGroup_Select_first = "/html/body/div[2]/div[3]/div/div[2]/li[1]";
    static String WLearn_selector_CreateNews_Add_btn = "//*[text()='Add']";
    static String WLearn_selector_CreateNews_Save_news_btn = "//*[text()='Save']";
    static String WLearn_selector_News_finder = "//*[@id=\"root\"]/div/div/div/div[2]/div[1]/div[1]/div[1]/div/div/div/input";
    static String WLearn_selector_News_moremenu = "//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div[1]/div/div[1]/div[2]/span";
    static String WLearn_selector_News_moremenu_delete = "//*[text()='Delete']";
    static String WLearn_selector_News_moremenu_delete_confirm = "//*[text()='Delete']";
    static String WLearn_selector_News_deleted_notif_close = "//*[@id=\"root\"]/div/div/div/div[1]/div/div[2]/button/span[1]";

}