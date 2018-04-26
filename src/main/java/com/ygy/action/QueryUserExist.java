package com.ygy.action;

import com.ygy.bll.UserAdmin;

import com.ygy.model.Reader;

public class QueryUserExist extends MyActionSupport {
	private int rdID;

	@Override
	public String execute() throws Exception {
		String uri = getRequest().getParameter("uri");
		Reader reader = UserAdmin.getReader(rdID);
		if (reader == null) {
			getWriter().println(Function.JumpTo("该用户" + rdID + "不存在", uri + ".jsp"));
		} else {
			if (uri.equals("updateCard"))
				getSession().setAttribute("updateUser", reader);
			getWriter().println(Function.JumpTo("该用户" + rdID + "存在", uri + ".jsp"));
		}
		return null;
	}

	public void setRdID(int rdID) {
		this.rdID = rdID;
	}

	public int getRdID() {
		return rdID;
	}
}
