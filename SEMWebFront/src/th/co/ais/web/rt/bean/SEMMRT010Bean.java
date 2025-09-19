package th.co.ais.web.rt.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;
import org.richfaces.model.TreeNode;

import th.co.ais.domain.common.MenuTreeSP;
import th.co.ais.domain.gm.VendorMasterSP;
import th.co.ais.domain.rt.DepositDetail;
import th.co.ais.domain.rt.Mrt001BalanceCal;
import th.co.ais.domain.rt.Mrt001BookBank;
import th.co.ais.domain.rt.Mrt010IfrsInterface;
import th.co.ais.domain.rt.Mrt001RentCal;
import th.co.ais.domain.rt.Mrt001SrchDpstCond;
import th.co.ais.domain.rt.Mrt001SrchDpstDetail;
import th.co.ais.domain.rt.Mrt001SrchRentDetail;
import th.co.ais.domain.rt.Mrt001SrchRentHist;
import th.co.ais.domain.rt.Mrt001SrchRentPay;
import th.co.ais.domain.rt.Mrt010IfrsTodolistDetail;
import th.co.ais.domain.rt.RentalDetail;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.bean.AbstractBean;
import th.co.ais.web.bean.TreeUtilBean;

public class SEMMRT010Bean extends AbstractBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4424407255923262019L;

	private List<SelectItem> companyList;
	private List<SelectItem> regionList;
	private List<WrapperBeanObject<Mrt010IfrsInterface>> resultList;
	private List<WrapperBeanObject<Mrt010IfrsInterface>> searchResultList;
	private boolean chkSelAll = false;
	private String backPage;
	private Mrt010IfrsTodolistDetail displayFrmTodoList;
	private Mrt010IfrsInterface criteria;

	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}

	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}

	public List<SelectItem> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<SelectItem> companyList) {
		this.companyList = companyList;
	}

	public List<SelectItem> getRegionList() {
		return regionList;
	}

	public void setRegionList(List<SelectItem> regionList) {
		this.regionList = regionList;
	}

	public List<WrapperBeanObject<Mrt010IfrsInterface>> getResultList() {
		return resultList;
	}

	public void setResultList(List<WrapperBeanObject<Mrt010IfrsInterface>> resultList) {
		this.resultList = resultList;
	}

	public List<WrapperBeanObject<Mrt010IfrsInterface>> getSearchResultList() {
		return searchResultList;
	}

	public void setSearchResultList(List<WrapperBeanObject<Mrt010IfrsInterface>> searchResultList) {
		this.searchResultList = searchResultList;
	}

	public boolean isChkSelAll() {
		return chkSelAll;
	}

	public void setChkSelAll(boolean chkSelAll) {
		this.chkSelAll = chkSelAll;
	}

	public Mrt010IfrsInterface getCriteria() {
		return criteria;
	}

	public void setCriteria(Mrt010IfrsInterface criteria) {
		this.criteria = criteria;
	}

	public Mrt010IfrsTodolistDetail getDisplayFrmTodoList() {
		return displayFrmTodoList;
	}

	public void setDisplayFrmTodoList(Mrt010IfrsTodolistDetail displayFrmTodoList) {
		this.displayFrmTodoList = displayFrmTodoList;
	}

	public String getBackPage() {
		return backPage;
	}

	public void setBackPage(String backPage) {
		this.backPage = backPage;
	}

}
