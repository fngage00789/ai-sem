package th.co.ais.rpt.util.enums;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;

import th.co.ais.rpt.util.bean.EnumFontStyleDomain;

public enum EnumDocStyle {
	HEADER(true, EnumFontType.HEADER, IndexedColors.LIGHT_CORNFLOWER_BLUE.getIndex(), CellStyle.ALIGN_CENTER, CellStyle.SOLID_FOREGROUND, null, false,(short)-1, true, "ALL"), 
	HEADER_DATE(true, EnumFontType.HEADER, IndexedColors.LIGHT_CORNFLOWER_BLUE.getIndex(), CellStyle.ALIGN_CENTER, CellStyle.SOLID_FOREGROUND, "d-mmm", false,(short)-1, true, "ALL"), 
	HEADER_TOPIC(true, EnumFontType.FRONT_4,IndexedColors.BLACK.getIndex(), CellStyle.ALIGN_CENTER, (short)-1, null, true,(short)-1, false, null), 
	HEADER_TOPIC_LEFT(true, EnumFontType.FRONT_4,IndexedColors.BLACK.getIndex(), CellStyle.ALIGN_LEFT, (short)-1, null, true,(short)-1, false, null), 
	HEADER_TOPIC_RIGHT(true, EnumFontType.FRONT_4,IndexedColors.BLACK.getIndex(), CellStyle.ALIGN_RIGHT, (short)-1, null, true,(short)-1, false, null),
	TITLE(true, EnumFontType.HEADER, IndexedColors.BLACK.getIndex(), CellStyle.ALIGN_CENTER, (short)-1, null, true,(short)-1, false, null), 
	TITLE_LEFT(true, EnumFontType.HEADER, IndexedColors.BLACK.getIndex(), CellStyle.ALIGN_LEFT, (short)-1, null, true,(short)-1, false, null),
	TITLE_BIG(true, EnumFontType.FONT_5, IndexedColors.BLACK.getIndex(), CellStyle.ALIGN_LEFT, (short)-1, null, true,(short)-1, false, null),
	CELL_B(false, EnumFontType.FRONT_1, IndexedColors.BLACK.getIndex(), CellStyle.ALIGN_LEFT, (short)-1, null, false,(short)-1, true, "ALL"), 
	CELL_BB(false, EnumFontType.FRONT_2, IndexedColors.BLUE.getIndex(), CellStyle.ALIGN_LEFT, (short)-1, null, false,(short)-1, true, "ALL"), 
	CELL_B_CENTER(false, EnumFontType.FRONT_1, IndexedColors.BLACK.getIndex(), CellStyle.ALIGN_CENTER, (short)-1, null, false,(short)-1, true, "ALL"), 
	CELL_B_DATE(false, EnumFontType.FRONT_1, IndexedColors.BLACK.getIndex(), CellStyle.ALIGN_RIGHT, (short)-1, "d-mmm", false,(short)-1, true, "ALL"),
	CELL_BG(false, EnumFontType.FRONT_1, IndexedColors.GREY_25_PERCENT.getIndex(), CellStyle.ALIGN_RIGHT, CellStyle.SOLID_FOREGROUND, "d-mmm", false,(short)-1, true, "ALL"), 
	CELL_H(false, EnumFontType.FRONT_3, IndexedColors.DARK_BLUE.getIndex(), CellStyle.ALIGN_LEFT , (short)-1, null, true,(short)-1, true, "ALL"), 
	CELL_G(false, EnumFontType.FRONT_1, IndexedColors.GREY_25_PERCENT.getIndex(), CellStyle.ALIGN_RIGHT, CellStyle.SOLID_FOREGROUND, "d-mmm", false,(short)-1, true, "ALL"), 
	CELL_NORMAL(false, EnumFontType.FRONT_1, IndexedColors.BLACK.getIndex(), CellStyle.ALIGN_LEFT, (short)-1, null, true,(short)-1, false, null), 
	CELL_NORMAL_CENTER(false, EnumFontType.FRONT_1, IndexedColors.BLACK.getIndex(), CellStyle.ALIGN_CENTER, (short)-1, null, true,(short)-1, false, null), 
	CELL_NORMAL_BIG_FONT(false, EnumFontType.FRONT_2, IndexedColors.BLACK.getIndex(), CellStyle.ALIGN_LEFT, (short)-1, null, true,(short)-1, false, null),
	CELL_NORMAL_BIG_FONT_CENTER(false, EnumFontType.FRONT_2, IndexedColors.BLACK.getIndex(), CellStyle.ALIGN_CENTER, (short)-1, null, true,(short)-1, false, null),
	CELL_NORMAL_DATE(false, EnumFontType.FRONT_1, IndexedColors.BLACK.getIndex(), CellStyle.ALIGN_RIGHT, (short)-1, null, true,(short)-1, false, null), 
	CELL_INDENTED(false, EnumFontType.FRONT_1, IndexedColors.BLACK.getIndex(), CellStyle.ALIGN_LEFT, (short)-1, null, true, (short)1, true, "ALL"), 
	CELL_BLUE(false, EnumFontType.FRONT_2, IndexedColors.BLUE.getIndex(), (short)-1, CellStyle.SOLID_FOREGROUND, null, false,(short)-1, true, "ALL"), 
	CELL_MONEY(false, EnumFontType.FRONT_2, IndexedColors.BLACK.getIndex(), (short)-1, (short)-1, "#,##0.00", true,(short)-1, true, "ALL"), 
	CELL_DEFAULT(false, EnumFontType.FRONT_2, IndexedColors.BLACK.getIndex(), (short)-1, (short)-1, null, true,(short)-1, true, "ALL"),
	MANUAL(false, EnumFontType.FRONT_1, IndexedColors.BLACK.getIndex(), (short)-1, (short)-1, null, true,(short)-1, false, null);
	
