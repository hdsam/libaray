package com.ygy.action;

import com.ygy.bll.BorrowAdmin;

public class CanLendBook extends MyActionSupport {
	private int rdID;

	public String execute() {
		boolean status = BorrowAdmin.canLend(rdID);
		if (status == false) {
			getWriter().println(Function.JumpTo("该用户" + rdID + "不能借书", "lendBook.jsp"));
			return null;
		} else {
			getWriter().println(Function.JumpTo("该用户" + rdID + "能借书", "lendBook.jsp"));
			return null;
			
		}
	}

	public void setRdID(int rdID) {
		this.rdID = rdID;
	}

	public int getRdID() {
		return rdID;
	}
}
