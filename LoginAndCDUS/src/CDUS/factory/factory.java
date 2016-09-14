package CDUS.factory;

import java.util.Vector;


import CDUS.DAO.impl.BookDaoImpl;
import CDUS.DAO.impl.BookKindsDaoImpl;
import CDUS.DAO.impl.BookLibHistoryDaoImpl;
import CDUS.DAO.impl.ManagerDaoImpl;
import CDUS.DAO.impl.ReaderDaoImpl;
import CDUS.entity.*;
import CDUS.util.DBhelper_mysql;

public class factory {

	public ReaderDaoImpl getReaderDaoImpl(){
		ReaderDaoImpl rdi = new ReaderDaoImpl();
		return rdi;
	}

	public ManagerDaoImpl getManagerDaoImpl(){
		ManagerDaoImpl mdi = new ManagerDaoImpl();
		return mdi;
	}

	public BookDaoImpl getBookDaoImpl(){
		BookDaoImpl bdi = new BookDaoImpl();
		return bdi;
	}
	public BookKindsDaoImpl getBookKindsDaoImpl(){
		BookKindsDaoImpl bkdi = new BookKindsDaoImpl();
		return bkdi;
	}
	public BookLibHistoryDaoImpl getBookLibHistoryDaoImpl(){
		BookLibHistoryDaoImpl blhdi = new BookLibHistoryDaoImpl();
		return blhdi;
	}
	public DBhelper_mysql getDBhelper_mysql(){
		DBhelper_mysql dbh = new DBhelper_mysql();
		return dbh;
	}
	public Reader getReader(){
		Reader r = new Reader();
		r.setRid(0);
		return r;
	}
	public Manager getManager(){
		Manager m = new Manager();
		m.setMid(0);
		return m;
	}
	public Book getBook(){
		Book b = new Book();
		return b;
	}
	public bookLibHistory getbookLibHistory(Book book,Reader reader){
		bookLibHistory b = new bookLibHistory();
		b.setBook(book);
		b.setReader(reader);
		return b;
	}
}
