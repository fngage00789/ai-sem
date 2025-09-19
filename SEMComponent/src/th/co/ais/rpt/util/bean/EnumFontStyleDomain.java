package th.co.ais.rpt.util.bean;

import th.co.ais.rpt.util.enums.EnumFontType;

public class EnumFontStyleDomain {

	private boolean isBold;
	private boolean isItalic;
	private boolean isUnderLine;
	private short color;
	private short fontHeight;
	private String fontName;
	
	public EnumFontStyleDomain(EnumFontType enumFont){
		if(enumFont != null){
			this.isBold = enumFont.isBold();
			this.color = enumFont.getColor();
			this.fontHeight = enumFont.getFontHeight();
			this.fontName = enumFont.getFontName();
		}
	}

	public boolean isBold() {
		return isBold;
	}

	public EnumFontStyleDomain setBold(boolean isBold) {
		this.isBold = isBold;
		return this;
	}

	public boolean isItalic() {
		return isItalic;
	}

	public EnumFontStyleDomain setItalic(boolean isItalic) {
		this.isItalic = isItalic;
		return this;
	}

	public boolean isUnderLine() {
		return isUnderLine;
	}

	public EnumFontStyleDomain setUnderLine(boolean isUnderLine) {
		this.isUnderLine = isUnderLine;
		return this;
	}

	public short getColor() {
		return color;
	}

	public EnumFontStyleDomain setColor(short color) {
		this.color = color;
		return this;
	}

	public short getFontHeight() {
		return fontHeight;
	}

	public EnumFontStyleDomain setFontHeight(short fontHeight) {
		this.fontHeight = fontHeight;
		return this;
	}

	public String getFontName() {
		return fontName;
	}

	public EnumFontStyleDomain setFontName(String fontName) {
		this.fontName = fontName;
		return this;
	}
	
}
