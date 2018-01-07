package com.test.autoset.quickstat.uiAction;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.autoset.quickstart.homepage.TC001_VerifyLoginWithInvalidCredentials;
import com.test.autoset.quickstat.excelReader.Excel_Reader;



public class HomePage {

	public static final Logger log = Logger.getLogger(TC001_VerifyLoginWithInvalidCredentials.class.getName());
	Excel_Reader excel;
	WebDriver driver;

	@FindBy(xpath = ".//*[@id='header']/div[2]/div/div/nav/div[1]/a")
	WebElement signIn;

	@FindBy(xpath = ".//*[@id='email']")
	WebElement loginEmailAddress;

	@FindBy(xpath = ".//*[@id='passwd']")
	WebElement loginPassword;

	@FindBy(id = "SubmitLogin")
	WebElement submit;

	@FindBy(xpath = "//*[@id='center_column']/div[1]/ol/li")
	WebElement athanticationFailed;

	@FindBy(xpath = "//*[@id='basicBootstrapForm']/div[1]/div[1]/input")
	WebElement firstName;

	@FindBy(xpath = "//*[@id='basicBootstrapForm']/div[1]/div[2]/input")
	WebElement lastName;

	@FindBy(xpath = "//*[@id='basicBootstrapForm']/div[2]/div/textarea")
	WebElement address;

	@FindBy(xpath = "//*[@id='eid']/input")
	WebElement emailAddress;

	@FindBy(xpath = "//*[@id='basicBootstrapForm']/div[4]/div/input")
	WebElement phoneNumber;

	@FindBy(xpath = "//*[@id='basicBootstrapForm']/div[5]/div/label[1]/input")
	WebElement gender;

	@FindBy(xpath = "//*[@id='countries']/option[@value='India']")
	WebElement country;

	@FindBy(xpath = "//*[@id='yearbox']/option[@value='1992']")
	WebElement year;

	@FindBy(xpath = ".//*[@id='basicBootstrapForm']/div[11]/div[2]/select/option[@value='4']")
	WebElement month;

	@FindBy(xpath = "//*[@id='daybox']/option[@value='30']")
	WebElement date;

	@FindBy(xpath = "//*[@id='firstpassword']")
	WebElement password;

	@FindBy(id = "secondpassword")
	WebElement confirmPassword;

	@FindBy(xpath = "//*[@id='submitbtn']")
	WebElement submitRegistration;

	@FindBy(xpath = "//*[@id='header']/nav/div/div[2]/ul/li[3]/a")
	WebElement registrationmessage;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void loginToApplicaation(String emailAddress, String password) {
		signIn.click();
		log.info("Clicked on sign in and object is : " + signIn.toString());
		loginEmailAddress.sendKeys(emailAddress);
		log.info("Enter email address " + emailAddress + " and object is : " + loginEmailAddress.toString());
		loginPassword.sendKeys(password);
		log.info("Enter password" + password + " and object is : " + loginPassword.toString());
		submit.click();
		log.info("Clicked on submit button and the object is : " + submit.toString());
	}

	public String getInvalidLoginText() {
		return athanticationFailed.getText();
	}

	public void RegisterToApplicaation(String firstName, String lastName, String address, String emailAddress,
			String phoneNumber, String password, String confirmPassword) {
		this.firstName.clear();
		this.firstName.sendKeys(firstName);
		log.info("Enter First Name and object is : " + firstName.toString());
		this.lastName.clear();
		this.lastName.sendKeys(lastName);
		log.info("Enter Last Name and object is : " + lastName.toString());

		this.address.clear();
		this.address.sendKeys(address);
		log.info("Enter Address and object is : " + address.toString());

		this.emailAddress.clear();
		this.emailAddress.sendKeys(emailAddress);
		log.info("Enter Email Address and object is : " + emailAddress.toString());

		this.phoneNumber.clear();
		this.phoneNumber.sendKeys(phoneNumber);
		log.info("Enter Phone Number and object is : " + phoneNumber.toString());

		gender.click();
		log.info("Select gender and object is : " + gender.toString());

		country.click();
		log.info("Select Country and object is : " + country.toString());

		year.click();
		log.info("Select Year and object is : " + year.toString());
		month.click();
		log.info("Select month and object is : " + month.toString());
		date.click();
		log.info("Select date and object is : " + date.toString());

		this.password.clear();
		this.password.sendKeys(password);
		log.info("Enter paassword and object is : " + password.toString());

		this.confirmPassword.clear();
		this.confirmPassword.sendKeys(confirmPassword);
		log.info("Enter paassword and object is : " + confirmPassword.toString());

		submitRegistration.click();
		log.info("Submitted and object is : " + submitRegistration.toString());

	}

	public boolean VerifyRegistrationSuccess() {
		try {
			driver.findElement(By.xpath("//*[@id='header']/nav/div/div[2]/ul/li[3]/a")).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	
}
