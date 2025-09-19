package com.junit;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Format;
import jxl.format.Pattern;
import jxl.read.biff.BiffException;
import jxl.write.DateTime;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ais.migrate.sem.hibernate.annotion.MigrateSapct;
import com.ais.migrate.sem.hibernate.annotion.MpContractClean;
import com.ais.migrate.sem.model.DatFile;
import com.ais.migrate.sem.model.ParamsProcedure;
import com.ais.migrate.sem.model.SPProcedure;
import com.ais.migrate.sem.model.SyncFile;
import com.ais.migrate.sem.model.SPProcedure.EProcedureName;
import com.ais.migrate.sem.spring.service.MigrateSapService;
import com.ais.migrate.sem.utilities.MigrateSAPUtility;
import com.ais.migrate.sem.utilities.FileUtility;
import com.ais.migrate.spring.controller.readExcel;

public class JUnitMigrateSAP {
	
	private MigrateSapService migrateSapService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testExecute() {
	
		//testUnzip();
		
		
		try {
			//importSAPCT();
			importSAPMO();
			
			//testInvoke();			
			//testHibernateCallProcedure();
			
			//Object obj = ConvertUtils.convert("20050531", DateTime.class);
			//System.out.println(((DateTime)obj).toString());			
			//readExcel();			
			
			/*migrateSapService = (MigrateSapService)getBean("migrateSapService");
			SPProcedure proc = migrateSapService.execProcedure("MIGRATE_RT_RENTAL_MASTER");
			if(!proc.isSuccess()){
				System.out.println(proc.getResultMsg());
			}else{
				System.out.println(proc.getResultMsg());
				System.out.println(proc.getRowEffect().toString().concat(" record(s) inserted."));
				System.out.println(proc.getUseTime());
			}*/
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private String[] columns = {
			"NO","CONTRACT_ID","SITE_NAME","START_DATE","END_DATE",
			"VENDOR_ID","MASTER_VENDOR","AMOUNT","REMARK","BG_BANK","BG_NO"};
	public void readExcel() throws IOException  {
		String path = "C:\\Documents and Settings\\vorapt49\\Desktop\\";
		String file = "BG_AIS_3.xls";
		File inputWorkbook = new File(path+file);
		Workbook w;
		try {
			w = Workbook.getWorkbook(inputWorkbook);
			// Get the first sheet
			Sheet sheet = w.getSheet(0);
			
			int rowBegin = 10;//1;
			int rowEnd = 12;//sheet.getRows();
			int colBegin = 3, colEnd=7;//columns.length;//sheet.getColumns()
			
			// Loop over first 10 column and lines
			for (int row = rowBegin; row < rowEnd; row++) {
				for (int col = colBegin; col < colEnd; col++) {				
					Cell cell = sheet.getCell(col, row);
					CellType type = cell.getType();
					String content = cell.getContents();
					Format format = cell.getCellFormat().getFormat();					
					/*if (cell.getType() == CellType.LABEL) {
						System.out.println("I got a label "+content);
					}

					if (cell.getType() == CellType.NUMBER) {
						System.out.println("I got a number "+content);
					}*/

					content = replaceAll(content);
					System.out.println(
							columns[col]+": "+ content +
							", type:" + type.toString() +
							", format:"+format.getFormatString());
				}
			}
		} catch (BiffException e) {
			e.printStackTrace();
		}
	}
	
	private String replaceAll(String content){
		content = content.replaceAll("\t", "");
		return content;
	}
	
	private String token = MigrateSAPUtility.getMessage("read_file_token");
	private void testInvoke() throws Exception{
		/*String READ_FILE_TOKEN = "\\|";
		String[] cs = {
			"TRN|AIS|ประชาอุทิศ 1|BKK 002|0000|RO|BKK 002|11|GSM|BKK|MACRO|20010206|20040205|1111006713|0000053160|กรุงเทพมหานคร||12|12|0.00|0.00|1080000.00|30000.00|0.00|0.00|0.00||00000000|09|0000000030000|00|0000000000000|20030201|360000.00|0.00|18000.00|0.00|720000.00|720000.00|360000.00|690000.00|360000.00|13|02|10",
			"PRO|AIS|ประชาอุทิศ|BKK 002|0002|RO|101114||GSM|BKK|MACRO|20040206|20070205|1111006713|0000053160|กรุงเทพมหานคร||12|12|0.00|0.00|1188000.00|33000.00|0.00|0.00|0.00||00000000|09|0000000033000|00|0000000000000|20040206|396000.00|0.00|19800.00|0.00|1188000.00|1188000.00|0.00|1089000.00|0.00|36|03|00",
			"PRO|AIS|เทียมร่วมมิตร|BKK 002|0004|RO|101114||GSM|BKK|MACRO|20070206|20100205|1111006713|0000053160|กรุงเทพมหานคร||12|12|0.00|0.00|1306800.00|36300.00|0.00|0.00|0.00||00000000|09|0000000036300|00|0000000000000|20070206|435600.00|0.00|21780.00|0.00|1306800.00|1306800.00|0.00|1197900.00|0.00|36|03|00",
			"PRO|AIS|เทียมร่วมมิตร|BKK 002|0005|RO|101114||GSM|BKK|MACRO|20100206|20130205|1111040254|0000053160|กรุงเทพมหานคร||12|12|0.00|0.00|1372140.00|38115.00|0.00|0.00|0.00||00000000|09|0000000038115|00|0000000000000|20100206|457380.00|0.00|22869.00|0.00|914760.00|914760.00|457380.00|838530.00|419265.00|13|02|10"
		};		
		
		System.out.println("Use StringTokenizer");
		for(String c : cs){
			//StringTokenizer st = new StringTokenizer(c,READ_FILE_TOKEN);			
			//System.out.println("countTokens: "+st.countTokens());
			//System.out.println(c.split(READ_FILE_TOKEN).length);
			
			String[] values = c.split("\\".concat(token), 45);
			//for(int c=0; c<)
			System.out.println("sub/33/34/35 : "+values[4]+"/"+values[33]+"/"+values[34]+"/"+values[35]);
		}*/		
		
		
		/*while (st.hasMoreTokens()) {
			//System.out.println("nextToken : "+st.nextToken());
			System.out.println("nextElement: "+st.nextElement());
		}
		
		String[] results = c.split(READ_FILE_TOKEN);
		System.out.println("Use String.split('|') : "+results.length);		
		for(int i=0; i<results.length; i++){
			System.out.println(" - "+results[i]);
		}*/
		
		try {
			/*String clazzName = "com.ais.migrate.sem.hibernate.annotion.MigrateSapctAis";
			Class clazz = Class.forName(clazzName);
			Object obj = clazz.newInstance();
			//Method method = clazz.getDeclaredMethod("setRectyp", null);
			//method.invoke(obj, "TRN");
			Method method = clazz.getMethod("setRectyp", Class.forName("java.lang.String"));
			method.invoke(obj, "TRN");
			
			MigrateSapctAis miSapctAis = (MigrateSapctAis)obj;
			System.out.println("Rectyp: "+miSapctAis.getRectyp());*/
			
			
			/*String fDbName = "Basamt";
			String declaredF = fDbName.substring(0, 1).toLowerCase().concat(fDbName.substring(1,fDbName.length()));
			String val = "0.00";
			
			MigrateSapct miSapctAis = new MigrateSapct();
			Object model = miSapctAis;
			
			Class clazz = model.getClass();
			Field field = clazz.getDeclaredField(declaredF);
			Method method = clazz.getMethod("set".concat(fDbName), field.getType());
			method.invoke(model, ConvertUtils.convert(val, field.getType()));			
			
			System.out.println("Basamt: "+miSapctAis.getBasamt());*/
			
			
			
			/*for(Field field : clazz.getDeclaredFields()){
				System.out.println(field.getName()+"/"+field.getType());
			}
			
			for(Method m : clazz.getMethods()){
				System.out.println(m.getName());
			}*/
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void testUnzip(){
		//String zipPath = MigrateSAPUtility.getMessage("upload_path");
		String zipPath = "C:/Documents and Settings/vorapt49/Desktop/Projects/SEM/MigrateSAP/Files/";
		//FileUtility.upzip(zipPath, "SAPCT.zip", "");		
	}
	
	private void testHibernateCallProcedure() throws Exception{
		
		/*migrateSapService = (MigrateSapService)getBean("migrateSapService");
		ParamsProcedure param = new ParamsProcedure(1,1,5,null,null,null);
		List<MpContractClean> data = (List<MpContractClean>)migrateSapService.querySingleBySP("SP_GET_CONTRACT_CLEAN", param);
		if(data!=null){
			for(MpContractClean cc : data){
				System.out.println("CONTRACT_ID/SUBCON/END_DATE_M >> "+
						cc.getContractId()+"/"+cc.getSubcon()+"/"+cc.getEndDateM()+"/"+cc.getLocationNameM());
			}
		}*/
	}
	private Object getBean(String beanName){
		ApplicationContext appcontext = new ClassPathXmlApplicationContext(new String[] {
				"applicationContext.xml",
				"applicationContext-dao.xml",
			    "applicationContext-service.xml",			    
			    "applicationContext-transaction-sem.xml"
		});	
		
		return appcontext.getBean(beanName);
	}
	
	
	
	
	private void importSAPCT() throws Exception{
		String[] dats = {
				"SAPCT_AIS_20110324150019",
				"SAPCT_AIS_20110324150133",
				"SAPCT_AIS_20110324173202",
				"SAPCT_AIS_20110324194420",
				"SAPCT_AIS_20110324214447",
				"SAPCT_AIS_20110325005223",
				"SAPCT_AIS_20110325040115"
			};
		String templateId="MP_SAP_CONTRACT";
		String path = "C:/Documents and Settings/vorapt49/Desktop/25032554/"; 
		migrateSapService = (MigrateSapService)getBean("migrateSapService");
		for(String datName : dats){
			List<DatFile> datFiles = FileUtility.getDatFiles(
										path,
										datName,true);			
			migrateSapService.transfer(datFiles, templateId);
		}
	}
	
	private void importSAPMO() throws Exception{
		String[] dats = {
				"SAPMO_AIS_20110324150019",
				"SAPMO_AIS_20110324150133",
				"SAPMO_AIS_20110324173202",
				"SAPMO_AIS_20110324194420",
				"SAPMO_AIS_20110324214447",
				"SAPMO_AIS_20110325005223",
				"SAPMO_AIS_20110325040115"
			};
		String templateId="MP_SAP_MOVEMENT";
		String path = "C:/Documents and Settings/vorapt49/Desktop/25032554/";
		migrateSapService = (MigrateSapService)getBean("migrateSapService");
		for(String datName : dats){
			List<DatFile> datFiles = FileUtility.getDatFiles(
										path,
										datName,true);			
			migrateSapService.transfer(datFiles, templateId);
		}
	}
}
