package th.co.ais.web.ir.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.ir.Deduct;
import th.co.ais.domain.ir.DeductibleSP;


public class SEMIR004Bean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2359355352402848631L;
	
	private List<SelectItem> companyList;
	private List<SelectItem> networkTypeList;
	private List<SelectItem> transferTypeList;
	private List<SelectItem> lossTypeList;
	private String rowId;
	
	private int rowPerPage = 10;
	private int maxPage = 10;
	private int maxSearchResult = 100;
	
	private List<DeductibleSP> deductibleSPList;
	private DeductibleSP deductibleSP;
	private Deduct editDedutible;
	
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	public int getRowPerPage() {
		return rowPerPage;
	}
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public int getMaxSearchResult() {
		return maxSearchResult;
	}
	public void setMaxSearchResult(int maxSearchResult) {
		this.maxSearchResult = maxSearchResult;
	}
	public List<SelectItem> getCompanyList() {
		return companyList;
	}
	public void setCompanyList(List<SelectItem> companyList) {
		this.companyList = companyList;
	}
	public void setNetworkTypeList(List<SelectItem> networkTypeList) {
		this.networkTypeList = networkTypeList;
	}
	public List<SelectItem> getNetworkTypeList() {
		return networkTypeList;
	}
	
	public void setTransferTypeList(List<SelectItem> transferTypeList) {
		this.transferTypeList = transferTypeList;
	}
	public List<SelectItem> getTransferTypeList() {
		return transferTypeList;
	}
	public void setDeductibleSPList(List<DeductibleSP> deductibleSPList) {
		this.deductibleSPList = deductibleSPList;
	}
	public List<DeductibleSP> getDeductibleSPList() {
		return deductibleSPList;
	}
	public void setDeductibleSP(DeductibleSP deductibleSP) {
		this.deductibleSP = deductibleSP;
	}
	public DeductibleSP getDeductibleSP() {
		return deductibleSP;
	}
	public void setEditDedutible(Deduct editDedutible) {
		this.editDedutible = editDedutible;
	}
	public Deduct getEditDedutible() {
		return editDedutible;
	}
	public void setLossTypeList(List<SelectItem> lossTypeList) {
		this.lossTypeList = lossTypeList;
	}
	public List<SelectItem> getLossTypeList() {
		return lossTypeList;
	}
	
	
	
	
}