	//How to Use Manual Style.
	// You Can Define Every Config to EnumType. 
	//EnumDocStyle.MANUAL.setEnumFont(EnumFontType.MANUAL.set....).setDocFile(...).set.....;
	
	private boolean isHeader;
	private EnumFontStyleDomain enumFont; 
	private short bgColor;
	private short align;
	private short fillPattern;
	private String dataFormat; 
	private boolean wrapTxt; 
	private short indent;
	private boolean haveBorder;
	private String borderSide;
	
	private EnumDocStyle(boolean isHeader,EnumFontType enumFont, short bgColor, short align
			, short fillPattern, String dataFormat, boolean wrapTxt, short indent, boolean haveBorder,String borderSide) {
		
		this.isHeader = isHeader;
		this.enumFont = new EnumFontStyleDomain(enumFont); 
		this.bgColor = bgColor;
		this.align = align;
		this.fillPattern = fillPattern;
		this.dataFormat = dataFormat; 
		this.wrapTxt = wrapTxt; 
		this.indent = indent;
		this.haveBorder = haveBorder;
		this.borderSide = borderSide;
	}

	public boolean isHeader() {
		return isHeader;
	}

	public void setHeader(boolean isHeader) {
		this.isHeader = isHeader;
	}

	public EnumFontStyleDomain getEnumFont() {
		return enumFont;
	}

	public void setEnumFont(EnumFontStyleDomain enumFont) {
		this.enumFont = enumFont;
	}

	public short getBgColor() {
		return bgColor;
	}

	public void setBgColor(short bgColor) {
		this.bgColor = bgColor;
	}

	public short getAlign() {
		return align;
	}

	public void setAlign(short align) {
		this.align = align;
	}

	public short getFillPattern() {
		return fillPattern;
	}

	public void setFillPattern(short fillPattern) {
		this.fillPattern = fillPattern;
	}

	public String getDataFormat() {
		return dataFormat;
	}

	public void setDataFormat(String dataFormat) {
		this.dataFormat = dataFormat;
	}

	public boolean isWrapTxt() {
		return wrapTxt;
	}

	public void setWrapTxt(boolean wrapTxt) {
		this.wrapTxt = wrapTxt;
	}

	public short getIndent() {
		return indent;
	}

	public void setIndent(short indent) {
		this.indent = indent;
	}

	public boolean isHaveBorder() {
		return haveBorder;
	}

	public void setHaveBorder(boolean haveBorder) {
		this.haveBorder = haveBorder;
	}

	public String getBorderSide() {
		return borderSide;
	}

	public void setBorderSide(String borderSide) {
		this.borderSide = borderSide;
	}
	
}
