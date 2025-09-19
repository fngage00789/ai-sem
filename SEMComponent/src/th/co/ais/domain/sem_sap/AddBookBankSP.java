package th.co.ais.domain.sem_sap;

public class AddBookBankSP {
	
	protected String rowId;
	
	protected String koArt;
	protected String confirmChanges;
	protected String lifnr;
	protected String bankS;
	protected String bankL;
	protected String bankN;
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	public String getKoArt() {
		return koArt;
	}
	public void setKoArt(String koArt) {
		this.koArt = koArt;
	}
	public String getConfirmChanges() {
		return confirmChanges;
	}
	public void setConfirmChanges(String confirmChanges) {
		this.confirmChanges = confirmChanges;
	}
	public String getLifnr() {
		return lifnr;
	}
	public void setLifnr(String lifnr) {
		this.lifnr = lifnr;
	}
	public String getBankS() {
		return bankS;
	}
	public void setBankS(String bankS) {
		this.bankS = bankS;
	}
	public String getBankL() {
		return bankL;
	}
	public void setBankL(String bankL) {
		this.bankL = bankL;
	}
	public String getBankN() {
		return bankN;
	}
	public void setBankN(String bankN) {
		this.bankN = bankN;
	}
	
	@Override
	public String toString() {
		return "AddBookBankSP [bankL=" + bankL + ", bankN=" + bankN
				+ ", bankS=" + bankS + ", confirmChanges=" + confirmChanges
				+ ", koArt=" + koArt + ", lifnr=" + lifnr + ", rowId=" + rowId
				+ "]";
	}
	
	
}
