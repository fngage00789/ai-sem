package th.co.ais.rpt.service;

import th.co.ais.rpt.domain.SEMECO001Domain;
import th.co.ais.rpt.exception.ReportServiceException;
import th.co.ais.rpt.parameter.ReportParameter;

public interface IReportServiceHelper {
	public String export(String reportServiceName, String paramXML, String exportType, String reportName) throws ReportServiceException;
	public String export(String reportServiceName, ReportParameter param, String exportType, String reportName) throws ReportServiceException;
	public SEMECO001Domain export(String reportServiceName, ReportParameter param) throws ReportServiceException;
	public byte[] view(String reportServiceName, ReportParameter param, String exportType) throws ReportServiceException;
	public String genParamXMl(String reportServiceName, ReportParameter reportParameter) throws ReportServiceException;
	public String export(String reportServiceName, ReportParameter param,Object obj, String exportType, String coverName) throws ReportServiceException;;
}
