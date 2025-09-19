package th.co.ais.service.impl.el;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

import th.co.ais.dao.impl.el.VendorMapPayeeELHibernateDAO;
import th.co.ais.domain.el.VendorMapPayeeEL;
import th.co.ais.domain.gm.PayeeBookbank;
import th.co.ais.domain.gm.PayeeMaster;
import th.co.ais.domain.gm.VendorBookbank;
import th.co.ais.domain.gm.VendorMaster;
import th.co.ais.service.AbstractService;
import th.co.ais.service.el.IVendorMapPayeeELService;
import th.co.ais.service.gm.IVendorMapPayeeService;
import th.co.ais.util.BeanUtils;

public class VendorMapPayeeELServiceImpl extends AbstractService implements IVendorMapPayeeELService{
	
	Logger logger =  Logger.getLogger(VendorMapPayeeELServiceImpl.class);

	VendorMapPayeeELHibernateDAO vendorMapPayeeELDao;
	IVendorMapPayeeService vendorMapPayeeService;
	
	public IVendorMapPayeeService getVendorMapPayeeService() {
		return vendorMapPayeeService;
	}

	public void setVendorMapPayeeService(
			IVendorMapPayeeService vendorMapPayeeService) {
		this.vendorMapPayeeService = vendorMapPayeeService;
	}

	public VendorMapPayeeELHibernateDAO getVendorMapPayeeELDao() {
		return vendorMapPayeeELDao;
	}

	public void setVendorMapPayeeELDao(
			VendorMapPayeeELHibernateDAO vendorMapPayeeELDao) {
		this.vendorMapPayeeELDao = vendorMapPayeeELDao;
	}

	@Override
	public VendorMapPayeeEL queryVendorMapPayeeMasterForCash(String expenseType, String recordStatus) throws Exception {
		
		List<VendorMapPayeeEL> resultList = vendorMapPayeeELDao.queryAllVendorMapPayeeMasterForCash(expenseType, recordStatus);
		
		VendorMapPayeeEL vmp = new VendorMapPayeeEL(); 
		VendorMaster vendor = new VendorMaster();
		PayeeMaster payee = new PayeeMaster();
		if(resultList.size()>0){
			vmp = resultList.get(0);
			
			vendor.setVendorCode(vmp.getVendorMasterId().getVendorCode());
			vendor.setVendorName(vmp.getVendorMasterId().getVendorName());
			vendor.setRowId(vmp.getVendorMasterId().getRowId());
			
			payee.setRowId(vmp.getPayeeMasterId().getRowId());
			
		}
		vmp.setPayeeMasterId(payee);
		vmp.setVendorMasterId(vendor);
			
		return vmp;
	}
	
	public HashMap<String,String> queryVendorPayeeBankForCash(String expenseType, String recordStatus) throws Exception {
		
		List<VendorMapPayeeEL> resultList = vendorMapPayeeELDao.queryAllVendorMapPayeeMasterForCash(expenseType, recordStatus);
		HashMap<String,String>  resultList2 = new HashMap<String,String>(); 
	
		for(VendorMapPayeeEL mapPayee : resultList ){
			mapPayee.getVendorMasterId();
			System.out.println(" >>>>>>> "+mapPayee.getVendorMasterId().getRowId());
			mapPayee.getPayeeMasterId();
			System.out.println(" >>>>>>> "+mapPayee.getPayeeMasterId().getRowId());
			
			resultList2.put("VendorName",mapPayee.getVendorMasterId().getVendorName());
			resultList2.put("VendorCode",mapPayee.getVendorMasterId().getVendorCode());
			resultList2.put("VendorMasterID",mapPayee.getVendorMasterId().getRowId());
			resultList2.put("PayeeMasterId",mapPayee.getPayeeMasterId().getRowId());
		}
		
		
		return resultList2;
	}

	@Override
	public List<VendorMapPayeeEL> queryAllVendorMapPayeeMaster() throws Exception {
		
		return vendorMapPayeeELDao.queryAllVendorMapPayee();
	}

