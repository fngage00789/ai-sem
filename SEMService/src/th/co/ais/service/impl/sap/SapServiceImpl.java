package th.co.ais.service.impl.sap;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import th.co.ais.dao.impl.gm.TransPaymentHibernateDAO;
import th.co.ais.dao.impl.gm.TransPaymentHistHibernateDAO;
import th.co.ais.dao.impl.sap.SapMappingHibernateDAO;
import th.co.ais.dao.impl.sap.SapTrxDtlHibernateDAO;
import th.co.ais.dao.impl.sap.SapTrxHdrHibernateDAO;
import th.co.ais.dao.impl.sap.SapTrxLogHibernateDAO;
import th.co.ais.domain.ac.Mac001Srch;
import th.co.ais.domain.gm.Employee;
import th.co.ais.domain.gm.TransPayment;
import th.co.ais.domain.gm.TransPaymentHist;
import th.co.ais.domain.sap.SapMapping;
import th.co.ais.domain.sap.SapTrxDtl;
import th.co.ais.domain.sap.SapTrxDtlId;
import th.co.ais.domain.sap.SapTrxHdr;
import th.co.ais.domain.sap.SapTrxHdrId;
import th.co.ais.domain.sap.SapTrxLog;
import th.co.ais.domain.sap.SapTrxLogSrch;
import th.co.ais.service.AbstractService;
import th.co.ais.service.sap.ISAPService;
import th.co.ais.util.SAPUtility;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.util.SFTPUtilities;
import th.co.ais.util.StringHelper;
import th.co.ais.util.WrapperBeanObject;

public class SapServiceImpl extends AbstractService implements ISAPService {

	/** Variable **/
	private static String CURRENT_FILE_ENCODING = StringHelper.ENCODING_TIS620;
	
	/** DAOs **/
	private SapMappingHibernateDAO sapMappingDao;
	public void setSapMappingDao(SapMappingHibernateDAO sapMappingDao) {this.sapMappingDao = sapMappingDao;	}
	
	private SapTrxLogHibernateDAO sapTrxLogDao;	
	public void setSapTrxLogDao(SapTrxLogHibernateDAO sapTrxLogDao) {this.sapTrxLogDao = sapTrxLogDao;	}

	private SapTrxHdrHibernateDAO sapTrxHdrDao;	
	public void setSapTrxHdrDao(SapTrxHdrHibernateDAO sapTrxHdrDao) {this.sapTrxHdrDao = sapTrxHdrDao;	}
	
	private SapTrxDtlHibernateDAO sapTrxDtlDao;
	public void setSapTrxDtlDao(SapTrxDtlHibernateDAO sapTrxDtlDao) {this.sapTrxDtlDao = sapTrxDtlDao;	}
	
	private TransPaymentHibernateDAO transPaymentDao;
	public void setTransPaymentDao(TransPaymentHibernateDAO transPaymentDao) { this.transPaymentDao = transPaymentDao;	}
	
