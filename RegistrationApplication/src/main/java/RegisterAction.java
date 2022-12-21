
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String firstName;
	String lastName;
	String gender;
	Integer age;
	String email;
	String address;
	String selectedColor;
	List<String> colors;
	Boolean subscription = false;
	List<String> hobbies;
	String selectedHobbies;
	List<Product> products;
	public void initializeProducts() {
		products = new ArrayList<>();
		products.add(new Product(111, "Mobile Phone", 10000));
		products.add(new Product(222, "Camera", 7000));
		products.add(new Product(333, "TV", 20000));
		products.add(new Product(444, "Laptop", 30000));
	}
	public String initializeFormFields() {
		System.out.println("in initializeFormFields");
		//les autres methodes pour remplir d'autres champs peuvvent 
		//être appeler ici
		initializeProducts();
		initializeColors();
		initializeHobbies();
		return INPUT;
	}
	public void initializeHobbies() {
		hobbies = new ArrayList<>();
		hobbies.add("Drawing");
		hobbies.add("Teaching");
		hobbies.add("Singing");
		hobbies.add("Programming");
	}
	public void initializeColors() {
		colors = new ArrayList<>();
		colors.add("Red");
		colors.add("Blue");
		colors.add("Green");
		colors.add("White");
		colors.add("Black");
	}
	public String execute() {
		System.out.println("execute() method called");
		if(subscription) {
			System.out.println("You are subscribe");
		}else {
			System.out.println("You are not subscribe");
		}
		return SUCCESS;
	}

	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public String getSelectedHobbies() {
		return selectedHobbies;
	}
	public void setSelectedHobbies(String selectedHobbies) {
		this.selectedHobbies = selectedHobbies;
	}
	public List<String> getHobbies() {
		return hobbies;
	}
	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}
	public Boolean getSubscription() {
		return subscription;
	}
	public void setSubscription(Boolean subscription) {
		this.subscription = subscription;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSelectedColor() {
		return selectedColor;
	}

	public void setSelectedColor(String selectedColor) {
		this.selectedColor = selectedColor;
	}

	public List<String> getColors() {
		return colors;
	}

	public void setColors(List<String> colors) {
		this.colors = colors;
	}

	public void validate() {
		if (firstName!= null &&firstName.equals("")) {
			addFieldError("firstName", getText("error.firstName.required"));
		}

		/*if (lastName.equals("")) {
			addFieldError("lastName", "Last name is required.");
		}

		if (gender == null) {
			addFieldError("gender", "Gender is required.");
		}

		if (age == null) {
			addFieldError("age", "Age is required.");
		} else if (age <= 18) {
			addFieldError("age", "Age should be above 18.");
		}

		if (email.equals("")) {
			addFieldError("email", "Email is required.");
		}*/
	}
}
