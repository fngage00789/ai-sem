package th.co.ais.service.el;

import java.util.HashMap;
import java.util.List;

import th.co.ais.domain.el.VendorMapPayeeEL;
import th.co.ais.domain.gm.PayeeBookbank;
import th.co.ais.service.BaseService;

public interface IVendorMapPayeeELService extends BaseService {

	public List<VendorMapPayeeEL> queryAllVendorMapPayeeMaster() throws Exception;
	
	public VendorMapPayeeEL queryVendorMapPayeeMasterForCash(String expenseType,String recordStatus) throws Exception;
	public HashMap<String,String> queryVendorPayeeBankForCash(String expenseType, String recordStatus) throws Exception;
	public VendorMapPayeeEL queryVendorMapPayeeMasterForCash(String expenseType,String recordStatus,String contractNo) throws Exception;
	
	public VendorMapPayeeEL queryVendorMapPayeeMasterForELPayment(String contractNo)throws Exception;
	
	public PayeeBookbank queryVendorMapPayeeMasterBookBank(String contractNo) throws Exception ;

	public VendorMapPayeeEL queryVendorMapPayeeMasterForCash(String expenseType, String recordStatus, String contractNo, String vendorStatus,
			String payeeStatus) throws Exception;
	
	public List<VendorMapPayeeEL> queryVendorMapPayeeByContractNo(String contractNo) throws Exception;
	public void createVendorMapPayee(VendorMapPayeeEL vendorMapPayeeEL) throws Exception;
}