	@Override
	public VendorMapPayeeEL queryVendorMapPayeeMasterForCash(String expenseType, String recordStatus, String contractNo, String vendorStatus, String payeeStatus) throws Exception {
		
		List<VendorMapPayeeEL> resultList = vendorMapPayeeELDao.queryAllVendorMapPayeeMasterForCash(expenseType, recordStatus,contractNo, vendorStatus, payeeStatus);
		System.out.println("WT###Print resultList.size()="+resultList.size());
		
		VendorMapPayeeEL vmpRetun = new VendorMapPayeeEL(); 
		VendorMaster vendor = null;
		PayeeMaster payee = null;
		List<VendorMapPayeeEL> resultListReturn = null;
		if(null!=resultList && !resultList.isEmpty()){
			resultListReturn = new ArrayList(resultList);
			if(resultList.size()>0){
				int i = 0;
				for(VendorMapPayeeEL vmp : resultList){
					if(vmp.getVendorMasterId() != null){
						vmp.getVendorMasterId().getVendorCode();
						vmp.getVendorMasterId().getRecordStatus();
						vmp.getVendorMasterId().getVersion();
						vmp.getVendorMasterId().getVendorName();
						vmp.getVendorMasterId().getRowId();
					}
					
					if(vmp.getPayeeMasterId() != null){
						if(!payeeStatus.equalsIgnoreCase(vmp.getPayeeMasterId().getPayeeStatus())){
							//resultList.remove(vmp);
							//resultListReturn.remove(i);
						}else{
							vmp.getPayeeMasterId().getRowId();
							vmp.getPayeeMasterId().getAmphur();
							vmp.getPayeeMasterId().getProvince();
							vmp.getPayeeMasterId().getPayeeName();
							vmp.getPayeeMasterId().getPayeeCode();
						}
					}
					i++;
				}
			}
		}		
		if(null==resultListReturn || resultListReturn.isEmpty()){
			return vmpRetun;
		}
		return resultListReturn.get(0);
	}
	
	@Override
	public VendorMapPayeeEL queryVendorMapPayeeMasterForCash(String expenseType, String recordStatus, String contractNo) throws Exception {
		
		List<VendorMapPayeeEL> resultList = vendorMapPayeeELDao.queryAllVendorMapPayeeMasterForCash(expenseType, recordStatus,contractNo);
		
		VendorMapPayeeEL vmp = new VendorMapPayeeEL(); 
		VendorMaster vendor = null;
		PayeeMaster payee = null;
		if(resultList.size()>0){
			
			vmp = resultList.get(0);
			
			if(vmp.getVendorMasterId() != null){
				
				vendor = new VendorMaster();
				vendor.setVendorCode(vmp.getVendorMasterId().getVendorCode());
				vendor.setRecordStatus(vmp.getVendorMasterId().getRecordStatus());
				vendor.setVersion(vmp.getVendorMasterId().getVersion());
				vendor.setVendorName(vmp.getVendorMasterId().getVendorName());
				vendor.setRowId(vmp.getVendorMasterId().getRowId());
			}
			
			if(vmp.getPayeeMasterId() != null){
				
				payee = new PayeeMaster();
				payee.setRowId(vmp.getPayeeMasterId().getRowId());
				payee.setAmphur(vmp.getPayeeMasterId().getAmphur());
				payee.setProvince(vmp.getPayeeMasterId().getProvince());
				payee.setPayeeName(vmp.getPayeeMasterId().getPayeeName());
				payee.setPayeeCode(vmp.getPayeeMasterId().getPayeeCode());
			}
		}
//		WT###Comment 20101215vmp.setPayeeMasterId(payee);
//		WT###Comment 20101215vmp.setVendorMasterId(vendor);
			
		return vmp;
	}

