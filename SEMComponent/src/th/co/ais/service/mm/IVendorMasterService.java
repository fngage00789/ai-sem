package th.co.ais.service.mm;

import java.util.List;

public interface IVendorMasterService {
	@SuppressWarnings("unchecked")
	public List querySPList(String spName, Object property) throws Exception;
	
}
