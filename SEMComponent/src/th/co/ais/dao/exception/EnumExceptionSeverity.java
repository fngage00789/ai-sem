package th.co.ais.dao.exception;

public enum EnumExceptionSeverity {
	FATAL, WARNING, WARNING_REFRESH, FATAL_REFRESH;

	public boolean isFatal() {
		return (this == FATAL || this == FATAL_REFRESH);
	}

	public boolean isWarning() {
		return (this == WARNING || this == WARNING_REFRESH);
	}

	public boolean isRefreshable() {
		return (this == WARNING_REFRESH || this == FATAL_REFRESH);
	}
}
