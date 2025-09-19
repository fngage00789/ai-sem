package th.co.ais.web.gm.bean;

import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.gm.LovMaster;
import th.co.ais.domain.gm.ParameterMaster;
import th.co.ais.domain.gm.ParameterMasterSP;
import th.co.ais.service.util.ServiceConstants;
import th.co.ais.web.bean.AbstractBean;

public class SEMMCT008Bean extends AbstractBean {

	// for search criteria
	private ParameterMasterSP paramMasterCriteria;
	// for editing
	private ParameterMaster paramMaster;
	// for displaying
	private List<ParameterMasterSP> paramMasterList;
	// select item for searching page.
	private List<SelectItem> lovTypeSelCrtList;
	
	private List<SelectItem> companyList;
	
	private String type1;
	private String type2;
	
	// mode
	private String mode = ServiceConstants.MODULE_ACTION_INSERT;

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public ParameterMasterSP getParamMasterCriteria() {
		if (paramMasterCriteria == null) {
			paramMasterCriteria = new ParameterMasterSP();
		}
		return paramMasterCriteria;
	}

	public void setParamMasterCriteria(ParameterMasterSP paramMasterCriteria) {
		this.paramMasterCriteria = paramMasterCriteria;
	}

	public ParameterMaster getParamMaster() {
		if (paramMaster == null) {
			paramMaster = new ParameterMaster();
		}
		return paramMaster;
	}

	public void setParamMaster(ParameterMaster paramMaster) {
		this.paramMaster = paramMaster;
	}

	public List<ParameterMasterSP> getParamMasterList() {
		return paramMasterList;
	}

	public void setParamMasterList(List<ParameterMasterSP> paramMasterList) {
		this.paramMasterList = paramMasterList;
	}

	public List<SelectItem> getLovTypeSelCrtList() {
		return lovTypeSelCrtList;
	}

	public void setLovTypeSelCrtList(List<SelectItem> lovTypeSelCrtList) {
		this.lovTypeSelCrtList = lovTypeSelCrtList;
	}

	public List<SelectItem> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<SelectItem> companyList) {
		this.companyList = companyList;
	}

	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}

	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}

	public String getType1() {
		return type1;
	}

	public void setType1(String type1) {
		this.type1 = type1;
	}

	public String getType2() {
		return type2;
	}

	public void setType2(String type2) {
		this.type2 = type2;
	}
	
}
