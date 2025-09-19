package th.co.ais.service.el;

import java.util.List;

import th.co.ais.domain.el.MeterInstallmentSearch;
import th.co.ais.domain.el.PrepaidInfo;
import th.co.ais.service.BaseService;

public interface IPrepaidPaymentService extends BaseService {

	public List<PrepaidInfo> getInstallment() throws Exception;
	public List<MeterInstallmentSearch> getDefaultAlertPrepaidList(MeterInstallmentSearch meterSearch) throws Exception;
	public List<MeterInstallmentSearch> searchPrepaidList( MeterInstallmentSearch meterSearch) throws Exception;
	public PrepaidInfo getPrepaidInfo() throws Exception;
}
     