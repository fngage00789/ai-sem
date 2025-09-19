package th.co.ais.web.ir.bean;

import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.ir.Mir003SP;
import th.co.ais.web.bean.AbstractBean;

public class SEMMIR003Bean extends AbstractBean{

	private static final long serialVersionUID = 1570007078020659367L;
	
	private List<SelectItem> companyList;
	private List<SelectItem> networkTypeList;
	private List<SelectItem> transferTypeList;
	
	private Mir003SP criteria;
	private List<Mir003SP> resultList;
	
	private Mir003SP tmpSave;
	private String tmpDelId;
	
	public SEMMIR003Bean(List<SelectItem> companyList, List<SelectItem> networkType, List<SelectItem> transferTypeList){
		this.companyList = companyList;
		this.networkTypeList = networkType;
		this.transferTypeList = transferTypeList;
		
		criteria = new Mir003SP();
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

	public List<Mir003SP> getResultList() {
		return resultList;
	}


	public void setResultList(List<Mir003SP> resultList) {
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
	
	public Mir003SP getCriteria() {
		return criteria;
	}

	public void setCriteria(Mir003SP criteria) {
		this.criteria = criteria;
	}

	public Mir003SP getTmpSave() {
		return tmpSave;
	}

	public void setTmpSave(Mir003SP tmpSave) {
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
