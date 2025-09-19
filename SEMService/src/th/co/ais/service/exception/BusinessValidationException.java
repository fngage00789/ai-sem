package th.co.ais.service.exception;

import th.co.ais.dao.exception.EnumExceptionSeverity;

public abstract class BusinessValidationException extends Exception {

	private static final long serialVersionUID = 7534720562631033407L;

	private String messageId;
	private EnumExceptionSeverity severity = EnumExceptionSeverity.WARNING;
	private Object[] msgArgs = null;

	protected BusinessValidationException(String message, String messageId, Object... msgArgs) {
		super(message);
		this.messageId = messageId;
		this.msgArgs = msgArgs;
	}

	protected BusinessValidationException(String message, String messageId, EnumExceptionSeverity severity, Object... msgArgs) {
		super(message);
		this.messageId = messageId;
		this.severity = severity;
		this.msgArgs = msgArgs;
	}

	/**
	 * @return the msgArgs
	 */
	public Object[] getMsgArgs() {
		return msgArgs;
	}

	/**
	 * @param msgArgs
	 *            the msgArgs to set
	 */
	public void setMsgArgs(Object[] msgArgs) {
		this.msgArgs = msgArgs;
	}

	/**
	 * @return the messageId
	 */
	public String getMessageId() {
		return messageId;
	}

	/**
	 * @return the severity
	 */
	public EnumExceptionSeverity getSeverity() {
		return severity;
	}

}
