package th.co.ais.web.report.util;

import java.util.HashMap;
import java.util.Map;

import th.co.ais.rpt.util.bean.EnumDocStyleDomain;
import th.co.ais.rpt.util.bean.EnumFontStyleDomain;
import th.co.ais.rpt.util.enums.EnumDocStyle;
import th.co.ais.rpt.util.enums.EnumFontType;

public final class EnumDocTypeManager {
	private Map<String , EnumDocStyleDomain> styleMap = new HashMap<String,EnumDocStyleDomain>();
	
	public Map<String, EnumDocStyleDomain> getStyleMap() {
		return styleMap;
	}

	public void setStyleMap(Map<String, EnumDocStyleDomain> styleMap) {
		this.styleMap = styleMap;
	}
	
	public EnumDocTypeManager(){
		
		this.styleMap.put("si002Field", new EnumDocStyleDomain(EnumDocStyle.CELL_NORMAL_CENTER).setEnumFont(new EnumFontStyleDomain(EnumFontType.FRONT_1).setBold(false).setFontHeight((short)10)).setHaveBorder(true).setBorderSide("ALL"));
		this.styleMap.put("si003Field", new EnumDocStyleDomain(EnumDocStyle.CELL_NORMAL_CENTER).setEnumFont(new EnumFontStyleDomain(EnumFontType.FRONT_1).setBold(false).setFontHeight((short)8)).setHaveBorder(true).setBorderSide("ALL"));
		this.styleMap.put("rt003Field", new EnumDocStyleDomain(EnumDocStyle.CELL_DEFAULT).setEnumFont(new EnumFontStyleDomain(EnumFontType.FRONT_1).setBold(false).setFontHeight((short)8)).setHaveBorder(true).setBorderSide("ALL"));
		this.styleMap.put("ct001Field", new EnumDocStyleDomain(EnumDocStyle.CELL_DEFAULT).setEnumFont(new EnumFontStyleDomain(EnumFontType.FRONT_1).setBold(false).setFontHeight((short)10)).setHaveBorder(true).setBorderSide("ALL"));
		this.styleMap.put("normalField", new EnumDocStyleDomain(EnumDocStyle.CELL_DEFAULT).setEnumFont(new EnumFontStyleDomain(EnumFontType.FRONT_1).setBold(false).setFontHeight((short)8)).setHaveBorder(false));
		this.styleMap.put("rt002FieldMoney", new EnumDocStyleDomain(EnumDocStyle.CELL_MONEY).setEnumFont(new EnumFontStyleDomain(EnumFontType.FRONT_1).setBold(false).setFontHeight((short)10)));
		this.styleMap.put("rt003FieldMoney", new EnumDocStyleDomain(EnumDocStyle.CELL_MONEY).setEnumFont(new EnumFontStyleDomain(EnumFontType.FRONT_1).setBold(false).setFontHeight((short)8)));
		this.styleMap.put("rt003FieldHeader", new EnumDocStyleDomain(EnumDocStyle.HEADER).setEnumFont(new EnumFontStyleDomain(EnumFontType.FRONT_1).setBold(true).setFontHeight((short)8)));
		this.styleMap.put("rt003TitleHeader", new EnumDocStyleDomain(EnumDocStyle.CELL_DEFAULT).setEnumFont(new EnumFontStyleDomain(EnumFontType.FRONT_1).setBold(true).setFontHeight((short)16)).setHaveBorder(false).setAlign((short)2));
		this.styleMap.put("pt003Field", new EnumDocStyleDomain(EnumDocStyle.CELL_NORMAL_CENTER).setEnumFont(new EnumFontStyleDomain(EnumFontType.FRONT_1).setBold(false).setFontHeight((short)10)).setHaveBorder(true).setBorderSide("ALL"));
		this.styleMap.put("pt003FieldTLR", new EnumDocStyleDomain(EnumDocStyle.CELL_NORMAL_CENTER).setEnumFont(new EnumFontStyleDomain(EnumFontType.FRONT_1).setBold(false).setFontHeight((short)10)).setHaveBorder(true).setBorderSide("LRT"));
		this.styleMap.put("pt003FieldLR", new EnumDocStyleDomain(EnumDocStyle.CELL_NORMAL_CENTER).setEnumFont(new EnumFontStyleDomain(EnumFontType.FRONT_1).setBold(false).setFontHeight((short)10)).setHaveBorder(true).setBorderSide("LR"));
		this.styleMap.put("pt003FieldLRB", new EnumDocStyleDomain(EnumDocStyle.CELL_NORMAL_CENTER).setEnumFont(new EnumFontStyleDomain(EnumFontType.FRONT_1).setBold(false).setFontHeight((short)10)).setHaveBorder(true).setBorderSide("LRB"));
	}

}
