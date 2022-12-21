package action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport; 

import dao.LoginDAO;
import pojo.LoginInfo;

public class LoginAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String userName;
	String password;
	
	public String execute() {
		String statusCode = "";
		System.out.println("execute() method called");
		boolean isUserValid = LoginDAO.isUserValid(new LoginInfo(userName, password));
		if (isUserValid) {
			ServletActionContext.getRequest().getSession().setAttribute("loggedinUser", userName);
			statusCode = SUCCESS;
		} else {
			statusCode = INPUT;
		}
		return statusCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
