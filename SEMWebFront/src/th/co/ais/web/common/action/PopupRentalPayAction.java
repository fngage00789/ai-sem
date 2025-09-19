package th.co.ais.web.common.action;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import th.co.ais.domain.rt.Mrt003Pop;
import th.co.ais.service.rt.IRentalPaymentService;
import th.co.ais.util.EQueryName;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.bean.common.PopupRentalPayBean;
import th.co.ais.web.ir.bean.SEMMIR002Bean;
import th.co.ais.web.util.FacesUtils;

public class PopupRentalPayAction extends AbstractAction {

	private Logger log = Logger.getLogger(getClass());
	
	public PopupRentalPayBean popupRentalPayBean;
	
	public PopupRentalPayBean getPopupRentalPayBean(){
		PopupRentalPayBean popupRentalPayBean = (PopupRentalPayBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("popupRentalPayBean");
		if(popupRentalPayBean == null){
			popupRentalPayBean = new PopupRentalPayBean();
		}
		return popupRentalPayBean;
	}
	
	public void setPopupRentalPayBean(PopupRentalPayBean popupRentalPayBean){
		this.popupRentalPayBean = popupRentalPayBean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("popupRentalPayBean", popupRentalPayBean);
	}
	
	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		if (methodWithNavi.equalsIgnoreCase("initPopupRental")) {
			initPopupRental();
		}
		return flag;
	}

	@Override
	public void clearSessionNotUsed() {

	}

	@Override
	public void init() {

	}

	@Override
	public boolean validate() {
		return false;
	}
	
	public boolean initPopupRental(){
		popupRentalPayBean = getPopupRentalPayBean();
		
		Mrt003Pop cri = new Mrt003Pop();
		List<Mrt003Pop> resultList = new ArrayList<Mrt003Pop>();
		IRentalPaymentService rentalPaymentService = (IRentalPaymentService)getBean("rentalPaymentService");
		String rentalPaymentId = (String)getFacesUtils().getRequestParameter("rowId");
		
		popupRentalPayBean.setMrt003PopSP(new Mrt003Pop());
		popupRentalPayBean.setMrt003PopSPList(new ArrayList<Mrt003Pop>());
		
		try{
			cri.setRentalPaymentId(rentalPaymentId);
			//Load Rental Pay
			resultList = rentalPaymentService.querySPList(EQueryName.SP_MRT003_POP.name, cri);
			log.debug("resultList.size() = "+resultList.size());
			if(resultList != null && resultList.size() > 0){
				popupRentalPayBean.setMrt003PopSP(resultList.get(0));
			}
			
			//Load Data in Table Detail
			resultList = rentalPaymentService.querySPList(EQueryName.SP_MRT003_POP_D.name, cri);
			log.debug("resultList.size() = "+resultList.size());
			if(resultList != null && resultList.size() > 0){
				popupRentalPayBean.setMrt003PopSPList(resultList);
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		setPopupRentalPayBean(popupRentalPayBean);
		return false;
	}

}
