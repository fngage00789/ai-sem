package th.co.ais.service.exception;

public class ServiceException extends Exception {

	private static final long serialVersionUID = -6925600225152943216L;

	public ServiceException(Throwable e) {
		super(e);
	}

	public ServiceException(String string) {
		super(string);
	}
}
