package arbormetrix.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import arbormetrix.base.TestBase;
import arbormetrix.util.TestUtil;

public class Registration extends TestBase {

	TestUtil util;

	@CacheLookup
	@FindBy(xpath = "//*[@id='header_1']")
	WebElement studentRegistrationForm;

	@CacheLookup
	@FindBy(name = "q4_studentName[first]")
	WebElement firstName;

	@CacheLookup
	@FindBy(xpath = "//*[@id='sublabel_4_first']")
	WebElement firstNamelabel;

	@CacheLookup
	@FindBy(name = "q4_studentName[middle]")
	WebElement middleName;

	@CacheLookup
	@FindBy(xpath = "//*[@id='sublabel_4_middle']")
	WebElement middleNamelabel;

	@CacheLookup
	@FindBy(name = "q4_studentName[last]")
	WebElement lastName;

	@CacheLookup
	@FindBy(xpath = "//*[@id='sublabel_4_last']")
	WebElement lastNamelabel;

	@CacheLookup
	@FindBy(name = "q24_birthDate24[month]")
	WebElement monthDropDown;

	@CacheLookup
	@FindBy(name = "q24_birthDate24[day]")
	WebElement dayDropDown;

	@CacheLookup
	@FindBy(name = "q24_birthDate24[year]")
	WebElement yearDropDown;

	@CacheLookup
	@FindBy(name = "q3_gender")
	WebElement genderDropDown;

	@CacheLookup
	@FindBy(xpath = "//input[@id='input_23_addr_line1']")
	WebElement streetAddress;

	@CacheLookup
	@FindBy(xpath = "//input[@name='q23_address[addr_line2]' and @type='text']")
	WebElement streetAddress2;

	@CacheLookup
	@FindBy(xpath = "// *[@id = 'input_23_city']")
	WebElement cityInfo;

	@CacheLookup
	@FindBy(xpath = "// *[@id = 'input_23_state']")
	WebElement stateInfo;

	@CacheLookup
	@FindBy(name = "q23_address[postal]")
	WebElement zipCodeInfo;

	@CacheLookup
	@FindBy(xpath = "//input[@name='q6_studentEmail6']")
	WebElement emailAddress;

	@CacheLookup
	@FindBy(xpath = "//*[@id='label_6']")
	WebElement emailAddressLabel;

	@CacheLookup
	@FindBy(xpath = "//input[@name='q27_mobileNumber[full]']")
	WebElement mobileNumber;

	@CacheLookup
	@FindBy(name = "q25_phoneNumber25[full]")
	WebElement phoneNumber;

	@CacheLookup
	@FindBy(name = "q26_workNumber[full]")
	WebElement workNumber;

	@CacheLookup
	@FindBy(name = "q14_company")
	WebElement companyInfo;

	@CacheLookup
	@FindBy(xpath = "//*[@id='input_46']")
	WebElement courseDropDownList;

	@CacheLookup
	@FindBy(xpath = "// *[@name = 'q45_clickTo45']")
	WebElement commentTextBox;

	@CacheLookup
	@FindBy(xpath = "// *[@id = 'input_20']")
	WebElement submitButton;

	@CacheLookup
	@FindBy(xpath = "// *[@id = 'input_19']")
	WebElement clearButton;
	
	@CacheLookup
	@FindBy(xpath= "//*[@id='input_46']/option[10]")
	WebElement mathCourse;

	// Constructor of the current page
	// Initializing Page Object using pageFactory Method
	public Registration() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public String validateRegistrationPageTitle() {
		return driver.getTitle();
	}

	public void studentName(String fname, String mname, String lname) {

		firstName.sendKeys(fname);
		middleName.sendKeys(mname);
		lastName.sendKeys(lname);
	}

	public void dateOfBirth(String month, String day, String year) {

		Select selectMonth = new Select(monthDropDown);
		selectMonth.selectByValue(month);

		dayDropDown.sendKeys(day);
		yearDropDown.sendKeys(year);

	}

	public void selectGender(String gender) {
		Select selectGender = new Select(genderDropDown);
		selectGender.selectByValue(gender);
	}

	public void studentAddress(String streetAdd, String streetAdd2, String city, String state, String zipcode) {
		streetAddress.sendKeys(streetAdd);
		streetAddress2.sendKeys(streetAdd2);
		cityInfo.sendKeys(city);
		stateInfo.sendKeys(state);
		zipCodeInfo.sendKeys(zipcode);
	}

	public void studentContact(String email, String mobileNum, String phoneNum, String workNum, String company) {
		emailAddress.sendKeys(email);
		mobileNumber.sendKeys(mobileNum);
		phoneNumber.sendKeys(phoneNum);
		workNumber.sendKeys(workNum);
		companyInfo.sendKeys(company);

	}

	public void studentCourse(String subject) {

		Select selectCourse = new Select(courseDropDownList);
		selectCourse.selectByValue(subject);
		String message = "Course Selected By Student: " + subject;
		commentTextBox.clear();
		commentTextBox.sendKeys(message);

	}

	public void clickSubmitButton() {
		submitButton.click();
	}

	public String studentRegistrationFormHeader() {
		return studentRegistrationForm.getText();
	}

	public void clickClearButton() {
		clearButton.click();
	}

	public String firstNamelabelFields() {
		return firstNamelabel.getText();
	}

	public String lastNamelabelFields() {
		return lastNamelabel.getText();

	}

	public String middleNamelabelFields() {
		return middleNamelabel.getText();

	}

	public String emailAddressLabelFields() {
		return emailAddressLabel.getText();

	}
	public void dropDownListbyCourse(String provideCourseName) {

		String selectedCourse = mathCourse.getText();
		Assert.assertEquals(selectedCourse, provideCourseName);
		System.out.println("Selected Course: "+selectedCourse);
		
		
	}


}