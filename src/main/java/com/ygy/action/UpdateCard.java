package com.ygy.action;


import com.ygy.bll.ReaderAdmin;
import com.ygy.model.Reader;

public class UpdateCard extends MyActionSupport {

	private String rdName;
	private String rdSex;
	private int rdType;
	private String rdDept;
	private String rdPhone;
	private String rdEmail;
	private String rdStatus;
	private int rdBorrowQty;

	@Override
	public String execute() throws Exception {
		Reader reader = (Reader) (getSession().getAttribute("updateUser"));
		reader.setRdName(rdName);
		reader.setRdSex(rdSex);
		reader.setRdType(rdType);
		reader.setRdDept(rdDept);
		reader.setRdPhone(rdPhone);
		reader.setRdEmail(rdEmail);
		reader.setRdStatus(rdStatus);
		reader.setRdBorrowQty(rdBorrowQty);
		boolean status = ReaderAdmin.updateCard(reader);
		if (status) {
			getWriter().println(Function.JumpTo("更新" + reader.getRdID() + "的信息成功！", "updateCard.jsp"));
			getSession().removeAttribute("updateUser");
			return null;
		} else {
			getWriter().println(Function.JumpTo("更新" + reader.getRdID() + "的信息失败！", "updateCard.jsp"));
			return null;
		}
	}

	public String getRdName() {
		return rdName;
	}

	public void setRdName(String rdName) {
		this.rdName = rdName;
	}

	public String getRdSex() {
		return rdSex;
	}

	public void setRdSex(String rdSex) {
		this.rdSex = rdSex;
	}

	public int getRdType() {
		return rdType;
	}

	public void setRdType(int rdType) {
		this.rdType = rdType;
	}

	public String getRdDept() {
		return rdDept;
	}

	public void setRdDept(String rdDept) {
		this.rdDept = rdDept;
	}

	public String getRdPhone() {
		return rdPhone;
	}

	public void setRdPhone(String rdPhone) {
		this.rdPhone = rdPhone;
	}

	public String getRdEmail() {
		return rdEmail;
	}

	public void setRdEmail(String rdEmail) {
		this.rdEmail = rdEmail;
	}

	public String getRdStatus() {
		return rdStatus;
	}

	public void setRdStatus(String rdStatus) {
		this.rdStatus = rdStatus;
	}

	public int getRdBorrowQty() {
		return rdBorrowQty;
	}

	public void setRdBorrowQty(int rdBorrowQty) {
		this.rdBorrowQty = rdBorrowQty;
	}

}
