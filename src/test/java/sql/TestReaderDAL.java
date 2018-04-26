package sql;

import org.junit.Test;

import com.ygy.dal.GenericDAL;
import com.ygy.model.Book;

public class TestReaderDAL {
	@Test
	public void test(){
		Book book=(Book) GenericDAL.getObjectById(Book.class, 1);
		System.out.println(book);
	}
}
