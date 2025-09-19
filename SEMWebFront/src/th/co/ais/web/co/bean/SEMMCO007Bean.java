package th.co.ais.web.co.bean;

import java.util.List;

import th.co.ais.domain.co.Mco007MasterContractDetailSP;
import th.co.ais.domain.co.Mco007MasterContractSP;
import th.co.ais.domain.temp.MockUpTemp;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.bean.AbstractBean;

public class SEMMCO007Bean extends AbstractBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4313256231097882463L;
	
	private Mco007MasterContractSP masterContractSP;
	private List<WrapperBeanObject<Mco007MasterContractSP>> masterContractWrapList;
	
	private Mco007MasterContractSP masterContractTitleSP;
	private Mco007MasterContractSP masterContractDetailSP;
	private List<WrapperBeanObject<Mco007MasterContractSP>> masterContractDetailList;

	private List<MockUpTemp> contractList;
	private MockUpTemp contract;
	
	private boolean chkContractBold;
	private boolean chkContractUnderline;
	private boolean chkContractNewline;
	
	private Integer totalList;
	private Integer totalColumn;
	private List<WrapperBeanObject<Mco007MasterContractDetailSP>> paramNameObjList;
	
	private boolean chkContEndingFlag;
	
	
	public Mco007MasterContractSP getMasterContractSP() {
		return masterContractSP;
	}
	public void setMasterContractSP(Mco007MasterContractSP masterContractSP) {
		this.masterContractSP = masterContractSP;
	}
	
	public List<WrapperBeanObject<Mco007MasterContractSP>> getMasterContractWrapList() {
		return masterContractWrapList;
	}
	public void setMasterContractWrapList(
			List<WrapperBeanObject<Mco007MasterContractSP>> masterContractWrapList) {
		this.masterContractWrapList = masterContractWrapList;
	}
	public List<MockUpTemp> getContractList() {
		return contractList;
	}
	public void setContractList(List<MockUpTemp> contractList) {
		this.contractList = contractList;
	}
	public MockUpTemp getContract() {
		return contract;
	}
	public void setContract(MockUpTemp contract) {
		this.contract = contract;
	}
	
	public Mco007MasterContractSP getMasterContractTitleSP() {
		return masterContractTitleSP;
	}
	public void setMasterContractTitleSP(
			Mco007MasterContractSP masterContractTitleSP) {
		this.masterContractTitleSP = masterContractTitleSP;
	}
	public Mco007MasterContractSP getMasterContractDetailSP() {
		return masterContractDetailSP;
	}
	public void setMasterContractDetailSP(
			Mco007MasterContractSP masterContractDetailSP) {
		this.masterContractDetailSP = masterContractDetailSP;
	}
	public List<WrapperBeanObject<Mco007MasterContractSP>> getMasterContractDetailList() {
		return masterContractDetailList;
	}
	public void setMasterContractDetailList(
			List<WrapperBeanObject<Mco007MasterContractSP>> masterContractDetailList) {
		this.masterContractDetailList = masterContractDetailList;
	}
	
	public boolean isChkContractBold() {
		return chkContractBold;
	}
	public void setChkContractBold(boolean chkContractBold) {
		this.chkContractBold = chkContractBold;
	}
	public boolean isChkContractUnderline() {
		return chkContractUnderline;
	}
	public void setChkContractUnderline(boolean chkContractUnderline) {
		this.chkContractUnderline = chkContractUnderline;
	}
	public Integer getTotalList() {
		return totalList;
	}
	public void setTotalList(Integer totalList) {
		this.totalList = totalList;
	}
	public boolean isChkContractNewline() {
		return chkContractNewline;
	}
	public void setChkContractNewline(boolean chkContractNewline) {
		this.chkContractNewline = chkContractNewline;
	}
	
	public List<WrapperBeanObject<Mco007MasterContractDetailSP>> getParamNameObjList() {
		return paramNameObjList;
	}
	public void setParamNameObjList(
			List<WrapperBeanObject<Mco007MasterContractDetailSP>> paramNameObjList) {
		this.paramNameObjList = paramNameObjList;
	}
	public Integer getTotalColumn() {
		return totalColumn;
	}
	public void setTotalColumn(Integer totalColumn) {
		this.totalColumn = totalColumn;
	}
	public boolean isChkContEndingFlag() {
		return chkContEndingFlag;
	}
	public void setChkContEndingFlag(boolean chkContEndingFlag) {
		this.chkContEndingFlag = chkContEndingFlag;
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