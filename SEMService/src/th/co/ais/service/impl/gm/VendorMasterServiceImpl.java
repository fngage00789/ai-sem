package th.co.ais.service.impl.gm;

import java.util.ArrayList;
import java.util.List;

import th.co.ais.dao.impl.gm.VendorMasterHibernateDAO;
import th.co.ais.domain.gm.CT001Export;
import th.co.ais.domain.gm.CT001SrchMSP;
import th.co.ais.domain.gm.CT001UpdateSP;
import th.co.ais.domain.gm.SPStatus;
import th.co.ais.domain.gm.VendorBookbank;
import th.co.ais.domain.gm.VendorMapPayee;
import th.co.ais.domain.gm.VendorMaster;
import th.co.ais.domain.rt.MrtGetRunningNo;
import th.co.ais.service.AbstractService;
import th.co.ais.service.gm.IVendorBookbankService;
import th.co.ais.service.gm.IVendorMapPayeeService;
import th.co.ais.service.gm.IVendorMasterService;
import th.co.ais.util.EQueryName;

public class VendorMasterServiceImpl extends AbstractService implements IVendorMasterService {
	
	private VendorMasterHibernateDAO vendorMasterDao;
	private IVendorMapPayeeService vendorMapPayeeService;
	private IVendorBookbankService vendorBookbankService;

	public void setVendorMasterDao(VendorMasterHibernateDAO vendorMasterDao) {
		this.vendorMasterDao = vendorMasterDao;
	}
	
	public void setVendorMapPayeeService(IVendorMapPayeeService vendorMapPayeeService) {
		this.vendorMapPayeeService = vendorMapPayeeService;
	}

	public void setVendorBookbankService(IVendorBookbankService vendorBookbankService) {
		this.vendorBookbankService = vendorBookbankService;
	}


	@Override
	public Object[] createVendorMasterInfo(VendorMaster vendorMaster, VendorMapPayee vendorMapPayee, VendorBookbank vendorBookbank) 
	throws Exception {
		
		Object[] obj = new Object[3];
		
		VendorMaster newVendorMaster = null;
		
		if(vendorMaster != null){
			//create vendor master
			newVendorMaster = createVendorMaster(vendorMaster);
			obj[0] = newVendorMaster;
		}
		
		if(vendorMapPayee != null){
			vendorMapPayee.setVendorMasterId(newVendorMaster.getRowId());
			VendorMapPayee newVendorMapPayee = vendorMapPayeeService.createVendorMapPayee(vendorMapPayee);
			obj[1] = newVendorMapPayee;
		}
		
		if(vendorBookbank != null){
			vendorBookbank.setVendorMasterId(newVendorMaster.getRowId());
			VendorBookbank newVendorBookbank = vendorBookbankService.createVendorBookbank(vendorBookbank);
			obj[2] = newVendorBookbank;
		}
		
		return obj;
		
	}
	
	@Override
	public Object[] updateVendorMasterInfo(VendorMaster vendorMaster, VendorMapPayee vendorMapPayee, VendorBookbank vendorBookbank) 
	throws Exception {
		
		Object[] obj = new Object[3];
		
		VendorMaster newVendorMaster = null;
		
		if(vendorMaster != null){
			//create vendor master
			newVendorMaster = updateVendorMaster(vendorMaster);
			obj[0] = newVendorMaster;
		}
		
		if(vendorMapPayee != null){
			vendorMapPayee.setVendorMasterId(newVendorMaster.getRowId());
			VendorMapPayee newVendorMapPayee = vendorMapPayeeService.updateVendorMapPayeeInfo(vendorMapPayee);
			obj[1] = newVendorMapPayee;
		}
		
		if(vendorBookbank != null){
			vendorBookbank.setVendorMasterId(newVendorMaster.getRowId());
			VendorBookbank newVendorBookbank = vendorBookbankService.updateVendorBookbank(vendorBookbank);
			obj[2] = newVendorBookbank;
		}
		
		return obj;
		
	}
	
