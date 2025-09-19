package th.co.ais.web.ir.bean;

import java.util.List;

import javax.faces.model.SelectItem;

import org.richfaces.model.TreeNode;

import th.co.ais.domain.common.MenuTreeSP;
import th.co.ais.domain.ir.Mir001Srch;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.bean.AbstractBean;
import th.co.ais.web.bean.TreeUtilBean;

public class SEMMIR001Bean extends AbstractBean {

	private static final long serialVersionUID = 7189955778890548904L;
	
	private List<SelectItem> companyList;
	private List<SelectItem> networkTypeList;
	private List<SelectItem> transferTypeList;
	
	private Mir001Srch criteria;
	private List<Mir001Srch> resultList;
	
	private String effMY;
	
	// added by.. YUT
	private boolean renderedOnToDoList = false;
	
	// added by NEW 18/03/2015
	private TreeUtilBean treeUtilBean;
	private List<SelectItem> regionList;
	private TreeNode rootNode = null;
	
	//added by NEW 20151030
	public boolean treeMacroFlag = false;
	public String headerTreeMacro;
	public List<WrapperBeanObject<MenuTreeSP>> menuTreeMacroList;
	
	public boolean treePicoFlag = false;
	public String headerTreePico;
	public List<WrapperBeanObject<MenuTreeSP>> menuTreePicoList;
	
	public SEMMIR001Bean(List<SelectItem> companyList, List<SelectItem> networkType, List<SelectItem> transferTypeList) {
		this.companyList = companyList;
		this.networkTypeList = networkType;
		this.transferTypeList = transferTypeList;
		
		criteria = new Mir001Srch();
	}

	public SEMMIR001Bean() {
		// TODO Auto-generated constructor stub
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

	public Mir001Srch getCriteria() {
		return criteria;
	}

	public void setCriteria(Mir001Srch criteria) {
		this.criteria = criteria;
	}

	public List<Mir001Srch> getResultList() {
		return resultList;
	}

	public void setResultList(List<Mir001Srch> resultList) {
		this.resultList = resultList;
	}

	public String getEffMY() {
		return effMY;
	}

	public void setEffMY(String effMY) {
		this.effMY = effMY;
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

	public List<SelectItem> getRegionList() {
		return regionList;
	}

	public void setRegionList(List<SelectItem> regionList) {
		this.regionList = regionList;
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

}
