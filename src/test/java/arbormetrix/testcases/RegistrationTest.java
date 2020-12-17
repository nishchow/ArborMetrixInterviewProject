package arbormetrix.testcases;

import arbormetrix.base.TestBase;
import arbormetrix.pages.Registration;
import arbormetrix.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {

	Registration registration;
	TestUtil testUtil;
	String sheetName = "studentInfo";

	public RegistrationTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws Exception {

		initialization();
		testUtil = new TestUtil();
		registration = new Registration();

	}

	@Test(priority = 0)
	public void verifyContactsPageLabel() {
		String title = registration.validateRegistrationPageTitle();
		Assert.assertEquals(title, "Course Registration Form Template | JotForm");
		System.out.println(title);
	}

	@Test(priority = 1)
	public void verifyFieldsArePresent() {
		String firstNameField = registration.firstNamelabelFields();
		System.out.println(firstNameField);
		Assert.assertEquals(firstNameField, "First Name");

		String lastNameField = registration.lastNamelabelFields();
		System.out.println(lastNameField);
		Assert.assertEquals(lastNameField, "Last Name");

		String middleNameField = registration.middleNamelabelFields();
		System.out.println(middleNameField);
		Assert.assertEquals(middleNameField, "Middle Name");

		String emailAddressField = registration.emailAddressLabelFields();
		System.out.println(emailAddressField);
		Assert.assertEquals(emailAddressField, "Student E-mail");

	}

	@DataProvider
	public Object[][] getStudentTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority = 2, dataProvider = "getStudentTestData")
	public void validatingStudentReistration(String fname, String mname, String lname, String month, String day,
			String year, String gender, String streetAdd, String streetAdd2, String city, String state, String zipcode,
			String email, String mobileNum, String phoneNum, String workNum, String company, String subject)
			throws Exception {

		

		registration.studentName(fname, mname, lname);
		registration.dateOfBirth(month, day, year);
		registration.selectGender(gender);
		registration.studentAddress(streetAdd, streetAdd2, city, state, zipcode.substring(0, 5));
		registration.studentContact(email, mobileNum, phoneNum, workNum, company);
		registration.studentCourse(subject);
		registration.clickSubmitButton();
		
		String formName = registration.studentRegistrationFormHeader();
		Assert.assertEquals(formName, "Student Registration Form");

	}

	@Test(priority = 3)
	public void verifyCourseIsPresentFromDropDownList() {

		registration.dropDownListbyCourse(" Math 101 ");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
