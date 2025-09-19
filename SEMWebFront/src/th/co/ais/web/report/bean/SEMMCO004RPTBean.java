package th.co.ais.web.report.bean;

import java.util.List;

//import com.arjuna.ats.internal.jdbc.drivers.modifiers.list;

import th.co.ais.domain.co.Mco004SrchSP;
import th.co.ais.rpt.service.ServiceConstants;
import th.co.ais.web.report.AbstractReportBean;

public class SEMMCO004RPTBean extends AbstractReportBean {

	private Mco004SrchSP subRentInfo;
	private String siteInfoId;
	private List<Mco004SrchSP> subRentInfoList;
	
	public SEMMCO004RPTBean() {
		super(ServiceConstants.TYPE_DOC);
	}
	
	public Mco004SrchSP getSubRentInfo() {
		return subRentInfo;
	}

	public void setSubRentInfo(Mco004SrchSP subRentInfo) {
		this.subRentInfo = subRentInfo;
	}

	@Override
	public int getRowPerPage() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setRowPerPage(int rowPerPage) {
		// TODO Auto-generated method stub

	}

	public String getSiteInfoId() {
		return siteInfoId;
	}

	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}

	public List<Mco004SrchSP> getSubRentInfoList() {
		return subRentInfoList;
	}

	public void setSubRentInfoList(List<Mco004SrchSP> subRentInfoList) {
		this.subRentInfoList = subRentInfoList;
	}

}
