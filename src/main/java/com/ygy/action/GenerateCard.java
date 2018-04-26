package com.ygy.action;

import com.opensymphony.xwork2.ModelDriven;
import com.ygy.bll.ReaderAdmin;
import com.ygy.model.Reader;

public class GenerateCard extends MyActionSupport implements ModelDriven<Reader> {
	private Reader reader = new Reader();

	@Override
	public String execute() throws Exception {
		reader.setRdPhoto(reader.getRdID() + ""); // 设置图片路径为用户名
		reader.setRdPwd("123");// 默认密码为123
		reader.setRdDateReg(new java.sql.Date(System.currentTimeMillis()));
		reader.setRdBorrowQty(0);
		reader.setRdAdminRoles(0);
		System.out.println(reader);
		boolean status = ReaderAdmin.generateCard(reader);
		if (status) {
			getWriter().println(Function.JumpTo("办理借书证成功", "generateCard.jsp"));
			return null;
		} else {
			getWriter().print(Function.JumpTo("办理借书证失败！", "generateCard.jsp"));
			return null;
		}

	}

	@Override
	public Reader getModel() {
		return reader;
	}

}