	@Override
	public VendorMapPayeeEL queryVendorMapPayeeMasterForELPayment(String contractNo) throws Exception {
		logger.debug(" # Get VendorMapPayeeEL  #");
		VendorMapPayeeEL vendorReturn = new VendorMapPayeeEL();
		logger.debug("  get VendorMapPayeeEL  for  EXPENSE_TYPE = 06 and  RECORD_STATUS = Y  and contractNo ="+contractNo+"");

		try{
			VendorMapPayeeEL vendortmp = new VendorMapPayeeEL();
			vendortmp.setExpenseType("06");
			vendortmp.setRecordStatus("Y");
			//WT###Add 20101215
			vendortmp.setContractNo(contractNo);
			//WT###Add 20101215 End
			VendorMapPayeeEL vendortmp1 = vendorMapPayeeELDao.queryVendorMasterForELTemp(vendortmp);
			
			if(vendortmp1!=null){
				logger.debug(" Found VendorMapPayeeEL not null, Check 	 VendorMaster and  PayeeMaster are  null? " );
				if( vendortmp1.getVendorMasterId()!=null){	
					logger.debug(" Step 1 get VendorMaster not null , Search VendorMaster  for  EXPENSE_TYPE = 06 and  RECORD_STATUS = Y   and VendorMasterId:"+vendortmp1.getVendorMasterId());
			
					VendorMaster vendorSearch = new VendorMaster();
					vendorSearch.setRowId(vendortmp1.getVendorMasterId().getRowId());
					vendorSearch.setVendorStatus("03");
					vendorSearch.setRecordStatus("Y");		
					VendorMaster vendorMaster = vendorMapPayeeELDao.getVendorMasterForELTemp(vendorSearch);	
					if(vendorMaster!=null){
						logger.debug(" Step 2 Found VendorMaster ,So  VENDOR_CODE  for  EXPENSE_TYPE = 03 ,  RECORD_STATUS = Y  , VENDOR_MASTER_ID ="+vendortmp1.getVendorMasterId().getRowId()+" VENDOR_CODE:"+vendorMaster.getVendorCode()+" VENDOR_ID:"+vendorMaster.getRowId() );
						vendorReturn.setVendorMasterId(vendorMaster);
					}else{
						logger.debug(" Step 2 get VENDOR_CODE  for  EXPENSE_TYPE = 03 ,  RECORD_STATUS = Y  , VENDOR_MASTER_ID ="+vendortmp1.getVendorMasterId().getRowId()+" Not Found");					
					}			
				}
			
				if( vendortmp1.getPayeeMasterId()!=null){	
					logger.debug(" Step 1 get PAYEE_MASTER_ID  for  EXPENSE_TYPE = 06 and  RECORD_STATUS = Y   Found:"+vendortmp1.getPayeeMasterId());
					/*
					  Step 2.	นำค่า PAYEE_MASTER_ID ที่ได้ไป Query Data From SEM_CT_PAYEE_MASTER Table: Column Name = PAYEE_MASTER_ID โดยมีเงื่อนไขดังนี้
							2.1	PAYEE_STATUS = 03	2.2	RECORD_STATUS = Y
	
					 */		
					
					PayeeMaster payeeIn = new PayeeMaster();
					payeeIn.setRowId(vendortmp1.getPayeeMasterId().getRowId());
//					payeeIn.setPayeeStatus("03");
					payeeIn.setRecordStatus("Y");
					PayeeMaster payeeMaster = vendorMapPayeeELDao.getPayeeMasterForELTemp(payeeIn);	
					if(payeeMaster!=null){
						logger.debug(" Step 2 get PAYEE_MASTER_ID  for  EXPENSE_TYPE = 03 ,  RECORD_STATUS = Y  , PAYEE_MASTER_ID ="+vendortmp1.getPayeeMasterId().getRowId()+" Found > PAYEE_MASTER_ID:"+payeeMaster.getRowId()+" PAYEE_NAME:"+payeeMaster.getPayeeName());					
						vendorReturn.setPayeeMasterId(payeeMaster);
					}else{
						logger.debug(" Step 2 get PAYEE_MASTER_ID  for  EXPENSE_TYPE = 03 ,  RECORD_STATUS = Y  , PAYEE_MASTER_ID ="+vendortmp1.getPayeeMasterId().getRowId()+" Not Found");					
					}			
	
				}else{
					logger.debug(" Step 1 get PAYEE_MASTER_ID for  EXPENSE_TYPE = 06 and  RECORD_STATUS = Y  Not Found");	
				}		
			}else{
				logger.debug(" Not Found VendorMapPayeeEL ");
			}			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}

		
		return vendorReturn;
	}

