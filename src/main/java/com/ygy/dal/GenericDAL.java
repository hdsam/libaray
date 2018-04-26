package com.ygy.dal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.ygy.model.AbstractModel;

//提供对各种类型的通用访问服务
public class GenericDAL {

	public static final String TB_READER = "TB_READER";
	public static final String TB_READERTYPE = "TB_READERTYPE";
	public static final String TB_BOOK = "TB_BOOK";
	public static final String TB_BORROW = "TB_BORROW";
	
	public static final String TB_READER_KEY = "RDID";
	public static final String TB_READERTYPE_KEY = "RDTY";
	public static final String TB_BOOK_KEY = "BKID";
	public static final String TB_BORROW_KEY= "BORROW_ID";

	private static final Map<String, String> tabMap=new HashMap<String,String >();
	
		static {
		tabMap.put(TB_READER, TB_READER_KEY);
		tabMap.put(TB_READERTYPE, TB_READERTYPE_KEY);
		tabMap.put(TB_BOOK, TB_BOOK_KEY);
		tabMap.put(TB_BORROW, TB_BORROW_KEY);
	}
	
	

		//该方法支持多表联查，返回结果的的第一行；
		public	static	 Object[] getDataArray(String sql,Object params[]){
			ArrayList<Object> array=new ArrayList<Object>();
			ResultSet rs=null;
			try {
				rs=	SQLHelper.getPreparedStatement(sql, params).executeQuery();
				if (rs.next()) {
					for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
						array.add(rs.getObject(i+1));
					}
				return array.toArray();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}	
			
			return null;
		}

	//获得所有的实体对象,支持条件查询
	public static AbstractModel[] getAllObjects(Class<? extends AbstractModel> clazz,String whereClause) throws SQLException {
		String tabName="TB_"+clazz.getSimpleName();
		String sql = "select * from "+tabName+" "+whereClause;
		return ConvertResultSetToEntity(clazz, SQLHelper.getResultSet(sql));
	}

