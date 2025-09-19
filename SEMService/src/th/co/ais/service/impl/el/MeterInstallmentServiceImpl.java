package th.co.ais.service.impl.el;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import th.co.ais.dao.impl.el.MeterInstallmentHibernateDAO;
import th.co.ais.dao.impl.el.PLUtil;
import th.co.ais.domain.el.Management;
import th.co.ais.domain.el.ManagementSP;
import th.co.ais.domain.el.MeterInstallment;
import th.co.ais.domain.el.PopupSiteSearch;
import th.co.ais.domain.el.PopupSiteSearchInstallment;
import th.co.ais.domain.el.PopupSiteSearchPrivate;
import th.co.ais.domain.el.PrivatePrepaid;
import th.co.ais.domain.gm.Region;
import th.co.ais.service.AbstractService;
import th.co.ais.service.el.IMeterInstallmentService;

public class MeterInstallmentServiceImpl extends AbstractService implements IMeterInstallmentService {

	private MeterInstallmentHibernateDAO meterInstallmentDao;
	private PLUtil plUtil;
	
	public void setPlUtil(PLUtil plUtil) {
		this.plUtil = plUtil;
	}
	
	public void setMeterInstallmentDao(MeterInstallmentHibernateDAO meterInstallmentDao) {
		this.meterInstallmentDao = meterInstallmentDao;
	}

	@Override
	public List<MeterInstallment> queryByContractNo(String contractNo) throws Exception {
		return meterInstallmentDao.findByContractNo(contractNo);
	}

	@Override
	public MeterInstallment queryByRowId(String rowId) throws Exception {
		return meterInstallmentDao.findByRowId(rowId);
	}
	
	@Override
	public PrivatePrepaid queryPrivatePrepaidByRowId(String rowId) throws Exception {
		return meterInstallmentDao.findPrivatePrepaidByRowId(rowId);
	}

	@Override
	public List<MeterInstallment> searchEL009(
			MeterInstallment meterInstallment) throws Exception {
		List<MeterInstallment> result = new ArrayList<MeterInstallment>();
		
		@SuppressWarnings("rawtypes")
		List meterInstallmentList =  meterInstallmentDao.searchEL009(meterInstallment);
		if(meterInstallment.isSelected()){
			for (int i = 0; i < meterInstallmentList.size(); i++) {
				Object[] row = (Object[])meterInstallmentList.get(i);
				MeterInstallment meter = new MeterInstallment();
				meter.setTermOfPaymentDt((Date)row[0]);
				meter.setCompany((String)row[1]);
				Region region = (Region)row[2];
				
				//region
				meter.setRegion(new Region());
				meter.getRegion().setRowId(region.getRowId());
				meter.getRegion().setEngDescription(region.getEngDescription());
				meter.getRegion().setThaiDescription(region.getThaiDescription());
				
				meter.setElectricUseType((String)row[3]);
				meter.setTermOfPaymentDisplay(String.valueOf(row[4]));
				result.add(meter);
			}
		}else{
			for (int i = 0; i < meterInstallmentList.size(); i++) {
				Object[] row = (Object[])meterInstallmentList.get(i);
				MeterInstallment meter = new MeterInstallment();
				meter.setCompany((String)row[0]);
				Region region = (Region)row[1];
				
				//region
				meter.setRegion(new Region());
				meter.getRegion().setRowId(region.getRowId());
				meter.getRegion().setEngDescription(region.getEngDescription());
				meter.getRegion().setThaiDescription(region.getThaiDescription());
				
				meter.setElectricUseType((String)row[2]);
				meter.setTermOfPaymentDisplay(String.valueOf(row[3]));
				result.add(meter);
			}
		}
		return result;
	}

	@Override
	public List<MeterInstallment> getDetailEL009(MeterInstallment meterInstallment)
			throws Exception {
		List<MeterInstallment> result = meterInstallmentDao.getDetailEL009(meterInstallment);
		return result;
	}

