package CDUS.DAO;

import java.util.ArrayList;

import CDUS.entity.bookKinds;

public interface BookKindsDao {
	public boolean createBookKinds(bookKinds bookKinds);
	public boolean delectBookKinds(bookKinds bookKinds);
	public boolean updateBookKinds(bookKinds bookKinds);
	public ArrayList<bookKinds> selectBookKinds();
}
