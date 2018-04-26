package com.ygy.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ygy.bll.UserAdmin;

public class ChangePassword extends MyActionSupport {

	private String password1;
	private String password2;

	@Override
	public String execute() throws Exception {

		Integer id = (Integer) getSession().getAttribute(("loginID"));
		System.out.print(id + "  " + password1 + "  " + password2);
		boolean status = UserAdmin.changePassword(id, password1, password2);
		if (status == false) {
			getWriter().print(Function.JumpTo("两次输入的密码不一致！！更改失败", "changePassword.jsp"));
			return null;
		} else {
			getWriter().print(Function.JumpTo("更改密码成功！！", "loginSuccess.jsp"));
			return null;
		}
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

}
