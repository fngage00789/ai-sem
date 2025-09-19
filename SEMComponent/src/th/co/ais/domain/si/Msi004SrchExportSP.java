package th.co.ais.domain.si;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;

import th.co.ais.domain.AbstractDomain;
import th.co.ais.rpt.util.annotation.PCell;
import th.co.ais.rpt.util.enums.EnumDocStyle;
import th.co.ais.util.SEMDataUtility;

public class Msi004SrchExportSP extends AbstractDomain{
	
	private static final long serialVersionUID = 4773941307374477024L;
	private static NumberFormat format = new DecimalFormat("#0.00");	
	private String rowId;
	private String company;
	private String region;
	private String reqTypeName;
	private String siteInfoId;
	private String contractNo;
	private String siteName;
	private String locationId;
	private String locationCode;
	private String phase;
	private String systemName;
	private Date effDate;
	private Date expireDate;
	private String address;
	private String street;
	private String tambon;
	private String amphur;
	private String province;
	private String ownerName;
	private String tel;
	private String siteTypeName;
	private Double deckArea;
	private Double roomArea;
	private Double landAreaSqm;
	private Double landAreaSqw;
	private Double rentAmtMonth;
	private Double rentAmtYear;
	private Double sumRentAmt;
	private Double serviceAmtMonth;
	private Double serviceAmtYear;
	private Double sumServiceAmt;
	private Double sumRentServiceAmt;
	private int no;
	private String placeTypeName;
	
	@PCell(cellType = String.class, no = 0)
	public String getStringNo() {
		return no + "";
	}
	
	@PCell(cellType = String.class, no = 1)
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@PCell(cellType = String.class, no = 2)
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@PCell(cellType = String.class, no = 3)
	public String getReqTypeName() {
		return reqTypeName;
	}

