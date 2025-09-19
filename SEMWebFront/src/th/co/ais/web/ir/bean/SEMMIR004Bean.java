package th.co.ais.web.ir.bean;

import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.ir.Mir004SP;
import th.co.ais.web.bean.AbstractBean;

public class SEMMIR004Bean extends AbstractBean{

	private static final long serialVersionUID = 1570007078020659367L;
	
	private List<SelectItem> companyList;
	private List<SelectItem> networkTypeList;
	private List<SelectItem> transferTypeList;
	private List<SelectItem> lossTypeList;
	
	private Mir004SP criteria;
	private List<Mir004SP> resultList;
	
	private Mir004SP tmpSave;
	private String tmpDelId;
	
	public SEMMIR004Bean(List<SelectItem> companyList, List<SelectItem> networkType, 
			List<SelectItem> transferTypeList, List<SelectItem> lossTypeList){
		this.companyList = companyList;
		this.networkTypeList = networkType;
		this.transferTypeList = transferTypeList;
		this.lossTypeList = lossTypeList;
		
		criteria = new Mir004SP();
	}

	public List<SelectItem> getLossTypeList() {
		return lossTypeList;
	}

	public void setLossTypeList(List<SelectItem> lossTypeList) {
		this.lossTypeList = lossTypeList;
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

	public List<Mir004SP> getResultList() {
		return resultList;
	}

	public void setResultList(List<Mir004SP> resultList) {
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
	
	public Mir004SP getCriteria() {
		return criteria;
	}

	public void setCriteria(Mir004SP criteria) {
		this.criteria = criteria;
	}

	public Mir004SP getTmpSave() {
		return tmpSave;
	}

	public void setTmpSave(Mir004SP tmpSave) {
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
