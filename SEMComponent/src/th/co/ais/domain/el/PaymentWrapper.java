package th.co.ais.domain.el;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PaymentWrapper implements Serializable{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 755514363302090010L;
	
	public PaymentWrapper(){
		
		setPaymentList(new ArrayList<Payment>(0));
	}
	
	public PaymentWrapper(List<Payment> paymentList){
		
		setPaymentList(paymentList);
	}
	
	private boolean selected;
	private boolean rowSelected;
	private boolean visibleSaveExpenseButton1;
	private boolean visibleSaveExpenseButton2;
	private String docDtLabel;
	private String chqPostingDtLabel;
	private String chqReceivedDtLabel;
	private String transferDtLabel;
	
	private List<Payment> paymentList;

	public int getSize(){
		
		return getPaymentList() != null ? getPaymentList().size() : 0;
	}

	public String getDocDtLabel() {
		return docDtLabel;
	}

	public void setDocDtLabel(String docDtLabel) {
		this.docDtLabel = docDtLabel;
	}

	public String getChqPostingDtLabel() {
		return chqPostingDtLabel;
	}

	public void setChqPostingDtLabel(String chqPostingDtLabel) {
		this.chqPostingDtLabel = chqPostingDtLabel;
	}

	public String getChqReceivedDtLabel() {
		return chqReceivedDtLabel;
	}

	public void setChqReceivedDtLabel(String chqReceivedDtLabel) {
		this.chqReceivedDtLabel = chqReceivedDtLabel;
	}

	public String getTransferDtLabel() {
		return transferDtLabel;
	}

	public void setTransferDtLabel(String transferDtLabel) {
		this.transferDtLabel = transferDtLabel;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public List<Payment> getPaymentList() {
		return paymentList;
	}

	public void setPaymentList(List<Payment> paymentList) {
		this.paymentList = paymentList;
	}

	public boolean isVisibleSaveExpenseButton1() {
		return visibleSaveExpenseButton1;
	}

	public void setVisibleSaveExpenseButton1(boolean visibleSaveExpenseButton1) {
		this.visibleSaveExpenseButton1 = visibleSaveExpenseButton1;
	}

	public boolean isVisibleSaveExpenseButton2() {
		return visibleSaveExpenseButton2;
	}

	public void setVisibleSaveExpenseButton2(boolean visibleSaveExpenseButton2) {
		this.visibleSaveExpenseButton2 = visibleSaveExpenseButton2;
	}

	public boolean isRowSelected() {
		return rowSelected;
	}

	public void setRowSelected(boolean rowSelected) {
		this.rowSelected = rowSelected;
	}
}
