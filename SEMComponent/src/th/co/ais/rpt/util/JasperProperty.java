package th.co.ais.rpt.util;

public class JasperProperty {
	
	private static JasperProperty instance = null;
	private String jasperPath = null;
	private String jasperSubReportPath = null;
	private String imagePath = null;
	private String exportPath = null;
	
	private JasperProperty(){
		
	}
	
	public static synchronized JasperProperty getInstance() {
        if (instance == null) {
            instance = new JasperProperty();
        }
        return instance;
    }

	public String getJasperPath() {
		return jasperPath;
	}

	public void setJasperPath(String jasperPath) {
		this.jasperPath = jasperPath;
	}

	public String getExportPath() {
		return exportPath;
	}

	public void setExportPath(String exportPath) {
		this.exportPath = exportPath;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getJasperSubReportPath() {
		return jasperSubReportPath;
	}

	public void setJasperSubReportPath(String jasperSubReportPath) {
		this.jasperSubReportPath = jasperSubReportPath;
	}
	
	
}
