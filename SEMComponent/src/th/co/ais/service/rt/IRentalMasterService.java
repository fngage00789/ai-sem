package th.co.ais.service.rt;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;

import th.co.ais.domain.rt.Mrt010IfrsInterface;
import th.co.ais.domain.rt.RentalMaster;

public interface IRentalMasterService {

	public RentalMaster createRentalMaster(RentalMaster rentalMaster) throws Exception;

	public RentalMaster updateRentalMaster(RentalMaster rentalMaster) throws Exception;

	public void deleteRentalMaster(RentalMaster rentalMaster) throws Exception;

	public RentalMaster queryByRowId(String rowId) throws Exception;

	public List querySPList(String spName, Object property) throws Exception;

	public String callSemIfrsChkSendToSap(String siteInfoId, String rentalMasterId);
	
	public String callSemIfrsChkChange(String contractNo) throws Exception;
	
	public String callSemIfrsChkDelay(String contractType)throws Exception;

	List<Mrt010IfrsInterface> callSemIfrs20online(Mrt010IfrsInterface ifrsPrepare) throws Exception;

}
