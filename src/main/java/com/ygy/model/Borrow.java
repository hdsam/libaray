package com.ygy.model;

import java.io.Serializable;
import java.util.Date;

//借阅信息
public class Borrow extends AbstractModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5603110536276123007L;
	private int borrowID;
	private int rdID;
	private int bkID;
	private int ldContinueTimes;
	private Date ldDateOut;
	private Date ldDateRetPlan;
	private Date ldDateRetAct;
	private int ldOverDay;
	private float ldOverMoney;
	private float ldPunishMoney;
	private int lsHasReturn;
	private String OperatorLend;
	private String OperatorRet;

	public int getBorrowID() {
		return borrowID;
	}

	public void setBorrowID(int borrowID) {
		this.borrowID = borrowID;
	}

	public int getRdID() {
		return rdID;
	}

	public void setRdID(int rdID) {
		this.rdID = rdID;
	}

	public int getBkID() {
		return bkID;
	}

	public void setBkID(int bkID) {
		this.bkID = bkID;
	}

	public int getLdContinueTimes() {
		return ldContinueTimes;
	}

	public void setLdContinueTimes(int ldContinueTimes) {
		this.ldContinueTimes = ldContinueTimes;
	}

	public Date getLdDateOut() {
		return ldDateOut;
	}

	public void setLdDateOut(Date ldDateOut) {
		this.ldDateOut = ldDateOut;
	}

	public Date getLdDateRetPlan() {
		return ldDateRetPlan;
	}

	public void setLdDateRetPlan(Date ldDateRetPlan) {
		this.ldDateRetPlan = ldDateRetPlan;
	}

	public Date getLdDateRetAct() {
		return ldDateRetAct;
	}

	public void setLdDateRetAct(Date ldDateRetAct) {
		this.ldDateRetAct = ldDateRetAct;
	}

	public int getLdOverDay() {
		return ldOverDay;
	}

	public void setLdOverDay(int ldOverDay) {
		this.ldOverDay = ldOverDay;
	}

	public float getLdOverMoney() {
		return ldOverMoney;
	}

	public void setLdOverMoney(float ldOverMoney) {
		this.ldOverMoney = ldOverMoney;
	}

	public float getLdPunishMoney() {
		return ldPunishMoney;
	}

	public void setLdPunishMoney(float ldPunishMoney) {
		this.ldPunishMoney = ldPunishMoney;
	}

	public int getLsHasReturn() {
		return lsHasReturn;
	}

	public void setLsHasReturn(int lsHasReturn) {
		this.lsHasReturn = lsHasReturn;
	}

	public String getOperatorLend() {
		return OperatorLend;
	}

	public void setOperatorLend(String operatorLend) {
		OperatorLend = operatorLend;
	}

	public String getOperatorRet() {
		return OperatorRet;
	}

	public void setOperatorRet(String operatorRet) {
		OperatorRet = operatorRet;
	}

	public Borrow() {

	}

	@Override
	public String toString() {
		return "Borrow [borrowID=" + borrowID + ", rdID=" + rdID + ", bkID=" + bkID + ", ldContinueTimes="
				+ ldContinueTimes + ", ldDateOut=" + ldDateOut + ", ldDateRetPlan=" + ldDateRetPlan + ", ldDateRetAct="
				+ ldDateRetAct + ", ldOverDay=" + ldOverDay + ", ldOverMoney=" + ldOverMoney + ", ldPunishMoney="
				+ ldPunishMoney + ", lsHasReturn=" + lsHasReturn + ", OperatorLend=" + OperatorLend + ", OperatorRet="
				+ OperatorRet + "]";
	}

}