	public void setReqTypeName(String reqTypeName) {
		this.reqTypeName = reqTypeName;
	}

	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	public String getSiteInfoId() {
		return siteInfoId;
	}
	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}
	
	@PCell(cellType = String.class, no = 4)
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	
	@PCell(cellType = String.class, no = 5)
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	
	@PCell(cellType = String.class, no = 6)
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	
	@PCell(cellType = String.class, no = 7)
	public String getLocationCode() {
		return locationCode;
	}
	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}
	
	@PCell(cellType = String.class, no = 8)
	public String getPhase() {
		return phase;
	}
	public void setPhase(String phase) {
		this.phase = phase;
	}
	
	@PCell(cellType = String.class, no = 9)
	public String getSystemName() {
		return systemName;
	}
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
	
	@PCell(cellType = Date.class, no = 10)
	public Date getEffDate() {
		return effDate;
	}
	public void setEffDate(Date effDate) {
		this.effDate = effDate;
	}
	
	@PCell(cellType = Date.class, no = 11)
	public Date getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}
	
	
	@PCell(cellType = String.class, no = 12)
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@PCell(cellType = String.class, no = 13)
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	@PCell(cellType = String.class, no = 14)
	public String getTambon() {
		return tambon;
	}
	public void setTambon(String tambon) {
		this.tambon = tambon;
	}
	
	@PCell(cellType = String.class, no = 15)
	public String getAmphur() {
		return amphur;
	}
	public void setAmphur(String amphur) {
		this.amphur = amphur;
	}
	
	@PCell(cellType = String.class, no = 16)
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	
	@PCell(cellType = String.class, no = 17)
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	
	@PCell(cellType = String.class, no = 18)
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public String getSiteTypeName() {
		return siteTypeName;
	}
	public void setSiteTypeName(String siteTypeName) {
		this.siteTypeName = siteTypeName;
	}
	
	public Double getDeckArea() {
		return deckArea;
	}
	
	@PCell(cellType = String.class, no = 20)
	public String getStringDeckArea() {
		if(deckArea != null){
			return format.format(new Double(deckArea).doubleValue());
		}
		return "";
	}
	
	public void setDeckArea(Double deckArea) {
		this.deckArea = deckArea;
	}
	
	public Double getRoomArea() {
		return roomArea;
	}
	
	@PCell(cellType = String.class, no = 21)
	public String getStringRoomArea() {
		if(roomArea != null){
			return format.format(new Double(roomArea).doubleValue());
		}
		return "";
	}
	
	public void setRoomArea(Double roomArea) {
		this.roomArea = roomArea;
	}
	
	public Double getLandAreaSqm() {
		return landAreaSqm;
	}
	
	@PCell(cellType = String.class, no = 22)
	public String getStringLandAreaSqm() {
		if(landAreaSqm != null){
			return format.format(new Double(landAreaSqm).doubleValue());
		}
		return "";
	}
	
	public void setLandAreaSqm(Double landAreaSqm) {
		this.landAreaSqm = landAreaSqm;
	}
	
	public Double getLandAreaSqw() {
		return landAreaSqw;
	}
	
	@PCell(cellType = String.class, no = 23)
	public String getStringLandAreaSqw() {
		if(landAreaSqw != null){
			return format.format(new Double(landAreaSqw).doubleValue());
		}
		return "";
	}
	
	public void setLandAreaSqw(Double landAreaSqw) {
		this.landAreaSqw = landAreaSqw;
	}
	
	public Double getRentAmtMonth() {
		return rentAmtMonth;
	}
	
	@PCell(cellType = String.class, no = 24)
	public String getStringRentAmtMonth() {
		if(rentAmtMonth != null){
			return format.format(new Double(rentAmtMonth).doubleValue());
		}
		return "";
	}
	
	public void setRentAmtMonth(Double rentAmtMonth) {
		this.rentAmtMonth = rentAmtMonth;
	}
	
	public Double getRentAmtYear() {
		return rentAmtYear;
	}
	
	@PCell(cellType = String.class, no = 25)
	public String getStringAmtYear() {
		if(rentAmtYear != null){
			return format.format(new Double(rentAmtYear).doubleValue());
		}
		return "";
	}
	
	public void setRentAmtYear(Double rentAmtYear) {
		this.rentAmtYear = rentAmtYear;
	}
	

	public Double getSumRentAmt() {
		return sumRentAmt;
	}
	@PCell(cellType = String.class, no = 26)
	public String getStringSumRentAmt() {
		if(sumRentAmt != null){
			return format.format(new Double(sumRentAmt).doubleValue());
		}
		return "";
	}
	
	public void setSumRentAmt(Double sumRentAmt) {
		this.sumRentAmt = sumRentAmt;
	}
	
	public Double getServiceAmtMonth() {
		return serviceAmtMonth;
	}
	
	@PCell(cellType = String.class, no = 27)
	public String getStringServiceAmtMonth() {
		if(serviceAmtMonth != null){
			return format.format(new Double(serviceAmtMonth).doubleValue());
		}
		return "";
	}
	
	public void setServiceAmtMonth(Double serviceAmtMonth) {
		this.serviceAmtMonth = serviceAmtMonth;
	}
	
	public Double getServiceAmtYear() {
		return serviceAmtYear;
	}
	
	@PCell(cellType = String.class, no = 28)
	public String getStringServiceAmtYear() {
		if(serviceAmtYear != null){
			return format.format(new Double(serviceAmtYear).doubleValue());
		}
		return "";
	}
	
	public void setServiceAmtYear(Double serviceAmtYear) {
		this.serviceAmtYear = serviceAmtYear;
	}
	
	public Double getSumServiceAmt() {
		return sumServiceAmt;
	}
	
	@PCell(cellType = String.class, no = 29)
	public String getStringSumServiceAmt() {
		if(sumServiceAmt != null){
			return format.format(new Double(sumServiceAmt).doubleValue());
		}
		return "";
	}
	
	public void setSumServiceAmt(Double sumServiceAmt) {
		this.sumServiceAmt = sumServiceAmt;
	}
	
	public Double getSumRentServiceAmt() {
		return sumRentServiceAmt;
	}
	
	@PCell(cellType = String.class, no = 30)
	public String getStringSumRentServiceAmt() {
		if(sumRentServiceAmt != null){
			return format.format(new Double(sumRentServiceAmt).doubleValue());
		}
		return "";
	}
	
	public void setSumRentServiceAmt(Double sumRentServiceAmt) {
		this.sumRentServiceAmt = sumRentServiceAmt;
	}
	@Override
	public String getCreateBy() {
		return this.createBy;
	}
	@Override
	public Date getCreateDt() {
		return this.createDt;
	}
	@Override
	public String getUpdateBy() {
		return this.updateBy;
	}
	@Override
	public Date getUpdateDt() {
		return this.updateDt;
	}
	@Override
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	@Override
	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}
	@Override
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	@Override
	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	}
	
	@PCell(cellType = String.class, no = 19)
	public String getPlaceTypeName() {
		return placeTypeName;
	}

	public void setPlaceTypeName(String placeTypeName) {
		this.placeTypeName = placeTypeName;
	}
	
}
