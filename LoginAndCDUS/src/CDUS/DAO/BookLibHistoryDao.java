package CDUS.DAO;

import java.sql.Date;
import java.util.ArrayList;

import CDUS.entity.Book;
import CDUS.entity.Reader;
import CDUS.entity.bookLibHistory;

public interface BookLibHistoryDao {
	public boolean createBookLibHistory(bookLibHistory bookLibHistory,Reader reader);
	public boolean delectBookLibHistory(bookLibHistory bookLibHistory);
	public boolean updateBookLibHistory(bookLibHistory bookLibHistory);
	public boolean updateBookLibHistory(int bno,Date hDate);
	public boolean updateBookReturnHistory(int bno,Date LibDate);
	public bookLibHistory selectBookLibHistory(bookLibHistory bookLibHistory);
	public ArrayList<Object> selectAllBookHistory();
	public ArrayList<Object> selectReaderBookHistory(Reader reader);
}
