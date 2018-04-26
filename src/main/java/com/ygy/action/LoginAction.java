package com.ygy.action;

import javax.servlet.http.HttpSession;


import com.ygy.bll.UserAdmin;
import com.ygy.model.Reader;

public class LoginAction extends MyActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4344763972968807410L;
	
	private int username;
	private String password;
	
	private Reader reader;

	@Override
	public String execute() throws Exception {

		HttpSession session = getSession();
		int status = UserAdmin.checkUser(username, password);
		if (status == 1) {
			session.setAttribute("userId", username+"");
			reader=UserAdmin.getReader(username);
			return SUCCESS;
		} else if (status == 0) {
			getWriter().print(Function.JumpTo("密码错误！", "index.jsp"));
			return null;
		} else {
			getWriter().print(Function.JumpTo("用户不存在！", "index.jsp"));
			return null;
		}
		
	}
	
	public void setReader(Reader reader) {
		this.reader = reader;
	}
	public Reader getReader() {
		return reader;
	}

	public int getUsername() {
		return username;
	}

	public void setUsername(int username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
