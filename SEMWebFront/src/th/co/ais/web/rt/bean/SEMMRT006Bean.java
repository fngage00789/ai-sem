package th.co.ais.web.rt.bean;

import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import org.richfaces.model.TreeNode;

import th.co.ais.domain.common.MenuTreeSP;
import th.co.ais.domain.gm.Attachment;
import th.co.ais.domain.rt.Mrt006DepositStatusDDL;
import th.co.ais.domain.rt.Mrt006Srch;
import th.co.ais.domain.rt.ReturnDeposit;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.bean.AbstractBean;
import th.co.ais.web.bean.TreeUtilBean;

public class SEMMRT006Bean extends AbstractBean {

	private static final long serialVersionUID = 8353105601284980701L;

	private List<SelectItem> companyList;
	private List<SelectItem> regionList;
	private List<SelectItem> siteTypeList;
	private List<SelectItem> depositTypeList;
	private List<SelectItem> bgBankList;
	private List<SelectItem> reqTypeList;
	private List<SelectItem> expenseTypeList;
	private List<SelectItem> returnDpsStatusList;
	private List<SelectItem> returnDpsStatus2List;
	
	private Mrt006Srch criteria;
	private List<Mrt006Srch> resultList;
	
	private String popupRole;
	private String popupMode;
	
	private ReturnDeposit returnDpst;
	private String reDpstContractNo;
	private Double reDpstAmt;
	private Double reDpstRentAmt;
	private Double reDpstRentRetAmt;
	private Double reDpstReBalanceAmt;
	private String reDpstReceiptNo;
	private String reDpstTaxInvoiceNo;
	private String bgNo;
	private String bgBank;
	private Date bgStartDt;
	private Date bgEndDt;
	
	// added by.. YUT
	private boolean renderedOnToDoList = false;
	
	// added by.. NEW 17/03/2015
	private TreeUtilBean treeUtilBean;
	private TreeNode rootNode = null;
	
	//data table attachment
	private List<Attachment> attachmentList;
	//Delete attachment
	private Attachment tmpAttachment;
	private Attachment attachment;
	private String refId;
	
	private boolean disDpsReturnAmt;
	private boolean disBtnSave;
	private boolean disReturnDpstStatus;
	private String mode;
	
	//added by NEW 20151030
	public boolean treeMacroFlag = false;
	public String headerTreeMacro;
	public List<WrapperBeanObject<MenuTreeSP>> menuTreeMacroList;
	public Mrt006DepositStatusDDL depositStatus;
	
	public boolean treePicoFlag = false;
	public String headerTreePico;
	public List<WrapperBeanObject<MenuTreeSP>> menuTreePicoList;
	
