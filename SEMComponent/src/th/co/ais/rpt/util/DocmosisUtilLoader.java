package th.co.ais.rpt.util;

public class DocmosisUtilLoader {
	
	public void setDocmosisReportPath(String docmosisReportPath) {
		DocmosisProperty.getInstance().setDocmosisReportPath(docmosisReportPath);
	}

	public void setExportPath(String exportPath) {
		DocmosisProperty.getInstance().setExportPath(exportPath);
	}

	public void setImagePath(String imagePath) {
		DocmosisProperty.getInstance().setImagePath(imagePath);
	}

	public void setDocmosisSubReportPath(String docmosisSubReportPath) {
		DocmosisProperty.getInstance().setDocmosisSubReportPath(docmosisSubReportPath);
	}
	
}