	private TransPaymentHistHibernateDAO transPaymentHistDao;
	public void setTransPaymentHistDao(TransPaymentHistHibernateDAO transPaymentHistDao) { this.transPaymentHistDao = transPaymentHistDao;	}
	/** End DAOs **/
	
	
	/** ####################   Transaction  ######################### */
	@Override
	public void createTransactionToSAP(
			final List<WrapperBeanObject<Mac001Srch>> mac001SrchList, 
			final Employee employee, 
			final String companyCode) throws Exception{
		Date dateNow = new Date();
		String yyyyMMdd = SEMDataUtility.toStringEngDateBySimpleFormat(dateNow, SEMDataUtility.PATTERN_yyyyMMdd);
		String hhmmss = SEMDataUtility.toStringEngDateBySimpleFormat(dateNow, SEMDataUtility.PATTERN_hhmmss);
		SapTrxLog log = new SapTrxLog();
		
		try {
			
			System.out.println("Company >> "+companyCode);
			if(null!=mac001SrchList && mac001SrchList.size()>0){
				
				//Open SFTP : find running number
				SFTPUtilities sftp = new SFTPUtilities(SAPUtility.CONNECT_SFTP);
				
				String nextFileName;
				//อ่านไฟล์จาก SAP Path
				if(SAPUtility.READ_RUNING_FROM_SAP_PATH && sftp.isSessionConnected()){
					/** หาไฟล์ที่เครื่อง MQ (running + 1)  [mqdev:/SEM/Interface_SAP/Outbound/SEMPA_MMT_20101115_ekarutwa_0001.dat] **/
					String regxFile = SAPUtility.getRegxFile(yyyyMMdd);  
					System.out.println("Regular File: "+regxFile);
					nextFileName = SAPUtility.getNextFileName(employee, yyyyMMdd, companyCode, sftp.getNextRunning(regxFile));
				}else{
					/** หาไฟล์ที่เครื่อง  SEM (running + 1) [/jboss/9_SEM_4.2.3/server/default/deploy/SEMFiles/sem_SAP/Interface/Outbound/SEMPA_MMT_20101115_ekarutwa_0001.dat] **/
					nextFileName = SAPUtility.getNextFileName(employee, companyCode, yyyyMMdd);
				}			
				
				/** 1.Insert Log **/		
				log.setLogid(sapTrxLogDao.getNextLogid(null));
				log.setCompany(companyCode);
				log.setFileName(nextFileName);
				log.setCurrentUser(employee.getUserStamp()); //rapeesuw, ekarutwa
				log = sapTrxLogDao.createSapTrxLog(log);
				
				
				/** 2.Insert to [SAP_TRX_LOG], [SAP_TRX_HDR], [SAP_TRX_DTRL] **/
				//for(TransPayment item : tPayments){
				for(WrapperBeanObject<Mac001Srch> wMc001Srch : mac001SrchList){
					
					//รายการที่ถูกเลือก checkbox
					if(wMc001Srch.isCheckBox()){ //if(item.isSelected()){ 
						Mac001Srch mc001Srch = (Mac001Srch)wMc001Srch.getDataObj();
						TransPayment item = transPaymentDao.findById(mc001Srch.getRowId());
						
						//~ 18 Case
						System.out.println(">> TransPaymentId|ExpenseType: "+item.getTransPaymentId()+"|"+item.getExpenseType());
						SapTrxHdr header = getCase(mc001Srch, item, log, employee, yyyyMMdd);
									
						//Insert SAP_TRX_HDR, SAP_TRX_DTL
						if(header!=null){
							//System.out.println(">> Insert H LOGID|HEARUN : "+ header.getId().getLogid()+"|"+header.getId().getHearun());
							header.getId().setHearun(sapTrxHdrDao.getNextHearun(header));
							sapTrxHdrDao.save(header);
							if(header.getSapTrxDtls()!=null && header.getSapTrxDtls().size()>0){
								for(SapTrxDtl detail : header.getSapTrxDtls()){
									detail.getId().setHearun(header.getId().getHearun());
									detail.getId().setLinitm(sapTrxDtlDao.getNextLinitm(detail));
									//System.out.println(">> Insert D LOGID|HEARUN|LINITM : "+ detail.getId().getLogid()+"|"+detail.getId().getHearun()+"|"+detail.getId().getLinitm());
									sapTrxDtlDao.save(detail);							
								}
							}						
						}
						
						//Insert SEM_CT_TRANS_PAYMENT_HIST
						TransPaymentHist tPHis = new TransPaymentHist(null, item);
						tPHis.setCurrentUser(employee.getUserStamp());
						//System.out.println(">> Insert SEM_CT_TRANS_PAYMENT_HIST SEM_CT_TRANS_PAYMENT_HIST|COMPANY : "+ tPHis.getTransPaymentId()+"|"+tPHis.getCompany());
						transPaymentHistDao.save(tPHis);
					}
				}
				
				/** 3. Write *.dat **/
				String sem_file = SAPUtility.SEM_PATH.concat(log.getFileName());
				
				//Replace .dat with .sync
				String sem_file_sync = sem_file.replace(
										".".concat(SAPUtility.SAP_FILE_EXTENSION), 
										".".concat(SAPUtility.SAP_FILE_EXTENSION2)); 
				
				//dbCount=1 เพราะรวมบันทัดสุดท้าย (E) ไปด้วย
				int dbCount = 0, countFileRecord = 0;
				SapTrxHdr filterH = new SapTrxHdr(log.getLogid(), null);
				List<SapTrxHdr> headers = querySapTrxHdr(filterH, true);
				if(headers != null && headers.size()>0){ 				
					System.out.println(sem_file.concat(" is writting..."));
					List<SapMapping> mapHs = sapMappingDao.querySapMapping(SAPUtility.TEMPLATE_HEADER);
					List<SapMapping> mapDs = sapMappingDao.querySapMapping(SAPUtility.TEMPLATE_DETAIL);								
					FileOutputStream fos = new FileOutputStream(sem_file, false);
					Writer out = new OutputStreamWriter(fos, CURRENT_FILE_ENCODING);				
					for(SapTrxHdr header : headers){
						dbCount++;
						SAPUtility.writeHeader(out, header, mapHs);					
						if(header.getSapTrxDtls()!=null && header.getSapTrxDtls().size()>0){
							dbCount += header.getSapTrxDtls().size();
							SAPUtility.writeDetail(out, header.getSapTrxDtls().toArray(), mapDs);							
						}
					}
					out.append("E");
					out.close();
					fos.close();				
				}
							
				/** 4. Write *.sync **/
				System.out.println("Read ".concat(sem_file));
				countFileRecord = SAPUtility.countFileRecords(sem_file, CURRENT_FILE_ENCODING);
				if(dbCount == countFileRecord-1){  //fileCount - บันทัดสุดท้าย(E) ออก			
					SAPUtility.writeSync(sem_file_sync, dbCount, null, employee, yyyyMMdd, hhmmss);
					log.setDbCount(dbCount);
					log.setStatus(SapTrxLog.E_STATUS.SUCCESS.name);
				}else{
					log.setStatus(SapTrxLog.E_STATUS.FAIL.name);
					this.setLogError(log, "Count not match");
					System.out.println("Count db & file not match");				
				}
				
				/** 5. Move *.dat ( + *.sync) to MQ [UAT:10.216.141.186, PROD:10.216.141.185] **/
				if(sftp.isSessionConnected()){
					sftp.put(sem_file, SAPUtility.SAP_PATH);
					sftp.put(sem_file_sync, SAPUtility.SAP_PATH);
					sftp.disconnect();
				}			
			}
		} catch (Exception e) {
			e.printStackTrace();			
			log.setStatus(SapTrxLog.E_STATUS.ERROR.name);
			this.setLogError(log, e.getMessage());			
		}					
		
		/** 6. Update [SAP_TRX_LOG]: STATUS, ERROR, DB_COUNT **/
		sapTrxLogDao.saveOrUpdate(log);
		
	}
	
