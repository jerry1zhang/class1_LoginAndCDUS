package CDUS.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CDUS.DAO.impl.BookDaoImpl;
import CDUS.entity.Book;

public class BookListServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BookDaoImpl BD = new BookDaoImpl();
		ArrayList<Object> bookList = BD.selectBook();
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println("<html><head><title>ͼ���б�</title></head><body>");
		out.println("<center>");
		out.println("<h1>ͼ���б�</h1>");
		out.println("<table border='1px'>");
		out.println("<tr><td>ͼ����</td><td>ͼ������</td><td>���ʱ��</td><td>������</td><td>����</td><td>����</td></tr>");
		Book book = null;
		for (int i = 0; i < bookList.size(); i++) {
			book = (Book)bookList.get(i);
			out.println("<tr>");
			out.println("<td>"+book.getBid()+"</td>");
			out.println("<td>"+book.getName()+"</td>");
			out.println("<td>"+book.getbDate()+"</td>");
			out.println("<td>"+book.getbPress()+"</td>");
			out.println("<td>"+book.getbAuthor()+"</td>");
			out.println("<td><a href='bookup?bid="+book.getBid()+"'>����</a><a href='bookdel?bid="+book.getBid()+"'>ɾ��</a></td>");
			out.println("</tr>");
		}
		out.println("<tr><td><a href='bookadd'>����</a></td></tr>");
		out.println("</table>");
		out.println("</center>");
		out.println("</body></html>");
		out.close();
	}
}
