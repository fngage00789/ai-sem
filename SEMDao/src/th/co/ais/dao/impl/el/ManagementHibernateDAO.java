package th.co.ais.dao.impl.el;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import th.co.ais.dao.AbstractHibernateDAO;
import th.co.ais.dao.exception.DAOException;
import th.co.ais.domain.common.CommonUtils;
import th.co.ais.domain.el.Management;
import th.co.ais.domain.el.ManagementSO;
import th.co.ais.domain.el.MeterInfo;
import th.co.ais.domain.el.PaymentSearch;
import th.co.ais.domain.el.PopupSiteSearch;
import th.co.ais.domain.el.PopupSiteSearchPrivate;
import th.co.ais.util.BeanUtils;

public class ManagementHibernateDAO extends AbstractHibernateDAO<Management>{
	
	Logger logger = Logger.getLogger(ManagementHibernateDAO.class);
	
	@SuppressWarnings("unchecked")
	public List<Management> queryByCriteria(Management management) throws DAOException{
		
		Session session = getSessionFactory().getCurrentSession();
		
		Criteria criteria = session.createCriteria(Management.class);
		
		//criteria = criteria.createCriteria("meterInfos");
		if(management != null){			
			if(StringUtils.isNotEmpty(management.getCompany())){
				criteria.add(Restrictions.eq("company", management.getCompany()));
			}
			if(StringUtils.isNotEmpty(management.getContractNo())){
				criteria.add(Restrictions.like("contractNo", management.getContractNo().toUpperCase()));
			}
			if(StringUtils.isNotEmpty(management.getSiteName())){
				criteria.add(Restrictions.like("siteName", management.getSiteName()));
			}
			if(StringUtils.isNotEmpty(management.getElectricUseType())){
				criteria.add(Restrictions.like("electricUseType", management.getElectricUseType()));
			}
			if(StringUtils.isNotEmpty(management.getLocationId())){
				criteria.add(Restrictions.like("locationId", management.getLocationId()));
			}
			if(StringUtils.isNotEmpty(management.getLocationCode())){
				criteria.add(Restrictions.like("locationCode", management.getLocationCode()));
			}
			if(StringUtils.isNotEmpty(management.getRecordStatus())){
				criteria.add(Restrictions.like("recordStatus", management.getRecordStatus()));
			}
		}
		return criteria.list();
	}
	
	public Management findByRowId(final String rowId) throws DAOException{
		
		getHibernateTemplate().setCacheQueries(true);
		
		return querySingleByHQL("select distinct manage from Management manage where manage.rowId = ? ", rowId);
	}
	
	@SuppressWarnings("unchecked")
	public List<Management> queryManagement(final Management manage) throws DAOException {
		
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Management.class);
		
