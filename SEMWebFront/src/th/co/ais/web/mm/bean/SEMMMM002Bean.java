package th.co.ais.web.mm.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.richfaces.model.TreeNode;

import th.co.ais.domain.common.MenuTreeSP;
import th.co.ais.domain.mm.ItemResultSP;
import th.co.ais.domain.mm.Mmm001ContractSP;
import th.co.ais.domain.mm.Mmm001VendorMasterSP;
import th.co.ais.domain.mm.Mmm001VendorSP;
import th.co.ais.domain.mm.Mmm002ContractSP;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.bean.AbstractBean;

public class SEMMMM002Bean extends AbstractBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 655138060286620545L;
	
	private List<SelectItem> companyList;
	private List<SelectItem> expenseTypeList;
	private List<SelectItem> bankList;
	private List<SelectItem> statusList;
	
	private List<SelectItem> vendorStatusList;
	private List<SelectItem> bookbankStatusList;
	private List<SelectItem> payeeStatusList;
	private List<SelectItem> bookbankPayeeStatusList;
	
	private List<SelectItem> tambolList;
	private List<SelectItem> amphurList;
	private List<SelectItem> provinceList;
	private List<SelectItem> regionList;
	
	private Mmm001VendorMasterSP criteria;
//	private List<WrapperBeanObject<Mmm002ContractSP>> vendorMasterResultList;
	private MenuTreeSP criteriaToDoList;
	private List<WrapperBeanObject<Mmm001VendorMasterSP>> vendorMasterResultList;
	private List<WrapperBeanObject<Mmm001VendorMasterSP>> vendorMasterRejectList;
	private List<WrapperBeanObject<MenuTreeSP>> vendorSelectedTeamList;
	
	
	private String selectedRowIndex;
	private boolean chkSelAll;
	
	private boolean chkPicoType;
	
	
	// enabled/disabled
	private boolean disableBtnApproveVendor = true;
	private boolean disableBtnRejectVendor = true;
	private boolean disableBtnSendVendorToMNG2 = true;
	private boolean disableBtnMNG2ApproveVendor = true;
	private boolean disableBtnMNG2RejectVendor = true;
	
	private boolean disableBtnApproveBookbank = true;
	private boolean disableBtnRejectBookbank = true;
	private boolean disableBtnSendBookbankToMNG2 = true;
	private boolean disableBtnMNG2ApproveBookbank = true;
	private boolean disableBtnMNG2RejectBookbank = true;
	
	private boolean disableBtnApprovePayee = true;
	private boolean disableBtnRejectPayee = true;
	private boolean disableBtnSendPayeeToMNG2 = true;
	private boolean disableBtnMNG2ApprovePayee = true;
	private boolean disableBtnMNG2RejectPayee = true;
	
	private boolean disableBtnApprovePayeeBookbank = true;
	private boolean disableBtnRejectPayeeBookbank = true;
	private boolean disableBtnSendPayeeBookbankToMNG2 = true;
	private boolean disableBtnMNG2ApprovePayeeBookbank = true;
	private boolean disableBtnMNG2RejectPayeeBookbank = true;
	
	
	//added by NEW 02/05/2017
	private ArrayList selectIdList;
	private String actionType;
	private String flowStatus;
	private String rejectRemark;
	
	//added by new 04/05/2017
	private TreeNode rootNode = null;
	private List<MenuTreeSP> menuTreeList;
	public List<WrapperBeanObject<MenuTreeSP>> menuTreeVendorList;
	public List<WrapperBeanObject<MenuTreeSP>> menuTreeVendorBookbankList;
	public List<WrapperBeanObject<MenuTreeSP>> menuTreePayeeList;
	public List<WrapperBeanObject<MenuTreeSP>> menuTreePayeeBookbankList;
	public List<WrapperBeanObject<MenuTreeSP>> menuTreeAbnormalList;
	public List<WrapperBeanObject<MenuTreeSP>> menuTreeCreateByList;
	private boolean renderedTodoRejectButton;
	
	private String paramUrl;
	private String paramMenuGroup;
	
	private List<SelectItem> teamList;
	
	private  String totalSumVendor;
	private  String totalSumVendorBookbank;
	private  String totalSumPayee;
	private  String totalSumPayeeBookbank;
	private  String totalSumAbnormal;
	private  String totalSumCreateBy;
	
	private Mmm001VendorSP vendorInfo;
	private List<WrapperBeanObject<Mmm001VendorMasterSP>> convertVendorResultList;
	private String todoFlag;
	
	//added by NEW 20170724
	private List<SelectItem> bookbankPayeeFlowStatusList;
	private boolean chkVendorType;
	private boolean chkPayeeType;
	private List<SelectItem> blockStatusList;
	private List<SelectItem> blackListStatusList;
	private List<SelectItem> vendorFlowStatusList;
	private List<SelectItem> payeeFlowStatusList;
	private List<SelectItem> bookbankFlowStatusList;
	private String actionBtnType;
	
	//added by NEW 20170807
	private boolean renderedBtnApproveVendor = false;
	private boolean renderedBtnRejectVendor = false;
	private boolean renderedBtnSendVendorToMNG2 = false;
	private boolean renderedBtnMNG2ApproveVendor = false;
	private boolean renderedBtnMNG2RejectVendor = false;
	
	private boolean renderedBtnApproveBookbank = false;
	private boolean renderedBtnRejectBookbank = false;
	private boolean renderedBtnSendBookbankToMNG2 = false;
	private boolean renderedBtnMNG2ApproveBookbank = false;
	private boolean renderedBtnMNG2RejectBookbank = false;
	
	private boolean renderedBtnApprovePayee = false;
	private boolean renderedBtnRejectPayee = false;
	private boolean renderedBtnSendPayeeToMNG2 = false;
	private boolean renderedBtnMNG2ApprovePayee = false;
	private boolean renderedBtnMNG2RejectPayee = false;
	
	private boolean renderedBtnApprovePayeeBookbank = false;
	private boolean renderedBtnRejectPayeeBookbank = false;
	private boolean renderedBtnSendPayeeBookbankToMNG2 = false;
	private boolean renderedBtnMNG2ApprovePayeeBookbank = false;
	private boolean renderedBtnMNG2RejectPayeeBookbank = false;
	
	private String remarkSapMSG;
	
	private String navProgramBack;
	
	private String renderedMsgConfirm;
	
	private ItemResultSP retResultObj;
	
	private boolean renderedBtnCloseVendor = false;
	private boolean renderedBtnOKVendor = false;
	private boolean renderedBtnCencelVendor = false;
	private boolean renderedBtnYesVendor = false;
	private boolean renderedBtnNoVendor = false;
	private boolean renderedMsgPopupSave = false;
	
	//Bas Add 
	private String searchType;
	private boolean togPnlVD = false;
	private boolean togPnlVB = false; 
	private boolean togPnlPY = false;
	private boolean togPnlPB = false;
	private boolean togPnlAB = false;
	private boolean togPnlCB = false;
	
	
	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}
	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}
	
	
	public Mmm001VendorMasterSP getCriteria() {
		if(criteria == null) {
			criteria = new Mmm001VendorMasterSP();
		}
		return criteria;
	}
	public void setCriteria(Mmm001VendorMasterSP criteria) {
		this.criteria = criteria;
	}
	
	public List<SelectItem> getCompanyList() {
		if(companyList == null){
			companyList = new ArrayList<SelectItem>();
		}
		return companyList;
	}
	public void setCompanyList(List<SelectItem> companyList) {
		this.companyList = companyList;
	}
	public List<SelectItem> getExpenseTypeList() {
		if(expenseTypeList == null){
			expenseTypeList = new ArrayList<SelectItem>();
		}
		return expenseTypeList;
	}
	public void setExpenseTypeList(List<SelectItem> expenseTypeList) {
		this.expenseTypeList = expenseTypeList;
	}
	public List<SelectItem> getBankList() {
		if(bankList == null){
			bankList = new ArrayList<SelectItem>();
		}
		return bankList;
	}
	public void setBankList(List<SelectItem> bankList) {
		this.bankList = bankList;
	}
	public List<SelectItem> getStatusList() {
		if(statusList == null){
			statusList = new ArrayList<SelectItem>();
		}
		return statusList;
	}
	public void setStatusList(List<SelectItem> statusList) {
		this.statusList = statusList;
	}
	public List<SelectItem> getVendorStatusList() {
		if(vendorStatusList == null){
			vendorStatusList = new ArrayList<SelectItem>();
		}
		return vendorStatusList;
	}
	public void setVendorStatusList(List<SelectItem> vendorStatusList) {
		this.vendorStatusList = vendorStatusList;
	}
	public List<SelectItem> getBookbankStatusList() {
		if(bookbankStatusList == null){
			bookbankStatusList = new ArrayList<SelectItem>();
		}
		return bookbankStatusList;
	}
	public void setBookbankStatusList(List<SelectItem> bookbankStatusList) {
		this.bookbankStatusList = bookbankStatusList;
	}
	public List<SelectItem> getPayeeStatusList() {
		if(payeeStatusList == null){
			payeeStatusList = new ArrayList<SelectItem>();
		}
		return payeeStatusList;
	}
	public void setPayeeStatusList(List<SelectItem> payeeStatusList) {
		this.payeeStatusList = payeeStatusList;
	}
	public List<SelectItem> getBookbankPayeeStatusList() {
		if(bookbankPayeeStatusList == null){
			bookbankPayeeStatusList = new ArrayList<SelectItem>();
		}
		return bookbankPayeeStatusList;
	}
	public void setBookbankPayeeStatusList(List<SelectItem> bookbankPayeeStatusList) {
		this.bookbankPayeeStatusList = bookbankPayeeStatusList;
	}
	public List<SelectItem> getTambolList() {
		if(tambolList == null){
			tambolList = new ArrayList<SelectItem>();
		}
		return tambolList;
	}
	public void setTambolList(List<SelectItem> tambolList) {
		this.tambolList = tambolList;
	}
	public List<SelectItem> getAmphurList() {
		if(amphurList == null){
			amphurList = new ArrayList<SelectItem>();
		}
		return amphurList;
	}
	public void setAmphurList(List<SelectItem> amphurList) {
		this.amphurList = amphurList;
	}
	public List<SelectItem> getProvinceList() {
		if(provinceList == null){
			provinceList = new ArrayList<SelectItem>();
		}
		return provinceList;
	}
	public void setProvinceList(List<SelectItem> provinceList) {
		this.provinceList = provinceList;
	}
	public List<SelectItem> getRegionList() {
		if(regionList == null){
			regionList = new ArrayList<SelectItem>();
		}
		return regionList;
	}
	public void setRegionList(List<SelectItem> regionList) {
		this.regionList = regionList;
	}
	
	public String getSelectedRowIndex() {
		return selectedRowIndex;
	}
	public void setSelectedRowIndex(String selectedRowIndex) {
		this.selectedRowIndex = selectedRowIndex;
	}
	public boolean isChkSelAll() {
		return chkSelAll;
	}
	public void setChkSelAll(boolean chkSelAll) {
		this.chkSelAll = chkSelAll;
	}
	public boolean isChkPicoType() {
		return chkPicoType;
	}
	public void setChkPicoType(boolean chkPicoType) {
		this.chkPicoType = chkPicoType;
	}
	
	
	@Override
	public String toString() {
		return "SEMMMM002Bean [bankList=" + bankList + ", bookbankPayeeStatusList=" + bookbankPayeeStatusList + ", bookbankStatusList=" + bookbankStatusList + ", chkPicoType=" + chkPicoType + ", chkSelAll=" + chkSelAll + ", companyList=" + companyList + ", criteria=" + criteria + ", amphurList=" + amphurList + ", expenseTypeList=" + expenseTypeList + ", isDisableBtnApprove=" + ", payeeStatusList=" + payeeStatusList + ", provinceList=" + provinceList + ", regionList=" + regionList + ", selectedRowIndex=" + selectedRowIndex + ", statusList=" + statusList + ", tambolList=" + tambolList + ", vendorMasterResultList=" + vendorMasterResultList + ", vendorStatusList=" + vendorStatusList + "]";
	}
	public ArrayList getSelectIdList() {
		return selectIdList;
	}
	public void setSelectIdList(ArrayList selectIdList) {
		this.selectIdList = selectIdList;
	}
	public String getActionType() {
		return actionType;
	}
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	public String getFlowStatus() {
		return flowStatus;
	}
	public void setFlowStatus(String flowStatus) {
		this.flowStatus = flowStatus;
	}
	public String getRejectRemark() {
		return rejectRemark;
	}
	public void setRejectRemark(String rejectRemark) {
		this.rejectRemark = rejectRemark;
	}
	public TreeNode getRootNode() {
		return rootNode;
	}
	public void setRootNode(TreeNode rootNode) {
		this.rootNode = rootNode;
	}
	public List<MenuTreeSP> getMenuTreeList() {
		return menuTreeList;
	}
	public void setMenuTreeList(List<MenuTreeSP> menuTreeList) {
		this.menuTreeList = menuTreeList;
	}
	public List<WrapperBeanObject<MenuTreeSP>> getMenuTreeVendorList() {
		return menuTreeVendorList;
	}
	public void setMenuTreeVendorList(
			List<WrapperBeanObject<MenuTreeSP>> menuTreeVendorList) {
		this.menuTreeVendorList = menuTreeVendorList;
	}
	public List<WrapperBeanObject<MenuTreeSP>> getMenuTreeVendorBookbankList() {
		return menuTreeVendorBookbankList;
	}
	public void setMenuTreeVendorBookbankList(
			List<WrapperBeanObject<MenuTreeSP>> menuTreeVendorBookbankList) {
		this.menuTreeVendorBookbankList = menuTreeVendorBookbankList;
	}
	public List<WrapperBeanObject<MenuTreeSP>> getMenuTreePayeeList() {
		return menuTreePayeeList;
	}
	public void setMenuTreePayeeList(
			List<WrapperBeanObject<MenuTreeSP>> menuTreePayeeList) {
		this.menuTreePayeeList = menuTreePayeeList;
	}
	public List<WrapperBeanObject<MenuTreeSP>> getMenuTreePayeeBookbankList() {
		return menuTreePayeeBookbankList;
	}
	public void setMenuTreePayeeBookbankList(
			List<WrapperBeanObject<MenuTreeSP>> menuTreePayeeBookbankList) {
		this.menuTreePayeeBookbankList = menuTreePayeeBookbankList;
	}
	public List<WrapperBeanObject<MenuTreeSP>> getMenuTreeAbnormalList() {
		return menuTreeAbnormalList;
	}
	public void setMenuTreeAbnormalList(
			List<WrapperBeanObject<MenuTreeSP>> menuTreeAbnormalList) {
		this.menuTreeAbnormalList = menuTreeAbnormalList;
	}
	public boolean isRenderedTodoRejectButton() {
		return renderedTodoRejectButton;
	}
	public void setRenderedTodoRejectButton(boolean renderedTodoRejectButton) {
		this.renderedTodoRejectButton = renderedTodoRejectButton;
	}
	public String getParamUrl() {
		return paramUrl;
	}
	public void setParamUrl(String paramUrl) {
		this.paramUrl = paramUrl;
	}
	public String getParamMenuGroup() {
		return paramMenuGroup;
	}
	public void setParamMenuGroup(String paramMenuGroup) {
		this.paramMenuGroup = paramMenuGroup;
	}
	public List<SelectItem> getTeamList() {
		return teamList;
	}
	public void setTeamList(List<SelectItem> teamList) {
		this.teamList = teamList;
	}
	public MenuTreeSP getCriteriaToDoList() {
		if(criteriaToDoList == null) {
			criteriaToDoList = new MenuTreeSP();
		}
		return criteriaToDoList;
	}
	public void setCriteriaToDoList(MenuTreeSP criteriaToDoList) {
		this.criteriaToDoList = criteriaToDoList;
	}
	public List<WrapperBeanObject<Mmm001VendorMasterSP>> getVendorMasterResultList() {
		return vendorMasterResultList;
	}
	public void setVendorMasterResultList(
			List<WrapperBeanObject<Mmm001VendorMasterSP>> vendorMasterResultList) {
		this.vendorMasterResultList = vendorMasterResultList;
	}
	public List<WrapperBeanObject<Mmm001VendorMasterSP>> getVendorMasterRejectList() {
		return vendorMasterRejectList;
	}
	public void setVendorMasterRejectList(
			List<WrapperBeanObject<Mmm001VendorMasterSP>> vendorMasterRejectList) {
		this.vendorMasterRejectList = vendorMasterRejectList;
	}
	public List<WrapperBeanObject<MenuTreeSP>> getVendorSelectedTeamList() {
		return vendorSelectedTeamList;
	}
	public void setVendorSelectedTeamList(
			List<WrapperBeanObject<MenuTreeSP>> vendorSelectedTeamList) {
		this.vendorSelectedTeamList = vendorSelectedTeamList;
	}
	public String getTotalSumVendor() {
		return totalSumVendor;
	}
	public void setTotalSumVendor(String totalSumVendor) {
		this.totalSumVendor = totalSumVendor;
	}
	public String getTotalSumVendorBookbank() {
		return totalSumVendorBookbank;
	}
	public void setTotalSumVendorBookbank(String totalSumVendorBookbank) {
		this.totalSumVendorBookbank = totalSumVendorBookbank;
	}
	public String getTotalSumPayee() {
		return totalSumPayee;
	}
	public void setTotalSumPayee(String totalSumPayee) {
		this.totalSumPayee = totalSumPayee;
	}
	public String getTotalSumPayeeBookbank() {
		return totalSumPayeeBookbank;
	}
	public void setTotalSumPayeeBookbank(String totalSumPayeeBookbank) {
		this.totalSumPayeeBookbank = totalSumPayeeBookbank;
	}
	public String getTotalSumAbnormal() {
		return totalSumAbnormal;
	}
	public void setTotalSumAbnormal(String totalSumAbnormal) {
		this.totalSumAbnormal = totalSumAbnormal;
	}
	public Mmm001VendorSP getVendorInfo() {
		return vendorInfo;
	}
	public void setVendorInfo(Mmm001VendorSP vendorInfo) {
		this.vendorInfo = vendorInfo;
	}
	public List<WrapperBeanObject<Mmm001VendorMasterSP>> getConvertVendorResultList() {
		return convertVendorResultList;
	}
	public void setConvertVendorResultList(
			List<WrapperBeanObject<Mmm001VendorMasterSP>> convertVendorResultList) {
		this.convertVendorResultList = convertVendorResultList;
	}
	public String getTodoFlag() {
		return todoFlag;
	}
	public void setTodoFlag(String todoFlag) {
		this.todoFlag = todoFlag;
	}
	public List<SelectItem> getPayeeFlowStatusList() {
		if(payeeFlowStatusList == null){
			payeeFlowStatusList = new ArrayList<SelectItem>();
		}
		return payeeFlowStatusList;
	}
	public void setPayeeFlowStatusList(List<SelectItem> payeeFlowStatusList) {
		this.payeeFlowStatusList = payeeFlowStatusList;
	}
	public List<SelectItem> getVendorFlowStatusList() {
		if(vendorFlowStatusList == null){
			vendorFlowStatusList = new ArrayList<SelectItem>();
		}
		return vendorFlowStatusList;
	}
	public void setVendorFlowStatusList(List<SelectItem> vendorFlowStatusList) {
		this.vendorFlowStatusList = vendorFlowStatusList;
	}
	public List<SelectItem> getBlackListStatusList() {
		if(blackListStatusList == null){
			blackListStatusList = new ArrayList<SelectItem>();
		}
		return blackListStatusList;
	}
	public void setBlackListStatusList(List<SelectItem> blackListStatusList) {
		this.blackListStatusList = blackListStatusList;
	}
	public List<SelectItem> getBlockStatusList() {
		if(blockStatusList == null){
			blockStatusList = new ArrayList<SelectItem>();
		}
		return blockStatusList;
	}
	public void setBlockStatusList(List<SelectItem> blockStatusList) {
		this.blockStatusList = blockStatusList;
	}
	public List<SelectItem> getBookbankPayeeFlowStatusList() {
		if(bookbankPayeeFlowStatusList == null){
			bookbankPayeeFlowStatusList = new ArrayList<SelectItem>();
		}
		return bookbankPayeeFlowStatusList;
	}
	public void setBookbankPayeeFlowStatusList(List<SelectItem> bookbankPayeeFlowStatusList) {
		this.bookbankPayeeFlowStatusList = bookbankPayeeFlowStatusList;
	}
	public boolean isChkVendorType() {
		return chkVendorType;
	}
	public void setChkVendorType(boolean chkVendorType) {
		this.chkVendorType = chkVendorType;
	}
	public boolean isChkPayeeType() {
		return chkPayeeType;
	}
	public void setChkPayeeType(boolean chkPayeeType) {
		this.chkPayeeType = chkPayeeType;
	}
	public List<SelectItem> getBookbankFlowStatusList() {
		if(bookbankFlowStatusList == null){
			bookbankFlowStatusList = new ArrayList<SelectItem>();
		}
		return bookbankFlowStatusList;
	}
	public void setBookbankFlowStatusList(List<SelectItem> bookbankFlowStatusList) {
		this.bookbankFlowStatusList = bookbankFlowStatusList;
	}
	public boolean isDisableBtnApproveVendor() {
		return disableBtnApproveVendor;
	}
	public void setDisableBtnApproveVendor(boolean disableBtnApproveVendor) {
		this.disableBtnApproveVendor = disableBtnApproveVendor;
	}
	public boolean isDisableBtnRejectVendor() {
		return disableBtnRejectVendor;
	}
	public void setDisableBtnRejectVendor(boolean disableBtnRejectVendor) {
		this.disableBtnRejectVendor = disableBtnRejectVendor;
	}
	public boolean isDisableBtnSendVendorToMNG2() {
		return disableBtnSendVendorToMNG2;
	}
	public void setDisableBtnSendVendorToMNG2(boolean disableBtnSendVendorToMNG2) {
		this.disableBtnSendVendorToMNG2 = disableBtnSendVendorToMNG2;
	}
	public boolean isDisableBtnMNG2ApproveVendor() {
		return disableBtnMNG2ApproveVendor;
	}
	public void setDisableBtnMNG2ApproveVendor(boolean disableBtnMNG2ApproveVendor) {
		this.disableBtnMNG2ApproveVendor = disableBtnMNG2ApproveVendor;
	}
	public boolean isDisableBtnMNG2RejectVendor() {
		return disableBtnMNG2RejectVendor;
	}
	public void setDisableBtnMNG2RejectVendor(boolean disableBtnMNG2RejectVendor) {
		this.disableBtnMNG2RejectVendor = disableBtnMNG2RejectVendor;
	}
	public boolean isDisableBtnApproveBookbank() {
		return disableBtnApproveBookbank;
	}
	public void setDisableBtnApproveBookbank(boolean disableBtnApproveBookbank) {
		this.disableBtnApproveBookbank = disableBtnApproveBookbank;
	}
	public boolean isDisableBtnRejectBookbank() {
		return disableBtnRejectBookbank;
	}
	public void setDisableBtnRejectBookbank(boolean disableBtnRejectBookbank) {
		this.disableBtnRejectBookbank = disableBtnRejectBookbank;
	}
	public boolean isDisableBtnSendBookbankToMNG2() {
		return disableBtnSendBookbankToMNG2;
	}
	public void setDisableBtnSendBookbankToMNG2(boolean disableBtnSendBookbankToMNG2) {
		this.disableBtnSendBookbankToMNG2 = disableBtnSendBookbankToMNG2;
	}
	public boolean isDisableBtnMNG2ApproveBookbank() {
		return disableBtnMNG2ApproveBookbank;
	}
	public void setDisableBtnMNG2ApproveBookbank(
			boolean disableBtnMNG2ApproveBookbank) {
		this.disableBtnMNG2ApproveBookbank = disableBtnMNG2ApproveBookbank;
	}
	public boolean isDisableBtnMNG2RejectBookbank() {
		return disableBtnMNG2RejectBookbank;
	}
	public void setDisableBtnMNG2RejectBookbank(boolean disableBtnMNG2RejectBookbank) {
		this.disableBtnMNG2RejectBookbank = disableBtnMNG2RejectBookbank;
	}
	public boolean isDisableBtnApprovePayee() {
		return disableBtnApprovePayee;
	}
	public void setDisableBtnApprovePayee(boolean disableBtnApprovePayee) {
		this.disableBtnApprovePayee = disableBtnApprovePayee;
	}
	public boolean isDisableBtnRejectPayee() {
		return disableBtnRejectPayee;
	}
	public void setDisableBtnRejectPayee(boolean disableBtnRejectPayee) {
		this.disableBtnRejectPayee = disableBtnRejectPayee;
	}
	public boolean isDisableBtnSendPayeeToMNG2() {
		return disableBtnSendPayeeToMNG2;
	}
	public void setDisableBtnSendPayeeToMNG2(boolean disableBtnSendPayeeToMNG2) {
		this.disableBtnSendPayeeToMNG2 = disableBtnSendPayeeToMNG2;
	}
	public boolean isDisableBtnMNG2ApprovePayee() {
		return disableBtnMNG2ApprovePayee;
	}
	public void setDisableBtnMNG2ApprovePayee(boolean disableBtnMNG2ApprovePayee) {
		this.disableBtnMNG2ApprovePayee = disableBtnMNG2ApprovePayee;
	}
	public boolean isDisableBtnMNG2RejectPayee() {
		return disableBtnMNG2RejectPayee;
	}
	public void setDisableBtnMNG2RejectPayee(boolean disableBtnMNG2RejectPayee) {
		this.disableBtnMNG2RejectPayee = disableBtnMNG2RejectPayee;
	}
	public boolean isDisableBtnApprovePayeeBookbank() {
		return disableBtnApprovePayeeBookbank;
	}
	public void setDisableBtnApprovePayeeBookbank(
			boolean disableBtnApprovePayeeBookbank) {
		this.disableBtnApprovePayeeBookbank = disableBtnApprovePayeeBookbank;
	}
	public boolean isDisableBtnRejectPayeeBookbank() {
		return disableBtnRejectPayeeBookbank;
	}
	public void setDisableBtnRejectPayeeBookbank(
			boolean disableBtnRejectPayeeBookbank) {
		this.disableBtnRejectPayeeBookbank = disableBtnRejectPayeeBookbank;
	}
	public boolean isDisableBtnSendPayeeBookbankToMNG2() {
		return disableBtnSendPayeeBookbankToMNG2;
	}
	public void setDisableBtnSendPayeeBookbankToMNG2(
			boolean disableBtnSendPayeeBookbankToMNG2) {
		this.disableBtnSendPayeeBookbankToMNG2 = disableBtnSendPayeeBookbankToMNG2;
	}
	public boolean isDisableBtnMNG2ApprovePayeeBookbank() {
		return disableBtnMNG2ApprovePayeeBookbank;
	}
	public void setDisableBtnMNG2ApprovePayeeBookbank(
			boolean disableBtnMNG2ApprovePayeeBookbank) {
		this.disableBtnMNG2ApprovePayeeBookbank = disableBtnMNG2ApprovePayeeBookbank;
	}
	public boolean isDisableBtnMNG2RejectPayeeBookbank() {
		return disableBtnMNG2RejectPayeeBookbank;
	}
	public void setDisableBtnMNG2RejectPayeeBookbank(
			boolean disableBtnMNG2RejectPayeeBookbank) {
		this.disableBtnMNG2RejectPayeeBookbank = disableBtnMNG2RejectPayeeBookbank;
	}
	public String getActionBtnType() {
		return actionBtnType;
	}
	public void setActionBtnType(String actionBtnType) {
		this.actionBtnType = actionBtnType;
	}
	public boolean isRenderedBtnApproveVendor() {
		return renderedBtnApproveVendor;
	}
	public void setRenderedBtnApproveVendor(boolean renderedBtnApproveVendor) {
		this.renderedBtnApproveVendor = renderedBtnApproveVendor;
	}
	public boolean isRenderedBtnRejectVendor() {
		return renderedBtnRejectVendor;
	}
	public void setRenderedBtnRejectVendor(boolean renderedBtnRejectVendor) {
		this.renderedBtnRejectVendor = renderedBtnRejectVendor;
	}
	public boolean isRenderedBtnSendVendorToMNG2() {
		return renderedBtnSendVendorToMNG2;
	}
	public void setRenderedBtnSendVendorToMNG2(boolean renderedBtnSendVendorToMNG2) {
		this.renderedBtnSendVendorToMNG2 = renderedBtnSendVendorToMNG2;
	}
	public boolean isRenderedBtnMNG2ApproveVendor() {
		return renderedBtnMNG2ApproveVendor;
	}
	public void setRenderedBtnMNG2ApproveVendor(boolean renderedBtnMNG2ApproveVendor) {
		this.renderedBtnMNG2ApproveVendor = renderedBtnMNG2ApproveVendor;
	}
	public boolean isRenderedBtnMNG2RejectVendor() {
		return renderedBtnMNG2RejectVendor;
	}
	public void setRenderedBtnMNG2RejectVendor(boolean renderedBtnMNG2RejectVendor) {
		this.renderedBtnMNG2RejectVendor = renderedBtnMNG2RejectVendor;
	}
	public boolean isRenderedBtnApproveBookbank() {
		return renderedBtnApproveBookbank;
	}
	public void setRenderedBtnApproveBookbank(boolean renderedBtnApproveBookbank) {
		this.renderedBtnApproveBookbank = renderedBtnApproveBookbank;
	}
	public boolean isRenderedBtnRejectBookbank() {
		return renderedBtnRejectBookbank;
	}
	public void setRenderedBtnRejectBookbank(boolean renderedBtnRejectBookbank) {
		this.renderedBtnRejectBookbank = renderedBtnRejectBookbank;
	}
	public boolean isRenderedBtnSendBookbankToMNG2() {
		return renderedBtnSendBookbankToMNG2;
	}
	public void setRenderedBtnSendBookbankToMNG2(
			boolean renderedBtnSendBookbankToMNG2) {
		this.renderedBtnSendBookbankToMNG2 = renderedBtnSendBookbankToMNG2;
	}
	public boolean isRenderedBtnMNG2ApproveBookbank() {
		return renderedBtnMNG2ApproveBookbank;
	}
	public void setRenderedBtnMNG2ApproveBookbank(
			boolean renderedBtnMNG2ApproveBookbank) {
		this.renderedBtnMNG2ApproveBookbank = renderedBtnMNG2ApproveBookbank;
	}
	public boolean isRenderedBtnMNG2RejectBookbank() {
		return renderedBtnMNG2RejectBookbank;
	}
	public void setRenderedBtnMNG2RejectBookbank(
			boolean renderedBtnMNG2RejectBookbank) {
		this.renderedBtnMNG2RejectBookbank = renderedBtnMNG2RejectBookbank;
	}
	public boolean isRenderedBtnApprovePayee() {
		return renderedBtnApprovePayee;
	}
	public void setRenderedBtnApprovePayee(boolean renderedBtnApprovePayee) {
		this.renderedBtnApprovePayee = renderedBtnApprovePayee;
	}
	public boolean isRenderedBtnRejectPayee() {
		return renderedBtnRejectPayee;
	}
	public void setRenderedBtnRejectPayee(boolean renderedBtnRejectPayee) {
		this.renderedBtnRejectPayee = renderedBtnRejectPayee;
	}
	public boolean isRenderedBtnSendPayeeToMNG2() {
		return renderedBtnSendPayeeToMNG2;
	}
	public void setRenderedBtnSendPayeeToMNG2(boolean renderedBtnSendPayeeToMNG2) {
		this.renderedBtnSendPayeeToMNG2 = renderedBtnSendPayeeToMNG2;
	}
	public boolean isRenderedBtnMNG2ApprovePayee() {
		return renderedBtnMNG2ApprovePayee;
	}
	public void setRenderedBtnMNG2ApprovePayee(boolean renderedBtnMNG2ApprovePayee) {
		this.renderedBtnMNG2ApprovePayee = renderedBtnMNG2ApprovePayee;
	}
	public boolean isRenderedBtnMNG2RejectPayee() {
		return renderedBtnMNG2RejectPayee;
	}
	public void setRenderedBtnMNG2RejectPayee(boolean renderedBtnMNG2RejectPayee) {
		this.renderedBtnMNG2RejectPayee = renderedBtnMNG2RejectPayee;
	}
	public boolean isRenderedBtnApprovePayeeBookbank() {
		return renderedBtnApprovePayeeBookbank;
	}
	public void setRenderedBtnApprovePayeeBookbank(
			boolean renderedBtnApprovePayeeBookbank) {
		this.renderedBtnApprovePayeeBookbank = renderedBtnApprovePayeeBookbank;
	}
	public boolean isRenderedBtnRejectPayeeBookbank() {
		return renderedBtnRejectPayeeBookbank;
	}
	public void setRenderedBtnRejectPayeeBookbank(
			boolean renderedBtnRejectPayeeBookbank) {
		this.renderedBtnRejectPayeeBookbank = renderedBtnRejectPayeeBookbank;
	}
	public boolean isRenderedBtnSendPayeeBookbankToMNG2() {
		return renderedBtnSendPayeeBookbankToMNG2;
	}
	public void setRenderedBtnSendPayeeBookbankToMNG2(
			boolean renderedBtnSendPayeeBookbankToMNG2) {
		this.renderedBtnSendPayeeBookbankToMNG2 = renderedBtnSendPayeeBookbankToMNG2;
	}
	public boolean isRenderedBtnMNG2ApprovePayeeBookbank() {
		return renderedBtnMNG2ApprovePayeeBookbank;
	}
	public void setRenderedBtnMNG2ApprovePayeeBookbank(
			boolean renderedBtnMNG2ApprovePayeeBookbank) {
		this.renderedBtnMNG2ApprovePayeeBookbank = renderedBtnMNG2ApprovePayeeBookbank;
	}
	public boolean isRenderedBtnMNG2RejectPayeeBookbank() {
		return renderedBtnMNG2RejectPayeeBookbank;
	}
	public void setRenderedBtnMNG2RejectPayeeBookbank(
			boolean renderedBtnMNG2RejectPayeeBookbank) {
		this.renderedBtnMNG2RejectPayeeBookbank = renderedBtnMNG2RejectPayeeBookbank;
	}
	public String getRemarkSapMSG() {
		return remarkSapMSG;
	}
	public void setRemarkSapMSG(String remarkSapMSG) {
		this.remarkSapMSG = remarkSapMSG;
	}
	public String getNavProgramBack() {
		return navProgramBack;
	}
	public void setNavProgramBack(String navProgramBack) {
		this.navProgramBack = navProgramBack;
	}
	public List<WrapperBeanObject<MenuTreeSP>> getMenuTreeCreateByList() {
		return menuTreeCreateByList;
	}
	public void setMenuTreeCreateByList(
			List<WrapperBeanObject<MenuTreeSP>> menuTreeCreateByList) {
		this.menuTreeCreateByList = menuTreeCreateByList;
	}
	public String getTotalSumCreateBy() {
		return totalSumCreateBy;
	}
	public void setTotalSumCreateBy(String totalSumCreateBy) {
		this.totalSumCreateBy = totalSumCreateBy;
	}
	public ItemResultSP getRetResultObj() {
		if(retResultObj == null){
			retResultObj = new ItemResultSP();
		}
		return retResultObj;
	}
	public void setRetResultObj(ItemResultSP retResultObj) {
		this.retResultObj = retResultObj;
	}
	public String getRenderedMsgConfirm() {
		return renderedMsgConfirm;
	}
	public void setRenderedMsgConfirm(String renderedMsgConfirm) {
		this.renderedMsgConfirm = renderedMsgConfirm;
	}
	public boolean isRenderedBtnCloseVendor() {
		return renderedBtnCloseVendor;
	}
	public void setRenderedBtnCloseVendor(boolean renderedBtnCloseVendor) {
		this.renderedBtnCloseVendor = renderedBtnCloseVendor;
	}
	public boolean isRenderedBtnOKVendor() {
		return renderedBtnOKVendor;
	}
	public void setRenderedBtnOKVendor(boolean renderedBtnOKVendor) {
		this.renderedBtnOKVendor = renderedBtnOKVendor;
	}
	public boolean isRenderedBtnCencelVendor() {
		return renderedBtnCencelVendor;
	}
	public void setRenderedBtnCencelVendor(boolean renderedBtnCencelVendor) {
		this.renderedBtnCencelVendor = renderedBtnCencelVendor;
	}
	public boolean isRenderedBtnYesVendor() {
		return renderedBtnYesVendor;
	}
	public void setRenderedBtnYesVendor(boolean renderedBtnYesVendor) {
		this.renderedBtnYesVendor = renderedBtnYesVendor;
	}
	public boolean isRenderedBtnNoVendor() {
		return renderedBtnNoVendor;
	}
	public void setRenderedBtnNoVendor(boolean renderedBtnNoVendor) {
		this.renderedBtnNoVendor = renderedBtnNoVendor;
	}
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public boolean isTogPnlVD() {
		return togPnlVD;
	}
	public void setTogPnlVD(boolean togPnlVD) {
		this.togPnlVD = togPnlVD;
	}
	public boolean isTogPnlVB() {
		return togPnlVB;
	}
	public void setTogPnlVB(boolean togPnlVB) {
		this.togPnlVB = togPnlVB;
	}
	public boolean isTogPnlPY() {
		return togPnlPY;
	}
	public void setTogPnlPY(boolean togPnlPY) {
		this.togPnlPY = togPnlPY;
	}
	public boolean isTogPnlPB() {
		return togPnlPB;
	}
	public void setTogPnlPB(boolean togPnlPB) {
		this.togPnlPB = togPnlPB;
	}
	public boolean isTogPnlAB() {
		return togPnlAB;
	}
	public void setTogPnlAB(boolean togPnlAB) {
		this.togPnlAB = togPnlAB;
	}
	public boolean isTogPnlCB() {
		return togPnlCB;
	}
	public void setTogPnlCB(boolean togPnlCB) {
		this.togPnlCB = togPnlCB;
	}
	public boolean isRenderedMsgPopupSave() {
		return renderedMsgPopupSave;
	}
	public void setRenderedMsgPopupSave(boolean renderedMsgPopupSave) {
		this.renderedMsgPopupSave = renderedMsgPopupSave;
	}
	
}
