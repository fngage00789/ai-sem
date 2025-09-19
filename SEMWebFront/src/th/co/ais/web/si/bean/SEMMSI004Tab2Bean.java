package th.co.ais.web.si.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.si.Contract;
import th.co.ais.domain.si.Lessor;
import th.co.ais.domain.si.Msi004SrchLessorSP;
import th.co.ais.web.bean.AbstractBean;

public class SEMMSI004Tab2Bean extends AbstractBean{

	private static final long serialVersionUID = -1767541831111318866L;

	private Lessor siteLessor;
	private Contract siteContract;
	private Contract contract;
	private List<SelectItem> contractDocTypeList = new ArrayList<SelectItem>();
	private List<SelectItem> periodTypeList = new ArrayList<SelectItem>();
	private List<SelectItem> ownerGroupList = new ArrayList<SelectItem>();
	private List<SelectItem> contractLessorAmphurList = new ArrayList<SelectItem>();
	private List<SelectItem> contactAmphurList = new ArrayList<SelectItem>();
	private List<Msi004SrchLessorSP> lessorSPList;
	private boolean chkDummyFlag;
	private boolean chkNoExpireFlag;
	private String contractNo1;
	private String contractNo2;
	private String contractNo3;
	private String contractNoFormat;
	private boolean disabledContractNo;
	private boolean disabledAge;
	private boolean renderStarImage;
	private String contractNoGen;
	private boolean disabledChkDummyContract;
	private boolean chkOwnerContractFlag;
	private String tempContractNo;
	private boolean disabledContract;
	private String editableContractFlag;
	private boolean disabledNoExpireFlag;
	private boolean disabledExpDate;
	private boolean chkOverFlag;
	private boolean disabledEffDate;
	
	//create by new for gen dummy 17/02/2015
	private String contractNoOld;
	private String contractNoNew;
	private List<SelectItem> titleList;
	
	//added by NEW 2018/09/06 SEM 4G
	private boolean chkLeaseholdRights;
	public boolean chkContractWanted;
	
	private boolean chkContRentAdj;
	
	private boolean chkContractInfoEditFlag;
	private String contractInfoEditFlag = "N";
	
	private List<SelectItem> ownerCategoryList;
	private List<SelectItem> ownerSubCategoryList;
	
	public String getContractNoFormat() {
		return contractNoFormat;
	}

	public void setContractNoFormat(String contractNoFormat) {
		this.contractNoFormat = contractNoFormat;
	}

	public boolean isChkOverFlag() {
		return chkOverFlag;
	}

	public void setChkOverFlag(boolean chkOverFlag) {
		this.chkOverFlag = chkOverFlag;
	}

	public boolean isDisabledExpDate() {
		return disabledExpDate;
	}

	public void setDisabledExpDate(boolean disabledExpDate) {
		this.disabledExpDate = disabledExpDate;
	}
	
	
	public boolean isDisabledNoExpireFlag() {
		return disabledNoExpireFlag;
	}

	public void setDisabledNoExpireFlag(boolean disabledNoExpireFlag) {
		this.disabledNoExpireFlag = disabledNoExpireFlag;
	}

	public String getEditableContractFlag() {
		return editableContractFlag;
	}

	public void setEditableContractFlag(String editableContractFlag) {
		this.editableContractFlag = editableContractFlag;
	}

	public boolean isDisabledContract() {
		return disabledContract;
	}

	public void setDisabledContract(boolean disabledContract) {
		this.disabledContract = disabledContract;
	}


	// popup add lessor
	private List<SelectItem> lessorAmphurList = new ArrayList<SelectItem>();
	

	public String getTempContractNo() {
		return tempContractNo;
	}

	public void setTempContractNo(String tempContractNo) {
		this.tempContractNo = tempContractNo;
	}

	public boolean isChkOwnerContractFlag() {
		return chkOwnerContractFlag;
	}

	public void setChkOwnerContractFlag(boolean chkOwnerContractFlag) {
		this.chkOwnerContractFlag = chkOwnerContractFlag;
	}

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	
	public boolean isDisabledChkDummyContract() {
		return disabledChkDummyContract;
	}

	public void setDisabledChkDummyContract(boolean disabledChkDummyContract) {
		this.disabledChkDummyContract = disabledChkDummyContract;
	}

	public String getContractNoGen() {
		return contractNoGen;
	}

	public void setContractNoGen(String contractNoGen) {
		this.contractNoGen = contractNoGen;
	}

	public boolean isDisabledAge() {
		return disabledAge;
	}

	public void setDisabledAge(boolean disabledAge) {
		this.disabledAge = disabledAge;
	}

	public boolean isRenderStarImage() {
		return renderStarImage;
	}

	public void setRenderStarImage(boolean renderStarImage) {
		this.renderStarImage = renderStarImage;
	}

	public boolean isDisabledContractNo() {
		return disabledContractNo;
	}

	public void setDisabledContractNo(boolean disabledContractNo) {
		this.disabledContractNo = disabledContractNo;
	}

	public String getContractNo1() {
		return contractNo1;
	}

	public void setContractNo1(String contractNo1) {
		this.contractNo1 = contractNo1;
	}

