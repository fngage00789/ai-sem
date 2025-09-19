package th.co.ais.service.impl.gm;

import java.util.List;

import th.co.ais.dao.impl.gm.PayeeMasterHibernateDAO;
import th.co.ais.domain.gm.PayeeBookbank;
import th.co.ais.domain.gm.PayeeMaster;
import th.co.ais.domain.gm.VendorMapPayee;
import th.co.ais.domain.rt.MrtGetRunningNo;
import th.co.ais.service.AbstractService;
import th.co.ais.service.gm.IPayeeBookbankService;
import th.co.ais.service.gm.IPayeeMasterService;
import th.co.ais.service.gm.IVendorMapPayeeService;
import th.co.ais.util.EQueryName;

public class PayeeMasterServiceImpl extends AbstractService implements IPayeeMasterService{

	private PayeeMasterHibernateDAO payeeMasterDao;
	private IVendorMapPayeeService vendorMapPayeeService;
	private IPayeeBookbankService payeeBookbankService;
	
	public void setVendorMapPayeeService(IVendorMapPayeeService vendorMapPayeeService) {
		this.vendorMapPayeeService = vendorMapPayeeService;
	}

	public void setPayeeBookbankService(IPayeeBookbankService payeeBookbankService) {
		this.payeeBookbankService = payeeBookbankService;
	}

	public void setPayeeMasterDao(PayeeMasterHibernateDAO payeeMasterDao) {
		this.payeeMasterDao = payeeMasterDao;
	}

	@Override
	public List<PayeeMaster> queryAllPayeeMaster() throws Exception {
		
		return payeeMasterDao.queryAllVendorMaster();
	}
	
	@Override
	public List<PayeeMaster> queryPayeeMasterByCriteria(PayeeMaster payeeMaster) throws Exception {
		
		return payeeMasterDao.queryPayeeMasterByCode(payeeMaster);
	}

	
	@Override
	public PayeeMaster queryPayeeMasterByRowId(String rowId) throws Exception {
		return payeeMasterDao.findByRowId(rowId);
	}
	
	
	@Override
	public Object[] createPayeeMasterInfo(String vendorMasterId, PayeeMaster payeeMaster, VendorMapPayee vendorMapPayee, PayeeBookbank payeeBookbank) throws Exception {
		
		Object[] obj = new Object[3];
		
		PayeeMaster newPayeeMaster = null;
		
		if(payeeMaster != null){
			//create payee master
			newPayeeMaster = createPayeeMaster(payeeMaster);
			obj[0] = newPayeeMaster;
		}
		
		if(vendorMapPayee != null){
			//create map PayeeMaster with VendorMaster
			vendorMapPayee.setVendorMasterId(vendorMasterId);
			vendorMapPayee.setPayeeMasterId(newPayeeMaster.getRowId());
			VendorMapPayee newVendorMapPayee = vendorMapPayeeService.createVendorMapPayee(vendorMapPayee);
			obj[1] = newVendorMapPayee;
		}
		
		if(payeeBookbank != null){
			payeeBookbank.setPayeeMasterId(newPayeeMaster.getRowId());
			PayeeBookbank newPayeeBookbank = payeeBookbankService.createPayeeBookbank(payeeBookbank);
			obj[2] = newPayeeBookbank;
		}
		
		return obj;
	}
	
	@Override
	public PayeeMaster createPayeeMaster(PayeeMaster payeeMaster) throws Exception {
		payeeMaster.setRowId(getRunningNo("CT_VENDOR_MASTER"));
		payeeMaster.setRecordStatus(STATUS_Y);
		//Change on 8/3/2013
		payeeMaster.setPayeeStatus("01");
		return payeeMasterDao.merge(payeeMaster);
	}

	@Override
	public void deletePayeeMaster(PayeeMaster payeeMaster) throws Exception {
		payeeMaster.setRecordStatus(STATUS_N);
		payeeMasterDao.merge(payeeMaster);
	}

	@Override
	public PayeeMaster updatePayeeMaster(PayeeMaster payeeMaster)throws Exception {
		return payeeMasterDao.merge(payeeMaster);
	}


	@Override
	public List queryPayeeMasterSPList(String spName, Object property) throws Exception {
		return payeeMasterDao.querySPList(spName, property);
	}
	
	@Override
	public PayeeMaster queryPayeeMasterByIdCard(String idCardNo) throws Exception {
		return payeeMasterDao.findByIdCard(idCardNo);
	}

	@Override
	public PayeeMaster queryPayeeMasterByTaxId(String taxIdNo) throws Exception {
		return payeeMasterDao.findByTaxId(taxIdNo);
	}

	@Override
	public Object[] updatePayeeMasterInfo(PayeeMaster payeeMaster, VendorMapPayee vendorMapPayee, PayeeBookbank payeeBookbank) throws Exception {
		
		Object[] obj = new Object[3];
		
		PayeeMaster newPayeeMaster = null;
		
		if(payeeMaster != null){
			//create payee master
			newPayeeMaster = updatePayeeMaster(payeeMaster);
			obj[0] = newPayeeMaster;
		}
		
		if(vendorMapPayee != null){
			//update map PayeeMaster with VendorMaster
			VendorMapPayee newVendorMapPayee = vendorMapPayeeService.updateVendorMapPayeeInfo(vendorMapPayee);
			obj[1] = newVendorMapPayee;
		}
		
		if(payeeBookbank != null){
			payeeBookbank.setPayeeMasterId(newPayeeMaster.getRowId());
			PayeeBookbank newPayeeBookbank = payeeBookbankService.updatePayeeBookbank(payeeBookbank);
			obj[2] = newPayeeBookbank;
		}
		
		
		return obj;
	}

	
	private String getRunningNo(String runningType) throws Exception {
		MrtGetRunningNo property = new MrtGetRunningNo();
		property.setRunningType(runningType);
		List<MrtGetRunningNo> runningNo = payeeMasterDao.querySPList(EQueryName.SP_MRT_GET_RUNNING_NO.name, property);
		if(runningNo != null && !runningNo.isEmpty()){
			if(runningNo.size()==1)
			return (String)runningNo.get(0).getRunningNo();
		}
		return "";
	}

	@Override
	public PayeeMaster queryPayeeMasterByPayeeName(String payeeName) throws Exception {
		return payeeMasterDao.findByPayeeName(payeeName);
	}

}
