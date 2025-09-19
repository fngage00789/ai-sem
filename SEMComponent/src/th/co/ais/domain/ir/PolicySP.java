package th.co.ais.domain.ir;

import java.util.Date;

import javax.persistence.Transient;

import th.co.ais.domain.AbstractDomain;
import th.co.ais.rpt.util.annotation.PCell;

public class PolicySP extends AbstractDomain{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9117355559025679149L;
	
	private String rowId;
	private String policyId;
	private String networkType;
	private String company;
	private String tfType;
	private String tfCode;
	protected Date effDt;
	protected String networkCode;
	protected String cCode;
	private String ptCode;
	private String locationId;
	private String locationStatus;
	private Double insuredAmtOld;
	private Double insuredAmt;
	private Double deductAmt;
	private Double premiumAmtOld;
	private Double premiumAmt;
	private String policyNo;
	private String ptType;
	private Date expDt;
	private String draftStatus;
	private String deductType;
	private String insuredFlg;
	private boolean insuredFlgBoolean;
	private String genType;
	private String policyDtlId;
	private String rs;
	
	private String draftNo;
	private String locationCode;
	private String locationName;
	private int changeCapital;
	private boolean checkPopUp;
	private String networkTypeDesc;
	private String tfTypeDesc;
	private String ptTypeDesc;
	private String draftStatusDesc;
	private int totalLocation;
	private String status;
	private Double insuredAmtDiff;
	private String docType;
	private String docTypeDesc;
	private Date effFromDt;
	private Date effToDt;
	private Date expFromDt;
	private Date expToDt;
	private String zone;
	private Double premiumAmtEst;
	private Double premiumAmtDiff;
	private Double diffAmt;
	private String viewType;
	
	private String paymentStatus;
	private String batchNo;
	private Date dueDtFrom;
	private Date DueDtTo;
	private String payType;
	private String vendorCode;
	private String vendorName;
	private String payeeName;
	private Double excAmount;
	
	//SEMMIR007 POP ADD
	private String refPolicy;
	private String dataAsOf;
	private Date newEffDt;
	private Date newExpDt;
	
	
	//SEMMIR010
	private String paymentGroupNo;
	private String transferType;
	private String transferTypeDesc;
	private String policyType;
	private String policyTypeDesc;	
	private String paymentStatusDesc;
	private Date dueDtTo;
	private String contractNo;
	private Double excAmt;
	private Double vatAmt;
	private Double whtAmt;
	private Double dutyAmt;
	private Double totalPayAmt;
	private Double totalAmt;
	private String invoiceNo;
	private Date paymentDt;
	private String paymentType;
	private String paymentTypeDesc;
	private String paymentMethod;
	private String paymentMethodDesc;
	private Date chqDt;
	private Date chqReceiveDt;
	private Date transferDt;
	private String remark;
	private int no;
	private String paymentId;
	private String payeeMasterId;
	private String region;
	private boolean renderColumn;
	private String siteName;
	private String dueDtStr;
	private String paymentDocNo;
	private Double amount;
	private Double vatAmount;
	private Double whtAmount;
	private Double netAmount;
	
	private String expDtStr;
	private String updateDtStr;
	protected String effDtStr;
	
	private String paymentDtStr;
	private String chqDtStr;
	private String chqReceiveDtStr;
	private String transferDtStr;
	
	//added by NEW 19/03/2015
	private String strParam;
	private String sendInfoStatus;
	private String payeeCode;
	
	//SEMMIR013
	private String claimId;
	
	// Database
	private String userId;
	//
	private boolean selected = false;
	
	
	// added by.. YUT 2014/09/10
	private Double rcptPayCutAmount;
	private boolean chkRcptPay;
	private String rcptPayFlag;
	
	private String doc92;
	
	//added by NEW 2018/09/11
	private String serviceId;
	private String serviceName;
	
	//added by NEW 2019/01/10
	private String payFlag;
	
	
	public String getDeductType() {
		return deductType;
	}

	public void setDeductType(String deductType) {
		this.deductType = deductType;
	}

	public String getInsuredFlg() {
		return insuredFlg;
	}

	public void setInsuredFlg(String insuredFlg) {
		this.insuredFlg = insuredFlg;
	}

