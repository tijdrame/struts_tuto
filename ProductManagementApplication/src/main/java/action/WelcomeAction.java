package action;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.opensymphony.xwork2.ActionSupport;

import dao.ProductManagementDAO;
import pojo.Product;

public class WelcomeAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String productName;
	private String productCategory;
	private String createdDate;
	List<Product> products;
	
	public void initializeProducts()
	{
		System.out.println("********** Filter Data **********");
		System.out.println("productName: "+productName);
		System.out.println("productCategory: "+productCategory);
		System.out.println("createdDate: "+createdDate);
		LocalDate dt = null;
		if(createdDate!=null && StringUtils.isNotEmpty(createdDate.toString())) {
			final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			dt = LocalDate.parse(createdDate.substring(0, 10), dtf);
		}
		
		products = ProductManagementDAO.getAllProducts(productName, productCategory, dt); 
	}
	
	public String execute() {
		System.out.println("WELCOME execute() method called");
		initializeProducts();
		return "success";
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	
}
