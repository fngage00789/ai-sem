package th.co.ais.domain.mm;

public class ItemMasterSP {

	private String rowId;
	private String value;
	private String label;
	
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
	@Override
	public String toString() {
		return "ItemMasterSP [label=" + label + ", value=" + value + "]";
	}
	
}
