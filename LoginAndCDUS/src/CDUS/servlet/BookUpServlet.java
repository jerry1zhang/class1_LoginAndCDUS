package CDUS.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CDUS.DAO.impl.BookDaoImpl;
import CDUS.entity.Book;

public class BookUpServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url="/BookUp.jsp";
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(url);
		String bid = req.getParameter("bid");
		BookDaoImpl bd = new BookDaoImpl();
		Book book = new Book();
		book.setBid(Integer.valueOf(bid));
		book = bd.selectBook(book);
//		req.setCharacterEncoding("charset=utf-8");
		resp.setContentType("text/html;charset=utf-8");
		req.setAttribute("bid", bid);
		req.setAttribute("Name", book.getName());
		req.setAttribute("bPress", book.getbPress());
		req.setAttribute("bAuthor", book.getbAuthor());
		req.setAttribute("bValue", book.getbValue());
		rd.forward(req,resp); 
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String bid = req.getParameter("bid");
		BookDaoImpl bd = new BookDaoImpl();
		Book book = new Book();
		book.setBid(Integer.valueOf(bid));
		book.setName(req.getParameter("Name"));
		book.setbPress(req.getParameter("bPress"));
		book.setbAuthor(req.getParameter("bAuthor"));
		book.setbValue(Double.valueOf(req.getParameter("bValue")));
		boolean flag = bd.updateBook(book);
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println("<html><head><title>图书修改</title></head><body>");
		out.println("<center>");
		if (flag) {
			out.println("修改成功！");
		}else{
			out.println("修改失败！");
		}
		out.println("<br>");
		out.println("<a href='booklist'>返回列表</a>");
		out.println("</center>");
		out.println("</body></html>");
	}
}
