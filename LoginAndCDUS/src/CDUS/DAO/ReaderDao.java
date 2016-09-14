package CDUS.DAO;

import java.util.ArrayList;

import CDUS.entity.Reader;

public interface ReaderDao {
	public boolean createReader(Reader reader);
	public boolean delectReader(Reader reader);
	public boolean updateReader(Reader reader);
	public Reader selectReader(Reader reader);
	public boolean easyUpdateReader(Reader reader);
	public boolean statusUpdateReader(Reader reader);
	public ArrayList<Object> allReader();
}
