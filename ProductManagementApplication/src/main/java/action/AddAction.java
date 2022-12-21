package action;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.opensymphony.xwork2.ActionSupport;

import dao.ProductManagementDAO;
import pojo.Product;

public class AddAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String productId;
	String productName;
	String productCategory;
	Integer productPrice;
	String createdDate;
	
	public String execute() {
		String statusCode = "";
		System.out.println("execute() method called");
		final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		final LocalDate dt = LocalDate.parse(createdDate.substring(0, 10), dtf);
		Product product = new Product(productId, productName, productCategory, productPrice, dt);
		int recordAdded = ProductManagementDAO.addProduct(product);
		if (recordAdded == 1) {
			statusCode = SUCCESS;
		} else {
			statusCode = ERROR;
		}
		return statusCode;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
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

	public Integer getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	
}
