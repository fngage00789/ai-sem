package th.co.ais.rpt.util.bean;

import th.co.ais.rpt.util.enums.EnumDocStyle;
import th.co.ais.rpt.util.enums.EnumFontType;

public class EnumDocStyleDomain {

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
	private EnumDocStyle enumDoc;
	
	public EnumDocStyleDomain(EnumDocStyle enumDoc){
		if(enumDoc != null){
			this.enumDoc = enumDoc;
			this.isHeader = enumDoc.isHeader();
			this.enumFont = enumDoc.getEnumFont(); 
			this.bgColor = enumDoc.getBgColor();
			this.align = enumDoc.getAlign();
			this.fillPattern = enumDoc.getFillPattern();
			this.dataFormat = enumDoc.getDataFormat(); 
			this.wrapTxt = enumDoc.isWrapTxt(); 
			this.indent = enumDoc.getIndent();
			this.haveBorder = enumDoc.isHaveBorder();
			this.borderSide = enumDoc.getBorderSide();
		}
	}

	public boolean isHeader() {
		return isHeader;
	}

	public EnumDocStyleDomain setHeader(boolean isHeader) {
		this.isHeader = isHeader;
		return this;
	}

	public short getBgColor() {
		return bgColor;
	}

	public EnumFontStyleDomain getEnumFont() {
		return enumFont;
	}

	public EnumDocStyleDomain setEnumFont(EnumFontStyleDomain enumFont) {
		this.enumFont = enumFont;
		return this;
	}

	public EnumDocStyleDomain setBgColor(short bgColor) {
		this.bgColor = bgColor;
		return this;
	}

	public short getAlign() {
		return align;
	}

	public EnumDocStyleDomain setAlign(short align) {
		this.align = align;
		return this;
	}

	public short getFillPattern() {
		return fillPattern;
	}

	public EnumDocStyleDomain setFillPattern(short fillPattern) {
		this.fillPattern = fillPattern;
		return this;
	}

	public String getDataFormat() {
		return dataFormat;
	}

	public EnumDocStyleDomain setDataFormat(String dataFormat) {
		this.dataFormat = dataFormat;
		return this;
	}

	public boolean isWrapTxt() {
		return wrapTxt;
	}

	public EnumDocStyleDomain setWrapTxt(boolean wrapTxt) {
		this.wrapTxt = wrapTxt;
		return this;
	}

	public short getIndent() {
		return indent;
	}

	public EnumDocStyleDomain setIndent(short indent) {
		this.indent = indent;
		return this;
	}

	public boolean isHaveBorder() {
		return haveBorder;
	}

	public EnumDocStyleDomain setHaveBorder(boolean haveBorder) {
		this.haveBorder = haveBorder;
		return this;
	}

	public EnumDocStyle getEnumDoc() {
		return enumDoc;
	}

	public void setEnumDoc(EnumDocStyle enumDoc) {
		this.enumDoc = enumDoc;
	}

	public String getBorderSide() {
		return borderSide;
	}

	public EnumDocStyleDomain setBorderSide(String borderSide) {
		this.borderSide = borderSide;
		return this;
	}
	
}
