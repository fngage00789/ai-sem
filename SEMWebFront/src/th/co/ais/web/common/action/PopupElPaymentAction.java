package th.co.ais.web.common.action;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import th.co.ais.domain.cp.PopupVendorSupplierSearchSP;
import th.co.ais.domain.el.Payment;
import th.co.ais.service.el.IPaymentService;
import th.co.ais.service.si.ISendRenewService;
import th.co.ais.util.EQueryName;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.bean.common.PopupElPaymentBean;
import th.co.ais.web.el.bean.SEMMEL005Bean;
import th.co.ais.web.util.ELUtils;
import th.co.ais.web.util.FrontMessageUtils;
import th.co.ais.web.util.LOVCacheUtil;
import th.co.ais.web.util.MSGCacheUtil;
import th.co.ais.web.util.config.ParameterConfigUtil;

public class PopupElPaymentAction extends AbstractAction{

	private static final long serialVersionUID = 154181415663741549L;
	private Logger LOG = Logger.getLogger(getClass());
	private String ERROR_CODE_NO_DATA_FOUND = "M0004";
	private String RECORD_STATUS_Y = "Y";
	private String EXPENSE_TYPE = "EL_BILL";
	private String LOV_TYPE_EL_PAYMENT_STATUS  = "EL_PAYMENT_STATUS";
	private static final ResourceBundle RS_BUNDLE_POPUP_EL_PAYMENT = ResourceBundle.getBundle("resources.popup.popup-el-payment");
	private SEMMEL005Bean semmel005Bean;
	
	public SEMMEL005Bean getSemmel005Bean() {
		return (SEMMEL005Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmel005Bean");
	}
	private String getMessage(String key) {
		return RS_BUNDLE_POPUP_EL_PAYMENT.getString(key);
	}
	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		if(methodWithNavi.equalsIgnoreCase("doSearch")){
			flag = doSearch();
		}else if(methodWithNavi.equalsIgnoreCase("initPopup")){
			flag = initPopup();
		}else if(methodWithNavi.equalsIgnoreCase("doSelectPayment")){
			flag = doSelectPayment();
		}else if(methodWithNavi.equalsIgnoreCase("doClearPopupElPayment")){
			flag = doClearPopupElPayment();
		}
		
		return flag;
	}

	private boolean doClearPopupElPayment() {
		boolean returnFalg = false;
		try{
			LOG.info("START Action doClearPopupElPayment");
			popupElPaymentBean = getPopupElPaymentBean();
			semmel005Bean      = getSemmel005Bean();
			popupElPaymentBean.setDocNo(null);
			popupElPaymentBean.setPaymentList(new ArrayList<Payment>());
			
			semmel005Bean.setDocDTFrom(null);
			semmel005Bean.setDocDTTo(null);
			
			LOG.info("END Action doClearPopupElPayment");
			
		}catch(Exception e){
			e.printStackTrace();
			LOG.info("ERROR Action doClearPopupElPayment : "+e, e);
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = errorMsg.replace("{0}", "Popup EL Payment");
			FrontMessageUtils.addMessageError(errorMsg);
			//returnFalg = false;			
		}		
		
		return returnFalg;
	}

	private boolean doSelectPayment() {
		
		boolean returnFalg = false;
		try{
			LOG.info("START Action doSelectPayment");
			popupElPaymentBean = getPopupElPaymentBean();
			
			String refDocNo = (String)getFacesUtils().getRequestParameter("refDocNo");
			String docNo = (String)getFacesUtils().getRequestParameter("docNo");
			String paymentId = (String ) getFacesUtils().getRequestParameter("paymentId");
			String rowIndex = (String) getFacesUtils().getRequestParameter("index");
			
			LOG.debug("WT###Print rowIndex="+rowIndex);
			
			Payment payment = popupElPaymentBean.getPaymentList().get(new Integer(rowIndex).intValue());
			
			LOG.debug("WT###Print payment.getRowId="+payment.getRowId()); 
						
			String paymentStatus = ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType("CT_PAYMENT_STATUS"), payment.getPaymentStatus());
			String elImportStatus = payment.getElImportStatusDetail();
			
			payment.setPaymentStatus(paymentStatus);
			LOG.debug("paymentStatus="+paymentStatus);
			LOG.debug("payment.getElImportStatusDetail()="+payment.getElImportStatusDetail());
			LOG.debug("payment.getElImportStatus: ="+payment.getElImportStatus());
			//LOG.debug("payment.getPaymentStatusDisplay()="+payment.get ;
			
			popupElPaymentBean.setRefDocNo(refDocNo);
			popupElPaymentBean.setPaymentId(paymentId);
			popupElPaymentBean.setDocNo(docNo);
			popupElPaymentBean.setPayment(payment);
			
			
			LOG.info("END Action doSelectPayment");
		}catch(Exception e){
			LOG.error("ERROR Action doSelectPayment : "+e, e);
		}		
		
