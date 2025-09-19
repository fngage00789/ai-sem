package th.co.ais.web.el.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.el.BgMaster;
import th.co.ais.domain.el.DepositDetail;
import th.co.ais.domain.el.Management;
import th.co.ais.domain.el.WarrantDatail;
import th.co.ais.domain.el.WarrantDetailSP;
import th.co.ais.web.bean.AbstractBean;

public class SEMMEL010Bean  extends AbstractBean implements Serializable {

	
	private static final long serialVersionUID = -168357028041134335L;
	
	private String company;
	private String electricUseType;
	private String contractNo;
	private Date contractStartDtFrom;
	private Date contractStartDtTo;
	private Date startDtFrom;
	private Date startDtTo;
	private Date endDtFrom;
	private Date endDtTo;
	private List<SelectItem> companyList;
	private List<SelectItem> electricUseTypeList;
	
	private boolean chkSelAllBgMaster;
	private boolean chkSelAllDepositDetail;
	private boolean disabledBtnExport;
	private boolean disableBtnRenewBg = true;
	private boolean disableAlertBtnRenewMsg = true;
	private List<BgMaster> bgMasterList;
	private List<DepositDetail> depositDetailList;	
	private List<Management> managementList;
	private boolean disableDelbtn = true;
	private BgMaster delBgMaster = new BgMaster();
	
	public boolean isDisabledBtnExport() {
		return disabledBtnExport;
	}
	public void setDisabledBtnExport(boolean disabledBtnExport) {
		this.disabledBtnExport = disabledBtnExport;
	}
	
	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}
	
	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}	
	public String getElectricUseType() {
		return electricUseType;
	}
	public void setElectricUseType(String electricUseType) {
		this.electricUseType = electricUseType;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public Date getContractStartDtFrom() {
		return contractStartDtFrom;
	}
	public void setContractStartDtFrom(Date contractStartDtFrom) {
		this.contractStartDtFrom = contractStartDtFrom;
	}
	public Date getContractStartDtTo() {
		return contractStartDtTo;
	}
	public void setContractStartDtTo(Date contractStartDtTo) {
		this.contractStartDtTo = contractStartDtTo;
	}
	public List<SelectItem> getCompanyList() {
		return companyList;
	}
	public void setCompanyList(List<SelectItem> companyList) {
		this.companyList = companyList;
	}
	public List<SelectItem> getElectricUseTypeList() {
		return electricUseTypeList;
	}
	public void setElectricUseTypeList(List<SelectItem> electricUseTypeList) {
		this.electricUseTypeList = electricUseTypeList;
	}
	public List<BgMaster> getBgMasterList() {
		return bgMasterList;
	}
	public void setBgMasterList(List<BgMaster> bgMasterList) {
		this.bgMasterList = bgMasterList;
	}
	public List<DepositDetail> getDepositDetailList() {
		return depositDetailList;
	}
	public void setDepositDetailList(List<DepositDetail> depositDetailList) {
		this.depositDetailList = depositDetailList;
	}
	public Date getStartDtFrom() {
		return startDtFrom;
	}
	public void setStartDtFrom(Date startDtFrom) {
		this.startDtFrom = startDtFrom;
	}
	public Date getStartDtTo() {
		return startDtTo;
	}
	public void setStartDtTo(Date startDtTo) {
		this.startDtTo = startDtTo;
	}
	public Date getEndDtFrom() {
		return endDtFrom;
	}
	public void setEndDtFrom(Date endDtFrom) {
		this.endDtFrom = endDtFrom;
	}
	public Date getEndDtTo() {
		return endDtTo;
	}
	public void setEndDtTo(Date endDtTo) {
		this.endDtTo = endDtTo;
	}
	public boolean isChkSelAllBgMaster() {
		return chkSelAllBgMaster;
	}
	public void setChkSelAllBgMaster(boolean chkSelAllBgMaster) {
		this.chkSelAllBgMaster = chkSelAllBgMaster;
	}
	public boolean isChkSelAllDepositDetail() {
		return chkSelAllDepositDetail;
	}
	public void setChkSelAllDepositDetail(boolean chkSelAllDepositDetail) {
		this.chkSelAllDepositDetail = chkSelAllDepositDetail;
	}
	public boolean isDisableBtnRenewBg() {
		return disableBtnRenewBg;
	}
	public void setDisableBtnRenewBg(boolean disableBtnRenewBg) {
		this.disableBtnRenewBg = disableBtnRenewBg;
	}
	public boolean isDisableAlertBtnRenewMsg() {
		return disableAlertBtnRenewMsg;
	}
	public void setDisableAlertBtnRenewMsg(boolean disableAlertBtnRenewMsg) {
		this.disableAlertBtnRenewMsg = disableAlertBtnRenewMsg;
	}
	public List<Management> getManagementList() {
		return managementList;
	}
	public void setManagementList(List<Management> managementList) {
		this.managementList = managementList;
	}
	public boolean isDisableDelbtn() {
		return disableDelbtn;
	}
	public void setDisableDelbtn(boolean disableDelbtn) {
		this.disableDelbtn = disableDelbtn;
	}
	public BgMaster getDelBgMaster() {
		return delBgMaster;
	}
	public void setDelBgMaster(BgMaster delBgMaster) {
		this.delBgMaster = delBgMaster;
	}
	
		
}