	@Override
	public String getCreateBy() {
		return this.createBy;
	}

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public String getPolicyId() {
		return policyId;
	}

	public void setPolicyId(String policyId) {
		this.policyId = policyId;
	}

	public String getNetworkType() {
		return networkType;
	}

	public void setNetworkType(String networkType) {
		this.networkType = networkType;
	}
	@PCell(cellType = String.class ,no = 4, manualStyleName = "rt003Field")
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getTfType() {
		return tfType;
	}

	public void setTfType(String tfType) {
		this.tfType = tfType;
	}

	public String getTfCode() {
		return tfCode;
	}

	public void setTfCode(String tfCode) {
		this.tfCode = tfCode;
	}

	
	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getLocationStatus() {
		return locationStatus;
	}
	
	
	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public void setLocationStatus(String locationStatus) {
		this.locationStatus = locationStatus;
	}

	public Double getInsuredAmtOld() {
		return insuredAmtOld;
	}

	public void setInsuredAmtOld(Double insuredAmtOld) {
		this.insuredAmtOld = insuredAmtOld;
	}

	public Double getInsuredAmt() {
		return insuredAmt;
	}

	public void setInsuredAmt(Double insuredAmt) {
		this.insuredAmt = insuredAmt;
	}

	public Double getDeductAmt() {
		return deductAmt;
	}

	public void setDeductAmt(Double deductAmt) {
		this.deductAmt = deductAmt;
	}
	
	@PCell(cellType = String.class ,no = 2, manualStyleName = "rt003Field")
	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
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
		// TODO Auto-generated method stub
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
	public Date getEffDt() {
		return effDt;
	}

	public void setEffDt(Date effDt) {
		this.effDt = effDt;
	}

	public String getNetworkCode() {
		return networkCode;
	}

	public void setNetworkCode(String networkCode) {
		this.networkCode = networkCode;
	}

	public String getcCode() {
		return cCode;
	}

	public void setcCode(String cCode) {
		this.cCode = cCode;
	}

	public void setPtCode(String ptCode) {
		this.ptCode = ptCode;
	}

	public String getPtCode() {
		return ptCode;
	}

	public void setExpDt(Date expDt) {
		this.expDt = expDt;
	}

	public Date getExpDt() {
		return expDt;
	}

	public void setPtType(String ptType) {
		this.ptType = ptType;
	}

	public String getPtType() {
		return ptType;
	}

	public void setDraftStatus(String draftStatus) {
		this.draftStatus = draftStatus;
	}
	@Transient
	public String getDraftStatus() {
		return draftStatus;
	}

	public void setGenType(String genType) {
		this.genType = genType;
	}

	public String getGenType() {
		return genType;
	}
	public Double getPremiumAmtOld() {
		return premiumAmtOld;
	}

	public void setPremiumAmtOld(Double premiumAmtOld) {
		this.premiumAmtOld = premiumAmtOld;
	}

	public Double getPremiumAmt() {
		return premiumAmt;
	}