		return returnFalg;
	}
	
	private boolean doSearch(){
		boolean returnFalg = false;
		try{
			LOG.info("START Action doSearch");
			
			popupElPaymentBean   = getPopupElPaymentBean();
			semmel005Bean        = this.getSemmel005Bean();
			String  company      = semmel005Bean.getCompany();
			String fileType      = semmel005Bean.getFileType();
			String elecUseType   = "";
			Date docDTFrom       = semmel005Bean.getDocDTFrom();
			Date docDTTo         = semmel005Bean.getDocDTTo();
			
			if(fileType.equalsIgnoreCase("10001") || fileType.equalsIgnoreCase("10002")){
				elecUseType = "MEA";
			}else{
				elecUseType = "PEA";
			}
			LOG.info(" fileType()()" + fileType);
			LOG.info(" fileType()()" + company);
			LOG.info(" elecUseType()()" + elecUseType);
			LOG.info(" docDTFrom()()" + docDTFrom);
			LOG.info(" docDTTo()()" + docDTTo);
			
			if(docDTFrom != null && docDTTo!=null){
			  if(docDTFrom.compareTo(docDTTo)>0){
				  String errorMsg = this.getMessage("msg.dcoDT");
				  FrontMessageUtils.addMessageError(errorMsg);
				 return returnFalg = true;	
			  }
			}
			
			IPaymentService paymentService = (IPaymentService) getBean("paymentService");
			String docNo = (String)getFacesUtils().getRequestParameter("docNo");

			Payment payment = new Payment();
			payment.setDocNo(popupElPaymentBean.getDocNo());
			payment.setRecordStatus(RECORD_STATUS_Y);
			payment.setExpenseType(EXPENSE_TYPE);
			payment.setCompany(company);
			payment.setElectricUseType(elecUseType);
			payment.setDocDtFrom(docDTFrom);
			payment.setDocDtTo(docDTTo);
			LOG.info("START Service queryPaymentByCriteria4Popup");
			List<Payment> paymentList = paymentService.queryPaymentByCriteria4Popup(payment);
			LOG.info("END Service queryPaymentByCriteria4Popup");
			List<Payment> paymentLists = new ArrayList();
			if(null==paymentList || paymentList.isEmpty()){
				addMessageError(ERROR_CODE_NO_DATA_FOUND);
				popupElPaymentBean.setPaymentList(new ArrayList<Payment>());
				//returnFalg = false;
			}else{
				
				for(Payment paymentObj : paymentList){
					paymentObj.setPaymentStatusDisplay(ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(LOV_TYPE_EL_PAYMENT_STATUS), paymentObj.getPaymentStatus()));
					
					//LOG.info("zzzzzz  paymentObj.getElImportStatus():"+paymentObj.getElImportStatus());
					
					if(paymentObj.getElImportStatus()== null){
					   paymentObj.setElImportStatusDetail("-");
					}else{
						paymentObj.setElImportStatusDetail(getMessage("msg.invImportStatus"));	
					}
					paymentLists.add(paymentObj);
					
					//LOG.info("zzzzzz paymentObj.getElImportStatusDetail():"+paymentObj.getElImportStatusDetail());
				
				}
				
				popupElPaymentBean.setPaymentList(paymentLists);
				/*
				for(Payment paymentObj : popupElPaymentBean.getPaymentList()){
					
					LOG.info("paymentObj.getElImportStatusDetail() 2:"+paymentObj.getElImportStatusDetail());
					
				}
				*/
				//returnFalg = true;
			}
			
			LOG.info("END Action doSearch");
		}catch(Exception e){
			e.printStackTrace();
			LOG.info("ERROR Action doSearch : "+e, e);
			String errorMsg = MSGCacheUtil.getInstance().getMessageByCode("EL0000");
			errorMsg = errorMsg.replace("{0}", "Popup EL Payment");
			FrontMessageUtils.addMessageError(errorMsg);
			//returnFalg = false;			
		}		
		
		return returnFalg;
	}
	
	private PopupElPaymentBean popupElPaymentBean;
	
	public PopupElPaymentBean getPopupElPaymentBean() {
		return (PopupElPaymentBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("popupElPaymentBean");
	}

	public void setPopupElPaymentBean(PopupElPaymentBean popupElPaymentBean) {
		this.popupElPaymentBean = popupElPaymentBean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("popupElPaymentBean",popupElPaymentBean);
	}
	
//	public PopupVendorSupplierBean getPopupVendorSupplierBean() {
//		return (PopupVendorSupplierBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("popupVendorSupplierBean");
//	}
//	public void setPopupVendorSupplierBean(PopupVendorSupplierBean popupVendorSupplierBean) {
//		this.popupVendorSupplierBean = popupVendorSupplierBean;
//		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("popupVendorSupplierBean",popupVendorSupplierBean);
//	}

	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub
	}

	@Override
	public void init() {
		LOG.info("START Action init");
		PopupElPaymentBean popupElPaymentBean = new PopupElPaymentBean();
		setPopupElPaymentBean(popupElPaymentBean);
		LOG.info("END Action init");
	}
	
	private boolean initPopup(){
		LOG.info("START Action initPopup");
		PopupElPaymentBean popupElPaymentBean = new PopupElPaymentBean();
		setPopupElPaymentBean(popupElPaymentBean);
		LOG.info("END Action initPopup");
		return false;
	}

	@Override
	public boolean validate() {
		boolean flgValid = true;
		
		/*if(StringUtils.isEmpty(getPopupVendorSupplierBean().getPopupVendorSupplierSearchSP().getVendorCodeCri()) 
			&& StringUtils.isEmpty(getPopupVendorSupplierBean().getPopupVendorSupplierSearchSP().getNameCri())
			&& StringUtils.isEmpty(getPopupVendorSupplierBean().getPopupVendorSupplierSearchSP().getIdentityIdCri())
			&& StringUtils.isEmpty(getPopupVendorSupplierBean().getPopupVendorSupplierSearchSP().getTaxIdCri())){
			addMessageError("W0004", msg("message.validateCondition"));
			flgValid = false;
		}*/
		return flgValid;
	}
	

}
