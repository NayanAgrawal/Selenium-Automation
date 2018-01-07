package com.test.autoset.quickstart.registrationPage;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.autoset.quickstart.homepage.TC001_VerifyLoginWithInvalidCredentials;

public class Registration {

	public static final Logger log = Logger.getLogger(TC001_VerifyLoginWithInvalidCredentials.class.getName());

	WebDriver driver;

	@FindBy(xpath = ".//*[@id='basicBootstrapForm']/div[1]/div[1]/input")
	WebElement firstName;

	@FindBy(xpath = ".//*[@id='basicBootstrapForm']/div[1]/div[2]/input")
	WebElement lastName;

	@FindBy(xpath = ".//*[@id='basicBootstrapForm']/div[2]/div/textarea")
	WebElement address;

	@FindBy(xpath = ".//*[@id='eid']/input")
	WebElement emailAddress;

	@FindBy(xpath = ".//*[@id='basicBootstrapForm']/div[4]/div/input")
	WebElement phoneNumber;

	@FindBy(xpath = ".//*[@id='basicBootstrapForm']/div[5]/div/label[1]/input")
	WebElement gender;

	@FindBy(xpath = ".//*[@id='countries']/option[@value='India']")
	WebElement country;

	@FindBy(xpath = ".//*[@id='firstpassword']")
	WebElement password;

	@FindBy(id = "secondpassword")
	WebElement confirmPassword;

	public Registration(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void RegisterToApplicaation(String registrationFirstName, String registrationLastName,
			String registrationAddress, String registrationEmailAddress, String registrationPassword,
			String confirmRregistrationPassword) {
		firstName.clear();
		firstName.sendKeys(registrationFirstName);
		log.info("Enter First Name and object is : " + firstName.toString());
		lastName.clear();
		lastName.sendKeys(registrationLastName);
		log.info("Enter Last Name and object is : " + lastName.toString());

		lastName.clear();
		address.sendKeys(registrationAddress);
		log.info("Enter Address and object is : " + address.toString());

		lastName.clear();
		emailAddress.sendKeys(registrationEmailAddress);
		log.info("Enter Email Address and object is : " + emailAddress.toString());

		phoneNumber.clear();
		phoneNumber.sendKeys(registrationEmailAddress);
		log.info("Enter Phone Number and object is : " + phoneNumber.toString());

		gender.click();
		log.info("Select gender and object is : " + gender.toString());

		country.click();
		;
		log.info("Select Country and object is : " + country.toString());

		password.clear();
		password.sendKeys(registrationPassword);
		log.info("Enter paassword and object is : " + password.toString());

		confirmPassword.clear();
		confirmPassword.sendKeys(confirmRregistrationPassword);
		log.info("Enter paassword and object is : " + password.toString());

	}

}
