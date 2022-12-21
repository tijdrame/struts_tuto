package action.product;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

@Namespace("/product")
@Action("/getDetails")
@ResultPath("/view/product")
@Result(name = "success", location = "product.jsp")
public class ProductDetailAction {
	public String execute() {
		System.out.println("execute() method of ProductDetailAction called");
		return "success"; 
	}
}
