package th.co.ais.exception;

import java.rmi.RemoteException;

public class ValidateDataException extends RemoteException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7487494290994350651L;

	public ValidateDataException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ValidateDataException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}


}
