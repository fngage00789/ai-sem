package th.co.ais.web.action;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;

import th.co.ais.domain.gm.Amphur;
import th.co.ais.domain.gm.Province;
import th.co.ais.domain.gm.Region;
import th.co.ais.domain.gm.VendorMaster;
import th.co.ais.domain.rt.EMAILModel;
import th.co.ais.domain.si.RegionZone;
import th.co.ais.service.gm.IAmphurService;
import th.co.ais.service.gm.IProvinceService;
import th.co.ais.service.gm.IVendorMasterService;
import th.co.ais.service.si.IRegionZoneService;
import th.co.ais.service.si.ISiteApproveService;
import th.co.ais.service.util.ServiceConstants;
import th.co.ais.util.AISConstant;
import th.co.ais.util.EQueryName;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.web.util.CompanyCacheUtil;
import th.co.ais.web.util.EmailMessageUtil;
import th.co.ais.web.util.FrontMessageUtils;
import th.co.ais.web.util.MSGCacheUtil;
import th.co.ais.web.util.RegionCacheUtil;
import th.co.ais.web.util.SelectItemLOVCacheUtil;
import th.co.ais.web.util.WebUtil;

public abstract class AbstractAction extends AbstractBaseAction{
	
	private static final long serialVersionUID = -1383641473985943656L;
	private static final Log LOG = LogFactory.getLog(AbstractAction.class);
	
	public static final String EVENT_ADD = "Add";
	public static final String EVENT_EDIT = "Edit";
	public static final String EVENT_VIEW = "View";
	public static final String EVENT_CLEAR = "Clear";
	public static final String EVENT_DELETE = "Delete";
	
	public abstract void init(); 
	public abstract boolean validate();
	public abstract boolean actionWithNavi(String methodWithNavi);
	public abstract void clearSessionNotUsed();
	
	public static String USER_SESSION = "userSession";
	
	public void clearAllSessionNotUsed(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove(USER_SESSION);
		//WebUtil.clearAllSessionNotUsed();
	}
	
	//Add by Bas 20110819
	public void clearRenderedMsg(){
		//Clear renderMsg For popup Error 
	}
	
	//Adding by mr.john 12/08/2010
	protected void addGeneralMessageError(String clientId, String message) {
		FrontMessageUtils.addMessageError(clientId, message);
	}
	
	protected void addGeneralMessageInfo(String clientId, String message) {
		FrontMessageUtils.addMessageInfo(clientId, message);
	}
	
	protected void addGeneralMessageError(String message) {
		FrontMessageUtils.addMessageError(message);
	}
	
	protected void addGeneralMessageInfo(String message) {
		FrontMessageUtils.addMessageInfo(message);
	}
	
	protected void addGeneralMessageWarn(String message) {
		FrontMessageUtils.addMessageWarn(message);
	}
	//End Adding by mr.john 12/08/2010
	
