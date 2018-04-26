package com.ygy.bll;

import java.sql.SQLException;

import com.ygy.dal.GenericDAL;
import com.ygy.model.Book;

//图书管理类，实现图书管理各用例中的系统操作
public class BookAdmin extends LibraryBLL {

	public boolean sortBook(Book book) {
		boolean status = false;
		try {
			status = GenericDAL.update(Book.class, book.getBkID(), book) == 1 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	public boolean addBook(Book book) {
		boolean status = false;
		try {
			new GenericDAL();
			status = GenericDAL.add(Book.class, book) == 1 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	public Book[] getAllBooks() {
		Book[] books = null;
		try {
			books = (Book[]) GenericDAL.getAllObjects(Book.class, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}

	public Book getBook(int bkID) {
		Book book = null;
		book = (Book) GenericDAL.getObjectById(Book.class, bkID);
		return book;
	}

	public boolean deleteBook(int bkID) {
		boolean status = false;
		if (getBook(bkID) != null) {
			try {
				new GenericDAL();
				status = GenericDAL.delete(Book.class, bkID) == 1 ? true : false;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return status;
	}

	public boolean updateBook(Book book) {
		boolean status = false;
		if (getBook(book.getBkID()) != null) {
			try {
				status = GenericDAL.update(Book.class, book.getBkID(), book) == 1 ? true : false;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return status;
	}
}
