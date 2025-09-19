package th.co.ais.web.bean.common;

import java.util.List;

import th.co.ais.domain.si.PopupViewSiteInfoSearchSP;
import th.co.ais.domain.si.Psi003SrchSiteInfo;
import th.co.ais.web.bean.AbstractBean;

public class PopupViewSiteInfoBean extends AbstractBean {

	private static final long serialVersionUID = 6909615740636416423L;

	private PopupViewSiteInfoSearchSP popupViewSiteInfoSearchSP;
	private Psi003SrchSiteInfo psi003SrchSiteInfo;
	private List<Psi003SrchSiteInfo> listSiteInfoSP;
	private int siteInfoIndex;
	private boolean disabledNextBtn;
	private boolean disabledPreviousBtn;
	private int rowPerPage = 10;
	private PopupViewSiteInfoSearchSP popupViewSiteInfoTmp;
	private String STYLE_NORMAL = "ms7";
	private String STYLE_RED = "ms7redBold";
	private String ownerAmphurStyle = this.STYLE_NORMAL;
	private String contractNoStyle = this.STYLE_NORMAL;
	private String oldContractNoStyle = this.STYLE_NORMAL;
	private String siteNameStyle = this.STYLE_NORMAL;
	private String effectiveDtStyle = this.STYLE_NORMAL;
	private String epDtStyle = this.STYLE_NORMAL;
	private String locationIdStyle = this.STYLE_NORMAL;
	private String locationCodeStyle = this.STYLE_NORMAL;
	private String firstEffectiveDtStyle = this.STYLE_NORMAL;
	private String stationTypeStyle = this.STYLE_NORMAL;
	private String addressStyle = this.STYLE_NORMAL;
	private String streetStyle = this.STYLE_NORMAL;
	private String tambonStyle = this.STYLE_NORMAL;
	private String amphurStyle = this.STYLE_NORMAL;
	private String provinceStyle = this.STYLE_NORMAL;
	private String remarkStyle = this.STYLE_NORMAL;
	private String siteTypeStyle = this.STYLE_NORMAL;
	private String deckAreaStyle = this.STYLE_NORMAL;
	private String buildingAreaStyle = this.STYLE_NORMAL;
	private String roomNoStyle = this.STYLE_NORMAL;
	private String roomAreaStyle = this.STYLE_NORMAL;
	private String landAreaStyle = this.STYLE_NORMAL;
	private String reqTypeNameStyle = this.STYLE_NORMAL;
	private String ownerStyle = this.STYLE_NORMAL;
	private String lessorNameStyle = this.STYLE_NORMAL;
	private String ownerAddressStyle = this.STYLE_NORMAL;
	private String ownerStreetStyle = this.STYLE_NORMAL;
	private String ownerTambonStyle = this.STYLE_NORMAL;
	private String ownerProvinceStyle = this.STYLE_NORMAL;
	private String networkStatusStyle = this.STYLE_NORMAL;
	private String siteStatusStyle = this.STYLE_NORMAL;
	private String contractStatusStyle = this.STYLE_NORMAL;
	private String sendTOTStatusStyle = this.STYLE_NORMAL;
	private String docRemainStyle = this.STYLE_NORMAL;
	private String depositCashStyle = this.STYLE_NORMAL;
	private String depositBgStyle = this.STYLE_NORMAL;
	private String depositEtCashStyle = this.STYLE_NORMAL;
	private String depositEtBgStyle = this.STYLE_NORMAL;
	private String rentServiceAmtStyle = this.STYLE_NORMAL;
	private String checkPropertyTaxPayType0Style = this.STYLE_NORMAL;
	private String checkPropertyTaxPayType1Style = this.STYLE_NORMAL;
	private String checkPropertyTaxPayType2Style = this.STYLE_NORMAL;
	private String checkPropertyTaxPayType3Style = this.STYLE_NORMAL;
	private String propertyTaxHistPayStyle = this.STYLE_NORMAL;
	private String electricTypeStyle = this.STYLE_NORMAL;
	private String etUnitPriceAmtStyle = this.STYLE_NORMAL;
	private String takeAllAmtStyle = this.STYLE_NORMAL;
	private String checkTakeAllPeriodTypeYearStyle = this.STYLE_NORMAL;
	private String checkTakeAllPeriodTypeMonthStyle = this.STYLE_NORMAL;
	private String checkELVatType03Style = this.STYLE_NORMAL;
	private String checkELVatType02Style = this.STYLE_NORMAL;
	private String chkElVatType1Style = this.STYLE_NORMAL;
	private String insuranceTypeStyle = this.STYLE_NORMAL;
	private String moneyAmountStyle = this.STYLE_NORMAL;
	private String titleStyle = this.STYLE_NORMAL;
	private String contactNameStyle = this.STYLE_NORMAL;
	private String contactTelStyle = this.STYLE_NORMAL;
	private String contactFaxStyle = this.STYLE_NORMAL;
	private String rentAmtStyle = this.STYLE_NORMAL;
	private String checkServiceVatType0Style = this.STYLE_NORMAL;
	private String checkRentWhtTypeTax0Style = this.STYLE_NORMAL;
	private String checkRentWhtTypeTax1Style = this.STYLE_NORMAL;
	private String checkRentWhtTypeTax2Style = this.STYLE_NORMAL;
	private String checkServiceVatType1Style = this.STYLE_NORMAL;
	private String checkServiceVatType2Style = this.STYLE_NORMAL;
	private String checkServiceWhtTypeTax0Style = this.STYLE_NORMAL;
	private String checkServiceWhtTypeTax1Style = this.STYLE_NORMAL;
	private String checkServiceWhtTypeTax2Style = this.STYLE_NORMAL;
	private String serviceAmtStyle = this.STYLE_NORMAL;
	private String checkRentWhtTypeTaxStyle  = this.STYLE_NORMAL;
	private String checkServiceVatTypeStyle = this.STYLE_NORMAL;
	private String checkServiceWhtTypeTaxStyle = this.STYLE_NORMAL;
	private String checkELVatTypeStyle = this.STYLE_NORMAL;
	
