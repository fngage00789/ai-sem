package th.co.ais.web.ir.bean;

import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.ir.Mir006SP;
import th.co.ais.web.bean.AbstractBean;

public class SEMMIR006Bean extends AbstractBean{
	
	private static final long serialVersionUID = 7415068927538726835L;
	
	private List<SelectItem> companyList;
	private List<SelectItem> networkTypeList;
	
	private Mir006SP criteria;
	private List<Mir006SP> resultList;
	
	private Mir006SP tmpSave;
	private String tmpDelId;
	
	public SEMMIR006Bean(List<SelectItem> companyList, List<SelectItem> networkTypeList){
		this.companyList = companyList;
		this.networkTypeList = networkTypeList;
		
		criteria = new Mir006SP();
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

	public List<Mir006SP> getResultList() {
		return resultList;
	}

	public void setResultList(List<Mir006SP> resultList) {
		this.resultList = resultList;
	}

	public void setNetworkTypeList(List<SelectItem> networkTypeList) {
		this.networkTypeList = networkTypeList;
	}
	
	public Mir006SP getCriteria() {
		return criteria;
	}

	public void setCriteria(Mir006SP criteria) {
		this.criteria = criteria;
	}

	public Mir006SP getTmpSave() {
		return tmpSave;
	}

	public void setTmpSave(Mir006SP tmpSave) {
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
