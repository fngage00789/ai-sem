package th.co.ais.web.ir.bean;

import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.ir.InsurancePaySP;
import th.co.ais.domain.ir.Mir011Srch;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.bean.AbstractBean;

public class SEMMIR011Bean extends AbstractBean {

	private List<SelectItem> companyList;
	private List<SelectItem> networkTypeList;
	private List<SelectItem> transferTypeList;
	private List<SelectItem> policyTypeList;
	private List<SelectItem> paymentStatusList;
	private List<SelectItem> dateTypeList;
	
//	private InsurancePaySP insurancePaySP;
//	private List<WrapperBeanObject<InsurancePaySP>> insurancePaySPList;
	
	private Mir011Srch insurancePaySP;
	private List<WrapperBeanObject<Mir011Srch>> insurancePaySPList;
	
	@Override
	public int getRowPerPage() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setRowPerPage(int rowPerPage) {
		// TODO Auto-generated method stub

	}

	public List<SelectItem> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<SelectItem> companyList) {
		this.companyList = companyList;
	}

	public List<SelectItem> getNetworkTypeList() {
		return networkTypeList;
	}

	public void setNetworkTypeList(List<SelectItem> networkTypeList) {
		this.networkTypeList = networkTypeList;
	}

	public List<SelectItem> getTransferTypeList() {
		return transferTypeList;
	}

	public void setTransferTypeList(List<SelectItem> transferTypeList) {
		this.transferTypeList = transferTypeList;
	}

	public List<SelectItem> getPolicyTypeList() {
		return policyTypeList;
	}

	public void setPolicyTypeList(List<SelectItem> policyTypeList) {
		this.policyTypeList = policyTypeList;
	}

	public List<SelectItem> getPaymentStatusList() {
		return paymentStatusList;
	}

	public void setPaymentStatusList(List<SelectItem> paymentStatusList) {
		this.paymentStatusList = paymentStatusList;
	}

	public List<SelectItem> getDateTypeList() {
		return dateTypeList;
	}

	public void setDateTypeList(List<SelectItem> dateTypeList) {
		this.dateTypeList = dateTypeList;
	}

	public Mir011Srch getInsurancePaySP() {
		return insurancePaySP;
	}

	public void setInsurancePaySP(Mir011Srch insurancePaySP) {
		this.insurancePaySP = insurancePaySP;
	}

	public List<WrapperBeanObject<Mir011Srch>> getInsurancePaySPList() {
		return insurancePaySPList;
	}

	public void setInsurancePaySPList(
			List<WrapperBeanObject<Mir011Srch>> insurancePaySPList) {
		this.insurancePaySPList = insurancePaySPList;
	}


}
