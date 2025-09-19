package th.co.ais.domain.pt;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;
import th.co.ais.rpt.util.annotation.PCell;

public class Mpt004Srch extends AbstractDomain{

	private boolean selected;
	private String rowId;
	private String paymentGroupNo;
	private String contractNo;
	private Integer pTaxYear;
	private String paymentStatus;
	private Integer periodNo;
	private String expenseType;
	private String vendorCode;
	private String vendorName;
	private String payeeId;
	private String payeeName;
	private Double excAmt;
	private Double whtAmt;
	private Double vatAmt;
	private Double chqAmt;
	private Double diffAmt;
	private String paymentType;
	private String bankName;
	private String bankAccNo;
	private Date chqDt;
	private Date chqReceiveDt;
	private Date transferDt;
	private String remark;
	private String exportFlag;
	private Date exportDt;
	private String docTypeDesc;
	private String docType;
	private String doc68;
	private String doc92;
	
	private String company;
	private String pTaxYearFrom;
	private String pTaxYearTo;
	private String periodNoFrom;
	private String periodNoTo;
	private String picoFlag;
	private String pTaxPayType;
	private String govtName;
	private String province;
	
	private boolean renderCheckBox;
	private boolean renderCommandLink;
	
	// add new parameter page SEMMPT005 
	private String regionIn;
	private String provinceIn;
	private String amphur;
	private Date chqDtFrom;
	private Date chqDtTo;
	private Date transferDtFrom;
	private Date transferDtTo;
	private String paymentBy;
	private Date paymentDtFrom;
	private Date paymentDtTo;
	private String estimateBy;
	private Date estimateDtFrom;
	private Date estimateDtTo;
	
	private String paymentDocNo;
	private String siteName;
	private String region;
	
	private String siteInfoId;
	
	private String docNo;
	private Date docDt;
	private String paymentTypeDesc;
	private String paymentMethod;
	private String payGovtFlag;
	private String estimateFlag;
	private String batchNo;
	
	private int no;
	
	// added by.. YUT 2014/09/10
	private Double rcptPayCutAmount;
	private boolean chkRcptPay;
	private String rcptPayFlag;
	private String paymentStatusId;
	private String diffRemark;
	
	private String sendInfoStatus;
	
	//added by NEW 2015/11/04
	private String doc69;
	private String chqDtStr;
	private String chqReceiveDtStr;
	private String transferDtStr;
	private String exportDtStr;
	