	private boolean displayBtn = false;
	private String siteInfoId;
	
	
	
	
	
	private int count = 0;
	
	public PopupViewSiteInfoSearchSP getPopupViewSiteInfoSearchSP() {
		return popupViewSiteInfoSearchSP;
	}

	public void setPopupViewSiteInfoSearchSP(
			PopupViewSiteInfoSearchSP popupViewSiteInfoSearchSP) {
		this.popupViewSiteInfoSearchSP = popupViewSiteInfoSearchSP;
	}

	public List<Psi003SrchSiteInfo> getListSiteInfoSP() {
		return listSiteInfoSP;
	}

	public void setListSiteInfoSP(List<Psi003SrchSiteInfo> listSiteInfoSP) {
		this.listSiteInfoSP = listSiteInfoSP;
	}

	public int getSiteInfoIndex() {
		return siteInfoIndex;
	}

	public void setSiteInfoIndex(int siteInfoIndex) {
		this.siteInfoIndex = siteInfoIndex;
	}

	public boolean isDisabledNextBtn() {
		return disabledNextBtn;
	}

	public void setDisabledNextBtn(boolean disabledNextBtn) {
		this.disabledNextBtn = disabledNextBtn;
	}

	public boolean isDisabledPreviousBtn() {
		return disabledPreviousBtn;
	}

	public void setDisabledPreviousBtn(boolean disabledPreviousBtn) {
		this.disabledPreviousBtn = disabledPreviousBtn;
	}

	public Psi003SrchSiteInfo getPsi003SrchSiteInfo() {
		return psi003SrchSiteInfo;
	}

	public void setPsi003SrchSiteInfo(Psi003SrchSiteInfo psi003SrchSiteInfo) {
		this.psi003SrchSiteInfo = psi003SrchSiteInfo;
	}

