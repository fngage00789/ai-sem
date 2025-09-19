package th.co.ais.service.el;

import java.util.List;

import th.co.ais.domain.el.Management;
import th.co.ais.domain.el.MeterInfo;
import th.co.ais.domain.el.Payment;
import th.co.ais.domain.el.PaymentDetail;
import th.co.ais.service.BaseService;

public interface IMeterInfoService extends BaseService {

	public List<MeterInfo> queryMeterInfoByCriteria(MeterInfo meterInfo) throws Exception;
	public List<MeterInfo> queryMeterInfoByManagement(Management manage) throws Exception;
	public List<MeterInfo> findByMeterId(String meterId) throws Exception;
	public void updateMeterInfoExport(List<MeterInfo> meterInfoList,String plName)throws Exception;
	public void createMeterInfo(MeterInfo meterInfo) throws Exception;
	public Number countMeterInfoByManage(Management manage) throws Exception;
	public void saveMeterInfo(Management manage, MeterInfo newMeterInfo, List<MeterInfo> oldMeterInfoList, String plName) throws Exception;
	public List<MeterInfo> queryMeterListForPayment(MeterInfo meterInfo) throws Exception;	
	public MeterInfo queryByRowId(String rowId) throws Exception;
	public void deleteMeterInfo(MeterInfo meterInfo) throws Exception;
	public void updateMeterInfo(MeterInfo meterInfo) throws Exception;
	//-----------------------------------------------------------
	public List<MeterInfo> queryMeterListByPayment(Payment payment,PaymentDetail paymentDetail) throws Exception;
	public void updateMeterInfo(Management manage, MeterInfo newMeterInfo, List<MeterInfo> oldMeterInfoList, String plName) throws Exception;
	public List<MeterInfo> queryMeterListForUpdateInstalment(MeterInfo meterInfo) throws Exception;
}