	@Override
	public void regenerateTransactionToSAP(final List<WrapperBeanObject<SapTrxLog>> logSrchList, final Employee employee) throws Exception{
		Date dateNow = new Date();
		String yyyyMMdd = SEMDataUtility.toStringEngDateBySimpleFormat(dateNow, SEMDataUtility.PATTERN_yyyyMMdd);
		String hhmmss = SEMDataUtility.toStringEngDateBySimpleFormat(dateNow, SEMDataUtility.PATTERN_hhmmss);
		//SapTrxLog log = new SapTrxLog();
		
		for(WrapperBeanObject<SapTrxLog> wrapLog : logSrchList){
			if(wrapLog.isCheckBox()){			
					SapTrxLog log = (SapTrxLog)wrapLog.getDataObj();
			
				try{								
					
					String currentFileName = SAPUtility.SEM_PATH.concat(log.getFileName());		
					
					//1.Insert Log	
					/*log.setLogid(sapTrxLogDao.getNextLogid(null));
					log.setCompany(employee.getCompanyCode());
					log.setFileName(currentFileName);
					log.setCurrentUser(employee.getUserStamp()); //rapeesuw, ekarutwa
					log = sapTrxLogDao.createSapTrxLog(log);*/
															
					//2.Insert to [SAP_TRX_LOG], [SAP_TRX_HDR], [SAP_TRX_DTRL]
					List<SapTrxHdr> hdList = querySapTrxHdr(new SapTrxHdr(log.getLogid(), null), false);
					TransPayment param = new TransPayment();					
					List<TransPayment> tPayments = transPaymentDao.queryTransPayment(param);
					for(TransPayment item : tPayments){
						//TransPayment item = transPaymentDao.findById(mc001Srch.getRowId());
						
						//~ 18 Case
						System.out.println(">> TransPaymentId|ExpenseType: "+item.getTransPaymentId()+"|"+item.getExpenseType());
						SapTrxHdr header = getCase(null, item, log, employee, yyyyMMdd);
									
						//Insert SAP_TRX_HDR, SAP_TRX_DTL
						if(header!=null){
							//System.out.println(">> Insert H LOGID|HEARUN : "+ header.getId().getLogid()+"|"+header.getId().getHearun());
							header.getId().setHearun(sapTrxHdrDao.getNextHearun(header));
							sapTrxHdrDao.save(header);
							if(header.getSapTrxDtls()!=null && header.getSapTrxDtls().size()>0){
								for(SapTrxDtl detail : header.getSapTrxDtls()){
									detail.getId().setHearun(header.getId().getHearun());
									detail.getId().setLinitm(sapTrxDtlDao.getNextLinitm(detail));
									//System.out.println(">> Insert D LOGID|HEARUN|LINITM : "+ detail.getId().getLogid()+"|"+detail.getId().getHearun()+"|"+detail.getId().getLinitm());
									sapTrxDtlDao.save(detail);							
								}
							}						
						}
						
						//Insert SEM_CT_TRANS_PAYMENT_HIST
						TransPaymentHist tPHis = new TransPaymentHist(null, item);
						tPHis.setCurrentUser(employee.getUserStamp());
						//System.out.println(">> Insert SEM_CT_TRANS_PAYMENT_HIST SEM_CT_TRANS_PAYMENT_HIST|COMPANY : "+ tPHis.getTransPaymentId()+"|"+tPHis.getCompany());
						transPaymentHistDao.save(tPHis);
					}
					
					//3. Write *.dat
					String sem_file = SAPUtility.SEM_PATH.concat(log.getFileName());
					
					//Replace .dat with .sync
					String sem_file_sync = sem_file.replace(
											".".concat(SAPUtility.SAP_FILE_EXTENSION), 
											".".concat(SAPUtility.SAP_FILE_EXTENSION2)); 
					
					//dbCount=1 เพราะรวมบันทัดสุดท้าย (E) ไปด้วย
					int dbCount = 0, countFileRecord = 0;
					SapTrxHdr filterH = new SapTrxHdr(log.getLogid(), null);
					List<SapTrxHdr> headers = querySapTrxHdr(filterH, true);
					if(headers != null && headers.size()>0){ 				
						System.out.println(sem_file.concat(" is writting..."));
						List<SapMapping> mapHs = sapMappingDao.querySapMapping(SAPUtility.TEMPLATE_HEADER);
						List<SapMapping> mapDs = sapMappingDao.querySapMapping(SAPUtility.TEMPLATE_DETAIL);								
						FileOutputStream fos = new FileOutputStream(sem_file, false);
						Writer out = new OutputStreamWriter(fos, CURRENT_FILE_ENCODING);				
						for(SapTrxHdr header : headers){
							dbCount++;
							SAPUtility.writeHeader(out, header, mapHs);					
							if(header.getSapTrxDtls()!=null && header.getSapTrxDtls().size()>0){
								dbCount += header.getSapTrxDtls().size();
								SAPUtility.writeDetail(out, header.getSapTrxDtls().toArray(), mapDs);							
							}
						}
						out.append("E");
						out.close();
						fos.close();				
					}
								
					//4. Write *.sync
					System.out.println("Read ".concat(sem_file));
					countFileRecord = SAPUtility.countFileRecords(sem_file, CURRENT_FILE_ENCODING);
					if(dbCount == countFileRecord-1){  //fileCount - บันทัดสุดท้าย(E) ออก			
						SAPUtility.writeSync(sem_file_sync, dbCount, null, employee, yyyyMMdd, hhmmss);
						log.setDbCount(dbCount);
						log.setStatus(SapTrxLog.E_STATUS.SUCCESS.name);
					}else{
						log.setStatus(SapTrxLog.E_STATUS.FAIL.name);
						this.setLogError(log, "Count not match");
						System.out.println("Count db & file not match");				
					}
					
					//5. Move *.dat ( + *.sync) to MQ [UAT:10.216.141.186, PROD:10.216.141.185]
					SFTPUtilities sftp = new SFTPUtilities(SAPUtility.CONNECT_SFTP);
					if(sftp.isSessionConnected()){
						sftp.put(sem_file, SAPUtility.SAP_PATH);
						sftp.put(sem_file_sync, SAPUtility.SAP_PATH);
						sftp.disconnect();
					}
				} catch (Exception e) {
					e.printStackTrace();			
					log.setStatus(SapTrxLog.E_STATUS.ERROR.name);
					this.setLogError(log, e.getMessage());			
				}
				
				//6. Update [SAP_TRX_LOG]: STATUS, ERROR, DB_COUNT
				sapTrxLogDao.saveOrUpdate(log);
			
			}//end if(wrapLog.isCheckBox()){
			
		}//end for(WrapperBeanObject<SapTrxLog> wrapLog : logSrchList){
	}
	
