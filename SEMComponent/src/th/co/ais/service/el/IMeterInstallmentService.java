package th.co.ais.service.el;

import java.util.List;

import th.co.ais.domain.el.Management;
import th.co.ais.domain.el.ManagementSP;
import th.co.ais.domain.el.MeterInstallment;
import th.co.ais.domain.el.PopupSiteSearch;
import th.co.ais.domain.el.PopupSiteSearchInstallment;
import th.co.ais.domain.el.PopupSiteSearchPrivate;
import th.co.ais.domain.el.PrivatePrepaid;
import th.co.ais.service.BaseService;

public interface IMeterInstallmentService extends BaseService{

	public List<MeterInstallment> queryByContractNo(String contractNo) throws Exception;
	public MeterInstallment queryByRowId(String rowId) throws Exception;
	public List<MeterInstallment> searchEL009(MeterInstallment meterInstallment)throws Exception;
	public List<MeterInstallment>  getDetailEL009(MeterInstallment meterInstallment)throws Exception;
	public List<MeterInstallment> queryByManagementDistinctMeterId(Management manage) throws Exception;
	public List<MeterInstallment> queryByManagementDistinctMeterId(ManagementSP manage) throws Exception;
	public List<MeterInstallment> queryByManagementDistinctMeterIdAndRefMeterId(Management manage) throws Exception;
	public List<MeterInstallment> queryByManagementDistinctMeterIdAndRefMeterId(ManagementSP manage) throws Exception;
	public List<MeterInstallment> queryByCriteria(MeterInstallment meterInstallment) throws Exception;
	public List<MeterInstallment> queryByMeterId(Management manage, MeterInstallment meterInstallment, boolean isMeterIdOnly) throws Exception;
	public List<MeterInstallment> queryByMeterId(ManagementSP manage, MeterInstallment meterInstallment, boolean isMeterIdOnly) throws Exception;
	
	public List<PrivatePrepaid> queryByCritiriaPrivatePrepaid(PrivatePrepaid  meterInstallment) throws Exception;
	public PrivatePrepaid queryPrivatePrepaidByRowId(String rowId) throws Exception;
	public Object[] searchEL009ByPL(MeterInstallment meterInstallment)throws Exception;
	public List<PopupSiteSearchInstallment> queryInstallmentDetailByPL(MeterInstallment meterInstallment)throws Exception;
	
	
	
}
