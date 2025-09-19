package th.co.ais.web.ir.bean;

import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.ir.Mir005SP;
import th.co.ais.web.bean.AbstractBean;

public class SEMMIR005Bean extends AbstractBean{
	
	private static final long serialVersionUID = 7415068927538726835L;
	
	private List<SelectItem> companyList;
	private List<SelectItem> networkTypeList;
	private List<SelectItem> transferTypeList;
	private List<SelectItem> policyTypeList;
	
	private Mir005SP criteria;
	private List<Mir005SP> resultList;
	
	private Mir005SP tmpSave;
	private String tmpDelId;
	
	public SEMMIR005Bean(List<SelectItem> companyList, List<SelectItem> networkTypeList, List<SelectItem> transferTypeList, List<SelectItem> policyTypeList){
		this.companyList = companyList;
		this.networkTypeList = networkTypeList;
		this.transferTypeList = transferTypeList;
		this.policyTypeList = policyTypeList;
		
		criteria = new Mir005SP();
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

	public List<Mir005SP> getResultList() {
		return resultList;
	}

	public void setResultList(List<Mir005SP> resultList) {
		this.resultList = resultList;
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
	
	public Mir005SP getCriteria() {
		return criteria;
	}

	public void setCriteria(Mir005SP criteria) {
		this.criteria = criteria;
	}
	
	public List<SelectItem> getPolicyTypeList() {
		return policyTypeList;
	}

	public void setPolicyTypeList(List<SelectItem> policyTypeList) {
		this.policyTypeList = policyTypeList;
	}

	public Mir005SP getTmpSave() {
		return tmpSave;
	}

	public void setTmpSave(Mir005SP tmpSave) {
		this.tmpSave = tmpSave;
	}

	public String getTmpDelId() {
		return tmpDelId;
	}

	public void setTmpDelId(String tmpDelId) {
		this.tmpDelId = tmpDelId;
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
