package emailapp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private int defaultPasswordLength = 15;
	private String department;
	private int mailboxCapacity = 500;
	private String alternateEmail;
	private String email;
	private String companySuffix = "intel.com";

	// Constructor to get firstName and lastName
public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		
		this.department = this.setDepartment();
	
		// call method to generate random password
		this.password = this.randomPassword(defaultPasswordLength);
		
		// combine elements to generate email
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
	}
	
	
	// Ask for department
	private String setDepartment() {
		// ask for input
		System.out.println("Choose the department of new worker:\n 1 for Sales\n 2 for Development\n 3 for Accounting\n 4 for None ");
		Scanner sc = new Scanner(System.in);
		int dept = sc.nextInt();
		if(dept == 1)
			return "Sales";
		else if(dept == 2)
			return "Dev";
		else if(dept == 3)
			return "Acct";
		else
			return "";
	}
	
	// Generate random password
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789$#";
		char[] password = new char[length];
		for(int i=0; i< length; i++) {
			int random = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(random);
		}
		
		return new String(password);
	}
	
	
	// Set the email mailbox capacity
	public void setMailCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}
	
	// Set alternate email
	public void setAltEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	
	
	// Change the password
	public void changePassword(String password) {
		this.password = password;
	}
	
	// Get methods
	public int getmailBoxCapacity() {
		return this.mailboxCapacity;
	}
	
	public String getAltEmail() {
		return this.alternateEmail;
	}
	public String getPassword()	{
		return this.password;
	}
	
	public String showEmpInfo() {
		return "Display Name: " + firstName + " " + lastName +
				"\nCompany email: " + email +
				"\nPassword: " + password +
				"\nMailbox capacity: " + mailboxCapacity + 
				"\nAlternate email: " + alternateEmail;
	}
	
}
