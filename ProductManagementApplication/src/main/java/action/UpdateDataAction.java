package action;

import com.opensymphony.xwork2.ActionSupport;

import dao.ProductManagementDAO;
import pojo.Product;

public class UpdateDataAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String productId;
	String productName;
	String productCategory;
	String createddate;
	Integer productPrice;
	
	public String execute() {
		System.out.println("execute() method called");
		Product product = ProductManagementDAO.getProductById(productId);
		productId = product.getProductId();
		productName = product.getProductName();
		productCategory = product.getProductCategory();
		productPrice = product.getProductPrice();
		createddate = product.getCreatedDate().toString();
		return "success";
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

	public String getCreateddate() {
		return createddate;
	}

	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}
	
}
