package io.zilker.application.constants;

public class DisplayConstants {
	public static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/new_government_project?autoReconnect=true&useSSL=false";
	public static final String CONNECTION_USERNAME = "root";
	public static final String CONNECTION_PASSWORD = "Ztech@123";
	public static final String MENU_DISPLAY_OPTION = "\n---------------------------\n1. View All Projects\n2. User Login\n3. User Registration\n4. Contractor Registration\n5. Exit\n-------------------------------";
	public static final String ADMIN_MENU = "\n----------------------------\n1. Add a New Project\n2. Display Requested Projects\n3. View all Contractors\n4. Log Out\n----------------------------";
	public static final String CONTRACTOR_MENU = "\n----------------------------\n1. View My Projects\n2. View Available Projects\n3. View Delayed Projects\n4. Log Out\n5. View Applied Projects \n----------------------------";
	public static final String USER_MENU = "\n----------------------------\n1. View All Projects\n2. View Projects in my location\n3. Log Out\n----------------------------";
	public static final String DELAYED_MENU = "\n----------------------------\n1. Add a Response for the Delay\n2. Exit\n----------------------------";
	public static final String ALL_PROJECTS = "Project ID | Project Name | Status | Start | End | Contractor ID | Location | Cost | Description ";
	public static final String REQUESTED_EDIT = "\n----------------------------\n1. Edit a Requested Project\n2. Exit\n----------------------------\n";
	public static final String REQUESTED_UPDATE_OPTION = "\n----------------------------\nEnter what you want to Edit \n1. Start Date\n2. End Date\n3. Estimated Cost\n----------------------------\n";
	public static final String WHAT_TO_EDIT = "Enter the Request ID you want to Edit !";
	public static final String GET_START_DATE = "Enter a new start date !";
	public static final String GET_END_DATE = "Enter a new end date !";
	public static final String GET_EST_COST = "Enter a new Estimated Cost !";
	public static final String SPLITTER = "\n------------------------------------------------------------------------\n";
	public static final String NO_DELAYED_PROJ = "You have no delayed Projects, Congrats !";
	public static final String USER_COMMENT_MENU = "\n-------------------------\n1. Comment\n2. Exit\n--------------------------\n";
	public static final String INVALID_NAME = "You Have Entered a Invalid Name ! Enter Again";
	public static final String DETAIL_DISPLAY_MENU = "\n-----------------------------------------\n1. Comment\n2. View Contractor Details\n3. Exit \n-----------------------------\n";
	public static final String ADMIN_APPROVE_MENU = "\n-----------------------\n1. Approve a Project\n2. Exit\n--------------------------\n";
	public static final String PROJECT_DISPLAY = "\n---------------------------\n1. Enter The project ID you want to see\n2. Go Back !\n-----------------------------\n";
	public static final String ROLE_SELECTION = "\n---------------------------------\1. User\n2. Contractor\n";
	public static final String ERROR_CONTRACTOR_CREATION = "An Error Occured during Contractor Creation !";
	public static final String ERROR_DATE = "You Have Entered a Invalid Date ! Enter Again";
	public static final String GET_FIRST_NAME = "Enter the Contractor First Name !";
	public static final String GET_LAST_NAME = "Enter the Contractor Last Name !";
	public static final String GET_EMAIL = "Enter the Contractor Email !";
	public static final String EMAIL_ERROR = "You Have Entered a Invalid Email! Enter Again";
	public static final String GET_UNIQUE_USERNAME = "Enter a unique Username For your Account !";
	public static final String GET_CONTRACTOR_PASSWORD = "Enter the Contractor Password !";
	public static final String GET_COMPANY_NAME = "Enter the Company Name !";
	public static final String GET_ANNUAL_REVENUE = "Enter the Annual Revenue of your Company !";
	public static final String GET_NO_OF_CLIENT = "Enter the Number of client your company has !";
	public static final String GET_LOCATION = "Enter the Location of your Company !";
	public static final String GET_USER_FIRST_NAME = "Enter the user First Name !";
	public static final String GET_USER_LAST_NAME = "Enter the user Last Name !";
	public static final String GET_USER_PASSWORD = "Enter a Password ! (Please Do Remember it !)";
	public static final String GET_USER_PASSWORD_AGAIN = "Enter the password Again !";
	public static final String GET_USER_LOCATION = "Enter the location !";
	public static final String ERR_INVALID_LOCATION = "You Have Entered a Invalid Location ! Enter Again";
	public static final String GET_USERNAME = "Enter the User Name";
	public static final String GET_PASSWORD = "Enter the Password !";
	public static final String NO_RESPONSE_FOUND = "No Response Found !";
	public static final String RESPONSE_FOUND_IS = "The Response is ";
	public static final String COMMENTS_FOUND_ARE = "The Comments are !";
	public static final String NO_COMMENTS_FOUND = "No Comments Found !";
	public static final String ERR_STATUS_CHECK = "Error Occured During Status Check !";
	public static final String ERR_LOGIN = "Login Information Incorrect !";
	public static final String ERR_COMMENT = "Error While adding Comment !";
	public static final String ERR_USER_CREATION = "Error Occured While User Creation ";
	public static final String ERR_REQUEST_TENDER = "Error Occured While Requesting Tender !";
	public static final String ERR_WHILE_ADDING_RESPONSE = "An Error Occured While Adding Response !";
	public static final String GET_RESPONSE_TEXT = "Enter the Response text";
	public static final String NO_AVAILABLE_PROJECT = "Sorry There are no Available Projects Right Now !";
	public static final String NO_APPLIED_PROJECT = "Sorry You applied to no Project Currently !";
	public static final String GET_PROJECT_ID_TO_SEE = "Enter the Projects ID you want to see !";
	public static final String REQUEST_LOGIN = "Please Login to Continue !";
	public static final String GET_PROJECT_NAME = "Enter the Project Name !";
	public static final String GET_PROJECT_LOCATION = "Enter the project Location !";
	public static final String GET_PROJECT_DESCRIPTION = "Enter Some Project Description !";
	public static final String ERR_ADDING_PROJECT = "Error Occured while Adding New Project";
	public static final String COMPLETED_PROJECT = "Enter the Project ID of the Completed project! else Enter -1";
	public static final String PROJECT_ID_TO_TENDER = "Enter a Project Id that you want to get Tender !\nEnter -1 to Exit";
	public static final String NO_REQUEST_FOR_PROJECT = "There are no request for projects currently !";
	public static final String NO_CONTRACTOR_REGISTERED = "No Contractor has registered for your Application !, Sad !";
	public static final String SQL_ERR = "An SQL Exception Occured";
	public static final String SYSTEM_EXCEPTION = "A System Exception Occured";
	public static final String INTERNAL_ERR = "A General Exception Occured";
	public static final String CONTROLLER_ERR = "An Error Occured at the Controller";
	public static final String NO_CLASS_FOUND_ERR = "An Error Occured No Class is found !";
	public static final String RESULT_SET_CLOSE_ERR = "An Error Occured while closing the Result Set !";
	public static final String PREPARED_STMT_CLOSE_ERR = "An Error Occured while closing the Prepared Statement !";
	public static final String CONNECTION_CLOSE_ERR = "An Error Occured while closing Database Connection";
}
