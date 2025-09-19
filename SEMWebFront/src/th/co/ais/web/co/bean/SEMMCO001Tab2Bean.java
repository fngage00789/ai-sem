package th.co.ais.web.co.bean;

import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.co.ContractFile;
import th.co.ais.domain.co.Mco001SrchFileSP;
import th.co.ais.web.bean.AbstractBean;

public class SEMMCO001Tab2Bean extends AbstractBean {

	private static final long serialVersionUID = 7164670455509692855L;

	private List<SelectItem> contractDocType;
	private List<Mco001SrchFileSP> contractFileSPList;
	private ContractFile contractFile;
	private boolean displayShowReport;
	private List<SelectItem> contractDocTypeNew;

	public ContractFile getContractFile() {
		return contractFile;
	}

	public void setContractFile(ContractFile contractFile) {
		this.contractFile = contractFile;
	}

	public List<SelectItem> getContractDocType() {
		return contractDocType;
	}

	public void setContractDocType(List<SelectItem> contractDocType) {
		this.contractDocType = contractDocType;
	}

	public List<Mco001SrchFileSP> getContractFileSPList() {
		return contractFileSPList;
	}

	public void setContractFileSPList(List<Mco001SrchFileSP> contractFileSPList) {
		this.contractFileSPList = contractFileSPList;
	}

	public boolean isDisplayShowReport() {
		return displayShowReport;
	}

	public void setDisplayShowReport(boolean displayShowReport) {
		this.displayShowReport = displayShowReport;
	}

	public List<SelectItem> getContractDocTypeNew() {
		return contractDocTypeNew;
	}

	public void setContractDocTypeNew(List<SelectItem> contractDocTypeNew) {
		this.contractDocTypeNew = contractDocTypeNew;
	}

	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}

	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}
	
}