	//按Id查询单个实体
	public static AbstractModel getObjectById(Class<? extends AbstractModel> clazz,int ID)  {
		String tabName=	"TB_"+clazz.getSimpleName();
		String sql = "select * from "+tabName+ " where "+GenericDAL.tabMap.get(tabName.toUpperCase())+" = ?" ;
		System.out.println(sql);
		Object params[] =new Object[1];
		params[0]= ID;
		AbstractModel[] am=null;
		try {
			am= ConvertResultSetToEntity(clazz, SQLHelper.getResultSet(sql, params));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (am==null||am.length==0) {
			return null;
		}else {
			return am[0];
		}
	}
	//添加一个实体到数据库中
	public static int add(Class <?> clazz,AbstractModel entity) throws SQLException{
		String tabName = "TB_"+clazz.getSimpleName().toUpperCase();
		String sql = "insert into  "+ tabName+" ( " ;
		HashMap <String ,Object> map=getAbstractMap(entity);
		if(tabName.equalsIgnoreCase(TB_BOOK)) map.remove(TB_BOOK_KEY);	//过滤到TB_BOOK表的identity字段-BKID
		Set<String> keys=map.keySet();
		Object params[] =new Object[keys.size()];
		int i=0 ,j=0;
		for(String string:keys){
			if (i<keys.size()-1) {
				sql+=string+"  ,";
			}else {
				sql+=string+"  ) values (";
			}
			params[i]=map.get(string);
			i++;
		}
		for (String str:keys) {
			if (j < keys.size() - 1) {
				sql += " ? , ";
			} else {
				sql += " ? )";
			}
			j++;
		}
		System.out.println(sql);
		PreparedStatement pst= SQLHelper.getPreparedStatement(sql, params);
		int status=	pst.executeUpdate();
		return status;
	}
	
	//从数据库中删除指定Id的实体
	public static int delete(Class<?> clazz,int ID) throws SQLException {
		String tabName = "TB_"+clazz.getSimpleName().toUpperCase();
		String sql = "delete "+ tabName+" where "+GenericDAL.tabMap.get(tabName)+" = ? ";
		System.out.println(sql);
		Object params[] =new Object[1];
		params[0]= ID;
		PreparedStatement pst= SQLHelper.getPreparedStatement(sql, params);
		int status=	pst.executeUpdate();
		return status;
	}

	//更新数据中指定Id实体的记录
	public static int update(Class <?> clazz,int ID,AbstractModel entity) throws SQLException {
		String tabName = "TB_"+clazz.getSimpleName().toUpperCase();
		String sql1 = "update "+ tabName+" set " ;
		String sql2="where "+GenericDAL.tabMap.get(tabName.toUpperCase())+" = "+ID;
		HashMap <String ,Object> map=getAbstractMap(entity);
		map.remove(GenericDAL.tabMap.get(tabName.toUpperCase()));
		Set<String> keys=map.keySet();
		Object params[] =new Object[keys.size()];
		int i=0;
		for(String string:keys){
			if (i<keys.size()-1) {
				sql1+=string+" = ? ,";
			}else {
				sql1+=string+" = ?  ";
			}
			params[i++]=map.get(string);
		}
		System.out.println(sql1+sql2);
		PreparedStatement pst= SQLHelper.getPreparedStatement(sql1+sql2, params);
		int status=	pst.executeUpdate();
		return status;
	}
	
	//得到对象的属性名和值的map	--工具方法
	private static HashMap<String , Object> getAbstractMap(AbstractModel entity){
		HashMap<String , Object> entityMap=new HashMap<String,Object>();
		Class<? extends AbstractModel> clazz = entity.getClass();
		Method [] methods=clazz.getMethods();
		for (Method method : methods) {
			String mName= method.getName();
			if (mName.startsWith("get") && !mName.startsWith("getClass")) {
				try {
					entityMap.put(mName.substring(3).toUpperCase(), method.invoke(entity));
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		return entityMap;
	}
		//将结果集中记录转变成对象	----工具方法
	private static AbstractModel [] ConvertResultSetToEntity(Class<? extends AbstractModel> clazz,ResultSet rs) throws SQLException{
		ArrayList<AbstractModel> list = new ArrayList<AbstractModel>();
		// ResultSetMetaData rsmd = rs.getMetaData();
		// String [] colNames=new String[rsmd.getColumnCount()];
		// for (int i = 0; i < rsmd.getColumnCount(); i++) {
		// colNames[i]= rsmd.getColumnName(i+1);
		// }
		Method[] methods = clazz.getMethods();
		while (rs.next()) {
			AbstractModel model = null;
			try {
				model = (AbstractModel) clazz.newInstance();
				for (Method method : methods) {
					String mName = method.getName();
					if (mName.startsWith("set")) {
						Object o= rs.getObject(mName.substring(3));
						if (o!=null) {
							method.invoke(model, o);
						}
					}
				}
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			list.add(model);
		}
		return (AbstractModel[]) list.toArray(new AbstractModel[list.size()]);
	}
}
//	protected  AbstractModel[] getObjectArray(Class<?> clazz,String condition ,Object ...params) throws SQLException {
//	ArrayList<AbstractModel> list = new ArrayList<AbstractModel>();
//	Connection conn = null;
//	PreparedStatement pst = null;
//	ResultSet rs = null;
//	if (!clazz.getSuperclass().getName().equals(AbstractModel.class.getName())) {
//		return null;
//	}
//	conn = SQLHelper.getConnection();
//	String sql= " select * from "+tabMap.get("TB_"+clazz.getSimpleName());
//	pst = SQLHelper.getConnection().prepareStatement(sql);
//	if(condition!=null&&condition.length()!=0&&params!=null ){
//		sql+= "  where "+condition+"  ";
//		for (int i = 0; i  < params.length; i++) {
//			pst.setObject(i+1, params[i]);
//		}
//	}
//	rs = pst.executeQuery();
//
//	// ResultSetMetaData rsmd = rs.getMetaData();
//	// String [] colNames=new String[rsmd.getColumnCount()];
//	// for (int i = 0; i < rsmd.getColumnCount(); i++) {
//	// colNames[i]= rsmd.getColumnName(i+1);
//	// }
//	Method[] methods = clazz.getMethods();
//	while (rs.next()) {
//		AbstractModel model = null;
//		try {
//			model = (AbstractModel) clazz.newInstance();
//			for (Method method : methods) {
//				String mName = method.getName();
//				if (mName.startsWith("set")) {
//					method.invoke(model, rs.getObject(mName.substring(3)));
//				}
//			}
//		} catch (InstantiationException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		} catch (IllegalArgumentException e) {
//			e.printStackTrace();
//		} catch (InvocationTargetException e) {
//			e.printStackTrace();
//		}
//		list.add(model);
//	}
//	SQLHelper.close(conn, pst, rs);
//	return (AbstractModel[]) list.toArray(new AbstractModel[list.size()]);
//}
//
//
//private  int add(AbstractModel entity) throws Exception {
//
//	// String sql ="update table "+type+"( ) where " ;
//	// if(type.equals(GenericDAL.TB_READER)){
//	// sql+=" rdID = ?";
//	// }
//	// if(type.equals(GenericDAL.TB_BOOK)){
//	// sql+=" "
//	// }
//	// if(type.equals(GenericDAL.TB_BOOK)){
//	// sql+=" "
//	// }
//	// if(type.equals(GenericDAL.TB_BOOK)){
//	// sql+=" "
//	// }
//	Class clazz = entity.getClass();
//	String table = clazz.getSimpleName();
//	Field[] fields = clazz.getFields();// 未验证
//
//	Method[] methods = clazz.getMethods();
//	ArrayList<String> keys = new ArrayList<String>();
//	ArrayList<Object> values = new ArrayList<Object>();
//	
//		for (Method method : methods) {
//			String mName = method.getName();
//			if (mName.startsWith("get") && !mName.startsWith("getClass")) {
//				keys.add(mName.substring(3));
//				try {
//					values.add(method.invoke(entity));
//				} catch (IllegalAccessException e) {
//					e.printStackTrace();
//				} catch (IllegalArgumentException e) {
//					e.printStackTrace();
//				} catch (InvocationTargetException e) {
//					e.printStackTrace();
//				}
//			}
//
//		}
//		String sql = " insert into TB_" + table + " ( ";
//		for (int i = 0; i < keys.size(); i++) {
//			if (i < keys.size() - 1) {
//				sql += keys.get(i) + " , ";
//			} else {
//				sql += keys.get(i) + " ) values ( ";
//			}
//		}
//		for (int i = 0; i < values.size(); i++) {
//			if (i < values.size() - 1) {
//				sql += " ? , ";
//			} else {
//				sql += " ? )";
//			}
//		}
//	System.out.println(sql);
//	PreparedStatement pst = SQLHelper.getConnection().prepareStatement(sql);
//	for (int i = 0; i < values.size(); i++) {
//		pst.setObject(i + 1, values.get(i));
//	}
//	int status = pst.executeUpdate();
//
//	return status;
//}

