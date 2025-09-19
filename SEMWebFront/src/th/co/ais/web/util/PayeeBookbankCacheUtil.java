package th.co.ais.web.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

import th.co.ais.domain.gm.PayeeBookbank;
import th.co.ais.service.gm.IPayeeBookbankService;
import th.co.ais.util.EComponentCode;

public class PayeeBookbankCacheUtil implements Serializable{

	private static final long serialVersionUID = -1546278657525216478L;
	private Logger log = Logger.getLogger(getClass());
	private static PayeeBookbankCacheUtil instance = null;
	private static List<PayeeBookbank> payeeBookbankList;
	private PayeeBookbankCacheUtil(){
		
	}
	
	public static void init(){
		if (payeeBookbankList == null) {
			try {
				IPayeeBookbankService payeeBookbankService = (IPayeeBookbankService)FacesUtils.getInstance().getBean("payeeBookbankService");
				payeeBookbankList = payeeBookbankService.queryAllPayeeBookbank();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static synchronized PayeeBookbankCacheUtil getInstance() {
        if (instance == null) {
            instance = new PayeeBookbankCacheUtil();
        }
        return instance;
    }
	
	@SuppressWarnings("unchecked")
	public void loadComponent(){
		init();
	}
		
	@SuppressWarnings("unchecked")
	public List<PayeeBookbank> getAllpayeeBookbank(){
		if(payeeBookbankList == null){ loadComponent(); }
		return payeeBookbankList;
	}
	
	@SuppressWarnings("unchecked")
	public PayeeBookbank getPayeeBookbankById(String payeeBookbankId){
		PayeeBookbank payeeBookbank = null;
		if(payeeBookbankList == null){ loadComponent(); }
		try {
			for(PayeeBookbank obj : payeeBookbankList){
				if(payeeBookbankId.equals(obj.getRowId())){
					return obj;
				}
			}
		} catch (Exception e) {
			log.error("error in getPayeeBookbankById : " + e);
		}
		return payeeBookbank;
	}

}
