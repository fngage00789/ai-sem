package th.co.ais.web.report.bean;

import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.pt.Mpt006Srch;
import th.co.ais.web.bean.AbstractBean;

public class SEMMPT006Bean extends AbstractBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<SelectItem> propertyTaxTypeList;
	
	private List<Mpt006Srch> mpt006SrchList; 
	private Mpt006Srch mpt006Srch;
	private Boolean disPlaybtnBack;
	private String paramNavModule;
	private String paramNavProgram ;
	private String paramModuleWithNavi;
	private String paramActionWithNavi;
	private String paramMethodWithNavi;
	
	
	
	
	
	public String getParamNavModule() {
		return paramNavModule;
	}
	public void setParamNavModule(String paramNavModule) {
		this.paramNavModule = paramNavModule;
	}
	public String getParamNavProgram() {
		return paramNavProgram;
	}
	public void setParamNavProgram(String paramNavProgram) {
		this.paramNavProgram = paramNavProgram;
	}
	public String getParamModuleWithNavi() {
		return paramModuleWithNavi;
	}
	public void setParamModuleWithNavi(String paramModuleWithNavi) {
		this.paramModuleWithNavi = paramModuleWithNavi;
	}
	public String getParamActionWithNavi() {
		return paramActionWithNavi;
	}
	public void setParamActionWithNavi(String paramActionWithNavi) {
		this.paramActionWithNavi = paramActionWithNavi;
	}
	public String getParamMethodWithNavi() {
		return paramMethodWithNavi;
	}
	public void setParamMethodWithNavi(String paramMethodWithNavi) {
		this.paramMethodWithNavi = paramMethodWithNavi;
	}
	public Boolean getDisPlaybtnBack() {
		return disPlaybtnBack;
	}
	public void setDisPlaybtnBack(Boolean disPlaybtnBack) {
		this.disPlaybtnBack = disPlaybtnBack;
	}
	public List<Mpt006Srch> getMpt006SrchList() {
		return mpt006SrchList;
	}
	public void setMpt006SrchList(List<Mpt006Srch> mpt006SrchList) {
		this.mpt006SrchList = mpt006SrchList;
	}
	public Mpt006Srch getMpt006Srch() {
		return mpt006Srch;
	}
	public void setMpt006Srch(Mpt006Srch mpt006Srch) {
		this.mpt006Srch = mpt006Srch;
	}
	public List<SelectItem> getPropertyTaxTypeList() {
		return propertyTaxTypeList;
	}
	public void setPropertyTaxTypeList(List<SelectItem> propertyTaxTypeList) {
		this.propertyTaxTypeList = propertyTaxTypeList;
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
