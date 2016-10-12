package CDUS.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CDUS.DAO.impl.BookDaoImpl;
import CDUS.entity.Book;

public class BookDelServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bid = req.getParameter("bid");
		BookDaoImpl bd = new BookDaoImpl();
		Book book = new Book();
		book.setBid(Integer.valueOf(bid));
		boolean flag = bd.delectBook(book);
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println("<html><head><title>Í¼ÊéÉ¾³ý</title></head><body>");
		out.println("<center>");
		if (flag) {
			System.out.println("info:delete book "+bid);
			out.println("É¾³ý³É¹¦£¡");
		}else{
			out.println("É¾³ýÊ§°Ü£¡");
		}
		out.println("<br>");
		out.println("<a href='booklist'>·µ»ØÁÐ±í</a>");
		out.println("</center>");
		out.println("</body></html>");
	}
}
