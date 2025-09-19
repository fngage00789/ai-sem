package th.co.ais.rpt.util.enums;

public enum EnumDocumentType {
	DOC("doc"),XLS("xls"),PDF("pdf"),PPT("ppt");
	String type;
	private EnumDocumentType(String type){
		this.type = type;
	}
	
	public String getType(){
		return type;
	}
}
