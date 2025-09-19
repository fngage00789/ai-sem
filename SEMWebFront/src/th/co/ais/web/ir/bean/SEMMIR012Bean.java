package th.co.ais.web.ir.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.faces.model.SelectItem;

import th.co.ais.domain.ir.IrClaim;
import th.co.ais.domain.ir.IrClaimDetail;
import th.co.ais.rpt.service.ServiceConstants;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.report.AbstractReportBean;

public class SEMMIR012Bean extends AbstractReportBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5087583040180099543L;
	private IrClaim irClaim;
	private IrClaimDetail irClaimDetail;

	private IrClaim irClaimSrch;
	private List<IrClaim> irClaimListSrch;

	private List<String> irClaimDetailKeySet;
	private Map<String, WrapperBeanObject<IrClaimDetail>> irClaimDetailList;
	private Map<String, WrapperBeanObject<IrClaimDetail>> irClaimDetailQueueList;

	private List<SelectItem> regionSelList;
	private List<SelectItem> provinceSelList;
	private List<SelectItem> transferSelList;
	private List<SelectItem> lossTypeSelList;
	private List<SelectItem> lossSubTypeSelList;
	private List<SelectItem> claimStatusSelList;

	private boolean disabledBtnSrchLocation = false;

	private String hintFooter;
	
	private boolean renderBackBtn = false;

	public SEMMIR012Bean() {
		super(ServiceConstants.TYPE_DOC);
	}
	
	public IrClaim getIrClaim() {
		return irClaim;
	}

	public void setIrClaim(IrClaim irClaim) {
		this.irClaim = irClaim;
	}

	public IrClaimDetail getIrClaimDetail() {
		return irClaimDetail;
	}

	public void setIrClaimDetail(IrClaimDetail irClaimDetail) {
		this.irClaimDetail = irClaimDetail;
	}

	public IrClaim getIrClaimSrch() {
		return irClaimSrch;
	}

	public void setIrClaimSrch(IrClaim irClaimSrch) {
		this.irClaimSrch = irClaimSrch;
	}

	public List<IrClaim> getIrClaimListSrch() {
		return irClaimListSrch;
	}

	public void setIrClaimListSrch(List<IrClaim> irClaimListSrch) {
		this.irClaimListSrch = irClaimListSrch;
	}

	public List<String> getIrClaimDetailKeySet() {
		if (irClaimDetailKeySet == null) {
			irClaimDetailKeySet = new ArrayList<String>();
		}
		return irClaimDetailKeySet;
	}

	public void setIrClaimDetailKeySet(List<String> irClaimDetailKeySet) {
		this.irClaimDetailKeySet = irClaimDetailKeySet;
	}

	public Map<String, WrapperBeanObject<IrClaimDetail>> getIrClaimDetailList() {
		if (irClaimDetailList == null) {
			irClaimDetailList = new TreeMap<String, WrapperBeanObject<IrClaimDetail>>();
		}
		return irClaimDetailList;
	}

	public void setIrClaimDetailList(
			Map<String, WrapperBeanObject<IrClaimDetail>> irClaimDetailList) {
		this.irClaimDetailList = irClaimDetailList;
	}

	public Map<String, WrapperBeanObject<IrClaimDetail>> getIrClaimDetailQueueList() {
		if (irClaimDetailQueueList == null) {
			irClaimDetailQueueList = new TreeMap<String, WrapperBeanObject<IrClaimDetail>>();
		}
		return irClaimDetailQueueList;
	}

	public void setIrClaimDetailQueueList(
			Map<String, WrapperBeanObject<IrClaimDetail>> irClaimDetailQueueList) {
		this.irClaimDetailQueueList = irClaimDetailQueueList;
	}

	public List<SelectItem> getRegionSelList() {
		if (regionSelList == null) {
			regionSelList = getEmptyDropDown();
		}
		return regionSelList;
	}

	public void setRegionSelList(List<SelectItem> regionSelList) {
		this.regionSelList = regionSelList;
	}

	public List<SelectItem> getProvinceSelList() {
		if (provinceSelList == null) {
			provinceSelList = getEmptyDropDown();
		}
		return provinceSelList;
	}

	public void setProvinceSelList(List<SelectItem> provinceSelList) {
		this.provinceSelList = provinceSelList;
	}

	public List<SelectItem> getTransferSelList() {
		if (transferSelList == null) {
			transferSelList = getEmptyDropDown();
		}
		return transferSelList;
	}

	public void setTransferSelList(List<SelectItem> transferSelList) {
		this.transferSelList = transferSelList;
	}

	public List<SelectItem> getLossTypeSelList() {
		if (lossTypeSelList == null) {
			lossTypeSelList = getEmptyDropDown();
		}
		return lossTypeSelList;
	}

	public void setLossTypeSelList(List<SelectItem> lossTypeSelList) {
		this.lossTypeSelList = lossTypeSelList;
	}

	public List<SelectItem> getLossSubTypeSelList() {
		if (lossSubTypeSelList == null) {
			lossSubTypeSelList = getEmptyDropDown();
		}
		return lossSubTypeSelList;
	}

	public void setLossSubTypeSelList(List<SelectItem> lossSubTypeSelList) {
		this.lossSubTypeSelList = lossSubTypeSelList;
	}

	public List<SelectItem> getClaimStatusSelList() {
		if (claimStatusSelList == null) {
			claimStatusSelList = getEmptyDropDown();
		}
		return claimStatusSelList;
	}

	public void setClaimStatusSelList(List<SelectItem> claimStatusSelList) {
		this.claimStatusSelList = claimStatusSelList;
	}

	public boolean isDisabledBtnSrchLocation() {
		return disabledBtnSrchLocation;
	}

	public void setDisabledBtnSrchLocation(boolean disabledBtnSrchLocation) {
		this.disabledBtnSrchLocation = disabledBtnSrchLocation;
	}

	public String getHintFooter() {
		return hintFooter;
	}

	public void setHintFooter(String hintFooter) {
		this.hintFooter = hintFooter;
	}

	public boolean isRenderBackBtn() {
		return renderBackBtn;
	}

	public void setRenderBackBtn(boolean renderBackBtn) {
		this.renderBackBtn = renderBackBtn;
	}

	@Override
	public int getRowPerPage() {
		return rowPerPage;
	}

	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}

}
