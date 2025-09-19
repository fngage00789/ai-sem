package th.co.ais.web.common.action;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.domain.rt.HistoryDetailSP;
import th.co.ais.service.si.ISendRenewService;
import th.co.ais.util.EQueryName;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.bean.common.PopupEditHistoryBean;

public class PopupEditHistoryAction extends AbstractAction {

	private Logger log = Logger.getLogger(getClass());
	
	public PopupEditHistoryBean popupEditHistoryBean;
	
	public PopupEditHistoryBean getPopupEditHistoryBean() {
		PopupEditHistoryBean popupEditHistoryBean = (PopupEditHistoryBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("popupEditHistoryBean");
		if(popupEditHistoryBean == null){
			popupEditHistoryBean = new PopupEditHistoryBean();
		}
		return popupEditHistoryBean;
	}

	public void setPopupEditHistoryBean(PopupEditHistoryBean popupEditHistoryBean) {
		this.popupEditHistoryBean = popupEditHistoryBean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("popupEditHistoryBean", popupEditHistoryBean);
	}

	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		if(methodWithNavi.equalsIgnoreCase("initPopup")){
			flag = initPopup();
		}
		return flag;
	}

	private boolean initPopup() {
		boolean flag = false;
		popupEditHistoryBean = getPopupEditHistoryBean();
		popupEditHistoryBean.setHistoryDetailSP(new HistoryDetailSP());
		
		String siteinfoId = (String)getFacesUtils().getRequestParameter("sIdHistory");
		try{
			HistoryDetailSP sp = new HistoryDetailSP();
			List<HistoryDetailSP> spList = new ArrayList<HistoryDetailSP>();
			List<HistoryDetailSP> spResultList = new ArrayList<HistoryDetailSP>();
			
			ISendRenewService service = (ISendRenewService) getBean("sendRenewService");
			sp.setSiteinfoId(siteinfoId);
			spList = service.querySPList(EQueryName.SP_MSI004_CHANGE.name,sp);
			
			String codeTmp = "";
			String seqTemp = "";
			for(HistoryDetailSP sptmp : spList){
				HistoryDetailSP spResult = new HistoryDetailSP();
				if(StringUtils.equalsIgnoreCase(codeTmp, sptmp.getDocNo())){
					spResult.setDocNo("");
				}else{
					spResult.setDocNo(sptmp.getDocNo());
				}
				
				if(StringUtils.equalsIgnoreCase(seqTemp, sptmp.getSiteChangeCode())){
					spResult.setSiteChangeDesc("");
					
					spResult.setDetail(sptmp.getDetail());
					
				}else{
					spResult.setSiteChangeDesc(sptmp.getSiteChangeDesc());
					spResult.setDetail(sptmp.getDetail());
				}
				spResultList.add(spResult);
				codeTmp = sptmp.getDocNo();
				seqTemp = sptmp.getSiteChangeCode();
			}
			
			popupEditHistoryBean.setHistoryDetailSPList(spResultList);
		}catch (Exception e) {
			e.printStackTrace();
		}
		setPopupEditHistoryBean(popupEditHistoryBean);
		return flag;
	}

	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}

	
		
}