	public List<SelectItem> getReturnDpsStatus2List() {
		return returnDpsStatus2List;
	}
	public void setReturnDpsStatus2List(List<SelectItem> returnDpsStatus2List) {
		this.returnDpsStatus2List = returnDpsStatus2List;
	}
	public boolean isDisReturnDpstStatus() {
		return disReturnDpstStatus;
	}
	public void setDisReturnDpstStatus(boolean disReturnDpstStatus) {
		this.disReturnDpstStatus = disReturnDpstStatus;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getBgBank() {
		return bgBank;
	}
	public void setBgBank(String bgBank) {
		this.bgBank = bgBank;
	}
	public Date getBgStartDt() {
		return bgStartDt;
	}
	public void setBgStartDt(Date bgStartDt) {
		this.bgStartDt = bgStartDt;
	}
	public Date getBgEndDt() {
		return bgEndDt;
	}
	public void setBgEndDt(Date bgEndDt) {
		this.bgEndDt = bgEndDt;
	}
	public String getBgNo() {
		return bgNo;
	}
	public void setBgNo(String bgNo) {
		this.bgNo = bgNo;
	}
	public boolean isDisBtnSave() {
		return disBtnSave;
	}
	public void setDisBtnSave(boolean disBtnSave) {
		this.disBtnSave = disBtnSave;
	}
	public Attachment getAttachment() {
		if(attachment == null)
			attachment = new  Attachment();
		return attachment;
	}
	public void setAttachment(Attachment attachment) {
		this.attachment = attachment;
	}
	public Attachment getTmpAttachment() {
		if(tmpAttachment == null)
			tmpAttachment = new Attachment();
		return tmpAttachment;
	}

	public void setTmpAttachment(Attachment tmpAttachment) {
		this.tmpAttachment = tmpAttachment;
	}

	public List<Attachment> getAttachmentList() {
		return attachmentList;
	}

	public void setAttachmentList(List<Attachment> attachmentList) {
		this.attachmentList = attachmentList;
	}

	public String getRefId() {
		return refId;
	}

	public void setRefId(String refId) {
		this.refId = refId;
	}

	public boolean isDisDpsReturnAmt() {
		return disDpsReturnAmt;
	}

	public void setDisDpsReturnAmt(boolean disDpsReturnAmt) {
		this.disDpsReturnAmt = disDpsReturnAmt;
	}

	public String getPopupMode() {
		return popupMode;
	}

	public void setPopupMode(String popupMode) {
		this.popupMode = popupMode;
	}

	public String getPopupRole() {
		return popupRole;
	}

	public void setPopupRole(String popupRole) {
		this.popupRole = popupRole;
	}

	public String getReDpstTaxInvoiceNo() {
		return reDpstTaxInvoiceNo;
	}

	public void setReDpstTaxInvoiceNo(String reDpstTaxInvoiceNo) {
		this.reDpstTaxInvoiceNo = reDpstTaxInvoiceNo;
	}

	public String getReDpstReceiptNo() {
		return reDpstReceiptNo;
	}

	public void setReDpstReceiptNo(String reDpstReceiptNo) {
		this.reDpstReceiptNo = reDpstReceiptNo;
	}

	public Double getReDpstReBalanceAmt() {
		return reDpstReBalanceAmt;
	}

	public void setReDpstReBalanceAmt(Double reDpstReBalanceAmt) {
		this.reDpstReBalanceAmt = reDpstReBalanceAmt;
	}

	public Double getReDpstRentRetAmt() {
		return reDpstRentRetAmt;
	}

	public void setReDpstRentRetAmt(Double reDpstRentRetAmt) {
		this.reDpstRentRetAmt = reDpstRentRetAmt;
	}

	public Double getReDpstRentAmt() {
		return reDpstRentAmt;
	}

	public void setReDpstRentAmt(Double reDpstRentAmt) {
		this.reDpstRentAmt = reDpstRentAmt;
	}

	public Double getReDpstAmt() {
		return reDpstAmt;
	}

	public void setReDpstAmt(Double reDpstAmt) {
		this.reDpstAmt = reDpstAmt;
	}

	public String getReDpstContractNo() {
		return reDpstContractNo;
	}

	public void setReDpstContractNo(String reDpstContractNo) {
		this.reDpstContractNo = reDpstContractNo;
	}

	public ReturnDeposit getReturnDpst() {
		return returnDpst;
	}

	public void setReturnDpst(ReturnDeposit returnDpst) {
		this.returnDpst = returnDpst;
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

	public List<SelectItem> getSiteTypeList() {
		return siteTypeList;
	}

	public void setSiteTypeList(List<SelectItem> siteTypeList) {
		this.siteTypeList = siteTypeList;
	}

	public List<SelectItem> getDepositTypeList() {
		return depositTypeList;
	}

	public void setDepositTypeList(List<SelectItem> depositTypeList) {
		this.depositTypeList = depositTypeList;
	}

	public List<SelectItem> getBgBankList() {
		return bgBankList;
	}

	public void setBgBankList(List<SelectItem> bgBankList) {
		this.bgBankList = bgBankList;
	}

	public List<SelectItem> getReqTypeList() {
		return reqTypeList;
	}

	public void setReqTypeList(List<SelectItem> reqTypeList) {
		this.reqTypeList = reqTypeList;
	}

	public List<SelectItem> getExpenseTypeList() {
		return expenseTypeList;
	}

	public void setExpenseTypeList(List<SelectItem> expenseTypeList) {
		this.expenseTypeList = expenseTypeList;
	}

	public List<SelectItem> getReturnDpsStatusList() {
		return returnDpsStatusList;
	}

	public void setReturnDpsStatusList(List<SelectItem> returnDpsStatusList) {
		this.returnDpsStatusList = returnDpsStatusList;
	}

	public Mrt006Srch getCriteria() {
		return criteria;
	}

	public void setCriteria(Mrt006Srch criteria) {
		this.criteria = criteria;
	}

	public List<Mrt006Srch> getResultList() {
		return resultList;
	}

	public void setResultList(List<Mrt006Srch> resultList) {
		this.resultList = resultList;
	}

	public boolean isRenderedOnToDoList() {
		return renderedOnToDoList;
	}
	public void setRenderedOnToDoList(boolean renderedOnToDoList) {
		this.renderedOnToDoList = renderedOnToDoList;
	}
	public TreeUtilBean getTreeUtilBean() {
		return treeUtilBean;
	}
	public void setTreeUtilBean(TreeUtilBean treeUtilBean) {
		this.treeUtilBean = treeUtilBean;
	}
	
	public TreeNode getRootNode() {
		return rootNode;
	}
	public void setRootNode(TreeNode rootNode) {
		this.rootNode = rootNode;
	}
	
	public boolean isTreeMacroFlag() {
		return treeMacroFlag;
	}
	public void setTreeMacroFlag(boolean treeMacroFlag) {
		this.treeMacroFlag = treeMacroFlag;
	}
	public String getHeaderTreeMacro() {
		return headerTreeMacro;
	}
	public void setHeaderTreeMacro(String headerTreeMacro) {
		this.headerTreeMacro = headerTreeMacro;
	}
	public List<WrapperBeanObject<MenuTreeSP>> getMenuTreeMacroList() {
		return menuTreeMacroList;
	}
	public void setMenuTreeMacroList(
			List<WrapperBeanObject<MenuTreeSP>> menuTreeMacroList) {
		this.menuTreeMacroList = menuTreeMacroList;
	}
	public boolean isTreePicoFlag() {
		return treePicoFlag;
	}
	public void setTreePicoFlag(boolean treePicoFlag) {
		this.treePicoFlag = treePicoFlag;
	}
	public String getHeaderTreePico() {
		return headerTreePico;
	}
	public void setHeaderTreePico(String headerTreePico) {
		this.headerTreePico = headerTreePico;
	}
	public List<WrapperBeanObject<MenuTreeSP>> getMenuTreePicoList() {
		return menuTreePicoList;
	}
	public void setMenuTreePicoList(
			List<WrapperBeanObject<MenuTreeSP>> menuTreePicoList) {
		this.menuTreePicoList = menuTreePicoList;
	}
	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}

	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}
	public Mrt006DepositStatusDDL getDepositStatus() {
		return depositStatus;
	}
	public void setDepositStatus(Mrt006DepositStatusDDL depositStatus) {
		this.depositStatus = depositStatus;
	}

}