	@Override
	public PayeeBookbank queryVendorMapPayeeMasterBookBank(String contractNo) throws Exception {
		logger.debug(" # Get PayeeBookbank ##");
		PayeeBookbank bookbank = new PayeeBookbank();
		logger.debug("  get VENDOR_MASTER_ID for  EXPENSE_TYPE = 06 and  RECORD_STATUS = Y  and contractNo ="+contractNo+"");


		try{
			VendorMapPayeeEL vendortmp = new VendorMapPayeeEL();
			vendortmp.setExpenseType("06");
			vendortmp.setRecordStatus("Y");
			vendortmp.setContractNo(contractNo);
			VendorMapPayeeEL vendortmp1 = vendorMapPayeeELDao.queryVendorMasterForELTemp(vendortmp);
			
			if(vendortmp1!=null){		
				logger.debug(" Found VendorMapPayeeEL not null , Check PayeeMaster and  VendorMaster use PayeeMaster First !!" );
				if(vendortmp1.getPayeeMasterId()!=null){
					logger.debug(" PayeeMaster not null , So use payeeMasterId:"+vendortmp1.getPayeeMasterId()+" for get PayeeBookbank");
					//2.	ถ้า Column Name = PAYEE_MASTER_ID <> Null Value > นำค่า PAYEE_MASTER_ID ที่ได้ไป Query Data From SEM_CT_PAYEE_BOOKBANK Table: Column Name = BANK_ACC_NAME โดยมีเงื่อนไขดังนี้
					//2.1	PAYEE_BOOKBANK_STATUS = 06
					//2.2	RECORD_STATUS = Y
					PayeeBookbank payeebookSearch = new PayeeBookbank();
					payeebookSearch.setPayeeMasterId(vendortmp1.getPayeeMasterId().getRowId());
					payeebookSearch.setPayeeBookbankStatus("06");
					payeebookSearch.setRecordStatus("Y");					
					bookbank= vendorMapPayeeELDao.getPayeeBookbankForEL(payeebookSearch);	
				}else{
					logger.debug(" PayeeMaster is null , So use VendorMaster id:"+vendortmp1.getVendorMasterId().getRowId()+" for get PayeeBookbank");
					//3.	ถ้า Column Name = PAYEE_MASTER_ID = Null Value > นำค่า VENDOR_MASTER_ID ที่ได้ไป Query Data From SEM_CT_VENDOR_BOOKBANK Table: Column Name = BANK_ACC_NAME โดยมีเงื่อนไขดังนี้
					//3.1	VENDOR_BOOKBANK_STATUS = 06
					//3.2	RECORD_STATUS = Y
					VendorBookbank bookbankSearch = new VendorBookbank();
					bookbankSearch.setVendorMasterId(vendortmp1.getVendorMasterId().getRowId());
					bookbankSearch.setVendorBookbankStatus("06");
					bookbankSearch.setRecordStatus("Y");					
					VendorBookbank vendorBookBank= vendorMapPayeeELDao.getVendorBookbankForEL(bookbankSearch);
					if(vendorBookBank!=null){
						bookbank.setBankAccName(vendorBookBank.getBankAccName());
						bookbank.setBankAccNo(vendorBookBank.getBankAccNo());
						bookbank.setBankCode(vendorBookBank.getBankCode());
					}
				}
		
			}else{
				logger.debug(" Not Found VendorMapPayeeEL  for  EXPENSE_TYPE = 06 and  RECORD_STATUS = Y  and contractNo ="+contractNo+"Not Found");
			}	
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return bookbank;
	}
	
	public List<VendorMapPayeeEL> queryVendorMapPayeeByContractNo(String contractNo)throws Exception {
		
		List<VendorMapPayeeEL> vendorMapPayeeList = vendorMapPayeeELDao.getVendorMapPayeeByContractNo(contractNo);
		if(!vendorMapPayeeList.isEmpty()){
			for(VendorMapPayeeEL obj : vendorMapPayeeList){
				if(null!=obj.getVendorMasterId()){
					obj.getVendorMasterId().toString();//WT### Avoid lazy error
				}				
				if(null!=obj.getPayeeMasterId()){
					obj.getPayeeMasterId().toString();//WT### Avoid lazy error
				}							
			}
		}	
		
		return vendorMapPayeeList;
	}

	@Override
	public void createVendorMapPayee(VendorMapPayeeEL vendorMapPayeeEL)
			throws Exception {
		vendorMapPayeeEL.setRowId(vendorMapPayeeService.getRunningNo("CT_VENDOR_MASTER"));
		vendorMapPayeeELDao.saveVendorMapPayee(vendorMapPayeeEL);		
	}
	
}
