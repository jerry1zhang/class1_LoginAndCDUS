package CDUS.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

public class BookAddServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		Book book = new Book();
		book.setName(req.getParameter("Name"));
		book.setbPress(req.getParameter("bPress"));
		book.setbAuthor(req.getParameter("bAuthor"));
		book.setbValue(Double.valueOf(req.getParameter("bValue")));
		book.setBookKindsNo(Integer.valueOf(req.getParameter("BookKindsNo")));
		BookDaoImpl bookdao = new BookDaoImpl();
		boolean flag = false;
		flag = bookdao.createBook(book);
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println("<html><head><title>图书新增</title></head><body>");
		out.println("<center>");
		if (flag) {
			out.println("图书：《"+book.getName()+"》已经添加成功");
		}else{
			out.println("图书：《"+book.getName()+"》添加失败！");
		}
		out.println("<br>");
		out.println("<a href='booklist'>返回列表</a>");
		out.println("</center>");
		out.println("</body></html>");
		out.close();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url="/BookAdd.jsp";
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(url);
		BookKindsDaoImpl dao = new BookKindsDaoImpl();
		ArrayList<bookKinds> bookkindslist = dao.selectBookKinds();
//		req.setCharacterEncoding("charset=utf-8");
		resp.setContentType("text/html;charset=utf-8");
		ArrayList<HashMap<Object, Object>> varlist = new ArrayList<>();
		HashMap<Object, Object> map;
		bookKinds bk = null;
		for (int i = 0; i < bookkindslist.size(); i++) {
			map = new HashMap<>();
			bk = bookkindslist.get(i);
			map.put(("bookKindsNo"), bk.getBookKindsNo());
			map.put(("bookKindsName"), bk.getBookKindsName());
			varlist.add(map);
		}
		req.setAttribute("varlist", varlist);
		rd.forward(req,resp); 
	}
}
