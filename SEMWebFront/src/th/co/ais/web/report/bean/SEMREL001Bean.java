package th.co.ais.web.report.bean;

import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.rpt.service.ServiceConstants;
import th.co.ais.web.report.AbstractReportBean;

public class SEMREL001Bean extends AbstractReportBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8621663925471015690L;
	
	private List<SelectItem> companyList;
	private List<SelectItem> electricUseTypeList;
	private List<SelectItem> regionList;
	private List<SelectItem> monthList;
	private List<SelectItem> yearList;
	private List<SelectItem> warrantTypeList;
	private List<SelectItem> meterDataList;
	private List<SelectItem> onServiceList;
	private List<SelectItem> periodList;
	private String period;
	private String onService;
	private String meterData;
	private String company;
	private String electricUseType;
	private String region;
	private String month;
	private String year;	
	private String reportEngine;
	private String warrantType;
	private String numMonthType;
	
	public SEMREL001Bean() {
		super(ServiceConstants.TYPE_XLS);
	}
	
	
	public List<SelectItem> getCompanyList() {
		return companyList;
	}


	public void setCompanyList(List<SelectItem> companyList) {
		this.companyList = companyList;
	}


	public List<SelectItem> getRegionList() {
		return regionList;
	}


	public void setRegionList(List<SelectItem> regionList) {
		this.regionList = regionList;
	}


	public List<SelectItem> getYearList() {
		return yearList;
	}


	public void setYearList(List<SelectItem> yearList) {
		this.yearList = yearList;
	}

	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}


	public String getRegion() {
		return region;
	}


	public void setRegion(String region) {
		this.region = region;
	}


	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}


	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}
	
	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}


	public List<SelectItem> getMonthList() {
		return monthList;
	}


	public void setMonthList(List<SelectItem> monthList) {
		this.monthList = monthList;
	}


	public String getMonth() {
		return month;
	}


	public void setMonth(String month) {
		this.month = month;
	}


	public List<SelectItem> getElectricUseTypeList() {
		return electricUseTypeList;
	}


	public void setElectricUseTypeList(List<SelectItem> electricUseTypeList) {
		this.electricUseTypeList = electricUseTypeList;
	}


	public String getElectricUseType() {
		return electricUseType;
	}


	public void setElectricUseType(String electricUseType) {
		this.electricUseType = electricUseType;
	}


	public String getReportEngine() {
		return reportEngine;
	}


	public void setReportEngine(String reportEngine) {
		this.reportEngine = reportEngine;
	}


	public List<SelectItem> getWarrantTypeList() {
		return warrantTypeList;
	}


	public void setWarrantTypeList(List<SelectItem> warrantTypeList) {
		this.warrantTypeList = warrantTypeList;
	}


	public String getWarrantType() {
		return warrantType;
	}


	public void setWarrantType(String warrantType) {
		this.warrantType = warrantType;
	}


	public List<SelectItem> getMeterDataList() {
		return meterDataList;
	}


	public void setMeterDataList(List<SelectItem> meterDataList) {
		this.meterDataList = meterDataList;
	}


	public String getMeterData() {
		return meterData;
	}


	public void setMeterData(String meterData) {
		this.meterData = meterData;
	}


	public List<SelectItem> getOnServiceList() {
		return onServiceList;
	}


	public void setOnServiceList(List<SelectItem> onServiceList) {
		this.onServiceList = onServiceList;
	}


	public String getOnService() {
		return onService;
	}


	public void setOnService(String onService) {
		this.onService = onService;
	}


	public List<SelectItem> getPeriodList() {
		return periodList;
	}


	public void setPeriodList(List<SelectItem> periodList) {
		this.periodList = periodList;
	}


	public String getPeriod() {
		return period;
	}


	public void setPeriod(String period) {
		this.period = period;
	}


	public String getNumMonthType() {
		return numMonthType;
	}


	public void setNumMonthType(String numMonthType) {
		this.numMonthType = numMonthType;
	}
	
}
