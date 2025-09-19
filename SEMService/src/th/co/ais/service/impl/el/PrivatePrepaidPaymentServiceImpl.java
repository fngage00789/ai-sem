package th.co.ais.service.impl.el;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import th.co.ais.dao.impl.el.PrepaidPaymentHibernateDAO;
import th.co.ais.dao.impl.el.PrivatePrepaidMeterInstallmentHibernateDAO;
import th.co.ais.domain.el.MeterInstallment;
import th.co.ais.domain.el.MeterInstallmentSearch;
import th.co.ais.domain.el.PrepaidInfo;
import th.co.ais.domain.el.PrivatePrepaid;
import th.co.ais.service.AbstractService;
import th.co.ais.service.el.IPrepaidPaymentService;
import th.co.ais.service.el.IPrivatePrepaidPaymentService;

public class PrivatePrepaidPaymentServiceImpl extends AbstractService implements IPrivatePrepaidPaymentService {

	private PrivatePrepaidMeterInstallmentHibernateDAO privatePrepaidDao;
	
	
	
	public PrivatePrepaidMeterInstallmentHibernateDAO getPrivatePrepaidDao() {
		return privatePrepaidDao;
	}

	public void setPrivatePrepaidDao(
			PrivatePrepaidMeterInstallmentHibernateDAO privatePrepaidDao) {
		this.privatePrepaidDao = privatePrepaidDao;
	}

	@Override
	public List<PrepaidInfo> getInstallment() throws Exception {
		return privatePrepaidDao.getInstallment();
	}
	
	@Override
	public PrepaidInfo getPrepaidInfo() throws Exception{
		return privatePrepaidDao.getPrepaidInfo();
	}
	
	@Override
	public List<MeterInstallmentSearch> getDefaultAlertPrepaidList(MeterInstallmentSearch meterSearch) 
		throws Exception {
		
		List<PrivatePrepaid> meterList = privatePrepaidDao.getDefaultPrepaidList(meterSearch);
		
		return this.convertDomainToVo(meterList);
	}
	
	@Override
	public List<MeterInstallmentSearch> searchPrepaidList(
			MeterInstallmentSearch meterSearch) throws Exception {
		
		List<PrivatePrepaid> meterList = privatePrepaidDao.searchPrivatePrepaid(meterSearch);		
		
		return this.convertDomainToVo(meterList);
	}
    
	private List<MeterInstallmentSearch> convertDomainToVo(List<PrivatePrepaid> meterList){
		List<MeterInstallmentSearch> searchList = new ArrayList<MeterInstallmentSearch>();
		
		if ((meterList != null) && (!meterList.isEmpty())) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy",	new Locale("th", "TH"));
			
			for (PrivatePrepaid mi : meterList) {
				MeterInstallmentSearch meterSearch = new MeterInstallmentSearch();
				meterSearch.setRowId(mi.getRowId());
				meterSearch.setCompany(mi.getCompany());
				meterSearch.setContractNo(mi.getContractNo());
				meterSearch.setDueDt(mi.getDueDt());
				meterSearch.setLocationCode(mi.getLocationCode());
				meterSearch.setLocationId(mi.getLocationId());
				meterSearch.setPaidFlag(mi.getPaidFlag());
				meterSearch.setPeriodAmt(mi.getPeriodAmt());
				meterSearch.setPeriodName(mi.getPeriodName());
				meterSearch.setRegion(mi.getRegion().getRowId());
				meterSearch.setSiteName(mi.getSiteName());
				meterSearch.setPeriodNo(mi.getPeriodNo());
				meterSearch.setExcAmt(mi.getExcludeVatAmt());
				meterSearch.setVatAmt(mi.getVatAmt());
				meterSearch.setIncAmt(mi.getIncludeVatAmt());
				meterSearch.setWhtAmt(mi.getWhtAmt());
				meterSearch.setChqAmt(mi.getChqAmt());
				try{
					meterSearch.setDueDateStr(sdf.format(mi.getDueDt()));
				}catch (Exception e){}
				
				searchList.add(meterSearch);
			}
		}
		
		return searchList;
	}
	public void updatePrivate(
			PrivatePrepaidMeterInstallmentHibernateDAO privatePrepaidDao) {
		this.privatePrepaidDao = privatePrepaidDao;
	}

	
	
}
