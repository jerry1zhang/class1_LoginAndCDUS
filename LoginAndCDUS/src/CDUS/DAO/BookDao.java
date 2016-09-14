package CDUS.DAO;

import java.util.ArrayList;

import CDUS.entity.Book;


public interface BookDao {
	public boolean createBook(Book book);
	public boolean delectBook(Book book);
	public boolean updateBook(Book  book);
	public boolean updateBookStatus(Book book);
	public Book selectBook(Book  book);
	public ArrayList<Object> selectBook();
	
}
