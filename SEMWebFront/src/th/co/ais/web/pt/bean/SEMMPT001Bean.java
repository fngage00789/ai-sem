package th.co.ais.web.pt.bean;

import java.util.List;

import javax.faces.model.SelectItem;

import org.richfaces.model.TreeNode;

import th.co.ais.domain.common.MenuTreeSP;
import th.co.ais.domain.pt.Mpt001Edt;
import th.co.ais.domain.pt.Mpt001Srch;
import th.co.ais.domain.pt.Mpt001SrchHist;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.bean.AbstractBean;
import th.co.ais.web.bean.TreeUtilBean;

public class SEMMPT001Bean extends AbstractBean{

	private List<SelectItem> companyList;
	private List<SelectItem> regionList;
	private List<SelectItem> provinceList;
	private List<SelectItem> propertyTaxTypeList;
	private List<SelectItem> propertyTaxTypeSchList;
	
	private List<WrapperBeanObject<Mpt001Srch>> mpt001SrchList; 
	private Mpt001Srch mpt001Srch;
	
	private List<Mpt001Edt> mpt001EdtList;
	private Mpt001Edt mpt001Edt;
	
	private List<Mpt001SrchHist> mpt001SrchHistList;
	private Mpt001SrchHist mpt001SrchHist;
	
	private String contractNo;
	
	// add by ming 20101124
	private boolean chkPayGovtFlag;
	private boolean validateBtn;
	
	private boolean chkSelAll = false;
	private boolean disabledBtnExport=true;
	private boolean disableChkAll=false;
	
	//added by NEW 18/03/2015
	private TreeUtilBean treeUtilBean;
	private TreeNode rootNode = null;
	
	//added by NEW 20151030
	public boolean treeMacroFlag = false;
	public String headerTreeMacro;
	public List<WrapperBeanObject<MenuTreeSP>> menuTreeMacroList;
	
	public boolean treePicoFlag = false;
	public String headerTreePico;
	public List<WrapperBeanObject<MenuTreeSP>> menuTreePicoList;
	
	private boolean renderedOnToDoList;
	
	public boolean isChkPayGovtFlag() {
		return chkPayGovtFlag;
	}
	public void setChkPayGovtFlag(boolean chkPayGovtFlag) {
		this.chkPayGovtFlag = chkPayGovtFlag;
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
	public List<SelectItem> getProvinceList() {
		return provinceList;
	}
	public void setProvinceList(List<SelectItem> provinceList) {
		this.provinceList = provinceList;
	}
	public List<SelectItem> getPropertyTaxTypeList() {
		return propertyTaxTypeList;
	}
	public void setPropertyTaxTypeList(List<SelectItem> propertyTaxTypeList) {
		this.propertyTaxTypeList = propertyTaxTypeList;
	}
	
	public TreeUtilBean getTreeUtilBean() {
		return treeUtilBean;
	}
	public void setTreeUtilBean(TreeUtilBean treeUtilBean) {
		this.treeUtilBean = treeUtilBean;
	}
	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}
	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}
	public Mpt001Srch getMpt001Srch() {
		return mpt001Srch;
	}
	public void setMpt001Srch(Mpt001Srch mpt001Srch) {
		this.mpt001Srch = mpt001Srch;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public String getContractNo() {
		return contractNo;
	}
	public List<Mpt001Edt> getMpt001EdtList() {
		return mpt001EdtList;
	}
	public void setMpt001EdtList(List<Mpt001Edt> mpt001EdtList) {
		this.mpt001EdtList = mpt001EdtList;
	}
	public Mpt001Edt getMpt001Edt() {
		return mpt001Edt;
	}
	public void setMpt001Edt(Mpt001Edt mpt001Edt) {
		this.mpt001Edt = mpt001Edt;
	}
	public void setValidateBtn(boolean validateBtn) {
		this.validateBtn = validateBtn;
	}
	public boolean isValidateBtn() {
		return validateBtn;
	}
	public void setMpt001SrchHistList(List<Mpt001SrchHist> mpt001SrchHistList) {
		this.mpt001SrchHistList = mpt001SrchHistList;
	}
	public List<Mpt001SrchHist> getMpt001SrchHistList() {
		return mpt001SrchHistList;
	}
	public void setMpt001SrchHist(Mpt001SrchHist mpt001SrchHist) {
		this.mpt001SrchHist = mpt001SrchHist;
	}
	public Mpt001SrchHist getMpt001SrchHist() {
		return mpt001SrchHist;
	}
	public void setMpt001SrchList(List<WrapperBeanObject<Mpt001Srch>> mpt001SrchList) {
		this.mpt001SrchList = mpt001SrchList;
	}
	public List<WrapperBeanObject<Mpt001Srch>> getMpt001SrchList() {
		return mpt001SrchList;
	}
	public boolean isChkSelAll() {
		return chkSelAll;
	}
	public void setChkSelAll(boolean chkSelAll) {
		this.chkSelAll = chkSelAll;
	}
	public boolean isDisabledBtnExport() {
		return disabledBtnExport;
	}
	public void setDisabledBtnExport(boolean disabledBtnExport) {
		this.disabledBtnExport = disabledBtnExport;
	}
	public void setDisableChkAll(boolean disableChkAll) {
		this.disableChkAll = disableChkAll;
	}
	public boolean isDisableChkAll() {
		return disableChkAll;
	}
	public List<SelectItem> getPropertyTaxTypeSchList() {
		return propertyTaxTypeSchList;
	}
	public void setPropertyTaxTypeSchList(List<SelectItem> propertyTaxTypeSchList) {
		this.propertyTaxTypeSchList = propertyTaxTypeSchList;
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
	public boolean isRenderedOnToDoList() {
		return renderedOnToDoList;
	}
	public void setRenderedOnToDoList(boolean renderedOnToDoList) {
		this.renderedOnToDoList = renderedOnToDoList;
	}
	
}
