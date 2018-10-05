package io.ztech.hrmanagement.beans.objects;

import java.util.ArrayList;

public class Profile {
	public Employee employee;
	public ArrayList<Phone> phoneNumbers;
	public ArrayList<EmergencyContact> emergencyContacts;
	public ArrayList<Mail> mailAddresses;
	public ArrayList<Assign> projectsAssigned;
	public ArrayList<Experience> totalExperience;
	
	public Profile() {
		super();
		employee = new Employee();
		phoneNumbers = new ArrayList<Phone>();
		emergencyContacts = new ArrayList<EmergencyContact>();
		mailAddresses = new ArrayList<Mail>();
		projectsAssigned = new ArrayList<Assign>();
		totalExperience = new ArrayList<Experience>();
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public ArrayList<Phone> getPhoneNumbers() {
		return phoneNumbers;
	}
	public void setPhoneNumbers(ArrayList<Phone> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	public ArrayList<EmergencyContact> getEmergencyContacts() {
		return emergencyContacts;
	}
	public void setEmergencyContacts(ArrayList<EmergencyContact> emergencyContacts) {
		this.emergencyContacts = emergencyContacts;
	}
	public ArrayList<Mail> getMailAddresses() {
		return mailAddresses;
	}
	public void setMailAddresses(ArrayList<Mail> mailAddresses) {
		this.mailAddresses = mailAddresses;
	}
	public ArrayList<Assign> getProjectsAssigned() {
		return projectsAssigned;
	}
	public void setProjectsAssigned(ArrayList<Assign> projectsAssigned) {
		this.projectsAssigned = projectsAssigned;
	}
	public ArrayList<Experience> getTotalExperience() {
		return totalExperience;
	}
	public void setTotalExperience(ArrayList<Experience> totalExperience) {
		this.totalExperience = totalExperience;
	}
	

}