	public String getOwnerAmphurStyle() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.getOwnerAmphur() == null)
				return (this.popupViewSiteInfoTmp.getOwnerAmphur() == null)?this.STYLE_NORMAL:this.STYLE_RED;
			else
				return (this.popupViewSiteInfoSearchSP.getOwnerAmphur().equals(this.popupViewSiteInfoTmp.getOwnerAmphur()))?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}

	}
	public void setOwnerAmphurStyle(String ownerAmphurStyle) {
		this.ownerAmphurStyle = ownerAmphurStyle;
	}
	
	public void setOwnerAmphur(String ownerAmphurStyle) {
		this.ownerAmphurStyle = ownerAmphurStyle;
	}
	
	public String getContractNoStyle() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.getContractNo() == null)
				return (this.popupViewSiteInfoTmp.getContractNo() == null)?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.getContractNo().equals(this.popupViewSiteInfoTmp.getContractNo()))?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setContractNoStyle(String contractNoStyle) {
		this.contractNoStyle = contractNoStyle;
	}

	public String getOldContractNoStyle() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.getOldContractNo() == null)
				return (this.popupViewSiteInfoTmp.getOldContractNo()== null)?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.getOldContractNo().equals(this.popupViewSiteInfoTmp.getOldContractNo()))?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setOldContractNoStyle(String oldContractNoStyle) {
		this.oldContractNoStyle = oldContractNoStyle;
	}	
	
	public String getEffectiveDtStyle() {
//		System.out.println("+++++++ EFF DATE "+popupViewSiteInfoSearchSP.getEffectiveDt());
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.getEffectiveDt() == null)
				return (this.popupViewSiteInfoTmp.getEffectiveDt()== null)?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.getEffectiveDt().equals(this.popupViewSiteInfoTmp.getEffectiveDt()))?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setEffectiveDtStyle(String effectiveDtStyle) {
		this.effectiveDtStyle = effectiveDtStyle;
	}
	
	public String getEpDtStyle() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.getExpireDt() == null)
				return (this.popupViewSiteInfoTmp.getExpireDt()== null)?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.getExpireDt().equals(this.popupViewSiteInfoTmp.getExpireDt()))?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setEpDtStyle(String epDtStyle) {
		this.epDtStyle = epDtStyle;
	}

	public String getSiteNameStyle() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.getSiteName() == null)
				return (this.popupViewSiteInfoTmp.getSiteName()== null)?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.getSiteName().equals(this.popupViewSiteInfoTmp.getSiteName()))?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setSiteNameStyle(String siteNameStyle) {
		this.siteNameStyle = siteNameStyle;
	}

	
	
	public String getLocationIdStyle() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.getLocationId() == null)
				return (this.popupViewSiteInfoTmp.getLocationId()== null)?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.getLocationId().equals(this.popupViewSiteInfoTmp.getLocationId()))?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setLocationIdStyle(String locationIdStyle) {
		this.locationIdStyle = locationIdStyle;
	}

	public String getLocationCodeStyle() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.getLocationCode() == null)
				return (this.popupViewSiteInfoTmp.getLocationCode()== null)?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.getLocationCode().equals(this.popupViewSiteInfoTmp.getLocationCode()))?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setLocationCodeStyle(String locationCodeStyle) {
		this.locationCodeStyle = locationCodeStyle;
	}

	public String getFirstEffectiveDtStyle() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.getFirsteffectiveDt() == null)
				return (this.popupViewSiteInfoTmp.getFirsteffectiveDt()== null)?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.getFirsteffectiveDt().equals(this.popupViewSiteInfoTmp.getFirsteffectiveDt()))?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setFirstEffectiveDtStyle(String firstEffectiveDtStyle) {
		this.firstEffectiveDtStyle = firstEffectiveDtStyle;
	}

	public String getStationTypeStyle() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.getStationType() == null)
				return (this.popupViewSiteInfoTmp.getStationType()== null)?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.getStationType().equals(this.popupViewSiteInfoTmp.getStationType()))?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setStationTypeStyle(String stationTypeStyle) {
		this.stationTypeStyle = stationTypeStyle;
	}

	public String getAddressStyle() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.getAddress() == null)
				return (this.popupViewSiteInfoTmp.getAddress()== null)?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.getAddress().equals(this.popupViewSiteInfoTmp.getAddress()))?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setAddressStyle(String addressStyle) {
		this.addressStyle = addressStyle;
	}

	public String getStreetStyle() {		
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.getStreet() == null)
				return (this.popupViewSiteInfoTmp.getStreet() == null)?this.STYLE_NORMAL:this.STYLE_RED;
			else
				return (this.popupViewSiteInfoSearchSP.getStreet().equals(this.popupViewSiteInfoTmp.getStreet()))?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setStreetStyle(String streetStyle) {
		this.streetStyle = streetStyle;
	}

	public String getTambonStyle() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.getTambon() == null)
				return (this.popupViewSiteInfoTmp.getTambon()== null)?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.getTambon().equals(this.popupViewSiteInfoTmp.getTambon()))?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setTambonStyle(String tambonStyle) {
		this.tambonStyle = tambonStyle;
	}

	public String getAmphurStyle() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.getAmphur() == null)
				return (this.popupViewSiteInfoTmp.getAmphur()== null)?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.getAmphur().equals(this.popupViewSiteInfoTmp.getAmphur()))?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setAmphurStyle(String amphurStyle) {
		this.amphurStyle = amphurStyle;
	}

	public String getProvinceStyle() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.getProvince() == null)
				return (this.popupViewSiteInfoTmp.getProvince()== null)?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.getProvince().equals(this.popupViewSiteInfoTmp.getProvince()))?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setProvinceStyle(String provinceStyle) {
		this.provinceStyle = provinceStyle;
	}

	public String getRemarkStyle() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.getRemark() == null)
				return (this.popupViewSiteInfoTmp.getRemark()== null)?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.getRemark().equals(this.popupViewSiteInfoTmp.getRemark()))?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setRemarkStyle(String remarkStyle) {
		this.remarkStyle = remarkStyle;
	}

	public String getSiteTypeStyle() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.getSiteType() == null)
				return (this.popupViewSiteInfoTmp.getSiteType()== null)?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.getSiteType().equals(this.popupViewSiteInfoTmp.getSiteType()))?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setSiteTypeStyle(String siteTypeStyle) {
		this.siteTypeStyle = siteTypeStyle;
	}

	public String getDeckAreaStyle() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.getDeckArea() == null)
				return (this.popupViewSiteInfoTmp.getDeckArea()== null)?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.getDeckArea().equals(this.popupViewSiteInfoTmp.getDeckArea()))?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setDeckAreaStyle(String deckAreaStyle) {
		this.deckAreaStyle = deckAreaStyle;
	}

	public String getBuildingAreaStyle() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.getBuildingArea() == null)
				return (this.popupViewSiteInfoTmp.getBuildingArea()== null)?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.getBuildingArea().equals(this.popupViewSiteInfoTmp.getBuildingArea()))?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setBuildingAreaStyle(String buildingAreaStyle) {
		this.buildingAreaStyle = buildingAreaStyle;
	}

	public String getRoomNoStyle() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.getRoomNo() == null)
				return (this.popupViewSiteInfoTmp.getRoomNo()== null)?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.getRoomNo().equals(this.popupViewSiteInfoTmp.getRoomNo()))?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setRoomNoStyle(String roomNoStyle) {
		this.roomNoStyle = roomNoStyle;
	}

	public String getRoomAreaStyle() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.getRoomArea() == null)
				return (this.popupViewSiteInfoTmp.getRoomArea()== null)?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.getRoomArea().equals(this.popupViewSiteInfoTmp.getRoomArea()))?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setRoomAreaStyle(String roomAreaStyle) {
		this.roomAreaStyle = roomAreaStyle;
	}

	public String getLandAreaStyle() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.getLandArea() == null)
				return (this.popupViewSiteInfoTmp.getLandArea()== null)?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.getLandArea().equals(this.popupViewSiteInfoTmp.getLandArea()))?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setLandAreaStyle(String landAreaStyle) {
		this.landAreaStyle = landAreaStyle;
	}

	public String getReqTypeNameStyle() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.getReqTypeName() == null)
				return (this.popupViewSiteInfoTmp.getReqTypeName()== null)?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.getReqTypeName().equals(this.popupViewSiteInfoTmp.getReqTypeName()))?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setReqTypeNameStyle(String reqTypeNameStyle) {
		this.reqTypeNameStyle = reqTypeNameStyle;
	}

	public String getOwnerStyle() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.getOwner() == null)
				return (this.popupViewSiteInfoTmp.getOwner()== null)?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.getOwner().equals(this.popupViewSiteInfoTmp.getOwner()))?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setOwnerStyle(String ownerStyle) {
		this.ownerStyle = ownerStyle;
	}

	public String getLessorNameStyle() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.getLessorName() == null)
				return (this.popupViewSiteInfoTmp.getLessorName()== null)?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.getLessorName().equals(this.popupViewSiteInfoTmp.getLessorName()))?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setLessorNameStyle(String lessorNameStyle) {
		this.lessorNameStyle = lessorNameStyle;
	}

	public String getOwnerAddressStyle() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.getOwnerAddress() == null)
				return (this.popupViewSiteInfoTmp.getOwnerAddress()== null)?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.getOwnerAddress().equals(this.popupViewSiteInfoTmp.getOwnerAddress()))?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setOwnerAddressStyle(String ownerAddressStyle) {
		this.ownerAddressStyle = ownerAddressStyle;
	}

	public String getOwnerStreetStyle() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.getOwnerStreet() == null)
				return (this.popupViewSiteInfoTmp.getOwnerStreet()== null)?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.getOwnerStreet().equals(this.popupViewSiteInfoTmp.getOwnerStreet()))?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setOwnerStreetStyle(String ownerStreetStyle) {
		this.ownerStreetStyle = ownerStreetStyle;
	}

	public String getOwnerTambonStyle() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.getOwnerTambon() == null)
				return (this.popupViewSiteInfoTmp.getOwnerTambon()== null)?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.getOwnerTambon().equals(this.popupViewSiteInfoTmp.getOwnerTambon()))?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setOwnerTambonStyle(String ownerTambonStyle) {
		this.ownerTambonStyle = ownerTambonStyle;
	}

	public String getOwnerProvinceStyle() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.getOwnerProvince() == null)
				return (this.popupViewSiteInfoTmp.getOwnerProvince()== null)?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.getOwnerProvince().equals(this.popupViewSiteInfoTmp.getOwnerProvince()))?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setOwnerProvinceStyle(String ownerProvinceStyle) {
		this.ownerProvinceStyle = ownerProvinceStyle;
	}

	public String getNetworkStatusStyle() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.getNetworkStatus() == null)
				return (this.popupViewSiteInfoTmp.getNetworkStatus()== null)?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.getNetworkStatus().equals(this.popupViewSiteInfoTmp.getNetworkStatus()))?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setNetworkStatusStyle(String networkStatusStyle) {
		this.networkStatusStyle = networkStatusStyle;
	}

	public String getSiteStatusStyle() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.getSiteStatus() == null)
				return (this.popupViewSiteInfoTmp.getSiteStatus()== null)?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.getSiteStatus().equals(this.popupViewSiteInfoTmp.getSiteStatus()))?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setSiteStatusStyle(String siteStatusStyle) {
		this.siteStatusStyle = siteStatusStyle;
	}

	public String getContractStatusStyle() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.getContractStatus() == null)
				return (this.popupViewSiteInfoTmp.getContractStatus()== null)?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.getContractStatus().equals(this.popupViewSiteInfoTmp.getContractStatus()))?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setContractStatusStyle(String contractStatusStyle) {
		this.contractStatusStyle = contractStatusStyle;
	}

	public String getSendTOTStatusStyle() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.getSendTOTStatus() == null)
				return (this.popupViewSiteInfoTmp.getSendTOTStatus()== null)?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.getSendTOTStatus().equals(this.popupViewSiteInfoTmp.getSendTOTStatus()))?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setSendTOTStatusStyle(String sendTOTStatusStyle) {
		this.sendTOTStatusStyle = sendTOTStatusStyle;
	}

	public String getDocRemainStyle() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.getDocRemain() == null)
				return (this.popupViewSiteInfoTmp.getDocRemain()== null)?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.getDocRemain().equals(this.popupViewSiteInfoTmp.getDocRemain()))?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setDocRemainStyle(String docRemainStyle) {
		this.docRemainStyle = docRemainStyle;
	}

	public String getDepositCashStyle() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.getDepositCash() == null)
				return (this.popupViewSiteInfoTmp.getDepositCash()== null||this.popupViewSiteInfoTmp.getDepositCash()== 0)?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.getDepositCash().equals(this.popupViewSiteInfoTmp.getDepositCash()))?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setDepositCashStyle(String depositCashStyle) {
		this.depositCashStyle = depositCashStyle;
	}

	public String getDepositBgStyle() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.getDepositBg() == null)
				return (this.popupViewSiteInfoTmp.getDepositBg()== null 
						|| this.popupViewSiteInfoTmp.getDepositBg()== "0" 
						|| this.popupViewSiteInfoTmp.getDepositBg()== "0.00")?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.getDepositBg().equals(this.popupViewSiteInfoTmp.getDepositBg()))?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setDepositBgStyle(String depositBgStyle) {
		this.depositBgStyle = depositBgStyle;
	}

	public String getDepositEtCashStyle() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.getDepositEtCash() == null)
				return (this.popupViewSiteInfoTmp.getDepositEtCash()== null ||this.popupViewSiteInfoTmp.getDepositEtCash()== 0 )?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.getDepositEtCash().equals(this.popupViewSiteInfoTmp.getDepositEtCash()))?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setDepositEtCashStyle(String depositEtCashStyle) {
		this.depositEtCashStyle = depositEtCashStyle;
	}

	public String getDepositEtBgStyle() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.getDepositEtBg()== null)
				return (this.popupViewSiteInfoTmp.getDepositEtBg()== null 
						|| this.popupViewSiteInfoTmp.getDepositEtBg()== "0"
						|| this.popupViewSiteInfoTmp.getDepositEtBg()== "0.00")?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.getDepositEtBg().equals(this.popupViewSiteInfoTmp.getDepositEtBg()))?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setDepositEtBgStyle(String depositEtBgStyle) {
		this.depositEtBgStyle = depositEtBgStyle;
	}

	public String getRentServiceAmtStyle() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.getRentServiceAmt()== null)
				return (this.popupViewSiteInfoTmp.getRentServiceAmt()== null 
						|| this.popupViewSiteInfoTmp.getRentServiceAmt()== 0)?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.getRentServiceAmt().equals(this.popupViewSiteInfoTmp.getRentServiceAmt()))?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setRentServiceAmtStyle(String rentServiceAmtStyle) {
		this.rentServiceAmtStyle = rentServiceAmtStyle;
	}

	public String getCheckPropertyTaxPayType0Style() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.isCheckPropertyTaxPayType0())
				return (this.popupViewSiteInfoTmp.isCheckPropertyTaxPayType0())?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.isCheckPropertyTaxPayType0()== this.popupViewSiteInfoTmp.isCheckPropertyTaxPayType0())?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setCheckPropertyTaxPayType0Style(
			String checkPropertyTaxPayType0Style) {
		this.checkPropertyTaxPayType0Style = checkPropertyTaxPayType0Style;
	}

	public String getCheckPropertyTaxPayType1Style() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.isCheckPropertyTaxPayType1())
				return (this.popupViewSiteInfoTmp.isCheckPropertyTaxPayType1())?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.isCheckPropertyTaxPayType1() == this.popupViewSiteInfoTmp.isCheckPropertyTaxPayType1())?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setCheckPropertyTaxPayType1Style(
			String checkPropertyTaxPayType1Style) {
		this.checkPropertyTaxPayType1Style = checkPropertyTaxPayType1Style;
	}

	public String getCheckPropertyTaxPayType2Style() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.isCheckPropertyTaxPayType2())
				return (this.popupViewSiteInfoTmp.isCheckPropertyTaxPayType2())?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.isCheckPropertyTaxPayType2() == this.popupViewSiteInfoTmp.isCheckPropertyTaxPayType2())?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setCheckPropertyTaxPayType2Style(
			String checkPropertyTaxPayType2Style) {
		this.checkPropertyTaxPayType2Style = checkPropertyTaxPayType2Style;
	}

	public String getCheckPropertyTaxPayType3Style() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.isCheckPropertyTaxPayType3())
				return (this.popupViewSiteInfoTmp.isCheckPropertyTaxPayType3())?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.isCheckPropertyTaxPayType3() == this.popupViewSiteInfoTmp.isCheckPropertyTaxPayType3())?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setCheckPropertyTaxPayType3Style(
			String checkPropertyTaxPayType3Style) {
		this.checkPropertyTaxPayType3Style = checkPropertyTaxPayType3Style;
	}

	public String getPropertyTaxHistPayStyle() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.getPropertyTaxPayType()==null)
				return (this.popupViewSiteInfoTmp.getPropertyTaxPayType()==null)?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.getPropertyTaxPayType().equals(this.popupViewSiteInfoTmp.getPropertyTaxPayType()))?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setPropertyTaxHistPayStyle(String propertyTaxHistPayStyle) {
		this.propertyTaxHistPayStyle = propertyTaxHistPayStyle;
	}

	public String getElectricTypeStyle() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.getElectricType()==null)
				return (this.popupViewSiteInfoTmp.getElectricType()== null)?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.getElectricType().equals(this.popupViewSiteInfoTmp.getElectricType()))?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setElectricTypeStyle(String electricTypeStyle) {
		this.electricTypeStyle = electricTypeStyle;
	}

	public String getEtUnitPriceAmtStyle() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.getEtUnitPriceAmt() ==null)
				return (this.popupViewSiteInfoTmp.getEtUnitPriceAmt()== null 
						|| this.popupViewSiteInfoTmp.getEtUnitPriceAmt()== 0)?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.getEtUnitPriceAmt().equals(this.popupViewSiteInfoTmp.getEtUnitPriceAmt()))?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setEtUnitPriceAmtStyle(String etUnitPriceAmtStyle) {
		this.etUnitPriceAmtStyle = etUnitPriceAmtStyle;
	}

	public String getTakeAllAmtStyle() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.getTakeAllAmt() ==null)
				return (this.popupViewSiteInfoTmp.getTakeAllAmt()== null 
						|| this.popupViewSiteInfoTmp.getTakeAllAmt()== 0 )?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.getTakeAllAmt().equals(this.popupViewSiteInfoTmp.getTakeAllAmt()))?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setTakeAllAmtStyle(String takeAllAmtStyle) {
		this.takeAllAmtStyle = takeAllAmtStyle;
	}

	public String getCheckTakeAllPeriodTypeYearStyle() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.isCheckTakeAllPeriodTypeYear())
				return (this.popupViewSiteInfoTmp.isCheckTakeAllPeriodTypeYear())?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.isCheckTakeAllPeriodTypeYear() == this.popupViewSiteInfoTmp.isCheckTakeAllPeriodTypeYear())?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setCheckTakeAllPeriodTypeYearStyle(
			String checkTakeAllPeriodTypeYearStyle) {
		this.checkTakeAllPeriodTypeYearStyle = checkTakeAllPeriodTypeYearStyle;
	}

	public String getCheckTakeAllPeriodTypeMonthStyle() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.isCheckTakeAllPeriodTypeYear())
				return (this.popupViewSiteInfoTmp.isCheckTakeAllPeriodTypeYear())?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.isCheckTakeAllPeriodTypeYear() == this.popupViewSiteInfoTmp.isCheckTakeAllPeriodTypeYear())?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setCheckTakeAllPeriodTypeMonthStyle(
			String checkTakeAllPeriodTypeMonthStyle) {
		this.checkTakeAllPeriodTypeMonthStyle = checkTakeAllPeriodTypeMonthStyle;
	}

	public String getCheckELVatType03Style() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.isCheckELVatType03())
				return (this.popupViewSiteInfoTmp.isCheckELVatType03())?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.isCheckELVatType03() == this.popupViewSiteInfoTmp.isCheckELVatType03())?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setCheckELVatType03Style(String checkELVatType03Style) {
		this.checkELVatType03Style = checkELVatType03Style;
	}

	public String getCheckELVatType02Style() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.isCheckELVatType02())
				return (this.popupViewSiteInfoTmp.isCheckELVatType02())?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.isCheckELVatType02() == this.popupViewSiteInfoTmp.isCheckELVatType02())?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setCheckELVatType02Style(String checkELVatType02Style) {
		this.checkELVatType02Style = checkELVatType02Style;
	}

	public String getChkElVatType1Style() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.isCheckELVatType01())
				return (this.popupViewSiteInfoTmp.isCheckELVatType01())?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.isCheckELVatType01() == this.popupViewSiteInfoTmp.isCheckELVatType01())?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setChkElVatType1Style(String chkElVatType1Style) {
		this.chkElVatType1Style = chkElVatType1Style;
	}

	public String getInsuranceTypeStyle() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.getInsuranceType() ==null)
				return (this.popupViewSiteInfoTmp.getInsuranceType()== null)?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.getInsuranceType().equals(this.popupViewSiteInfoTmp.getInsuranceType()))?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setInsuranceTypeStyle(String insuranceTypeStyle) {
		this.insuranceTypeStyle = insuranceTypeStyle;
	}

	public String getMoneyAmountStyle() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.getMoneyAmount() ==null)
				return (this.popupViewSiteInfoTmp.getMoneyAmount()== null 
						|| this.popupViewSiteInfoTmp.getMoneyAmount()== 0 )?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.getMoneyAmount().equals(this.popupViewSiteInfoTmp.getMoneyAmount()))?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setMoneyAmountStyle(String moneyAmountStyle) {
		this.moneyAmountStyle = moneyAmountStyle;
	}

	public String getTitleStyle() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.getTitle() ==null)
				return (this.popupViewSiteInfoTmp.getTitle()== null)?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.getTitle().equals(this.popupViewSiteInfoTmp.getTitle()))?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setTitleStyle(String titleStyle) {
		this.titleStyle = titleStyle;
	}
	
	
	public String getContactNameStyle() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.getContactName() ==null)
				return (this.popupViewSiteInfoTmp.getContactName()== null)?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.getContactName().equals(this.popupViewSiteInfoTmp.getContactName()))?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setContactNameStyle(String contactNameStyle) {
		this.contactNameStyle = contactNameStyle;
	}

	public String getContactTelStyle() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.getContactTel() ==null)
				return (this.popupViewSiteInfoTmp.getContactTel()== null)?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.getContactTel().equals(this.popupViewSiteInfoTmp.getContactTel()))?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setContactTelStyle(String contactTelStyle) {
		this.contactTelStyle = contactTelStyle;
	}

	public String getContactFaxStyle() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.getContactFax() ==null)
				return (this.popupViewSiteInfoTmp.getContactFax()== null)?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.getContactFax().equals(this.popupViewSiteInfoTmp.getContactFax()))?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setContactFaxStyle(String contactFaxStyle) {
		this.contactFaxStyle = contactFaxStyle;
	}

	public String getRentAmtStyle() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.getRentAmt() ==null)
				return (this.popupViewSiteInfoTmp.getRentAmt()== null
						||this.popupViewSiteInfoTmp.getRentAmt()== 0)?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.getRentAmt().equals(this.popupViewSiteInfoTmp.getRentAmt()))?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setRentAmtStyle(String rentAmtStyle) {
		this.rentAmtStyle = rentAmtStyle;
	}

	public String getCheckServiceVatType0Style() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.isCheckServiceVatType0())
				return (this.popupViewSiteInfoTmp.isCheckServiceVatType0())?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.isCheckServiceVatType0() == this.popupViewSiteInfoTmp.isCheckServiceVatType0())?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setCheckServiceVatType0Style(String checkServiceVatType0Style) {
		this.checkServiceVatType0Style = checkServiceVatType0Style;
	}

	public String getCheckRentWhtTypeTax0Style() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.isCheckRentWhtTypeTax0())
				return (this.popupViewSiteInfoTmp.isCheckRentWhtTypeTax0())?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.isCheckRentWhtTypeTax0() == this.popupViewSiteInfoTmp.isCheckRentWhtTypeTax0())?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setCheckRentWhtTypeTax0Style(String checkRentWhtTypeTax0Style) {
		this.checkRentWhtTypeTax0Style = checkRentWhtTypeTax0Style;
	}

	public String getCheckRentWhtTypeTax1Style() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.isCheckRentWhtTypeTax1())
				return (this.popupViewSiteInfoTmp.isCheckRentWhtTypeTax1())?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.isCheckRentWhtTypeTax1() == this.popupViewSiteInfoTmp.isCheckRentWhtTypeTax1())?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setCheckRentWhtTypeTax1Style(String checkRentWhtTypeTax1Style) {
		this.checkRentWhtTypeTax1Style = checkRentWhtTypeTax1Style;
	}

	public String getCheckRentWhtTypeTax2Style() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.isCheckRentWhtTypeTax2())
				return (this.popupViewSiteInfoTmp.isCheckRentWhtTypeTax2())?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.isCheckRentWhtTypeTax2() == this.popupViewSiteInfoTmp.isCheckRentWhtTypeTax2())?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setCheckRentWhtTypeTax2Style(String checkRentWhtTypeTax2Style) {
		this.checkRentWhtTypeTax2Style = checkRentWhtTypeTax2Style;
	}

	public String getCheckServiceVatType1Style() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.isCheckServiceVatType1())
				return (this.popupViewSiteInfoTmp.isCheckServiceVatType1())?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.isCheckServiceVatType1() == this.popupViewSiteInfoTmp.isCheckServiceVatType1())?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setCheckServiceVatType1Style(String checkServiceVatType1Style) {
		this.checkServiceVatType1Style = checkServiceVatType1Style;
	}

	public String getCheckServiceVatType2Style() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.isCheckServiceVatType2())
				return (this.popupViewSiteInfoTmp.isCheckServiceVatType2())?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.isCheckServiceVatType2() == this.popupViewSiteInfoTmp.isCheckServiceVatType2())?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setCheckServiceVatType2Style(String checkServiceVatType2Style) {
		this.checkServiceVatType2Style = checkServiceVatType2Style;
	}

	public String getCheckServiceWhtTypeTax0Style() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.isCheckServiceWhtTypeTax0())
				return (this.popupViewSiteInfoTmp.isCheckServiceWhtTypeTax0())?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.isCheckServiceWhtTypeTax0() == this.popupViewSiteInfoTmp.isCheckServiceWhtTypeTax0())?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setCheckServiceWhtTypeTax0Style(String checkServiceWhtTypeTax0Style) {
		this.checkServiceWhtTypeTax0Style = checkServiceWhtTypeTax0Style;
	}

	public String getCheckServiceWhtTypeTax1Style() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.isCheckServiceWhtTypeTax1())
				return (this.popupViewSiteInfoTmp.isCheckServiceWhtTypeTax1())?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.isCheckServiceWhtTypeTax1() == this.popupViewSiteInfoTmp.isCheckServiceWhtTypeTax1())?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setCheckServiceWhtTypeTax1Style(String checkServiceWhtTypeTax1Style) {
		this.checkServiceWhtTypeTax1Style = checkServiceWhtTypeTax1Style;
	}

	public String getCheckServiceWhtTypeTax2Style() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.isCheckServiceWhtTypeTax2())
				return (this.popupViewSiteInfoTmp.isCheckServiceWhtTypeTax2())?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.isCheckServiceWhtTypeTax2() == this.popupViewSiteInfoTmp.isCheckServiceWhtTypeTax2())?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setCheckServiceWhtTypeTax2Style(String checkServiceWhtTypeTax2Style) {
		this.checkServiceWhtTypeTax2Style = checkServiceWhtTypeTax2Style;
	}

	public String getServiceAmtStyle() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.getServiceAmt() == null)
				return (this.popupViewSiteInfoTmp.getServiceAmt()== null 
						|| this.popupViewSiteInfoTmp.getServiceAmt()== 0)?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.getServiceAmt().equals(this.popupViewSiteInfoTmp.getServiceAmt()))?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setServiceAmtStyle(String serviceAmtStyle) {
		this.serviceAmtStyle = serviceAmtStyle;
	}

	public PopupViewSiteInfoSearchSP getPopupViewSiteInfoTmp() {
		return popupViewSiteInfoTmp;
	}

	public void setPopupViewSiteInfoTmp(
			PopupViewSiteInfoSearchSP popupViewSiteInfoTmp) {
		this.popupViewSiteInfoTmp = popupViewSiteInfoTmp;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}

	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}

	public String getCheckRentWhtTypeTaxStyle() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.getCheckRentWhtTypeTaxStr() ==null)
				return (this.popupViewSiteInfoTmp.getCheckRentWhtTypeTaxStr()== null)?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.getCheckRentWhtTypeTaxStr().equals(this.popupViewSiteInfoTmp.getCheckRentWhtTypeTaxStr()))?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setCheckRentWhtTypeTaxStyle(String checkRentWhtTypeTaxStyle) {
		this.checkRentWhtTypeTaxStyle = checkRentWhtTypeTaxStyle;
	}

	public String getCheckServiceVatTypeStyle() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.getCheckServiceVatTypeStr() ==null)
				return (this.popupViewSiteInfoTmp.getCheckServiceVatTypeStr()== null)?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.getCheckServiceVatTypeStr().equals(this.popupViewSiteInfoTmp.getCheckServiceVatTypeStr()))?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setCheckServiceVatTypeStyle(String checkServiceVatTypeStyle) {
		this.checkServiceVatTypeStyle = checkServiceVatTypeStyle;
	}

	public String getCheckServiceWhtTypeTaxStyle() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.getCheckServiceWhtTypeTaxStr() ==null)
				return (this.popupViewSiteInfoTmp.getCheckServiceWhtTypeTaxStr()== null)?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.getCheckServiceWhtTypeTaxStr().equals(this.popupViewSiteInfoTmp.getCheckServiceWhtTypeTaxStr()))?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setCheckServiceWhtTypeTaxStyle(String checkServiceWhtTypeTaxStyle) {
		this.checkServiceWhtTypeTaxStyle = checkServiceWhtTypeTaxStyle;
	}

	public String getCheckELVatTypeStyle() {
		if(this.popupViewSiteInfoSearchSP != null &&
				this.popupViewSiteInfoTmp != null){
			if(this.popupViewSiteInfoSearchSP.getCheckELVatTypeStr() ==null)
				return (this.popupViewSiteInfoTmp.getCheckELVatTypeStr()== null)?this.STYLE_NORMAL:this.STYLE_RED;
			else
			return (this.popupViewSiteInfoSearchSP.getCheckELVatTypeStr().equals(this.popupViewSiteInfoTmp.getCheckELVatTypeStr()))?this.STYLE_NORMAL:this.STYLE_RED;
		}else{
			return this.STYLE_NORMAL;
		}
	}

	public void setCheckELVatTypeStyle(String checkELVatTypeStyle) {
		this.checkELVatTypeStyle = checkELVatTypeStyle;
	}

	public boolean isDisplayBtn() {
		return displayBtn;
	}

	public void setDisplayBtn(boolean displayBtn) {
		this.displayBtn = displayBtn;
	}

	public String getSiteInfoId() {
		return siteInfoId;
	}

	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}
	
	
}
