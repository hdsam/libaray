package com.ygy.bll;

import java.sql.SQLException;

import com.ygy.dal.GenericDAL;
import com.ygy.model.Reader;

//读者管理类，实现借书证办理、变更、补办、挂失、解除挂失、注销等用例中的各种系统操作。
public class ReaderAdmin extends LibraryBLL {

	//办理借书证
	public  static boolean generateCard(Reader reader) {
		boolean status =false; // 默认办理失败
		// 先判断用户是否存在
		if (GenericDAL.getObjectById(Reader.class, reader.getRdID()) != null) {
			// 用户已存在，办理失败
			return status;
		}
		try {
			status = GenericDAL.add(Reader.class, reader) == 1 ? true :false;
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return status;
	}

	// 变更借书证
	public static boolean updateCard(Reader reader) {
		boolean status = false;
		//先查询
		Reader result = (Reader) GenericDAL.getObjectById(Reader.class, reader.getRdID());
		if (result != null) {
			try {
				status = GenericDAL.update(Reader.class, reader.getRdID(), reader) == 1 ? true : false;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return status;

	}

}
