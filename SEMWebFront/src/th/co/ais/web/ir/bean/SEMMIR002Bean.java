package th.co.ais.web.ir.bean;

import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import th.co.ais.domain.ir.Mir002Srch;
import th.co.ais.web.bean.AbstractBean;
import th.co.ais.web.bean.common.PopupMultiProvinceBean;
import th.co.ais.web.bean.common.PopupMultiZoneBean;

public class SEMMIR002Bean extends AbstractBean {

	private List<SelectItem> companyList;
	private List<SelectItem> networkTypeList;
	private List<SelectItem> transferTypeList;
	private List<SelectItem> networkTypeExcelList;
	
	private Mir002Srch criteria;
	private List<Mir002Srch> resultList;
	
	private String effMY;
	
	private PopupMultiProvinceBean popupMultiProvinceBean;
	
	private boolean renderConfirm = false;
	private boolean renderLoadExcel = false;
	private String confirmLoadExcelMsg;
	private boolean renderMsgFromImport = false;
	private boolean loadExcelFlag = false;
	
	public SEMMIR002Bean(List<SelectItem> companyList, List<SelectItem> networkTypeList, List<SelectItem> transferTypeList,List<SelectItem> networkTypeExcelList) {
		this.companyList = companyList;
		this.networkTypeList = networkTypeList;
		this.transferTypeList = transferTypeList;
		this.networkTypeExcelList = networkTypeExcelList;
		
		criteria = new Mir002Srch();
	}
	
	public SEMMIR002Bean(List<SelectItem> companyList, List<SelectItem> networkTypeList, List<SelectItem> transferTypeList,List<SelectItem> networkTypeExcelList, 
			String company, String networkType, String transferType) {
		this.companyList = companyList;
		this.networkTypeList = networkTypeList;
		this.transferTypeList = transferTypeList;
		this.networkTypeExcelList = networkTypeExcelList;
		
		criteria = new Mir002Srch();
		criteria.setCompany(company);
		criteria.setNetworkType(networkType);
		criteria.setTransferType(transferType);
	}
	
	public List<SelectItem> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<SelectItem> companyList) {
		this.companyList = companyList;
	}

	public List<SelectItem> getNetworkTypeList() {
		return networkTypeList;
	}

	public void setNetworkTypeList(List<SelectItem> networkTypeList) {
		this.networkTypeList = networkTypeList;
	}

	public List<SelectItem> getTransferTypeList() {
		return transferTypeList;
	}

	public void setTransferTypeList(List<SelectItem> transferTypeList) {
		this.transferTypeList = transferTypeList;
	}

	public Mir002Srch getCriteria() {
		return criteria;
	}

	public void setCriteria(Mir002Srch criteria) {
		this.criteria = criteria;
	}

	public List<Mir002Srch> getResultList() {
		return resultList;
	}

	public void setResultList(List<Mir002Srch> resultList) {
		this.resultList = resultList;
	}

	public String getEffMY() {
		return effMY;
	}

	public void setEffMY(String effMY) {
		this.effMY = effMY;
	}

	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}

	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}
	
	public PopupMultiProvinceBean getPopupMultiProvinceBean() {														
		return (PopupMultiProvinceBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("popupMultiProvinceBean");
	}


	public void setPopupMultiProvinceBean(
			PopupMultiProvinceBean popupMultiProvinceBean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("popupMultiProvinceBean", popupMultiProvinceBean);
	}

	public List<SelectItem> getNetworkTypeExcelList() {
		return networkTypeExcelList;
	}

	public void setNetworkTypeExcelList(List<SelectItem> networkTypeExcelList) {
		this.networkTypeExcelList = networkTypeExcelList;
	}

	public boolean isRenderConfirm() {
		return renderConfirm;
	}

	public void setRenderConfirm(boolean renderConfirm) {
		this.renderConfirm = renderConfirm;
	}

	public boolean isRenderLoadExcel() {
		return renderLoadExcel;
	}

	public void setRenderLoadExcel(boolean renderLoadExcel) {
		this.renderLoadExcel = renderLoadExcel;
	}

	public String getConfirmLoadExcelMsg() {
		return confirmLoadExcelMsg;
	}

	public void setConfirmLoadExcelMsg(String confirmLoadExcelMsg) {
		this.confirmLoadExcelMsg = confirmLoadExcelMsg;
	}

	public boolean isRenderMsgFromImport() {
		return renderMsgFromImport;
	}

	public void setRenderMsgFromImport(boolean renderMsgFromImport) {
		this.renderMsgFromImport = renderMsgFromImport;
	}

	public boolean isLoadExcelFlag() {
		return loadExcelFlag;
	}

	public void setLoadExcelFlag(boolean loadExcelFlag) {
		this.loadExcelFlag = loadExcelFlag;
	}

}
