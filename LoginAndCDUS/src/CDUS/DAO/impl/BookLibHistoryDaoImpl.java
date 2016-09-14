package CDUS.DAO.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import CDUS.DAO.BookLibHistoryDao;
import CDUS.entity.Book;
import CDUS.entity.Reader;
import CDUS.entity.bookLibHistory;
import CDUS.factory.factory;
import CDUS.util.DBhelper_mysql;

public class BookLibHistoryDaoImpl implements BookLibHistoryDao{
	private factory f = new factory();
	public boolean createBookLibHistory(bookLibHistory bookLibHistory,Reader reader) {
		DBhelper_mysql dbh = f.getDBhelper_mysql();
		Connection conn = dbh.getConnection();
		PreparedStatement ps = null;
		boolean flag = false;
		int n = 0;
		try {
			String sql = "insert into bookLibHistory(bid,rid,LibDate,ReturnDate,HDate) value(?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bookLibHistory.getBook().getBid());
			ps.setInt(2, reader.getRid());
			ps.setDate(3, bookLibHistory.getLibDate());
			ps.setDate(4, bookLibHistory.getReturnDate());
			ps.setDate(5, bookLibHistory.getHdate());
			n = ps.executeUpdate();
			if (n!=0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbh.closeConnection(null, ps, conn);
		return flag;
	}

	public boolean delectBookLibHistory(bookLibHistory bookLibHistory) {
		DBhelper_mysql dbh = f.getDBhelper_mysql();
		Connection conn = dbh.getConnection();
		PreparedStatement ps = null;
		int n = 0;
		boolean flag = false;
		String sql = "delect bookLibHistoryNo,bid,rid,LibDate,ReturnDate from bookLibHistory where bookLibHistory = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bookLibHistory.getBookLibHistory());
			n = ps.executeUpdate();
			if (n!=0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbh.closeConnection(null, ps, conn);
		return flag;
	}

	public boolean updateBookLibHistory(bookLibHistory bookLibHistory) {
		boolean flag = false;
		DBhelper_mysql dbh = f.getDBhelper_mysql();
		Connection conn = dbh.getConnection();
		PreparedStatement ps = null;
		int n = 0;
		String sql = "update bookLibHistory set bookLibHistory = ?,bid = ?,rid = ?,LibDate = ?,ReturnDate = ? where bookLibHistory = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bookLibHistory.getBookLibHistory());
			ps.setInt(2, bookLibHistory.getBook().getBid());
			ps.setInt(3, bookLibHistory.getReader().getRid());
			ps.setDate(4, bookLibHistory.getLibDate());
			ps.setDate(5, bookLibHistory.getReturnDate());
			ps.setInt(6, bookLibHistory.getBookLibHistory());
			n = ps.executeUpdate();
			if (n!=0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbh.closeConnection(null, ps, conn);
		return flag;
	}

	public bookLibHistory selectBookLibHistory(bookLibHistory bookLibHistory) {
		DBhelper_mysql dbh = f.getDBhelper_mysql();
		Connection conn = dbh.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "select bookLibHistoryNo,bid,rid,LibDate,ReturnDate,HData from bookLibHistory where rid = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bookLibHistory.getReader().getRid());
			rs = ps.executeQuery();
			while (rs.next()) {
				bookLibHistory.setBookLibHistory(rs.getInt("bookLibHistoryNo"));
				//���Կ��ǽ��ж�book��reader�Ĳ�ѯ
				Book book = new Book();
				book.setBid(rs.getInt("bid"));
				bookLibHistory.setBook(book);
				Reader reader = new Reader();
				reader.setRid(rs.getInt("rid"));
				bookLibHistory.setReader(reader);
				bookLibHistory.setLibDate(rs.getDate("LibDate"));
				bookLibHistory.setReturnDate(rs.getDate("ReturnDate"));
				bookLibHistory.setHdate(rs.getDate("HData"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbh.closeConnection(rs, ps, conn);
		return bookLibHistory;
	}

	public ArrayList<Object> selectAllBookHistory() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Object> selectReaderBookHistory(Reader reader) {
		DBhelper_mysql dbh = f.getDBhelper_mysql();
		Connection conn = dbh.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Object> srbh = new ArrayList<Object>();
		try {
			String sql = "select blh.bookLibHistoryNo,b.bid,b.name,r.rid,r.accounts,blh.LibDate,blh.ReturnDate,blh.status,blh.HDate from bookLibHistory blh,book b,reader r where r.rid = ? and blh.bid = b.bid and blh.rid = r.rid";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, reader.getRid());
			rs = ps.executeQuery();
			bookLibHistory bookLibHistory;
			while (rs.next()) {
				bookLibHistory = new bookLibHistory();
				bookLibHistory.setBookLibHistory(rs.getInt("bookLibHistoryNo"));
				Book book = new Book();
				book.setBid(rs.getInt("bid"));
				book.setName(rs.getString("name"));
				bookLibHistory.setBook(book);
				Reader r = new Reader();
				r.setRid(rs.getInt("rid"));
				r.setAccounts(rs.getString("accounts"));
				bookLibHistory.setReader(r);
				bookLibHistory.setLibDate(rs.getDate("LibDate"));
				bookLibHistory.setReturnDate(rs.getDate("ReturnDate"));
				bookLibHistory.setStatus(rs.getInt("status"));
				bookLibHistory.setHdate(rs.getDate("HDate"));
				srbh.add(bookLibHistory);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbh.closeConnection(rs, ps, conn);
		return srbh;
	}

	public boolean updateBookLibHistory(int bid, Date LibDate) {
		boolean flag = false;
		DBhelper_mysql dbh = f.getDBhelper_mysql();
		Connection conn = dbh.getConnection();
		PreparedStatement ps = null;
		int n = 0;
		String sql = "update bookLibHistory set LibDate = ? where bid = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setDate(1, LibDate);
			ps.setInt(2, bid);
			n = ps.executeUpdate();
			if (n!=0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbh.closeConnection(null, ps, conn);
		return flag;
	}

	public boolean updateBookReturnHistory(int bid, Date ReturnDate) {
		boolean flag = false;
		DBhelper_mysql dbh = f.getDBhelper_mysql();
		Connection conn = dbh.getConnection();
		PreparedStatement ps = null;
		int n = 0;
		String sql = "update bookLibHistory set ReturnDate = ?,status = 0 where bid = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setDate(1, ReturnDate);
			ps.setInt(2, bid);
			n = ps.executeUpdate();
			if (n!=0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbh.closeConnection(null, ps, conn);
		return flag;
	}


	

}
