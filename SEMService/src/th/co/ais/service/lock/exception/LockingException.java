package th.co.ais.service.lock.exception;

import th.co.ais.service.exception.BusinessValidationException;

public class LockingException extends BusinessValidationException {

	private static final long serialVersionUID = -6286367663945501507L;

	public LockingException(String msg) {
		super(msg, msg);
	}

}
