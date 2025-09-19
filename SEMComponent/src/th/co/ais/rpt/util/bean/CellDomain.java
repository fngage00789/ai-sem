package th.co.ais.rpt.util.bean;

import th.co.ais.rpt.util.enums.EnumDocStyle;

public class CellDomain {
	private Class<?> clazz;
	private String  cellName;
	private int cellNoFrom;
	private int cellNoTo = -1;
	private int rowNoTo = -1;
	private EnumDocStyleDomain cellStyle;
	private Object cellValue;
	private Integer width = null;
	
	public CellDomain(int no, String name, Class<?> clazz, EnumDocStyleDomain style,Integer width){
		this(no, -1, name, clazz, style, null,-1, width);
	}
	
	public CellDomain(int no, String name, Class<?> clazz, EnumDocStyleDomain style, Object value,Integer width){
		this(no, -1, name, clazz, style, value,-1, width);
	}
	
	public CellDomain(int cellNoFrom, int cellNoTo, String name, Class<?> clazz, EnumDocStyleDomain style,Integer width){
		this(cellNoFrom, cellNoTo, name, clazz, style, null,-1, width);
	}
	
	public CellDomain(int no, String name, Class<?> clazz, EnumDocStyleDomain style, int rowNoTo,Integer width){
		this(no, -1, name, clazz, style, null,rowNoTo, width);
	}
	
	public CellDomain(int no, String name, Class<?> clazz, EnumDocStyleDomain style, Object value, int rowNoTo,Integer width){
		this(no, -1, name, clazz, style, value, rowNoTo,width);
	}
	
	public CellDomain(int cellNoFrom, int cellNoTo, String name, Class<?> clazz, EnumDocStyleDomain style, int rowNoTo,Integer width){
		this(cellNoFrom, cellNoTo, name, clazz, style, null,-1,width);
	}
	
	public CellDomain(int cellNoFrom, int cellNoTo, String name, Class<?> clazz, EnumDocStyleDomain style, Object value,Integer width){
		this(cellNoFrom, cellNoTo, name, clazz, style, value,-1,width);
	}
	
/**/
	public CellDomain(int no, String name, Class<?> clazz, EnumDocStyleDomain style){
		this(no, -1, name, clazz, style, null ,-1, null);
	}
	
	public CellDomain(int no, String name, Class<?> clazz, EnumDocStyleDomain style, Object value){
		this(no, -1, name, clazz, style, value,-1, null);
	}
	
	public CellDomain(int cellNoFrom, int cellNoTo, String name, Class<?> clazz, EnumDocStyleDomain style){
		this(cellNoFrom, cellNoTo, name, clazz, style, null,-1, null);
	}
	
	public CellDomain(int no, String name, Class<?> clazz, EnumDocStyleDomain style, int rowNoTo){
		this(no, -1, name, clazz, style, null,rowNoTo, null);
	}
	
	public CellDomain(int no, String name, Class<?> clazz, EnumDocStyleDomain style, Object value, int rowNoTo){
		this(no, -1, name, clazz, style, value,rowNoTo, null);
	}
	
	public CellDomain(int cellNoFrom, int cellNoTo, String name, Class<?> clazz, EnumDocStyleDomain style, int rowNoTo){
		this(cellNoFrom, cellNoTo, name, clazz, style, null,-1,null);
	}
	
	public CellDomain(int cellNoFrom, int cellNoTo, String name, Class<?> clazz, EnumDocStyleDomain style, Object value){
		this(cellNoFrom, cellNoTo, name, clazz, style, value,-1,null);
	}
	
	public CellDomain(int cellNoFrom, int cellNoTo, String name, Class<?> clazz, EnumDocStyleDomain style, Object value, int rowNoTo,Integer width){
		this.cellNoFrom = cellNoFrom;
		this.cellNoTo = cellNoTo;
		this.rowNoTo = rowNoTo;
		this.clazz = clazz;
		this.cellName = name;
		this.cellStyle = style;
		this.cellValue = value;
		this.width = width;
	}
	
	public Class<?> getClazz() {
		return clazz;
	}
	public void setClazz(Class<?> clazz) {
		this.clazz = clazz;
	}
	public String getCellName() {
		return cellName;
	}
	public void setCellName(String cellName) {
		this.cellName = cellName;
	}
	public int getCellNoFrom() {
		return cellNoFrom;
	}
	public void setgetCellNoFrom(int cellNo) {
		this.cellNoFrom = cellNo;
	}
	
	public int getCellNoTo() {
		return cellNoTo;
	}
	public void setgetCellNoTo(int cellNo) {
		this.cellNoTo = cellNo;
	}

	public EnumDocStyleDomain getCellStyle() {
		return cellStyle;
	}

	public void setCellStyle(EnumDocStyleDomain cellStyle) {
		this.cellStyle = cellStyle;
	}

	public Object getCellValue() {
		return cellValue;
	}

	public void setCellValue(Object cellValue) {
		this.cellValue = cellValue;
	}

	public int getRowNoTo() {
		return rowNoTo;
	}

	public void setRowNoTo(int rowNoTo) {
		this.rowNoTo = rowNoTo;
	}

	public void setCellNoFrom(int cellNoFrom) {
		this.cellNoFrom = cellNoFrom;
	}

	public void setCellNoTo(int cellNoTo) {
		this.cellNoTo = cellNoTo;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}
	
}