	//added BY NEW 2018/09/11
	private String serviceId;
	private String serviceName;
	private String strParam;
	
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
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	public String getPaymentGroupNo() {
		return paymentGroupNo;
	}
	public void setPaymentGroupNo(String paymentGroupNo) {
		this.paymentGroupNo = paymentGroupNo;
	}
	@PCell(cellType = String.class,no = 2, manualStyleName ="rt003Field")
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	@PCell(cellType = Double.class,no = 3, manualStyleName ="rt003Field")
	public Integer getpTaxYear() {
		return pTaxYear;
	}
	public void setpTaxYear(Integer pTaxYear) {
		this.pTaxYear = pTaxYear;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	@PCell(cellType = String.class,no = 4, manualStyleName ="si003Field")
	public Integer getPeriodNo() {
		return periodNo;
	}
	public void setPeriodNo(Integer periodNo) {
		this.periodNo = periodNo;
	}
	@PCell(cellType = String.class,no = 5, manualStyleName ="rt003Field")
	public String getExpenseType() {
		return expenseType;
	}
	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}
	@PCell(cellType = String.class,no = 7, manualStyleName ="si003Field")
	public String getVendorCode() {
		return vendorCode;
	}
	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}
	@PCell(cellType = String.class,no = 8, manualStyleName ="rt003Field")
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getPayeeId() {
		return payeeId;
	}
	public void setPayeeId(String payeeId) {
		this.payeeId = payeeId;
	}
	@PCell(cellType = String.class,no = 9, manualStyleName ="rt003Field")
	public String getPayeeName() {
		return payeeName;
	}
	public String getRegionIn() {
		return regionIn;
	}
	public void setRegionIn(String regionIn) {
		this.regionIn = regionIn;
	}
	public String getProvinceIn() {
		return provinceIn;
	}
	public void setProvinceIn(String provinceIn) {
		this.provinceIn = provinceIn;
	}
	public String getAmphur() {
		return amphur;
	}
	public void setAmphur(String amphur) {
		this.amphur = amphur;
	}
	public Date getChqDtFrom() {
		return chqDtFrom;
	}
	public void setChqDtFrom(Date chqDtFrom) {
		this.chqDtFrom = chqDtFrom;
	}
	public Date getChqDtTo() {
		return chqDtTo;
	}
	public void setChqDtTo(Date chqDtTo) {
		this.chqDtTo = chqDtTo;
	}
	public Date getTransferDtFrom() {
		return transferDtFrom;
	}
	public void setTransferDtFrom(Date transferDtFrom) {
		this.transferDtFrom = transferDtFrom;
	}
	public Date getTransferDtTo() {
		return transferDtTo;
	}
	public void setTransferDtTo(Date transferDtTo) {
		this.transferDtTo = transferDtTo;
	}
	public String getPaymentBy() {
		return paymentBy;
	}
	public void setPaymentBy(String paymentBy) {
		this.paymentBy = paymentBy;
	}
	public Date getPaymentDtFrom() {
		return paymentDtFrom;
	}
	public void setPaymentDtFrom(Date paymentDtFrom) {
		this.paymentDtFrom = paymentDtFrom;
	}
	public Date getPaymentDtTo() {
		return paymentDtTo;
	}
	public void setPaymentDtTo(Date paymentDtTo) {
		this.paymentDtTo = paymentDtTo;
	}
	public String getEstimateBy() {
		return estimateBy;
	}
	public void setEstimateBy(String estimateBy) {
		this.estimateBy = estimateBy;
	}
	public Date getEstimateDtFrom() {
		return estimateDtFrom;
	}
	public void setEstimateDtFrom(Date estimateDtFrom) {
		this.estimateDtFrom = estimateDtFrom;
	}
	public Date getEstimateDtTo() {
		return estimateDtTo;
	}
	public void setEstimateDtTo(Date estimateDtTo) {
		this.estimateDtTo = estimateDtTo;
	}
	public boolean isRenderCommandLink() {
		return renderCommandLink;
	}
	public void setRenderCommandLink(boolean renderCommandLink) {
		this.renderCommandLink = renderCommandLink;
	}
	public boolean isRenderCheckBox() {
		return renderCheckBox;
	}
	public void setRenderCheckBox(boolean renderCheckBox) {
		this.renderCheckBox = renderCheckBox;
	}
	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}
	@PCell(cellType = Double.class,no = 10, manualStyleName ="rt003FieldMoney")
	public Double getExcAmt() {
		return excAmt;
	}
	public void setExcAmt(Double excAmt) {
		this.excAmt = excAmt;
	}
	@PCell(cellType = Double.class,no = 11, manualStyleName ="rt003FieldMoney")
	public Double getWhtAmt() {
		return whtAmt;
	}
	public void setWhtAmt(Double whtAmt) {
		this.whtAmt = whtAmt;
	}
	@PCell(cellType = Double.class,no = 12, manualStyleName ="rt003FieldMoney")
	public Double getVatAmt() {
		return vatAmt;
	}
	public void setVatAmt(Double vatAmt) {
		this.vatAmt = vatAmt;
	}
	@PCell(cellType = Double.class,no = 13, manualStyleName ="rt003FieldMoney")
	public Double getChqAmt() {
		return chqAmt;
	}
	public void setChqAmt(Double chqAmt) {
		this.chqAmt = chqAmt;
	}
	@PCell(cellType = Double.class,no = 14, manualStyleName ="rt003FieldMoney")
	public Double getDiffAmt() {
		return diffAmt;
	}
	public void setDiffAmt(Double diffAmt) {
		this.diffAmt = diffAmt;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankAccNo() {
		return bankAccNo;
	}
	public void setBankAccNo(String bankAccNo) {
		this.bankAccNo = bankAccNo;
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
	@PCell(cellType = String.class,no = 15, manualStyleName ="rt003Field")
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getExportFlag() {
		return exportFlag;
	}
	public void setExportFlag(String exportFlag) {
		this.exportFlag = exportFlag;
	}
	public Date getExportDt() {
		return exportDt;
	}
	public void setExportDt(Date exportDt) {
		this.exportDt = exportDt;
	}
	public String getDocType() {
		return docType;
	}
	public void setDocType(String docType) {
		this.docType = docType;
	}
	
	public String getDoc68() {
		return doc68;
	}
	public void setDoc68(String doc68) {
		this.doc68 = doc68;
	}
	public String getDoc92() {
		return doc92;
	}
	public void setDoc92(String doc92) {
		this.doc92 = doc92;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getPicoFlag() {
		return picoFlag;
	}
	public void setPicoFlag(String picoFlag) {
		this.picoFlag = picoFlag;
	}
	public String getpTaxPayType() {
		return pTaxPayType;
	}
	public void setpTaxPayType(String pTaxPayType) {
		this.pTaxPayType = pTaxPayType;
	}
	public String getGovtName() {
		return govtName;
	}
	public void setGovtName(String govtName) {
		this.govtName = govtName;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	public boolean isSelected() {
		return selected;
	}
	@PCell(cellType = String.class,no = 1, manualStyleName ="rt003Field")
	public String getPaymentDocNo() {
		return paymentDocNo;
	}
	public void setPaymentDocNo(String paymentDocNo) {
		this.paymentDocNo = paymentDocNo;
	}
	@PCell(cellType = String.class,no = 6, manualStyleName ="rt003Field")
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}
	public String getSiteInfoId() {
		return siteInfoId;
	}
	public String getDocTypeDesc() {
		return docTypeDesc;
	}
	public void setDocTypeDesc(String docTypeDesc) {
		this.docTypeDesc = docTypeDesc;
	}
	public String getDocNo() {
		return docNo;
	}
	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}
	public Date getDocDt() {
		return docDt;
	}
	public void setDocDt(Date docDt) {
		this.docDt = docDt;
	}
	public void setPaymentTypeDesc(String paymentTypeDesc) {
		this.paymentTypeDesc = paymentTypeDesc;
	}
	public String getPaymentTypeDesc() {
		return paymentTypeDesc;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public String getpTaxYearFrom() {
		return pTaxYearFrom;
	}
	public void setpTaxYearFrom(String pTaxYearFrom) {
		this.pTaxYearFrom = pTaxYearFrom;
	}
	public String getpTaxYearTo() {
		return pTaxYearTo;
	}
	public void setpTaxYearTo(String pTaxYearTo) {
		this.pTaxYearTo = pTaxYearTo;
	}
	public String getPeriodNoFrom() {
		return periodNoFrom;
	}
	public void setPeriodNoFrom(String periodNoFrom) {
		this.periodNoFrom = periodNoFrom;
	}
	public String getPeriodNoTo() {
		return periodNoTo;
	}
	public void setPeriodNoTo(String periodNoTo) {
		this.periodNoTo = periodNoTo;
	}
	/**
	 * @param payGovtFlag the payGovtFlag to set
	 */
	public void setPayGovtFlag(String payGovtFlag) {
		this.payGovtFlag = payGovtFlag;
	}
	/**
	 * @return the payGovtFlag
	 */
	public String getPayGovtFlag() {
		return payGovtFlag;
	}
	/**
	 * @param estimateFlag the estimateFlag to set
	 */
	public void setEstimateFlag(String estimateFlag) {
		this.estimateFlag = estimateFlag;
	}
	/**
	 * @return the estimateFlag
	 */
	public String getEstimateFlag() {
		return estimateFlag;
	}
	
	public int getNo() {
		return no;
	}
	
	public void setNo(int no) {
		this.no = no;
	}
	@PCell(cellType = String.class,no = 0, manualStyleName ="rt003Field")
	public String getStringNo() {
		return no+"";
	}
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
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
	public String getPaymentStatusId() {
		return paymentStatusId;
	}
	public void setPaymentStatusId(String paymentStatusId) {
		this.paymentStatusId = paymentStatusId;
	}
	public String getSendInfoStatus() {
		return sendInfoStatus;
	}
	public void setSendInfoStatus(String sendInfoStatus) {
		this.sendInfoStatus = sendInfoStatus;
	}
	public String getDiffRemark() {
		return diffRemark;
	}
	public void setDiffRemark(String diffRemark) {
		this.diffRemark = diffRemark;
	}
	public String getDoc69() {
		return doc69;
	}
	public void setDoc69(String doc69) {
		this.doc69 = doc69;
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
	public String getExportDtStr() {
		return exportDtStr;
	}
	public void setExportDtStr(String exportDtStr) {
		this.exportDtStr = exportDtStr;
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
	public String getStrParam() {
		return strParam;
	}
	public void setStrParam(String strParam) {
		this.strParam = strParam;
	}
	
}
