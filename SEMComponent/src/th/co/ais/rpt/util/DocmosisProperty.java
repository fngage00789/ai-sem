package th.co.ais.rpt.util;

public class DocmosisProperty {
	
	private static DocmosisProperty instance = null;
	private String docmosisReportPath = null;
	private String docmosisSubReportPath = null;
	private String imagePath = null;
	private String exportPath = null;
	
	private DocmosisProperty(){
		
	}
	
	public static synchronized DocmosisProperty getInstance() {
        if (instance == null) {
            instance = new DocmosisProperty();
        }
        return instance;
    }

	public String getDocmosisReportPath() {
		return docmosisReportPath;
	}

	public void setDocmosisReportPath(String docmosisReportPath) {
		this.docmosisReportPath = docmosisReportPath;
	}

	public String getDocmosisSubReportPath() {
		return docmosisSubReportPath;
	}

	public void setDocmosisSubReportPath(String docmosisSubReportPath) {
		this.docmosisSubReportPath = docmosisSubReportPath;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getExportPath() {
		return exportPath;
	}

	public void setExportPath(String exportPath) {
		this.exportPath = exportPath;
	}

	
}
