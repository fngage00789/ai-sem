package th.co.ais.web.ir.bean;

import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.ir.Replacement;
import th.co.ais.domain.ir.ReplacementValueSP;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.bean.AbstractBean;


public class SEMIR003Bean extends AbstractBean {

	private static final long serialVersionUID = 2359355352402848631L;
	
	private List<SelectItem> companyList;
	private List<SelectItem> networkTypeList;
	private List<SelectItem> transferTypeList;
	private String rowId;
	
	private int rowPerPage = 5;
	
	private ReplacementValueSP replacementValueSP;
	private Replacement editReplacement;
	private boolean chkSelAll;
	private boolean disabledBtnExport=true;
	
	
	public boolean isDisabledBtnExport() {
		return disabledBtnExport;
	}
	public void setDisabledBtnExport(boolean disabledBtnExport) {
		this.disabledBtnExport = disabledBtnExport;
	}
	public List<WrapperBeanObject<ReplacementValueSP>> replacementValueSPList;
	
	public ReplacementValueSP getReplacementValueSP() {
		return replacementValueSP;
	}
	public List<WrapperBeanObject<ReplacementValueSP>> getReplacementValueSPList() {
		return replacementValueSPList;
	}
	public void setReplacementValueSPList(
			List<WrapperBeanObject<ReplacementValueSP>> replacementValueSPList) {
		this.replacementValueSPList = replacementValueSPList;
	}
	public void setReplacementValueSP(ReplacementValueSP replacementValueSP) {
		this.replacementValueSP = replacementValueSP;
	}
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
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
	
	public void setEditReplacement(Replacement editReplacement) {
		this.editReplacement = editReplacement;
	}
	public Replacement getEditReplacement() {
		return editReplacement;
	}
	
	public boolean isChkSelAll() {
		return chkSelAll;
	}
	public void setChkSelAll(boolean chkSelAll) {
		this.chkSelAll = chkSelAll;
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