	@Override
	public VendorMaster createVendorMaster(VendorMaster vendorMaster) throws Exception {
		vendorMaster.setRowId(getRunningNo("CT_VENDOR_MASTER"));
		vendorMaster.setRecordStatus(STATUS_Y);
		vendorMaster.setVendorStatus("03");
		return vendorMasterDao.merge(vendorMaster);
	}
	
	@Override
	public void deleteVendorMaster(VendorMaster vendorMaster) throws Exception {
		vendorMaster.setRecordStatus(STATUS_N);
		vendorMasterDao.mergeFlush(vendorMaster);
		
	}
	
	@Override
	public VendorMaster updateVendorMaster(VendorMaster vendorMaster) throws Exception {
		return vendorMasterDao.merge(vendorMaster);
	}

	@Override
	public List<VendorMaster> queryVendorMaster(VendorMaster vendorMaster, String orderBy) throws Exception {
		return vendorMasterDao.queryVendorMaster(vendorMaster, orderBy);
	}
	
	@Override
	public VendorMaster queryVendorMasterByRowId(String rowId) throws Exception {
		return vendorMasterDao.findByRowId(rowId);
	}

	@Override
	public List<VendorMaster> queryAllVendorMaster() throws Exception {
		return vendorMasterDao.queryAllVendorMaster();
	}

	@Override
	public List queryVendorMasterSPList(String spName, Object property) throws Exception {
		return vendorMasterDao.querySPList(spName, property);
	}

	@Override
	public CT001SrchMSP queryCT001SrchMSPByVendorMasterId(String vendorMasterId) throws Exception {
		CT001SrchMSP property = new CT001SrchMSP();
		property.setVendorMasterId(vendorMasterId);
		return (CT001SrchMSP)vendorMasterDao.querySingleBySP(EQueryName.Q_CT001_M_SRCH.name, property);
		
	}

	@Override
	public VendorMaster queryVendorMasterByIdCard(String idCard) throws Exception {
		return vendorMasterDao.findByIdCard(idCard);
	}

	@Override
	public VendorMaster queryVendorMasterByTaxId(String taxId) throws Exception {
		return vendorMasterDao.findByTaxId(taxId);
	}
	
	@Override
	public VendorMaster queryVendorMasterByTaxId13(String taxId13) throws Exception {
		return vendorMasterDao.findByTaxId13(taxId13);
	}
	
	@Override
	public String getRunningNo(String runningType) throws Exception {
		MrtGetRunningNo property = new MrtGetRunningNo();
		property.setRunningType(runningType);
		List<MrtGetRunningNo> runningNo = vendorMasterDao.querySPList(EQueryName.SP_MRT_GET_RUNNING_NO.name, property);
		if(runningNo != null && !runningNo.isEmpty()){
			if(runningNo.size()==1)
			return (String)runningNo.get(0).getRunningNo();
		}
		return "";
	}
	
	//Approve in ct001-2
	@Override
	public SPStatus updateStatus(String vendorMapPayeeIds, String userId) throws Exception {
		return vendorMasterDao.updateStatus(vendorMapPayeeIds, userId);
	}

	@Override
	public List<CT001Export> queryCT001ForExport(String vendorMasterIds) throws Exception {
		CT001Export property = new CT001Export();
		property.setVendorMasterIds(vendorMasterIds);
		return (List<CT001Export>)vendorMasterDao.querySPList(EQueryName.Q_CT001_EXPORT.name, property);
	}

	@Override
	public VendorMaster queryVendorMasterByVendorName1(String vendorName1) throws Exception {
		return vendorMasterDao.findByVendorName1(vendorName1);
	}
	

	@Override
	public CT001UpdateSP updateMCT001(String vendorMasterId, String vendorMapPayeeId, String userId, String lessorId) throws Exception {
		return vendorMasterDao.updateMCT001(vendorMasterId, vendorMapPayeeId, userId, lessorId);
	}
	
	@Override
	public List querySPList(String spName, Object property) throws Exception {
		return vendorMasterDao.querySPList(spName, property);
	}

	public List<String> getVendorCodeList(String contractNo) throws Exception{
		return vendorMasterDao.getVendorCodeList(contractNo);
	}
	
	@Override
	public List getRegionMasterCheckList(String spName) throws Exception {
		return vendorMasterDao.querySP(spName);
	}
	
}
