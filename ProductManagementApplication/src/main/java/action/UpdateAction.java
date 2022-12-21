package action;

import java.time.LocalDate;

import com.opensymphony.xwork2.ActionSupport;

import dao.ProductManagementDAO;
import pojo.Product;

public class UpdateAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String productId;
	String productName;
	String productCategory;
	Integer productPrice;
	LocalDate createdDate;
	
	public String execute() {
		String statusCode = "";
		System.out.println("execute() method called");
		Product product = new Product(productId, productName, productCategory, productPrice, null);
		int recordUpdated = ProductManagementDAO.updateProduct(product);
		if (recordUpdated == 1) {
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

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	
}