	private void setLogError(SapTrxLog log, String error) throws UnsupportedEncodingException{
		String cur = log.getError(); 
		StringBuilder value = new StringBuilder();		
		if(cur != null){
			value.append(cur.trim()+"\n"+error.trim());
		}else{
			value.append(error.trim());
		}
		log.setError(StringHelper.convertMS874ToTIS620(value.toString()));
	}
	
	private SapTrxHdr getCase(Mac001Srch mc001Srch, TransPayment tP, SapTrxLog log, Employee employee, String yyyyMMdd) throws Exception{
		
		//***********************************  Header **********************************************
		SapTrxHdr header = new SapTrxHdr();
		
		//Mandatory
		header.setId(new SapTrxHdrId(log.getLogid(), null));
		header.setRefsem(tP.getTransPaymentId());	//เปลี่ยนขนาดเป็น 15 SEMIRXXYYRRRRRRR
		header.setComcod(tP.getCompany());			//SAP Company code เช่น AIS,AWN,… 
		header.setDoctyp(tP.getDocType());			//SAP Document Type เช่น IR,IS,IA,…
		header.setRefdoc(tP.getDocNo());			//ระบุ Tax Invoice no. หรือเลขที่เอกสารที่ออกให้กับลูกค้า หรือ รับจาก Vendor
		//header.setDochea(tP.getDocNo()); 			//ถ้ามีรายการ VAT - Input tax  ต้องเป็นค่าว่าง
		header.setDocdat(yyyyMMdd);					//วันที่ตามเอกสารที่ออกให้กับลูกค้า หรือ รับจาก Vendor
		header.setPosdat(yyyyMMdd);					//วันที่บันทึกรายการสำหรับระบบบัญชี
		header.setBracod("A000");					//SAP Branch code  เช่น A000
		header.setCurcod("THB");					//รหัสสกุลเงิน เช่น THB,USD,…
		header.setExttxt23("");					//Extra Text 2
		
		//No Mandatory
		//header.setExcrat();						//อัตราแลกเปลี่ยนกรณีบันทึก Currency ต่างประเทศ
		//header.setTradat();						//
		//header.setTextid1();						//Extra Text 1
		//header.setExttxt11();						//Extra Text 1
		//header.setExttxt12();						//Extra Text 1
		//header.setExttxt13();						//Extra Text 1
		//header.setExttxt14();						//Extra Text 1
		//header.setTextid2();						//Extra Text 2
		//header.setExttxt21();						//Extra Text 2
		//header.setExttxt22();						//Extra Text 2
		//header.setExttxt23();						//Extra Text 2	: set แล้ว
		//header.setExttxt24();						//Extra Text 2
		//header.setTextid3();						//Extra Text 3
		//header.setExttxt31();						//Extra Text 3
		//header.setExttxt32();						//Extra Text 3
		//header.setExttxt33();						//Extra Text 3
		//header.setExttxt34();						//Extra Text 3		
		
		
		//***********************************  Detail **********************************************
		int expenseType = Integer.valueOf(tP.getExpenseType());
		List<SapTrxDtl> details = null;
		switch(expenseType){
			case 1: //break;
			case 2: //break;
			case 3: //break;
				details = getCase01(mc001Srch, tP, log, header, employee, yyyyMMdd);
				break;
			case 4: //break;
			case 5: //break;
			case 6: //break;
			case 7: //break;
			case 8: //break;
			case 9: //break;
			case 10: //break;
			case 11: //break;
			case 12: //break;
			case 13: //break;
			case 14: //break;
			case 15: //break;
			case 16: //break;
			case 17: //break;
			case 18: //break;
			default :
				details = getCase04(mc001Srch, tP, log, header, employee, yyyyMMdd);
				break;
		}
		
		if(details!=null){
			header.setSapTrxDtls(details);
		}
		return header;
	}
	
