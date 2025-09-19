package th.co.ais.service.ir;

import java.util.List;
import java.util.Map;

import th.co.ais.domain.ir.IrClaim;
import th.co.ais.domain.ir.IrClaimDetail;
import th.co.ais.service.BaseService;
import th.co.ais.util.WrapperBeanObject;

public interface IIrClaimService extends BaseService {

	public IrClaim insertIrClaim(IrClaim irClaim, Map<String, WrapperBeanObject<IrClaimDetail>> irClaimDetails) throws Exception;
	
	public IrClaim updateIrClaim(IrClaim irClaim, Map<String, WrapperBeanObject<IrClaimDetail>> irClaimDetails) throws Exception;
	
	public IrClaim deleteIrClaim(IrClaim irClaim) throws Exception;

	public List querySPList(String spName, Object property) throws Exception;
	
	public IrClaim findByPK(String pk) throws Exception;
	
	public IrClaim findByPKWithChild(String pk) throws Exception;
	
	public List<IrClaim> searchByUserLogin(String userLogin) throws Exception;

}
