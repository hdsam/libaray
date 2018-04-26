package com.ygy.action;

import com.ygy.bll.BorrowAdmin;

public class GetBook extends MyActionSupport {
	private int bkID;

	@Override
	public String execute() throws Exception {
		getSession().setAttribute("book", BorrowAdmin.getBook(bkID));
		System.out.println(BorrowAdmin.getBook(bkID));
		getWriter().println(Function.JumpTo(null, "lendBook.jsp"));
		return null;
	}

	public int getBkID() {
		return bkID;
	}

	public void setBkID(int bkID) {
		this.bkID = bkID;
	}
}
