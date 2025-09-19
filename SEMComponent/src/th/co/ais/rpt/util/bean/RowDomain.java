package th.co.ais.rpt.util.bean;

import java.util.HashMap;
import java.util.Map;

public class RowDomain {
	private int rowNo;
	private boolean isFont = true;
	private Map<Integer, CellDomain> cellList = new HashMap<Integer , CellDomain>();
	
	@Deprecated
	public RowDomain(int rowNo){
		this.rowNo = rowNo;
	}
	
	public RowDomain(int rowNo, boolean isFont){
		this.rowNo = rowNo;
		this.isFont = isFont;
	}
	
	public int getRowNo() {
		return rowNo;
	}
	
	public void setRowNo(int rowNo) {
		this.rowNo = rowNo;
	}
	
	public Map<Integer, CellDomain> getCellList() {
		return cellList;
	}
	
	public void setCellList(Map<Integer, CellDomain> cellList) {
		this.cellList = cellList;
	}
	
	public void setCell(CellDomain cell) {
		cellList.put(cell.getCellNoFrom(), cell);
	}
	
	public CellDomain getCellFromIndex(int index) {
		return cellList.get(index);
	}
	
	public CellDomain getAndRemoveCellFromIndex(int index) {
		CellDomain cell  = this.cellList.get(index);
		this.cellList.remove(index);
		return cell;
	}

	public boolean isFont() {
		return isFont;
	}

	public void setFont(boolean isFont) {
		this.isFont = isFont;
	}
	
}