	/** Case 1 : 2 lines **/
	private List<SapTrxDtl> getCase01(Mac001Srch mc001Srch, TransPayment tP, SapTrxLog log, SapTrxHdr header,
									Employee employee, String yyyyMMdd) throws Exception{		
		List<SapTrxDtl> sapTrxDtlList = new ArrayList<SapTrxDtl>();			
		sapTrxDtlList.add(createSapTrxDtl(mc001Srch,tP,log,header,employee,yyyyMMdd,"D","G","3300001"));		
		sapTrxDtlList.add(createSapTrxDtl(mc001Srch, tP, log, header, employee, yyyyMMdd, "C", "V", "1111001116"));		
		return sapTrxDtlList;
	}
	
	/** Case 4: 3 line **/
	private List<SapTrxDtl> getCase04(Mac001Srch mc001Srch, TransPayment tP, SapTrxLog log, SapTrxHdr header, Employee employee, String yyyyMMdd) throws Exception{		
		SapTrxHdrId hdId = header.getId();		
		List<SapTrxDtl> sapTrxDtlList = new ArrayList<SapTrxDtl>();
		sapTrxDtlList.add(new SapTrxDtl(hdId.getLogid(), hdId.getHearun(), tP.getTransPaymentId(),
					null,"D","G","3300001",10000.00, 10000.00, employee.getCostCenter(),header.getDocdat()));
		sapTrxDtlList.add(new SapTrxDtl(header.getId().getLogid(), header.getId().getHearun(), tP.getTransPaymentId(),
					null,"D","T","180302",   700.00,   700.00, employee.getCostCenter(),header.getDocdat()));
		sapTrxDtlList.add(new SapTrxDtl(hdId.getLogid(), hdId.getHearun(), tP.getTransPaymentId(),
					null,"C","V","1111005577",10700.00,10700.00, employee.getCostCenter(),header.getDocdat()));
		
		//sapTrxDtlList.add(createSapTrxDtl(mc001Srch,tP,log,header,employee,yyyyMMdd,"D","G","3300001"));		
		//sapTrxDtlList.add(createSapTrxDtl(mc001Srch,tP,log,header,employee,yyyyMMdd,"D","T","180302"));	
		//sapTrxDtlList.add(createSapTrxDtl(mc001Srch,tP,log,header,employee,yyyyMMdd,"C","V","1111005577"));
		return sapTrxDtlList;
	}
	
