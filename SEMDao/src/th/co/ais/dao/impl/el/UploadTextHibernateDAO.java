package th.co.ais.dao.impl.el;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.el.ElectricFTRateSearch;
import th.co.ais.domain.el.InstallmentSearch7;
import th.co.ais.domain.el.UploadText;

public class UploadTextHibernateDAO extends AbstractHibernateDAO<UploadText>{

	private static final Logger logger 		= Logger.getLogger(UploadTextHibernateDAO.class);
	
	public List<UploadText> queryUploadTextByImportTransactionId(String uploadTextId){
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(UploadText.class);
		criteria.createAlias("textFileId", "textFileIdAlias");
		criteria.add(Restrictions.eq("textFileIdAlias.rowId", uploadTextId));
		
		return criteria.list();
	}
	
	public List<UploadText> queryUploadTextByCriteria(UploadText uploadText){
		if(null==uploadText || null==uploadText.getTextFileId()){
			logger.info("No textFileId");
			return new ArrayList<UploadText>();
		}
		logger.debug("WT###Print uploadText.getTextFileId().getRowId()="+uploadText.getTextFileId().getRowId());		
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(UploadText.class);
		criteria.createAlias("textFileId", "textFileIdAlias", CriteriaSpecification.LEFT_JOIN);
		criteria.createAlias("region", "regionAlias", CriteriaSpecification.LEFT_JOIN);
		criteria.add(Restrictions.eq("textFileIdAlias.rowId", uploadText.getTextFileId().getRowId()));		
		if(null!=uploadText.getRegion()){
			if(null!=uploadText.getRegion().getRowId() && !"".equals(uploadText.getRegion().getRowId())){
				//criteria.createAlias("region", "regionAlias", CriteriaSpecification.LEFT_JOIN);
				logger.debug("WT###Print uploadText.getRegion().getRowId()="+uploadText.getRegion().getRowId());
				criteria.add(Restrictions.eq("regionAlias.rowId", uploadText.getRegion().getRowId()));
			}
		}
		if(null!=uploadText.getPaidFlag() && !"".equals(uploadText.getPaidFlag())){
			logger.debug("WT###Print uploadText.getPaidFlag()="+uploadText.getPaidFlag());
			criteria.add(Restrictions.eq("paidFlag", uploadText.getPaidFlag()));
		}
		if(null!=uploadText.getInvNo() && !"".equals(uploadText.getInvNo())){
			logger.debug("WT###Print uploadText.getInvNo()="+uploadText.getInvNo());
			criteria.add(Restrictions.like("invNo", "%"+uploadText.getInvNo()+"%"));
		}
		if(null!=uploadText.getMeterId() && !"".equals(uploadText.getMeterId())){
			logger.debug("WT###Print uploadText.getMeterId()="+uploadText.getMeterId());
			criteria.add(Restrictions.like("meterId", "%"+uploadText.getMeterId()+"%"));
		}
		if(null!=uploadText.getRecordStatus() && !"".equals(uploadText.getRecordStatus())){
			logger.debug("WT###Print uploadText.getRecordStatus()="+uploadText.getRecordStatus());
			criteria.add(Restrictions.eq("recordStatus", uploadText.getRecordStatus()));
		}
		if(null!=uploadText.getErrorCode() && !"".equals(uploadText.getErrorCode())){
			logger.debug("WT###Print uploadText.getErrorCode()="+uploadText.getErrorCode());
			criteria.add(Restrictions.eq("errorCode", uploadText.getErrorCode()));
		}
		if(null!=uploadText.getClearingFlag() && !"".equals(uploadText.getClearingFlag())){
			logger.debug("WT###Print uploadText.getClearingFlag()="+uploadText.getClearingFlag());
			if(uploadText.getClearingFlag().equalsIgnoreCase("Y")){
				criteria.add(Restrictions.eq("clearingFlag", uploadText.getClearingFlag()));	
			}else{
				
				criteria.add(Restrictions.or(
				             Restrictions.eq( "clearingFlag",uploadText.getClearingFlag() ),
				             Restrictions.isNull("clearingFlag")));

			}
			
		}
		
		if(null!=uploadText.getPaidStatus() && !"".equals(uploadText.getPaidStatus())){
			logger.debug("WT###Print uploadText.getPaidStatus()="+uploadText.getPaidStatus());
			if(uploadText.getPaidStatus().equalsIgnoreCase("Y")){
				criteria.add(Restrictions.eq("paidStatus", uploadText.getPaidStatus()));	
			}else{
				criteria.add(Restrictions.or(
			             Restrictions.eq( "paidStatus",uploadText.getPaidStatus() ),
			             Restrictions.isNull("paidStatus")));
			}
			
			
		}
		if(null!=uploadText.getContractNo() && !"".equals(uploadText.getContractNo())){
			logger.debug("WT###Print uploadText.getContractNo="+uploadText.getContractNo());
			
			criteria.add(Restrictions.eq("contractNo", uploadText.getContractNo()));
		}
		return criteria.list();
	}
	
	public List<UploadText> queryUploadTextError(UploadText uploadText){
		if(null==uploadText || null==uploadText.getTextFileId()){
			return new ArrayList<UploadText>();
		}
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(UploadText.class);
		criteria.createAlias("textFileId", "textFileIdAlias", CriteriaSpecification.LEFT_JOIN);
		criteria.add(Restrictions.eq("textFileIdAlias.rowId", uploadText.getTextFileId().getRowId()));
		
		if(null!=uploadText.getErrorCode() && !"".equals(uploadText.getErrorCode())){
			criteria.add(Restrictions.isNotNull("errorCode"));
		}
		
		return criteria.list();
	}
public List<ElectricFTRateSearch> searchFTRate(ElectricFTRateSearch ftRate) throws DAOException {
		
		Session session = getSessionFactory().getCurrentSession();
		Query q = session.getNamedQuery("queryElectricFTRateSearch");
		 //query="call SEM_PG_EL_VENDOR_PAYEE.SP_REFER_DOC_SRCH(?,:company, :electricUseType,:expenseType, :docNo,:fromDocDt,:toDocDt,:meterId,:fromTermOfPaymentDt,:toTermOfPaymentDt)",   
		
		//System.out.println(" contractNo:" + installment.getContractNo()); 
		
		
		q.setDate("fromTermOfPayment", ftRate.getStartEffectiveDt());
		q.setDate("toTermOfPayment", ftRate.getEndEffectiveDt());
		
		List<ElectricFTRateSearch> returnList = q.list();
		return returnList;
	}
	
}
