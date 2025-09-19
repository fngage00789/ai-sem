package th.co.ais.service.impl.gm;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import th.co.ais.dao.impl.gm.VendorMapPayeeHibernateDAO;
import th.co.ais.domain.gm.PayeeMaster;
import th.co.ais.domain.gm.VendorMapPayee;
import th.co.ais.domain.gm.VendorMaster;
import th.co.ais.domain.rt.MrtGetRunningNo;
import th.co.ais.service.AbstractService;
import th.co.ais.service.gm.IVendorMapPayeeService;
import th.co.ais.util.EQueryName;

public class VendorMapPayeeServiceImpl extends AbstractService implements IVendorMapPayeeService{

	VendorMapPayeeHibernateDAO vendorMapPayeeDao;
	
	public void setVendorMapPayeeDao(VendorMapPayeeHibernateDAO vendorMapPayeeDao) {
		this.vendorMapPayeeDao = vendorMapPayeeDao;
	}
	
	@Override
	public List<VendorMapPayee> queryAllVendorMapPayeeMaster() throws Exception {
		return vendorMapPayeeDao.queryAllVendorMapPayee();
	}

	@Override
	public VendorMapPayee queryByRowId(String rowId) throws Exception {
		return vendorMapPayeeDao.findByRowId(rowId);
	}

	@Override
	public VendorMapPayee createVendorMapPayee(VendorMapPayee vendorMapPayee) throws Exception {
		//set running no.
		vendorMapPayee.setRowId(getRunningNo("CT_VENDOR_MASTER"));
		vendorMapPayee.setRecordStatus(STATUS_Y);
		return vendorMapPayeeDao.merge(vendorMapPayee);
	}

	@Override
	public void deleteVendorMapPayee(VendorMapPayee vendorMapPayee) throws Exception {
		vendorMapPayee.setRecordStatus(STATUS_N);
		vendorMapPayeeDao.mergeFlush(vendorMapPayee);
	}

	public VendorMapPayee updateVendorMapPayee(VendorMapPayee vendorMapPayee) throws Exception {
		return vendorMapPayeeDao.merge(vendorMapPayee);
	}
	
	public boolean updateVendorMapPayeeM(VendorMapPayee vendorMapPayee) throws Exception {
		return vendorMapPayeeDao.updateVendorMapPayee(vendorMapPayee);
	}
	
	@Override
	public VendorMapPayee updateVendorMapPayeeInfo(VendorMapPayee vendorMapPayee) throws Exception {
		if(vendorMapPayee != null){
			String contractNo = vendorMapPayee.getContractNo();
			String expenseType = vendorMapPayee.getExpenseType();
			String vendorMasterId = vendorMapPayee.getVendorMasterId();
			String payeeMasterId = vendorMapPayee.getPayeeMasterId();
			
			VendorMapPayee deleteVendorMap = null;
			if(StringUtils.isEmpty(payeeMasterId)){
				deleteVendorMap = checkVendorNoMapExisted(contractNo, expenseType, vendorMasterId);
			}else{
				deleteVendorMap = checkVendorMapExisted(contractNo, expenseType, vendorMasterId, payeeMasterId);
			}
			
			if(deleteVendorMap != null){
				deleteVendorMapPayee(deleteVendorMap);
			}
			
		}
		return createVendorMapPayee(vendorMapPayee);
	}

	@Override
	public VendorMapPayee queryByVendorMasterId(String vendorMasterId) throws Exception {
		return vendorMapPayeeDao.findByVendorMasterId(vendorMasterId);
	}
	
	@Override
	public VendorMapPayee checkVendorNoMapExisted(String contractNo, String expenseType, String vendorMasterId) throws Exception {
		VendorMapPayee vendorMapPayee = new VendorMapPayee();
		vendorMapPayee.setContractNo(contractNo);
		vendorMapPayee.setExpenseType(expenseType);
		vendorMapPayee.setVendorMasterId(vendorMasterId);
		List<VendorMapPayee> l = vendorMapPayeeDao.queryVendorMapPayeeNoMapping(vendorMapPayee);
		if(l != null && !l.isEmpty() && l.size() == 1){
			return (VendorMapPayee)l.get(0);	
		}
		return null;
	}
	
	@Override
	public VendorMapPayee checkVendorMapExisted(String contractNo,
			String expenseType, String vendorMasterId, String payeeMasterId)
			throws Exception {
		
		VendorMapPayee vendorMapPayee = new VendorMapPayee();
		vendorMapPayee.setContractNo(contractNo);
		vendorMapPayee.setExpenseType(expenseType);
		vendorMapPayee.setVendorMasterId(vendorMasterId);
		vendorMapPayee.setPayeeMasterId(payeeMasterId);
		List<VendorMapPayee> l = vendorMapPayeeDao.queryVendorMapPayeeMapping(vendorMapPayee);
		if (l != null && !l.isEmpty() && l.size() == 1) {
			return (VendorMapPayee) l.get(0);
		}
		return null;
	}

	@Override
	public String getRunningNo(String runningType) throws Exception {
		MrtGetRunningNo property = new MrtGetRunningNo();
		property.setRunningType(runningType);
		List<MrtGetRunningNo> runningNo = vendorMapPayeeDao.querySPList(EQueryName.SP_MRT_GET_RUNNING_NO.name, property);
		if(runningNo != null && !runningNo.isEmpty()){
			if(runningNo.size()==1)
			return (String)runningNo.get(0).getRunningNo();
		}
		return "";
	}
	

	@Override
	public VendorMapPayee queryVendorMapPayeeMasterForCash(String expenseType, String recordStatus) throws Exception {
		
		List<VendorMapPayee> resultList = vendorMapPayeeDao.queryAllVendorMapPayeeMasterForCash(expenseType, recordStatus);
		
		VendorMapPayee vmp = new VendorMapPayee(); 
		VendorMaster vendor = new VendorMaster();
		PayeeMaster payee = new PayeeMaster();
		if(resultList.size()>0){
			vmp = resultList.get(0);
			
		/*	vendor.setVendorCode(vmp.getVendorMasterId().getVendorCode());
			vendor.setVendorName(vmp.getVendorMasterId().getVendorName());
			vendor.setRowId(vmp.getVendorMasterId().getRowId());
			
			payee.setRowId(vmp.getPayeeMasterId().getRowId());*/
			
		}
		/*vmp.setPayeeMasterId(payee);
		vmp.setVendorMasterId(vendor);*/
			
		return vmp;
	}
	
	public HashMap<String,String> queryVendorPayeeBankForCash(String expenseType, String recordStatus) throws Exception {
		
		List<VendorMapPayee> resultList = vendorMapPayeeDao.queryAllVendorMapPayeeMasterForCash(expenseType, recordStatus);
		HashMap<String,String>  resultList2 = new HashMap<String,String>(); 
	
		for(VendorMapPayee mapPayee : resultList ){
			mapPayee.getVendorMasterId();
			/*System.out.println(" >>>>>>> "+mapPayee.getVendorMasterId().getRowId());
			mapPayee.getPayeeMasterId();
			System.out.println(" >>>>>>> "+mapPayee.getPayeeMasterId().getRowId());
			
			resultList2.put("VendorName",mapPayee.getVendorMasterId().getVendorName());
			resultList2.put("VendorCode",mapPayee.getVendorMasterId().getVendorCode());
			resultList2.put("VendorMasterID",mapPayee.getVendorMasterId().getRowId());
			resultList2.put("PayeeMasterId",mapPayee.getPayeeMasterId().getRowId());*/
		}
		
		
		return resultList2;
	}
	
}
