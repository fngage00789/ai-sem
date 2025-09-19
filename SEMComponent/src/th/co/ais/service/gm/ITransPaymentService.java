package th.co.ais.service.gm;

import java.util.List;

import th.co.ais.domain.gm.TransPayment;
import th.co.ais.service.BaseService;

public interface ITransPaymentService extends BaseService {
	
	public List<TransPayment> queryTransPayment(TransPayment transPayment) throws Exception;
	
}
