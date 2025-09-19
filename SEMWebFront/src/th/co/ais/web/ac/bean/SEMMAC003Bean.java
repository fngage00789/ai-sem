package th.co.ais.web.ac.bean;

import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.ac.Mac003File;
import th.co.ais.domain.ac.Mac003Srch;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.bean.AbstractBean;

public class SEMMAC003Bean extends AbstractBean{

	private List<SelectItem> companyList;
	private List<SelectItem> errorStatusList;
	
	private List<WrapperBeanObject<Mac003Srch>> mac003SrchList;
	private Mac003Srch mac003Srch;
	private Mac003File mac003File;
	
	private boolean chkSelAll = false;
	private boolean disableBtnUpdateStatus;
	
	private String tmpStatus;
	private String tmpRemark;
	
	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}
	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}
	public List<SelectItem> getCompanyList() {
		return companyList;
	}
	public void setCompanyList(List<SelectItem> companyList) {
		this.companyList = companyList;
	}
	public List<WrapperBeanObject<Mac003Srch>> getMac003SrchList() {
		return mac003SrchList;
	}
	public void setMac003SrchList(List<WrapperBeanObject<Mac003Srch>> mac003SrchList) {
		this.mac003SrchList = mac003SrchList;
	}
	public Mac003Srch getMac003Srch() {
		return mac003Srch;
	}
	public void setMac003Srch(Mac003Srch mac003Srch) {
		this.mac003Srch = mac003Srch;
	}
	public void setErrorStatusList(List<SelectItem> errorStatusList) {
		this.errorStatusList = errorStatusList;
	}
	public List<SelectItem> getErrorStatusList() {
		return errorStatusList;
	}
	public void setChkSelAll(boolean chkSelAll) {
		this.chkSelAll = chkSelAll;
	}
	public boolean isChkSelAll() {
		return chkSelAll;
	}
	public void setDisableBtnUpdateStatus(boolean disableBtnUpdateStatus) {
		this.disableBtnUpdateStatus = disableBtnUpdateStatus;
	}
	public boolean isDisableBtnUpdateStatus() {
		return disableBtnUpdateStatus;
	}
	public String getTmpStatus() {
		return tmpStatus;
	}
	public void setTmpStatus(String tmpStatus) {
		this.tmpStatus = tmpStatus;
	}
	public String getTmpRemark() {
		return tmpRemark;
	}
	public void setTmpRemark(String tmpRemark) {
		this.tmpRemark = tmpRemark;
	}
	public void setMac003File(Mac003File mac003File) {
		this.mac003File = mac003File;
	}
	public Mac003File getMac003File() {
		return mac003File;
	}
}
