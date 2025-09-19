package th.co.ais.web.report.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPrintSetup;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;

import th.co.ais.rpt.util.annotation.PCell;
import th.co.ais.rpt.util.bean.CellDomain;
import th.co.ais.rpt.util.bean.EnumDocStyleDomain;
import th.co.ais.rpt.util.bean.EnumFontStyleDomain;
import th.co.ais.rpt.util.bean.RowDomain;
import th.co.ais.rpt.util.enums.EnumDocStyle;
import th.co.ais.rpt.util.enums.EnumDocumentType;
import th.co.ais.rpt.util.enums.EnumFontType;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.web.util.FacesUtils;

public abstract class AbstractDocumentManager implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3782748052309644380L;
	private HashMap<String , HSSFCellStyle> styleMap = null;
	private HashMap<String , HSSFFont> fontMap = null;
	protected int skipRow = 0;
	protected EnumDocumentType docType;
	protected String filePath = "";
	protected InputStream inp;
	protected OutputStream out;
	protected HSSFWorkbook wb;
	protected HSSFSheet sheet;
	protected HSSFSheet[] sheets;
	protected int rowStart = 0;
	protected int sheetPage = 0;
	protected RowDomain listHeader = new RowDomain(-1);
	protected Map<String, RowDomain> listDetail = new HashMap<String, RowDomain>();
	protected Map<String,Map<String, RowDomain>> listDetailMap = new HashMap<String, Map<String,RowDomain>>();
	protected Map<String, RowDomain> listDetailTmp = new HashMap<String, RowDomain>();
	protected RowDomain listFooter = new RowDomain(-1);
	protected String contentType;
	protected String headerFile;
	protected String module;
	protected HSSFCellStyle style;
	protected HSSFFont font;
	protected HSSFDataFormat format;
	protected int rowT ;
	protected int rowD;
	protected Map<Integer,Integer> columWidth = new HashMap<Integer, Integer>();
	protected int maxLine = 0;
	protected boolean positionMode = true;
	protected float maxHeightPerRow = 0;
	protected boolean printPageLandScape;
	protected Map<String,EnumDocStyleDomain> styleList = new HashMap<String,EnumDocStyleDomain>();
	protected Logger log = Logger.getLogger(getClass());
	protected Double marginLeft = null, marginRight = null, marginTop = null, marginBottom = null;
	protected short pageSize = HSSFPrintSetup.A4_PAPERSIZE;
	protected short fitWidth = 0;
	protected short fitHeight = 0;
	protected boolean fitToPage = false;
	protected float columnheight = 0;   
	

	public AbstractDocumentManager(){
		this.putStyle(new EnumDocTypeManager().getStyleMap());
	}
	
	public List<CellDomain> sortCellList(Class<?> clazz) {
		Field[] fields = clazz.getDeclaredFields();
		Method[]  methods = clazz.getMethods();
		Map<Integer, CellDomain> map = new HashMap<Integer, CellDomain>();
		List<CellDomain> l = new ArrayList<CellDomain>();

		// mapping for filed
		for (Field f : fields) {
			if (f.getAnnotation(PCell.class) != null) {
				map.put(f.getAnnotation(PCell.class).no(), new CellDomain(
						f.getAnnotation(PCell.class).no(), f.getName(), 
						f.getAnnotation(PCell.class).cellType(),
						("".equals(f.getAnnotation(PCell.class).manualStyleName()) && !styleList.isEmpty())?
								new EnumDocStyleDomain(f.getAnnotation(PCell.class).styleName()):
								styleList.get(f.getAnnotation(PCell.class).manualStyleName())
						,null));
			}
		}
		
		// mapping for method
		for (Method m : methods) {
			if (m.getAnnotation(PCell.class) != null) {
				map.put(m.getAnnotation(PCell.class).no(), new CellDomain(
						m.getAnnotation(PCell.class).no(), 
						m.getName(),
						m.getAnnotation(PCell.class).cellType(),
						("".equals(m.getAnnotation(PCell.class).manualStyleName()) && !styleList.isEmpty())?
								new EnumDocStyleDomain(m.getAnnotation(PCell.class).styleName()):
								styleList.get(m.getAnnotation(PCell.class).manualStyleName())
						,null));
			}
		}
		
		int i = 0;
		while (map.size() > 0) {
			if (map.get(i) != null) {
				l.add(map.get(i));
				map.remove(i);
			}
			i++;
		}

		return l;
	}

	public List<CellDomain> sortExportCellList(Class<?> clazz) {
		Field[] fields = clazz.getDeclaredFields();
		Method[]  methods = clazz.getMethods();
		Map<Integer, CellDomain> map = new HashMap<Integer, CellDomain>();
		List<CellDomain> l = new ArrayList<CellDomain>();

		// mapping for filed
		for (Field f : fields) {
			if (f.getAnnotation(PCell.class) != null) {
				map.put(f.getAnnotation(PCell.class).no(), new CellDomain(
						f.getAnnotation(PCell.class).no(), f.getName(), 
						f.getAnnotation(PCell.class).cellType(),
						("".equals(f.getAnnotation(PCell.class).manualStyleName()) && !styleList.isEmpty())?
								new EnumDocStyleDomain(f.getAnnotation(PCell.class).styleName()):
								styleList.get(f.getAnnotation(PCell.class).manualStyleName())
						,null));
			}
		}
		
		// mapping for method
		for (Method m : methods) {
			if (m.getAnnotation(PCell.class) != null && ("get".equals(m.getName().substring(0,3)) || "is".equals(m.getName().substring(0,2)))) {
				map.put(m.getAnnotation(PCell.class).no(), new CellDomain(
						m.getAnnotation(PCell.class).no(), 
						m.getName(), 
						m.getAnnotation(PCell.class).cellType(),
						("".equals(m.getAnnotation(PCell.class).manualStyleName()) && !styleList.isEmpty())?
								new EnumDocStyleDomain(m.getAnnotation(PCell.class).styleName()):
								styleList.get(m.getAnnotation(PCell.class).manualStyleName())
						,null));
			}
		}
		
		int i = 0;
		while (map.size() > 0) {
			if (map.get(i) != null) {
				l.add(map.get(i));
				map.remove(i);
			}
			i++;
		}

		return l;
	}
	
	public List<CellDomain> sortImportCellList(Class<?> clazz) {
		Field[] fields = clazz.getDeclaredFields();
		Method[]  methods = clazz.getMethods();
		Map<Integer, CellDomain> map = new HashMap<Integer, CellDomain>();
		List<CellDomain> l = new ArrayList<CellDomain>();

		// mapping for filed
		for (Field f : fields) {
			if (f.getAnnotation(PCell.class) != null) {
				map.put(f.getAnnotation(PCell.class).no(), new CellDomain(
						f.getAnnotation(PCell.class).no(), f.getName(), 
						f.getAnnotation(PCell.class).cellType(),
						("".equals(f.getAnnotation(PCell.class).manualStyleName()) && !styleList.isEmpty())?
								new EnumDocStyleDomain(f.getAnnotation(PCell.class).styleName()):
								styleList.get(f.getAnnotation(PCell.class).manualStyleName())
						,null));
			}
		}
		
		// mapping for method
		for (Method m : methods) {
			if (m.getAnnotation(PCell.class) != null && "set".equals(m.getName().substring(0,3))) {
				map.put(m.getAnnotation(PCell.class).no(), new CellDomain(
						m.getAnnotation(PCell.class).no(), 
						m.getName(), 
						m.getAnnotation(PCell.class).cellType(),
						("".equals(m.getAnnotation(PCell.class).manualStyleName()) && !styleList.isEmpty())?
								new EnumDocStyleDomain(m.getAnnotation(PCell.class).styleName()):
								styleList.get(m.getAnnotation(PCell.class).manualStyleName())
						,null));
			}
		}
		
		int i = 0;
		while (map.size() > 0) {
			if (map.get(i) != null) {
				l.add(map.get(i));
				map.remove(i);
			}
			i++;
		}

		return l;
	}
	
	public Object convertNumberType(Object obj, Class<?> clazz) {
		Number n = (Number) obj;
		if (clazz == Integer.class || clazz == int.class) {
			return new Integer(n.intValue() + "");
		} else {
			if (clazz == Double.class || clazz == double.class) {
				return new Double(n.doubleValue() + "");
			} else {
				if (clazz == Long.class || clazz == long.class) {
					return new Long(n.longValue() + "");
				} else {
					if (clazz == Float.class || clazz == float.class) {
						return new Float(n.floatValue() + "");
					} else {
						if (clazz == String.class) {
							return n.toString();
						} else {
							return n;
						}
					}
				}
			}
		}
	}

	public Object convertObjectType(Object obj, Class<?> clazz) {
		try{
			if(clazz == Number.class){
				if(obj == null){
					return new Double(0);
				}
				return new Double(((Number)obj).doubleValue() + "");
			}
			
			if(clazz == Integer.class){
				if(obj == null){
					return new Double(0);
				}
				return new Double(((Number)obj).doubleValue() + "");
			}
			
			if(clazz == Double.class){
				if(obj == null){
					return new Double(0);
				}
				return new Double(((Number)obj).doubleValue() + "");
			}
			
			if(clazz == Float.class){
				if(obj == null){
					return new Double(0);
				}
				return new Double(((Number)obj).doubleValue() + "");
			}
			
			if(clazz == Long.class){
				if(obj == null){
					return new Double(0);
				}
				return new Double(((Number)obj).doubleValue() + "");
			}
			
			if(clazz == String.class){
				return obj + "";
			}
			
			if(clazz == Boolean.class){
				if(obj == null){
					return false;
				}
				return new Boolean(obj.toString());
			}
			
			if(clazz == Date.class){
				return Date.class.cast(obj);
			}
			
			if(clazz == Calendar.class){
				return Calendar.class.cast(obj);
			}	
		}catch(Exception e){
//			log.info(obj.getClass()+" cannot convert to class "+ clazz.getName());
			return "";
		}
		return clazz.cast(obj);
	}
	
	public int checkIndexObjOnRow(int index, List<CellDomain> domainList) {
		for (CellDomain cell : domainList) {
			if(cell.getCellNoTo() > -1){
				if (index >= cell.getCellNoFrom() || index <= cell.getCellNoTo()) {
					return domainList.indexOf(cell);
				}
			}else{
				if (index == cell.getCellNoFrom()) {
					return domainList.indexOf(cell);
				}
			}
		}
		return -1;
	}
	
	public String generateSetterName(String filed){
		if(!filed.substring(0,3).equals("set")){
			return "set" + filed.substring(0,1).toUpperCase() + filed.substring(1);
		}
		return filed;
	}
	
	public String generateGetterName(String filed){
		if(!filed.substring(0,3).equals("get")){
			return "get" + filed.substring(0,1).toUpperCase() + filed.substring(1);
		}
		return filed;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) throws FileNotFoundException {
		inp = new FileInputStream(filePath);
		this.filePath = filePath;
	}

	public InputStream getInp() {
		return inp;
	}

	public void setInp(InputStream inp) {
		this.inp = inp;
	}

	public OutputStream getOut() {
		return out;
	}

	public void setOut(OutputStream out) {
		this.out = out;
	}

	public HSSFWorkbook getWorkBook() {
		return wb;
	}

	public void setWorkBook(HSSFWorkbook wb) {
		this.wb = wb;
	}

	public EnumDocumentType getDocType() {
		return docType;
	}

	public void setDocType(EnumDocumentType docType) {
		this.docType = docType;
	}

	public int getSkipRow() {
		return skipRow;
	}

	public void setSkipRow(int skipRow) {
		this.skipRow = skipRow;
	}

	public int getRowStart() {
		return rowStart;
	}

	public void setRowStart(int rowStart) {
		this.rowStart = rowStart;
	}

	public HSSFSheet getSheet() {
		return sheet;
	}

	public void setSheet(HSSFSheet sheet) {
		this.sheet = sheet;
	}

	public int getSheetPage() {
		return sheetPage;
	}

	public void setSheetPage(int sheetPage) {
		this.sheetPage = sheetPage;
	}
	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getHeaderFile() {
		return headerFile;
	}

	public void setHeaderFile(String headerFile) {
		this.headerFile = headerFile;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public RowDomain getListHeader() {
		return listHeader;
	}

	public void setListHeader(RowDomain listHeader) {
		this.listHeader = listHeader;
	}

	public RowDomain getDetailRowByIndex(int index) {
//		return this.listDetail.get(index);
		RowDomain row  = this.listDetail.get(index + (positionMode?"F":"H"));
		return row;
	}
	
	
	public Map<String, Map<String, RowDomain>> getListDetailMap() {
		return listDetailMap;
	}

	public void setListDetailMap(Map<String, Map<String, RowDomain>> listDetailMap) {
		this.listDetailMap = listDetailMap;
	}

	public RowDomain getAndRemoveDetailRowByIndex(int index) {
		RowDomain row  = this.listDetail.get(index + (positionMode?"F":"H"));
		this.listDetail.remove(index + (positionMode?"F":"H"));
		return row;
	}
	
	public void setListDetail(List<RowDomain> listDetail) {
		for(RowDomain row : listDetail){
			this.listDetail.put(row.getRowNo()+(row.isFont()?"H":"F"), row);
		}
	}
	
	public void putDetailRow(RowDomain rowDetail) {
		this.listDetail.put(rowDetail.getRowNo()+(rowDetail.isFont()?"H":"F"), rowDetail);
	}
	
	public void putDetailRowMap(Map<String, RowDomain> listDetail,String key) {
		this.listDetailMap.put(key,listDetail);
	}

	public RowDomain getListFooter() {
		return listFooter;
	}

	public void setListFooter(RowDomain listFooter) {
		this.listFooter = listFooter;
	}

	public void generateRow(RowDomain rowD , boolean mode){
		String objText = "";
		if(rowD != null && rowD.getCellList().size() > 0){
			HSSFRow row = null;
			if(!mode){
				row = sheet.createRow(rowD.getRowNo());
			}else{
				row = sheet.createRow(rowD.getRowNo() + this.rowD);
			}
			int i = 0;
			while(rowD.getCellList().size() > 0){
				HSSFCell cell = row.createCell(i);
				if(rowD.getCellFromIndex(i) != null){
					CellDomain c = rowD.getAndRemoveCellFromIndex(i);
					Object obj = convertObjectType(c.getCellValue(), c.getClazz());
					
					if(obj != null){
						if(obj instanceof Number){
							cell.setCellValue((Double)obj);
							objText = ((Double)obj).toString();
						}else{
							if(obj instanceof String){
								cell.setCellValue(new HSSFRichTextString(obj.equals("null")?"": obj.toString()));
								objText = obj.equals("null")?"": obj.toString();
							}else{
								if(obj instanceof Calendar){
									cell.setCellValue((Calendar)obj);
									DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
									objText = (format.format(((Calendar)obj).getTime()));
								}else{
									if(obj instanceof Date){
										DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
										cell.setCellValue(format.format((Date)obj));
										objText = format.format((Date)obj);
									}else{
										if(obj instanceof Boolean){
											cell.setCellValue((Boolean)obj);
											objText = ((Boolean)obj).toString();
										}else{
											cell.setCellValue(obj.toString());
											objText = obj.toString();
										}
									}
								}
							}
						}
					}else{
						cell.setCellValue("");
					}
					cell.getSheet().addMergedRegion(
							new CellRangeAddress(
				            row.getRowNum(), //first row (0-based)
				            c.getRowNoTo() > -1 ?  c.getRowNoTo() : row.getRowNum(),//last row  (0-based)
				            c.getCellNoFrom(), //first column (0-based)
				            c.getCellNoTo() > -1 ? c.getCellNoTo() : c.getCellNoFrom()//last column  (0-based)
							));
					cell.setCellStyle(getStyle(c.getCellStyle()));
					
					if(c.getWidth() != null){
						columWidth.put(cell.getColumnIndex(), c.getWidth());
						BigDecimal bRow = new BigDecimal((obj.toString().length() * cell.getCellStyle().getFont(wb).getFontHeight()));
						float hRow =  bRow.divide(new BigDecimal(c.getWidth()), BigDecimal.ROUND_UP).floatValue();
						if(hRow > 1){
							if(hRow > maxHeightPerRow){
								maxHeightPerRow = hRow;
								row.setHeightInPoints(maxHeightPerRow * sheet.getDefaultRowHeightInPoints()); 
							}
						}
					}
					objText = "";
				}
				++i;
				if(maxLine < rowD.getCellList().size()){
					maxLine = rowD.getCellList().size();
				}
			}
		}
	}
	
	public HSSFSheet generateRow(HSSFSheet sheet,RowDomain rowD , boolean mode){
		String objText = "";
		if(rowD != null && rowD.getCellList().size() > 0){
			HSSFRow row = null;
			if(!mode){
				row = sheet.createRow(rowD.getRowNo());
			}else{
				row = sheet.createRow(rowD.getRowNo() + this.rowD);
			}
			int i = 0;
			while(rowD.getCellList().size() > 0){
				HSSFCell cell = row.createCell(i);
				if(rowD.getCellFromIndex(i) != null){
					CellDomain c = rowD.getAndRemoveCellFromIndex(i);
					Object obj = convertObjectType(c.getCellValue(), c.getClazz());
					
					if(obj != null){
						if(obj instanceof Number){
							cell.setCellValue((Double)obj);
							objText = ((Double)obj).toString();
						}else{
							if(obj instanceof String){
								cell.setCellValue(new HSSFRichTextString(obj.equals("null")?"": obj.toString()));
								objText = obj.equals("null")?"": obj.toString();
							}else{
								if(obj instanceof Calendar){
									cell.setCellValue((Calendar)obj);
									DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
									objText = (format.format(((Calendar)obj).getTime()));
								}else{
									if(obj instanceof Date){
										DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
										cell.setCellValue(format.format((Date)obj));
										objText = format.format((Date)obj);
									}else{
										if(obj instanceof Boolean){
											cell.setCellValue((Boolean)obj);
											objText = ((Boolean)obj).toString();
										}else{
											cell.setCellValue(obj.toString());
											objText = obj.toString();
											
										}
									}
								}
							}
						}
					}else{
						cell.setCellValue("");
					}
					cell.getSheet().addMergedRegion(
							new CellRangeAddress(
				            row.getRowNum(), //first row (0-based)
				            c.getRowNoTo() > -1 ?  c.getRowNoTo() : row.getRowNum(),//last row  (0-based)
				            c.getCellNoFrom(), //first column (0-based)
				            c.getCellNoTo() > -1 ? c.getCellNoTo() : c.getCellNoFrom()//last column  (0-based)
							));
					cell.setCellStyle(getStyle(c.getCellStyle()));
					
					if(c.getWidth() != null){
						columWidth.put(cell.getColumnIndex(), c.getWidth());
						BigDecimal bRow = new BigDecimal((obj.toString().length() * cell.getCellStyle().getFont(wb).getFontHeight()));
						float hRow =  bRow.divide(new BigDecimal(c.getWidth()), BigDecimal.ROUND_UP).floatValue();
						if(hRow > 1){
							if(hRow > maxHeightPerRow){
								maxHeightPerRow = hRow;
								row.setHeightInPoints(maxHeightPerRow * sheet.getDefaultRowHeightInPoints()); 
							}
						}
					}
					objText = "";
				}
				++i;
				if(maxLine < rowD.getCellList().size()){
					maxLine = rowD.getCellList().size();
				}
			}
		}
		return sheet;
	}
	
	public void exportServletFile() throws IOException{
		HttpServletResponse res = FacesUtils.getInstance().getHttpResponse();   
		res.setContentType("application/vnd.ms-excel");   
		
		try {
			String strDate = SEMDataUtility.getCurrentDateByPatternYYMMDD();
			res.setHeader("Content-disposition",  "attachment;filename=" + module + strDate +"." + docType.getType());   
		} catch (Exception e) {
			e.printStackTrace();
		}
		
        ServletOutputStream out = res.getOutputStream();   
        if(wb != null){
        	wb.write(out); 
        }  
        out.flush();   
        out.close();   
        FacesContext faces = FacesContext.getCurrentInstance();   
        faces.responseComplete(); 
	}
	
	public void exportFile() throws IOException{
		out = new FileOutputStream(filePath+"." + docType.getType());

        if(wb != null){
        	wb.write(out); 
        }  
        out.flush();   
        out.close();   
	}
	
	public void createFont(){
		format = wb.createDataFormat();
		font = wb.createFont();
	}
	
//	public HSSFCellStyle getStyle(EnumDocStyleDomain enumStyle) {
////		format = wb.createDataFormat();
////		font = wb.createFont();
//		
//
//			if(enumStyle.isHaveBorder()){
//				style = createBorderedStyle();
//			}else{
//				style = wb.createCellStyle();
//			}
//			if(enumStyle.isHeader()){
//				font.setBoldweight(Font.BOLDWEIGHT_BOLD);
//			}else{
//				font.setBoldweight(Font.BOLDWEIGHT_NORMAL);
//			}
//			style.setWrapText(enumStyle.isWrapTxt());
//			getFront(enumStyle.getEnumFont());
//			style.setFont(font);
//			style.setVerticalAlignment(HSSFCellStyle.VERTICAL_TOP);
//			if(enumStyle.getAlign() >= 0){
//				style.setAlignment(enumStyle.getAlign());
//			}
//			if(enumStyle.getBgColor() >= 0){
//				style.setFillForegroundColor(enumStyle.getBgColor());
//			}
//			if(enumStyle.getFillPattern() >= 0){
//				style.setFillPattern(enumStyle.getFillPattern());
//			}
//			if(enumStyle.getDataFormat() != null){
//				style.setDataFormat(format.getFormat(enumStyle.getDataFormat()));
//			}
//			if(enumStyle.getIndent() >= 0){
//				style.setIndention(enumStyle.getIndent());
//			}
//		
//		return this.style;
//	}
	
	/*
	 * Modify By : Jakrapan Paopisut
	 * Modify Date : (21/11/2011 20:03)
	 */
	public HSSFCellStyle getStyle(EnumDocStyleDomain enumStyle) {
//		format = wb.createDataFormat();
//		font = wb.createFont();
		HashMap<String, HSSFCellStyle> map = getFrontMap();
		HSSFCellStyle hssfCellStyle = null;
		StringBuffer getSBF = new StringBuffer();
		StringBuffer setSBF = null;
		String keyGetSBF = null;
		String keySetSBF = null;
		
		final String border = "B";
		final String regular = "R";
		final String wrapText = "WTT";
		final String nonWrapText = "WTF";
		final String align = "ALG";
		final String bgColor = "BGC";
		final String fillPattern = "FP";
		final String dateFormat = "DFT";
		final String indent = "IND";
		
		if(enumStyle.isHaveBorder()){
			getSBF.append(border).append("|");
		} else {
			getSBF.append(regular).append("|");
		}
		
		if (enumStyle.isWrapTxt()) {
			getSBF.append(wrapText).append("|");
		} else {
			getSBF.append(nonWrapText).append("|");
		}
		
		if(enumStyle.getAlign() >= 0){
			getSBF.append(align).append("|");
		}
		
		if(enumStyle.getBgColor() >= 0){
			getSBF.append(bgColor).append("|");
		}
		
		if(enumStyle.getFillPattern() >= 0){
			getSBF.append(fillPattern).append("|");
		}
		
		if(enumStyle.getDataFormat() != null){
			getSBF.append(dateFormat).append("|");
		}
		
		if(enumStyle.getIndent() >= 0){
			getSBF.append(indent).append("|");
		}
		
		if(enumStyle.getEnumFont().getFontHeight() >= 0){
			getSBF.append(enumStyle.getEnumFont().getFontHeight()).append("|");
		}
		
		if(enumStyle.isHaveBorder()){
			String borderSide = enumStyle.getBorderSide();
			if(StringUtils.equalsIgnoreCase("ALL", borderSide)){
				getSBF.append("ALL").append("|");
			}else{
				if(borderSide.indexOf("L") > 0){
					getSBF.append("L").append("|");
				}
				if(borderSide.indexOf("R") > 0){
					getSBF.append("R").append("|");
				}
				if(borderSide.indexOf("T") > 0){
					getSBF.append("T").append("|");
				}
				if(borderSide.indexOf("B") > 0){
					getSBF.append("B").append("|");
				}
			}
		}
		
		keyGetSBF = getSBF.toString();
		
		if (StringUtils.isNotEmpty(keyGetSBF) && StringUtils.isNotBlank(keyGetSBF)) {
			getFront(enumStyle.getEnumFont());
			if (map != null) {
				if (!map.containsKey(keyGetSBF)) {
					setSBF = new StringBuffer();
					
					if(enumStyle.isHeader()){
						font.setBoldweight(Font.BOLDWEIGHT_BOLD);
					}else{
						font.setBoldweight(Font.BOLDWEIGHT_NORMAL);
					}
					
					
					
					if(enumStyle.isHaveBorder()){
						hssfCellStyle = createBorderedStyle(enumStyle.getBorderSide());
						setSBF.append(border).append("|");
					} else {
						hssfCellStyle = wb.createCellStyle();
						setSBF.append(regular).append("|");
					}
					
					if (hssfCellStyle != null) {
						if (enumStyle.isWrapTxt()) {
							setSBF.append(wrapText).append("|");
						} else {
							setSBF.append(nonWrapText).append("|");
						}
						
						hssfCellStyle.setWrapText(enumStyle.isWrapTxt());
						hssfCellStyle.setFont(font);
						hssfCellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_TOP);
						
						if(enumStyle.getAlign() >= 0){
							hssfCellStyle.setAlignment(enumStyle.getAlign());
							setSBF.append(align).append("|");
						}
						
						if(enumStyle.getBgColor() >= 0){
							hssfCellStyle.setFillForegroundColor(enumStyle.getBgColor());
							setSBF.append(bgColor).append("|");
						}
						
						if(enumStyle.getFillPattern() >= 0){
							hssfCellStyle.setFillPattern(enumStyle.getFillPattern());
							setSBF.append(fillPattern).append("|");
						}
						
						if(enumStyle.getDataFormat() != null){
							hssfCellStyle.setDataFormat(format.getFormat(enumStyle.getDataFormat()));
							setSBF.append(dateFormat).append("|");
						}
						
						if(enumStyle.getIndent() >= 0){
							hssfCellStyle.setIndention(enumStyle.getIndent());
							setSBF.append(indent).append("|");
						}
						
						if(enumStyle.getEnumFont().getFontHeight() >= 0){
							setSBF.append(enumStyle.getEnumFont().getFontHeight()).append("|");
						}
						
						if(enumStyle.isHaveBorder()){
							String borderSide = enumStyle.getBorderSide();
							if(StringUtils.equalsIgnoreCase("ALL", borderSide)){
								setSBF.append("ALL").append("|");
							}else{
								if(borderSide.indexOf("L") > 0){
									setSBF.append("L").append("|");
								}
								if(borderSide.indexOf("R") > 0){
									setSBF.append("R").append("|");
								}
								if(borderSide.indexOf("T") > 0){
									setSBF.append("T").append("|");
								}
								if(borderSide.indexOf("B") > 0){
									setSBF.append("B").append("|");
								}
							}
						}
						map.put(setSBF.toString(), hssfCellStyle);
					}
				}
			}
			style = map.get(keyGetSBF);
		}
		
		return style;
	}

	public HSSFCellStyle createBorderedStyle(String borderSide) {
		HSSFCellStyle style = wb.createCellStyle();
		if(StringUtils.isNotEmpty(borderSide)){
			borderSide = borderSide.toUpperCase();
			if(StringUtils.equalsIgnoreCase("ALL", borderSide)){
				style.setBorderRight(CellStyle.BORDER_THIN);
				style.setRightBorderColor(IndexedColors.BLACK.getIndex());
				style.setBorderBottom(CellStyle.BORDER_THIN);
				style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
				style.setBorderLeft(CellStyle.BORDER_THIN);
				style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
				style.setBorderTop(CellStyle.BORDER_THIN);
				style.setTopBorderColor(IndexedColors.BLACK.getIndex());
				return style;
			}
			if(borderSide.indexOf("L") > 0){
				style.setBorderLeft(CellStyle.BORDER_THIN);
				style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
			}
			if(borderSide.indexOf("R") > 0){
				style.setBorderRight(CellStyle.BORDER_THIN);
				style.setRightBorderColor(IndexedColors.BLACK.getIndex());
			}
			if(borderSide.indexOf("T") > 0){
				style.setBorderTop(CellStyle.BORDER_THIN);
				style.setTopBorderColor(IndexedColors.BLACK.getIndex());
			}
			if(borderSide.indexOf("B") > 0){
				style.setBorderBottom(CellStyle.BORDER_THIN);
				style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
			}
		}
		return style;
	}
	
