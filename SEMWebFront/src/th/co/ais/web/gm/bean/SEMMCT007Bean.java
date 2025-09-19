package th.co.ais.web.gm.bean;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.gm.LovMaster;
import th.co.ais.service.util.ServiceConstants;
import th.co.ais.web.bean.AbstractBean;

public class SEMMCT007Bean extends AbstractBean{
	
	
	//for search criteria
	private LovMaster lovMasterCriteria;
	//for editing
	private LovMaster lovMaster;
	//for displaying
	private List<LovMaster> lovMasterList;
	//select item
	private List<SelectItem> lovTypeSelList;
	//select item for searching page.
	private List<SelectItem> lovTypeSelCrtList;
	//mode 
	private String mode = ServiceConstants.MODULE_ACTION_INSERT;
	
	private String groupTypeSelected;
	private String type1;
	private String type2;
	private String type3;
	private String type4;
	private String type5;
	private String type6;
	
	private String txtLovTypeDisplay;
	
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	
	public LovMaster getLovMasterCriteria() {
		if(lovMasterCriteria == null)
			lovMasterCriteria = new LovMaster();
		return lovMasterCriteria;
	}
	public void setLovMasterCriteria(LovMaster lovMasterCriteria) {
		this.lovMasterCriteria = lovMasterCriteria;
	}
	public LovMaster getLovMaster() {
		if(lovMaster == null)
			lovMaster = new LovMaster();
		return lovMaster;
	}
	public void setLovMaster(LovMaster lovMaster) {
		this.lovMaster = lovMaster;
	}
	public List<LovMaster> getLovMasterList() {
		if(lovMasterList == null)
			lovMasterList = new ArrayList<LovMaster>();
		return lovMasterList;
	}
	public void setLovMasterList(List<LovMaster> lovMasterList) {
		this.lovMasterList = lovMasterList;
	}
	
	public List<SelectItem> getLovTypeSelList() {
		if(lovTypeSelList == null)
			lovTypeSelList = new LinkedList<SelectItem>();
		return lovTypeSelList;
	}
	public void setLovTypeSelList(List<SelectItem> lovTypeSelList) {
		this.lovTypeSelList = lovTypeSelList;
	}
	
	public List<SelectItem> getLovTypeSelCrtList() {
		return lovTypeSelCrtList;
	}
	public void setLovTypeSelCrtList(List<SelectItem> lovTypeSelCrtList) {
		this.lovTypeSelCrtList = lovTypeSelCrtList;
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
	public String getType3() {
		return type3;
	}
	public void setType3(String type3) {
		this.type3 = type3;
	}
	public String getType4() {
		return type4;
	}
	public void setType4(String type4) {
		this.type4 = type4;
	}
	public String getType5() {
		return type5;
	}
	public void setType5(String type5) {
		this.type5 = type5;
	}
	public String getType6() {
		return type6;
	}
	public void setType6(String type6) {
		this.type6 = type6;
	}
	public String getGroupTypeSelected() {
		return groupTypeSelected;
	}
	public void setGroupTypeSelected(String groupTypeSelected) {
		this.groupTypeSelected = groupTypeSelected;
	}
	public String getTxtLovTypeDisplay() {
		return txtLovTypeDisplay;
	}
	public void setTxtLovTypeDisplay(String txtLovTypeDisplay) {
		this.txtLovTypeDisplay = txtLovTypeDisplay;
	}
	
}
