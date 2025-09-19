package th.co.ais.web.report.util;

import java.io.IOException;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFPrintSetup;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;

import th.co.ais.rpt.util.bean.CellDomain;
import th.co.ais.rpt.util.bean.EnumDocStyleDomain;
import th.co.ais.rpt.util.bean.EnumFontStyleDomain;
import th.co.ais.rpt.util.bean.RowDomain;
import th.co.ais.rpt.util.enums.EnumDocStyle;
import th.co.ais.rpt.util.enums.EnumDocumentType;
import th.co.ais.rpt.util.enums.EnumFontType;
import th.co.ais.util.SEMDataUtility;

public class DocumentExportManager <T> extends AbstractDocumentManager{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4507322389442862259L;
	private T objTemp;
	private Class<T> eClass;
	private Collection<T> eObjectList;
	private HashMap<String, Collection<T>> eObjectMap;
	private List<String> mapKeyList;
	
	public DocumentExportManager(Class clazz, EnumDocumentType documentType){
		eClass = clazz;
		docType = documentType;
	}
	
	public void getObjectFromDocument() throws IOException{
		switch(docType){
			case XLS :
				if(eObjectMap != null && !eObjectMap.isEmpty())
					exportExcelObjectManySheet();
				else
					exportExcelObject();
				break;
			case DOC : break;
			case PDF : break;
			default : break;
		}
	}
	