	protected void addMessageError(String messageCode) {
		FrontMessageUtils.addMessageError(
				SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode(messageCode), ""));
	}
	
	protected void addMessageError(String messageCode, String argument) {
		FrontMessageUtils.addMessageError(SEMDataUtility.
				buildMessage(MSGCacheUtil.getInstance().getMessageByCode(messageCode), argument));
	}
	
	
	protected void addMessageError(String clientId, String messageCode, String argument) {
		FrontMessageUtils.addMessageError(clientId, 
				SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode(messageCode), argument));
	}
	
	protected void addMessageErrorWithArgument(String messageCode, String... arguments) {
		FrontMessageUtils.addMessageError(
				SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode(messageCode), arguments));
	}

	protected void addMessageWarn(String messageCode) {
		FrontMessageUtils.addMessageWarn(
				SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode(messageCode), ""));
	}
	
	protected void addMessageWarn(String messageCode, String argument) {
		FrontMessageUtils.addMessageWarn(
				SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode(messageCode), argument));
	}
	
	protected void addMessageWarn(String clientId, String messageCode, String argument) {
		FrontMessageUtils.addMessageWarn(clientId, 
				SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode(messageCode), argument));
	}
	
	protected void addMessageWarn(String clientId, String messageCode, String... arguments) {
		FrontMessageUtils.addMessageWarn(clientId, 
				SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode(messageCode), arguments));
	}
	
	protected void addMessageWarn(String messageCode, List<String> argument) {
		FrontMessageUtils.addMessageWarn(
				SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode(messageCode), argument));
	}
	
	protected void addMessageInfo(String messageCode) {
		FrontMessageUtils.addMessageInfo(
				SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode(messageCode), ""));
	}
	
	protected void deleteMessageInfo() {
		FrontMessageUtils.deleteMessageInfo("");
	}
	
	protected void addMessageInfo(String messageCode, String argument) {
		FrontMessageUtils.addMessageInfo(
				SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode(messageCode), argument));
	}
	
	protected void addMessageInfo(String clientId, String messageCode, String argument) {
		FrontMessageUtils.addMessageInfo(clientId, 
				SEMDataUtility.buildMessage(MSGCacheUtil.getInstance().getMessageByCode(messageCode), argument));
	}

	protected String getMessageByCode(String messageCode){
		return MSGCacheUtil.getInstance().getMessageByCode(messageCode);
	}
	
	protected List<SelectItem> getLovItemsByTypeExceptLovCodes(String lovType, String notInLovCode){
		return SelectItemLOVCacheUtil.getInstance().getLovItemsByTypeExceptLovCodes(lovType, notInLovCode);
	}
	
	protected String getLovVal2(String lovType,String lovCode){
		return SelectItemLOVCacheUtil.getInstance().getLovVal2(lovType,lovCode);
	}
	
	protected List<SelectItem> getLovItemsByType(String lovType){
		return SelectItemLOVCacheUtil.getInstance().getLovItemsByType(lovType);
	}
	
	protected List<SelectItem> getLovItemsByTypeAndInsertFlag(String lovType, String insertFlag, String con1){
		return SelectItemLOVCacheUtil.getInstance().getLovItemsByTypeAndInsertFlag(lovType, insertFlag, con1);
	}
	
	protected List<SelectItem> getLovItemsByType(String lovType, String expression, String con1, String con2, String con3){
		return SelectItemLOVCacheUtil.getInstance().getLovItemsByType(lovType, expression, con1, con2, con3);
	}
	
	protected List<SelectItem> getCompanyItemsAll(){
		return CompanyCacheUtil.getInstance().getCompanySelItemsALL();
	}
	
	protected List<SelectItem> getCompanyItemsByRole(){
		return CompanyCacheUtil.getInstance().getCompanySelItemsByRole();
	}
	
	protected List<SelectItem> getRegionItems(){
		return RegionCacheUtil.getInstance().getRegionSelList();
	}
	
	/*protected String validateDateFormat(Date date) throws Exception{
		LOG.info("-- validateDateFormat --");
		String dtStr = SEMDataUtility.toStringEngDateSimpleFormat(date);
		LOG.info("-- dtStr --" + dtStr);
		String msg = AISDataValidateUtil.isDate(dtStr);
		return msg;
	}*/
	
	public List<SelectItem> getProvinceBySamRegion(Object[] SamRegion) {
		IProvinceService provinceService = (IProvinceService) getBean("provinceService");
		List<SelectItem> selList = new ArrayList<SelectItem>();
		selList.add(setInitDropDown());
		SelectItem selItem = null;
		try{
			List<Province> provinceList = provinceService.getListProvinceBySamRegions(SamRegion);
			if(provinceList != null && !provinceList.isEmpty()){
				for(Province province : provinceList){
					selItem = new SelectItem();
					selItem.setLabel(province.getThaiName());
					selItem.setValue(province.getRowId());
					selList.add(selItem);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return selList;
	}
	
	public final RegionZone getRegionZoneList() {
		RegionZone regZone =  new RegionZone();
		try{
			IRegionZoneService regionZoneService = (IRegionZoneService) getBean("regionZoneService");
			List<Object[]> regionList = regionZoneService.getRegionZone();
			if(regionList != null && !regionList.isEmpty()){
				for(Object[] region : regionList){
					regZone.putRegionZone(region[1].toString(),region[0].toString());
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return regZone;
	}
	
	public List<SelectItem> getAmphurByProvince(Province province) {
		IAmphurService amphurService = (IAmphurService) getBean("amphurService");
		List<SelectItem> selList = new ArrayList<SelectItem>();
		selList.add(setInitDropDown());
		SelectItem selItem = null;
		try{
			List<Amphur> amphurList = amphurService.getListAmphurByProvince(province);
			if(amphurList != null && !amphurList.isEmpty()){
				for(Amphur amphur : amphurList){
					selItem = new SelectItem();
					selItem.setLabel(amphur.getThaiName());
					selItem.setValue(amphur.getRowId());
					selList.add(selItem);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return selList;
	}
	
	public List<SelectItem> getGovtByProvince(VendorMaster vMaster) {
		IVendorMasterService vendorMasterService = (IVendorMasterService) getBean("vendorMasterService");
		List<SelectItem> selList = new ArrayList<SelectItem>();
		selList.add(setInitDropDown());
		SelectItem selItem = null;
		try{
			List<VendorMaster> vendorMasterList = vendorMasterService.queryVendorMaster(vMaster, null);
			if(vendorMasterList != null && !vendorMasterList.isEmpty()){
				for(VendorMaster vendorMaster : vendorMasterList){
					selItem = new SelectItem();
					selItem.setLabel(vendorMaster.getVendorName());
					selItem.setValue(vendorMaster.getRowId());
					selList.add(selItem);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return selList;
	}
	
	protected SelectItem setInitDropDown() {
		SelectItem item = new SelectItem("" , msg("value.selectItem"));
		return item;
	}
	
	protected List<SelectItem> getEmptyDropDown() {
		List<SelectItem> selList = new ArrayList<SelectItem>();
		selList.add(setInitDropDown());
		return selList;
	}
	
	protected String getParameterDateStr(Date d) {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		if (d != null) {
			try {
				return df.format(d);
			} catch (Exception e) {
				return "";
			}
		} else {
			return "";
		}
	}
	
	protected Date parseParameterToDate(String str) {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		if (StringUtils.isNotEmpty(str)) {
			try {
				return df.parse(str);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		} else {
			return null;
		}
	}
	
	protected String getDisplayMode(String modeName){
		if(StringUtils.equals(ServiceConstants.MODULE_ACTION_INSERT, modeName)){
			return EVENT_ADD; 
		}
		if(StringUtils.equals(ServiceConstants.MODULE_ACTION_UPDATE, modeName)){
			return EVENT_EDIT; 
		}
		if(StringUtils.equals(ServiceConstants.MODULE_ACTION_SELECT, modeName)){
			return EVENT_VIEW; 
		}
		if(StringUtils.equals(ServiceConstants.MODULE_ACTION_DELETE, modeName)){
			return EVENT_DELETE; 
		}
		return "";
	}
	
	
	protected void setExcelStyle(HSSFCellStyle style, HSSFRow row, short cellNo, Object cellVal){
		
		HSSFCell cell = row.createCell((short)cellNo);
		if(cellVal instanceof String)
		cell.setCellValue(new HSSFRichTextString((String)cellVal));
		else if(cellVal instanceof Double)
		cell.setCellValue((Double)cellVal);
		
		cell.setCellStyle(style);
		

	}
	
	/**
     * create a library of cell styles
     */
    public Map<String, HSSFCellStyle> createStyles(HSSFWorkbook wb){
        Map<String, HSSFCellStyle> styles = new HashMap<String, HSSFCellStyle>();
        
        HSSFDataFormat df = wb.createDataFormat();
        HSSFDataFormat format = wb.createDataFormat();
        
        HSSFCellStyle style;
        HSSFFont headerFont = wb.createFont();
        headerFont.setBoldweight(org.apache.poi.ss.usermodel.Font.BOLDWEIGHT_BOLD);
        style = createBorderedStyle(wb);
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setFillForegroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setFont(headerFont);
        styles.put("header", style);

        style = createBorderedStyle(wb);
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setFillForegroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setFont(headerFont);
        style.setDataFormat(df.getFormat("d-mmm"));
        styles.put("header_date", style);

        HSSFFont font1 = wb.createFont();
        font1.setBoldweight(org.apache.poi.ss.usermodel.Font.BOLDWEIGHT_BOLD);
        style = createBorderedStyle(wb);
        style.setAlignment(CellStyle.ALIGN_LEFT);
        style.setFont(font1);
        styles.put("cell_b", style);

        style = createBorderedStyle(wb);
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setFont(font1);
        styles.put("cell_b_centered", style);

        style = createBorderedStyle(wb);
        style.setAlignment(CellStyle.ALIGN_RIGHT);
        style.setFont(font1);
        style.setDataFormat(df.getFormat("d-mmm"));
        styles.put("cell_b_date", style);

        style = createBorderedStyle(wb);
        style.setAlignment(CellStyle.ALIGN_RIGHT);
        style.setFont(font1);
        style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setDataFormat(df.getFormat("d-mmm"));
        styles.put("cell_g", style);

        HSSFFont font2 = wb.createFont();
        font2.setColor(IndexedColors.BLUE.getIndex());
        font2.setBoldweight(org.apache.poi.ss.usermodel.Font.BOLDWEIGHT_BOLD);
        style = createBorderedStyle(wb);
        style.setAlignment(CellStyle.ALIGN_LEFT);
        style.setFont(font2);
        styles.put("cell_bb", style);

        style = createBorderedStyle(wb);
        style.setAlignment(CellStyle.ALIGN_RIGHT);
        style.setFont(font1);
        style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setDataFormat(df.getFormat("d-mmm"));
        styles.put("cell_bg", style);

        HSSFFont font3 = wb.createFont();
        font3.setFontHeightInPoints((short)14);
        font3.setColor(IndexedColors.DARK_BLUE.getIndex());
        font3.setBoldweight(org.apache.poi.ss.usermodel.Font.BOLDWEIGHT_BOLD);
        style = createBorderedStyle(wb);
        style.setAlignment(CellStyle.ALIGN_LEFT);
        style.setFont(font3);
        style.setWrapText(true);
        styles.put("cell_h", style);

        style = createBorderedStyle(wb);
        style.setAlignment(CellStyle.ALIGN_LEFT);
        style.setWrapText(true);
        styles.put("cell_normal", style);

        style = createBorderedStyle(wb);
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setWrapText(true);
        styles.put("cell_normal_centered", style);

        style = createBorderedStyle(wb);
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setWrapText(true);
        style.setDataFormat(df.getFormat("d-mmm"));
        styles.put("cell_normal_date", style);

        style = createBorderedStyle(wb);
        style.setAlignment(CellStyle.ALIGN_LEFT);
        style.setIndention((short)1);
        style.setWrapText(true);
        styles.put("cell_indented", style);

        style = createBorderedStyle(wb);
        style.setFillForegroundColor(IndexedColors.BLUE.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        styles.put("cell_blue", style);
		
		style = createBorderedStyle(wb);
		style.setDataFormat(format.getFormat("#,##0.00"));
		style.setWrapText(true);
		styles.put("cell_money", style);
		
		style = createBorderedStyle(wb);
		style.setAlignment(CellStyle.ALIGN_CENTER);
		style.setWrapText(true);
		styles.put("cell_default", style);
		
		// 20110118 header topic by ming
		HSSFFont font4 = wb.createFont();
	    font4.setFontHeightInPoints((short)15);
	    font4.setBoldweight(org.apache.poi.ss.usermodel.Font.BOLDWEIGHT_BOLD);
	    style = wb.createCellStyle();
	    style.setAlignment(CellStyle.ALIGN_CENTER);
	    style.setFont(font4);
	    style.setWrapText(true);
	    styles.put("header_topic", style);
		
        return styles;
    }
    
    private static HSSFCellStyle createBorderedStyle(HSSFWorkbook wb){
    	HSSFCellStyle style = wb.createCellStyle();
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
	
    public Object checkObjNull(Object obj){
    	try{
			if(obj == null){
				return obj = "";
			}else {
				if(!obj.equals("") && (obj.toString().equals("0.0"))){
					return  obj = "";
				}else{
					return obj;
				}
			}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return obj;
	}
	
    protected String getMapRowId() {
		return "zx" + new SimpleDateFormat("mmssSS").format(new Date())
					+ new Random().nextInt(100000)
					+ new Random().nextInt(10000);
	}
    
    public Object getValueFromCell(HSSFCell cell,String type){
		Object o = null;
		if(cell != null){
			switch (cell.getCellType()) {
				case Cell.CELL_TYPE_STRING:
					o = cell.getRichStringCellValue().getString();
					break;
				case Cell.CELL_TYPE_NUMERIC:
					o = cell.getNumericCellValue();
					break;
				case Cell.CELL_TYPE_BLANK:
					break;
				case Cell.CELL_TYPE_BOOLEAN:
					break;
				case Cell.CELL_TYPE_FORMULA:
					break;
				default:;
			}
			if(o instanceof Double){
				if(type.equals(AISConstant.STRING_TYPE) && o != null){
					double d = Double.parseDouble(o.toString());
					NumberFormat nf = new DecimalFormat("##########.##");
					String o1 = nf.format(d);
					return o1.toString();
				}
			}else if(o instanceof String){
				if(type.equals(AISConstant.DOUBLE_TYPE)){
					return Double.parseDouble(o.toString());
				}
			}
		}else{
			LOG.debug("Cell Is Null");
		}
		return o;
	}
    
    public Object getValueFromCellXLS(XSSFCell cell,String type){
		Object o = null;
		if(cell != null){
			switch (cell.getCellType()) {
				case Cell.CELL_TYPE_STRING:
					o = cell.getRichStringCellValue().getString();
					break;
				case Cell.CELL_TYPE_NUMERIC:
					o = cell.getNumericCellValue();
					break;
				case Cell.CELL_TYPE_BLANK:
					break;
				case Cell.CELL_TYPE_BOOLEAN:
					break;
				case Cell.CELL_TYPE_FORMULA:
					break;
				default:;
			}
			if(o instanceof Double){
				if(type.equals(AISConstant.STRING_TYPE) && o != null){
					double d = Double.parseDouble(o.toString());
					NumberFormat nf = new DecimalFormat("##########.##");
					String o1 = nf.format(d);
					return o1.toString();
				}
			}else if(o instanceof String){
				if(type.equals(AISConstant.DOUBLE_TYPE)){
					return Double.parseDouble(o.toString());
				}
			}
		}else{
			LOG.debug("Cell Is Null");
		}
		return o;
	}
    
    public static boolean isNumeric(String str)
	{
	    return str.matches("-?\\d+(.\\d+)?");
	}
    
    public List<SelectItem> setSelectItemList(List<String> strList,boolean withSelect){
    	List<SelectItem> resultList = new ArrayList<SelectItem>();
    	SelectItem selectItem = null;
    	if(withSelect)
    		resultList.add(new SelectItem("" , msg("value.selectItem")));
    	for(String str:strList){
    		selectItem = new SelectItem();
    		selectItem.setLabel(str);
    		selectItem.setValue(str);
    		resultList.add(selectItem);
    	}
    	return resultList;
    }
    
    
    // ->
    public List<SelectItem> getProvinceList_SEM() {
    	IProvinceService provinceService = (IProvinceService) getBean("provinceService");
		List<SelectItem> selList = new ArrayList<SelectItem>();
		selList.add(setInitDropDown());
		SelectItem selItem = null;
		try{
			List<Province> provinceList = provinceService.getProvinceList_SEM();
			if(provinceList != null && !provinceList.isEmpty()){
				for(Province province : provinceList){
					selItem = new SelectItem();
					selItem.setLabel(province.getThaiName());
					selItem.setValue(province.getRowId());
					selList.add(selItem);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return selList;
    	
	}
    
    public List<SelectItem> getAmphurListByProvince_SEM(Province province) {
		IAmphurService amphurService = (IAmphurService) getBean("amphurService");
		List<SelectItem> selList = new ArrayList<SelectItem>();
		selList.add(setInitDropDown());
		SelectItem selItem = null;
		try{
			List<Amphur> amphurList = amphurService.getAmphurList_SEM(province);
			if(amphurList != null && !amphurList.isEmpty()){
				for(Amphur amphur : amphurList){
					selItem = new SelectItem();
					selItem.setLabel(amphur.getThaiName());
					selItem.setValue(amphur.getRowId());
					selList.add(selItem);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return selList;
	}
    
    public List<SelectItem> getDistrictListByProvinceAmphur_SEM(Province province, String amphurCode) {
		IAmphurService amphurService = (IAmphurService) getBean("amphurService");
		List<SelectItem> selList = new ArrayList<SelectItem>();
		selList.add(setInitDropDown());
		SelectItem selItem = null;
		try{
			List<Map<String, Object>> districtList = amphurService.getDistrictList_SEM(province, amphurCode);
			if(districtList != null && !districtList.isEmpty()){
				for(Map<String, Object> district : districtList){
					selItem = new SelectItem();
					selItem.setLabel((String) district.get("DISTRICT_NAME"));
					selItem.setValue(district.get("DISTRICT_CODE"));
					selItem.setDescription((String) district.get("POSTCODE"));
					selList.add(selItem);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return selList;
	}
    
    public String getProvinceName_SEM(String provinceCode) {
    	IProvinceService provinceService = (IProvinceService) getBean("provinceService");
		String provinceNameStr = "";
		try{
			List<Province> provinceList = provinceService.getProvinceList_SEM();
			if(provinceList != null && !provinceList.isEmpty()){
				for(Province province : provinceList){
					if(province.getRowId().equals(provinceCode)) {
						provinceNameStr = province.getThaiName();
						break;
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return provinceNameStr;
	}
    
    public String getAmphurName_SEM(String provinceCode, String amphurCode) {
    	Province province = new Province();	
    	IAmphurService amphurService = (IAmphurService) getBean("amphurService");
		String amphurNameStr = "";
		try{
			province.setProvinceCode(provinceCode);
			List<Amphur> amphurList = amphurService.getAmphurList_SEM(province);
			if(amphurList != null && !amphurList.isEmpty()){
				for(Amphur amphur : amphurList){
					if(amphur.getRowId().equals(amphurCode)) {
						amphurNameStr = amphur.getThaiName();
						break;
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return amphurNameStr;
	}
    
    public SelectItem getDistrictName_SEM(String provinceCode, String amphurCode, String districtCode) {
    	Province province = new Province();	
    	IAmphurService amphurService = (IAmphurService) getBean("amphurService");

    	SelectItem retIem = new SelectItem();
    	
		try{
			province.setProvinceCode(provinceCode);
			List<Map<String, Object>> districtList = amphurService.getDistrictList_SEM(province, amphurCode);
			if(districtList != null && !districtList.isEmpty()){
				for(Map<String, Object> district : districtList){
					if(district.get("DISTRICT_CODE").equals(districtCode)) {
						retIem.setLabel((String) district.get("DISTRICT_NAME")); 	//(SelectItem's object "label" have assign by "DISTRICT NAME")
						retIem.setDescription((String) district.get("POSTCODE")); 	//(SelectItem's object "description" have assign by "POSTCODE")
						break;
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return retIem;
	}
    // <-
    
  //added by NEW 2016/07/14 send mail to owner when status reject
    public boolean doSendEmail(EMAILModel email){

    	boolean result = false;
    	List<EMAILModel> emailList = new ArrayList<EMAILModel>();
    	ISiteApproveService service = (ISiteApproveService)getBean("siteApproveService");
    	try{
    		
    		emailList = service.querySPList(EQueryName.SP_MSA001_MAIL.name, email);
			
			if(emailList == null || emailList.size() == 0){
//				addMessageError("E0004");
				result = false;
			}else{
				for(EMAILModel emailM :emailList){
//					emailM.setV_Message(emailM.getV_Message()+" FROM SEMMRT003-1");
//					emailM.setV_Message(emailM.getV_Message());
					//test
//					email.setEmail_to(msg("massage.MAIL_TEST"));
//					email.setEmail_from(msg("MAIL_SEM"));
					System.out.println("email from : "+emailM.getEmail_from());
					System.out.println("email to : "+emailM.getEmail_to());
					result = true;
					EmailMessageUtil.sendEmail(emailM);
//					LOG.debug("result = "+result);
				}
//				addMessageInfo("M0003");
//				result = EmailMessageUtil.sendEmail(email);
			}
//    				
    		
//							
			LOG.debug("result = "+result);
    	}catch (Exception e) {
    		e.printStackTrace();
    		LOG.debug("error from SEMMSA001 Action doSendEmail : "+e);
			// TODO: handle exception
		}finally{
			email = null;
		}
		return result;
    }
}
