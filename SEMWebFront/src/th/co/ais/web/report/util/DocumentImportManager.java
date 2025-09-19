package th.co.ais.web.report.util;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import th.co.ais.rpt.util.bean.CellDomain;
import th.co.ais.rpt.util.enums.EnumDocumentType;


public class DocumentImportManager <T> extends AbstractDocumentManager{
	private T objTemp;
	private Class<T> eClass;
	private Collection<T> eObjectList;
	
	public DocumentImportManager(Class clazz, EnumDocumentType documentType){
		eClass = clazz;
		docType = documentType;
	}
	
	public Collection<T> getObjectFromDocument(){
		switch(docType){
			case XLS : return getExcelObject();
			case DOC : break;
			case PDF : break;
			default : break;
		}
		return null;
	}
	
	private Collection<T> getExcelObject(){
		List<CellDomain> listCell = sortImportCellList(eClass);
		try {
			eObjectList = new ArrayList<T>();
			if(inp != null){
				if(wb == null){
					wb =  new HSSFWorkbook(new POIFSFileSystem(inp));
				}
			}else{
				if(wb == null){
					wb =  new HSSFWorkbook();
				}
			}
			Sheet sheet1 = wb.getSheetAt(rowStart);
				for (Row row : sheet1) {
					objTemp = eClass.newInstance();
					if(skipRow <= row.getRowNum()){
						for (Cell cell : row) {
							try{
								int index = cell.getColumnIndex();
								int target = checkIndexObjOnRow(index, listCell);
								if(target > -1){
									switch(cell.getCellType()) {
										case Cell.CELL_TYPE_STRING: eClass.getMethod(generateSetterName(listCell.get(target).getCellName()), listCell.get(target).getClazz()).invoke(objTemp, 
																					(listCell.get(target).getClazz()).cast(cell.getRichStringCellValue().getString())); break;
										case Cell.CELL_TYPE_NUMERIC:{
												if(DateUtil.isCellDateFormatted(cell)) {
													eClass.getMethod(generateSetterName(listCell.get(target).getCellName()), listCell.get(target).getClazz()).invoke(objTemp, (listCell.get(target).getClazz()).cast(cell.getDateCellValue()));
												} else {
													eClass.getMethod(generateSetterName(listCell.get(target).getCellName()), listCell.get(target).getClazz()).invoke(objTemp,convertNumberType(cell.getNumericCellValue(),listCell.get(target).getClazz()));
												}
											} break;
										case Cell.CELL_TYPE_BLANK : break;
										case Cell.CELL_TYPE_BOOLEAN: eClass.getMethod(generateSetterName(listCell.get(target).getCellName()), listCell.get(target).getClazz()).invoke(objTemp, (listCell.get(target).getClazz()).cast(cell.getBooleanCellValue()));break;
										case Cell.CELL_TYPE_FORMULA:eClass.getMethod(generateSetterName(listCell.get(target).getCellName()), listCell.get(target).getClazz()).invoke(objTemp, (listCell.get(target).getClazz()).cast(cell.getCellFormula())); break;
										default: eClass.getMethod(generateSetterName(listCell.get(target).getCellName()), listCell.get(target).getClazz()).invoke(objTemp, null);
									}
								}
							}catch(Exception e){
								log.info("Data on cell : "+cell.getColumnIndex()+" row :"+row.getRowNum()+" , cannot convert to config type.");
								e.printStackTrace();}
						}
						eObjectList.add(objTemp);
					}
				}
			} catch (Exception e) {}
			return eObjectList;
	}
	
	public Collection<T> geteObjectList() {
		return eObjectList;
	}

	public void seteObjectList(Collection<T> eObjectList) {
		this.eObjectList = eObjectList;
	}
}
