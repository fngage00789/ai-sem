package th.co.ais.rpt.util.enums;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.IndexedColors;

public enum EnumFontType {
	HEADER(true, false, false, IndexedColors.BLACK.getIndex(), (short)10,null),
	FRONT_1(false, false, false, IndexedColors.BLACK.getIndex(), (short)8,null),
	FRONT_2(false, false, false, IndexedColors.BLACK.getIndex(), (short)10,null),
	FRONT_3(false, false, false, IndexedColors.DARK_BLUE.getIndex(),(short) 14,null),
	FRONT_4(false, false, false, IndexedColors.DARK_BLUE.getIndex(),(short) 15,null),
	FONT_5(true, false, false,IndexedColors.BLACK.getIndex(),(short)15 ,null),
	MANUAL(false, false, false,(short) 0,(short) 0,null);
	
	private boolean isBold;
	private boolean isItalic;
	private boolean isUnderLine;
	private short color;
	private short fontHeight;
	private String fontName;
	
	private EnumFontType(boolean isBold,boolean isItalic,boolean isUnderLine, short color, short fontHeight, String fontName){
		this.isBold = isBold;
		this.color = color;
		this.fontHeight = fontHeight;
		this.fontName = fontName;
	}

	public boolean isBold() {
		return isBold;
	}

	public void setBold(boolean isBold) {
		this.isBold = isBold;
	}

	public boolean isItalic() {
		return isItalic;
	}

	public void setItalic(boolean isItalic) {
		this.isItalic = isItalic;
	}

	public boolean isUnderLine() {
		return isUnderLine;
	}

	public void setUnderLine(boolean isUnderLine) {
		this.isUnderLine = isUnderLine;
	}

	public short getColor() {
		return color;
	}

	public void setColor(short color) {
		this.color = color;
	}

	public short getFontHeight() {
		return fontHeight;
	}

	public void setFontHeight(short fontHeight) {
		this.fontHeight = fontHeight;
	}

	public String getFontName() {
		return fontName;
	}

	public void setFontName(String fontName) {
		this.fontName = fontName;
	}

}
