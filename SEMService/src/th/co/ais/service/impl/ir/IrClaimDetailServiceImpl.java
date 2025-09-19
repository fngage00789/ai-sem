package th.co.ais.service.impl.ir;

import th.co.ais.dao.impl.ir.IrClaimDetailHibernateDAO;
import th.co.ais.service.AbstractService;
import th.co.ais.service.ir.IIrClaimDetailService;

public class IrClaimDetailServiceImpl extends AbstractService implements
		IIrClaimDetailService {

	private IrClaimDetailHibernateDAO irClaimDetailDao;

	public void setIrClaimDetailDao(IrClaimDetailHibernateDAO irClaimDetailDao) {
		this.irClaimDetailDao = irClaimDetailDao;
	}

}