	@Override
	public List<MeterInstallment> queryByCriteria(MeterInstallment meterInstallment) throws Exception{	
		return meterInstallmentDao.queryByCritiria(meterInstallment);
	}
	
	@Override
	public List<PrivatePrepaid> queryByCritiriaPrivatePrepaid(PrivatePrepaid  meterInstallment) throws Exception{	
		return meterInstallmentDao.queryByCritiriaPrivatePrepaid(meterInstallment);
	}
	

	@Override
	public List<MeterInstallment> queryByManagementDistinctMeterId(Management manage) throws Exception{
		
		return meterInstallmentDao.findByManagement(manage, true);
	}
	
	@Override
	public List<MeterInstallment> queryByManagementDistinctMeterId(ManagementSP manage) throws Exception{
		
		return meterInstallmentDao.findByManagement(manage, true);
	}

	@Override
	public List<MeterInstallment> queryByManagementDistinctMeterIdAndRefMeterId(Management manage) throws Exception{
		
		return meterInstallmentDao.findByManagement(manage, false);
	}
	
	@Override
	public List<MeterInstallment> queryByManagementDistinctMeterIdAndRefMeterId(ManagementSP manage) throws Exception{
		
		return meterInstallmentDao.findByManagement(manage, false);
	}

	@Override
	public List<MeterInstallment> queryByMeterId(Management manage, MeterInstallment meterInstallment, boolean isMeterIdOnly) throws Exception {
		return meterInstallmentDao.findByMeterId(manage, meterInstallment, isMeterIdOnly);
	}
	
	@Override
	public List<MeterInstallment> queryByMeterId(ManagementSP manage, MeterInstallment meterInstallment, boolean isMeterIdOnly) throws Exception {
		return meterInstallmentDao.findByMeterId(manage, meterInstallment, isMeterIdOnly);
	}
	
	@Override
	public  Object[] searchEL009ByPL(
			MeterInstallment meterInstallment) throws Exception {
		//List<MeterInstallment> result = new ArrayList<MeterInstallment>();
		//List<String> result = new ArrayList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyy",	new Locale("th", "TH"));
		String periodTxt = "01"	+ meterInstallment.getFormTermOfPaymentMonth()+ meterInstallment.getFormTermOfPaymentYear();
		Date fromTermOfPaymentDt = sdf.parse(periodTxt);
		periodTxt = "01" + meterInstallment.getToTermOfPaymentMonth()+ meterInstallment.getToTermOfPaymentYear();
		Date toTermOfPaymentDt = sdf.parse(periodTxt);
		int []inParamType = new int[]{PLUtil.IN_PARAM_TYPE_VARCHAR, PLUtil.IN_PARAM_TYPE_VARCHAR,PLUtil.IN_PARAM_TYPE_VARCHAR,
				                      PLUtil.IN_PARAM_TYPE_DATE,PLUtil.IN_PARAM_TYPE_DATE};
		int []outParamType = new int[]{PLUtil.IN_PARAM_TYPE_VARCHAR, PLUtil.IN_PARAM_TYPE_VARCHAR};
		Object []inParamValue = new Object[]{meterInstallment.getCompany(),meterInstallment.getRegion(),meterInstallment.getElectricUseType(),
										 fromTermOfPaymentDt,toTermOfPaymentDt};
		
		String plName = "SEM_PG_EL_SITE_INFO_PROCESS_SEM_GET_OUTSTANDING_PAYMENT";	
		
		Object [] results = plUtil.callPLWithReturnValue(plName, inParamType, outParamType, inParamValue);
		
		
		return results;
	}
    
	@Override
	public List<PopupSiteSearchInstallment> queryInstallmentDetailByPL(MeterInstallment meterInstallment)throws Exception
		 {
		return meterInstallmentDao.queryByContractNo06ByPL(meterInstallment);
	}
	
}