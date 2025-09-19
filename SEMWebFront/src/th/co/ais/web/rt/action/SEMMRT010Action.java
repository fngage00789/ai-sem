package th.co.ais.web.rt.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import sap.client.service.call.WsClientService;
import th.co.ais.domain.rt.Mrt010IfrsInterface;
import th.co.ais.domain.rt.Mrt010IfrsTodolistDetail;
import th.co.ais.service.rt.IRentalMasterService;
import th.co.ais.util.ELovType;
import th.co.ais.util.EQueryName;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.rt.bean.SEMMRT010Bean;

public class SEMMRT010Action extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1621031477689965283L;

	private static final Log LOG = LogFactory.getLog(SEMMRT010Action.class);

	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		if (methodWithNavi.equalsIgnoreCase("doResend")) {
			flag = doResendToIFRS();
		} else if (methodWithNavi.equalsIgnoreCase("ToDoList")) {
			getIfrsInterface();
			flag = true;
		} else if (methodWithNavi.equalsIgnoreCase("ToDoListDetail")) {
			String backMethod = (String) getFacesUtils().getRequestParameter("backPage");
			semmrt010Bean = getSemmrt010Bean();
			semmrt010Bean.setBackPage(backMethod);
			setSemmrt010Bean(semmrt010Bean);
			flag = doDisplayToDoListDetail();
		} else if (methodWithNavi.equalsIgnoreCase("doResendToIfrsWithRefId")) {
			doResendToIfrsWithRefId();
			flag = true;
		} else if (methodWithNavi.equalsIgnoreCase("doCloseJob")) {
			flag = doCloseJob();
		} else if (methodWithNavi.equalsIgnoreCase("doUpdateRefx")) {
			flag = doUpdateRefx();
		} else if (methodWithNavi.equalsIgnoreCase("doSearch")) {
			flag = doSearch();
		} else if (methodWithNavi.equalsIgnoreCase("doClear")) {
			flag = doClear();
		} else if (methodWithNavi.equalsIgnoreCase("backPage")) {
			flag = true;
		}
		return flag;
	}

	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub
	}

	@Override
	public void init() {
		semmrt010Bean = new SEMMRT010Bean();
		semmrt010Bean.setCriteria(new Mrt010IfrsInterface());
		semmrt010Bean.setDisplayFrmTodoList(new Mrt010IfrsTodolistDetail());
		semmrt010Bean.getCriteria().setCompanyCode1("");
		semmrt010Bean.getCriteria().setRegion("");
		semmrt010Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semmrt010Bean.setRegionList(getLovItemsByType(ELovType.T_COMPANY.name));
		setSemmrt010Bean(semmrt010Bean);
		getIfrsInterface();
		// TODO Auto-generated method stub

	}

	@Override
	public boolean validate() {
		boolean flag = true;
/*		if (StringUtils.isNotEmpty(getSemmrt010Bean().getCriteria().getContractNo())) {
			return flag;
		} else {
			String msg = "";
			if (StringUtils.isEmpty(getSemmrt010Bean().getCriteria().getCompanyCode1())) {
				msg += msg("message.company");
			}
			if (StringUtils.isEmpty(getSemmrt010Bean().getCriteria().getRegion())) {
				msg += msg.isEmpty() ? msg("message.region") : ", " + msg("message.region");
			}
			if (!msg.isEmpty()) {
				addMessageError("W0001", msg);
				flag = false;
			}
		}*/
		return flag;
	}

	private SEMMRT010Bean semmrt010Bean;

	public void setSemmrt010Bean(SEMMRT010Bean semmrt010Bean) {
		this.semmrt010Bean = semmrt010Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmrt010Bean", this.semmrt010Bean);
	}

	public SEMMRT010Bean getSemmrt010Bean() {
		return (SEMMRT010Bean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(
				"semmrt010Bean");
	}

	@SuppressWarnings("unchecked")
	private void getIfrsInterface() {
		semmrt010Bean = getSemmrt010Bean();
		semmrt010Bean.setResultList(new ArrayList<WrapperBeanObject<Mrt010IfrsInterface>>());
		try {
			Mrt010IfrsInterface ifrsInterface = new Mrt010IfrsInterface();
			IRentalMasterService service = (IRentalMasterService) getBean("rentalMasterService");
			List<Mrt010IfrsInterface> itfList = service.querySPList(EQueryName.SP_MRT010_IFRS_INTERFACE_TODOLIST.name,
					ifrsInterface);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
			if (itfList != null && !itfList.isEmpty()) {
				for (Mrt010IfrsInterface v : itfList) {
					try {
						v.setCurrencyUnitPriceFormatter(Double.valueOf(v.getCurrencyUnitPrice()));
					} catch (Exception e) {
						v.setCurrencyUnitPriceFormatter(0D);
					}
					
					v.setDateFromCondition(convertYearENtoTHStr(formatter.parse(v.getDateFromCondition())));
					v.setDateUpToCondition(convertYearENtoTHStr(formatter.parse(
							(v.getDateUpToCondition()!= null && !v.getDateUpToCondition().equals("") )?v.getDateUpToCondition():v.getDateFirstContractEnd())));
					v.setFirstPostingFrom1(convertYearENtoTHStr(formatter.parse(v.getFirstPostingFrom1())));
					v.setDateFirstContractEnd(convertYearENtoTHStr(formatter.parse(v.getDateFirstContractEnd())));
					
					v.setUpdateDtStr(convertYearTimeENtoTHStr(v.getUpdateDt()));
					
					WrapperBeanObject<Mrt010IfrsInterface> tmpWrapperBean = new WrapperBeanObject<Mrt010IfrsInterface>();
					tmpWrapperBean.setDataObj(v);
					tmpWrapperBean.setMessage("");
					tmpWrapperBean.setCheckBox(false);
					semmrt010Bean.getResultList().add(tmpWrapperBean);
				}
			} else {
				semmrt010Bean.setRenderedMsgDataNotFound(true);
			}
			setSemmrt010Bean(semmrt010Bean);
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e);
		}
	}

	private void doResendToIfrsWithRefId() {
		semmrt010Bean = getSemmrt010Bean();
		String referenceId = (String) getFacesUtils().getRequestParameter("referenceId");
		semmrt010Bean.setSearchResultList(new ArrayList<WrapperBeanObject<Mrt010IfrsInterface>>());

		try {
			IRentalMasterService service = (IRentalMasterService) getBean("rentalMasterService");
			List<Mrt010IfrsInterface> refIds = service.querySPList(EQueryName.SP_MRT010_IFRS_INTERFACE.name,
					(new Mrt010IfrsInterface(referenceId)));
			if (!refIds.isEmpty() && refIds != null) {
				WsClientService sapService = new WsClientService();
				List<Mrt010IfrsInterface> resSap = new ArrayList<Mrt010IfrsInterface>();
				if(refIds.get(0).getActivity() != null && !refIds.get(0).getActivity().equals("")){
					resSap = sapService.IFRSChangeSEM(refIds);
				}else {
					resSap = sapService.IFRSCreateSEM(refIds);
				}
				
				if (!resSap.isEmpty()) {
					for (int i = 0; i < resSap.size(); i++) {
						try {
							resSap.get(i).setUserId(getUserLogIn());
							List<Mrt010IfrsInterface> updResultList = service.querySPList(
									EQueryName.SP_MRT010_IFRS_INTERFACE_UPDATE.name, resSap.get(i));
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					semmrt010Bean.getResultList().clear();
					getIfrsInterface();
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e);
		}
	}

	private boolean doResendToIFRS() {
		boolean flag = true;
		semmrt010Bean = getSemmrt010Bean();
		List<Mrt010IfrsInterface> isrfInterfaces = new ArrayList();
		List<Mrt010IfrsInterface> isrfInterfacesChange = new ArrayList();
		try {
			IRentalMasterService service = (IRentalMasterService) getBean("rentalMasterService");
			for (WrapperBeanObject<Mrt010IfrsInterface> to : semmrt010Bean.getResultList()) {
				if (to.isCheckBox()) {
					List<Mrt010IfrsInterface> refIds = service.querySPList(EQueryName.SP_MRT010_IFRS_INTERFACE.name,
							(Mrt010IfrsInterface) to.getDataObj());
					if (!refIds.isEmpty() && refIds != null) {
						
						if(refIds.get(0).getActivity() != null && !refIds.get(0).getActivity().equals("")){
							isrfInterfacesChange.add(refIds.get(0));
						}else {
							isrfInterfaces.add(refIds.get(0));
						}
					}
				}
			}
			if (!isrfInterfaces.isEmpty()) {
				WsClientService sapService = new WsClientService();
				List<Mrt010IfrsInterface> resSap = sapService.IFRSCreateSEM(isrfInterfaces);
				if (!resSap.isEmpty()) {
					for (int i = 0; i < resSap.size(); i++) {
						try {
							resSap.get(i).setUserId(getUserLogIn());
							List<Mrt010IfrsInterface> updResultList = service.querySPList(
									EQueryName.SP_MRT010_IFRS_INTERFACE_UPDATE.name, resSap.get(i));
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					 semmrt010Bean.getResultList().clear();
					 getIfrsInterface();
				}
			}
			
			if (!isrfInterfacesChange.isEmpty()) {
				WsClientService sapService = new WsClientService();
				
				
				for(int index=0 ; index< isrfInterfacesChange.size(); index++) {
					List<Mrt010IfrsInterface> resendChange = new ArrayList();
					resendChange.add(isrfInterfacesChange.get(index));
					List<Mrt010IfrsInterface> resSap = sapService.IFRSChangeSEM(resendChange);
					if (!resSap.isEmpty()) {
						for (int i = 0; i < resSap.size(); i++) {
							try {
								resSap.get(i).setUserId(getUserLogIn());
								List<Mrt010IfrsInterface> updResultList = service.querySPList(
										EQueryName.SP_MRT010_IFRS_INTERFACE_UPDATE.name, resSap.get(i));
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
						 semmrt010Bean.getResultList().clear();
						 getIfrsInterface();
					}
					String chkCodeDelay = service.callSemIfrsChkDelay("CHANGE");
					if(chkCodeDelay.equals("Y")){
						Thread.sleep(2000);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e);
		}
		return flag;
	}

	public void selectRow() {
		semmrt010Bean = getSemmrt010Bean();
		try {
			if (semmrt010Bean.getResultList() != null && semmrt010Bean.getResultList().size() > 0) {
				for (WrapperBeanObject<Mrt010IfrsInterface> to : semmrt010Bean.getResultList()) {
					if (to.isCheckBox()) {
						// semmrt010Bean.setRenderedBtnExport(true);
						break;
					} else {
						// semmrt010Bean.setRenderedBtnExport(false);
					}
				}
				setSemmrt010Bean(semmrt010Bean);
			}
		} catch (Exception e) {
			LOG.debug(e);
			e.printStackTrace();
		}
	}

	public void selectAllRow() {
		semmrt010Bean = getSemmrt010Bean();
		try {
			if (semmrt010Bean.getResultList() != null && !(semmrt010Bean.getResultList()).isEmpty()) {
				int index = 0;
				for (WrapperBeanObject<Mrt010IfrsInterface> to : semmrt010Bean.getResultList()) {
					Mrt010IfrsInterface vo = (Mrt010IfrsInterface) to.getDataObj();
					// if (StringUtils.isEmpty(vo.getVendorCode()) &&
					// StringUtils.isNotEmpty(vo.getVendorMasterId())) {
					if (StringUtils.isNotEmpty(vo.getReferenceId())) {
						if (semmrt010Bean.isChkSelAll()) {
							to.setCheckBox(Boolean.TRUE);
							// semmrt010Bean.setRenderedBtnExport(true);
						} else {
							to.setCheckBox(Boolean.FALSE);
							// semmrt010Bean.setRenderedBtnExport(false);
						}
						semmrt010Bean.getResultList().set(index, to);
					}
					// else{
					// to.setCheckBox(Boolean.FALSE);
					// }
					// semmrt010Bean.getResultList().set(index, to);
					index++;
				}
				setSemmrt010Bean(semmrt010Bean);
			}
		} catch (NullPointerException ne) {
			LOG.debug(ne);
			ne.printStackTrace();
		} catch (Exception e) {
			LOG.debug(e);
			e.printStackTrace();
		}
	}

	private boolean doDisplayToDoListDetail() {
		boolean flag = true;
		String referenceId = (String) getFacesUtils().getRequestParameter("referenceId");
		Mrt010IfrsTodolistDetail detail = new Mrt010IfrsTodolistDetail(referenceId);
		IRentalMasterService service = (IRentalMasterService) getBean("rentalMasterService");
		try {
			List<Mrt010IfrsTodolistDetail> details = service.querySPList(
					EQueryName.SP_MRT010_IFRS_TODOLIST_DETAIL.name, detail);
			if (!details.isEmpty()) {
				detail = details.get(0);
				try {
					detail.setCurrencyUnitPriceFormatter(Double.valueOf(detail.getCurrencyUnitPrice()));
				} catch (Exception e) {
					detail.setCurrencyUnitPriceFormatter(0D);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		semmrt010Bean = getSemmrt010Bean();
		semmrt010Bean.setDisplayFrmTodoList(detail);
		setSemmrt010Bean(semmrt010Bean);

		return flag;
	}

	// @SuppressWarnings("unchecked")
	// public boolean pageLoad() {
	// boolean flag = true;
	// String mode = (String) getFacesUtils().getRequestParameter("mode");
	// String referenceId = (String)
	// getFacesUtils().getRequestParameter("referenceId");
	//
	// if (mode.equals("ToDoList")) {
	// getIfrsInterface();
	// } else if (mode.equals("ToDoListDetail")) {
	// Mrt010IfrsTodolistDetail detail = new
	// Mrt010IfrsTodolistDetail(referenceId);
	// IRentalMasterService service = (IRentalMasterService)
	// getBean("rentalMasterService");
	// try {
	// List<Mrt010IfrsTodolistDetail> details = service.querySPList(
	// EQueryName.SP_MRT010_IFRS_TODOLIST_DETAIL.name, detail);
	// if (!details.isEmpty()) {
	// detail = details.get(0);
	// try {
	// detail.setCurrencyUnitPriceFormatter(Double.valueOf(detail.getCurrencyUnitPrice()));
	// } catch (Exception e) {
	// detail.setCurrencyUnitPriceFormatter(0D);
	// }
	// }
	// } catch (Exception e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// semmrt010Bean = getSemmrt010Bean();
	// semmrt010Bean.setDisplayFrmTodoList(detail);
	// setSemmrt010Bean(semmrt010Bean);
	// }
	// return flag;
	// }

	private boolean doCloseJob() {
		boolean flag = true;
		semmrt010Bean = getSemmrt010Bean();
		semmrt010Bean.setResultList(new ArrayList<WrapperBeanObject<Mrt010IfrsInterface>>());
		semmrt010Bean.setSearchResultList(new ArrayList<WrapperBeanObject<Mrt010IfrsInterface>>());

		String referenceId = (String) getFacesUtils().getRequestParameter("referenceId");
		Mrt010IfrsInterface ifrs = new Mrt010IfrsInterface();
		ifrs.setReferenceId(referenceId);
		ifrs.setUserId(getUserLogIn());
		IRentalMasterService service = (IRentalMasterService) getBean("rentalMasterService");
		try {
			List<Mrt010IfrsInterface> itfList = service.querySPList("spMrt010IfrsCloseJob", ifrs);
			if (itfList != null && !itfList.isEmpty()) {
				for (Mrt010IfrsInterface v : itfList) {
					try {
						v.setCurrencyUnitPriceFormatter(Double.valueOf(v.getCurrencyUnitPrice()));
					} catch (Exception e) {
						v.setCurrencyUnitPriceFormatter(0D);
					}
					WrapperBeanObject<Mrt010IfrsInterface> tmpWrapperBean = new WrapperBeanObject<Mrt010IfrsInterface>();
					tmpWrapperBean.setDataObj(v);
					tmpWrapperBean.setMessage("");
					tmpWrapperBean.setCheckBox(false);
					semmrt010Bean.getResultList().add(tmpWrapperBean);
				}
			} else {
				semmrt010Bean.setRenderedMsgDataNotFound(true);
			}
			setSemmrt010Bean(semmrt010Bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	private boolean doUpdateRefx() {
		boolean flag = true;
		semmrt010Bean = getSemmrt010Bean();
		semmrt010Bean.setResultList(new ArrayList<WrapperBeanObject<Mrt010IfrsInterface>>());
		semmrt010Bean.setSearchResultList(new ArrayList<WrapperBeanObject<Mrt010IfrsInterface>>());

		String referenceId = (String) getFacesUtils().getRequestParameter("referenceId");
		Mrt010IfrsInterface ifrs = new Mrt010IfrsInterface();
		ifrs.setReferenceId(referenceId);
		ifrs.setUserId(getUserLogIn());
		ifrs.setSapRefxNo(semmrt010Bean.getDisplayFrmTodoList().getRefxNo());
		IRentalMasterService service = (IRentalMasterService) getBean("rentalMasterService");
		try {
			List<Mrt010IfrsInterface> itfList = service.querySPList("spMrt010IfrsUpdateRxfx", ifrs);
			if (itfList != null && !itfList.isEmpty()) {
				for (Mrt010IfrsInterface v : itfList) {
					try {
						v.setCurrencyUnitPriceFormatter(Double.valueOf(v.getCurrencyUnitPrice()));
					} catch (Exception e) {
						v.setCurrencyUnitPriceFormatter(0D);
					}
					WrapperBeanObject<Mrt010IfrsInterface> tmpWrapperBean = new WrapperBeanObject<Mrt010IfrsInterface>();
					tmpWrapperBean.setDataObj(v);
					tmpWrapperBean.setMessage("");
					tmpWrapperBean.setCheckBox(false);
					semmrt010Bean.getResultList().add(tmpWrapperBean);
				}
			} else {
				semmrt010Bean.setRenderedMsgDataNotFound(true);
			}
			setSemmrt010Bean(semmrt010Bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	private boolean doSearch() {
		boolean flag = false;
		semmrt010Bean = getSemmrt010Bean();
		semmrt010Bean.setSearchResultList(new ArrayList<WrapperBeanObject<Mrt010IfrsInterface>>());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		
		if (validate()) {
			// Passed validation
			semmrt010Bean.setRenderedMsgFormSearch(false);
			IRentalMasterService service = (IRentalMasterService) getBean("rentalMasterService");
			try {
				List<Mrt010IfrsInterface> itfList = service.querySPList("spMrt010IfrsInterfaceSearch", semmrt010Bean
						.getCriteria());
				if (itfList != null && !itfList.isEmpty()) {
					for (Mrt010IfrsInterface v : itfList) {
						try {
							v.setCurrencyUnitPriceFormatter(Double.valueOf(v.getCurrencyUnitPrice()));
						} catch (Exception e) {
							v.setCurrencyUnitPriceFormatter(0D);
						}
						v.setDateFromCondition(convertYearENtoTHStr(formatter.parse(v.getDateFromCondition())));
						v.setDateUpToCondition(convertYearENtoTHStr(formatter.parse(
								(v.getDateUpToCondition()!= null && !v.getDateUpToCondition().equals("") )?v.getDateUpToCondition():v.getDateFirstContractEnd())));
						v.setFirstPostingFrom1(convertYearENtoTHStr(formatter.parse(v.getFirstPostingFrom1())));
						v.setDateFirstContractEnd(convertYearENtoTHStr(formatter.parse(v.getDateFirstContractEnd())));
						
						v.setUpdateDtStr(convertYearTimeENtoTHStr(v.getUpdateDt()));
						
						WrapperBeanObject<Mrt010IfrsInterface> tmpWrapperBean = new WrapperBeanObject<Mrt010IfrsInterface>();
						tmpWrapperBean.setDataObj(v);
						tmpWrapperBean.setMessage("");
						tmpWrapperBean.setCheckBox(false);
						semmrt010Bean.getSearchResultList().add(tmpWrapperBean);
					}
				} else {
					semmrt010Bean.setRenderedMsgDataNotFound(true);
				}
				setSemmrt010Bean(semmrt010Bean);
			} catch (Exception e) {
				e.printStackTrace();
				LOG.error(e);
			}
		} else {
			// Failed validation and show error message
			semmrt010Bean.setRenderedMsgFormSearch(true);
		}

		semmrt010Bean.setScrollerPage("");
		setSemmrt010Bean(semmrt010Bean);
		return flag;
	}

	private boolean doClear() {
		boolean flag = true;

		semmrt010Bean = getSemmrt010Bean();
		semmrt010Bean.setCriteria(new Mrt010IfrsInterface());
		semmrt010Bean.getSearchResultList().clear();
		setSemmrt010Bean(semmrt010Bean);

		return flag;
	}
	
	public static void main(String[] args) {
		String str = "";
		System.out.println(str != "");
	}
}
