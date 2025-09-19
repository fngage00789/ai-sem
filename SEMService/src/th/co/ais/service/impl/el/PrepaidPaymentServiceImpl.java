package th.co.ais.service.impl.el;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import th.co.ais.dao.impl.el.PrepaidPaymentHibernateDAO;
import th.co.ais.domain.el.MeterInstallment;
import th.co.ais.domain.el.MeterInstallmentSearch;
import th.co.ais.domain.el.PrepaidInfo;
import th.co.ais.service.AbstractService;
import th.co.ais.service.el.IPrepaidPaymentService;

public class PrepaidPaymentServiceImpl extends AbstractService implements
		IPrepaidPaymentService {

	private PrepaidPaymentHibernateDAO prepaidpaymentDao;
	
	public PrepaidPaymentHibernateDAO getPrepaidpaymentDao() {
		return prepaidpaymentDao;
	}

	public void setPrepaidpaymentDao(
			PrepaidPaymentHibernateDAO prepaidpaymentDao) {
		this.prepaidpaymentDao = prepaidpaymentDao;
	}

	@Override
	public List<PrepaidInfo> getInstallment() throws Exception {
		return prepaidpaymentDao.getInstallment();
	}

	@Override
	public PrepaidInfo getPrepaidInfo() throws Exception{
		return prepaidpaymentDao.getPrepaidInfo();
	}
	
	@Override
	public List<MeterInstallmentSearch> getDefaultAlertPrepaidList(MeterInstallmentSearch meterSearch) 
		throws Exception {
		List<MeterInstallment> meterList = prepaidpaymentDao.getDefaultAlertPrepaidList(meterSearch);
		
		return this.convertDomainToVo(meterList);
	}
	

	@Override
	public List<MeterInstallmentSearch> searchPrepaidList(
			MeterInstallmentSearch meterSearch) throws Exception {
		
		List<MeterInstallment> meterList = prepaidpaymentDao.searchPrepaidList(meterSearch);		
		
		return this.convertDomainToVo(meterList);
	}
	
	private List<MeterInstallmentSearch> convertDomainToVo(List<MeterInstallment> meterList){
		List<MeterInstallmentSearch> searchList = new ArrayList<MeterInstallmentSearch>();
		
		if ((meterList != null) && (!meterList.isEmpty())) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy",	new Locale("th", "TH"));
			
			for (MeterInstallment mi : meterList) {
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
				try{
					meterSearch.setDueDateStr(sdf.format(mi.getDueDt()));
				}catch (Exception e){}
				
				searchList.add(meterSearch);
			}
		}
		
		return searchList;
	}
}
