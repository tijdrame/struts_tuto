package action;

import com.opensymphony.xwork2.ActionSupport;

import dao.ProductManagementDAO;

public class DeleteAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String productId;
	
	public String execute() {
		String statusCode = "";
		System.out.println("Delete execute() method called");
		System.out.println("Product Id = "+productId);
		int recordUpdated = ProductManagementDAO.deleteProduct(productId);
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
}