//	public void getFront(EnumFontStyleDomain fontType){
//		if(font != null){
//			font = wb.createFont();
//			if(fontType.isBold()){
//				font.setBoldweight(Font.BOLDWEIGHT_BOLD);
//			}
//			if(fontType.getFontName() != null){
//				font.setFontName(fontType.getFontName());
//			}
//			font.setColor(fontType.getColor());
//			if(fontType.getFontHeight() >= 0){
//				font.setFontHeightInPoints(fontType.getFontHeight());
//			}
//		}
//	}
	
	/*
	 * Modify By : Jakrapan Paopisut
	 * Modify Date : (22/11/2011 16:27)
	 */
	public void getFront(EnumFontStyleDomain fontType){
		HashMap<String, HSSFFont> fontMap = getFontMap();
		StringBuffer fontStr = new StringBuffer(); 
		StringBuffer setFontStr = new StringBuffer();
		final String bold = "B";
		
		if(font != null){
			if(fontType.isBold()){
				fontStr.append(bold).append("|");
			}
			if(fontType.getFontName() != null){
				fontStr.append(fontType.getFontName()).append("|");
			}
			if(fontType.getColor() >= 0){
				fontStr.append(fontType.getColor()).append("|");
			}
			
			if(fontType.getFontHeight() >= 0){
				fontStr.append(fontType.getFontHeight()).append("|");
			}
			
			if(fontMap != null){
				if(!fontMap.containsKey(fontStr.toString())){
					HSSFFont fontTmp = wb.createFont();
					if(fontType.isBold()){
						fontTmp.setBoldweight(Font.BOLDWEIGHT_BOLD);
						setFontStr.append(bold).append("|");
					}else{
						fontTmp.setBoldweight(Font.BOLDWEIGHT_NORMAL);
					}
					if(fontType.getFontName() != null){
						fontTmp.setFontName(fontType.getFontName());
						setFontStr.append(fontType.getFontName()).append("|");
					}
					if(fontType.getColor() >= 0){
						fontTmp.setColor(fontType.getColor());
						setFontStr.append(fontType.getColor()).append("|");
					}
					if(fontType.getFontHeight() >= 0){
						fontTmp.setFontHeightInPoints(fontType.getFontHeight());
						setFontStr.append(fontType.getFontHeight()).append("|");
					}
					fontMap.put(setFontStr.toString(), fontTmp);
				}
				font = fontMap.get(fontStr.toString());
			}
			
		}
	}
	
	public boolean checkFlagMode(){
		for(RowDomain row : listDetail.values()){
			if(row.isFont()){
				return true;
			}
		}
		return false;
	}

	public void setDocFile(File docFile) throws FileNotFoundException {
		inp = new FileInputStream(docFile);
	}

	public void setByteFile(byte[] byteFile) {
		inp = new ByteArrayInputStream(byteFile);
	}

	public boolean isPrintPageLandScape() {
		return printPageLandScape;
	}

	public void setPrintPageLandScape(boolean printLandScape) {
		this.printPageLandScape = printLandScape;
	}

	public Map<String, EnumDocStyleDomain> getStyleList() {
		return styleList;
	}

	public void setStyleList(Map<String, EnumDocStyleDomain> styleList) {
		this.styleList = styleList;
	}
	
	public void putStyle(String styleName, EnumDocStyleDomain enumDocStyle){
		styleList.put(styleName, enumDocStyle);
	}
	
	public void putStyle(Map<String,EnumDocStyleDomain> enumDocStyle){
		styleList.putAll(enumDocStyle);
	}
	
	public void removeStyle(String styleName){
		styleList.remove(styleName);
	}
	
	public EnumDocStyleDomain getStyle(String styleName){
		return styleList.get(styleName);
	}
	
	public void setMargin(double left,double right,double top,double bottom){
		marginLeft = left;
		marginRight = right;
		marginTop = top;
		marginBottom = bottom;
	}

	public short getPageSize() {
		return pageSize;
	}

	public void setPageSize(short pageSize) {
		this.pageSize = pageSize;
	}

	public short getFitWidth() {
		return fitWidth;
	}

	public void setFitWidth(short fitWidth) {
		this.fitWidth = fitWidth;
	}

	public short getFitHeight() {
		return fitHeight;
	}

	public void setFitHeight(short fitHeight) {
		this.fitHeight = fitHeight;
	}

	public boolean isFitToPage() {
		return fitToPage;
	}

	public void setFitToPage(boolean fitToPage) {
		this.fitToPage = fitToPage;
	}

	public HashMap<String, HSSFCellStyle> getFrontMap() {
		if (styleMap == null) {
			styleMap = new HashMap<String, HSSFCellStyle>();
		}
		return styleMap;
	}
	
	public HashMap<String, HSSFFont> getFontMap (){
		if (fontMap == null) {
			fontMap = new HashMap<String, HSSFFont>();
		}
		return fontMap;
	}

	public float getColumnheight() {
		return columnheight;
	}

	public void setColumnheight(float columnheight) {
		this.columnheight = columnheight;
	}

	public HSSFSheet[] getSheets() {
		return sheets;
	}

	public void setSheets(HSSFSheet[] sheets) {
		this.sheets = sheets;
	}

	public Map<String, RowDomain> getListDetail() {
		return listDetail;
	}

	public void setNewListDetail() {
		this.listDetail =  new HashMap<String, RowDomain>();
	}
	
}

