package th.co.ais.service.sem_sap;

import java.util.List;

public interface ISemSapService {
	public List<?> querySPList(String spName, Object property) throws Exception;
}
