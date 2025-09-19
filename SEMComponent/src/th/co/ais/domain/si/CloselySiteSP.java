package th.co.ais.domain.si;

import java.io.Serializable;
import java.util.Date;

import th.co.ais.domain.AbstractDomain;
import th.co.ais.rpt.util.annotation.PCell;

public class CloselySiteSP extends AbstractDomain implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7451634706115784244L;
	
	private String rowId;
	private String contractNo;
	private String oldContractNo;
//	private String contractDate;
	private String effDt;
	private String expDt;
	private Date effDate;
	private Date expDate;
	private String address;
	private String placeType;
	private Double rtAmountPerYer;
	private Double svAmountPerYer;
	private Double rtAmountCenter;
	private Double svAmountCenter;
	
	private String effDateStr;
	private String expDateStr;
	
	@Override
	public String getCreateBy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getCreateDt() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUpdateBy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getUpdateDt() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCreateBy(String createBy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCreateDt(Date createDt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUpdateBy(String updateBy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUpdateDt(Date updateDt) {
		// TODO Auto-generated method stub
		
	}
	@PCell(cellType = String.class ,no = 0, manualStyleName = "rt003Field")
	public String getContractNo() {
		return contractNo;
	}
	
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	@PCell(cellType = String.class ,no = 1, manualStyleName = "rt003Field")
	public String getOldContractNo() {
		return oldContractNo;
	}

	public void setOldContractNo(String oldContractNo) {
		this.oldContractNo = oldContractNo;
	}
	@PCell(cellType = String.class ,no = 4, manualStyleName = "rt003Field")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@PCell(cellType = String.class ,no = 5, manualStyleName = "rt003Field")
	public String getPlaceType() {
		return placeType;
	}

	public void setPlaceType(String placeType) {
		this.placeType = placeType;
	}

	public String getEffDt() {
		return effDt;
	}

	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}

	public String getExpDt() {
		return expDt;
	}

	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}
	@PCell(cellType = Date.class ,no = 2, manualStyleName = "rt003Field")
	public Date getEffDate() {
		return effDate;
	}
	
	public void setEffDate(Date effDate) {
		this.effDate = effDate;
	}
	@PCell(cellType = Date.class ,no = 3, manualStyleName = "rt003Field")
	public Date getExpDate() {
		return expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}
	@PCell(cellType = Double.class ,no = 6, manualStyleName = "rt003Field")
	public Double getRtAmountPerYer() {
		return rtAmountPerYer;
	}

	public void setRtAmountPerYer(Double rtAmountPerYer) {
		this.rtAmountPerYer = rtAmountPerYer;
	}
	@PCell(cellType = Double.class ,no = 7, manualStyleName = "rt003Field")
	public Double getSvAmountPerYer() {
		return svAmountPerYer;
	}

	public void setSvAmountPerYer(Double svAmountPerYer) {
		this.svAmountPerYer = svAmountPerYer;
	}
	@PCell(cellType = Double.class ,no = 8, manualStyleName = "rt003Field")
	public Double getRtAmountCenter() {
		return rtAmountCenter;
	}

	public void setRtAmountCenter(Double rtAmountCenter) {
		this.rtAmountCenter = rtAmountCenter;
	}
	@PCell(cellType = Double.class ,no = 9, manualStyleName = "rt003Field")
	public Double getSvAmountCenter() {
		return svAmountCenter;
	}

	public void setSvAmountCenter(Double svAmountCenter) {
		this.svAmountCenter = svAmountCenter;
	}

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public String getEffDateStr() {
		return effDateStr;
	}

	public void setEffDateStr(String effDateStr) {
		this.effDateStr = effDateStr;
	}

	public String getExpDateStr() {
		return expDateStr;
	}

	public void setExpDateStr(String expDateStr) {
		this.expDateStr = expDateStr;
	}
	
}
