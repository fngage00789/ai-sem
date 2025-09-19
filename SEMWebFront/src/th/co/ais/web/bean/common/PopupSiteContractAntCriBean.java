package th.co.ais.web.bean.common;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.si.PopupContractAntCriSearchSP;
import th.co.ais.web.bean.AbstractBean;

public class PopupSiteContractAntCriBean extends AbstractBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2194140271321492862L;
	private PopupContractAntCriSearchSP popupContractCriteria;
	private List<PopupContractAntCriSearchSP> contractList;
	private List<SelectItem> companyList = new ArrayList<SelectItem>();
	private String page;
	private String fromButton;
	private String contractNo;

	public PopupContractAntCriSearchSP getPopupContractCriteria() {
		return popupContractCriteria;
	}

	public void setPopupContractCriteria(
			PopupContractAntCriSearchSP popupContractCriteria) {
		this.popupContractCriteria = popupContractCriteria;
	}

	public List<PopupContractAntCriSearchSP> getContractList() {
		return contractList;
	}

	public void setContractList(List<PopupContractAntCriSearchSP> contractList) {
		this.contractList = contractList;
	}

	public List<SelectItem> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<SelectItem> companyList) {
		this.companyList = companyList;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getFromButton() {
		return fromButton;
	}

	public void setFromButton(String fromButton) {
		this.fromButton = fromButton;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	@Override
	public int getRowPerPage() {
		return 10;
	}

	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = 10;
	}
}
