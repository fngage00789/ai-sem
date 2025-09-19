package th.co.ais.service.impl.ir;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Session;

import th.co.ais.dao.exception.DAOException;
import th.co.ais.dao.impl.ir.IrClaimDetailHibernateDAO;
import th.co.ais.dao.impl.ir.IrClaimHibernateDAO;
import th.co.ais.domain.ir.IrClaim;
import th.co.ais.domain.ir.IrClaimDetail;
import th.co.ais.domain.ir.MirGetRunningNo;
import th.co.ais.service.AbstractService;
import th.co.ais.service.ir.IIrClaimService;
import th.co.ais.service.util.ServiceConstants;
import th.co.ais.util.EQueryName;
import th.co.ais.util.WrapperBeanObject;

public class IrClaimServiceImpl extends AbstractService implements IIrClaimService {

	private IrClaimHibernateDAO irClaimDao;
	private IrClaimDetailHibernateDAO irClaimDetailDao;

	public void setIrClaimDao(IrClaimHibernateDAO irClaimDao) {
		this.irClaimDao = irClaimDao;
	}

	public void setIrClaimDetailDao(IrClaimDetailHibernateDAO irClaimDetailDao) {
		this.irClaimDetailDao = irClaimDetailDao;
	}
	
	@Override
	public IrClaim insertIrClaim(IrClaim irClaim, Map<String, WrapperBeanObject<IrClaimDetail>> irClaimDetails) throws Exception {
		IrClaim returnValue = null;
		Session session = irClaimDao.getSessionFactory().getCurrentSession();
		
		try {
			if (session != null) {
				if (irClaim != null) {
					MirGetRunningNo mirGetRunningNo = new MirGetRunningNo();
					mirGetRunningNo.setCompany(null);
					mirGetRunningNo.setRunningType("IR_CLAIM_NO");
					mirGetRunningNo.setLocationCode(irClaim.getLocationCode());
					
					List<MirGetRunningNo> to = irClaimDao.querySPList(EQueryName.SP_MIR_GET_RUNNING_NO.name, mirGetRunningNo);
					if (to != null && !to.isEmpty()) {
						mirGetRunningNo = to.get(0);
						if (mirGetRunningNo != null) {
							irClaim.setClaimNo(mirGetRunningNo.getRunningNo());
							irClaim.setRecordStatus(STATUS_Y);
							
							List<IrClaimDetail> tmpIrClaimDetail = new ArrayList<IrClaimDetail>();
							if (irClaimDetails != null && !irClaimDetails.isEmpty()) {
								for (WrapperBeanObject<IrClaimDetail> wrapIrClaimDetail : irClaimDetails.values()) {
									if (StringUtils.equalsIgnoreCase(wrapIrClaimDetail.getDbQuery(), ServiceConstants.MODULE_ACTION_INSERT)
											|| StringUtils.equalsIgnoreCase(wrapIrClaimDetail.getDbQuery(), ServiceConstants.MODULE_ACTION_UPDATE)) {
										
										IrClaimDetail irClaimDetail = (IrClaimDetail) wrapIrClaimDetail.getDataObj();
										if (irClaimDetail != null) {
											irClaimDetail.setIrClaim(irClaim);
											irClaimDetail.setRecordStatus(STATUS_Y);
											irClaimDetail.setCurrentUser(irClaim.getCurrentUser());
											irClaimDetailDao.injectInfoToDomain(irClaimDetail);
											tmpIrClaimDetail.add(irClaimDetail);
										}
									}
								}
							}
							irClaim.setIrClaimDetails(tmpIrClaimDetail);
							irClaimDao.injectInfoToDomain(irClaim);
							session.saveOrUpdate(irClaim);
							session.flush();
							session.refresh(irClaim);
							
							returnValue = irClaim;
						}
					}	
				}
			}
		} catch (DAOException daoe) {
			irClaim.setClaimNo(null);
			daoe.printStackTrace();
		}
		
		return returnValue;
	}

	@Override
	public IrClaim updateIrClaim(IrClaim irClaim, Map<String, WrapperBeanObject<IrClaimDetail>> irClaimDetails) throws Exception {
		IrClaim returnValue = null;
		Session session = irClaimDao.getSessionFactory().getCurrentSession();
		
		if (session != null) {
			if (irClaim != null) {	
				List<IrClaimDetail> tmpIrClaimDetail = new ArrayList<IrClaimDetail>();
				if (irClaimDetails != null && !irClaimDetails.isEmpty()) {
					for (WrapperBeanObject<IrClaimDetail> wrapIrClaimDetail : irClaimDetails.values()) {
						IrClaimDetail irClaimDetail = (IrClaimDetail) wrapIrClaimDetail.getDataObj();
						if (irClaimDetail != null) {
							if (StringUtils.equalsIgnoreCase(wrapIrClaimDetail.getDbQuery(), ServiceConstants.MODULE_ACTION_DELETE)) {
								irClaimDetail.setRecordStatus(STATUS_N);
							} else {
								irClaimDetail.setRecordStatus(STATUS_Y);
							}
							irClaimDetail.setIrClaim(irClaim);
							irClaimDetail.setCurrentUser(irClaim.getCurrentUser());
							irClaimDetailDao.injectInfoToDomain(irClaimDetail);
							tmpIrClaimDetail.add(irClaimDetail);
						}
					}
				}
				irClaim.setIrClaimDetails(tmpIrClaimDetail);
				irClaimDao.injectInfoToDomain(irClaim);
				session.saveOrUpdate(irClaim);
				session.flush();
				session.refresh(irClaim);
				
				returnValue = irClaim;
			}
		}
		
		return returnValue;
	}
	
	@Override
	public IrClaim deleteIrClaim(IrClaim irClaim) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IrClaim findByPK(String pk) throws Exception {
		return irClaimDao.findByPK(pk);
	}
	
	@Override
	public List querySPList(String spName, Object property) throws Exception {
		return irClaimDao.querySPList(spName, property);
	}

	@Override
	public IrClaim findByPKWithChild(String pk) throws Exception {
		return irClaimDao.findByPKWithChild(pk);
	}

	@Override
	public List<IrClaim> searchByUserLogin(String userLogin) throws Exception {
		return irClaimDao.searchByUserLogin(userLogin);
	}
	
}
