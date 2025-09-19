package th.co.ais.service.sap;

import java.util.List;

import th.co.ais.domain.ac.Mac001Srch;
import th.co.ais.domain.gm.Employee;
import th.co.ais.domain.gm.TransPayment;
import th.co.ais.domain.sap.SapMapping;
import th.co.ais.domain.sap.SapTrxDtl;
import th.co.ais.domain.sap.SapTrxHdr;
import th.co.ais.domain.sap.SapTrxLog;
import th.co.ais.domain.sap.SapTrxLogSrch;
import th.co.ais.service.BaseService;
import th.co.ais.util.WrapperBeanObject;

public interface ISAPService extends BaseService {
	
	//public void createTransactionToSAP(final List<TransPayment> tPayments, final Employee employee) throws Exception;
	public void createTransactionToSAP(final List<WrapperBeanObject<Mac001Srch>> mac001SrchList, final Employee employee, final String companyCode) throws Exception;
	public void regenerateTransactionToSAP(final List<WrapperBeanObject<SapTrxLog>> logSrchList, final Employee employee) throws Exception;
	
	/** Log **/
	public List<SapTrxLog> querySapTrxLog(final SapTrxLogSrch filter) throws Exception;	
	
	/** Header **/
	public List<SapTrxHdr> querySapTrxHdr(SapTrxHdr filter, boolean loadChild) throws Exception;
		
	/** Detail **/
	public List<SapTrxDtl> querySapTrxDtl(SapTrxDtl filter) throws Exception;
	
}