	/**
	 * @param mc001Srch
	 * @param tP
	 * @param log
	 * @param header
	 * @param employee
	 * @param yyyyMMdd
	 * @param amttyp
	 * @param acctyp
	 * @param accnum
	 * @return
	 */
	private SapTrxDtl createSapTrxDtl(
			Mac001Srch mc001Srch, 
			TransPayment tP, 
			SapTrxLog log, 
			SapTrxHdr header,
			Employee employee, 
			String yyyyMMdd,
			String amttyp,
			String acctyp,
			String accnum
			){
		
		SapTrxDtl detail = new SapTrxDtl();
		SapTrxHdrId hdId = header.getId();
		
		//*************************************  Mandatory  **************************************
		detail.setId(new SapTrxDtlId(hdId.getLogid(), hdId.getHearun(), null));
		detail.setRefsem(tP.getTransPaymentId());
		detail.setAmttyp(amttyp);						//"D"=Debit(ยอดเงินที่บันทึกบัญชีด้านบวก), "C"=Credit(ยอดเงินที่บันทึกบัญชีด้านลบ)

		/* การส่งค่าเป็นดังนี้
			ถ้า Customer code ให้ส่ง   Account Type = C
			ถ้า Vendor code 	ให้ส่ง  Account Type = V
			ถ้า GL Account 	ให้ส่ง  Account Type  = G
			ถ้า GL Account ที่เป็น VAT ให้ส่ง  Account Type = T */
		detail.setAcctyp(acctyp);
		
		/*การส่งค่ามีความสัมพันธ์กับค่า field Account Type
			ถ้า Account Type = D,Account no. = SAP Customer Code
			ถ้า Account Type = V,Account no. = SAP Vendor Code
			ถ้า Account Type = G,Account no. = SAP G/L Account Code
			ถ้า Account Type = T,Account no. = SAP G/L  VAT Account Code */
		detail.setAccnum(accnum);
		detail.setAmtloc(tP.getPeriodAmt());			//มีขนาด13 หลักรวมจุดทศนิยม เช่น 13000.25 ไม่ต้องมีค่า + หรือ -
		detail.setAmtdoc(tP.getPeriodAmt());			//มีขนาด13 หลักรวมจุดทศนิยม เช่น 13000.25 ไม่ต้องมีค่า + หรือ -
		detail.setCoscen(employee.getCostCenter());		//สำหรับ G/L Account รายได้หรือค่าใช้จ่าย จะต้องส่งค่ามาทุกกรณี ส่วน WBS element หรือ Internal order ขึ้นอยู่กับว่า User จะให้ตัดที่ Budget ประเภทใด ซึ่งจะมีหรือไม่มีก็ได้  
		
		/* Baseline Date สำหรับรายการ Invoice (Customer & Vendor) 
		   Due date สำหรับรายการ SP G/L Indicater (Customer & Vendor)
		   Value Date สำหรับรายการบัญชี Bank
		        เพิ่มเติมสำหรับรายการอื่นๆ ไม่ต้องส่งเพราะไม่ได้ใช้  */
		detail.setBasdat(header.getDocdat());
		
		//*************************************  No Mandatory  **************************************
		//detail.setSpegli();							//ถ้าเป็น Customer เช่น "2": Short term Loan, ถ้าเป็น Vendor เช่น "J": AP Deposit
		detail.setWbsele(tP.getWbsNo());				//เพิ่มเติม WBS element หรือ Internal order ขึ้นอยู่กับว่า User จะให้ตัดที่ Budget ประเภทใด ซึ่งจะมีหรือไม่มีก็ได้
		//detail.setIntord();							//เพิ่มเติม WBS element หรือ Internal order ขึ้นอยู่กับว่า User จะให้ตัดที่ Budget ประเภทใด ซึ่งจะมีหรือไม่มีก็ได้
		//detail.setPurdoc();
		//detail.setPurite();							//เพิ่มเติมเป็นข้อมูลสำหรับรายการตั้งหนี้ AP ซึ่งมีถ้ามีการอ้างอิง purchasing doc.ของ filed 14 และ field 15 คือ line item ใน purchasing doc. ซึ่งจะต้องมาคู่กัน
		detail.setTaxcod(String.format("%02d", tP.getPayVatRate()));	//SAP Tax code เช่น O7 : Sales Tax Rate 7%
		detail.setBasloc(tP.getPayExcAmt());			//สำหรับรายการที่เป็น VAT (Account = T)
		detail.setBasdoc(tP.getPayExcAmt());			//สำหรับรายการที่เป็น VAT (Account = T)
		
		//REFERENCE_DOC_NO : INVREF,YERINV,ITMINV 	ex. >> INV-2010-14001
		//detail.setInvref();							//สำหรับ CN หรือ DN ที่ต้องการอ้างถึง SAP invoice document
		//detail.setYerinv();							//สำหรับ CN หรือ DN เพื่ออ้างถึงปีของเอกสาร Invoice document
		//detail.setItminv();							//สำหรับ CN หรือ DN เพื่ออ้างถึง line item ของเอกสาร Invoice document
		
		//detail.setPayterm();							//เงื่อนไขในการชำระเงิน เช่น Z000 (จ่ายทันที), Z082 (1/2, 0.6/4, (30), BKK)
		//detail.setDscday1();						
		//detail.setDscper1();
		//detail.setDscday2();						
		//detail.setDscper2();
		//detail.setNetpay();
		//detail.setPayblk();
		detail.setPaymet(tP.getPaymentMethod());		//ประเภทการรับ / จ่ายชำระเงิน  
		//detail.setPaysup();
		//detail.setAssign();
		//detail.setLinitmtxt();						//คำอธิบายรายการ
		//detail.setLontxt();							//คำอธิบายรายการ (เพิ่มเติม)
		//detail.setWthcod1();							//SAP Withholding tax code เช่น 19 :รางวัลในการประกวดแข่งขัน5% บุคคลธรรมดา
		//detail.setWthbasl1();							//มีขนาด13 หลักรวมจุดทศนิยม เช่น 13000.25 ไม่ต้องมีค่า + หรือ -
		//detail.setWthbasd1();							//มีขนาด13 หลักรวมจุดทศนิยม เช่น 13000.25 ไม่ต้องมีค่า + หรือ -
		//detail.setWthamtl1();							//มีขนาด13 หลักรวมจุดทศนิยม เช่น 13000.25 ไม่ต้องมีค่า + หรือ -
		//detail.setWthamtd1();							//มีขนาด13 หลักรวมจุดทศนิยม เช่น 13000.25 ไม่ต้องมีค่า + หรือ -
		//detail.setWthcod2();							//SAP Withholding tax code เช่น 19 :รางวัลในการประกวดแข่งขัน5% บุคคลธรรมดา
		//detail.setWthbasl2();							//มีขนาด13 หลักรวมจุดทศนิยม เช่น 13000.25 ไม่ต้องมีค่า + หรือ -
		//detail.setWthbasd2();							//มีขนาด13 หลักรวมจุดทศนิยม เช่น 13000.25 ไม่ต้องมีค่า + หรือ -
		//detail.setWthamtl2();							//มีขนาด13 หลักรวมจุดทศนิยม เช่น 13000.25 ไม่ต้องมีค่า + หรือ -
		//detail.setWthamtd2();							//มีขนาด13 หลักรวมจุดทศนิยม เช่น 13000.25 ไม่ต้องมีค่า + หรือ -
		//detail.setWthcod3();							//SAP Withholding tax code เช่น 19 :รางวัลในการประกวดแข่งขัน5% บุคคลธรรมดา
		//detail.setWthbasl3();							//มีขนาด13 หลักรวมจุดทศนิยม เช่น 13000.25 ไม่ต้องมีค่า + หรือ -
		//detail.setWthbasd3();							//มีขนาด13 หลักรวมจุดทศนิยม เช่น 13000.25 ไม่ต้องมีค่า + หรือ -
		//detail.setWthamtl3();							//มีขนาด13 หลักรวมจุดทศนิยม เช่น 13000.25 ไม่ต้องมีค่า + หรือ -
		//detail.setWthamtd3();							//มีขนาด13 หลักรวมจุดทศนิยม เช่น 13000.25 ไม่ต้องมีค่า + หรือ -
		//detail.setRefkey1();							//
		//detail.setRefkey2();							//
		//detail.setRefkey3();							//
		//detail.setParbnk();							//สำหรับรายการโอนที่มีเลขบัญชีมากกว่า 1 บัญชี ตรงตามที่ระบุใน Vendor master 
		//detail.setTraprt();							//ใช้สำหรับรายการ GL ที่ไม่มีการบันทึก Vendor หรือ Customer ในเอกสารนั้น โดยต้องระบุมาเป็น Code ของบริษัทที่เป็นรายการระหว่างกัน เช่น  เมื่อบริษัท AIS มีการบันทึกค่าใช้จ่ายที่ต้องจ่ายให้กับบริษัท DPC ก็จะต้องระบุมาเป็น Trading parter "DPC"
		//detail.setAssspgl();							//เป็นการอธิบายเพิ่มเติมสำหรับรายการ S/P GL Field ที่ 18 (SPEGLI) - ซึ่งปัจจุบันยังไม่มีการใช้งาน

		//--- Vendor Onetime or Customer Onetime or Alternative ---
		//PAYEE_NAME(255) : ONENAM1(35),ONENAM2(35),ONENAM3(35),ONENAM4(35)
		//detail.setOnenam1();						//ชื่อ
		//detail.setOnenam2();						//ชื่อ กรณี name1 ความยาวไม่พอ
		//detail.setOnenam3();						//ชื่อ กรณี name2 ความยาวไม่พอ
		//detail.setOnenam4();						//ชื่อ กรณี name3 ความยาวไม่พอ
		
		//PAYEE_xxx : STREET,CITY01,POSCOD,PERID,TAXID,BNKKEY (Bank code(3) + Branch code(4)),BNKNAM1,BNKACC
		//detail.setStreet();						//ที่อยู่ 
		//detail.setCity01();						//ที่อยู่ กรณี Street  ความยาวไม่พอ
		//detail.setPoscod();						//รหัสไปรษณีย์
		//detail.setPerid();						//เลขที่บัตรประชาชน
		//detail.setTaxid();						//เลขประจำตัวผู้เสียภาษี
		//detail.setBnkkey();						//Bank code(3) + Branch code(4)
		//detail.setBnknam1();						//ชื่อธนาคาร - ชื่อสาขา
		//detail.setBnkacc();						//		
				
		return detail;
	}
	/** ####################   End Transaction  ######################### */


	
	
