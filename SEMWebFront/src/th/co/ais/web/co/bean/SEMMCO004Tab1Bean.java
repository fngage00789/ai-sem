package th.co.ais.web.co.bean;

import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.co.ContractStatus;
import th.co.ais.domain.co.Mco001CheckAddAbleSP;
import th.co.ais.domain.co.Mco001SrchStatusSP;
import th.co.ais.domain.co.Mco004SrchStatusSP;
import th.co.ais.domain.si.Contract;
import th.co.ais.domain.si.SiteInfo;
import th.co.ais.web.bean.AbstractBean;

public class SEMMCO004Tab1Bean extends AbstractBean {

	private static final long serialVersionUID = 7164670455509692855L;
	
	private List<SelectItem> rightAmphurList;
	private List<SelectItem> provinceList;
	//Adding by mr.John from (mr.Surasit).
	private List<SelectItem> borrowOfficerList;
	private Contract contract;
	private SiteInfo siteInfo;
	private ContractStatus contractStatus;
	private List<Mco004SrchStatusSP> contractStatusHistoryList;
	private boolean disabledBtnAddContractStatusHistory;
	private boolean disabledBtnUpdateContractStatusHistory;
	private boolean renderedUpdateHistory;
	private boolean renderedDeleteHistory;
	private boolean renderedAddHistory;
	private boolean renderedEditDuty;
	private boolean renderedEditTot;
	
	
	public boolean isRenderedUpdateHistory() {
		return renderedUpdateHistory;
	}
	public void setRenderedUpdateHistory(boolean renderedUpdateHistory) {
		this.renderedUpdateHistory = renderedUpdateHistory;
	}
	public boolean isRenderedDeleteHistory() {
		return renderedDeleteHistory;
	}
	public void setRenderedDeleteHistory(boolean renderedDeleteHistory) {
		this.renderedDeleteHistory = renderedDeleteHistory;
	}
	public boolean isRenderedAddHistory() {
		return renderedAddHistory;
	}
	public void setRenderedAddHistory(boolean renderedAddHistory) {
		this.renderedAddHistory = renderedAddHistory;
	}
	public boolean isDisabledBtnAddContractStatusHistory() {
		return disabledBtnAddContractStatusHistory;
	}
	public void setDisabledBtnAddContractStatusHistory(
			boolean disabledBtnAddContractStatusHistory) {
		this.disabledBtnAddContractStatusHistory = disabledBtnAddContractStatusHistory;
	}
	public boolean isDisabledBtnUpdateContractStatusHistory() {
		return disabledBtnUpdateContractStatusHistory;
	}
	public void setDisabledBtnUpdateContractStatusHistory(
			boolean disabledBtnUpdateContractStatusHistory) {
		this.disabledBtnUpdateContractStatusHistory = disabledBtnUpdateContractStatusHistory;
	}
	public ContractStatus getContractStatus() {
		return contractStatus;
	}
	public void setContractStatus(ContractStatus contractStatus) {
		this.contractStatus = contractStatus;
	}
	public List<Mco004SrchStatusSP> getContractStatusHistoryList() {
		return contractStatusHistoryList;
	}
	public void setContractStatusHistoryList(
			List<Mco004SrchStatusSP> contractStatusHistoryList) {
		this.contractStatusHistoryList = contractStatusHistoryList;
	}
	public Contract getContract() {
		return contract;
	}
	public void setContract(Contract contract) {
		this.contract = contract;
	}
	public List<SelectItem> getRightAmphurList() {
		return rightAmphurList;
	}
	public void setRightAmphurList(List<SelectItem> rightAmphurList) {
		this.rightAmphurList = rightAmphurList;
	}
	public List<SelectItem> getProvinceList() {
		return provinceList;
	}
	public void setProvinceList(List<SelectItem> provinceList) {
		this.provinceList = provinceList;
	}
	public SiteInfo getSiteInfo() {
		return siteInfo;
	}
	public void setSiteInfo(SiteInfo siteInfo) {
		this.siteInfo = siteInfo;
	}
	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}
	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}
	public boolean isRenderedEditDuty() {
		return renderedEditDuty;
	}
	public void setRenderedEditDuty(boolean renderedEditDuty) {
		this.renderedEditDuty = renderedEditDuty;
	}
	public boolean isRenderedEditTot() {
		return renderedEditTot;
	}
	public void setRenderedEditTot(boolean renderedEditTot) {
		this.renderedEditTot = renderedEditTot;
	}
	public List<SelectItem> getBorrowOfficerList() {
		return borrowOfficerList;
	}
	public void setBorrowOfficerList(List<SelectItem> borrowOfficerList) {
		this.borrowOfficerList = borrowOfficerList;
	}
	
	
}
