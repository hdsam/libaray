package com.ygy.bll;

import com.ygy.dal.GenericDAL;
import com.ygy.model.Book;

//借阅管理类，实现借书、还书、续借等用例中的系统操作。
public class BorrowAdmin extends LibraryBLL {

	//判断用户能否借阅
	public static boolean canLend(int rdID) {
		boolean status = false;
		String sql = "select rdStatus , rdBorrowQty,canLendQty , ldOverDay "
				+ "from TB_READER rd ,TB_READERTYPE rt,TB_BORROW br "
				+ "where rd.rdType = rt.rdType and rd.rdID = br.rdID and rd.rdID = ?";
		Object params[] = new Object[1];
		params[0] = rdID;
		Object[] result = GenericDAL.getDataArray(sql, params);
		System.out.println(result ==null);
		if (result != null) {
			if ("有效".equals(result[0]) && (int) result[1] < (int) result[2] && (int) result[3] == 0) {
				status= true;
			}else {
				status =false;
			}
		}else {
			status =true;
		} 
		
		return status;
	}
	
	//查询书籍信息
	public  static Book getBook(int bkID){
		return new BookAdmin().getBook(bkID);
	}
	
//	public boolean canContiune(){
////		boolean status = false;
////		GenericDAL dal = new GenericDAL();
////		String sql = " select rdStatus ,";
//		
//		return false;
//	}
	

}
