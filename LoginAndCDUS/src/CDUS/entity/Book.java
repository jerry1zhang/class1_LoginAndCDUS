package CDUS.entity;

import java.sql.Date;

public class Book {
	private int bid;//�鼮���
	private String name;//�鼮����
	private Date bDate;//�鼮���ʱ��
	private String bPress;//������
	private String bAuthor;//�鼮����
	private double bValue;//�鼮�۸�
	private int bookKindsNo;//�鼮���ͱ��
	private String bookKindsName;//�鼮��������
	private int status;//�鼮״̬
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getbDate() {
		return bDate;
	}
	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}
	public String getbPress() {
		return bPress;
	}
	public void setbPress(String bPress) {
		this.bPress = bPress;
	}
	public String getbAuthor() {
		return bAuthor;
	}
	public void setbAuthor(String bAuthor) {
		this.bAuthor = bAuthor;
	}
	public double getbValue() {
		return bValue;
	}
	public void setbValue(double bValue) {
		this.bValue = bValue;
	}
	public int getBookKindsNo() {
		return bookKindsNo;
	}
	public void setBookKindsNo(int bookKindsNo) {
		this.bookKindsNo = bookKindsNo;
	}
	public String getBookKindsName() {
		return bookKindsName;
	}
	public void setBookKindsName(String bookKindsName) {
		this.bookKindsName = bookKindsName;
	}
	
}