	/** Log **/
	@Override
	public List<SapTrxLog> querySapTrxLog(SapTrxLogSrch filter) throws Exception {
		List<SapTrxLog> sapTrxLogList = sapTrxLogDao.querySapTrxLog(filter);
		if(filter!=null){
			if(filter.isLoadChild()){
				for(SapTrxLog log : sapTrxLogList){
					SapTrxHdr param = new SapTrxHdr(log.getLogid(),null);					
					List<SapTrxHdr> hdrList = querySapTrxHdr(param, filter.isLoadChild());
					log.setSapTrxHdrs(hdrList);
				}
			}
		}		
		return sapTrxLogList;
	}
	
	
	/** SAP Header **/
	@Override
	public List<SapTrxHdr> querySapTrxHdr(SapTrxHdr filter, boolean loadChild) throws Exception {
		List<SapTrxHdr> retValue = sapTrxHdrDao.querySapTrxHdr(filter);
		if(retValue!=null && loadChild){
			for(SapTrxHdr header : retValue){
				SapTrxDtl prm = new SapTrxDtl(header.getId().getLogid(), header.getId().getHearun(), null);
				List<SapTrxDtl> sapTrxDtls = sapTrxDtlDao.querySapTrxDtl(prm);
				header.setSapTrxDtls(sapTrxDtls);
			}
		}
		return retValue;
	}	
	
	/** SAP Detail **/
	@Override
	public List<SapTrxDtl> querySapTrxDtl(SapTrxDtl filter) throws Exception {
		return sapTrxDtlDao.querySapTrxDtl(filter);
	}
}