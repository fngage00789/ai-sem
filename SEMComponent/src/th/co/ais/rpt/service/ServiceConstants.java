package th.co.ais.rpt.service;

import java.util.Date;

public interface ServiceConstants {
	public static final String PRIMARY_CONTEXT_ID = "businessBeanFactory";
	public static final String BEAN_REPORT_SERVICE = "ReportService";
	public static final String BEAN_REPORT_DAO = "ReportDao";
	public static final String BEAN_JASPER = "Jasper";
	public static final String BEAN_REPORT_PARAMETER_MARSHALLER = "ReportParameterMarshaller";
	public static final String TYPE_PDF = "pdf";
	public static final String TYPE_HTML = "html";
	public static final String TYPE_XLS = "xls";
	public static final String TYPE_CSV = "csv";
	public static final String TYPE_TEXT = "txt";
	public static final String TYPE_DOC= "doc";
	public static final String TYPE_ODT= "odt";
	public static final String TYPE_ZIP = "zip";
	public static final String STATUS = "status";
	public static final String STATUS_SUCCESS = "status_success";
	public static final String STATUS_ERROR = "status_error";
	public static final String ERROR_MESSAGE = "error_message";
	public static final String ERROR_EXCEPTION = "error_exception";
	
	public static final String REPORT_STATUS_CODE_WAITING = "W";
	public static final String REPORT_STATUS_CODE_RUNNING = "R";
	public static final String REPORT_STATUS_CODE_SUCCESS = "S"; 
	public static final String REPORT_STATUS_CODE_FAIL = "F";
	public static final String REPORT_STATUS_CODE_CANCEL = "C";
	
	public static final String REPORT_STATUS_DESC_WAITING = "Waiting";
	public static final String REPORT_STATUS_DESC_RUNNING = "Running";
	public static final String REPORT_STATUS_DESC_SUCCESS = "Success"; 
	public static final String REPORT_STATUS_DESC_FAIL = "Fail";
	public static final String REPORT_STATUS_DESC_CANCEL = "Cancel";
	
	public static final String DATA_INPUT_STREAM = "DataInputStream";

	public static final int DEFAULT_TIME_DURATION = 90;
	
	public static final String TEMPSTORE_PROJECT_DIRECTORY = "SEMProject";
	public static final String REPORT_ENGINE_JASPER = "Jasper";
	public static final String REPORT_ENGINE_DOCMOSIS = "Docmosis";
}