		if(manage != null){
			if(StringUtils.isNotEmpty(manage.getCompany())) criteria.add(Restrictions.eq("company", manage.getCompany()));
			if(StringUtils.isNotEmpty(manage.getContractNo())) criteria.add(Restrictions.like("contractNo", "%" + manage.getContractNo().toUpperCase() + "%"));
			if(StringUtils.isNotEmpty(manage.getRegion())) criteria.add(Restrictions.eq("region", manage.getRegion()));
			if(StringUtils.isNotEmpty(manage.getProvince())) criteria.add(Restrictions.eq("province", manage.getProvince()));
			if(StringUtils.isNotEmpty(manage.getSiteName())) criteria.add(Restrictions.like("siteName", "%" + manage.getSiteName() + "%"));
			if(StringUtils.isNotEmpty(manage.getSiteStatus())) criteria.add(Restrictions.eq("siteStatus", manage.getSiteStatus()));
			if(StringUtils.isNotEmpty(manage.getElectricUseType())) criteria.add(Restrictions.eq("electricUseType", manage.getElectricUseType()));
			if(StringUtils.isNotEmpty(manage.getLocationId())) criteria.add(Restrictions.like("locationId", "%" + manage.getLocationId() + "%"));
			if(StringUtils.isNotEmpty(manage.getLocationCode())) criteria.add(Restrictions.like("locationCode", "%" + manage.getLocationCode() + "%"));
			if(StringUtils.isNotEmpty(manage.getProcessStatusCode())) criteria.add(Restrictions.eq("processStatusCode", manage.getProcessStatusCode()));
			if(StringUtils.isNotEmpty(manage.getOwnerName())) criteria.add(Restrictions.like("ownerName", "%" + manage.getOwnerName() + "%"));
			if(StringUtils.isNotEmpty(manage.getLessorName())) criteria.add(Restrictions.like("lessorName", "%" + manage.getLessorName() + "%"));
			if(manage.getTransferReceivedDt() != null){
				
				Criterion between = Restrictions.between("transferReceivedDt", getFromDate(manage.getTransferReceivedDt()), getToDate(manage.getTransferReceivedDt()));
				Criterion equal = Restrictions.eq("transferReceivedDt", manage.getTransferReceivedDt());
				
				LogicalExpression orExp = Restrictions.or(between, equal);
				criteria.add(orExp);
			}
			if(manage.getNewReceivedDt() != null){
				
				Criterion between = Restrictions.between("newReceivedDt", getFromDate(manage.getNewReceivedDt()), getToDate(manage.getNewReceivedDt()));
				Criterion equal = Restrictions.eq("newReceivedDt", manage.getNewReceivedDt());
				
				LogicalExpression orExp = Restrictions.or(between, equal);
				
				criteria.add(orExp);
			}
			if(manage.getTerminateReceivedDt() != null){
				
				Criterion between = Restrictions.between("terminateReceivedDt", getFromDate(manage.getTerminateReceivedDt()), getToDate(manage.getTerminateReceivedDt()));
				Criterion equal = Restrictions.eq("terminateReceivedDt", manage.getTerminateReceivedDt());
				
				LogicalExpression orExp = Restrictions.or(between, equal);
				
				criteria.add(orExp);
			}
			if(manage.getTransferCutoffDt() != null){
				
				Criterion between = Restrictions.between("transferCutoffDt", getFromDate(manage.getTransferCutoffDt()), getToDate(manage.getTransferCutoffDt()));
				Criterion equal = Restrictions.eq("transferCutoffDt", manage.getTransferCutoffDt());
				
				LogicalExpression orExp = Restrictions.or(between, equal);
				
				criteria.add(orExp);
			}
			
		}

		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		criteria.addOrder(Order.asc("contractNo"));
		
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Management> queryManagementIncludeSiteAddress(final Management manage) throws DAOException {
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Management.class);
		//Criteria childCriteria = criteria.createCriteria("bgMapContract", Criteria.LEFT_JOIN);
		//criteria.createAlias("bgMapContract", "c", CriteriaSpecification.LEFT_JOIN).setFetchMode("c", FetchMode.JOIN).add(Restrictions.eq("c.recordStatus", "Y")); 
		try{
			if(manage != null){			
				
				//childCriteria.add(Restrictions.eq("recordStatus", "Y"));
				
				if(StringUtils.isNotEmpty(manage.getCompany())) criteria.add(Restrictions.eq("company", manage.getCompany()));
				if(StringUtils.isNotEmpty(manage.getContractNo())) criteria.add(Restrictions.like("contractNo", CommonUtils.convertString4FullTxtSrch(manage.getContractNo().toUpperCase())));
				if(StringUtils.isNotEmpty(manage.getRegion())) criteria.add(Restrictions.eq("region", manage.getRegion()));
				if(StringUtils.isNotEmpty(manage.getProvince())) criteria.add(Restrictions.eq("province", manage.getProvince()));
				if(StringUtils.isNotEmpty(manage.getSiteName())) criteria.add(Restrictions.like("siteName",CommonUtils.convertString4FullTxtSrch(manage.getSiteName())));
				if(StringUtils.isNotEmpty(manage.getSiteStatus())) criteria.add(Restrictions.eq("siteStatus", manage.getSiteStatus()));
				if(StringUtils.isNotEmpty(manage.getElectricUseType())) criteria.add(Restrictions.eq("electricUseType", manage.getElectricUseType()));
				if(StringUtils.isNotEmpty(manage.getLocationId())) criteria.add(Restrictions.like("locationId", CommonUtils.convertString4FullTxtSrch(manage.getLocationId())));
				if(StringUtils.isNotEmpty(manage.getLocationCode())) criteria.add(Restrictions.like("locationCode", CommonUtils.convertString4FullTxtSrch(manage.getLocationCode())));
				if(StringUtils.isNotEmpty(manage.getProcessStatusCode())) criteria.add(Restrictions.eq("processStatusCode", manage.getProcessStatusCode()));
				if(StringUtils.isNotEmpty(manage.getOwnerName())) criteria.add(Restrictions.like("ownerName", CommonUtils.convertString4FullTxtSrch(manage.getOwnerName())));
				if(StringUtils.isNotEmpty(manage.getLessorName())) criteria.add(Restrictions.like("lessorName", CommonUtils.convertString4FullTxtSrch(manage.getLessorName())));
				if(StringUtils.isNotEmpty(manage.getRecordStatus())) criteria.add(Restrictions.eq("recordStatus", manage.getRecordStatus()));
				if(StringUtils.isNotEmpty(manage.getZone())) criteria.add(Restrictions.eq("zone", manage.getZone()));
				if(manage.getTransferReceivedDt() != null){
					
					Criterion between = Restrictions.between("transferReceivedDt", getFromDate(manage.getTransferReceivedDt()), getToDate(manage.getTransferReceivedDt()));
					Criterion equal = Restrictions.eq("transferReceivedDt", manage.getTransferReceivedDt());
					
					LogicalExpression orExp = Restrictions.or(between, equal);
					criteria.add(orExp);
				}
				if(manage.getNewReceivedDt() != null){
					
					Criterion between = Restrictions.between("newReceivedDt", getFromDate(manage.getNewReceivedDt()), getToDate(manage.getNewReceivedDt()));
					Criterion equal = Restrictions.eq("newReceivedDt", manage.getNewReceivedDt());
					
					LogicalExpression orExp = Restrictions.or(between, equal);
					
					criteria.add(orExp);
				}
				if(manage.getTerminateReceivedDt() != null){
					
					Criterion between = Restrictions.between("terminateReceivedDt", getFromDate(manage.getTerminateReceivedDt()), getToDate(manage.getTerminateReceivedDt()));
					Criterion equal = Restrictions.eq("terminateReceivedDt", manage.getTerminateReceivedDt());
					
					LogicalExpression orExp = Restrictions.or(between, equal);
					
					criteria.add(orExp);
				}
				if(manage.getTransferCutoffDt() != null){
					
					Criterion between = Restrictions.between("transferCutoffDt", getFromDate(manage.getTransferCutoffDt()), getToDate(manage.getTransferCutoffDt()));
					Criterion equal = Restrictions.eq("transferCutoffDt", manage.getTransferCutoffDt());
					
					LogicalExpression orExp = Restrictions.or(between, equal);
					
					criteria.add(orExp);
				}
				//WT###Add
				if(StringUtils.isNotEmpty(manage.getSiteHouseNo())){				
					criteria.add(Restrictions.disjunction().
							add(Restrictions.like("siteHouseNo", CommonUtils.convertString4FullTxtSrch(manage.getSiteHouseNo()))).
							add(Restrictions.like("siteLandNo", CommonUtils.convertString4FullTxtSrch(manage.getSiteHouseNo()))).
							add(Restrictions.like("siteRoomNo", CommonUtils.convertString4FullTxtSrch(manage.getSiteHouseNo()))));
				}
				if(StringUtils.isNotEmpty(manage.getSiteBuilding())){
					criteria.add(Restrictions.like("siteBuilding", CommonUtils.convertString4FullTxtSrch(manage.getSiteBuilding())));
				}
				if(StringUtils.isNotEmpty(manage.getSiteStreet())){
					criteria.add(Restrictions.like("siteStreet", CommonUtils.convertString4FullTxtSrch(manage.getSiteStreet())));
				}
				if(StringUtils.isNotEmpty(manage.getSiteTumbon())){
					criteria.add(Restrictions.like("siteTumbon", CommonUtils.convertString4FullTxtSrch(manage.getSiteTumbon())));
				}
				if(StringUtils.isNotEmpty(manage.getSiteAmphur())){
					criteria.add(Restrictions.like("siteAmphur", CommonUtils.convertString4FullTxtSrch(manage.getSiteAmphur())));
				}			
				if(StringUtils.isNotEmpty(manage.getMeterId())){
					criteria.createAlias("meterInfos", "meterInfosAlias", Criteria.LEFT_JOIN);
					criteria.add(Restrictions.like("meterInfosAlias.meterId", CommonUtils.convertString4FullTxtSrch(manage.getMeterId())));
				}				
				if(null!=manage.getNewReceivedDtFrom()){
					/*Criterion between = Restrictions.between("newReceivedDt", getFromDate(manage.getNewReceivedDtFrom()), getToDate(manage.getNewReceivedDtTo()));
					Criterion equal = Restrictions.eq("newReceivedDt", manage.getNewReceivedDt());
					LogicalExpression orExp = Restrictions.or(between, equal);*/
					Criterion ge = Restrictions.ge("newReceivedDt", getFromDate(manage.getNewReceivedDtFrom()));
					Criterion le = Restrictions.le("newReceivedDt", getToDate(manage.getNewReceivedDtTo()));
					//LogicalExpression orExp = Restrictions.and(ge, le);
					criteria.add(ge);
					criteria.add(le);
				}
				if(null!=manage.getTerminateReceivedDtFrom()){
					/*Criterion between = Restrictions.between("terminateReceivedDt", getFromDate(manage.getTerminateReceivedDtFrom()), getToDate(manage.getTerminateReceivedDtTo()));
					Criterion equal = Restrictions.eq("terminateReceivedDt", manage.getTerminateReceivedDt());
					LogicalExpression orExp = Restrictions.or(between, equal);*/
					Criterion ge = Restrictions.ge("terminateReceivedDt", getFromDate(manage.getTerminateReceivedDtFrom()));
					Criterion le = Restrictions.le("terminateReceivedDt", getToDate(manage.getTerminateReceivedDtTo()));
					//LogicalExpression orExp = Restrictions.and(ge, le);
					criteria.add(ge);
					criteria.add(le);
				}
				if(null!=manage.getTransferReceivedDtFrom()){
					/*Criterion between = Restrictions.between("transferReceivedDt", getFromDate(manage.getTransferReceivedDtFrom()), getToDate(manage.getTransferReceivedDtTo()));
					Criterion equal = Restrictions.eq("transferReceivedDt", manage.getTransferReceivedDt());
					LogicalExpression orExp = Restrictions.or(between, equal);*/
					Criterion ge = Restrictions.ge("transferReceivedDt", getFromDate(manage.getTransferReceivedDtFrom()));
					Criterion le = Restrictions.le("transferReceivedDt", getToDate(manage.getTransferReceivedDtTo()));
					//LogicalExpression orExp = Restrictions.and(ge, le);
					criteria.add(ge);
					criteria.add(le);
				}
				if(null!=manage.getTerminateCutoffDtFrom()){
					Criterion ge = Restrictions.ge("terminateCutoffDt", getFromDate(manage.getTerminateCutoffDtFrom()));
					Criterion le = Restrictions.le("terminateCutoffDt", getToDate(manage.getTerminateCutoffDtTo()));
					//LogicalExpression orExp = Restrictions.and(ge, le);
					criteria.add(ge);
					criteria.add(le);
				}
				if(null!=manage.getTransferCutoffDtFrom()){
					/*Criterion between = Restrictions.between("transferCutoffDt", getFromDate(manage.getTransferCutoffDtFrom()), getToDate(manage.getTransferCutoffDtTo()));
					Criterion equal = Restrictions.eq("transferCutoffDt", manage.getTransferCutoffDt());
					LogicalExpression orExp = Restrictions.or(between, equal);*/
					Criterion ge = Restrictions.ge("transferCutoffDt", getFromDate(manage.getTransferCutoffDtFrom()));
					Criterion le = Restrictions.le("transferCutoffDt", getToDate(manage.getTransferCutoffDtTo()));
					//LogicalExpression orExp = Restrictions.and(ge, le);
					criteria.add(ge);
					criteria.add(le);
				}
				if(null!=manage.getExpandOldCutoffDtFrom()){
					/*Criterion between = Restrictions.between("expandOldCutoffDtFrom", getFromDate(manage.getExpandOldCutoffDtFrom()), getToDate(manage.getExpandOldCutoffDtTo()));
					Criterion equal = Restrictions.eq("expandOldCutoffDtFrom", manage.getExpandOldCutoffDt());
					LogicalExpression orExp = Restrictions.or(between, equal);*/
					Criterion ge = Restrictions.ge("expandOldCutoffDt", getFromDate(manage.getExpandOldCutoffDtFrom()));
					Criterion le = Restrictions.le("expandOldCutoffDt", getToDate(manage.getExpandOldCutoffDtTo()));
					//LogicalExpression orExp = Restrictions.and(ge, le);
					criteria.add(ge);
					criteria.add(le);
				}
				if(null!=manage.getContractStartDtTo()){
					Criterion ge = Restrictions.le("contractStartDt", getFromDate(manage.getContractStartDtTo()));
					criteria.add(ge);
				}
				
				if(null!=manage.getContractStartDtTo()){
					Criterion ge = Restrictions.le("contractStartDt", getFromDate(manage.getContractStartDtTo()));
					criteria.add(ge);
				}
				//WT###Add End
				
				if(manage.isRenewFlag()){
					Criterion ge = Restrictions.ge("renewNo",new BigDecimal(1));
					criteria.add(ge);
				}
				else{
					if(null == manage.getElAction() || manage.getElAction().equalsIgnoreCase("")){
						Criterion ge = Restrictions.eq("renewNo",new BigDecimal(0));
						Criterion ge1 = Restrictions.ge("renewNo",new BigDecimal(1));
						LogicalExpression orExp = Restrictions.or(ge, ge1);
						criteria.add(orExp);
					}
					else if (manage.getElAction().equalsIgnoreCase("RENEW")
							 && manage.getProcessStatusCode().equalsIgnoreCase("300701")){
						    Criterion ge = Restrictions.ge("renewNo",new BigDecimal(1));
						    criteria.add(ge);
					}
					else{
						Criterion ge = Restrictions.eq("renewNo",new BigDecimal(0));
						criteria.add(ge);
					}
				}
			}
	        
			if(null!=manage.getPrintDT()){
				//Criterion between = Restrictions.between("newReceivedDt", getFromDate(manage.getNewReceivedDtFrom()), getToDate(manage.getNewReceivedDtTo()));
				//Criterion equal = Restrictions.eq("newReceivedDt", manage.getNewReceivedDt());
				//LogicalExpression orExp = Restrictions.or(between, equal);
				//Criterion ge = Restrictions.eq("transferPrintDt", getFromDate(manage.getPrintDT()));
				//Criterion ge = Restrictions.ge("expandOldCutoffDt", getFromDate(manage.getExpandOldCutoffDtFrom()));
				//Criterion le = Restrictions.le("expandOldCutoffDt", getToDate(manage.getExpandOldCutoffDtTo()));
				//LogicalExpression orExp = Restrictions.and(ge, le);
				//criteria.add(ge);
				criteria.add(Restrictions.or(
						//Restrictions.sqlRestriction("trunc(TRANSFER_PRINT_DT) = trunc(?)",manage.getPrintDT(),Hibernate.DATE),
						//Restrictions.sqlRestriction("trunc(TERMINATE_PRINT_DT) = trunc(?)",manage.getPrintDT(),Hibernate.DATE)
						Restrictions.sqlRestriction("cast(TRANSFER_PRINT_DT as date) = cast(? as date)",manage.getPrintDT(),Hibernate.DATE),
						Restrictions.sqlRestriction("cast(TERMINATE_PRINT_DT as date) = cast(? as date)",manage.getPrintDT(),Hibernate.DATE)
						));
				
			}
			
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			criteria.addOrder(Order.asc("contractNo"));
		
			return criteria.setMaxResults(500).list();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<ManagementSO> queryManagementIncludeSiteAddressSO(final Management manage) throws DAOException {
		getSessionFactory().getCurrentSession().enableFilter(ManagementSO.METERINFO_FILTER);
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(ManagementSO.class);
		
		if(manage != null){			
			if(StringUtils.isNotEmpty(manage.getCompany())) criteria.add(Restrictions.eq("company", manage.getCompany()));
			if(StringUtils.isNotEmpty(manage.getContractNo())) criteria.add(Restrictions.eq("contractNo",manage.getContractNo().toUpperCase()));
			if(StringUtils.isNotEmpty(manage.getRegion())) criteria.add(Restrictions.eq("region", manage.getRegion()));
			if(StringUtils.isNotEmpty(manage.getProvince())) criteria.add(Restrictions.eq("province", manage.getProvince()));
			if(StringUtils.isNotEmpty(manage.getSiteName())) criteria.add(Restrictions.like("siteName", "%" + manage.getSiteName() + "%"));
			if(StringUtils.isNotEmpty(manage.getSiteStatus())) criteria.add(Restrictions.eq("siteStatus", manage.getSiteStatus()));
			
			if(StringUtils.isNotEmpty(manage.getElectricUseType())){
				
				if(manage.getElectricUseType().equalsIgnoreCase("MEA/PEA")){
					criteria.add( Restrictions.in( "electricUseType", new String[] { "MEA", "PEA" }));

					
				}else{
					criteria.add(Restrictions.eq("electricUseType", manage.getElectricUseType()));
					
				}
					
			}
			if(StringUtils.isNotEmpty(manage.getLocationId())) criteria.add(Restrictions.like("locationId", "%" + manage.getLocationId() + "%"));
			if(StringUtils.isNotEmpty(manage.getLocationCode())) criteria.add(Restrictions.like("locationCode", "%" + manage.getLocationCode() + "%"));
			if(StringUtils.isNotEmpty(manage.getProcessStatusCode())){
				
				if(manage.getElectricUseType().equalsIgnoreCase("MEA/PEA")){
				    String peaStatusCode = manage.getProcessStatusCode().replaceFirst("1", "2");
				    System.out.println("XXXXXXXXXXXXXXXXXXX meaStatusCode: "+ manage.getProcessStatusCode());
				    System.out.println("XXXXXXXXXXXXXXXXXXX peaStatusCode: "+ peaStatusCode);
				    
				    criteria.add( Restrictions.in( "processStatusCode", new String[] { manage.getProcessStatusCode(), peaStatusCode  }));
					
				}else{
					criteria.add(Restrictions.eq("processStatusCode", manage.getProcessStatusCode()));
					
				}
			}
			
			if(StringUtils.isNotEmpty(manage.getOwnerName())) criteria.add(Restrictions.like("ownerName", "%" + manage.getOwnerName() + "%"));
			if(StringUtils.isNotEmpty(manage.getLessorName())) criteria.add(Restrictions.like("lessorName", "%" + manage.getLessorName() + "%"));
			if(StringUtils.isNotEmpty(manage.getRecordStatus())) criteria.add(Restrictions.eq("recordStatus", manage.getRecordStatus()));
			if(StringUtils.isNotEmpty(manage.getZone())) criteria.add(Restrictions.eq("zone", manage.getZone()));
			
			if(StringUtils.isNotEmpty(manage.getVendorName())){
				criteria.add(Restrictions.like("vendorName", "%" + manage.getVendorName() + "%"));
			}			
			if(StringUtils.isNotEmpty(manage.getPayeeName())){
				criteria.add(Restrictions.like("payeeName", "%" + manage.getPayeeName() + "%"));
			}
			if(manage.getTransferReceivedDt() != null){
				
				Criterion between = Restrictions.between("transferReceivedDt", getFromDate(manage.getTransferReceivedDt()), getToDate(manage.getTransferReceivedDt()));
				Criterion equal = Restrictions.eq("transferReceivedDt", manage.getTransferReceivedDt());
				
				LogicalExpression orExp = Restrictions.or(between, equal);
				criteria.add(orExp);
			}
			if(manage.getNewReceivedDt() != null){
				
				Criterion between = Restrictions.between("newReceivedDt", getFromDate(manage.getNewReceivedDt()), getToDate(manage.getNewReceivedDt()));
				Criterion equal = Restrictions.eq("newReceivedDt", manage.getNewReceivedDt());
				
				LogicalExpression orExp = Restrictions.or(between, equal);
				
				criteria.add(orExp);
			}
			if(manage.getTerminateReceivedDt() != null){
				
				Criterion between = Restrictions.between("terminateReceivedDt", getFromDate(manage.getTerminateReceivedDt()), getToDate(manage.getTerminateReceivedDt()));
				Criterion equal = Restrictions.eq("terminateReceivedDt", manage.getTerminateReceivedDt());
				
				LogicalExpression orExp = Restrictions.or(between, equal);
				
				criteria.add(orExp);
			}
			if(manage.getTransferCutoffDt() != null){
				
				Criterion between = Restrictions.between("transferCutoffDt", getFromDate(manage.getTransferCutoffDt()), getToDate(manage.getTransferCutoffDt()));
				Criterion equal = Restrictions.eq("transferCutoffDt", manage.getTransferCutoffDt());
				
				LogicalExpression orExp = Restrictions.or(between, equal);
				
				criteria.add(orExp);
			}
			//WT###Add
			if(StringUtils.isNotEmpty(manage.getSiteHouseNo())){				
				criteria.add(Restrictions.disjunction().
						add(Restrictions.like("siteHouseNo", "%" + manage.getSiteHouseNo() + "%")).
						add(Restrictions.like("siteLandNo", "%" + manage.getSiteHouseNo() + "%")).
						add(Restrictions.like("siteRoomNo", "%" + manage.getSiteHouseNo() + "%")));
			}
			if(StringUtils.isNotEmpty(manage.getSiteBuilding())){
				criteria.add(Restrictions.like("siteBuilding", "%" + manage.getSiteBuilding() + "%"));
			}
			if(StringUtils.isNotEmpty(manage.getSiteStreet())){
				criteria.add(Restrictions.like("siteStreet", "%" + manage.getSiteStreet() + "%"));
			}
			if(StringUtils.isNotEmpty(manage.getSiteTumbon())){
				criteria.add(Restrictions.like("siteTumbon", "%" + manage.getSiteTumbon() + "%"));
			}
			if(StringUtils.isNotEmpty(manage.getSiteAmphur())){
				criteria.add(Restrictions.like("siteAmphur", "%" + manage.getSiteAmphur() + "%"));
			}			
			if(StringUtils.isNotEmpty(manage.getMeterId())){
				criteria.createAlias("meterInfos", "meterInfosAlias", Criteria.LEFT_JOIN);
				criteria.add(Restrictions.like("meterInfosAlias.meterId", "%"+manage.getMeterId()+"%"));
			}				
			if(null!=manage.getNewReceivedDtFrom()){
				/*Criterion between = Restrictions.between("newReceivedDt", getFromDate(manage.getNewReceivedDtFrom()), getToDate(manage.getNewReceivedDtTo()));
				Criterion equal = Restrictions.eq("newReceivedDt", manage.getNewReceivedDt());
				LogicalExpression orExp = Restrictions.or(between, equal);*/
				Criterion ge = Restrictions.ge("newReceivedDt", getFromDate(manage.getNewReceivedDtFrom()));
				Criterion le = Restrictions.le("newReceivedDt", getToDate(manage.getNewReceivedDtTo()));
				//LogicalExpression orExp = Restrictions.and(ge, le);
				criteria.add(ge);
				criteria.add(le);
			}
			if(null!=manage.getTerminateReceivedDtFrom()){
				/*Criterion between = Restrictions.between("terminateReceivedDt", getFromDate(manage.getTerminateReceivedDtFrom()), getToDate(manage.getTerminateReceivedDtTo()));
				Criterion equal = Restrictions.eq("terminateReceivedDt", manage.getTerminateReceivedDt());
				LogicalExpression orExp = Restrictions.or(between, equal);*/
				Criterion ge = Restrictions.ge("terminateReceivedDt", getFromDate(manage.getTerminateReceivedDtFrom()));
				Criterion le = Restrictions.le("terminateReceivedDt", getToDate(manage.getTerminateReceivedDtTo()));
				//LogicalExpression orExp = Restrictions.and(ge, le);
				criteria.add(ge);
				criteria.add(le);
			}
			if(null!=manage.getTransferReceivedDtFrom()){
				/*Criterion between = Restrictions.between("transferReceivedDt", getFromDate(manage.getTransferReceivedDtFrom()), getToDate(manage.getTransferReceivedDtTo()));
				Criterion equal = Restrictions.eq("transferReceivedDt", manage.getTransferReceivedDt());
				LogicalExpression orExp = Restrictions.or(between, equal);*/
				Criterion ge = Restrictions.ge("transferReceivedDt", getFromDate(manage.getTransferReceivedDtFrom()));
				Criterion le = Restrictions.le("transferReceivedDt", getToDate(manage.getTransferReceivedDtTo()));
				//LogicalExpression orExp = Restrictions.and(ge, le);
				criteria.add(ge);
				criteria.add(le);
			}
			if(null!=manage.getTerminateCutoffDtFrom()){
				Criterion ge = Restrictions.ge("terminateCutoffDt", getFromDate(manage.getTerminateCutoffDtFrom()));
				Criterion le = Restrictions.le("terminateCutoffDt", getToDate(manage.getTerminateCutoffDtTo()));
				//LogicalExpression orExp = Restrictions.and(ge, le);
				criteria.add(ge);
				criteria.add(le);
			}
			if(null!=manage.getTransferCutoffDtFrom()){
				/*Criterion between = Restrictions.between("transferCutoffDt", getFromDate(manage.getTransferCutoffDtFrom()), getToDate(manage.getTransferCutoffDtTo()));
				Criterion equal = Restrictions.eq("transferCutoffDt", manage.getTransferCutoffDt());
				LogicalExpression orExp = Restrictions.or(between, equal);*/
				Criterion ge = Restrictions.ge("transferCutoffDt", getFromDate(manage.getTransferCutoffDtFrom()));
				Criterion le = Restrictions.le("transferCutoffDt", getToDate(manage.getTransferCutoffDtTo()));
				//LogicalExpression orExp = Restrictions.and(ge, le);
				criteria.add(ge);
				criteria.add(le);
			}
			if(null!=manage.getExpandOldCutoffDtFrom()){
				/*Criterion between = Restrictions.between("expandOldCutoffDtFrom", getFromDate(manage.getExpandOldCutoffDtFrom()), getToDate(manage.getExpandOldCutoffDtTo()));
				Criterion equal = Restrictions.eq("expandOldCutoffDtFrom", manage.getExpandOldCutoffDt());
				LogicalExpression orExp = Restrictions.or(between, equal);*/
				Criterion ge = Restrictions.ge("expandOldCutoffDt", getFromDate(manage.getExpandOldCutoffDtFrom()));
				Criterion le = Restrictions.le("expandOldCutoffDt", getToDate(manage.getExpandOldCutoffDtTo()));
				//LogicalExpression orExp = Restrictions.and(ge, le);
				criteria.add(ge);
				criteria.add(le);
			}
			if(null!=manage.getContractStartDtTo()){
				Criterion ge = Restrictions.le("contractStartDt", getFromDate(manage.getContractStartDtTo()));
				criteria.add(ge);
			}
			
			if(null!=manage.getContractStartDtTo()){
				Criterion ge = Restrictions.le("contractStartDt", getFromDate(manage.getContractStartDtTo()));
				criteria.add(ge);
			}
			//WT###Add End
			
			if(manage.isRenewFlag()){
				Criterion ge = Restrictions.ge("renewNo",new BigDecimal(1));
				criteria.add(ge);
			}
			else{
				if(null == manage.getElAction() || manage.getElAction().equalsIgnoreCase("")){
					Criterion ge = Restrictions.eq("renewNo",new BigDecimal(0));
					Criterion ge1 = Restrictions.ge("renewNo",new BigDecimal(1));
					LogicalExpression orExp = Restrictions.or(ge, ge1);
					criteria.add(orExp);
				}
				else if (manage.getElAction().equalsIgnoreCase("RENEW")
						 && manage.getProcessStatusCode().equalsIgnoreCase("300701")){
					    Criterion ge = Restrictions.ge("renewNo",new BigDecimal(1));
					    criteria.add(ge);
				}
				else{
					Criterion ge = Restrictions.eq("renewNo",new BigDecimal(0));
					criteria.add(ge);
				}
			}
		}
		
		
		
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		criteria.addOrder(Order.asc("contractNo"));
		
		return criteria.setMaxResults(8000).list();
		//return criteria.list();
	}
	
	public List<Management> queryManagementByPL(Management manage) throws Exception{		
		//logger.debug(" ---- searchPayment ---" );
		Session session = getSessionFactory().getCurrentSession();
	
		//Session session = getSessionFactory().getCurrentSession();	
        Query q = session.getNamedQuery("queryManagementPL"); 
        q.setString("siteInfoId", null);
        q.setString("siteInfoId", null); 
        q.setString("siteInfoId", null); 
        q.setString("siteInfoId", null); 
        q.setString("siteInfoId", null); 
        q.setString("siteInfoId", null); 
        q.setString("siteInfoId", null); 
        q.setString("siteInfoId", null); 
        q.setString("siteInfoId", null); 
        q.setString("siteInfoId", null); 
        q.setString("siteInfoId", null); 
        q.setString("siteInfoId", null); 
        q.setString("siteInfoId", null); 
        q.setString("siteInfoId", null); 
        q.setString("siteInfoId", null); 
        q.setString("siteInfoId", null); 
        q.setString("siteInfoId", null); 
        q.setString("siteInfoId", null); 
        q.setString("siteInfoId", null); 
        q.setString("siteInfoId", null); 
        q.setString("siteInfoId", null); 
        q.setString("siteInfoId", null); 
        q.setString("siteInfoId", null); 
        q.setString("siteInfoId", null); 
        q.setString("siteInfoId", null); 
        q.setString("siteInfoId", null); 
        q.setString("siteInfoId", null); 
        q.setString("siteInfoId", null); 
        q.setString("siteInfoId", null); 
        List<Management> returnList = q.list();
        //System.out.println(" returnList:"+returnList);
        
        return returnList; 

}
	
	private Date getFromDate(Date date){
		
		Calendar fromDate = Calendar.getInstance();
		fromDate.setTime(date);
		fromDate.set(Calendar.HOUR_OF_DAY, 0);
		fromDate.set(Calendar.MINUTE, 0);
		fromDate.set(Calendar.SECOND, 0);
		//WT###Edit 20101223 Start
		//fromDate.set(Calendar.MILLISECOND, 1);
		fromDate.set(Calendar.MILLISECOND, 0);
		//WT###Edit 20101223 End
		return fromDate.getTime();
	}
	
	private Date getToDate(Date date){
		
		Calendar toDate = Calendar.getInstance();
		toDate.setTime(date);
		toDate.set(Calendar.HOUR_OF_DAY, 23);
		toDate.set(Calendar.MINUTE, 59);
		toDate.set(Calendar.SECOND, 59);
		toDate.set(Calendar.MILLISECOND, 59);
		return toDate.getTime();
	}
	
	@SuppressWarnings("unchecked")
	public List<Management> queryByContractNo(String contractNo) throws DAOException {
		
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Management.class);
		if(contractNo==null){
			criteria.add(Restrictions.eq("contractNo", contractNo));
		}else{
			criteria.add(Restrictions.eq("contractNo", contractNo.toUpperCase()));
		}
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		criteria.addOrder(Order.asc("rowId"));
		
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Management> queryByContractNo06(String contractNo) throws DAOException {
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Management.class);
		/*
		if(StringUtils.isNotEmpty(contractNo)){
			criteria.add(Restrictions.like("contractNo", "%"+contractNo.toUpperCase()+"%"));
		}
		*/
		if(StringUtils.isNotEmpty(contractNo)){
			criteria.add(Restrictions.eq("contractNo",contractNo.toUpperCase()));
		}
		criteria.add(Restrictions.eq("electricUseType", "PRIVATE"));
		criteria.add(Restrictions.eq("recordStatus", "Y"));		
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		criteria.addOrder(Order.asc("rowId"));
		List result = criteria.list();	
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<PopupSiteSearchPrivate> queryByContractNo06ByPL(PopupSiteSearch popupSiteSearch) throws DAOException {
		Session session = getSessionFactory().getCurrentSession();
		Query q = session.getNamedQuery("searchSitePrivatePostpaid");
		logger.debug("Company="+popupSiteSearch.getCompany());
		logger.debug("ContractNo="+popupSiteSearch.getContractNo());
		logger.debug("SiteName="+popupSiteSearch.getSiteName());
		logger.debug("VendorName="+popupSiteSearch.getVendorName());
		logger.debug("VendorAddress="+popupSiteSearch.getVendorAddress());
		logger.debug("PayeeName="+popupSiteSearch.getPayeeName());
		logger.debug("PayeeAddress="+popupSiteSearch.getPayeeAddress());
		logger.debug("Region="+popupSiteSearch.getRegion());
		logger.debug("VendorId="+popupSiteSearch.getVendorId());
		logger.debug("PrepaidFlagStr="+popupSiteSearch.getPrepaidFlagStr());
		logger.debug("MeterID="+popupSiteSearch.getMeterID());
		logger.debug("Pread="+popupSiteSearch.getpRead());
		
		q.setString("company", popupSiteSearch.getCompany());
		if(popupSiteSearch.getContractNo()==null){
			q.setString("contractNo", popupSiteSearch.getContractNo());
		}else{
			q.setString("contractNo", popupSiteSearch.getContractNo().toUpperCase());
		}
		
		q.setString("siteName", popupSiteSearch.getSiteName());
		q.setString("vendorName", popupSiteSearch.getVendorName());
		q.setString("vendorAddress", popupSiteSearch.getVendorAddress());
		q.setString("payeeName", popupSiteSearch.getPayeeName());
		q.setString("payeeAddress", popupSiteSearch.getPayeeAddress());
		
		q.setString("region", popupSiteSearch.getRegion());
		q.setString("vendorId", popupSiteSearch.getVendorId());
		q.setString("prepaidFlag", popupSiteSearch.getPrepaidFlagStr());
		q.setString("meterID", popupSiteSearch.getMeterID());
		q.setString("pwh", popupSiteSearch.getpRead());
				
		
		return q.list();

	}
	
	@SuppressWarnings("unchecked")
	public List<PopupSiteSearchPrivate> queryByContractNo06PrepaidByPL(PopupSiteSearch popupSiteSearch) throws DAOException {
		Session session = getSessionFactory().getCurrentSession();
		Query q = session.getNamedQuery("searchSitePrivatePrepaid");
		logger.debug("Company="+popupSiteSearch.getCompany());
		logger.debug("ContractNo="+popupSiteSearch.getContractNo());
		logger.debug("SiteName="+popupSiteSearch.getSiteName());
		logger.debug("VendorName="+popupSiteSearch.getVendorName());
		logger.debug("VendorAddress="+popupSiteSearch.getVendorAddress());
		logger.debug("PayeeName="+popupSiteSearch.getPayeeName());
		logger.debug("PayeeAddress="+popupSiteSearch.getPayeeAddress());
		logger.debug("Region="+popupSiteSearch.getRegion());
		logger.debug("VendorId="+popupSiteSearch.getVendorId());
		
		q.setString("company", popupSiteSearch.getCompany());
		if(popupSiteSearch.getContractNo()==null){
			q.setString("contractNo", popupSiteSearch.getContractNo());
		}else{
			q.setString("contractNo", popupSiteSearch.getContractNo().toUpperCase());
		}
		
		q.setString("siteName", popupSiteSearch.getSiteName());
		q.setString("vendorName", popupSiteSearch.getVendorName());
		q.setString("vendorAddress", popupSiteSearch.getVendorAddress());
		q.setString("payeeName", popupSiteSearch.getPayeeName());
		q.setString("payeeAddress", popupSiteSearch.getPayeeAddress());
		
		q.setString("region", popupSiteSearch.getRegion());
		q.setString("vendorId", popupSiteSearch.getVendorId());
		return q.list();

	}
	
	@SuppressWarnings("unchecked")
	public List<PopupSiteSearchPrivate> queryDepositDetailByID(PopupSiteSearch popupSiteSearch) throws DAOException {
		Session session = getSessionFactory().getCurrentSession();
		Query q = session.getNamedQuery("searchSitePrivatePostpaid");
		logger.debug("Company="+popupSiteSearch.getCompany());
		logger.debug("ContractNo="+popupSiteSearch.getContractNo());
		logger.debug("SiteName="+popupSiteSearch.getSiteName());
		logger.debug("VendorName="+popupSiteSearch.getVendorName());
		logger.debug("VendorAddress="+popupSiteSearch.getVendorAddress());
		logger.debug("PayeeName="+popupSiteSearch.getPayeeName());
		logger.debug("PayeeAddress="+popupSiteSearch.getPayeeAddress());
		logger.debug("Region="+popupSiteSearch.getRegion());
		logger.debug("VendorId="+popupSiteSearch.getVendorId());
		logger.debug("PrepaidFlagStr="+popupSiteSearch.getPrepaidFlagStr());
		logger.debug("MeterID="+popupSiteSearch.getMeterID());
		logger.debug("Pread="+popupSiteSearch.getpRead());
		
		q.setString("company", popupSiteSearch.getCompany());
		if(popupSiteSearch.getContractNo()==null){
			q.setString("contractNo", popupSiteSearch.getContractNo());
		}else{
			q.setString("contractNo", popupSiteSearch.getContractNo().toUpperCase());
		}
		
		q.setString("siteName", popupSiteSearch.getSiteName());
		q.setString("vendorName", popupSiteSearch.getVendorName());
		q.setString("vendorAddress", popupSiteSearch.getVendorAddress());
		q.setString("payeeName", popupSiteSearch.getPayeeName());
		q.setString("payeeAddress", popupSiteSearch.getPayeeAddress());
		
		q.setString("region", popupSiteSearch.getRegion());
		q.setString("vendorId", popupSiteSearch.getVendorId());
		q.setString("prepaidFlag", popupSiteSearch.getPrepaidFlagStr());
		q.setString("meterID", popupSiteSearch.getMeterID());
		q.setString("pwh", popupSiteSearch.getpRead());
				
		
		return q.list();

	}
	@SuppressWarnings("unchecked")
	public List<ManagementSO> queryManagementIncludeSiteAddressSOExport(final Management manage) throws DAOException {
		getSessionFactory().getCurrentSession().enableFilter(ManagementSO.METERINFO_FILTER);
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(ManagementSO.class);
		
		if(manage != null){			
			if(StringUtils.isNotEmpty(manage.getCompany())) criteria.add(Restrictions.eq("company", manage.getCompany()));
			if(StringUtils.isNotEmpty(manage.getContractNo())) criteria.add(Restrictions.like("contractNo", "%" + manage.getContractNo().toUpperCase() + "%"));
			if(StringUtils.isNotEmpty(manage.getRegion())) criteria.add(Restrictions.eq("region", manage.getRegion()));
			if(StringUtils.isNotEmpty(manage.getProvince())) criteria.add(Restrictions.eq("province", manage.getProvince()));
			if(StringUtils.isNotEmpty(manage.getSiteName())) criteria.add(Restrictions.like("siteName", "%" + manage.getSiteName() + "%"));
			if(StringUtils.isNotEmpty(manage.getSiteStatus())) criteria.add(Restrictions.eq("siteStatus", manage.getSiteStatus()));
			if(StringUtils.isNotEmpty(manage.getElectricUseType())) criteria.add(Restrictions.eq("electricUseType", manage.getElectricUseType()));
			if(StringUtils.isNotEmpty(manage.getLocationId())) criteria.add(Restrictions.like("locationId", "%" + manage.getLocationId() + "%"));
			if(StringUtils.isNotEmpty(manage.getLocationCode())) criteria.add(Restrictions.like("locationCode", "%" + manage.getLocationCode() + "%"));
			if(StringUtils.isNotEmpty(manage.getProcessStatusCode())) criteria.add(Restrictions.eq("processStatusCode", manage.getProcessStatusCode()));
			if(StringUtils.isNotEmpty(manage.getOwnerName())) criteria.add(Restrictions.like("ownerName", "%" + manage.getOwnerName() + "%"));
			if(StringUtils.isNotEmpty(manage.getLessorName())) criteria.add(Restrictions.like("lessorName", "%" + manage.getLessorName() + "%"));
			if(StringUtils.isNotEmpty(manage.getRecordStatus())) criteria.add(Restrictions.eq("recordStatus", manage.getRecordStatus()));
			if(StringUtils.isNotEmpty(manage.getZone())) criteria.add(Restrictions.eq("zone", manage.getZone()));
			
			if(manage.getTransferReceivedDt() != null){
				
				Criterion between = Restrictions.between("transferReceivedDt", getFromDate(manage.getTransferReceivedDt()), getToDate(manage.getTransferReceivedDt()));
				Criterion equal = Restrictions.eq("transferReceivedDt", manage.getTransferReceivedDt());
				
				LogicalExpression orExp = Restrictions.or(between, equal);
				criteria.add(orExp);
			}
			if(manage.getNewReceivedDt() != null){
				
				Criterion between = Restrictions.between("newReceivedDt", getFromDate(manage.getNewReceivedDt()), getToDate(manage.getNewReceivedDt()));
				Criterion equal = Restrictions.eq("newReceivedDt", manage.getNewReceivedDt());
				
				LogicalExpression orExp = Restrictions.or(between, equal);
				
				criteria.add(orExp);
			}
			if(manage.getTerminateReceivedDt() != null){
				
				Criterion between = Restrictions.between("terminateReceivedDt", getFromDate(manage.getTerminateReceivedDt()), getToDate(manage.getTerminateReceivedDt()));
				Criterion equal = Restrictions.eq("terminateReceivedDt", manage.getTerminateReceivedDt());
				
				LogicalExpression orExp = Restrictions.or(between, equal);
				
				criteria.add(orExp);
			}
			if(manage.getTransferCutoffDt() != null){
				
				Criterion between = Restrictions.between("transferCutoffDt", getFromDate(manage.getTransferCutoffDt()), getToDate(manage.getTransferCutoffDt()));
				Criterion equal = Restrictions.eq("transferCutoffDt", manage.getTransferCutoffDt());
				
				LogicalExpression orExp = Restrictions.or(between, equal);
				
				criteria.add(orExp);
			}
			//WT###Add
			if(StringUtils.isNotEmpty(manage.getSiteHouseNo())){				
				criteria.add(Restrictions.disjunction().
						add(Restrictions.like("siteHouseNo", "%" + manage.getSiteHouseNo() + "%")).
						add(Restrictions.like("siteLandNo", "%" + manage.getSiteHouseNo() + "%")).
						add(Restrictions.like("siteRoomNo", "%" + manage.getSiteHouseNo() + "%")));
			}
			if(StringUtils.isNotEmpty(manage.getSiteBuilding())){
				criteria.add(Restrictions.like("siteBuilding", "%" + manage.getSiteBuilding() + "%"));
			}
			if(StringUtils.isNotEmpty(manage.getSiteStreet())){
				criteria.add(Restrictions.like("siteStreet", "%" + manage.getSiteStreet() + "%"));
			}
			if(StringUtils.isNotEmpty(manage.getSiteTumbon())){
				criteria.add(Restrictions.like("siteTumbon", "%" + manage.getSiteTumbon() + "%"));
			}
			if(StringUtils.isNotEmpty(manage.getSiteAmphur())){
				criteria.add(Restrictions.like("siteAmphur", "%" + manage.getSiteAmphur() + "%"));
			}			
			if(StringUtils.isNotEmpty(manage.getMeterId())){
				criteria.createAlias("meterInfos", "meterInfosAlias", Criteria.LEFT_JOIN);
				criteria.add(Restrictions.like("meterInfosAlias.meterId", "%"+manage.getMeterId()+"%"));
			}				
			if(null!=manage.getNewReceivedDtFrom()){
				/*Criterion between = Restrictions.between("newReceivedDt", getFromDate(manage.getNewReceivedDtFrom()), getToDate(manage.getNewReceivedDtTo()));
				Criterion equal = Restrictions.eq("newReceivedDt", manage.getNewReceivedDt());
				LogicalExpression orExp = Restrictions.or(between, equal);*/
				Criterion ge = Restrictions.ge("newReceivedDt", getFromDate(manage.getNewReceivedDtFrom()));
				Criterion le = Restrictions.le("newReceivedDt", getToDate(manage.getNewReceivedDtTo()));
				//LogicalExpression orExp = Restrictions.and(ge, le);
				criteria.add(ge);
				criteria.add(le);
			}
			if(null!=manage.getTerminateReceivedDtFrom()){
				/*Criterion between = Restrictions.between("terminateReceivedDt", getFromDate(manage.getTerminateReceivedDtFrom()), getToDate(manage.getTerminateReceivedDtTo()));
				Criterion equal = Restrictions.eq("terminateReceivedDt", manage.getTerminateReceivedDt());
				LogicalExpression orExp = Restrictions.or(between, equal);*/
				Criterion ge = Restrictions.ge("terminateReceivedDt", getFromDate(manage.getTerminateReceivedDtFrom()));
				Criterion le = Restrictions.le("terminateReceivedDt", getToDate(manage.getTerminateReceivedDtTo()));
				//LogicalExpression orExp = Restrictions.and(ge, le);
				criteria.add(ge);
				criteria.add(le);
			}
			if(null!=manage.getTransferReceivedDtFrom()){
				/*Criterion between = Restrictions.between("transferReceivedDt", getFromDate(manage.getTransferReceivedDtFrom()), getToDate(manage.getTransferReceivedDtTo()));
				Criterion equal = Restrictions.eq("transferReceivedDt", manage.getTransferReceivedDt());
				LogicalExpression orExp = Restrictions.or(between, equal);*/
				Criterion ge = Restrictions.ge("transferReceivedDt", getFromDate(manage.getTransferReceivedDtFrom()));
				Criterion le = Restrictions.le("transferReceivedDt", getToDate(manage.getTransferReceivedDtTo()));
				//LogicalExpression orExp = Restrictions.and(ge, le);
				criteria.add(ge);
				criteria.add(le);
			}
			if(null!=manage.getTerminateCutoffDtFrom()){
				Criterion ge = Restrictions.ge("terminateCutoffDt", getFromDate(manage.getTerminateCutoffDtFrom()));
				Criterion le = Restrictions.le("terminateCutoffDt", getToDate(manage.getTerminateCutoffDtTo()));
				//LogicalExpression orExp = Restrictions.and(ge, le);
				criteria.add(ge);
				criteria.add(le);
			}
			if(null!=manage.getTransferCutoffDtFrom()){
				/*Criterion between = Restrictions.between("transferCutoffDt", getFromDate(manage.getTransferCutoffDtFrom()), getToDate(manage.getTransferCutoffDtTo()));
				Criterion equal = Restrictions.eq("transferCutoffDt", manage.getTransferCutoffDt());
				LogicalExpression orExp = Restrictions.or(between, equal);*/
				Criterion ge = Restrictions.ge("transferCutoffDt", getFromDate(manage.getTransferCutoffDtFrom()));
				Criterion le = Restrictions.le("transferCutoffDt", getToDate(manage.getTransferCutoffDtTo()));
				//LogicalExpression orExp = Restrictions.and(ge, le);
				criteria.add(ge);
				criteria.add(le);
			}
			if(null!=manage.getExpandOldCutoffDtFrom()){
				/*Criterion between = Restrictions.between("expandOldCutoffDtFrom", getFromDate(manage.getExpandOldCutoffDtFrom()), getToDate(manage.getExpandOldCutoffDtTo()));
				Criterion equal = Restrictions.eq("expandOldCutoffDtFrom", manage.getExpandOldCutoffDt());
				LogicalExpression orExp = Restrictions.or(between, equal);*/
				Criterion ge = Restrictions.ge("expandOldCutoffDt", getFromDate(manage.getExpandOldCutoffDtFrom()));
				Criterion le = Restrictions.le("expandOldCutoffDt", getToDate(manage.getExpandOldCutoffDtTo()));
				//LogicalExpression orExp = Restrictions.and(ge, le);
				criteria.add(ge);
				criteria.add(le);
			}
			if(null!=manage.getContractStartDtTo()){
				Criterion ge = Restrictions.le("contractStartDt", getFromDate(manage.getContractStartDtTo()));
				criteria.add(ge);
			}
			
			if(null!=manage.getContractStartDtTo()){
				Criterion ge = Restrictions.le("contractStartDt", getFromDate(manage.getContractStartDtTo()));
				criteria.add(ge);
			}
			//WT###Add End
			
			if(manage.isRenewFlag()){
				Criterion ge = Restrictions.ge("renewNo",new BigDecimal(1));
				criteria.add(ge);
			}
			else{
				if(null == manage.getElAction() || manage.getElAction().equalsIgnoreCase("")){
					Criterion ge = Restrictions.eq("renewNo",new BigDecimal(0));
					Criterion ge1 = Restrictions.ge("renewNo",new BigDecimal(1));
					LogicalExpression orExp = Restrictions.or(ge, ge1);
					criteria.add(orExp);
				}
				else if (manage.getElAction().equalsIgnoreCase("RENEW")
						 && manage.getProcessStatusCode().equalsIgnoreCase("300701")){
					    Criterion ge = Restrictions.ge("renewNo",new BigDecimal(1));
					    criteria.add(ge);
				}
				else{
					Criterion ge = Restrictions.eq("renewNo",new BigDecimal(0));
					criteria.add(ge);
				}
			}
		}

		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		criteria.addOrder(Order.asc("contractNo"));
		
		return criteria.setMaxResults(1000).list();
		//return criteria.list();
	}
}
