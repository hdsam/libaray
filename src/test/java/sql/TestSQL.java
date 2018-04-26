package sql;



import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import com.ygy.dal.GenericDAL;
import com.ygy.dal.SQLHelper;
import com.ygy.model.AbstractModel;
import com.ygy.model.Reader;
import com.ygy.model.ReaderType;

public class TestSQL {
	
//	@Test
//	public void testQuery() throws SQLException {
//			String sql ="select * from TB_ReaderType where rdType = 10 ";
//			AbstractModel[] r=(AbstractModel[]) GenericDAL.getAllObjects(Reader.class, null);
//			for (AbstractModel reader : r) {
//				System.out.println(reader.getClass());
//				System.out.println(reader.toString());
//			}
////			rt.setCanContinueTimes((Integer) map.get("canContinueTimes"));
////			rt.setCanLendDay((Integer) map.get("canLendDay"));
////			rt.setCanLendQty((Integer) map.get("canLendQty"));
////			rt.setDateValid((Short) map.get("dateValid"));	//Short
////			rt.setPunishRate((Double) map.get("punishRate"));
////			rt.setRdType((Short) map.get("rdType"));
////			rt.setRdTypeName((String) map.get("rdTypeName"));
////			HashMap<String , Object> map=new HashMap<String, Object>();
////			System.out.println(rsmd);
//	}
	
//	@Test
//	public void test1() throws SQLException {
//		AbstractModel[] r=(AbstractModel[]) GenericDAL.getAllObjects(Reader.class, null,null);
//		((Reader)r[0]).setRdID(201404001);
//		GenericDAL.add(null, r[0],);
//		
//	}
//	
	@Test
	public void test2() {
		try {
			GenericDAL g=new GenericDAL();
			Reader r=(Reader) g.getObjectById(Reader.class, 201404000);
			System.out.println(r);
			r.setRdAdminRoles(8);
			r.setRdID(201404123);
			g.add(r.getClass(), r );
			System.out.println(g.getObjectById(Reader.class, 201404123));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
