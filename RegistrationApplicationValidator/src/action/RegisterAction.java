package action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.CustomValidator;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.IntRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.ValidationParameter;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

@Action("/registerAction")
@Results({ @Result(name = "success", location = "/welcome.jsp"), @Result(name = "input", location = "/register.jsp") })
@Validations(requiredStrings = {
		@RequiredStringValidator(type = ValidatorType.SIMPLE, fieldName = "firstName", message = "FirstName is required"),
		@RequiredStringValidator(type = ValidatorType.SIMPLE, fieldName = "lastName", message = "LastName is required"),
		@RequiredStringValidator(type = ValidatorType.SIMPLE, fieldName = "email", message = "Email is required") }, 
			requiredFields = {
				@RequiredFieldValidator(type = ValidatorType.SIMPLE, fieldName = "gender", message = "Gender is required"),
				@RequiredFieldValidator(type = ValidatorType.SIMPLE, fieldName = "age", message = "Age is required") }, 
			emails = {
				@EmailValidator(type = ValidatorType.SIMPLE, fieldName = "email", message = "Must provide a valid Email") }, 
			intRangeFields = {
				@IntRangeFieldValidator(type = ValidatorType.SIMPLE, fieldName = "age", min = "18", message = "Age should be above 18") }, 
			customValidators = {
				@CustomValidator(type = "domainNameValidator", fieldName = "email", parameters = {
				@ValidationParameter(name = "domainName", value = "gmail.com") }, message = "Email must have a valid domain") })
public class RegisterAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private String gender;
	private Integer age;
	private String email;

	public String execute() {
		System.out.println("execute() method called");
		return "success";
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// Comment this method if validation is done using xml file
	/*
	 * public void validate() { if (firstName.equals("")) {
	 * addFieldError("firstName", getText("error.firstName.required")); }
	 * 
	 * if (lastName.equals("")) { addFieldError("lastName",
	 * getText("error.lastName.required")); }
	 * 
	 * if (gender == null) { addFieldError("gender",
	 * getText("error.gender.required")); }
	 * 
	 * if (age == null) { addFieldError("age", getText("error.age.required")); }
	 * else if(age <= 18) { addFieldError("age", getText("error.age.range")); }
	 * 
	 * if (email.equals("")) { addFieldError("email",
	 * getText("error.email.required")); } }
	 */
}
