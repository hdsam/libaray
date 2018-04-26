package com.ygy.model;


//读者类型
public class ReaderType extends AbstractModel {
	/**
	 * 
	 */

	private short rdType;
	private String rdTypeName;
	private int canLendQty;
	private int canLendDay;
	private int canContinueTimes;
	private double punishRate;
	private short dateValid;

	public ReaderType() {
	}

	public short getRdType() {
		return rdType;
	}

	public void setRdType(short rdType) {
		this.rdType = rdType;
	}

	public String getRdTypeName() {
		return rdTypeName;
	}

	public void setRdTypeName(String rdTypeName) {
		this.rdTypeName = rdTypeName;
	}

	public int getCanLendQty() {
		return canLendQty;
	}

	public void setCanLendQty(int canLendQty) {
		this.canLendQty = canLendQty;
	}

	public int getCanLendDay() {
		return canLendDay;
	}

	public void setCanLendDay(int canLendDay) {
		this.canLendDay = canLendDay;
	}

	public int getCanContinueTimes() {
		return canContinueTimes;
	}

	public void setCanContinueTimes(int canContinueTimes) {
		this.canContinueTimes = canContinueTimes;
	}

	public double getPunishRate() {
		return punishRate;
	}

	public void setPunishRate(double punishRate) {
		this.punishRate = punishRate;
	}

	public int getDateValid() {
		return dateValid;
	}

	public void setDateValid(short dateValid) {
		this.dateValid = dateValid;
	}


	@Override
	public String toString() {
		return "ReaderType [rdType=" + rdType + ", rdTypeName=" + rdTypeName + ", canLendQty=" + canLendQty
				+ ", canLendDay=" + canLendDay + ", canContinueTimes=" + canContinueTimes + ", punishRate=" + punishRate
				+ ", dateValid=" + dateValid + "]";
	}

}