	public String getContractNo2() {
		return contractNo2;
	}

	public void setContractNo2(String contractNo2) {
		this.contractNo2 = contractNo2;
	}

	public String getContractNo3() {
		return contractNo3;
	}

	public void setContractNo3(String contractNo3) {
		this.contractNo3 = contractNo3;
	}

	public List<SelectItem> getLessorAmphurList() {
		return lessorAmphurList;
	}

	public void setLessorAmphurList(List<SelectItem> lessorAmphurList) {
		this.lessorAmphurList = lessorAmphurList;
	}

	public List<SelectItem> getContractDocTypeList() {
		return contractDocTypeList;
	}

	public void setContractDocTypeList(List<SelectItem> contractDocTypeList) {
		this.contractDocTypeList = contractDocTypeList;
	}

	public List<SelectItem> getPeriodTypeList() {
		return periodTypeList;
	}

	public void setPeriodTypeList(List<SelectItem> periodTypeList) {
		this.periodTypeList = periodTypeList;
	}

	public List<SelectItem> getOwnerGroupList() {
		return ownerGroupList;
	}

	public void setOwnerGroupList(List<SelectItem> ownerGroupList) {
		this.ownerGroupList = ownerGroupList;
	}

	public List<SelectItem> getContractLessorAmphurList() {
		return contractLessorAmphurList;
	}

	public void setContractLessorAmphurList(
			List<SelectItem> contractLessorAmphurList) {
		this.contractLessorAmphurList = contractLessorAmphurList;
	}

	public List<SelectItem> getContactAmphurList() {
		return contactAmphurList;
	}

	public void setContactAmphurList(List<SelectItem> contactAmphurList) {
		this.contactAmphurList = contactAmphurList;
	}

	public List<Msi004SrchLessorSP> getLessorSPList() {
		return lessorSPList;
	}

	public void setLessorSPList(List<Msi004SrchLessorSP> lessorSPList) {
		this.lessorSPList = lessorSPList;
	}

	public boolean isChkDummyFlag() {
		return chkDummyFlag;
	}

	public void setChkDummyFlag(boolean chkDummyFlag) {
		this.chkDummyFlag = chkDummyFlag;
	}

	public boolean isChkNoExpireFlag() {
		return chkNoExpireFlag;
	}

	public void setChkNoExpireFlag(boolean chkNoExpireFlag) {
		this.chkNoExpireFlag = chkNoExpireFlag;
	}

	public Contract getSiteContract() {
		return siteContract;
	}

	public void setSiteContract(Contract siteContract) {
		this.siteContract = siteContract;
	}

	public Lessor getSiteLessor() {
		return siteLessor;
	}

	public void setSiteLessor(Lessor siteLessor) {
		this.siteLessor = siteLessor;
	}

	public boolean isDisabledEffDate() {
		return disabledEffDate;
	}

	public void setDisabledEffDate(boolean disabledEffDate) {
		this.disabledEffDate = disabledEffDate;
	}

	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}


	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
		
	}

	public String getContractNoOld() {
		return contractNoOld;
	}

	public void setContractNoOld(String contractNoOld) {
		this.contractNoOld = contractNoOld;
	}

	public String getContractNoNew() {
		return contractNoNew;
	}

	public void setContractNoNew(String contractNoNew) {
		this.contractNoNew = contractNoNew;
	}

	public List<SelectItem> getTitleList() {
		return titleList;
	}

	public void setTitleList(List<SelectItem> titleList) {
		this.titleList = titleList;
	}

	public boolean isChkLeaseholdRights() {
		return chkLeaseholdRights;
	}

	public void setChkLeaseholdRights(boolean chkLeaseholdRights) {
		this.chkLeaseholdRights = chkLeaseholdRights;
	}

	public boolean isChkContractWanted() {
		return chkContractWanted;
	}

	public void setChkContractWanted(boolean chkContractWanted) {
		this.chkContractWanted = chkContractWanted;
	}

	public boolean isChkContractInfoEditFlag() {
		return chkContractInfoEditFlag;
	}

	public void setChkContractInfoEditFlag(boolean chkContractInfoEditFlag) {
		this.chkContractInfoEditFlag = chkContractInfoEditFlag;
	}

	public String getContractInfoEditFlag() {
		return contractInfoEditFlag;
	}

	public void setContractInfoEditFlag(String contractInfoEditFlag) {
		this.contractInfoEditFlag = contractInfoEditFlag;
	}

	public List<SelectItem> getOwnerCategoryList() {
		return ownerCategoryList;
	}

	public void setOwnerCategoryList(List<SelectItem> ownerCategoryList) {
		this.ownerCategoryList = ownerCategoryList;
	}

	public List<SelectItem> getOwnerSubCategoryList() {
		return ownerSubCategoryList;
	}

	public void setOwnerSubCategoryList(List<SelectItem> ownerSubCategoryList) {
		this.ownerSubCategoryList = ownerSubCategoryList;
	}

	public boolean isChkContRentAdj() {
		return chkContRentAdj;
	}

	public void setChkContRentAdj(boolean chkContRentAdj) {
		this.chkContRentAdj = chkContRentAdj;
	}

}