	public void setPremiumAmt(Double premiumAmt) {
		this.premiumAmt = premiumAmt;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	public void setPolicyDtlId(String policyDtlId) {
		this.policyDtlId = policyDtlId;
	}

	public String getPolicyDtlId() {
		return policyDtlId;
	}

	public void setRs(String rs) {
		this.rs = rs;
	}

	public String getRs() {
		return rs;
	}

	public String getDraftNo() {
		return draftNo;
	}

	public void setDraftNo(String draftNo) {
		this.draftNo = draftNo;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public int getChangeCapital() {
		return changeCapital;
	}

	public void setChangeCapital(int changeCapital) {
		this.changeCapital = changeCapital;
	}

	public boolean isCheckPopUp() {
		return checkPopUp;
	}

	public void setCheckPopUp(boolean checkPopUp) {
		this.checkPopUp = checkPopUp;
	}

	public String getTfTypeDesc() {
		return tfTypeDesc;
	}

	public void setTfTypeDesc(String tfTypeDesc) {
		this.tfTypeDesc = tfTypeDesc;
	}

	public String getPtTypeDesc() {
		return ptTypeDesc;
	}

	public void setPtTypeDesc(String ptTypeDesc) {
		this.ptTypeDesc = ptTypeDesc;
	}

	public String getDraftStatusDesc() {
		return draftStatusDesc;
	}

	public void setDraftStatusDesc(String draftStatusDesc) {
		this.draftStatusDesc = draftStatusDesc;
	}
	@PCell(cellType = String.class ,no = 5, manualStyleName = "rt003Field")
	public String getNetworkTypeDesc() {
		return networkTypeDesc;
	}

	public void setNetworkTypeDesc(String networkTypeDesc) {
		this.networkTypeDesc = networkTypeDesc;
	}

	public int getTotalLocation() {
		return totalLocation;
	}

	public void setTotalLocation(int totalLocation) {
		this.totalLocation = totalLocation;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getInsuredAmtDiff() {
		return insuredAmtDiff;
	}

	public void setInsuredAmtDiff(Double insuredAmtDiff) {
		this.insuredAmtDiff = insuredAmtDiff;
	}
	
	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public Date getEffFromDt() {
		return effFromDt;
	}

	public void setEffFromDt(Date effFromDt) {
		this.effFromDt = effFromDt;
	}

	public Date getEffToDt() {
		return effToDt;
	}

	public void setEffToDt(Date effToDt) {
		this.effToDt = effToDt;
	}

	public Date getExpFromDt() {
		return expFromDt;
	}

	public void setExpFromDt(Date expFromDt) {
		this.expFromDt = expFromDt;
	}

	public Date getExpToDt() {
		return expToDt;
	}

	public void setExpToDt(Date expToDt) {
		this.expToDt = expToDt;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}
	@PCell(cellType = String.class ,no = 8, manualStyleName = "rt003Field")
	public String getDocTypeDesc() {
		return docTypeDesc;
	}

	public void setDocTypeDesc(String docTypeDesc) {
		this.docTypeDesc = docTypeDesc;
	}

	public Double getPremiumAmtEst() {
		return premiumAmtEst;
	}

	public void setPremiumAmtEst(Double premiumAmtEst) {
		this.premiumAmtEst = premiumAmtEst;
	}

	public Double getPremiumAmtDiff() {
		return premiumAmtDiff;
	}

	public void setPremiumAmtDiff(Double premiumAmtDiff) {
		this.premiumAmtDiff = premiumAmtDiff;
	}

	public Double getDiffAmt() {
		return diffAmt;
	}

	public void setDiffAmt(Double diffAmt) {
		this.diffAmt = diffAmt;
	}

	public String getViewType() {
		return viewType;
	}

	public void setViewType(String viewType) {
		this.viewType = viewType;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public Date getDueDtFrom() {
		return dueDtFrom;
	}

	public void setDueDtFrom(Date dueDtFrom) {
		this.dueDtFrom = dueDtFrom;
	}

	public Date getDueDtTo() {
		return DueDtTo;
	}

	public void setDueDtTo(Date dueDtTo) {
		DueDtTo = dueDtTo;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}
	@PCell(cellType = String.class ,no = 9, manualStyleName = "rt003Field")
	public String getVendorCode() {
		return vendorCode;
	}

	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}
	@PCell(cellType = String.class ,no = 10, manualStyleName = "rt003Field")
	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	@PCell(cellType = String.class ,no = 11, manualStyleName = "rt003Field")
	public String getPayeeName() {
		return payeeName;
	}
	
	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}
	
	public Double getExcAmount() {
		return excAmount;
	}

	public void setExcAmount(Double excAmount) {
		this.excAmount = excAmount;
	}

	public String getTransferType() {
		return transferType;
	}

	public void setTransferType(String transferType) {
		this.transferType = transferType;
	}
	@PCell(cellType = String.class ,no = 6, manualStyleName = "rt003Field")
	public String getTransferTypeDesc() {
		return transferTypeDesc;
	}

	public void setTransferTypeDesc(String transferTypeDesc) {
		this.transferTypeDesc = transferTypeDesc;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}
	@PCell(cellType = String.class ,no = 7, manualStyleName = "rt003Field")
	public String getPolicyTypeDesc() {
		return policyTypeDesc;
	}

	public void setPolicyTypeDesc(String policyTypeDesc) {
		this.policyTypeDesc = policyTypeDesc;
	}

	public String getPaymentStatusDesc() {
		return paymentStatusDesc;
	}

	public void setPaymentStatusDesc(String paymentStatusDesc) {
		this.paymentStatusDesc = paymentStatusDesc;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	
	@PCell(cellType = Double.class ,no = 12, manualStyleName = "rt003FieldMoney")
	public Double getExcAmt() {
		return excAmt;
	}

	public void setExcAmt(Double excAmt) {
		this.excAmt = excAmt;
	}
	@PCell(cellType = Double.class ,no = 14, manualStyleName = "rt003FieldMoney")
	public Double getVatAmt() {
		return vatAmt;
	}

	public void setVatAmt(Double vatAmt) {
		this.vatAmt = vatAmt;
	}
	@PCell(cellType = Double.class ,no = 15, manualStyleName = "rt003FieldMoney")
	public Double getWhtAmt() {
		return whtAmt;
	}

	public void setWhtAmt(Double whtAmt) {
		this.whtAmt = whtAmt;
	}

	@PCell(cellType = Double.class ,no = 13, manualStyleName = "rt003FieldMoney")
	public Double getDutyAmt() {
		return dutyAmt;
	}

	public void setDutyAmt(Double dutyAmt) {
		this.dutyAmt = dutyAmt;
	}
	@PCell(cellType = Double.class ,no = 16, manualStyleName = "rt003FieldMoney")
	public Double getTotalPayAmt() {
		return totalPayAmt;
	}

	public void setTotalPayAmt(Double totalPayAmt) {
		this.totalPayAmt = totalPayAmt;
	}

	public Double getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(Double totalAmt) {
		this.totalAmt = totalAmt;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public Date getPaymentDt() {
		return paymentDt;
	}

	public void setPaymentDt(Date paymentDt) {
		this.paymentDt = paymentDt;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getPaymentTypeDesc() {
		return paymentTypeDesc;
	}

	public void setPaymentTypeDesc(String paymentTypeDesc) {
		this.paymentTypeDesc = paymentTypeDesc;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getPaymentMethodDesc() {
		return paymentMethodDesc;
	}

	public void setPaymentMethodDesc(String paymentMethodDesc) {
		this.paymentMethodDesc = paymentMethodDesc;
	}

	public Date getChqDt() {
		return chqDt;
	}

	public void setChqDt(Date chqDt) {
		this.chqDt = chqDt;
	}

	public Date getChqReceiveDt() {
		return chqReceiveDt;
	}

	public void setChqReceiveDt(Date chqReceiveDt) {
		this.chqReceiveDt = chqReceiveDt;
	}

	public Date getTransferDt() {
		return transferDt;
	}

	public void setTransferDt(Date transferDt) {
		this.transferDt = transferDt;
	}

	public String getPaymentGroupNo() {
		return paymentGroupNo;
	}

	public void setPaymentGroupNo(String paymentGroupNo) {
		this.paymentGroupNo = paymentGroupNo;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	@PCell(cellType = String.class ,no = 0, manualStyleName = "rt003Field")
	public String getStringNo() {
		return no + "";
	}
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public String getPayeeMasterId() {
		return payeeMasterId;
	}

	public void setPayeeMasterId(String payeeMasterId) {
		this.payeeMasterId = payeeMasterId;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public boolean isRenderColumn() {
		return renderColumn;
	}

	public void setRenderColumn(boolean renderColumn) {
		this.renderColumn = renderColumn;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getDataAsOf() {
		return dataAsOf;
	}

	public void setDataAsOf(String dataAsOf) {
		this.dataAsOf = dataAsOf;
	}

	public Date getNewEffDt() {
		return newEffDt;
	}

	public Date getNewExpDt() {
		return newExpDt;
	}

	public void setNewEffDt(Date newEffDt) {
		this.newEffDt = newEffDt;
	}

	public void setNewExpDt(Date newExpDt) {
		this.newExpDt = newExpDt;
	}

	public String getRefPolicy() {
		return refPolicy;
	}

	public void setRefPolicy(String refPolicy) {
		this.refPolicy = refPolicy;
	}
	
	@PCell(cellType = String.class ,no = 3, manualStyleName = "rt003Field")
	public String getDueDtStr() {
		return dueDtStr;
	}

	public void setDueDtStr(String dueDtStr) {
		this.dueDtStr = dueDtStr;
	}

	
	public String getClaimId() {
		return claimId;
	}

	public void setClaimId(String claimId) {
		this.claimId = claimId;
	}

	@PCell(cellType = String.class ,no = 1, manualStyleName = "rt003Field")
	public String getPaymentDocNo() {
		return paymentDocNo;
	}

	public void setPaymentDocNo(String paymentDocNo) {
		this.paymentDocNo = paymentDocNo;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getVatAmount() {
		return vatAmount;
	}

	public void setVatAmount(Double vatAmount) {
		this.vatAmount = vatAmount;
	}

	public Double getWhtAmount() {
		return whtAmount;
	}

	public void setWhtAmount(Double whtAmount) {
		this.whtAmount = whtAmount;
	}

	public Double getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(Double netAmount) {
		this.netAmount = netAmount;
	}

	public String getExpDtStr() {
		return expDtStr;
	}

	public void setExpDtStr(String expDtStr) {
		this.expDtStr = expDtStr;
	}

	public String getUpdateDtStr() {
		return updateDtStr;
	}

	public void setUpdateDtStr(String updateDtStr) {
		this.updateDtStr = updateDtStr;
	}

	public String getEffDtStr() {
		return effDtStr;
	}

	public void setEffDtStr(String effDtStr) {
		this.effDtStr = effDtStr;
	}

	public String getPaymentDtStr() {
		return paymentDtStr;
	}

	public void setPaymentDtStr(String paymentDtStr) {
		this.paymentDtStr = paymentDtStr;
	}

	public String getChqDtStr() {
		return chqDtStr;
	}

	public void setChqDtStr(String chqDtStr) {
		this.chqDtStr = chqDtStr;
	}

	public String getChqReceiveDtStr() {
		return chqReceiveDtStr;
	}

	public void setChqReceiveDtStr(String chqReceiveDtStr) {
		this.chqReceiveDtStr = chqReceiveDtStr;
	}

	public String getTransferDtStr() {
		return transferDtStr;
	}

	public void setTransferDtStr(String transferDtStr) {
		this.transferDtStr = transferDtStr;
	}

	public Double getRcptPayCutAmount() {
		return rcptPayCutAmount;
	}

	public void setRcptPayCutAmount(Double rcptPayCutAmount) {
		this.rcptPayCutAmount = rcptPayCutAmount;
	}

	public boolean isChkRcptPay() {
		return chkRcptPay;
	}

	public void setChkRcptPay(boolean chkRcptPay) {
		this.chkRcptPay = chkRcptPay;
	}

	public String getRcptPayFlag() {
		return rcptPayFlag;
	}

	public void setRcptPayFlag(String rcptPayFlag) {
		this.rcptPayFlag = rcptPayFlag;
	}

	public String getDoc92() {
		return doc92;
	}

	public void setDoc92(String doc92) {
		this.doc92 = doc92;
	}

	public String getStrParam() {
		return strParam;
	}

	public void setStrParam(String strParam) {
		this.strParam = strParam;
	}

	public String getSendInfoStatus() {
		return sendInfoStatus;
	}

	public void setSendInfoStatus(String sendInfoStatus) {
		this.sendInfoStatus = sendInfoStatus;
	}

	public String getPayeeCode() {
		return payeeCode;
	}

	public void setPayeeCode(String payeeCode) {
		this.payeeCode = payeeCode;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getPayFlag() {
		return payFlag;
	}

	public void setPayFlag(String payFlag) {
		this.payFlag = payFlag;
	}

	public boolean isInsuredFlgBoolean() {
		if("Y".equalsIgnoreCase(this.insuredFlg) || "true".equalsIgnoreCase(this.insuredFlg)) {
			this.insuredFlgBoolean = true;
		}
		return insuredFlgBoolean;
	}

	public void setInsuredFlgBoolean(boolean insuredFlgBoolean) {
		this.insuredFlgBoolean = insuredFlgBoolean;
	}

	
}
