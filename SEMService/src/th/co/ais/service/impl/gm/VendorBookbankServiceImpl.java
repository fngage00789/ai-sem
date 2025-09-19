package th.co.ais.service.impl.gm;

import java.util.List;

import th.co.ais.dao.impl.gm.VendorBookbankHibernateDAO;
import th.co.ais.domain.gm.VendorBookbank;
import th.co.ais.service.AbstractService;
import th.co.ais.service.gm.IVendorBookbankService;

public class VendorBookbankServiceImpl extends AbstractService implements IVendorBookbankService {
 
	private VendorBookbankHibernateDAO vendorBookbankDao;
	
	public void setVendorBookbankDao(VendorBookbankHibernateDAO vendorBookbankDao) {
		this.vendorBookbankDao = vendorBookbankDao;
	}
	
	public VendorBookbank queryByRowId(String rowId) throws Exception {
		return vendorBookbankDao.findByRowId(rowId);
	}

	@Override
	public List<VendorBookbank> searchVendorBookbank( VendorBookbank vendorBookBank) throws Exception {
		return vendorBookbankDao.queryVendorBookbank(vendorBookBank);
	}

	@Override
	public VendorBookbank createVendorBookbank(VendorBookbank vendorBookBank) throws Exception {
		vendorBookBank.setRecordStatus(STATUS_Y);
		//vendorBookBank.setVendorBookbankStatus("01");
		return vendorBookbankDao.merge(vendorBookBank);
	}

	@Override
	public void deleteVendorBookbank(VendorBookbank vendorBookBank) throws Exception {
		vendorBookBank.setRecordStatus(STATUS_N);
		vendorBookbankDao.mergeFlush(vendorBookBank);
	}

	public VendorBookbank update(VendorBookbank vendorBookBank) throws Exception {
		return vendorBookbankDao.merge(vendorBookBank);
	}
	
	@Override
	public VendorBookbank updateVendorBookbank(VendorBookbank vendorBookBank) throws Exception {
		if(vendorBookBank != null){
			VendorBookbank oldVendorBookbank = getVendorBookbankByVendorMasterId(vendorBookBank.getVendorMasterId());
			if(oldVendorBookbank != null)
			deleteVendorBookbank(oldVendorBookbank);
			vendorBookBank.setRowId(null);
			return createVendorBookbank(vendorBookBank);
		}
		return update(vendorBookBank);
	}


	@Override
	public String queryByVendorMasterId(String vendorMasterId) throws Exception {
		VendorBookbank to = vendorBookbankDao.queryVendorBookBankByVendorMasterId(vendorMasterId);
		if (to != null) {
			return to.getBankAccNo();
		} else {
			return "";
		}
	}
	
	@Override
	public List<VendorBookbank> queryAllVendorBookbankService()
			throws Exception {
		
		return vendorBookbankDao.queryAllVendorBookbank();
	}

	@Override
	public VendorBookbank getVendorBookbankByVendorMasterId(
			String vendorMasterId) throws Exception {
		
		return vendorBookbankDao.queryVendorBookBankByVendorMasterId(vendorMasterId);
	}
	
	@Override
	public VendorBookbank queryVendorBookbankByVendorMaster(
			VendorBookbank vendorBookbank) throws Exception {
		
		return vendorBookbankDao.queryVendorBookBankByVendorMaster(vendorBookbank);
	}

	@Override
	public VendorBookbank queryByBankAccountNo(String bankAccNo) throws Exception {
		return vendorBookbankDao.findByBankAccountNo(bankAccNo);
	}
	
	

}
