package th.co.ais.rpt.util;

public class JasperUtilLoader {
	
	public void setJasperPath(String jasperPath) {
		JasperProperty.getInstance().setJasperPath(jasperPath);
	}

	public void setExportPath(String exportPath) {
		JasperProperty.getInstance().setExportPath(exportPath);
	}

	public void setImagePath(String imagePath) {
		JasperProperty.getInstance().setImagePath(imagePath);
	}

	public void setJasperSubReportPath(String jasperSubReportPath) {
		JasperProperty.getInstance().setJasperSubReportPath(jasperSubReportPath);
	}
	
	
}
