package CDUS.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CDUS.DAO.impl.BookDaoImpl;
import CDUS.DAO.impl.BookKindsDaoImpl;
import CDUS.entity.Book;
import CDUS.entity.bookKinds;

public class BookListServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BookDaoImpl BD = new BookDaoImpl();
		ArrayList<Object> bookList = BD.selectBook();
		String url = "/BookList.jsp";
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(url);
		resp.setContentType("text/html;charset=utf-8");
		ArrayList<HashMap<Object, Object>> varlist = new ArrayList<>();
		HashMap<Object, Object> map;
		Book book = null;
		for (int i = 0; i < bookList.size(); i++) {
			map = new HashMap<>();
			book = (Book)bookList.get(i);
			map.put(("Bid"), book.getBid());
			map.put(("Name"), book.getName());
			map.put(("bDate"), book.getbDate());
			map.put(("bPress"), book.getbPress());
			map.put(("bAuthor"), book.getbAuthor());
			varlist.add(map);
		}
		req.setAttribute("varlist", varlist);
		rd.forward(req,resp); 
//		PrintWriter out = resp.getWriter();
//		out.println("<html><head><title>图书列表</title></head><body>");
//		out.println("<center>");
//		out.println("<h1>图书列表</h1>");
//		out.println("<table border='1px'>");
//		out.println("<tr><td>图书编号</td><td>图书名称</td><td>入库时间</td><td>出版社</td><td>作者</td><td>操作</td></tr>");
//		Book book = null;
//		for (int i = 0; i < bookList.size(); i++) {
//			book = (Book)bookList.get(i);
//			out.println("<tr>");
//			out.println("<td>"+book.getBid()+"</td>");
//			out.println("<td>"+book.getName()+"</td>");
//			out.println("<td>"+book.getbDate()+"</td>");
//			out.println("<td>"+book.getbPress()+"</td>");
//			out.println("<td>"+book.getbAuthor()+"</td>");
//			out.println("<td><a href='bookup?bid="+book.getBid()+"'>更新</a><a href='bookdel?bid="+book.getBid()+"'>删除</a></td>");
//			out.println("</tr>");
//		}
//		out.println("<tr><td  colspan='2'><a href='bookadd'>新增</a></td>");
//		out.println("<td  colspan='4'><from method='post' action='booksel'>"
//				+ "书名：<input type='text' name='Name'>"
//				+ "<input type='submit' value='搜索'>"
//				+ "</form></td></tr>");
//		out.println("</table>");
//		out.println("</center>");
//		out.println("</body></html>");
//		out.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BookDaoImpl BD = new BookDaoImpl();
		req.setCharacterEncoding("utf-8");
		String name = req.getParameter("Name");
		ArrayList<Object> bookList = BD.selectBookByName(name);
		String url = "/BookList.jsp";
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(url);
		resp.setContentType("text/html;charset=utf-8");
		ArrayList<HashMap<Object, Object>> varlist = new ArrayList<>();
		HashMap<Object, Object> map;
		Book book = null;
		for (int i = 0; i < bookList.size(); i++) {
			map = new HashMap<>();
			book = (Book)bookList.get(i);
			map.put(("Bid"), book.getBid());
			map.put(("Name"), book.getName());
			map.put(("bDate"), book.getbDate());
			map.put(("bPress"), book.getbPress());
			map.put(("bAuthor"), book.getbAuthor());
			varlist.add(map);
		}
		req.setAttribute("varlist", varlist);
		rd.forward(req,resp); 
	}
}
