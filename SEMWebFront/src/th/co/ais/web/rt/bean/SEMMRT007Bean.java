package th.co.ais.web.rt.bean;

import java.util.List;

import javax.faces.model.SelectItem;

import org.richfaces.model.TreeNode;

import th.co.ais.domain.common.MenuTreeSP;
import th.co.ais.domain.rt.Mrt003ExpLetter;
import th.co.ais.domain.rt.Mrt007Srch;
import th.co.ais.domain.rt.Mrt007UpdateDocSP;
import th.co.ais.domain.rt.RentalClrRec;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.bean.AbstractBean;
import th.co.ais.web.bean.TreeUtilBean;

public class SEMMRT007Bean extends AbstractBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1573746292449280723L;
	
	private List<SelectItem> companyList;
	private List<SelectItem> regionList;
	private List<SelectItem> expenseTypeList;
	private List<SelectItem> paymentTypeList;
	private List<SelectItem> clrReceiptStatusList;
	private List<SelectItem> clrReceiptStatusList2;
	private List<SelectItem> amphurList;
	private List<SelectItem> provinceList;
	private List<SelectItem> moduleTypeList;
	
	private Mrt007Srch criteria;
	private List<WrapperBeanObject<Mrt007Srch>> resultList;
	
	private RentalClrRec rentalClrRec;
	private String rentClrRecIdStr;

	private String currentCompany;
	private boolean disBtnExport;
	private boolean disBtn;
	private boolean chkSelAll = false;
	private boolean popupOpen = true;
	
	
	// added by.. YUT
	private boolean renderedOnToDoList = false;
	
	// added by.. NEW 17/03/2015
	private TreeUtilBean treeUtilBean;
	private TreeNode rootNode = null;
	
	//added by NEW 20151030
	public boolean treeMacroFlag = false;
	public String headerTreeMacro;
	public List<WrapperBeanObject<MenuTreeSP>> menuTreeMacroList;
	
	public boolean treePicoFlag = false;
	public String headerTreePico;
	public List<WrapperBeanObject<MenuTreeSP>> menuTreePicoList;
	
	private boolean disabledBtnEmail;
	private boolean disabledBtnSms;
	private boolean displayReportFlag;
	private boolean exportFlagRemark;
	private boolean displayShowExcel;
	private boolean disabledBtnOth;
	private boolean disabledBtnNotClr;
	private boolean disabledBtnClr;
	private boolean displayReportDataFlag;
	
	private List<Mrt003ExpLetter> expLetterList;
	private List<Mrt007Srch> expDataList;
	//added by NEW 2019/01/11
	private Mrt007UpdateDocSP updateDocSP;
	
	private String rowIdTmp;
	private Mrt007Srch notClearRecriptSP;
	
	private List<SelectItem> reqTypeList;
	
	private List<SelectItem> jobTypeList;
	
	public List<SelectItem> getClrReceiptStatusList2() {
		return clrReceiptStatusList2;
	}
	public void setClrReceiptStatusList2(List<SelectItem> clrReceiptStatusList2) {
		this.clrReceiptStatusList2 = clrReceiptStatusList2;
	}
	public String getCurrentCompany() {
		return currentCompany;
	}
	public void setCurrentCompany(String currentCompany) {
		this.currentCompany = currentCompany;
	}
	public boolean isChkSelAll() {
		return chkSelAll;
	}
	public void setChkSelAll(boolean chkSelAll) {
		this.chkSelAll = chkSelAll;
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
	public List<SelectItem> getExpenseTypeList() {
		return expenseTypeList;
	}
	public void setExpenseTypeList(List<SelectItem> expenseTypeList) {
		this.expenseTypeList = expenseTypeList;
	}
	public List<SelectItem> getPaymentTypeList() {
		return paymentTypeList;
	}
	public void setPaymentTypeList(List<SelectItem> paymentTypeList) {
		this.paymentTypeList = paymentTypeList;
	}
	public List<SelectItem> getClrReceiptStatusList() {
		return clrReceiptStatusList;
	}
	public void setClrReceiptStatusList(List<SelectItem> clrReceiptStatusList) {
		this.clrReceiptStatusList = clrReceiptStatusList;
	}
	public List<SelectItem> getAmphurList() {
		return amphurList;
	}
	public void setAmphurList(List<SelectItem> amphurList) {
		this.amphurList = amphurList;
	}
	public List<SelectItem> getProvinceList() {
		return provinceList;
	}
	public void setProvinceList(List<SelectItem> provinceList) {
		this.provinceList = provinceList;
	}
	public List<WrapperBeanObject<Mrt007Srch>> getResultList() {
		return resultList;
	}
	public void setResultList(List<WrapperBeanObject<Mrt007Srch>> resultList) {
		this.resultList = resultList;
	}
	public List<SelectItem> getModuleTypeList() {
		return moduleTypeList;
	}
	public void setModuleTypeList(List<SelectItem> moduleTypeList) {
		this.moduleTypeList = moduleTypeList;
	}
	public Mrt007Srch getCriteria() {
		return criteria;
	}
	public void setCriteria(Mrt007Srch criteria) {
		this.criteria = criteria;
	}
	public RentalClrRec getRentalClrRec() {
		return rentalClrRec;
	}
	public void setRentalClrRec(RentalClrRec rentalClrRec) {
		this.rentalClrRec = rentalClrRec;
	}
	public boolean isPopupOpen() {
		return popupOpen;
	}
	public void setPopupOpen(boolean popupOpen) {
		this.popupOpen = popupOpen;
	}
	public String getRentClrRecIdStr() {
		return rentClrRecIdStr;
	}
	public void setRentClrRecIdStr(String rentClrRecIdStr) {
		this.rentClrRecIdStr = rentClrRecIdStr;
	}
	public boolean isDisBtnExport() {
		return disBtnExport;
	}
	public void setDisBtnExport(boolean disBtnExport) {
		this.disBtnExport = disBtnExport;
	}
	public boolean isDisBtn() {
		return disBtn;
	}
	public void setDisBtn(boolean disBtn) {
		this.disBtn = disBtn;
	}
	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}
	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
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
	public Mrt007UpdateDocSP getUpdateDocSP() {
		return updateDocSP;
	}
	public void setUpdateDocSP(Mrt007UpdateDocSP updateDocSP) {
		this.updateDocSP = updateDocSP;
	}
	public boolean isDisabledBtnEmail() {
		return disabledBtnEmail;
	}
	public void setDisabledBtnEmail(boolean disabledBtnEmail) {
		this.disabledBtnEmail = disabledBtnEmail;
	}
	public boolean isDisabledBtnSms() {
		return disabledBtnSms;
	}
	public void setDisabledBtnSms(boolean disabledBtnSms) {
		this.disabledBtnSms = disabledBtnSms;
	}
	public boolean isDisplayReportFlag() {
		return displayReportFlag;
	}
	public void setDisplayReportFlag(boolean displayReportFlag) {
		this.displayReportFlag = displayReportFlag;
	}
	public boolean isExportFlagRemark() {
		return exportFlagRemark;
	}
	public void setExportFlagRemark(boolean exportFlagRemark) {
		this.exportFlagRemark = exportFlagRemark;
	}
	public boolean isDisplayShowExcel() {
		return displayShowExcel;
	}
	public void setDisplayShowExcel(boolean displayShowExcel) {
		this.displayShowExcel = displayShowExcel;
	}
	public List<Mrt003ExpLetter> getExpLetterList() {
		return expLetterList;
	}
	public void setExpLetterList(List<Mrt003ExpLetter> expLetterList) {
		this.expLetterList = expLetterList;
	}
	public boolean isDisabledBtnOth() {
		return disabledBtnOth;
	}
	public void setDisabledBtnOth(boolean disabledBtnOth) {
		this.disabledBtnOth = disabledBtnOth;
	}
	public boolean isDisabledBtnNotClr() {
		return disabledBtnNotClr;
	}
	public void setDisabledBtnNotClr(boolean disabledBtnNotClr) {
		this.disabledBtnNotClr = disabledBtnNotClr;
	}
	public boolean isDisabledBtnClr() {
		return disabledBtnClr;
	}
	public void setDisabledBtnClr(boolean disabledBtnClr) {
		this.disabledBtnClr = disabledBtnClr;
	}
	public Mrt007Srch getNotClearRecriptSP() {
		return notClearRecriptSP;
	}
	public void setNotClearRecriptSP(Mrt007Srch notClearRecriptSP) {
		this.notClearRecriptSP = notClearRecriptSP;
	}
	public String getRowIdTmp() {
		return rowIdTmp;
	}
	public void setRowIdTmp(String rowIdTmp) {
		this.rowIdTmp = rowIdTmp;
	}
	public List<SelectItem> getReqTypeList() {
		return reqTypeList;
	}
	public void setReqTypeList(List<SelectItem> reqTypeList) {
		this.reqTypeList = reqTypeList;
	}
	public boolean isDisplayReportDataFlag() {
		return displayReportDataFlag;
	}
	public void setDisplayReportDataFlag(boolean displayReportDataFlag) {
		this.displayReportDataFlag = displayReportDataFlag;
	}
	public List<Mrt007Srch> getExpDataList() {
		return expDataList;
	}
	public void setExpDataList(List<Mrt007Srch> expDataList) {
		this.expDataList = expDataList;
	}
	public List<SelectItem> getJobTypeList() {
		return jobTypeList;
	}
	public void setJobTypeList(List<SelectItem> jobTypeList) {
		this.jobTypeList = jobTypeList;
	}
	
}
