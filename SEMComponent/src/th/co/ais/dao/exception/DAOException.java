package th.co.ais.dao.exception;

public class DAOException extends Exception {

	private static final long serialVersionUID = -3454009611293275183L;

	public DAOException() {
		super();
	}

	public DAOException(Throwable e) {
		super(e);
	}

	public DAOException(String string) {
		super(string);
	}
}
