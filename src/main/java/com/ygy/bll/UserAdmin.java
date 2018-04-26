package com.ygy.bll;

import java.sql.SQLException;

import com.ygy.dal.GenericDAL;
import com.ygy.model.Reader;


//用户管理类，
public class UserAdmin extends LibraryBLL {
	
	public static Reader getReader(int rdID) {
		
		return (Reader) GenericDAL.getObjectById(Reader.class,rdID);
		
	}
	
	
	//检查用户输入的密码和用户名是否正确
	public static int checkUser(int rdID,String password){
		int status=0;
		Reader result=(Reader) GenericDAL.getObjectById(Reader.class,rdID);
		if (result==null) {
			status=-1;	//用户不存在
		}else if(result.getRdPwd().equals(password)){
			status=1;	//登录成功
		}else {
			status=0;	//密码错误
		}
		return status;
	}
	
	//修改密码
	public static boolean changePassword(int rdId,String password1,String password2){
		boolean status=false;
		if(password1.equals(password2)){
			Reader reader= (Reader) GenericDAL.getObjectById(Reader.class, rdId);
			System.out.println(rdId+reader.toString());
			if (reader!=null) {
				reader.setRdPwd(password1);
				int row=0;
				try {
					row= GenericDAL.update(Reader.class, rdId, reader);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				status=row==1?true:false;
			}
		}
		return status;
	}
	
}