	private void exportExcelObject(){
		rowT = rowStart;
		List<CellDomain> listCell = sortExportCellList(eClass);
		boolean detailPass = false;
		String objText = "";
		HSSFCellStyle style;
		try{
			if((eObjectList != null && eObjectList.size() != 0) || 
					(listHeader != null) || (listFooter != null) || 
					(listDetail.size() > 0)){
				if(wb == null){
					wb =  new HSSFWorkbook();
					createFont();
				}
				sheet = wb.createSheet();
				if(isPrintPageLandScape()){
					sheet.getPrintSetup().setLandscape(true);
				}
				//set Margin
				if(marginLeft != null){
					sheet.setMargin(HSSFSheet.LeftMargin, marginLeft);
				}
				if(marginRight != null){
					sheet.setMargin(HSSFSheet.RightMargin, marginRight);				
				}
				if(marginTop != null){
					sheet.setMargin(HSSFSheet.TopMargin, marginTop);
				}
				if(marginTop != null){
					sheet.setMargin(HSSFSheet.BottomMargin, marginBottom);
				}
				//Set Page Size
				sheet.getPrintSetup().setPaperSize(pageSize);
				
				//Set width page and Hight page
				if(fitHeight != 0 || fitWidth != 0){
					sheet.setAutobreaks(true);
					sheet.getPrintSetup().setFitHeight(fitHeight);
					sheet.getPrintSetup().setFitWidth(fitWidth);
				}
				
				//Set Fit To one Page
				if(fitToPage){
					sheet.setAutobreaks(true);
					sheet.getPrintSetup().setFitHeight((short)1);
					sheet.getPrintSetup().setFitWidth((short)1);
				}
				
				/***********************/
				while(listDetail.size() > 0 || listHeader != null || !detailPass || listFooter != null ){
					
					if(checkFlagMode()){
						positionMode = false;
					}else{
						positionMode = true;
					}
					
					if(listDetail.get(rowT + (positionMode?"F":"H")) != null){
						// do write detail row
						generateRow(getAndRemoveDetailRowByIndex(rowT), positionMode);
						maxHeightPerRow = 0;
					}else{
						if(listHeader != null){
							// do write header row.
							if(listHeader.getRowNo() != -1){
								generateRow(listHeader, false);
								maxHeightPerRow = 0;
							}else{
								--rowT;
							}
							listHeader = null;
						}else{ if(!detailPass){
									// do list of object.
							
								if(eObjectList != null && eObjectList.size() > 0){ 
									for(T eObj : eObjectList){
										HSSFRow row = sheet.createRow(rowT);
										for(CellDomain cellD :listCell){
											HSSFCell cell = row.createCell(cellD.getCellNoFrom());
											Object obj = convertObjectType(eClass.getDeclaredMethod(generateGetterName(cellD.getCellName()), new Class[]{}).invoke(eObj, new Object[]{}), cellD.getClazz());
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
																
//																log.debug(" + + + + FORMAT + + + + : "+format);
																cell.setCellValue(format.format((Date)obj));
//																cell.setCellStyle(HSSFDataFormat.getBuiltinFormat("dd/MM/yyyy"));
//																cell.setCellType(Cell.CELL_TYPE_ERROR);
//																cell.setCellValue((Date)obj);
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
//											cell.getSheet().addMergedRegion(
//													new CellRangeAddress(
//										            row.getRowNum(), //first row (0-based)
//										            cellD.getRowNoTo() > -1 ? cellD.getRowNoTo(): row.getRowNum(),//last row  (0-based)
//										            cellD.getCellNoFrom(), //first column (0-based)
//										            cellD.getCellNoTo() > -1 ? cellD.getCellNoTo(): cellD.getCellNoFrom()//last column  (0-based)
//													));
											style = getStyle(cellD.getCellStyle());
											if(obj instanceof Date){
												style.setDataFormat(HSSFDataFormat.getBuiltinFormat("dd/MM/yyyy"));
												
											}
											style.setWrapText(false);
											cell.setCellStyle(style);
											// set row height when word wrap.
											if(columWidth.get(cellD.getCellNoFrom()) != null){
//												BigDecimal bRow = new BigDecimal((obj.toString().length() * cell.getCellStyle().getFont(wb).getFontHeight()));
												BigDecimal bRow = new BigDecimal(1);
												if(obj instanceof String){
													bRow = new BigDecimal((obj.toString().length() ));
												}else if(obj instanceof Date){
													bRow = new BigDecimal(10);
												}
												
												float hRow =  bRow.divide(new BigDecimal(columWidth.get(cellD.getCellNoFrom())), BigDecimal.ROUND_UP).floatValue();
												if(hRow > 1){
													if(hRow > maxHeightPerRow){
														maxHeightPerRow = hRow;
														row.setHeightInPoints(maxHeightPerRow * sheet.getDefaultRowHeightInPoints()); 
													}
												}
											}
											if(columnheight != 0){
												row.setHeightInPoints(columnheight);
											}
											objText = "";
										}
										++rowT;
										maxHeightPerRow = 0;
									}
									}
									if(maxLine < listCell.size()){
										maxLine = listCell.size();
									}
									rowD = rowT;
									rowT = -1;
									detailPass = true;
								}else{
									if(listFooter != null){
										// do write footer row.
										if(listFooter.getRowNo() != -1){
											generateRow(listFooter, true);
											maxHeightPerRow = 0;
										}else{
											--rowD;
										}
										listFooter = null;
									}
								}
							}
						}
					++rowT;
					}
				}
				for(int i = 0;i < maxLine ;i++){
					if(columWidth.get(i) != null){
						sheet.setColumnWidth(i, columWidth.get(i));
					}else{
						sheet.autoSizeColumn(i,true);
					}
				}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void exportExcelObjectManySheet(){
		rowT = rowStart;
		List<CellDomain> listCell = sortExportCellList(eClass);
		boolean detailPass = false;
		String objText = "";
		HSSFCellStyle style;
		HSSFSheet sheet2;
		try{
			if((mapKeyList != null && mapKeyList.size() != 0) || 
					(listHeader != null) || (listFooter != null) || 
					(listDetail.size() > 0)){
//				copyListDetail(true);
				for(int i=0;i<mapKeyList.size();i++){
					if(wb == null){
						wb =  new HSSFWorkbook();
						createFont();
					}
//					copyListDetail(false);
					createSheet(wb, mapKeyList.get(i));
					sheet = wb.getSheetAt(i);
					sheet = setSheetPage(sheet,mapKeyList.get(i));
//					if(i==0){
//						log.debug("sheet 1");
//						sheet = createSheet(wb, mapKeyList.get(i));
//						sheet = setSheetPage(sheet,mapKeyList.get(i));
//					}else{
//						log.debug("///////////////////////////");
//						log.debug("sheet 2");
//						copyListDetail(false);
//						sheet2 = createSheet(wb, mapKeyList.get(i));
//						sheet2 = setSheetPage(sheet2,mapKeyList.get(i));
//					}
					
				
				}
			}
			
				
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private HSSFSheet setSheetPage(HSSFSheet sheet,String key){
		rowT = rowStart;
		List<CellDomain> listCell = sortExportCellList(eClass);
		boolean detailPass = false;
		String objText = "";
		HSSFCellStyle style;
		int countListDetail = 0;
		
		try{
			if(isPrintPageLandScape()){
				sheet.getPrintSetup().setLandscape(true);
			}
			//set Margin
			if(marginLeft != null){
				sheet.setMargin(HSSFSheet.LeftMargin, marginLeft);
			}
			if(marginRight != null){
				sheet.setMargin(HSSFSheet.RightMargin, marginRight);				
			}
			if(marginTop != null){
				sheet.setMargin(HSSFSheet.TopMargin, marginTop);
			}
			if(marginTop != null){
				sheet.setMargin(HSSFSheet.BottomMargin, marginBottom);
			}
			//Set Page Size
			sheet.getPrintSetup().setPaperSize(pageSize);
			
			//Set width page and Hight page
			if(fitHeight != 0 || fitWidth != 0){
				sheet.setAutobreaks(true);
				sheet.getPrintSetup().setFitHeight(fitHeight);
				sheet.getPrintSetup().setFitWidth(fitWidth);
			}
			
			//Set Fit To one Page
			if(fitToPage){
				sheet.setAutobreaks(true);
				sheet.getPrintSetup().setFitHeight((short)1);
				sheet.getPrintSetup().setFitWidth((short)1);
			}
			
			/***********************/
			listDetail = listDetailMap.get(key);
			while(listDetail.size() > 0 || listHeader != null || !detailPass || listFooter != null ){
//			while(listDetail.size() > countListDetail || listHeader != null || !detailPass || listFooter != null ){
				if(checkFlagMode()){
					positionMode = false;
				}else{
					positionMode = true;
				}
				if(listDetail.get(rowT + (positionMode?"F":"H")) != null){
					// do write detail row
					sheet = generateRow(sheet,getAndRemoveDetailRowByIndex(rowT), positionMode); 
//					sheet = generateRow(sheet,getDetailRowByIndex(rowT), positionMode);
					maxHeightPerRow = 0;
//					++countListDetail;
				}else{
					if(listHeader != null){
						// do write header row.
						if(listHeader.getRowNo() != -1){
							sheet = generateRow(sheet,listHeader, false);
							maxHeightPerRow = 0;
						}else{
							--rowT;
						}
						listHeader = null;
					}else{ if(!detailPass){
								// do list of object.
						
							if(eObjectMap != null && eObjectMap.size() > 0){ 
								for(T eObj : eObjectMap.get(key)){
									HSSFRow row = sheet.createRow(rowT);
									for(CellDomain cellD :listCell){
										HSSFCell cell = row.createCell(cellD.getCellNoFrom());
										Object obj = convertObjectType(eClass.getDeclaredMethod(generateGetterName(cellD.getCellName()), new Class[]{}).invoke(eObj, new Object[]{}), cellD.getClazz());
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
															
	//														log.debug(" + + + + FORMAT + + + + : "+format);
															cell.setCellValue(format.format((Date)obj));
	//														cell.setCellStyle(HSSFDataFormat.getBuiltinFormat("dd/MM/yyyy"));
	//														cell.setCellType(Cell.CELL_TYPE_ERROR);
	//														cell.setCellValue((Date)obj);
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
	//									cell.getSheet().addMergedRegion(
	//											new CellRangeAddress(
	//								            row.getRowNum(), //first row (0-based)
	//								            cellD.getRowNoTo() > -1 ? cellD.getRowNoTo(): row.getRowNum(),//last row  (0-based)
	//								            cellD.getCellNoFrom(), //first column (0-based)
	//								            cellD.getCellNoTo() > -1 ? cellD.getCellNoTo(): cellD.getCellNoFrom()//last column  (0-based)
	//											));
										style = getStyle(cellD.getCellStyle());
										if(obj instanceof Date){
											style.setDataFormat(HSSFDataFormat.getBuiltinFormat("dd/MM/yyyy"));
											
										}
										style.setWrapText(false);
										cell.setCellStyle(style);
										// set row height when word wrap.
										if(columWidth.get(cellD.getCellNoFrom()) != null){
	//										BigDecimal bRow = new BigDecimal((obj.toString().length() * cell.getCellStyle().getFont(wb).getFontHeight()));
											BigDecimal bRow = new BigDecimal(1);
											if(obj instanceof String){
												bRow = new BigDecimal((obj.toString().length() ));
											}else if(obj instanceof Date){
												bRow = new BigDecimal(10);
											}
											
											float hRow =  bRow.divide(new BigDecimal(columWidth.get(cellD.getCellNoFrom())), BigDecimal.ROUND_UP).floatValue();
											if(hRow > 1){
												if(hRow > maxHeightPerRow){
													maxHeightPerRow = hRow;
													row.setHeightInPoints(maxHeightPerRow * sheet.getDefaultRowHeightInPoints()); 
												}
											}
										}
										if(columnheight != 0){
											row.setHeightInPoints(columnheight);
										}
										objText = "";
									}
									++rowT;
									maxHeightPerRow = 0;
								}
								}
								if(maxLine < listCell.size()){
									maxLine = listCell.size();
								}
								rowD = rowT;
								rowT = -1;
								detailPass = true;
							}else{
								if(listFooter != null){
									// do write footer row.
									if(listFooter.getRowNo() != -1){
										sheet = generateRow(sheet,listFooter, true);
										maxHeightPerRow = 0;
									}else{
										--rowD;
									}
									listFooter = null;
								}
							}
						}
					}
				++rowT;
				
				}
			for(int i = 0;i < maxLine ;i++){
				if(columWidth.get(i) != null){
					sheet.setColumnWidth(i, columWidth.get(i));
				}else{
					sheet.autoSizeColumn(i,true);
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return sheet;
	}
	

	public Collection<T> geteObjectList() {
		return eObjectList;
	}
	public void seteObjectList(Collection<T> eObjectList) {

		this.eObjectList = eObjectList;
	}
	
	public HashMap<String, Collection<T>> geteObjectMap() {
		return eObjectMap;
	}

	public void seteObjectMap(HashMap<String, Collection<T>> eObjectMap) {
		this.eObjectMap = eObjectMap;
	}

	public List<String> getMapKeyList() {
		return mapKeyList;
	}

	public void setMapKeyList(List<String> mapKeyList) {
		this.mapKeyList = mapKeyList;
	}

	private HSSFSheet createSheet(HSSFWorkbook wb, String sheetName) {
		HSSFSheet sheet = wb.createSheet(sheetName);
		return sheet;
	}
	
	private void copyListDetail(boolean toTmp){
		RowDomain rowDTmp;
		CellDomain cellTmp;
		if(toTmp){
			
			for(RowDomain rowD: listDetail.values()){
				rowDTmp = new RowDomain(rowD.getRowNo(),rowD.isFont());
				for(CellDomain cell : rowD.getCellList().values()){
					cellTmp = new CellDomain(cell.getCellNoFrom(), cell.getCellNoTo(), cell.getCellName(), cell.getClazz(), cell.getCellStyle(), cell.getCellValue(), cell.getRowNoTo(), cell.getWidth());;
					rowDTmp.setCell(cellTmp);
				}
				listDetailTmp.put(rowDTmp.getRowNo()+(rowDTmp.isFont()?"H":"F"), rowDTmp);
			}
		}else{
			for(RowDomain rowD: listDetailTmp.values()){
				rowDTmp = new RowDomain(rowD.getRowNo(),rowD.isFont());
				for(CellDomain cell : rowD.getCellList().values()){
					cellTmp = new CellDomain(cell.getCellNoFrom(), cell.getCellNoTo(), cell.getCellName(), cell.getClazz(), cell.getCellStyle(), cell.getCellValue(), cell.getRowNoTo(), cell.getWidth());;
					rowDTmp.setCell(cellTmp);
				}
				listDetail.put(rowDTmp.getRowNo()+(rowDTmp.isFont()?"H":"F"), rowDTmp);
			}
		}
		
	}
}
