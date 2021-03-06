package io.ztech.jkingsley.employeemanagement.ui;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.logging.Logger;

import io.ztech.jkingsley.employeemanagement.ui.AdminEmployeeManagementUI.AdminMenuOption;
import io.ztech.jkingsley.employeemanagement.ui.EmployeeLimitedEmployeeManagementUI.EmployeeLimitedMenuOption;
import io.ztech.jkingsley.employeemanagement.ui.ManagerEmployeeManagementUI.ManagerMenuOption;
import io.ztech.jkingsley.employeemanagementsystem.beans.objects.Profile;
import io.ztech.jkingsley.employeemanagementsystem.beans.types.AccountType;
import io.ztech.jkingsley.employeemanagementsystem.services.EmployeeManagement;

public class EmployeeManagementUI {

	Scanner scanner;
	BigInteger emp_id;

	public EmployeeManagementUI(BigInteger emp_id) {
		super();
		scanner = new Scanner(System.in);
		this.emp_id = emp_id;
	}

	private final Logger LOGGER = Logger.getLogger(Application.class.getName());

	public void start() {

		boolean notExit = true;

		while (notExit) {

			EmployeeManagement employeeManagement = new EmployeeManagement();
			Profile profile = employeeManagement.findEmployeeById(emp_id);
			
			profile.getEmployee();
			profile.employee.getAccount_type();
			
			AccountType accountType = profile.employee.getAccount_type();
			
			switch (accountType) {
			case ADMIN:
				AdminEmployeeManagementUI adminUI = new AdminEmployeeManagementUI(emp_id);
				adminUI.displayAdminMenu();
				AdminMenuOption adminMenuOption = adminUI.getMenuOption();
				notExit = adminUI.execute(adminMenuOption);
				break;
			case EMPLOYEE_LIMITED:
				EmployeeLimitedEmployeeManagementUI employeeLimitedUI = new EmployeeLimitedEmployeeManagementUI(emp_id);
				employeeLimitedUI.displayEmployeeMenuLimited();
				EmployeeLimitedMenuOption employeeLimitedMenuOption = employeeLimitedUI.getMenuOption();
				notExit = employeeLimitedUI.execute(employeeLimitedMenuOption);
				break;
			case EMPLOYEE_MAX:
				break;
			case MANAGER:
				ManagerEmployeeManagementUI managerUI = new ManagerEmployeeManagementUI(emp_id);
				managerUI.displayManagerMenu();
				ManagerMenuOption managerMenuOption = managerUI.getMenuOption();
				notExit = managerUI.execute(managerMenuOption);
				break;
			default:
				break;
			}
		}
	}

}
