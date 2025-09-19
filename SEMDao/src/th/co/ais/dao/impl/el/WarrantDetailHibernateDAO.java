package th.co.ais.dao.impl.el;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.el.Management;
import th.co.ais.domain.el.WarrantDatail;
import th.co.ais.domain.el.WarrantDetailSP;
import th.co.ais.util.BeanUtils;

public class WarrantDetailHibernateDAO extends
		AbstractHibernateDAO<WarrantDatail> {

	private static final Logger LOGGER = Logger.getLogger(WarrantDetailHibernateDAO.class);
	
	@SuppressWarnings("unchecked")
	public List<WarrantDatail> queryByCriteria(WarrantDatail warrantDatail)
			throws DAOException {

		Session session = getSessionFactory().getCurrentSession();

		Criteria criteria = session.createCriteria(WarrantDatail.class);
		if (warrantDatail != null) {
			if (StringUtils.isNotEmpty(warrantDatail.getCompany())) {
				criteria.add(Restrictions.eq("company", warrantDatail.getCompany()));
			}
			if (StringUtils.isNotEmpty(warrantDatail.getContractNo())) {
				criteria.add(Restrictions.eq("contractNo", warrantDatail.getContractNo().toUpperCase()));
			}
			if (StringUtils.isNotEmpty(warrantDatail.getSiteName())) {
				criteria.add(Restrictions.eq("siteName", warrantDatail.getSiteName()));
			}
			if (StringUtils.isNotEmpty(warrantDatail.getLocationId())) {
				criteria.add(Restrictions.eq("locationId", warrantDatail.getLocationId()));
			}
			if (StringUtils.isNotEmpty(warrantDatail.getLocationCode())) {
				criteria.add(Restrictions.eq("locationCode", warrantDatail.getLocationCode()));
			}
			if (StringUtils.isNotEmpty(warrantDatail.getWarrantType())) {
				criteria.add(Restrictions.eq("warrantType", warrantDatail.getWarrantType()));
			}
			if (StringUtils.isNotEmpty(warrantDatail.getExportFlag())) {
				criteria.add(Restrictions.eq("exportFlag", warrantDatail.getExportFlag()));
			}
			if (null != warrantDatail.getPrintDtFrom()
					&& null != warrantDatail.getPrintDtTo()) {
				criteria.add(Restrictions.between("printDt", warrantDatail
						.getPrintDtFrom(), warrantDatail.getPrintDtTo()));
			}
			if (null != warrantDatail.getSentSamuserDtFrom()
					&& null != warrantDatail.getSentSamuserDtTo()) {
				criteria.add(Restrictions.between("sentSamuserDt",
						warrantDatail.getSentSamuserDtFrom(), warrantDatail.getSentSamuserDtTo()));
			}
		}

		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public BigDecimal getMaxPrintTime(Management manage) throws Exception{
		
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(WarrantDatail.class);
		criteria.add(Restrictions.eq("electricId", manage));
		criteria.setProjection(Projections.projectionList().add(Projections.max("printTimes")));
		
		List<BigDecimal> result = criteria.list();
		
		return result != null && result.size() > 0 && result.get(0) != null ? result.get(0) : new BigDecimal("0");
	}
	
	@SuppressWarnings("unchecked")
	public List<WarrantDatail> queryByCriteria(WarrantDatail warrantDatail,String sortBy,String sortType) throws DAOException{
		
		Session session = getSessionFactory().getCurrentSession();
		
		Criteria criteria = session.createCriteria(WarrantDatail.class);
		
		if(warrantDatail != null){
			if(StringUtils.isNotEmpty(warrantDatail.getCompany())){
				criteria.add(Restrictions.eq("company", warrantDatail.getCompany()));
			}
			if(StringUtils.isNotEmpty(warrantDatail.getContractNo())){
				criteria.add(Restrictions.eq("contractNo", warrantDatail.getContractNo().toUpperCase()));
			}
			if(StringUtils.isNotEmpty(warrantDatail.getSiteName())){
				criteria.add(Restrictions.eq("siteName", warrantDatail.getSiteName()));
			}
			if(StringUtils.isNotEmpty(warrantDatail.getLocationId())){
				criteria.add(Restrictions.eq("locationId", warrantDatail.getLocationId()));
			}
			if(StringUtils.isNotEmpty(warrantDatail.getLocationCode())){
				criteria.add(Restrictions.eq("locationCode", warrantDatail.getLocationCode()));
			}
			if(StringUtils.isNotEmpty(warrantDatail.getWarrantType())){
				criteria.add(Restrictions.eq("warrantType", warrantDatail.getWarrantType()));
			}
			if(StringUtils.isNotEmpty(warrantDatail.getExportFlag())){
				criteria.add(Restrictions.eq("exportFlag", warrantDatail.getExportFlag()));
			}
			if(null != warrantDatail.getPrintDtFrom() && null != warrantDatail.getPrintDtTo()){
				criteria.add(Restrictions.between("printDt", warrantDatail.getPrintDtFrom(), warrantDatail.getPrintDtTo()));
			}
			if(null != warrantDatail.getSentSamuserDtFrom() && null != warrantDatail.getSentSamuserDtTo()){
				criteria.add(Restrictions.between("sentSamuserDt", warrantDatail.getSentSamuserDtFrom(), warrantDatail.getSentSamuserDtTo()));
			}
			if(null != warrantDatail.getElectricId()){
				criteria.add(Restrictions.eq("electricId", warrantDatail.getElectricId()));
			}
			
		}
		if("ASC".equalsIgnoreCase(sortType)){
			criteria.addOrder(Order.asc(sortBy));
		}else if("DESC".equalsIgnoreCase(sortType)){
			criteria.addOrder(Order.desc(sortBy));
		}
		
		return criteria.list();
	}
	
	public void updateWarrantDetail(WarrantDatail warranDetail)throws DAOException {
		
		Session session = getSessionFactory().getCurrentSession();
		session.saveOrUpdate(warranDetail);
	}

	@SuppressWarnings("unchecked")
	public List<WarrantDetailSP> queryBySP(WarrantDetailSP warrantDetailSP)
			throws DAOException {
		
		Session session = getSessionFactory().getCurrentSession();			
        Query q = session.getNamedQuery("queryWarrantDetailSP"); 
        LOGGER.debug("queryBySP SQL : "+ q); 
        LOGGER.debug("queryBySP Params");     
        
        LOGGER.debug(" company="+warrantDetailSP.getCompany());
        LOGGER.debug(" region="+warrantDetailSP.getRegion());
        LOGGER.debug(" province="+warrantDetailSP.getProvince());
        LOGGER.debug(" contractNo="+warrantDetailSP.getContractNo());
        LOGGER.debug(" siteName="+warrantDetailSP.getSiteName());
        LOGGER.debug(" locationId="+warrantDetailSP.getLocationId());
        LOGGER.debug(" locationCode="+warrantDetailSP.getLocationCode());
        if((null != warrantDetailSP.getWarrantType()) && (!"ALL".equalsIgnoreCase(warrantDetailSP.getWarrantType()))){
        	LOGGER.debug(" warrantType="+warrantDetailSP.getWarrantType());
        	q.setString("warrantType", warrantDetailSP.getWarrantType()); 
        }else{
        	LOGGER.debug(" warrantType="+null);
        	q.setString("warrantType", null); 
        }        
        if((null != warrantDetailSP.getExportFlag()) && (!"ALL".equalsIgnoreCase(warrantDetailSP.getExportFlag()))){
        	LOGGER.debug(" exportFlag="+warrantDetailSP.getExportFlag());
        	q.setString("exportFlag", warrantDetailSP.getExportFlag()); 
        }else{
        	LOGGER.debug(" exportFlag="+null);
        	q.setString("exportFlag", null);
        }
        LOGGER.debug(" warrantStatus="+warrantDetailSP.getWarrantStatus());
        LOGGER.debug(" printDtFrom="+warrantDetailSP.getPrintDtFrom());
        LOGGER.debug(" printDtTo="+warrantDetailSP.getPrintDtTo());
        LOGGER.debug(" sentSighDtFrom="+warrantDetailSP.getSentSighDtFrom());
        LOGGER.debug(" sentSighDtTo="+warrantDetailSP.getSentSighDtTo());
        LOGGER.debug(" sighDtFrom="+warrantDetailSP.getSighDtFrom());
        LOGGER.debug(" sighDtTo="+warrantDetailSP.getSighDtTo());
        LOGGER.debug(" sentWarrantDtFrom="+warrantDetailSP.getSentWarrantDtFrom());
        LOGGER.debug(" sentWarrantDtTo="+warrantDetailSP.getSentWarrantDtTo());
        LOGGER.debug(" sentContractDtFrom="+warrantDetailSP.getSentContractDtFrom());
        LOGGER.debug(" sentContractDtTo="+warrantDetailSP.getSentContractDtTo());
        LOGGER.debug(" sentSamuserDtFrom="+warrantDetailSP.getSentSamuserDtFrom());
        LOGGER.debug(" sentSamuserDtTo="+warrantDetailSP.getSentSamuserDtTo());
        LOGGER.debug(" compleateDtFrom="+warrantDetailSP.getCompleateDtFrom());
        LOGGER.debug(" compleateDtTo="+warrantDetailSP.getCompleateDtTo());
        LOGGER.debug(" exportDtFrom="+warrantDetailSP.getExportDtFrom());
        LOGGER.debug(" exportDtTo="+warrantDetailSP.getExportDtTo());        
        LOGGER.debug(" maxPrintTimesFlag="+warrantDetailSP.getMaxPrintTimesFlag());
        
        q.setString("company", warrantDetailSP.getCompany()); 
        q.setString("region", warrantDetailSP.getRegion());
        q.setString("province", warrantDetailSP.getProvince());
        if(warrantDetailSP.getContractNo()==null){
        	q.setString("contractNo", warrantDetailSP.getContractNo());
        }else{
        	q.setString("contractNo", warrantDetailSP.getContractNo().toUpperCase());
        }
        q.setString("siteName", warrantDetailSP.getSiteName()); 
        q.setString("locationId", warrantDetailSP.getLocationId()); 
        q.setString("locationCode", warrantDetailSP.getLocationCode()); 
        if((null != warrantDetailSP.getWarrantType()) && (!"ALL".equalsIgnoreCase(warrantDetailSP.getWarrantType()))){
        	q.setString("warrantType", warrantDetailSP.getWarrantType()); 
        }else{
        	q.setString("warrantType", null); 
        }
        if((null != warrantDetailSP.getExportFlag()) && (!"ALL".equalsIgnoreCase(warrantDetailSP.getExportFlag()))){
        	q.setString("exportFlag", warrantDetailSP.getExportFlag()); 
        }else{
        	q.setString("exportFlag", null);
        }
        q.setString("warrantStatus", warrantDetailSP.getWarrantStatus());
        q.setTimestamp("printDtFrom", warrantDetailSP.getPrintDtFrom()); 
        q.setTimestamp("printDtTo", warrantDetailSP.getPrintDtTo()); 
//        q.setTimestamp("sentSighDtFrom", warrantDetailSP.getSentSighDtFrom()); 
//        q.setTimestamp("sentSighDtTo", warrantDetailSP.getSentSighDtTo());
        q.setTimestamp("sighDtFrom", warrantDetailSP.getSighDtFrom()); 
        q.setTimestamp("sighDtTo", warrantDetailSP.getSighDtTo()); 
        q.setTimestamp("sentWarrantDtFrom", warrantDetailSP.getSentWarrantDtFrom()); 
        q.setTimestamp("sentWarrantDtTo", warrantDetailSP.getSentWarrantDtTo()); 
        q.setTimestamp("sentContractDtFrom", warrantDetailSP.getSentContractDtFrom()); 
        q.setTimestamp("sentContractDtTo", warrantDetailSP.getSentContractDtTo());        
//        q.setTimestamp("sentSamuserDtFrom", warrantDetailSP.getSentSamuserDtFrom()); 
//        q.setTimestamp("sentSamuserDtTo", warrantDetailSP.getSentSamuserDtTo());
        q.setTimestamp("exportDtFrom", warrantDetailSP.getExportDtFrom());
        q.setTimestamp("exportDtTo", warrantDetailSP.getExportDtTo());
        q.setTimestamp("compleateDtFrom", warrantDetailSP.getCompleateDtFrom());
        q.setTimestamp("compleateDtTo", warrantDetailSP.getCompleateDtTo());
        q.setString("maxPrintTimesFlag", warrantDetailSP.getMaxPrintTimesFlag());
        q.setString("batchNo", warrantDetailSP.getBatchNo());
        q.setString("supplier", warrantDetailSP.getSupplier());
        List<WarrantDetailSP> returnList = q.list();
        
        LOGGER.info(" returnList.size:"+ returnList.size());
        
        return returnList; 
	}

	public void pdateWarrantDetailExport(List<WarrantDatail> warrantDetailList) {
		LOGGER.info("pdateWarrantDetailExport() warrantDetailList size : "+ warrantDetailList.size());
		Session session = getSessionFactory().getCurrentSession();
		for (WarrantDatail obj : warrantDetailList) {
			WarrantDatail oldObj = (WarrantDatail) session.get(WarrantDatail.class, obj.getRowId());
			oldObj.setRowId(obj.getRowId());
			oldObj.setExportFlag(obj.getExportFlag());
			oldObj.setExportDt(obj.getExportDt());
			oldObj.setSelected(obj.isSelected());
			oldObj.setElectricId(obj.getElectricId());
			oldObj.setPrintTimes(obj.getPrintTimes());
			oldObj.setUpdateDt(obj.getUpdateDt());
			oldObj.setUpdateBy(obj.getUpdateBy());
			
			session.update(oldObj);
		}
	}
}
