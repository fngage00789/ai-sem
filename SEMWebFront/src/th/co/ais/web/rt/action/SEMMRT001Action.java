package th.co.ais.web.rt.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.richfaces.component.UITree;
import org.richfaces.component.html.HtmlTree;
import org.richfaces.event.NodeSelectedEvent;
import org.richfaces.model.TreeNode;
import org.richfaces.model.TreeNodeImpl;

import sap.client.service.call.WsClientService;
import th.co.ais.common.service.IMenuTreeService;
import th.co.ais.domain.common.MenuTreeSP;
import th.co.ais.domain.el.ELVerifyCondSP;
import th.co.ais.domain.gm.CT001Export;
import th.co.ais.domain.gm.Province;
import th.co.ais.domain.gm.VendorMasterSP;
import th.co.ais.domain.gm.Zone;
import th.co.ais.domain.rt.CheckVendor;
import th.co.ais.domain.rt.DepositCondMapSi;
import th.co.ais.domain.rt.DepositDetail;
import th.co.ais.domain.rt.Mrt001BalanceCal;
import th.co.ais.domain.rt.Mrt001BookBank;
import th.co.ais.domain.rt.Mrt001CheckDate;
import th.co.ais.domain.rt.Mrt010IfrsInterface;
import th.co.ais.domain.rt.Mrt001RentCal;
import th.co.ais.domain.rt.Mrt001SrchDpstCond;
import th.co.ais.domain.rt.Mrt001SrchDpstDetail;
import th.co.ais.domain.rt.Mrt001SrchPayee;
import th.co.ais.domain.rt.Mrt001SrchRentDetail;
import th.co.ais.domain.rt.Mrt001SrchRentHist;
import th.co.ais.domain.rt.Mrt001SrchRentPay;
import th.co.ais.domain.rt.Mrt001SrchVendor;
import th.co.ais.domain.rt.Mrt001UpdDpstMap;
import th.co.ais.domain.rt.Mrt001UpdDpstPay;
import th.co.ais.domain.rt.Mrt001UpdRentJob;
import th.co.ais.domain.rt.Mrt001UpdRentMap;
import th.co.ais.domain.rt.Mrt001UpdRentPay;
import th.co.ais.domain.rt.Mrt001UpdatePeriod;
import th.co.ais.domain.rt.Mrt001VerifyStatus;
import th.co.ais.domain.rt.RentalCondMapSi;
import th.co.ais.domain.rt.RentalDetail;
import th.co.ais.domain.rt.RentalMaster;
import th.co.ais.domain.rt.RentalPayNormalSearchDSP;
import th.co.ais.domain.rt.VerifyRentalSearchSiteInfoSP;
import th.co.ais.domain.rt.VerifyRentalSearchSiteRentCondSP;
import th.co.ais.domain.si.Msi004CalcAgeSP;
import th.co.ais.rpt.util.bean.CellDomain;
import th.co.ais.service.el.IManagementService;
import th.co.ais.service.gm.ILovMasterService;
import th.co.ais.service.gm.IProvinceService;
import th.co.ais.service.gm.IVendorMasterService;
import th.co.ais.service.rt.IDepositDetailService;
import th.co.ais.service.rt.IRentalDetailService;
import th.co.ais.service.rt.IRentalMasterService;
import th.co.ais.service.rt.IRentalPaymentService;
import th.co.ais.service.si.ISiteDepositService;
import th.co.ais.util.ELovType;
import th.co.ais.util.EQueryName;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.bean.TreeUtilBean;
import th.co.ais.web.bean.common.PopupUploadFilePictureBean;
import th.co.ais.web.el.bean.SEMMEL001Bean;
import th.co.ais.web.rt.bean.SEMMRT001Bean;
import th.co.ais.web.rt.bean.SEMMRT003Bean;
import th.co.ais.web.util.ELUtils;
import th.co.ais.web.util.FacesUtils;
import th.co.ais.web.util.FrontMessageUtils;
import th.co.ais.web.util.LOVCacheUtil;
import th.co.ais.web.util.MSGCacheUtil;
import th.co.ais.web.util.RegionCacheUtil;
import th.co.ais.web.util.SelectItemLOVCacheUtil;
import th.co.ais.web.util.SemUtils;

public class SEMMRT001Action extends AbstractAction {

	private static final long serialVersionUID = 8162443051904813384L;

	private static final Log LOG = LogFactory.getLog(SEMMRT001Action.class);

	private PopupUploadFilePictureBean popupUploadFilePictureBean;
	

	public void setPopupUploadFilePictureBean(PopupUploadFilePictureBean popupUploadFilePictureBean) {
		this.popupUploadFilePictureBean = popupUploadFilePictureBean;
		getFacesUtils().setSessionMapValue("popupUploadFilePictureBean", popupUploadFilePictureBean);
	}

	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		if (methodWithNavi.equalsIgnoreCase("doSearch")) {
			flag = doSearch();
		} else if (methodWithNavi.equalsIgnoreCase("doClear")) {
			flag = doClear();
		} else if (methodWithNavi.equalsIgnoreCase("pageLoad")) {
			flag = pageLoad();
		} else if (methodWithNavi.equalsIgnoreCase("doUpdateRentalMaster")) {
			flag = doUpdateRentalMaster();
		} else if (methodWithNavi.equalsIgnoreCase("doAddRentalDetail")) {
			flag = doAddRentalDetail();
		} else if (methodWithNavi.equalsIgnoreCase("getRentalDetailById")) {
			flag = getRentalDetailById();
		} else if (methodWithNavi.equalsIgnoreCase("doClearRentalDetail")) {
			flag = doClearRentalDetail();
		} else if (methodWithNavi.equalsIgnoreCase("doDeleteRentalDetail")) {
			flag = doDeleteRentalDetail();
		} else if (methodWithNavi.equalsIgnoreCase("doAddDpstDetail")) {
			flag = doAddDpstDetail();
		} else if (methodWithNavi.equalsIgnoreCase("getDpstDetailById")) {
			flag = getDpstDetailById();
		} else if (methodWithNavi.equalsIgnoreCase("doClearDpstDetail")) {
			flag = doClearDpstDetail();
		} else if (methodWithNavi.equalsIgnoreCase("doDeleteDpstDetail")) {
			flag = doDeleteDpstDetail();
		} else if (methodWithNavi.equalsIgnoreCase("doApprove")) {
			flag = doApprove();
		} else if (methodWithNavi.equalsIgnoreCase("doDefaultDate")) {
			flag = doDefaultDate();
		} else if (methodWithNavi.equalsIgnoreCase("doDefaultDateDpst")) {
			flag = doDefaultDateDpst();
		} else if (methodWithNavi.equalsIgnoreCase("doBackPage")) {
			flag = doBackPage();
		} else if (methodWithNavi.equalsIgnoreCase("doUpdateAfterWarning")) {
			flag = doUpdateAfterWarning();
		} else if (methodWithNavi.equalsIgnoreCase("doCalculate")) {
			flag = doCalculate();
		} else if (methodWithNavi.equalsIgnoreCase("doCheckBeforeSaveRentalMaster")) {
			flag = doCheckBeforeSaveRentalMaster();
		} else if (methodWithNavi.equalsIgnoreCase("doLoadCheckPremium")) {
			flag = doLoadCheckPremium();
		} else if (methodWithNavi.equalsIgnoreCase("doCalculateBalance")) {
			flag = doCalculateBalance();
		} else if (methodWithNavi.equalsIgnoreCase("doNewDepositDetail")) {
			doNewDepositDetail();
		} else if (methodWithNavi.equalsIgnoreCase("initEditPeriod")) {
			initEditPeriod();
		} else if (methodWithNavi.equalsIgnoreCase("doUpdatePeriod")) {
			doUpdatePeriod();
		} else if (methodWithNavi.equalsIgnoreCase("getTreeNode")) {
			getTreeNode();
		}
		// 2015/01/26 added by.. YUT
		else if (methodWithNavi.equalsIgnoreCase("doInitialForSearchRental")) {
			flag = this.doInitialForSearchRental();
		} else if (methodWithNavi.equalsIgnoreCase("doInitTodoList")) {
			flag = this.doInitTodoList();
			// 2015/01/26 added by Kanruethai.T
		} else if (methodWithNavi.equalsIgnoreCase("doSaveServiceCal")) {
			// flag = doSaveServiceCal();
			this.doSaveServiceCal();
		}

		// else if (methodWithNavi.equalsIgnoreCase("doNewRentalDetail")) {
		// flag = doNewRentalDetail();
		// }
		return flag;
	}

	@Override
	public void clearSessionNotUsed() {

		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		semmrt001Bean = new SEMMRT001Bean();

		semmrt001Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semmrt001Bean.setRegionList(RegionCacheUtil.getInstance().getRegionSelList());
		semmrt001Bean.setReqTypeList(SelectItemLOVCacheUtil.getInstance().getLovItemsByTypeExceptLovCodes(
				ELovType.T_SI_APPROVE_TYPE.name, "98"));
		semmrt001Bean.setSiteTypeList(SelectItemLOVCacheUtil.getInstance().getLovItemsByType(
				ELovType.T_SI_SITE_TYPE.name, EX_AND, "RT", null, null));
		semmrt001Bean.setVerifyStatusList(SelectItemLOVCacheUtil.getInstance().getLovItemsByType(
				ELovType.T_RT_VERIFY_STATUS.name, EX_AND, "01", null, null));
		semmrt001Bean.setExpenseTypeList(SelectItemLOVCacheUtil.getInstance().getLovItemsByType(
				ELovType.T_CT_EXPENSE_TYPE.name));
		semmrt001Bean.setRentalStatusList(SelectItemLOVCacheUtil.getInstance().getLovItemsByType(
				ELovType.T_RT_RENTAL_JOB_STATUS.name));
		semmrt001Bean.setVendorList(getEmptyDropDown());
		semmrt001Bean.setPayeeList(getEmptyDropDown());

		semmrt001Bean.setCriteria(new VerifyRentalSearchSiteInfoSP());
		semmrt001Bean.getCriteria().setSiteType("");
		semmrt001Bean.getCriteria().setVerifyStatus("00");
		semmrt001Bean.getCriteria().setCurrentFlag("Y");
		semmrt001Bean.setDisApprove(false);
		semmrt001Bean.setRentPayList(new ArrayList<Mrt001SrchRentPay>());

		//

		semmrt001Bean.setTreeUtilBean(new TreeUtilBean());
		PopupUploadFilePictureBean uploadBean = new PopupUploadFilePictureBean();
		uploadBean.setModuleList(new ArrayList<SelectItem>());
		uploadBean.setSubModuleList(new ArrayList<SelectItem>());
		setPopupUploadFilePictureBean(uploadBean);

		LOG.debug(semmrt001Bean.getCompanyList());
		for (SelectItem list : semmrt001Bean.getCompanyList()) {
			LOG.debug("label : " + list.getLabel() + " , value : " + list.getValue());
		}

		setSemmrt001Bean(semmrt001Bean);
	}

	@Override
	public boolean validate() {
		boolean flag = true;

		if (StringUtils.isNotEmpty(getSemmrt001Bean().getCriteria().getContractNo())) {
			return flag;
		} else if (StringUtils.isEmpty(getSemmrt001Bean().getCriteria().getCompany())) {
			addMessageError("W0001", msg("message.company"));
			flag = false;
		}

		return flag;
	}

	private boolean doBackPage() {
		boolean flag = true;

		String navProgram = (String) getFacesUtils().getRequestParameter("navProgram");
		if (navProgram.equals("SEMMRT001-1")) {
			// doSearch();
			searchVerifyRental();
		} else {
			semmrt001Bean = getSemmrt001Bean();
			initPageDeposit();
			setSemmrt001Bean(semmrt001Bean);
		}

		return flag;
	}

	private SEMMRT001Bean semmrt001Bean;

	public SEMMRT001Bean getSemmrt001Bean() {
		return (SEMMRT001Bean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(
				"semmrt001Bean");
	}

	public void setSemmrt001Bean(SEMMRT001Bean semmrt001Bean) {
		this.semmrt001Bean = semmrt001Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmrt001Bean", this.semmrt001Bean);
	}

	@SuppressWarnings("unchecked")
	private void searchVerifyRental() {
		semmrt001Bean = getSemmrt001Bean();
		semmrt001Bean.setResultList(new ArrayList<WrapperBeanObject<VerifyRentalSearchSiteInfoSP>>());
		List<VerifyRentalSearchSiteInfoSP> to = null;
		try {
			if (semmrt001Bean.getCriteria().isChkNoVendorId()) {
				semmrt001Bean.getCriteria().setNoVendorCode("Y");
			} else {
				semmrt001Bean.getCriteria().setNoVendorCode("N");
			}
			if (semmrt001Bean.getCriteria().isChkPico()) {
				semmrt001Bean.getCriteria().setPicoFlag("Y");
			} else {
				semmrt001Bean.getCriteria().setPicoFlag("N");
			}
			if (semmrt001Bean.isChkCurrentFlg()) {
				semmrt001Bean.getCriteria().setCurrentFlag("N");
			} else {
				semmrt001Bean.getCriteria().setCurrentFlag("Y");
			}
			IRentalDetailService service = (IRentalDetailService) getBean("rentalDetailService");

			to = service.querySPList(EQueryName.Q_SEARCH_VERIFY_RENTAL_BY_SITE_INFO.name, semmrt001Bean.getCriteria());

			if (to != null && !to.isEmpty()) {
				semmrt001Bean.setRenderedMsgDataNotFound(false);

				String tempId = "";
				for (VerifyRentalSearchSiteInfoSP v : to) {
					WrapperBeanObject<VerifyRentalSearchSiteInfoSP> tmpWrapperBean = new WrapperBeanObject<VerifyRentalSearchSiteInfoSP>();
					// Check merge rows
					
					if (tempId.equals(v.getSiteInfoId())) {
						v.setRenderColumn(false);
						v.setRenderSave(false);
					} else {
						tempId = v.getSiteInfoId();
						v.setRenderColumn(true);
						if ((v.getReqType().equals("05") || v.getReqType().equals("06") || v.getReqType().equals("99"))) {
							v.setRenderSave(true);
						} else if (StringUtils.isNotEmpty(v.getVendorCode())) {
							v.setRenderSave(true);
						} else {
							v.setRenderSave(false);
						}
					}

					// Convert object date to string for displaying.
					// v.setStrEffDate(SEMDataUtility.toStringThaiDateTimeSimpleFormat(v.getEffDate()));
					// if(v.getExpireDate() != null){
					// v.setStrExpireDate(SEMDataUtility.toStringThaiDateTimeSimpleFormat(v.getExpireDate()));
					// }
					if (v.getEffDate() != null) {
						v.setStrEffDate(SEMDataUtility.toStringEngDateTimeSimpleFormat(v.getEffDate()));
					}
					if (v.getExpireDate() != null) {
						v.setStrExpireDate(SEMDataUtility.toStringEngDateTimeSimpleFormat(v.getExpireDate()));
					}

					if (v.getCycleNo() == null) {
						v.setCycleNo(0.00);
					}
					if (v.getSeqNo() == null) {
						v.setSeqNo(0.00);
					}
					// v.setStrEffDate(convertYearENtoTHStr(v.getEffDate())+" 00:00:00");
					// if(v.getExpireDate() != null){
					// v.setStrExpireDate(convertYearENtoTHStr(v.getExpireDate())+" 00:00:00");
					// }

					// v.setEffDate(convertYearENtoTH(v.getEffDate()));
					// v.setExpireDate(convertYearENtoTH(v.getExpireDate()));
					v.setEffDateStr(convertYearENtoTHStr(v.getEffDate()));
					v.setExpireDateStr(convertYearENtoTHStr(v.getExpireDate()));
					v.setCreateDtStr(getParameterDateStr(v.getCreateDt()));
					v.setUpdateDtStr(getParameterDateStr(v.getUpdateDt()));
					v.setPendingDateStr(getParameterDateStr(v.getPendingDate()));
					v.setTerminateDtStr(getParameterDateStr(v.getTerminateDt()));

					tmpWrapperBean.setDataObj(v);
					tmpWrapperBean.setMessage("");
					tmpWrapperBean.setCheckBox(false);
					semmrt001Bean.getResultList().add(tmpWrapperBean);
					
				}
			} else {
				// Set enable render message not found
				semmrt001Bean.setRenderedMsgDataNotFound(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e);
		}
	}

	private boolean doSearch() {
		boolean flag = false;
		semmrt001Bean = getSemmrt001Bean();
		semmrt001Bean.setRenderedBtnExport(false);
		semmrt001Bean.setChkSelAll(false);
		semmrt001Bean.setDisabledExpenseType(true);
		semmrt001Bean.setRentCondSpecial(new VerifyRentalSearchSiteRentCondSP());
		semmrt001Bean.setServCondSpecial(new VerifyRentalSearchSiteRentCondSP());
		semmrt001Bean.setServCondSpecial2(new VerifyRentalSearchSiteRentCondSP());
		semmrt001Bean.setServCondSpecial3(new VerifyRentalSearchSiteRentCondSP());
		semmrt001Bean.setSpecialChk1(false);
		semmrt001Bean.setSpecialChk2(false);
		semmrt001Bean.setSpecialChk3(false);
		semmrt001Bean.setSpecialChk4(false);
		semmrt001Bean.setDisabledSpacialChk(true);
		if (semmrt001Bean.getCriteria().getStrParam() != null) {
			// incase search from To Do List
			semmrt001Bean.setRenderedMsgFormSearch(false);
			searchVerifyRental();

		} else {

			if (validate()) {
				// Passed validation
				semmrt001Bean.setRenderedMsgFormSearch(false);
				searchVerifyRental();
			} else {
				// Failed validation and show error message
				semmrt001Bean.setRenderedMsgFormSearch(true);
			}
		}

		semmrt001Bean.setScrollerPage("");
		setSemmrt001Bean(semmrt001Bean);
		return flag;
	}

	private boolean doClear() {
		boolean flag = false;
		semmrt001Bean = getSemmrt001Bean();

		semmrt001Bean.setRenderedMsgDataNotFound(false);
		semmrt001Bean.setCriteria(new VerifyRentalSearchSiteInfoSP());
		semmrt001Bean.getCriteria().setSiteType("");
		semmrt001Bean.setChkCurrentFlg(false);
		semmrt001Bean.getCriteria().setCurrentFlag("Y");
		semmrt001Bean.getCriteria().setChkNoVendorId(false);
		semmrt001Bean.setResultList(null);
		semmrt001Bean.setTreeUtilBean(new TreeUtilBean());

		// added by NEW 18/03/2015 for to do list page
		semmrt001Bean.setTreeUtilBean(new TreeUtilBean());
		semmrt001Bean.setRootNode(new TreeNodeImpl());
		rootNode = null;
		semmrt001Bean.setMenuTreeMacroList(new ArrayList<WrapperBeanObject<MenuTreeSP>>());
		semmrt001Bean.setMenuTreePicoList(new ArrayList<WrapperBeanObject<MenuTreeSP>>());
		semmrt001Bean.setTreeMacroFlag(false);
		semmrt001Bean.setTreePicoFlag(false);
		setSemmrt001Bean(semmrt001Bean);
		return flag;
	}

	private RentalMaster saveRentalMaster(RentalMaster o) {
		IRentalMasterService service = (IRentalMasterService) getBean("rentalMasterService");
		try {
			return service.createRentalMaster(o);
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e);
			return null;
		}
	}

	private boolean doApprove() {
		semmrt001Bean = getSemmrt001Bean();
		IRentalMasterService service = (IRentalMasterService) getBean("rentalMasterService");
		try {

			RentalMaster o = service.queryByRowId(semmrt001Bean.getDisplayFrmRental().getRentalMasterId());
			o.setVerifyStatus("02");
			o.setCurrentUser(getUserLogIn());
			o = service.updateRentalMaster(o);

			semmrt001Bean.getDisplayFrmRental().setRentalJobStatus(o.getRentalJobStatus());
			semmrt001Bean.getDisplayFrmRental().setVerifyStatus(o.getVerifyStatus());
			semmrt001Bean.getDisplayFrmRental().setCreateBy(o.getCreateBy());
			semmrt001Bean.getDisplayFrmRental().setCreateDt(o.getCreateDt());
			semmrt001Bean.getDisplayFrmRental().setUpdateBy(o.getUpdateBy());
			semmrt001Bean.getDisplayFrmRental().setUpdateDt(o.getUpdateDt());

			addMessageInfo("M0001");
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e);
			addMessageError("E0001");
		}
		setSemmrt001Bean(semmrt001Bean);
		return false;
	}

	private void updateRentalMaster() {
		IRentalMasterService service = (IRentalMasterService) getBean("rentalMasterService");

		try {

			RentalMaster o = service.queryByRowId(semmrt001Bean.getDisplayFrmRental().getRentalMasterId());
			o.setRentalJobStatus(semmrt001Bean.getDisplayFrmRental().getRentalJobStatus());
			o.setVerifyStatus(semmrt001Bean.getDisplayFrmRental().getVerifyStatus());
			o.setCurrentUser(getUserLogIn());
			o = service.updateRentalMaster(o);

			semmrt001Bean.getDisplayFrmRental().setRentalJobStatus(o.getRentalJobStatus());
			semmrt001Bean.getDisplayFrmRental().setVerifyStatus(o.getVerifyStatus());
			semmrt001Bean.getDisplayFrmRental().setCreateBy(o.getCreateBy());
			semmrt001Bean.getDisplayFrmRental().setCreateDt(o.getCreateDt());
			semmrt001Bean.getDisplayFrmRental().setUpdateBy(o.getUpdateBy());
			semmrt001Bean.getDisplayFrmRental().setUpdateDt(o.getUpdateDt());

			addMessageInfo("M0001");
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e);
			addMessageError("E0001");
		}

	}

	@SuppressWarnings("unchecked")
	private void updateRentalMasterTerminate(Mrt001UpdRentJob mrt001UpdRentJob) {
		IRentalMasterService service = (IRentalMasterService) getBean("rentalMasterService");
		try {
			List<Mrt001UpdRentJob> list = service.querySPList(EQueryName.SP_MRT001_UPD_RENT_JOB.name, mrt001UpdRentJob);
			if (list != null && !list.isEmpty()) {
				String str = list.get(0).getResult();
				if (str.equals("Success")) {
					addMessageInfo("M0001");
				} else {
					String remark = list.get(0).getRemark();
					addGeneralMessageError(remark);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e);
			addMessageError("E0001");
		}
	}

	@SuppressWarnings("unchecked")
	private List<VerifyRentalSearchSiteRentCondSP> getSPMrt001SrchRentCond(VerifyRentalSearchSiteRentCondSP oSP) {
		IRentalDetailService rentalDetailService = (IRentalDetailService) getBean("rentalDetailService");
		try {
			return rentalDetailService.querySPList(EQueryName.SP_MRT001_SRCH_RENT_COND.name, oSP);
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	private List getSPMrt001SrchRentDetail(Mrt001SrchRentDetail rentDetailSP) {
		IRentalDetailService rentalDetailService = (IRentalDetailService) getBean("rentalDetailService");
		try {
			SEMMRT001Bean semmrt001Bean = getSemmrt001Bean();

			List to = rentalDetailService.querySPList(EQueryName.SP_MRT001_SRCH_RENT_DETAIL.name, rentDetailSP);
			for (int i = 0; i < to.size(); i++) {
				Mrt001SrchRentDetail temp = (Mrt001SrchRentDetail) to.get(i);
				// temp.setPeriodStartDt(convertYearENtoTH(temp.getPeriodStartDt()));
				// temp.setPeriodEndDt(convertYearENtoTH(temp.getPeriodEndDt()));
				temp.setPeriodStartDtStr(convertYearENtoTHStr(temp.getPeriodStartDt()));
				temp.setPeriodEndDtStr(convertYearENtoTHStr(temp.getPeriodEndDt()));

			}

			return to;
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	private List getSPMrt001SrchRentHist(Mrt001SrchRentHist rentHistSp) {
		IRentalDetailService rentalDetailService = (IRentalDetailService) getBean("rentalDetailService");
		try {
			List to = rentalDetailService.querySPList(EQueryName.SP_MRT001_SRCH_RENT_HIST.name, rentHistSp);
			return to;
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	private List getSPMrt001SrchDpstCond(Mrt001SrchDpstCond dpstCondSP) {
		ISiteDepositService service = (ISiteDepositService) getBean("siteDepositService");
		try {
			return service.querySPList(EQueryName.SP_MRT001_SRCH_DPST_COND.name, dpstCondSP);
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	private List getSPMrt001SrchDpstDetail(Mrt001SrchDpstDetail dpstDetail) {
		IDepositDetailService service = (IDepositDetailService) getBean("depositDetailService");
		try {
			List to = service.querySPList(EQueryName.SP_MRT001_SRCH_DPST_DETAIL.name, dpstDetail);
			for (int i = 0; i < to.size(); i++) {
				Mrt001SrchDpstDetail temp = (Mrt001SrchDpstDetail) to.get(i);
				// temp.setPeriodStDt(convertYearENtoTH(temp.getPeriodStDt()));
				// temp.setPeriodEndDt(convertYearENtoTH(temp.getPeriodEndDt()));
				temp.setPeriodStDtStr(convertYearENtoTHStr(temp.getPeriodStDt()));
				temp.setPeriodEndDtStr(convertYearENtoTHStr(temp.getPeriodEndDt()));
			}
			return to;
		} catch (Exception e) {
			return null;
		}
	}

	private void resetDefaultData() {
		semmrt001Bean.setCountDataSelect(0);
		semmrt001Bean.setPeriod("01");
		semmrt001Bean.setMrt001BookBank(new Mrt001BookBank());
		semmrt001Bean.setRenderedMsgFormSearch(false);
		semmrt001Bean.setRenderedMsgFormTop(false);
		semmrt001Bean.setRenderedMsgFormMiddle(false);
		semmrt001Bean.setRenderedMsgFormBottom(false);
		semmrt001Bean.setSelectedBGSpecial(false);
		semmrt001Bean.setSelectedCashSpecial(false);
	}

	private Double getVatRate() {
		ILovMasterService lovService = (ILovMasterService) getBean("lovMasterService");
		try {
			String vatRate = lovService.getVatRate();
			return new Double(vatRate);
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	private void initPageDeposit() {
		// Call store procedure sem_sp_mrt001_srch_dpst_cond
		Mrt001SrchDpstCond mrt001SrchDpstCond = new Mrt001SrchDpstCond();
		mrt001SrchDpstCond.setSiteInfoId(semmrt001Bean.getDisplayFrmRental().getSiteInfoId());
		mrt001SrchDpstCond.setRentalMasterId(semmrt001Bean.getDisplayFrmRental().getRentalMasterId());
		LOG.debug("semmrt001Bean.getDisplayFrmRental().getSiteInfoId() = "
				+ semmrt001Bean.getDisplayFrmRental().getSiteInfoId());
		LOG.debug("semmrt001Bean.getDisplayFrmRental().getRentalMasterId() = "
				+ semmrt001Bean.getDisplayFrmRental().getRentalMasterId());
		List<Mrt001SrchDpstCond> toDeposit = getSPMrt001SrchDpstCond(mrt001SrchDpstCond);
		List<Mrt001SrchDpstCond> listDepositTmp = new ArrayList<Mrt001SrchDpstCond>();
		semmrt001Bean.setSelectedBGSpecial(false);
		semmrt001Bean.setSelectedCashSpecial(false);
		boolean flg = true;
		// if
		// (semmrt001Bean.getDisplayFrmRental().getDepositCondType().equals("01"))
		// {
		// Case normal
		if (!semmrt001Bean.isViewMode()) {
			// boolean flg = true;
			for (Mrt001SrchDpstCond temp : toDeposit) {
				if (StringUtils.equals(temp.getDepositCondType(), "01")) {
					listDepositTmp.add(temp);
				}
				if (temp.getCondBalanceAmt() != null && !temp.getCondBalanceAmt().equals(new Double(0))) {
					if (flg) {
						semmrt001Bean.setDpstDetail(setFirstDpstSetup(temp));
						semmrt001Bean.getDpstDetail().setPeriodStDt(semmrt001Bean.getDisplayFrmRental().getEffDate());
						semmrt001Bean.getDpstDetail().setPeriodEndDt(
								semmrt001Bean.getDisplayFrmRental().getExpireDate());

						semmrt001Bean.setCountDataSelect(semmrt001Bean.getCountDataSelect() + 1);

						// Get dropdown vendor
						Mrt001SrchVendor mrt001SrchVendor = new Mrt001SrchVendor();
						mrt001SrchVendor.setExpenseType(semmrt001Bean.getDpstDetail().getExpenseType());
						mrt001SrchVendor.setContractNo(semmrt001Bean.getDisplayFrmRental().getContractNo());
						semmrt001Bean.setVendorList(getDropdownVendor(mrt001SrchVendor));

						if (semmrt001Bean.getDpstDetail().getDepositType().equals("02")) {
							setSemmrt001Bean(semmrt001Bean);
							calculateVat();
							semmrt001Bean = getSemmrt001Bean();
						}

						temp.setSelected(true);
						if (semmrt001Bean.getDisplayFrmRental().getRentalJobStatus() != null
								&& StringUtils.equals("03", semmrt001Bean.getDisplayFrmRental().getRentalJobStatus())) {
							semmrt001Bean.setDisabledVerify(true);
						}
						flg = false;
					}
					temp.setDisSelect(false);
				} else {
					temp.setDisSelect(true);
				}
			}
		}
		// semmrt001Bean.setDpstCondList(toDeposit);
		semmrt001Bean.setDpstCondList(listDepositTmp);
		semmrt001Bean.setModePage("NORMAL");
		// } else {
		// Case special
		// semmrt001Bean.setDpstCondSpecial(new Mrt001SrchDpstCond());
		// semmrt001Bean.getDpstCondSpecial().setVatType("01");

		semmrt001Bean.setModePage("SPECIAL");

		if (toDeposit != null && !toDeposit.isEmpty()) {
			// semmrt001Bean.setDpstCondList(toDeposit);
			semmrt001Bean.setDpstCondList(listDepositTmp);

			for (int i = 0; i < toDeposit.size(); i++) {
				Mrt001SrchDpstCond temp = toDeposit.get(i);
				if (StringUtils.equals(temp.getDepositCondType(), "02")) {
					if (temp.getDepositType().equals("01")) {
						if (StringUtils.isEmpty(temp.getVatType())) {
							temp.setVatType("");
						}
						semmrt001Bean.setDpstCondSpecialBG(temp);
					} else if (temp.getDepositType().equals("02")) {
						if (StringUtils.isEmpty(temp.getVatType())) {
							temp.setVatType("");
						}
						semmrt001Bean.setDpstCondSpecial(temp);
					}
				}
			}

			if (semmrt001Bean.getDpstCondSpecialBG() != null && semmrt001Bean.getDpstCondSpecial() != null) {
				semmrt001Bean.setDisChkSpecial(true);
			} else if (semmrt001Bean.getDpstCondSpecialBG() == null) {
				semmrt001Bean.setDisChkSpecial(false);
				// if(semmrt001Bean.getDpstCondSpecial() != null){
				if (flg && semmrt001Bean.getDpstCondSpecial() != null) {
					semmrt001Bean.getDpstDetail().setDepositType(semmrt001Bean.getDpstCondSpecial().getDepositType());
					semmrt001Bean.getDpstDetail().setVatType(semmrt001Bean.getDpstCondSpecial().getVatType());
					semmrt001Bean.getDpstDetail().setPeriodStDt(semmrt001Bean.getDpstCondSpecial().getPeriodStDt());
					semmrt001Bean.getDpstDetail().setPeriodEndDt(semmrt001Bean.getDpstCondSpecial().getPeriodEndDt());
					doCalDate(semmrt001Bean.getDpstCondSpecial().getPeriodStDt(), semmrt001Bean.getDpstCondSpecial()
							.getPeriodEndDt());
				}
				// } else if (semmrt001Bean.getDpstCondSpecial() == null) {
			} else if (flg && semmrt001Bean.getDpstCondSpecial() == null) {
				semmrt001Bean.setDisChkSpecial(false);
				semmrt001Bean.getDpstDetail().setDepositType(semmrt001Bean.getDpstCondSpecialBG().getDepositType());
				semmrt001Bean.getDpstDetail().setPeriodStDt(semmrt001Bean.getDpstCondSpecialBG().getPeriodStDt());
				semmrt001Bean.getDpstDetail().setPeriodEndDt(semmrt001Bean.getDpstCondSpecialBG().getPeriodEndDt());
				doCalDate(semmrt001Bean.getDpstCondSpecialBG().getPeriodStDt(), semmrt001Bean.getDpstCondSpecialBG()
						.getPeriodEndDt());
			}
		}
		// }

		Mrt001SrchDpstDetail mrt001SrchDpstDetail = new Mrt001SrchDpstDetail();
		mrt001SrchDpstDetail.setRentalMasterId(semmrt001Bean.getDisplayFrmRental().getRentalMasterId());
		List<Mrt001SrchDpstDetail> toDpstDetail = getSPMrt001SrchDpstDetail(mrt001SrchDpstDetail);

		// Default
		semmrt001Bean.getRentDetail().setWhtType("03");

		semmrt001Bean.setDpstDetailList(toDpstDetail);
	}

	@SuppressWarnings("unchecked")
	private boolean pageLoad() {
		boolean flag = true;
		String mode = (String) getFacesUtils().getRequestParameter("mode");
		String rowId = (String) getFacesUtils().getRequestParameter("rowId");

		semmrt001Bean = getSemmrt001Bean();
		semmrt001Bean.setModePage(null);
		semmrt001Bean.setDisBtnAdd(false);
		semmrt001Bean.setTmpRowId(rowId);

		List<SelectItem> sel = getLovItemsByType(ELovType.T_CT_VAT_RATE.name);
		if (sel.size() > 0) {
			String vatValue = String.valueOf(sel.get(1).getValue());
			semmrt001Bean.setDefaultVat(Double.parseDouble(vatValue));
		}

		if (mode.equals("SEARCH")) {
			// Go to page search semmrt001-1
			semmrt001Bean.setRenderedMsgFormSearch(false);
			searchVerifyRental();
		} else {
			resetDefaultData();

			if (mode.equals("RENTAL_SETUP") || mode.equals("RENTAL")) {
				semmrt001Bean.setDpstCondSpecialBG(null);
				semmrt001Bean.setDpstCondSpecial(null);
				semmrt001Bean.setSpecialChk1(false);
				semmrt001Bean.setSpecialChk2(false);
				semmrt001Bean.setSpecialChk3(false);
				semmrt001Bean.setSpecialChk4(false);
				semmrt001Bean.setDisabledSpacialChk(true);
				String condType = (String) getFacesUtils().getRequestParameter("condType");
				semmrt001Bean.setCondType(condType);

				String viewFlag = (String) getFacesUtils().getRequestParameter("viewFlag");
				viewFlag = (StringUtils.isNotEmpty(viewFlag)) ? viewFlag : (semmrt001Bean.isViewMode()) ? "Y" : "F";
				if (viewFlag.equals("Y")) {
					semmrt001Bean.setViewMode(true);
				} else {
					semmrt001Bean.setViewMode(false);
				}

				if (mode.equals("RENTAL_SETUP")) {
					String company = (String) getFacesUtils().getRequestParameter("company");
					String contractNo = (String) getFacesUtils().getRequestParameter("contractNo");
					String siteName = (String) getFacesUtils().getRequestParameter("siteName");
					String reqType = (String) getFacesUtils().getRequestParameter("reqType");
					String reqTypeName = (String) getFacesUtils().getRequestParameter("reqTypeName");
					String title = (String) getFacesUtils().getRequestParameter("title");
					String rentalJobStatus = (String) getFacesUtils().getRequestParameter("rentalJobStatus");
					String verifyStatus = (String) getFacesUtils().getRequestParameter("verifyStatus");
					String siteInfoId = (String) getFacesUtils().getRequestParameter("siteInfoId");
					String rentCondType = (String) getFacesUtils().getRequestParameter("rentCondType");
					String depositCondType = (String) getFacesUtils().getRequestParameter("depositCondType");
					String createBy = (String) getFacesUtils().getRequestParameter("createBy");
					String createDt = (String) getFacesUtils().getRequestParameter("createDt");
					String updateBy = (String) getFacesUtils().getRequestParameter("updateBy");
					String updateDt = (String) getFacesUtils().getRequestParameter("updateDt");
					String pendingDt = (String) getFacesUtils().getRequestParameter("pendingDt");
					String effDate = (String) getFacesUtils().getRequestParameter("effDate");
					String expireDate = (String) getFacesUtils().getRequestParameter("expireDate");
					String rentalMasterId = (String) getFacesUtils().getRequestParameter("rentalMasterId");
					String remark = (String) getFacesUtils().getRequestParameter("remark");
					String specialFlag = (String) getFacesUtils().getRequestParameter("specialFlag");
					String terminateDt = (String) getFacesUtils().getRequestParameter("terminateDt");

					LOG.debug("effDate = " + effDate);
					LOG.debug("expireDate = " + expireDate);

					semmrt001Bean.setRentDetail(new RentalDetail());
					System.out.println("getSiteRentCondId 1 = " + semmrt001Bean.getRentDetail().getSiteRentCondId());
					semmrt001Bean.getRentDetail().setWhtType("01");
					semmrt001Bean.getRentDetail().setPayPeriodType("01");
					semmrt001Bean.getRentDetail().setVatType("01");
					semmrt001Bean.setModeRentalDetail("ADD");
					semmrt001Bean.setTxtContent(MSGCacheUtil.getInstance().getMessageByCode("Q0002"));
					if (StringUtils.isEmpty(rentalMasterId)) {
						// Add new rental master
						RentalMaster o = new RentalMaster();
						o.setCompany(company);
						o.setRentalJobStatus("00");
						o.setVerifyStatus("00");
						o.setSiteInfoId(siteInfoId);
						o.setRentalLastestFlag("Y");
						o.setCurrentUser(getUserLogIn());
						o = saveRentalMaster(o);
						if (o != null) {
							rentalMasterId = o.getRowId();
						}
					}
					LOG.debug("siteName = " + siteName);
					semmrt001Bean.setDisplayFrmRental(new VerifyRentalSearchSiteInfoSP());
					semmrt001Bean.getDisplayFrmRental().setRentalMasterId(rentalMasterId);
					semmrt001Bean.getDisplayFrmRental().setCompany(company);
					semmrt001Bean.getDisplayFrmRental().setContractNo(contractNo);
					semmrt001Bean.setContractNo(contractNo); // Add By Noom
					// 09/10/2013
					semmrt001Bean.getDisplayFrmRental().setSiteName(siteName);
					semmrt001Bean.getDisplayFrmRental().setReqType(reqType);
					semmrt001Bean.getDisplayFrmRental().setReqTypeName(reqTypeName);
					semmrt001Bean.getDisplayFrmRental().setTitle(title);
					semmrt001Bean.getDisplayFrmRental().setRentalJobStatus(rentalJobStatus);
					semmrt001Bean.getDisplayFrmRental().setVerifyStatus(verifyStatus);
					semmrt001Bean.getDisplayFrmRental().setSiteInfoId(siteInfoId);
					semmrt001Bean.getDisplayFrmRental().setRentCondType(rentCondType);
					semmrt001Bean.getDisplayFrmRental().setDepositCondType(depositCondType);
					semmrt001Bean.getDisplayFrmRental().setCreateBy(createBy);
					semmrt001Bean.getDisplayFrmRental().setCreateDt(parseParameterToDate(createDt));
					semmrt001Bean.getDisplayFrmRental().setUpdateBy(updateBy);
					semmrt001Bean.getDisplayFrmRental().setUpdateDt(parseParameterToDate(updateDt));
					semmrt001Bean.getDisplayFrmRental().setPendingDate(parseParameterToDate(pendingDt));
					semmrt001Bean.getDisplayFrmRental().setTerminateDt(parseParameterToDate(terminateDt));
					semmrt001Bean.setDisPendingDt(semmrt001Bean.getDisplayFrmRental().getPendingDate() != null ? true
							: false);
					LOG.debug("parseParameterToDate(effDate) = " + parseParameterToDate(effDate));
					LOG.debug("parseParameterToDate(expireDate) = " + parseParameterToDate(expireDate));
					semmrt001Bean.getDisplayFrmRental().setEffDate(parseParameterToDate(effDate));
					semmrt001Bean.setEffDt(parseParameterToDate(effDate));
					semmrt001Bean.getDisplayFrmRental().setExpireDate(parseParameterToDate(expireDate));
					semmrt001Bean.setExpDt(parseParameterToDate(expireDate));
					semmrt001Bean.getDisplayFrmRental().setRemark(remark);
					semmrt001Bean.getDisplayFrmRental().setSpecialFlag(
							("Y".equalsIgnoreCase(specialFlag)) ? true : false);

					if (StringUtils.isEmpty(expireDate)) {
						semmrt001Bean.setRequireFlag(false);
					} else {
						semmrt001Bean.setRequireFlag(true);
					}
				}

				// Call store procedure SEM_SP_MRT001_SRCH_RENT_COND
				VerifyRentalSearchSiteRentCondSP oSP = new VerifyRentalSearchSiteRentCondSP();
				oSP.setRentalMasterId(semmrt001Bean.getDisplayFrmRental().getRentalMasterId());
				oSP.setSiteInfoId(semmrt001Bean.getDisplayFrmRental().getSiteInfoId());
				LOG.debug("semmrt001Bean.getDisplayFrmRental().getRentalMasterId() = "
						+ semmrt001Bean.getDisplayFrmRental().getRentalMasterId());
				LOG.debug("semmrt001Bean.getDisplayFrmRental().getSiteInfoId() = "
						+ semmrt001Bean.getDisplayFrmRental().getSiteInfoId());
				List<VerifyRentalSearchSiteRentCondSP> to = getSPMrt001SrchRentCond(oSP);
				List<VerifyRentalSearchSiteRentCondSP> listTmp = new ArrayList<VerifyRentalSearchSiteRentCondSP>();

				semmrt001Bean.setRenderedModeApprove(true);
				semmrt001Bean.setDisApprove(false);
				semmrt001Bean.setMode("RENTAL");
				semmrt001Bean.setExpenseTypeList(SelectItemLOVCacheUtil.getInstance().getLovItemsByType(
						ELovType.T_CT_EXPENSE_TYPE.name, EX_AND, "RENT", "RT", "S"));
				semmrt001Bean.setPeriodTypeList(getLovItemsByType(ELovType.T_CT_PERIOD_TYPE.name));

				// Check reqType
				if (semmrt001Bean.getDisplayFrmRental().getReqType().equals("05")) {
					semmrt001Bean.setRentalStatusList(SelectItemLOVCacheUtil.getInstance().getLovItemsByType(
							ELovType.T_RT_RENTAL_JOB_STATUS.name, EX_IN, "00,05", null, null));
					semmrt001Bean.setTxtSavePending(getMessageByCode("Q0009"));
				} else if (semmrt001Bean.getDisplayFrmRental().getReqType().equals("06")) {
					semmrt001Bean.setRentalStatusList(SelectItemLOVCacheUtil.getInstance().getLovItemsByType(
							ELovType.T_RT_RENTAL_JOB_STATUS.name, EX_IN, "00,06", null, null));
					semmrt001Bean.setTxtSavePending(getMessageByCode("Q0012"));
				} else if (semmrt001Bean.getDisplayFrmRental().getReqType().equals("99")) {
					semmrt001Bean.setRentalStatusList(SelectItemLOVCacheUtil.getInstance().getLovItemsByType(
							ELovType.T_RT_RENTAL_JOB_STATUS.name, EX_IN, "00,99", null, null));
					semmrt001Bean.setTxtSavePending(getMessageByCode("Q0010"));
					if (semmrt001Bean.getDisplayFrmRental().getRentalJobStatus() == null
							|| "".equals(semmrt001Bean.getDisplayFrmRental().getRentalJobStatus())) {
						semmrt001Bean.getDisplayFrmRental().setRentalJobStatus("03");
					}

				}

				clearRentalDetail();

				// Check rent_cond_type
				LOG.debug("semmrt001Bean.getDisplayFrmRental().getRentCondType() = "
						+ semmrt001Bean.getDisplayFrmRental().getRentCondType());
				// if
				// (semmrt001Bean.getDisplayFrmRental().getRentCondType().equals("01"))
				// {
				// semmrt001Bean.setModePage("NORMAL");
				// }else{
				// semmrt001Bean.setModePage("SPECIAL");
				// }
				// if
				// (semmrt001Bean.getDisplayFrmRental().getRentCondType().equals("01"))
				// {
				if (!semmrt001Bean.isViewMode()) {
					boolean flg = true;
					for (VerifyRentalSearchSiteRentCondSP object : to) {
						if (StringUtils.equals(object.getRentCondType(), "01")) {
							listTmp.add(object);
						}
						// object.setEffectiveDtTh(convertYearENtoTH(object.getEffectiveDT()));
						object.setEffectiveDtThStr(convertYearENtoTHStr(object.getEffectiveDT()));
						if (object.getBalanceAmt() != null && !object.getBalanceAmt().equals(new Double(0))) {
							if (flg) {
								semmrt001Bean.setRentDetail(setFirstRentCond(object));
								System.out.println("period " + semmrt001Bean.getRentDetail().getPeriodAmt());
								System.out.println("getSiteRentCondId 2 = "
										+ semmrt001Bean.getRentDetail().getSiteRentCondId());
								object.setSelected(true);
								semmrt001Bean.setModePage("NORMAL");

								semmrt001Bean.setCountDataSelect(semmrt001Bean.getCountDataSelect() + 1);

								// Get dropdown vendor
								Mrt001SrchVendor mrt001SrchVendor = new Mrt001SrchVendor();
								mrt001SrchVendor.setExpenseType(semmrt001Bean.getRentDetail().getExpenseType());
								mrt001SrchVendor.setContractNo(semmrt001Bean.getDisplayFrmRental().getContractNo());
								semmrt001Bean.setVendorList(getDropdownVendor(mrt001SrchVendor));
								if (semmrt001Bean.getDisplayFrmRental().getRentalJobStatus() != null
										&& StringUtils.equals("03", semmrt001Bean.getDisplayFrmRental()
												.getRentalJobStatus())) {
									semmrt001Bean.setDisabledVerify(true);
								}

								flg = false;
							}
						} else {
							object.setDisSelect(true);
						}

						if (object.getBalanceAmt() != null && !object.getBalanceAmt().equals(new Double(0))
								|| object.getRentAmt() != null && object.getRentAmt().equals(new Double(0))) {
							object.setDisSelect(false);
						}

					}
				}

				// semmrt001Bean.setRentCondList(to);
				semmrt001Bean.setRentCondList(listTmp);
				// semmrt001Bean.setModePage("NORMAL");
				semmrt001Bean.setChkBtnAddSpecial(false);

				// } else {
				// Get data from List two data (if have) display in panel rental
				// and service
				// semmrt001Bean.setPeriodTypeList(getLovItemsByType(ELovType.T_CT_PERIOD_TYPE.name));
				semmrt001Bean.setRentCondSpecial(null);
				semmrt001Bean.setServCondSpecial(null);
				semmrt001Bean.setModeDpstDetail("ADD");
				// semmrt001Bean.setChkBtnAddSpecial(true);
				// semmrt001Bean.setTmpVatRate(getVatRate());
				// semmrt001Bean.getRentDetail().setVatRate(semmrt001Bean.getTmpVatRate());
				// for (int i=0; i<to.size();i++) {
				// VerifyRentalSearchSiteRentCondSP temp =
				// (VerifyRentalSearchSiteRentCondSP)to.get(i);
				// if(StringUtils.equals(temp.getRentCondType(), "02")){
				// if (temp.getExpenseType().equals("01")) {
				// if(StringUtils.isEmpty(temp.getVatType())){
				// temp.setVatType("");
				// }
				// semmrt001Bean.setRentCondSpecial(temp);
				// } else if (temp.getExpenseType().equals("02")) {
				// if(StringUtils.isEmpty(temp.getVatType())){
				// temp.setVatType("");
				// }
				// semmrt001Bean.setServCondSpecial(temp);
				// }
				// // } else if (temp.getExpenseType().equals("03")) {
				// // semmrt001Bean.setDonateCondSpecial(temp);
				// // }
				// }
				// }
				for (int i = 0; i < to.size(); i++) {
					VerifyRentalSearchSiteRentCondSP temp = (VerifyRentalSearchSiteRentCondSP) to.get(i);
					if (StringUtils.equals(temp.getRentCondType(), "02")) {
						if (temp.getExpenseType().equals("01")) {
							if (StringUtils.isEmpty(temp.getVatType())) {
								temp.setVatType("");
							}
							semmrt001Bean.setRentCondSpecial(temp);
						} else if (temp.getExpenseType().equals("02")) {
							if (StringUtils.isEmpty(temp.getVatType())) {
								temp.setVatType("");
							}
							if (temp.getSubExpenseType() != null) {
								if ("01".equals(temp.getSubExpenseType())) {
									semmrt001Bean.setServCondSpecial(temp);
								} else if ("02".equals(temp.getSubExpenseType())) {
									semmrt001Bean.setServCondSpecial2(temp);
								} else if ("03".equals(temp.getSubExpenseType())) {
									semmrt001Bean.setServCondSpecial3(temp);
								}
							}
							// semmrt001Bean.setServCondSpecial(temp);
						}
						// } else if (temp.getExpenseType().equals("03")) {
						// semmrt001Bean.setDonateCondSpecial(temp);
						// }
					}
				}
				LOG.debug("semmrt001Bean.setDonateCondSpecial() = " + semmrt001Bean.getDonateCondSpecial());
				// semmrt001Bean.setModePage("SPECIAL");
				// }
				Mrt001SrchRentDetail rentDetailSP = new Mrt001SrchRentDetail();
				rentDetailSP.setRentalMasterId(semmrt001Bean.getDisplayFrmRental().getRentalMasterId());
				List toDetail = getSPMrt001SrchRentDetail(rentDetailSP);
				semmrt001Bean.setRentDetailList(toDetail);
				System.out.println("getSiteRentCondId 3 = " + semmrt001Bean.getRentDetail().getSiteRentCondId());
				// load history

				Mrt001SrchRentHist histSp = new Mrt001SrchRentHist();
				histSp.setRentalMasterId(semmrt001Bean.getDisplayFrmRental().getRentalMasterId());
				List<Mrt001SrchRentHist> toHist = getSPMrt001SrchRentHist(histSp);
				semmrt001Bean.setRentHistList(new ArrayList<Mrt001SrchRentHist>());
				if (toHist != null && toHist.size() > 0) {
					for (int i = 0; i < toHist.size(); i++) {
						Mrt001SrchRentHist rentHistTmp = toHist.get(i);
						// rentHistTmp.setPeriodStartDt(convertYearENtoTH(rentHistTmp.getPeriodStartDt()));
						// rentHistTmp.setPeriodEndDt(convertYearENtoTH(rentHistTmp.getPeriodEndDt()));
						rentHistTmp.setPeriodStartDtStr(convertYearENtoTHStr(rentHistTmp.getPeriodStartDt()));
						rentHistTmp.setPeriodEndDtStr(convertYearENtoTHStr(rentHistTmp.getPeriodEndDt()));
						semmrt001Bean.getRentHistList().add(rentHistTmp);
					}
				}
				// semmrt001Bean.setRentHistList(toHist);

				// Cal Balance
				if (StringUtils.equalsIgnoreCase("NORMAL", semmrt001Bean.getModePage())) {
					semmrt001Bean.setCheckMode("NORMAL");
					callMrt001BalanceCal();
					System.out.println("getSiteRentCondId 4 = " + semmrt001Bean.getRentDetail().getSiteRentCondId());
					
					//Add for calculate refresh period, periodAmt
					chkPayPeriodType() ;
					doCalculate();
					
				} else {
					semmrt001Bean.getRentDetail().setBalanceAmt(0.0);
				}
			} else if (mode.equals("DEPOSIT")) {
				// Deposit
				semmrt001Bean.setMode("DEPOSIT");
				semmrt001Bean.setDepositTypeList(SelectItemLOVCacheUtil.getInstance().getLovItemsByType(
						ELovType.T_CT_DEPOSIT_TYPE.name));
				semmrt001Bean.setExpenseTypeList(SelectItemLOVCacheUtil.getInstance().getLovItemsByType(
						ELovType.T_CT_EXPENSE_TYPE.name, EX_IN, "DEPOSIT_RENT", null, null));
				semmrt001Bean.setDpstDetail(new DepositDetail());
				semmrt001Bean.getDpstDetail().setVatRate(getVatRate());
				semmrt001Bean.setModeDpstDetail("ADD");
				semmrt001Bean.setVendorList(getEmptyDropDown());
				semmrt001Bean.setPayeeList(getEmptyDropDown());

				semmrt001Bean.setDisDepositDetail(true);

				initPageDeposit();
			}
		}
		semmrt001Bean.setDisabledExpenseType(true);
		// LOG.debug("semmrt001Bean.getModePage() = "+semmrt001Bean.getModePage());
		// LOG.debug("semmrt001Bean.getRentCondSpecial() = "+semmrt001Bean.getRentCondSpecial());
		// LOG.debug("semmrt001Bean.getServCondSpecial() = "+semmrt001Bean.getServCondSpecial());
		// LOG.debug("semmrt001Bean.getDonateCondSpecial() = "+semmrt001Bean.getDonateCondSpecial());
		System.out.println("getSiteRentCondId 5 = " + semmrt001Bean.getRentDetail().getSiteRentCondId());
		if (semmrt001Bean.getRentDetail() != null) {
			// LOG.debug("semmrt001Bean.getRentDetail().getRentalAmt() : "+semmrt001Bean.getRentDetail().getRentalAmt());
			if (semmrt001Bean.getRentDetail().getRentalAmt() != null
					&& semmrt001Bean.getRentDetail().getRentalAmt() > 0) {
				semmrt001Bean.setDisabledSpacialChk(true);
			} else {
				semmrt001Bean.setDisabledSpacialChk(false);
			}
		}

		setSemmrt001Bean(semmrt001Bean);

		String siteInfoId = "";
		if (semmrt001Bean.getRentCondSpecial() == null) {
			if (semmrt001Bean.getRentCondList() != null && semmrt001Bean.getRentCondList().size() > 0)
				siteInfoId = semmrt001Bean.getRentCondList().get(0).getSiteInfoId();
		} else {
			siteInfoId = semmrt001Bean.getRentCondSpecial().getSiteInfoId();
		}

		semmrt001Bean.setServiceNameList(getServiceList(siteInfoId));
		semmrt001Bean.setServiceTypeToCalList(SelectItemLOVCacheUtil.getInstance().getLovItemsByType(
				ELovType.T_RT_CAL.name));
		semmrt001Bean
				.setServiceCalTypeIdToCalName(semmrt001Bean.getServiceTypeToCalList().get(1).getLabel().toString());
		return flag;
	}

	private boolean validateRentalMaster() {
		boolean vFlag = true;

		if (StringUtils.isEmpty(getSemmrt001Bean().getDisplayFrmRental().getRentalJobStatus())) {
			addMessageError("W0001", msg("message.rentalJobStatus"));
			vFlag = false;
		}

		if (StringUtils.isEmpty(getSemmrt001Bean().getDisplayFrmRental().getVerifyStatus())) {
			addMessageError("W0001", msg("message.verifyStatus"));
			vFlag = false;
		}

		return vFlag;
	}

	private boolean doUpdateAfterWarning() {
		boolean flag = false;
		semmrt001Bean = getSemmrt001Bean();
		semmrt001Bean.setRenderedMsgFormSearch(true);
		semmrt001Bean.setRenderedMsgFormMiddle(false);

		if (semmrt001Bean.getDisplayFrmRental().getReqType().equals("99")) {
			Mrt001UpdRentJob mrt001UpdRentJob = new Mrt001UpdRentJob();
			mrt001UpdRentJob.setCurrentUser(getUserLogIn());
			mrt001UpdRentJob.setRentalMasterId(semmrt001Bean.getDisplayFrmRental().getRentalMasterId());
			mrt001UpdRentJob.setReqType(semmrt001Bean.getDisplayFrmRental().getReqType());
			mrt001UpdRentJob.setContractNo(semmrt001Bean.getDisplayFrmRental().getContractNo());
			updateRentalMasterTerminate(mrt001UpdRentJob);
		} else {
			updateRentalMaster();
		}

		setSemmrt001Bean(semmrt001Bean);
		return flag;
	}

	private boolean doCheckBeforeSaveRentalMaster() {
		boolean flag = false;

		semmrt001Bean = getSemmrt001Bean();
		semmrt001Bean.setDisableBtnSave(true);
		if (semmrt001Bean.getDisplayFrmRental().getRentalJobStatus().equals("03")
				&& semmrt001Bean.getDisplayFrmRental().getVerifyStatus().equals("02")) {
			semmrt001Bean.setPopupWarning(true);
			setSemmrt001Bean(semmrt001Bean);
		} else {
			semmrt001Bean.setPopupWarning(false);
			setSemmrt001Bean(semmrt001Bean);
			doUpdateRentalMaster();
		}
		semmrt001Bean.setDisableBtnSave(false);
		return flag;
	}

	@SuppressWarnings("unchecked")
	private boolean doUpdateRentalMaster() {
		
		boolean flag = false;
		semmrt001Bean = getSemmrt001Bean();
		semmrt001Bean.setDisableBtnSave(true);
		semmrt001Bean.setRenderedMsgFormSearch(true);
		semmrt001Bean.setRenderedMsgFormMiddle(false);
		semmrt001Bean.setPopupWarning(false);
		if (validateRentalMaster()) {
			Mrt001VerifyStatus mrt001VerifyStatus = new Mrt001VerifyStatus();
			// mrt001VerifyStatus.setSiteInfoId("2");
			// mrt001VerifyStatus.setVerifyStatus("02");
			mrt001VerifyStatus.setSiteInfoId(semmrt001Bean.getDisplayFrmRental().getSiteInfoId());
			mrt001VerifyStatus.setRentalMasterId(semmrt001Bean.getDisplayFrmRental().getRentalMasterId());
			mrt001VerifyStatus.setVerifyStatus(semmrt001Bean.getDisplayFrmRental().getVerifyStatus());
			mrt001VerifyStatus.setRentalJobStatus(semmrt001Bean.getDisplayFrmRental().getRentalJobStatus());
			mrt001VerifyStatus.setPendingDt(semmrt001Bean.getDisplayFrmRental().getPendingDate());
			mrt001VerifyStatus.setRemark(semmrt001Bean.getDisplayFrmRental().getRemark());
			mrt001VerifyStatus.setSpecialFlag((semmrt001Bean.getDisplayFrmRental().isSpecialFlag()) ? "Y" : "N");
			mrt001VerifyStatus.setTerminateDt(semmrt001Bean.getDisplayFrmRental().getTerminateDt());

			IRentalMasterService service = (IRentalMasterService) getBean("rentalMasterService");
			try {
				List<Mrt001VerifyStatus> resultList = service.querySPList(EQueryName.SP_MRT001_VERIFY_STATUS.name,
						mrt001VerifyStatus);
				if (resultList != null && !resultList.isEmpty()) {
					String result = resultList.get(0).getResult();
					String remark = resultList.get(0).getRemark();

					if (result.equals("Success") || result.equals("Warning")) {
						if (result.equals("Success")){
							if (semmrt001Bean.getDisplayFrmRental().getReqType().equals("99")
									&& semmrt001Bean.getDisplayFrmRental().getRentalJobStatus().equals("03")
									&& semmrt001Bean.getDisplayFrmRental().getVerifyStatus().equals("02")) {
								Mrt001UpdRentJob mrt001UpdRentJob = new Mrt001UpdRentJob();
								mrt001UpdRentJob.setCurrentUser(getUserLogIn());
								mrt001UpdRentJob.setRentalMasterId(semmrt001Bean.getDisplayFrmRental().getRentalMasterId());
								mrt001UpdRentJob.setReqType(semmrt001Bean.getDisplayFrmRental().getReqType());
								mrt001UpdRentJob.setContractNo(semmrt001Bean.getDisplayFrmRental().getContractNo());
								updateRentalMasterTerminate(mrt001UpdRentJob);
	
							} else {
								updateRentalMaster();
	
							}
						} else if (result.equals("Warning")) {
							// alert warning
							semmrt001Bean.setPopupWarning(true);
							semmrt001Bean.setTxtWarning(remark);
						}
						System.out.println("### siteInfoId : " + semmrt001Bean.getDisplayFrmRental().getSiteInfoId());
						if (semmrt001Bean.getDisplayFrmRental().getVerifyStatus().equals("02")) {
							
							updateToISRF(service);
						}
					} else if (result.equals("Fail")) {
						// not save
						addGeneralMessageError(remark);
					}
				} else {
					// error

				}
			} catch (Exception e) {
				e.printStackTrace();
				LOG.error(e);
			}
		}
		semmrt001Bean.setDisableBtnSave(false);
		setSemmrt001Bean(semmrt001Bean);
		return flag;
	}

	@SuppressWarnings("unchecked")
	private void updateToISRF(IRentalMasterService service) {
		String chkSendToSoap = service.callSemIfrsChkSendToSap(semmrt001Bean.getDisplayFrmRental().getSiteInfoId(),
				semmrt001Bean.getDisplayFrmRental().getRentalMasterId());
		if (chkSendToSoap.trim().equalsIgnoreCase("Y")) {
			try {
				
				
				List<Mrt010IfrsInterface> resSap = new ArrayList<Mrt010IfrsInterface>();
				WsClientService sapService = new WsClientService();
				//String flag = service.callSemIfrsChkChange(semmrt001Bean.getContractNo());
				String flag = service.callSemIfrsChkChange(semmrt001Bean.getDisplayFrmRental().getSiteInfoId());
				
				if(flag.trim().equals("N")){
					Mrt010IfrsInterface ifrsPrepare = new Mrt010IfrsInterface();
					ifrsPrepare.setContractNo(semmrt001Bean.getContractNo());
					ifrsPrepare.setUserId(semmrt001Bean.getUserLogin());
					
					List<Mrt010IfrsInterface> IsrfInterfaces = service.querySPList(
							EQueryName.SP_MRT010_IFRS_INTERFACE_ONLINE.name, ifrsPrepare);
					if(!IsrfInterfaces.isEmpty()){
						resSap = sapService.IFRSCreateSEM(IsrfInterfaces);
					}
					
					if (!resSap.isEmpty()) {
						for (int i = 0; i < resSap.size(); i++) {
							try {
								resSap.get(i).setUserId(semmrt001Bean.getUserLogin());
								List<Mrt010IfrsInterface> updResultList = service.querySPList(
										EQueryName.SP_MRT010_IFRS_INTERFACE_UPDATE.name, resSap.get(i));
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}
				}else if(flag.trim().equals("C")) {
					Mrt010IfrsInterface ifrsPrepare = new Mrt010IfrsInterface();
					System.out.println("### siteInfoId : " + semmrt001Bean.getDisplayFrmRental().getSiteInfoId());
					ifrsPrepare.setContractNo(semmrt001Bean.getDisplayFrmRental().getSiteInfoId());
					ifrsPrepare.setUserId(semmrt001Bean.getUserLogin());
					
					List<Mrt010IfrsInterface> IsrfInterfaces = service.querySPList(
							EQueryName.SP_MRT010_IFRS_INTERFACE_ONLINE_CH.name, ifrsPrepare);
					
					if(!IsrfInterfaces.isEmpty()){
						
						if(IsrfInterfaces.get(0).getActivity().equals("U") && 
								IsrfInterfaces.get(0).getContractStatus().equals("MVAS")){
							
							List<Mrt010IfrsInterface> list = new ArrayList<Mrt010IfrsInterface>();
							list.add(IsrfInterfaces.get(0));
							IsrfInterfaces.remove(0);
							System.out.println("######");
							resSap = sapService.IFRSChangeSEM(list);
							
							if (!resSap.isEmpty()) {
								for (int i = 0; i < resSap.size(); i++) {
									try {
										resSap.get(i).setUserId(semmrt001Bean.getUserLogin());
										List<Mrt010IfrsInterface> updResultList = service.querySPList(
												EQueryName.SP_MRT010_IFRS_INTERFACE_UPDATE.name, resSap.get(i));
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							}
							
							List<Mrt010IfrsInterface> resSapChange = sapService.IFRSCreateSEM(IsrfInterfaces);
							if (!resSapChange.isEmpty()) {
								for (int i = 0; i < resSapChange.size(); i++) {
									try {
										resSapChange.get(i).setUserId(semmrt001Bean.getUserLogin());
										List<Mrt010IfrsInterface> updResultList = service.querySPList(
												EQueryName.SP_MRT010_IFRS_INTERFACE_UPDATE.name, resSapChange.get(i));
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							}
						
						
						}else {
							
							for(int index = 0; index < IsrfInterfaces.size(); index ++){
								List<Mrt010IfrsInterface> list = new ArrayList<Mrt010IfrsInterface>();
								list.add(IsrfInterfaces.get(index));
								
								resSap = sapService.IFRSChangeSEM(list);
								
								if (!resSap.isEmpty()) {
									for (int i = 0; i < resSap.size(); i++) {
										try {
											resSap.get(i).setUserId(semmrt001Bean.getUserLogin());
											List<Mrt010IfrsInterface> updResultList = service.querySPList(
													EQueryName.SP_MRT010_IFRS_INTERFACE_UPDATE.name, resSap.get(i));
										} catch (Exception e) {
											e.printStackTrace();
										}
									}
								}
								String chkCodeDelay = service.callSemIfrsChkDelay("CHANGE");
								if(chkCodeDelay.equals("Y")){
									Thread.sleep(2000);
								}
								
							}
						}
							
					}
						
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				LOG.error(e);
			}
		}
	}

	private void setRadioPayPeriodType(String value, String payPeriod) {
		if ("03".equals(value)) {
			semmrt001Bean.setPeriod("");
			semmrt001Bean.setPeriod4("");
			semmrt001Bean.setPeriod3(value);
			if (StringUtils.isNotEmpty(payPeriod)) {
				semmrt001Bean.setPayPeriodMonth(new Integer(payPeriod));
				semmrt001Bean.getRentDetail().setPayPeriod(semmrt001Bean.getPayPeriodMonth());
			}
		} else if ("04".equals(value)) {
			semmrt001Bean.setPeriod("");
			semmrt001Bean.setPeriod3("");
			semmrt001Bean.setPeriod4(value);
			if (StringUtils.isNotEmpty(payPeriod)) {
				semmrt001Bean.setPayPeriodYear(new Integer(payPeriod));
				semmrt001Bean.getRentDetail().setPayPeriod(semmrt001Bean.getPayPeriodYear());
			}
		} else {
			semmrt001Bean.setPeriod(value);
		}
	}

	public void chkPayPeriodType() {
		String type = (String) getFacesUtils().getRequestParameter("type");	
		
			
		
		semmrt001Bean = getSemmrt001Bean();
		
		
		//Fixed case initial PeriodAmt incorrect
		String periodType = semmrt001Bean.getPeriod();
		if (type==null) {			
			if (periodType.matches("01|02|05|06|07")) {
				type ="1";				
			}
		}
		LOG.debug("type = " + type);
		LOG.debug("semmrt001Bean.getRentDetail().getAmtPerMonth() = " + semmrt001Bean.getRentDetail().getAmtPerMonth());
		LOG.debug("semmrt001Bean.getRentDetail().getAmtPerYear() = " + semmrt001Bean.getRentDetail().getAmtPerYear());
		System.out.println("period " + semmrt001Bean.getRentDetail().getPeriodAmt());
		if (StringUtils.equalsIgnoreCase("SPECIAL", semmrt001Bean.getCheckMode())) {

			Double amtMonth = 0.0;
			Double amtYear = 0.0;
			Double amtOnce = 0.0;
			if (semmrt001Bean.getRentDetail().getRentalAmt() == null
					|| semmrt001Bean.getRentDetail().getRentalAmt() == 0.0) {
				semmrt001Bean.getRentDetail().setRentalAmt(0.0);
			} else {
				if (StringUtils.equalsIgnoreCase("M", semmrt001Bean.getRentDetail().getRentPeriodType())) {
					amtMonth = semmrt001Bean.getRentDetail().getRentalAmt();
					amtYear = semmrt001Bean.getRentDetail().getRentalAmt() * 12;
					amtOnce = semmrt001Bean.getRentDetail().getRentalAmt();
				} else if (StringUtils.equalsIgnoreCase("Y", semmrt001Bean.getRentDetail().getRentPeriodType())) {
					amtMonth = semmrt001Bean.getRentDetail().getRentalAmt() / 12;
					amtYear = semmrt001Bean.getRentDetail().getRentalAmt();
					amtOnce = semmrt001Bean.getRentDetail().getRentalAmt();
				} else {
					amtMonth = semmrt001Bean.getRentDetail().getRentalAmt();
					amtYear = semmrt001Bean.getRentDetail().getRentalAmt();
					amtOnce = semmrt001Bean.getRentDetail().getRentalAmt();
				}
			}

			if ("1".equals(type)) {
				semmrt001Bean.setPeriod3("");
				semmrt001Bean.setPeriod4("");
				semmrt001Bean.setPayPeriodMonth(0);
				semmrt001Bean.setPayPeriodYear(0);
				semmrt001Bean.getRentDetail().setPayPeriodType(semmrt001Bean.getPeriod());
				if ("01".equals(semmrt001Bean.getPeriod())) {
					if (amtMonth == 0.0 || amtMonth == null) {
						semmrt001Bean.getRentDetail().setPeriodAmt(0.0);
					} else {
						semmrt001Bean.getRentDetail().setPeriodAmt(calShraePeriodAmt(amtMonth, 1));
					}
				} else if ("02".equals(semmrt001Bean.getPeriod())) {
					if (amtYear == 0.0 || amtYear == null) {
						semmrt001Bean.getRentDetail().setPeriodAmt(0.0);
					} else {
						semmrt001Bean.getRentDetail().setPeriodAmt(calShraePeriodAmt(amtYear, 1));
					}
				} else if ("05".equals(semmrt001Bean.getPeriod())) {
					if (amtOnce == 0.0 || amtOnce == null) {
						semmrt001Bean.getRentDetail().setPeriodAmt(0.0);
					} else {
						semmrt001Bean.getRentDetail().setPeriodAmt(calShraePeriodAmt(amtOnce, 1));
					}
				}
			} else if ("2".equals(type)) {
				semmrt001Bean.setDisMonth(false);
				semmrt001Bean.setPeriod("");
				semmrt001Bean.setPeriod4("");
				semmrt001Bean.setPayPeriodYear(0);
				semmrt001Bean.getRentDetail().setPayPeriodType(semmrt001Bean.getPeriod3());
				if ("03".equals(semmrt001Bean.getPeriod3()) && semmrt001Bean.getPayPeriodMonth() != null
						&& amtMonth != null) {
					semmrt001Bean.getRentDetail().setPeriodAmt(
							calShraePeriodAmt(amtMonth * semmrt001Bean.getPayPeriodMonth(), 1));
				}
			} else if ("3".equals(type)) {
				semmrt001Bean.setDisMonth(true);
				semmrt001Bean.setPeriod("");
				semmrt001Bean.setPeriod3("");
				semmrt001Bean.setPayPeriodMonth(0);
				semmrt001Bean.getRentDetail().setPayPeriodType(semmrt001Bean.getPeriod4());
				if ("04".equals(semmrt001Bean.getPeriod4()) && semmrt001Bean.getPayPeriodYear() != null
						&& amtYear != null) {
					semmrt001Bean.getRentDetail().setPeriodAmt(
							calShraePeriodAmt(amtYear * semmrt001Bean.getPayPeriodYear(), 1));
				}
			}

		} else {
			if ("1".equals(type)) {
				if ("05".equals(semmrt001Bean.getPeriod())) {
					semmrt001Bean.getRentDetail().setTotPeriodNo(new Integer(1));
				} else {
					semmrt001Bean.getRentDetail().setTotPeriodNo(null);
				}
				semmrt001Bean.setPeriod3("");
				semmrt001Bean.setPeriod4("");
				semmrt001Bean.setPayPeriodMonth(0);
				semmrt001Bean.setPayPeriodYear(0);
				semmrt001Bean.getRentDetail().setPayPeriodType(semmrt001Bean.getPeriod());
				LOG.debug("semmrt001Bean.getPeriod() = " + semmrt001Bean.getPeriod());
				// calculate Period Amt
				if ("01".equals(semmrt001Bean.getPeriod())) {
					semmrt001Bean.getRentDetail().setPeriodAmt(
							calShraePeriodAmt(semmrt001Bean.getRentDetail().getAmtPerMonth(), semmrt001Bean
									.getRentDetail().getCntVendor()));
				} else if ("02".equals(semmrt001Bean.getPeriod())) {
					semmrt001Bean.getRentDetail().setPeriodAmt(
							calShraePeriodAmt(semmrt001Bean.getRentDetail().getAmtPerYear(), semmrt001Bean
									.getRentDetail().getCntVendor()));
				} else if ("05".equals(semmrt001Bean.getPeriod())) {
					semmrt001Bean.getRentDetail().setPeriodAmt(
							calShraePeriodAmt(semmrt001Bean.getRentDetail().getAmtOneTime(), semmrt001Bean
									.getRentDetail().getCntVendor()));
					
				//13/07/2023 -- Add for fixed calculate Period by 3 Month	
				} else if ("06".equals(semmrt001Bean.getPeriod())) {	
					
					if ( semmrt001Bean.getRentDetail().getAmtPerMonth() != null) {
			 	        semmrt001Bean.getRentDetail().setPeriodAmt(
						calShraePeriodAmt(semmrt001Bean.getRentDetail().getAmtPerMonth()
								* 3 , semmrt001Bean.getRentDetail().getCntVendor()));
		        	}
				
					//13/07/2023 -- Add for fixed calculate Period by 6 Month	
				} else if ("07".equals(semmrt001Bean.getPeriod())) {	
					
					if ( semmrt001Bean.getRentDetail().getAmtPerMonth() != null) {
			 	        semmrt001Bean.getRentDetail().setPeriodAmt(
						calShraePeriodAmt(semmrt001Bean.getRentDetail().getAmtPerMonth()
								* 6 , semmrt001Bean.getRentDetail().getCntVendor()));
		        	}
	

				} else {
					semmrt001Bean.getRentDetail().setPeriodAmt(semmrt001Bean.getRentDetail().getRentalAmt());
				}
			} else if ("2".equals(type)) {
				semmrt001Bean.setDisMonth(false);
				semmrt001Bean.setPeriod("");
				semmrt001Bean.setPeriod4("");
				semmrt001Bean.setPayPeriodYear(0);
				semmrt001Bean.getRentDetail().setPayPeriodType(semmrt001Bean.getPeriod3());
				System.out.println("value Test" + semmrt001Bean.getRentDetail().getAmtPerMonth() + "  :: "
						+ semmrt001Bean.getPayPeriodMonth() + " :: " + semmrt001Bean.getRentDetail().getCntVendor());
				// calculate Period Amt
				if ("03".equals(semmrt001Bean.getPeriod3()) && semmrt001Bean.getPayPeriodMonth() != null
						&& semmrt001Bean.getRentDetail().getAmtPerMonth() != null) {
					semmrt001Bean.getRentDetail().setPeriodAmt(
							calShraePeriodAmt(semmrt001Bean.getRentDetail().getAmtPerMonth()
									* semmrt001Bean.getPayPeriodMonth(), semmrt001Bean.getRentDetail().getCntVendor()));
				}

			} else if ("3".equals(type)) {
				semmrt001Bean.setDisMonth(true);
				semmrt001Bean.setPeriod("");
				semmrt001Bean.setPeriod3("");
				semmrt001Bean.setPayPeriodMonth(0);
				semmrt001Bean.getRentDetail().setPayPeriodType(semmrt001Bean.getPeriod4());
				LOG.debug("semmrt001Bean.getPeriod3() = " + semmrt001Bean.getPeriod4());
				// calculate Period Amt
				if ("04".equals(semmrt001Bean.getPeriod4()) && semmrt001Bean.getPayPeriodYear() != null
						&& semmrt001Bean.getRentDetail().getAmtPerYear() != null) {
					semmrt001Bean.getRentDetail().setPeriodAmt(
							calShraePeriodAmt(semmrt001Bean.getRentDetail().getAmtPerYear()
									* semmrt001Bean.getPayPeriodYear(), semmrt001Bean.getRentDetail().getCntVendor()));
				}
			}
		}
		LOG.debug("semmrt001Bean.getModeRentalDetail() = " + semmrt001Bean.getModeRentalDetail());
		// if (semmrt001Bean.getModeRentalDetail().equals("ADD")) {
		// semmrt001Bean.setPayPeriodMonth(0);
		// semmrt001Bean.setPayPeriodYear(0);
		// }
		LOG.debug("semmrt001Bean.getPayPeriodMonth() = " + semmrt001Bean.getPayPeriodMonth());
		LOG.debug("semmrt001Bean.getPayPeriodYear() = " + semmrt001Bean.getPayPeriodYear());
		System.out.println("period " + semmrt001Bean.getRentDetail().getPeriodAmt());
		setSemmrt001Bean(semmrt001Bean);
	}

	// private String getVendorBookBank(String vendorMasterId) {
	// IVendorBookbankService vService =
	// (IVendorBookbankService)getBean("vendorBookbankService");
	// try {
	// return vService.queryByVendorMasterId(vendorMasterId);
	// } catch (Exception e) {
	// e.printStackTrace();
	// return "";
	// }
	// }

	@SuppressWarnings("unchecked")
	private Mrt001BookBank getVendorBookBank(String vendorMasterId, String mode) {
		IRentalDetailService vService = (IRentalDetailService) getBean("rentalDetailService");
		try {
			Mrt001BookBank criteria = new Mrt001BookBank();
			criteria.setVendorMasterId(vendorMasterId);
			criteria.setMode(mode);
			List<Mrt001BookBank> list = vService.querySPList(EQueryName.SP_MRT001_BOOKBANK.name, criteria);
			if (list != null && !list.isEmpty()) {
				return list.get(0);
			} else {
				return new Mrt001BookBank();
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e);
			return new Mrt001BookBank();
		}
	}

	// private String getPayeeBookbank(String payeeMasterId) {
	// IPayeeBookbankService pService =
	// (IPayeeBookbankService)getBean("payeeBookbankService");
	// try {
	// return pService.queryByPayeeMasterId(payeeMasterId).getBankAccNo();
	// } catch (Exception e) {
	// e.printStackTrace();
	// return "";
	// }
	// }

	@SuppressWarnings("unchecked")
	private Mrt001BookBank getPayeeBookBank(String payeeMasterId, String mode) {
		IRentalDetailService vService = (IRentalDetailService) getBean("rentalDetailService");
		try {
			Mrt001BookBank criteria = new Mrt001BookBank();
			criteria.setPayeeMasterId(payeeMasterId);
			criteria.setMode(mode);
			List<Mrt001BookBank> list = vService.querySPList(EQueryName.SP_MRT001_BOOKBANK.name, criteria);
			if (list != null && !list.isEmpty()) {
				return list.get(0);
			} else {
				return new Mrt001BookBank();
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e);
			return new Mrt001BookBank();
		}
	}

	@SuppressWarnings("unchecked")
	private List<SelectItem> getDropdownVendor(Mrt001SrchVendor mrt001SrchVendor) {
		IRentalDetailService service = (IRentalDetailService) getBean("rentalDetailService");
		try {
			List<Mrt001SrchVendor> list = service.querySPList(EQueryName.SP_MRT001_SRCH_VENDOR.name, mrt001SrchVendor);
			List<SelectItem> resultList = new ArrayList<SelectItem>();
			if (list.size() != 1) {
				resultList.add(setInitDropDown());
				semmrt001Bean.setDisRentAmt(false);
				semmrt001Bean.setDisDpstAmt(false);
			} else {
				Mrt001SrchPayee mrt001SrchPayee = new Mrt001SrchPayee();
				mrt001SrchPayee.setContractNo(semmrt001Bean.getDisplayFrmRental().getContractNo());
				mrt001SrchPayee.setVendorMasterId(list.get(0).getVendorMasterId());
				if (semmrt001Bean.getMode().equals("RENTAL")) {
					mrt001SrchPayee.setExpenseType(semmrt001Bean.getRentDetail().getExpenseType());
				} else {
					mrt001SrchPayee.setExpenseType(semmrt001Bean.getDpstDetail().getExpenseType());
				}
				semmrt001Bean.setDisRentAmt(true);
				semmrt001Bean.setDisDpstAmt(true);
				semmrt001Bean.setPayeeList(getDropdownPayee(mrt001SrchPayee));
			}

			for (Mrt001SrchVendor temp : list) {
				SelectItem item = new SelectItem();
				item.setLabel(temp.getVendorName());
				item.setValue(temp.getVendorMasterId());
				resultList.add(item);
			}
			return resultList;
		} catch (Exception e) {
			return getEmptyDropDown();
		}
	}

	@SuppressWarnings("unchecked")
	private List<SelectItem> getDropdownPayee(Mrt001SrchPayee mrt001SrchPayee) {
		IRentalDetailService service = (IRentalDetailService) getBean("rentalDetailService");
		try {
			List<Mrt001SrchPayee> list = service.querySPList(EQueryName.SP_MRT001_SRCH_PAYEE.name, mrt001SrchPayee);
			List<SelectItem> resultList = new ArrayList<SelectItem>();

			if (list == null || list.isEmpty()) {
				semmrt001Bean.setDisDdlpayee(true);
				if (semmrt001Bean.getMode().equals("RENTAL")) {
					// semmrt001Bean.getRentDetail().setBookBankNo(getVendorBookBank(mrt001SrchPayee.getVendorMasterId()));
					semmrt001Bean.setMrt001BookBank(getVendorBookBank(mrt001SrchPayee.getVendorMasterId(), "VENDOR"));
				} else {
					// semmrt001Bean.getDpstDetail().setBookBankNo(getVendorBookBank(mrt001SrchPayee.getVendorMasterId()));
					semmrt001Bean.setMrt001BookBank(getVendorBookBank(mrt001SrchPayee.getVendorMasterId(), "VENDOR"));
				}
				return getEmptyDropDown();
			} else {
				semmrt001Bean.setDisDdlpayee(false);
				if (list.size() != 1) {
					resultList.add(setInitDropDown());
					// semmrt001Bean.setDisRentAmt(false);
					// semmrt001Bean.setDisDpstAmt(false);
					semmrt001Bean.setMrt001BookBank(getVendorBookBank(mrt001SrchPayee.getVendorMasterId(), "VENDOR"));
				} else {
					// semmrt001Bean.setDisRentAmt(true);
					// semmrt001Bean.setDisDpstAmt(true);
					semmrt001Bean.setMrt001BookBank(getPayeeBookBank(list.get(0).getPayeeMasterId(), "PAYEE"));
				}
				for (Mrt001SrchPayee temp : list) {
					SelectItem item = new SelectItem();
					item.setLabel(temp.getPayeeName());
					item.setValue(temp.getPayeeMasterId());
					resultList.add(item);
				}
				return resultList;
			}
		} catch (Exception e) {
			return getEmptyDropDown();
		}
	}

	public void onChangeDdlVendor() {
		semmrt001Bean = getSemmrt001Bean();
		String modeDdl = (String) getFacesUtils().getRequestParameter("modeDdl");
		String vendorMasterId;
		if (modeDdl.equals("RENTAL")) {
			vendorMasterId = getSemmrt001Bean().getRentDetail().getVendorMasterId();
		} else {
			vendorMasterId = getSemmrt001Bean().getDpstDetail().getVendorMasterId();
		}
		if (StringUtils.isNotEmpty(vendorMasterId)) {
			Mrt001SrchPayee mrt001SrchPayee = new Mrt001SrchPayee();
			mrt001SrchPayee.setContractNo(semmrt001Bean.getDisplayFrmRental().getContractNo());
			if (semmrt001Bean.getMode().equals("RENTAL")) {
				mrt001SrchPayee.setVendorMasterId(vendorMasterId);
				mrt001SrchPayee.setExpenseType(semmrt001Bean.getRentDetail().getExpenseType());
				semmrt001Bean.setPayeeList(getDropdownPayee(mrt001SrchPayee));
				// semmrt001Bean.setMrt001BookBank(getVendorBookBank(mrt001SrchPayee.getVendorMasterId(),
				// "VENDOR"));
			} else {
				mrt001SrchPayee.setVendorMasterId(vendorMasterId);
				mrt001SrchPayee.setExpenseType(semmrt001Bean.getDpstDetail().getExpenseType());
				semmrt001Bean.setPayeeList(getDropdownPayee(mrt001SrchPayee));
				// semmrt001Bean.setMrt001BookBank(getVendorBookBank(mrt001SrchPayee.getVendorMasterId(),
				// "VENDOR"));
			}
		} else {
			semmrt001Bean.setPayeeList(getEmptyDropDown());
			semmrt001Bean.getMrt001BookBank().setBankAccNo("");
			semmrt001Bean.getMrt001BookBank().setBankName("");
			// semmrt001Bean.getRentDetail().setBookBankNo("");
		}
		setSemmrt001Bean(semmrt001Bean);
	}

	public void onChangeDdlPayee() {
		semmrt001Bean = getSemmrt001Bean();
		String modeDdl = (String) getFacesUtils().getRequestParameter("modeDdl");
		String payeeMasterId;
		if (modeDdl.equals("RENTAL")) {
			payeeMasterId = getSemmrt001Bean().getRentDetail().getPayeeMasterId();
		} else {
			payeeMasterId = getSemmrt001Bean().getDpstDetail().getPayeeMasterId();
		}
		if (StringUtils.isNotEmpty(getSemmrt001Bean().getRentDetail().getPayeeMasterId())) {
			semmrt001Bean.setMrt001BookBank(getPayeeBookBank(payeeMasterId, "PAYEE"));
		} else {
			String vendorMasterId;
			if (modeDdl.equals("RENTAL")) {
				vendorMasterId = getSemmrt001Bean().getRentDetail().getVendorMasterId();
			} else {
				vendorMasterId = getSemmrt001Bean().getDpstDetail().getVendorMasterId();
			}
			semmrt001Bean.setMrt001BookBank(getVendorBookBank(vendorMasterId, "VENDOR"));
		}
		setSemmrt001Bean(semmrt001Bean);
	}

	public void onChangeDdlExpenseType() {
		boolean chkObjSpecial = true;
		semmrt001Bean = getSemmrt001Bean();
		// Default
		semmrt001Bean.getRentDetail().setWhtType("03");
		// if (semmrt001Bean.getModePage().equals("SPECIAL")) {
		// Add 13/12/2012
		String expenseType = (String) getFacesUtils().getRequestParameter("expenseType");
		if (StringUtils.isNotEmpty(expenseType)) {
			LOG.debug("expenseType = " + expenseType);
			semmrt001Bean.getRentDetail().setExpenseType(expenseType);
		}

		Mrt001SrchVendor mrt001SrchVendor = new Mrt001SrchVendor();
		mrt001SrchVendor.setContractNo(semmrt001Bean.getDisplayFrmRental().getContractNo());

		String expenseTypeTmp = semmrt001Bean.getRentDetail().getExpenseType();

		if (semmrt001Bean.getMode().equals("RENTAL")) {

			LOG.debug("semmrt001Bean.getRentDetail().getExpenseType() = "
					+ semmrt001Bean.getRentDetail().getExpenseType());
			LOG.debug("semmrt001Bean.getDonateCondSpecial() = " + semmrt001Bean.getDonateCondSpecial());
			if (StringUtils.isEmpty(semmrt001Bean.getRentDetail().getExpenseType())) {
				clearRentalDetail();
				semmrt001Bean.getRentDetail().setExpenseType("");
				semmrt001Bean.getRentDetail().setWhtType("03");
				chkObjSpecial = false;
				// semmrt001Bean.setChkBtnAddSpecial(true);
			} else if (semmrt001Bean.getRentDetail().getExpenseType().equals("01")) {
				if (semmrt001Bean.getRentCondSpecial() != null) {
					semmrt001Bean.getRentDetail().setWhtRate(new Double("5"));
					semmrt001Bean.getRentDetail().setWhtType(semmrt001Bean.getRentCondSpecial().getWhtType());
					semmrt001Bean.getRentDetail().setPeriodStartDt(semmrt001Bean.getRentCondSpecial().getPeriodStDt());
					semmrt001Bean.getRentDetail().setPeriodEndDt(semmrt001Bean.getRentCondSpecial().getPeriodEndDt());
					semmrt001Bean.getRentDetail().setRentalAmt(null);
					semmrt001Bean.getRentDetail().setRentPeriodType(null);
					semmrt001Bean.getRentDetail().setTotPeriodNo(null);
					semmrt001Bean.getRentDetail().setPeriodAmt(null);
					// semmrt001Bean.getRentDetail().setPeriodDay(null);
					// semmrt001Bean.getRentDetail().setPeriodMonth(null);
					// semmrt001Bean.getRentDetail().setPeriodYear(null);
					semmrt001Bean.getRentDetail().setVatType(semmrt001Bean.getRentCondSpecial().getVatType()); // EDIT
					// BY
					// NOOM
					// 04/10/2013
					semmrt001Bean.setDisVat(true);
					semmrt001Bean.setChkBtnAddSpecial(false);
					semmrt001Bean.setDisabledSpacialChk(false);
					this.setChangeVat();
				} else {
					clearRentalDetail();
					// semmrt001Bean.getRentDetail().setExpenseType("01");
					semmrt001Bean.getRentDetail().setExpenseType(expenseTypeTmp);
					semmrt001Bean.setDisabledSpacialChk(true);
					chkObjSpecial = false;
					// semmrt001Bean.setChkBtnAddSpecial(true);
				}

			} else if (semmrt001Bean.getRentDetail().getExpenseType().equals("02")) {
				if (semmrt001Bean.isSpecialChk2()) {
					if (semmrt001Bean.getServCondSpecial() != null) {
						semmrt001Bean.getRentDetail().setWhtRate(new Double("3"));
						LOG.debug("semmrt001Bean.getServCondSpecial().getWhtType() = "
								+ semmrt001Bean.getServCondSpecial().getWhtType());
						semmrt001Bean.getRentDetail().setWhtType(semmrt001Bean.getServCondSpecial().getWhtType());
						semmrt001Bean.getRentDetail().setVatType(semmrt001Bean.getServCondSpecial().getVatType());
						semmrt001Bean.getRentDetail().setPeriodStartDt(
								semmrt001Bean.getServCondSpecial().getPeriodStDt());
						semmrt001Bean.getRentDetail().setPeriodEndDt(
								semmrt001Bean.getServCondSpecial().getPeriodEndDt());
						semmrt001Bean.getRentDetail().setRentalAmt(null);
						semmrt001Bean.getRentDetail().setRentPeriodType(null);
						semmrt001Bean.getRentDetail().setTotPeriodNo(null);
						semmrt001Bean.getRentDetail().setPeriodAmt(null);
						// semmrt001Bean.getRentDetail().setPeriodDay(null);
						// semmrt001Bean.getRentDetail().setPeriodMonth(null);
						// semmrt001Bean.getRentDetail().setPeriodYear(null);
						semmrt001Bean.setChkBtnAddSpecial(false);
						semmrt001Bean.setDisabledSpacialChk(false);
						this.setChangeVat();
					} else {
						clearRentalDetail();
						semmrt001Bean.getRentDetail().setExpenseType("02");
						semmrt001Bean.setDisabledSpacialChk(true);
						chkObjSpecial = false;
						// semmrt001Bean.setChkBtnAddSpecial(true);
					}
				}

				if (semmrt001Bean.isSpecialChk3()) {
					if (semmrt001Bean.getServCondSpecial2() != null) {
						semmrt001Bean.getRentDetail().setWhtRate(new Double("3"));
						LOG.debug("semmrt001Bean.getServCondSpecial().getWhtType() = "
								+ semmrt001Bean.getServCondSpecial2().getWhtType());
						semmrt001Bean.getRentDetail().setWhtType(semmrt001Bean.getServCondSpecial2().getWhtType());
						semmrt001Bean.getRentDetail().setVatType(semmrt001Bean.getServCondSpecial2().getVatType());
						semmrt001Bean.getRentDetail().setPeriodStartDt(
								semmrt001Bean.getServCondSpecial2().getPeriodStDt());
						semmrt001Bean.getRentDetail().setPeriodEndDt(
								semmrt001Bean.getServCondSpecial2().getPeriodEndDt());
						semmrt001Bean.getRentDetail().setRentalAmt(null);
						semmrt001Bean.getRentDetail().setRentPeriodType(null);
						semmrt001Bean.getRentDetail().setTotPeriodNo(null);
						semmrt001Bean.getRentDetail().setPeriodAmt(null);
						// semmrt001Bean.getRentDetail().setPeriodDay(null);
						// semmrt001Bean.getRentDetail().setPeriodMonth(null);
						// semmrt001Bean.getRentDetail().setPeriodYear(null);
						semmrt001Bean.setChkBtnAddSpecial(false);
						semmrt001Bean.setDisabledSpacialChk(false);
						this.setChangeVat();
					} else {
						clearRentalDetail();
						semmrt001Bean.getRentDetail().setExpenseType("02");
						semmrt001Bean.setDisabledSpacialChk(true);
						chkObjSpecial = false;
						// semmrt001Bean.setChkBtnAddSpecial(true);
					}
				}

				if (semmrt001Bean.isSpecialChk4()) {
					if (semmrt001Bean.getServCondSpecial3() != null) {
						semmrt001Bean.getRentDetail().setWhtRate(new Double("3"));
						LOG.debug("semmrt001Bean.getServCondSpecial().getWhtType() = "
								+ semmrt001Bean.getServCondSpecial3().getWhtType());
						semmrt001Bean.getRentDetail().setWhtType(semmrt001Bean.getServCondSpecial3().getWhtType());
						semmrt001Bean.getRentDetail().setVatType(semmrt001Bean.getServCondSpecial3().getVatType());
						semmrt001Bean.getRentDetail().setPeriodStartDt(
								semmrt001Bean.getServCondSpecial3().getPeriodStDt());
						semmrt001Bean.getRentDetail().setPeriodEndDt(
								semmrt001Bean.getServCondSpecial3().getPeriodEndDt());
						semmrt001Bean.getRentDetail().setRentalAmt(null);
						semmrt001Bean.getRentDetail().setRentPeriodType(null);
						semmrt001Bean.getRentDetail().setTotPeriodNo(null);
						semmrt001Bean.getRentDetail().setPeriodAmt(null);
						// semmrt001Bean.getRentDetail().setPeriodDay(null);
						// semmrt001Bean.getRentDetail().setPeriodMonth(null);
						// semmrt001Bean.getRentDetail().setPeriodYear(null);
						semmrt001Bean.setChkBtnAddSpecial(false);
						semmrt001Bean.setDisabledSpacialChk(false);
						this.setChangeVat();
					} else {
						clearRentalDetail();
						semmrt001Bean.getRentDetail().setExpenseType("02");
						semmrt001Bean.setDisabledSpacialChk(true);
						chkObjSpecial = false;
						// semmrt001Bean.setChkBtnAddSpecial(true);
					}
				}
			}
			// } else if
			// (semmrt001Bean.getRentDetail().getExpenseType().equals("03")) {
			// if (semmrt001Bean.getDonateCondSpecial() != null) {
			// semmrt001Bean.getRentDetail().setWhtRate(new Double("5"));
			// semmrt001Bean.getRentDetail().setWhtType(semmrt001Bean.getDonateCondSpecial().getWhtType());
			// semmrt001Bean.getRentDetail().setPeriodStartDt(semmrt001Bean.getDonateCondSpecial().getPeriodStDt());
			// semmrt001Bean.getRentDetail().setPeriodEndDt(semmrt001Bean.getDonateCondSpecial().getPeriodEndDt());
			// semmrt001Bean.setDisVat(true);
			// semmrt001Bean.setChkBtnAddSpecial(false);
			// } else {
			// clearRentalDetail();
			// semmrt001Bean.getRentDetail().setExpenseType("03");
			// chkObjSpecial = false;
			// // semmrt001Bean.setChkBtnAddSpecial(true);
			// }
			// }

			Date periodStDt = semmrt001Bean.getRentDetail().getPeriodStartDt();
			Date periodEndDt = semmrt001Bean.getRentDetail().getPeriodEndDt();
			if (periodStDt != null && periodEndDt != null) {
				if (periodStDt.after(periodEndDt)) {
					semmrt001Bean.getRentDetail().setPeriodStartDt(null);
					semmrt001Bean.getRentDetail().setPeriodEndDt(null);
					addMessageErrorWithArgument("W0048");
					semmrt001Bean.setRenderedMsgFormSearch(false);
				} else {
					calDateSpecial(periodStDt, periodEndDt);
				}
			}

			if (!semmrt001Bean.getRentDetail().getExpenseType().equals("01")) {
				semmrt001Bean.setDisVat(false);
			}

			if (chkObjSpecial) {
				// Get dropdown vendor
				mrt001SrchVendor.setExpenseType(semmrt001Bean.getRentDetail().getExpenseType());
			}
			semmrt001Bean.setVendorList(getDropdownVendor(mrt001SrchVendor));
		} else if (semmrt001Bean.getMode().equals("DEPOSIT")) {
			// Get dropdown vendor
			mrt001SrchVendor.setExpenseType(semmrt001Bean.getDpstDetail().getExpenseType());
			semmrt001Bean.setVendorList(getDropdownVendor(mrt001SrchVendor));
		}

		// } else {

		// TODO add-on case 'normal'
		// Mrt001SrchVendor mrt001SrchVendor = new Mrt001SrchVendor();
		if (StringUtils.isEmpty(semmrt001Bean.getRentDetail().getExpenseType())) {
			clearRentalDetail();
			semmrt001Bean.getRentDetail().setExpenseType("");
			chkObjSpecial = false;
			semmrt001Bean.setVendorList(getDropdownVendor(mrt001SrchVendor));
			// semmrt001Bean.setChkBtnAddSpecial(true);
		} else {
			mrt001SrchVendor.setContractNo(semmrt001Bean.getDisplayFrmRental().getContractNo());
			mrt001SrchVendor.setExpenseType(semmrt001Bean.getRentDetail().getExpenseType());
			semmrt001Bean.setVendorList(getDropdownVendor(mrt001SrchVendor));
			semmrt001Bean.setDisDpstAmt(false);
			LOG.debug("semmrt001Bean.getRentDetail() = " + semmrt001Bean.getRentDetail());
			LOG.debug("semmrt001Bean.getRentDetail().getExpenseType() = "
					+ semmrt001Bean.getRentDetail().getExpenseType());
			if (semmrt001Bean.getRentDetail().getExpenseType() != null) {
				if (semmrt001Bean.getRentDetail().getExpenseType().equals("01")) {
					semmrt001Bean.getRentDetail().setWhtRate(new Double("5"));
				} else if (semmrt001Bean.getRentDetail().getExpenseType().equals("02")) {
					semmrt001Bean.getRentDetail().setWhtRate(new Double("3"));
				} else if (semmrt001Bean.getRentDetail().getExpenseType().equals("03")) {
					semmrt001Bean.getRentDetail().setWhtRate(null);
				}
			}
		}
		// }

		// For case special get vendor dropdownList
		// if (semmrt001Bean.getModePage().equals("SPECIAL")) {
		// Mrt001SrchVendor mrt001SrchVendor = new Mrt001SrchVendor();
		// mrt001SrchVendor.setContractNo(semmrt001Bean.getDisplayFrmRental().getContractNo());
		// if (semmrt001Bean.getMode().equals("RENTAL")) {
		// if (chkObjSpecial) {
		// // Get dropdown vendor
		// mrt001SrchVendor.setExpenseType(semmrt001Bean.getRentDetail().getExpenseType());
		// semmrt001Bean.setVendorList(getDropdownVendor(mrt001SrchVendor));
		// }
		// } else if (semmrt001Bean.getMode().equals("DEPOSIT")) {
		// // Get dropdown vendor
		// mrt001SrchVendor.setExpenseType(semmrt001Bean.getDpstDetail().getExpenseType());
		// semmrt001Bean.setVendorList(getDropdownVendor(mrt001SrchVendor));
		// }
		//			
		// }

		setSemmrt001Bean(semmrt001Bean);
	}

	private String setMsgError(String msg, String str) {
		if (!msg.equals("")) {
			msg += ", " + str;
		} else {
			msg = str;
		}
		return msg;
	}

	private boolean validateMergeRentData(VerifyRentalSearchSiteRentCondSP temp) {
		boolean flag = true;
		RentalDetail o = getSemmrt001Bean().getRentDetail();
		String msg = "";
		// Case selected more one data
		// expense_type, pay_period, wht_type, vat_type, pay_period_type
		if (!SemUtils.equalsString(o.getExpenseType(), temp.getExpenseType())) {
			msg = setMsgError(msg, msg("message.expenseType2"));
			flag = false;
		}
		if (temp.getPayPeriod() == null) {
			msg = setMsgError(msg, msg("message.payPeriod"));
			flag = false;
		} else {
			if (!o.getPayPeriod().equals(SemUtils.parseInteger(temp.getPayPeriod()))) {
				msg = setMsgError(msg, msg("message.payPeriod"));
				flag = false;
			}
		}
		if (!SemUtils.equalsString(o.getWhtType(), temp.getWhtType())) {
			msg = setMsgError(msg, msg("message.whtType"));
			flag = false;
		}
		if (!SemUtils.equalsString(o.getVatType(), temp.getVatType())) {
			msg = setMsgError(msg, "VAT");
			flag = false;
		}
		if (!SemUtils.equalsString(o.getPayPeriodType(), temp.getPayPeriodType())) {
			msg = setMsgError(msg, msg("message.payPeriodType"));
			flag = false;
		}
		if (o.getEffectiveDt() != null && temp.getEffectiveDT() != null) {
			if (o.getEffectiveDt().compareTo(temp.getEffectiveDT()) != 0) {
				msg = setMsgError(msg, msg("message.effDt"));
				flag = false;
			}
		} else if ((o.getEffectiveDt() == null && temp.getEffectiveDT() != null)) {
			msg = setMsgError(msg, msg("message.effDt"));
			flag = false;
		} else if ((o.getEffectiveDt() != null && temp.getEffectiveDT() == null)) {
			msg = setMsgError(msg, msg("message.effDt"));
			flag = false;
		}

		if (!o.getRentPeriodType().equals(temp.getRentPeriodType())) {
			msg = setMsgError(msg, msg("message.rentPeriodType"));
			flag = false;
		}

		if (!flag) {
			addMessageError("W0015", msg);
		}
		return flag;
	}

	private boolean validateMergeDpstData(Mrt001SrchDpstCond temp) {
		boolean flag = true;
		DepositDetail o = getSemmrt001Bean().getDpstDetail();
		String msg = "";
		// Case more one data
		// @expense_type , @deposit_type And @vat_type
		if (!SemUtils.equalsString(o.getExpenseType(), temp.getExpenseType())) {
			msg = setMsgError(msg, msg("message.expenseType2"));
			flag = false;
		}
		if (!SemUtils.equalsString(o.getDepositType(), temp.getDepositType())) {
			msg = setMsgError(msg, msg("message.depositType"));
			flag = false;
		}
		if (!SemUtils.equalsString(o.getVatType(), temp.getVatType())) {
			msg = setMsgError(msg, "VAT");
			flag = false;
		}
		return flag;
	}

	private Double calShraePeriodAmt(Double balanceAmt, Integer cntVendor) {
		Double tmp = new Double(0);
		if (cntVendor != null && cntVendor.intValue() != 0) {
			tmp = balanceAmt / cntVendor;
		}
		return tmp;
	}

	private RentalDetail setFirstRentCond(VerifyRentalSearchSiteRentCondSP temp) {
		RentalDetail rentDetail = new RentalDetail();

		rentDetail.setExpenseType(temp.getExpenseType());
		rentDetail.setWhtType(temp.getWhtType());
		rentDetail.setVatType(temp.getVatType());
		rentDetail.setRentPeriodType(temp.getRentPeriodType());
		rentDetail.setPayPeriodType(temp.getPayPeriodType());
		setRadioPayPeriodType(rentDetail.getPayPeriodType(), temp.getPayPeriod());
		rentDetail.setPayPeriod(new Integer(temp.getPayPeriod()));
		if (StringUtils.isNotEmpty(temp.getWhtRate()))
			rentDetail.setDefaultWht(new Double(temp.getWhtRate()));
		// if (StringUtils.isEmpty(temp.getVatType()))
		// rentDetail.setVatType("");
		// rentDetail.setDefaultVat(new Double(temp.getDefaultVat()));
		if (StringUtils.isNotEmpty(temp.getWhtRate()))
			rentDetail.setWhtRate(new Double(temp.getWhtRate()));
		if (StringUtils.isNotEmpty(temp.getVatRate())) {
			rentDetail.setVatRate(new Double(temp.getVatRate()));
		} else {
			rentDetail.setVatRate(new Double(0));
		}
		if (temp.getBalanceAmt() != null)
			rentDetail.setRentalAmt(temp.getRentAmt());
		// if (temp.getBalanceAmt() != null)
		// rentDetail.setPeriodAmt(calShraePeriodAmt(temp.getRentAmt(),
		// temp.getCntVendor()));
		rentDetail.setPeriodAmt(temp.getPeriodAmt());
		if (temp.getBalanceAmt() != null)
			rentDetail.setBalanceAmt(temp.getBalanceAmt() - rentDetail.getPeriodAmt());
		if (temp.getBalanceAmt() != null)
			rentDetail.setTmpBalanceAmt(temp.getBalanceAmt());
		rentDetail.setPeriodStartDt(temp.getPeriodStDt());
		rentDetail.setPeriodEndDt(temp.getPeriodEndDt());
		rentDetail.setEffectiveDt(temp.getEffectiveDT());
		rentDetail.setExpiredDt(temp.getExpireDt());
		rentDetail.setSiteRentCondId(temp.getSiteRentCondId());
		rentDetail.setAmtPerMonth(temp.getAmtPerMonth());
		rentDetail.setAmtPerYear(temp.getAmtPerYear());
		rentDetail.setCntVendor(temp.getCntVendor());
		rentDetail.setAmtOneTime(temp.getAmtOneTime());
		
		//add 21/03/2023
		rentDetail.setExpenseDesc(temp.getExpenseDesc());
		
		
		return rentDetail;
	}

	public void doSelectedRentSetup() {
		semmrt001Bean = getSemmrt001Bean();
		semmrt001Bean.setRenderedMsgFormSearch(false);
		semmrt001Bean.setDisabledExpenseType(true);
		String siteRentCondId = (String) getFacesUtils().getRequestParameter("siteRentCondId");
		// String siteInfoId =
		// (String)getFacesUtils().getRequestParameter("siteInfoId");

		semmrt001Bean.setCheckMode("NORMAL");

		semmrt001Bean.setSpecialChk1(false);
		semmrt001Bean.setSpecialChk2(false);

		if (semmrt001Bean.getModeRentalDetail().equals("EDIT")) {
			semmrt001Bean.setRentDetail(new RentalDetail());
			semmrt001Bean.getRentDetail().setEffectiveDt(new Date());
			semmrt001Bean.setCountDataSelect(0);
			semmrt001Bean.setModeRentalDetail("ADD");
			semmrt001Bean.setVendorList(getEmptyDropDown());
			semmrt001Bean.setPayeeList(getEmptyDropDown());
		}
		// 20110202
		LOG.debug("semmrt001Bean.getRentCondList().size() = " + semmrt001Bean.getRentCondList().size());
		for (int i = 0; i < semmrt001Bean.getRentCondList().size(); i++) {
			// find data is selected
			if (siteRentCondId.equals(semmrt001Bean.getRentCondList().get(i).getSiteRentCondId())) {
				// validate data is selected have value 'true' or 'false'
				VerifyRentalSearchSiteRentCondSP temp = semmrt001Bean.getRentCondList().get(i);
				boolean flag = temp.isSelected();
				int count = semmrt001Bean.getCountDataSelect();

				if (flag) {
					LOG.debug("count = " + count);
					if (count == 0) {
						// First data
						// transfer data is selected to form add rental detail
						// site_rental_cond_id, expense_type, wht_type,
						// wht_rate, vat_type
						// rent_period_type, pay_period_type, pay_period,
						// balance_amt
						
						
						semmrt001Bean.setRentDetail(setFirstRentCond(temp));
						callMrt001BalanceCal();
						
						//Add for calculate refresh period, periodAmt
						chkPayPeriodType() ;
						doCalculate();
						
						
						LOG.debug("semmrt001Bean.getRentDetail().getRowId() = "
								+ semmrt001Bean.getRentDetail().getRowId());
						LOG.debug("semmrt001Bean.getRentDetail().getSiteRentCondId() = "
								+ semmrt001Bean.getRentDetail().getSiteRentCondId());
						semmrt001Bean.setCountDataSelect(semmrt001Bean.getCountDataSelect() + 1);

						// Get dropdown vendor
						Mrt001SrchVendor mrt001SrchVendor = new Mrt001SrchVendor();
						mrt001SrchVendor.setExpenseType(semmrt001Bean.getRentDetail().getExpenseType());
						mrt001SrchVendor.setContractNo(semmrt001Bean.getDisplayFrmRental().getContractNo());
						semmrt001Bean.setVendorList(getDropdownVendor(mrt001SrchVendor));
					} else {
						// Not is first data (select more one data)
						// Validate data is selected have value 'true' or
						// 'false'
						// Merge data is selected to form add rental detail
						// Check condition value expense_type, pay_period,
						// wht_type, vat_type, pay_period_type
						if (validateMergeRentData(temp)) {
							if (temp.getBalanceAmt() != null)
								semmrt001Bean.getRentDetail().setRentalAmt(
										semmrt001Bean.getRentDetail().getRentalAmt() + temp.getBalanceAmt());
							if (temp.getBalanceAmt() != null)
								semmrt001Bean.getRentDetail().setPeriodAmt(
										semmrt001Bean.getRentDetail().getPeriodAmt()
												+ calShraePeriodAmt(temp.getBalanceAmt(), temp.getCntVendor()));
							semmrt001Bean.setCountDataSelect(semmrt001Bean.getCountDataSelect() + 1);
							semmrt001Bean.setRenderedMsgFormSearch(false);
						} else {
							temp.setSelected(false);
							semmrt001Bean.setRenderedMsgFormSearch(true);
						}
					}
				} else {
					// unSelected
					if (count == 1) {
						semmrt001Bean.setRentDetail(new RentalDetail());
						semmrt001Bean.getRentDetail().setEffectiveDt(new Date());
						semmrt001Bean.setVendorList(getEmptyDropDown());
						semmrt001Bean.setPayeeList(getEmptyDropDown());
						semmrt001Bean.setMrt001BookBank(new Mrt001BookBank());
						semmrt001Bean.setDisRentAmt(false);
					} else {
						Double oldAmt = semmrt001Bean.getRentDetail().getRentalAmt();
						Double selectAmt = temp.getBalanceAmt();
						semmrt001Bean.getRentDetail().setRentalAmt(oldAmt - selectAmt);
						Double oldPeriodAmt = semmrt001Bean.getRentDetail().getPeriodAmt();
						Double selectPeriodAmt = calShraePeriodAmt(temp.getBalanceAmt(), temp.getCntVendor());
						semmrt001Bean.getRentDetail().setPeriodAmt(oldPeriodAmt - selectPeriodAmt);
					}
					semmrt001Bean.setCountDataSelect(semmrt001Bean.getCountDataSelect() - 1);
				}
			}
		}

		if (semmrt001Bean.getRentDetail() != null) {
			// LOG.debug("semmrt001Bean.getRentDetail().getRentalAmt() : "+semmrt001Bean.getRentDetail().getRentalAmt());
			if (semmrt001Bean.getRentDetail().getRentalAmt() != null
					&& semmrt001Bean.getRentDetail().getRentalAmt() > 0) {
				semmrt001Bean.setDisabledSpacialChk(true);
			} else {
				semmrt001Bean.setDisabledSpacialChk(false);
			}
		}

		setSemmrt001Bean(semmrt001Bean);
	}

	private DepositDetail setFirstDpstSetup(Mrt001SrchDpstCond temp) {
		DepositDetail dpstDetail = new DepositDetail();

		dpstDetail.setExpenseType(temp.getExpenseType());
		if (StringUtils.isEmpty(temp.getVatType())) {
			temp.setVatType("");
		}
		dpstDetail.setVatType(temp.getVatType());
		if (temp.getCondDepositAmt() != null)
			dpstDetail.setDepositRentAmt(temp.getCondBalanceAmt());
		if (temp.getCondDepositAmt() != null)
			dpstDetail.setDepositAmt(temp.getCondBalanceAmt());
		dpstDetail.setDepositType(temp.getDepositType());

		return dpstDetail;
	}

	public void doSelectedDpstSetup() {
		semmrt001Bean = getSemmrt001Bean();
		semmrt001Bean.setRenderedMsgFormSearch(false);
		String siteDpstCondId = (String) getFacesUtils().getRequestParameter("siteDpstCondId");

		if (semmrt001Bean.getModeDpstDetail().equals("EDIT")) {
			semmrt001Bean.setDpstDetail(new DepositDetail());
			semmrt001Bean.getDpstDetail().setVatType("01");
			semmrt001Bean.getDpstDetail().setVatRate(getVatRate());
			semmrt001Bean.setCountDataSelect(0);
			semmrt001Bean.setModeDpstDetail("ADD");
			semmrt001Bean.setVendorList(getEmptyDropDown());
			semmrt001Bean.setPayeeList(getEmptyDropDown());
		}
		for (int i = 0; i < semmrt001Bean.getDpstCondList().size(); i++) {
			if (siteDpstCondId.equals(semmrt001Bean.getDpstCondList().get(i).getSiteDepositId())) {
				Mrt001SrchDpstCond temp = semmrt001Bean.getDpstCondList().get(i);
				boolean flag = temp.isSelected();
				int count = semmrt001Bean.getCountDataSelect();

				if (flag) {
					// LOG.debug("count = "+count);
					if (count == 0) {
						// First data
						// transfer data is selected to form add rental detail
						semmrt001Bean.setDpstDetail(setFirstDpstSetup(temp));
						semmrt001Bean.getDpstDetail().setPeriodStDt(semmrt001Bean.getDisplayFrmRental().getEffDate());
						semmrt001Bean.getDpstDetail().setPeriodEndDt(
								semmrt001Bean.getDisplayFrmRental().getExpireDate());

						semmrt001Bean.setCountDataSelect(semmrt001Bean.getCountDataSelect() + 1);

						// Get dropdown vendor
						Mrt001SrchVendor mrt001SrchVendor = new Mrt001SrchVendor();
						mrt001SrchVendor.setExpenseType(semmrt001Bean.getDpstDetail().getExpenseType());
						mrt001SrchVendor.setContractNo(semmrt001Bean.getDisplayFrmRental().getContractNo());
						semmrt001Bean.setVendorList(getDropdownVendor(mrt001SrchVendor));
					} else {
						// Not is first data (select more one data)
						// Validate data is selected have value 'true' or
						// 'false'
						// Merge data is selected to form add rental detail
						if (validateMergeDpstData(temp)) {
							if (temp.getCondBalanceAmt() != null)
								semmrt001Bean.getDpstDetail().setDepositRentAmt(
										semmrt001Bean.getDpstDetail().getDepositRentAmt() + temp.getCondBalanceAmt());
							if (temp.getCondBalanceAmt() != null)
								semmrt001Bean.getDpstDetail().setDepositAmt(
										semmrt001Bean.getDpstDetail().getDepositAmt() + temp.getCondBalanceAmt());
							semmrt001Bean.setCountDataSelect(semmrt001Bean.getCountDataSelect() + 1);
						} else {
							temp.setSelected(false);
							semmrt001Bean.setRenderedMsgFormSearch(true);
						}
					}
					if ("02".equals(semmrt001Bean.getDpstDetail().getDepositType())) {
						setSemmrt001Bean(semmrt001Bean);
						calculateVat();
						semmrt001Bean = getSemmrt001Bean();
					}

					if (temp.isSelected()) {
						semmrt001Bean.setSelectedBGSpecial(false);
						semmrt001Bean.setSelectedCashSpecial(false);
					}
				} else {
					// unSelected
					if (count == 1) {
						// clear Deposit Detail after last data selected
						semmrt001Bean.setDpstDetail(new DepositDetail());
						semmrt001Bean.getDpstDetail().setVatType("01");
						semmrt001Bean.getDpstDetail().setVatRate(getVatRate());
						semmrt001Bean.setVendorList(getEmptyDropDown());
						semmrt001Bean.setPayeeList(getEmptyDropDown());
						semmrt001Bean.setMrt001BookBank(new Mrt001BookBank());
						semmrt001Bean.setDisDpstAmt(false);
					} else {
						Double oldAmt = semmrt001Bean.getDpstDetail().getDepositRentAmt();
						Double selectAmt = temp.getCondBalanceAmt();
						if (oldAmt != null && selectAmt != null)
							semmrt001Bean.getDpstDetail().setDepositRentAmt(oldAmt - selectAmt);
						semmrt001Bean.getDpstDetail().setDepositAmt(semmrt001Bean.getDpstDetail().getDepositRentAmt());
						if ("02".equals(semmrt001Bean.getDpstDetail().getDepositType())) {
							setSemmrt001Bean(semmrt001Bean);
							calculateVat();
							semmrt001Bean = getSemmrt001Bean();
						}
					}
					semmrt001Bean.setCountDataSelect(semmrt001Bean.getCountDataSelect() - 1);
				}

			}
		}

		setSemmrt001Bean(semmrt001Bean);
	}

	@SuppressWarnings("unchecked")
	private String validatePeriodDate(Mrt001CheckDate mrt001CheckDate) {
		IRentalDetailService service = (IRentalDetailService) getBean("rentalDetailService");
		try {
			List list = service.querySPList(EQueryName.SP_MRT001_CHECK_DATE.name, mrt001CheckDate);
			return ((Mrt001CheckDate) list.get(0)).getRemark();
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e);
			return null;
		}
	}

	private boolean validateRentalDetail() {
		boolean vFlag = true;
		Date periodStDt = getSemmrt001Bean().getRentDetail().getPeriodStartDt();
		Date periodEndDt = getSemmrt001Bean().getRentDetail().getPeriodEndDt();
		Date expireDt = getSemmrt001Bean().getDisplayFrmRental().getExpireDate();
		if (StringUtils.isEmpty(getSemmrt001Bean().getRentDetail().getExpenseType())) {
			addMessageError("W0001", msg("message.expenseType2"));
			vFlag = false;
		}
		if (getSemmrt001Bean().getRentDetail().getPeriodAmt() == null
				|| getSemmrt001Bean().getRentDetail().getPeriodAmt() == 0) {
			addMessageError("W0001", msg("message.periodAmt"));
			vFlag = false;
		}
		if (StringUtils.isEmpty(getSemmrt001Bean().getRentDetail().getVendorMasterId())) {
			addMessageError("W0001", msg("message.vendorId"));
			vFlag = false;
		}

		if (getSemmrt001Bean().getDisplayFrmRental().getRentCondType().equals("02")) {
			// validate for type special
			if (StringUtils.isEmpty(getSemmrt001Bean().getRentDetail().getPayPeriodType())) {
				addMessageError("W0001", msg("message.payPeriodType"));
				vFlag = false;
			}

			if (periodStDt == null) {
				addMessageError("W0001", msg("message.periodStDt"));
				vFlag = false;
			}

			if (semmrt001Bean.isRequireFlag() && periodEndDt == null) {
				addMessageError("W0001", msg("message.periodEndDt"));
				vFlag = false;
			}

			// Comment not use By Bas 20111021
			/*
			 * Mrt001CheckDate mrt001CheckDate = new Mrt001CheckDate();
			 * mrt001CheckDate
			 * .setExpenseType(getSemmrt001Bean().getRentDetail().
			 * getExpenseType());
			 * mrt001CheckDate.setRentalMasterId(getSemmrt001Bean
			 * ().getDisplayFrmRental().getRentalMasterId());
			 * mrt001CheckDate.setPeriodStartDt(periodStDt);
			 * mrt001CheckDate.setPeriodEndDt(periodEndDt);
			 * mrt001CheckDate.setVendorMasterId
			 * (getSemmrt001Bean().getRentDetail().getVendorMasterId());
			 * mrt001CheckDate
			 * .setCurrentId(getSemmrt001Bean().getRentDetail().getRowId());
			 * String result = validatePeriodDate(mrt001CheckDate); if (result
			 * == null || !result.equals("Success")) {
			 * addGeneralMessageError(result); vFlag = false; }
			 */
		}

		// Comment By Noom
		// Integer totPeroidNo = semmrt001Bean.getRentDetail().getTotPeriodNo();
		// if (getSemmrt001Bean().getModePage().equals("SPECIAL") &&
		// (totPeroidNo == null || totPeroidNo == 0) &&
		// semmrt001Bean.isRequireFlag()) {
		// addMessageError("W0001", msg("message.totPeriodNo"));
		// vFlag = false;
		// }
		// if(expireDt!=null){
		// if(periodEndDt==null){
		// addMessageError("W0001", msg("message.periodEndDt"));
		// vFlag = false;
		// }
		// }

		Date effDt = getSemmrt001Bean().getRentDetail().getEffectiveDt();
		Date expDt = getSemmrt001Bean().getRentDetail().getExpiredDt();

		if (effDt != null && expDt != null) {
			if (effDt.after(expDt)) {
				addMessageErrorWithArgument("W0006", msg("message.expireDt"), msg("message.effectDt"));
				vFlag = false;
			}
		}

		if (periodStDt != null && periodEndDt != null) {
			if (periodStDt.after(periodEndDt)) {
				addMessageErrorWithArgument("W0006", msg("message.periodEndDt"), msg("message.periodStDt"));
				vFlag = false;
			}

		}
		return vFlag;
	}

	private RentalCondMapSi setRentalCondMapSi(String company, String rentalMasterId, String siteRentCondId) {
		RentalCondMapSi o = new RentalCondMapSi();
		o.setCompany(company);
		o.setRentalMasterId(rentalMasterId);
		o.setSiteRentalCondId(siteRentCondId);
		o.setRentalSetupAmt(0.0);
		o.setRecordStatus("Y");
		o.setCurrentUser(getUserLogIn());
		return o;
	}

	@SuppressWarnings("unchecked")
	private boolean doAddRentalDetail() {
		boolean flag = false;
		// validate rental detail
		semmrt001Bean = getSemmrt001Bean();
		semmrt001Bean.setRenderedMsgFormSearch(false);
		semmrt001Bean.setRenderedMsgFormMiddle(true);
		System.out.println("getSiteRentCondId 1 = " + semmrt001Bean.getRentDetail().getSiteRentCondId());
		if (validateRentalDetail()) {

			if (semmrt001Bean.getRentDetail().isProrate()) {
				semmrt001Bean.getRentDetail().setProrateFlag("Y");
			} else {
				semmrt001Bean.getRentDetail().setProrateFlag("N");
			}
			// semmrt001Bean.getRentDetail().setRentalAmt(semmrt001Bean.getRentDetail().getVerifyAmt());
			semmrt001Bean.getRentDetail().setCompany(semmrt001Bean.getDisplayFrmRental().getCompany());
			semmrt001Bean.getRentDetail().setRentalMasterId(semmrt001Bean.getDisplayFrmRental().getRentalMasterId());
			if (StringUtils.equalsIgnoreCase("NORMAL", semmrt001Bean.getCheckMode())) {
				semmrt001Bean.getRentDetail().setRentalCondType("01");
			} else if (StringUtils.equalsIgnoreCase("SPECIAL", semmrt001Bean.getCheckMode())) {
				semmrt001Bean.getRentDetail().setRentalCondType("02");
			} else {
				semmrt001Bean.getRentDetail().setRentalCondType(semmrt001Bean.getDisplayFrmRental().getRentCondType());
			}
			// check data pay period
			if (semmrt001Bean.getRentDetail().getPayPeriodType().equals("03")) {
				semmrt001Bean.getRentDetail().setPayPeriod(semmrt001Bean.getPayPeriodMonth());
			} else if (semmrt001Bean.getRentDetail().getPayPeriodType().equals("04")) {
				semmrt001Bean.getRentDetail().setPayPeriod(semmrt001Bean.getPayPeriodYear());
			} else {
				semmrt001Bean.getRentDetail().setPayPeriod(null);
			}
			semmrt001Bean.getRentDetail().setCurrentUser(getUserLogIn());
			semmrt001Bean.getRentDetail().setRecordStatus("Y");

			// set payPeriodType กรณี สามารถแก้ไขได้ [special]
			List<RentalCondMapSi> oList = new ArrayList<RentalCondMapSi>();
			if (!semmrt001Bean.isSpecialChk2() && !semmrt001Bean.isSpecialChk1()) {
				// if
				// (semmrt001Bean.getRentDetail().getRentalCondType().equals("01"))
				// {
				// case add
				List<String> tmpRentCondList = new ArrayList<String>();
				for (VerifyRentalSearchSiteRentCondSP temp : semmrt001Bean.getRentCondList()) {
					if (temp.isSelected()) {
						tmpRentCondList.add(temp.getSiteRentCondId());
						oList.add(setRentalCondMapSi(semmrt001Bean.getDisplayFrmRental().getCompany(), semmrt001Bean
								.getDisplayFrmRental().getRentalMasterId(), temp.getSiteRentCondId()));
					}
				}

				// Comment not use By Bas 20111021
				/*
				 * if (semmrt001Bean.getRentDetailList() != null &&
				 * !semmrt001Bean.getRentDetailList().isEmpty()) { String
				 * vendorMasterId =
				 * semmrt001Bean.getRentDetail().getVendorMasterId();
				 * 
				 * for (Mrt001SrchRentDetail tmpDetail:
				 * semmrt001Bean.getRentDetailList()) { if
				 * (tmpDetail.getVendorMasterId().equals(vendorMasterId)) {
				 * String detailRentCond = tmpDetail.getmSiteRentCond();
				 * List<String> strList =
				 * Arrays.asList(detailRentCond.split(",")); for (String
				 * tmpRentCond : tmpRentCondList) { for (String
				 * tmpDetailRentCond: strList) { if
				 * (tmpRentCond.equals(tmpDetailRentCond)) {
				 * addMessageError("W0097", tmpDetail.getVendorName());
				 * 
				 * return flag; } } } } }
				 * 
				 * }
				 */

			} else {
				// for case special

				String siteInfoId = "";
				if (semmrt001Bean.getRentDetail().getExpenseType().equals("01")) {
					siteInfoId = semmrt001Bean.getRentCondSpecial().getSiteRentCondId();
				} else if (semmrt001Bean.getRentDetail().getExpenseType().equals("02")) {
					siteInfoId = semmrt001Bean.getServCondSpecial().getSiteRentCondId();
				}
				oList.add(setRentalCondMapSi(semmrt001Bean.getDisplayFrmRental().getCompany(), semmrt001Bean
						.getDisplayFrmRental().getRentalMasterId(), siteInfoId));
			}
			if (callMrt001BalanceCal()) {
				System.out.println("getSiteRentCondId 2 = " + semmrt001Bean.getRentDetail().getSiteRentCondId());
				IRentalDetailService service = (IRentalDetailService) getBean("rentalDetailService");
				try {
					// Save Rental Detail
					RentalDetail result = service.saveVerifyRentalSetup(semmrt001Bean.getRentDetail(), oList,
							semmrt001Bean.getModeRentalDetail());
					if (result != null) {
						// call store proc 'sem_sp_mrt001_upd_rent_map'
						// pass param @rentalMasterId, @rental_detail_id,
						// @periodAmt
						// @user
						Mrt001UpdRentMap updRentMap = new Mrt001UpdRentMap();
						updRentMap.setRentalMasterId(result.getRentalMasterId());
						updRentMap.setRentalDetailId(result.getRowId());
						updRentMap.setPeriodAmt(result.getPeriodAmt());
						updRentMap.setCurrentUser(getUserLogIn());
						List<Mrt001UpdRentMap> resultListMap = service.querySPList(
								EQueryName.SP_MRT001_UPD_RENT_MAP.name, updRentMap);
						if (resultListMap != null && !resultListMap.isEmpty()) {
							// call store proc 'sem_sp_mrt001_upd_rent_pay'
							// pass param @expense_type, @rent_cond_type,
							// @rental_detail_id, @mode
							Mrt001UpdRentPay updRentPay = new Mrt001UpdRentPay();
							updRentPay.setExpenseType(result.getExpenseType());
							updRentPay.setRentCondType(result.getRentalCondType());
							updRentPay.setRentalDetailId(result.getRowId());
							updRentPay.setMode(semmrt001Bean.getModeRentalDetail());
							updRentPay.setCurrentUser(getUserLogIn());

							List<Mrt001UpdRentPay> resultList = service.querySPList(
									EQueryName.SP_MRT001_UPD_RENT_PAY.name, updRentPay);
							if (resultList != null && !resultList.isEmpty()) {
								// semmrt001Bean.setRentDetail(new
								// RentalDetail());
								// semmrt001Bean.getRentDetail().setEffectiveDt(new
								// Date());
								// semmrt001Bean.setModeRentalDetail("ADD");
								// semmrt001Bean.setCountDataSelect(0);
								// Clear vendor & payee
								// if
								// (semmrt001Bean.getDisplayFrmRental().getRentCondType().equals("01"))
								// {
								// semmrt001Bean.setVendorList(getEmptyDropDown());
								// semmrt001Bean.setPayeeList(getEmptyDropDown());
								// } else {
								// semmrt001Bean.setPayeeList(getEmptyDropDown());
								// }

								// Plydo
								doBeforeAddMain(result.getRowId(), semmrt001Bean.getDisplayFrmRental().getSiteInfoId());

								clearRentalDetail();
								Mrt001SrchRentDetail rentDetailSP = new Mrt001SrchRentDetail();
								rentDetailSP.setRentalMasterId(semmrt001Bean.getDisplayFrmRental().getRentalMasterId());
								rentDetailSP.setServiceName(semmrt001Bean.getServiceCalTypeId());
								rentDetailSP.setServiceCalType(semmrt001Bean.getServiceCalTypeTbl());
								List toDetail = getSPMrt001SrchRentDetail(rentDetailSP);
								semmrt001Bean.setRentDetailList(toDetail);

								VerifyRentalSearchSiteRentCondSP oSP = new VerifyRentalSearchSiteRentCondSP();
								oSP.setRentalMasterId(semmrt001Bean.getDisplayFrmRental().getRentalMasterId());
								oSP.setSiteInfoId(semmrt001Bean.getDisplayFrmRental().getSiteInfoId());
								List<VerifyRentalSearchSiteRentCondSP> to = getSPMrt001SrchRentCond(oSP);
								// Disable Select if balanceAmt == 0
								if (!semmrt001Bean.isViewMode()) {
									for (VerifyRentalSearchSiteRentCondSP object : to) {
										if (object.getBalanceAmt() != null
												&& !object.getBalanceAmt().equals(new Double(0))
												|| object.getRentAmt() != null
												&& object.getRentAmt().equals(new Double(0))) {
											object.setDisSelect(false);
										} else {
											object.setDisSelect(true);
										}
									}
								}

								// Add 7/12/2012
								List<VerifyRentalSearchSiteRentCondSP> rentCondListTmp = new ArrayList<VerifyRentalSearchSiteRentCondSP>();
								for (VerifyRentalSearchSiteRentCondSP tmp : to) {
									if (StringUtils.equals(tmp.getRentCondType(), "01")) {
										rentCondListTmp.add(tmp);
									}
								}

								// --------------------------------------
								// semmrt001Bean.setRentCondList(to);
								semmrt001Bean.setRentCondList(rentCondListTmp);
								if (semmrt001Bean.getDisplayFrmRental().getRentCondType().equals("02")) {
									for (int i = 0; i < to.size(); i++) {
										VerifyRentalSearchSiteRentCondSP temp = (VerifyRentalSearchSiteRentCondSP) to
												.get(i);
										if (StringUtils.equals(temp.getRentCondType(), "02")) {
											if (temp.getExpenseType().equals("01")) {
												semmrt001Bean.setRentCondSpecial(temp);
											} else if (temp.getExpenseType().equals("02")) {
												semmrt001Bean.setServCondSpecial(temp);
											}
										}
									}
								}
								semmrt001Bean.setSpecialChk1(false);
								semmrt001Bean.setSpecialChk2(false);
								semmrt001Bean.setSpecialChk3(false);
								semmrt001Bean.setSpecialChk4(false);
								semmrt001Bean.setDisabledSpacialChk(true);
								addMessageInfo("M0001", "");

							} else {
								// fail
							}
						} else {
							// fail

						}

					} else {
						// show message fail save
						addMessageError("E0001", "");
					}
				} catch (Exception e) {
					e.printStackTrace();
					LOG.error(e);
					// show message fail save
					addMessageError("E0001", "");
				}
			}
			System.out.println("getSiteRentCondId 3 = " + semmrt001Bean.getRentDetail().getSiteRentCondId());
			setSemmrt001Bean(semmrt001Bean);
		} else {
			semmrt001Bean.setRenderedMsgFormMiddle(true);
		}

		return flag;
	}

	private boolean validateDpstDetail() {
		boolean vFlag = true;
		if (StringUtils.isEmpty(getSemmrt001Bean().getDpstDetail().getExpenseType())) {
			addMessageError("W0001", msg("message.expenseType2"));
			vFlag = false;
		}
		if (StringUtils.isEmpty(getSemmrt001Bean().getDpstDetail().getDepositType())) {
			addMessageError("W0001", msg("message.depositType"));
			vFlag = false;
		}
		if (getSemmrt001Bean().getDpstDetail().getDepositAmt() == null
				|| getSemmrt001Bean().getDpstDetail().getDepositAmt() == 0) {
			addMessageError("W0001", msg("message.depositAmt2"));
			vFlag = false;
		}

		if (getSemmrt001Bean().getDisplayFrmRental().getDepositCondType().equals("02")) {
			// special case
			Date periodStDt = getSemmrt001Bean().getDpstDetail().getPeriodStDt();
			Date periodEndDt = getSemmrt001Bean().getDpstDetail().getPeriodEndDt();

			if (periodStDt == null) {
				addMessageError("W0001", msg("message.periodStDt"));
				vFlag = false;
			}

			if (periodEndDt == null) {
				addMessageError("W0001", msg("message.periodEndDt"));
				vFlag = false;
			}

			if (periodStDt != null && periodEndDt != null) {
				if (periodStDt.after(periodEndDt)) {
					addMessageErrorWithArgument("W0006", msg("message.periodStDt"), msg("message.periodEndDt"));
					vFlag = false;
				} else {
					Mrt001CheckDate mrt001CheckDate = new Mrt001CheckDate();
					mrt001CheckDate.setExpenseType(getSemmrt001Bean().getDpstDetail().getExpenseType());
					mrt001CheckDate.setRentalMasterId(getSemmrt001Bean().getDisplayFrmRental().getRentalMasterId());
					mrt001CheckDate.setPeriodStartDt(periodStDt);
					mrt001CheckDate.setPeriodEndDt(periodEndDt);
					mrt001CheckDate.setVendorMasterId(getSemmrt001Bean().getDpstDetail().getVendorMasterId());
					mrt001CheckDate.setCurrentId(getSemmrt001Bean().getDpstDetail().getRowId());
					String result = validatePeriodDate(mrt001CheckDate);
					if (result == null || !result.equals("Success")) {
						addGeneralMessageError(result);
						vFlag = false;
					}
				}
			}
		}

		if (getSemmrt001Bean().getDpstDetail().getDepositType() != null
				&& getSemmrt001Bean().getDpstDetail().getDepositType().equals("02")
				&& getSemmrt001Bean().getDpstDetail().getExpenseType().equals("05")) {
			if (StringUtils.isEmpty(getSemmrt001Bean().getDpstDetail().getVatType())) {
				addMessageError("W0001", "VAT");
				vFlag = false;
			}
			if (getSemmrt001Bean().getDpstDetail().getVatAmt() == null) {
				addMessageError("W0001", msg("message.vatAmt"));
				vFlag = false;
			}
			if (getSemmrt001Bean().getDpstDetail().getDepositIncAmt() == null
					|| getSemmrt001Bean().getDpstDetail().getDepositIncAmt() == 0) {
				addMessageError("W0001", msg("message.incAmt"));
				vFlag = false;
			}
			if (StringUtils.isEmpty(getSemmrt001Bean().getDpstDetail().getVendorMasterId())) {
				addMessageError("W0001", msg("message.vendorId"));
				vFlag = false;
			}
		}

		if (getSemmrt001Bean().getDisplayFrmRental().getExpireDate() != null) {
			if (getSemmrt001Bean().getDpstDetail().getPeriodEndDt() == null) {
				addMessageError("W0001", msg("message.periodEndDt"));
				vFlag = false;
			}
		}

		return vFlag;
	}

	@SuppressWarnings("unchecked")
	private boolean doAddDpstDetail() {
		boolean flag = false;
		semmrt001Bean = getSemmrt001Bean();
		semmrt001Bean.setRenderedMsgFormSearch(false);
		semmrt001Bean.setRenderedMsgFormMiddle(false);
		if (validateDpstDetail()) {
			if (semmrt001Bean.getDpstDetail().getDepositType().equals("01")
					|| (semmrt001Bean.getDpstDetail().getDepositType().equals("01") && semmrt001Bean.getDpstDetail()
							.getExpenseType().equals("05"))) {
				// BG
				// semmrt001Bean.getDpstDetail().setVatType(null);
				// semmrt001Bean.getDpstDetail().setVatRate(null);
				semmrt001Bean.getDpstDetail().setVatAmt(null);
				semmrt001Bean.getDpstDetail().setDepositExcAmt(semmrt001Bean.getDpstDetail().getDepositAmt());
				semmrt001Bean.getDpstDetail().setDepositIncAmt(semmrt001Bean.getDpstDetail().getDepositAmt());
			}

			// Double whtAmt = 0.00;
			// if (semmrt001Bean.getRentDetail().getWhtRate()!=null){
			// if(semmrt001Bean.getDpstDetail().getDepositExcAmt()!=0.0 ||
			// semmrt001Bean.getDpstDetail().getDepositExcAmt() !=null ){
			// whtAmt =
			// (semmrt001Bean.getDpstDetail().getDepositExcAmt()*semmrt001Bean.getRentDetail().getWhtRate())/100;
			// }
			// }else{
			// whtAmt = 0.00;
			// }

			semmrt001Bean.getDpstDetail().setCompany(semmrt001Bean.getDisplayFrmRental().getCompany());
			semmrt001Bean.getDpstDetail().setRentalMasterId(semmrt001Bean.getDisplayFrmRental().getRentalMasterId());
			semmrt001Bean.getDpstDetail().setDepositCondType(semmrt001Bean.getDisplayFrmRental().getDepositCondType());
			semmrt001Bean.getDpstDetail().setDepositRentAmt(null);
			semmrt001Bean.getDpstDetail().setCurrentUser(getUserLogIn());
			semmrt001Bean.getDpstDetail().setRecordStatus("Y");

			List<DepositCondMapSi> oList = new ArrayList<DepositCondMapSi>();
			// if
			// (semmrt001Bean.getDpstDetail().getDepositCondType().equals("01"))
			// {
			if (!semmrt001Bean.isSelectedBGSpecial() && !semmrt001Bean.isSelectedCashSpecial()) {
				for (Mrt001SrchDpstCond temp : semmrt001Bean.getDpstCondList()) {
					if (temp.isSelected()) {
						DepositCondMapSi o = new DepositCondMapSi();
						o.setCompany(getSemmrt001Bean().getDisplayFrmRental().getCompany());
						o.setRentalMasterId(getSemmrt001Bean().getDisplayFrmRental().getRentalMasterId());
						o.setSiteDepositId(temp.getSiteDepositId());
						o.setDepositSetupAmt(0.0);
						o.setRecordStatus("Y");
						o.setCurrentUser(getUserLogIn());
						oList.add(o);
					}
				}
			} else {
				DepositCondMapSi o = new DepositCondMapSi();
				o.setCompany(getSemmrt001Bean().getDisplayFrmRental().getCompany());
				o.setRentalMasterId(getSemmrt001Bean().getDisplayFrmRental().getRentalMasterId());
				// 20101211
				// o.setSiteDepositId(semmrt001Bean.getDpstCondSpecial().getSiteDepositId());
				// if
				// (semmrt001Bean.getDpstDetail().getDepositType().equals("01"))
				// {
				if (semmrt001Bean.isSelectedBGSpecial()) {
					o.setSiteDepositId(semmrt001Bean.getDpstCondSpecialBG().getSiteDepositId());
					// } else if
					// (semmrt001Bean.getDpstDetail().getDepositType().equals("02"))
					// {
				} else if (semmrt001Bean.isSelectedCashSpecial()) {
					o.setSiteDepositId(semmrt001Bean.getDpstCondSpecial().getSiteDepositId());
				}

				o.setDepositSetupAmt(0.0);
				o.setRecordStatus("Y");
				o.setCurrentUser(getUserLogIn());
				oList.add(o);
			}

			IDepositDetailService service = (IDepositDetailService) getBean("depositDetailService");
			try {
				DepositDetail result = service.saveVerifyDepositSetup(semmrt001Bean.getDpstDetail(), oList,
						semmrt001Bean.getModeDpstDetail());
				if (result != null) {
					// Call Store Procedure 'MRT001_UPD_DPST_MAP'
					Mrt001UpdDpstMap mrt001UpdDpstMap = new Mrt001UpdDpstMap();
					mrt001UpdDpstMap.setRentalMasterId(result.getRentalMasterId());
					mrt001UpdDpstMap.setDepositDetailId(result.getRowId());
					mrt001UpdDpstMap.setDepositAmt(result.getDepositAmt());
					mrt001UpdDpstMap.setCurrentUser(getUserLogIn());

					List resultListMap = service.querySPList(EQueryName.SP_MRT001_UPD_DPST_MAP.name, mrt001UpdDpstMap);
					if (resultListMap != null && !resultListMap.isEmpty()) {
						// Call Store Procedure 'MRT001_UPD_DPST_PAY'
						Mrt001UpdDpstPay mrt001UpdDpstPay = new Mrt001UpdDpstPay();
						mrt001UpdDpstPay.setExpenseType(result.getExpenseType());
						mrt001UpdDpstPay.setDepositCondType(result.getDepositCondType());
						mrt001UpdDpstPay.setDepositDetailId(result.getRowId());
						mrt001UpdDpstPay.setMode(semmrt001Bean.getModeDpstDetail());
						mrt001UpdDpstPay.setCurrentUser(getUserLogIn());

						List resultListPay = service.querySPList(EQueryName.SP_MRT001_UPD_DPST_PAY.name,
								mrt001UpdDpstPay);
						if (resultListPay != null && !resultListPay.isEmpty()) {
							// Success for save rental deposit detail
							semmrt001Bean.setDpstDetail(new DepositDetail());
							semmrt001Bean.setModeDpstDetail("ADD");
							semmrt001Bean.setCountDataSelect(0);
							semmrt001Bean.setVendorList(getEmptyDropDown());
							semmrt001Bean.setPayeeList(getEmptyDropDown());
							semmrt001Bean.setSelectedBGSpecial(false);
							semmrt001Bean.setSelectedCashSpecial(false);

							Mrt001SrchDpstDetail mrt001SrchDpstDetail = new Mrt001SrchDpstDetail();
							mrt001SrchDpstDetail.setRentalMasterId(semmrt001Bean.getDisplayFrmRental()
									.getRentalMasterId());
							List<Mrt001SrchDpstDetail> toDpstDetail = getSPMrt001SrchDpstDetail(mrt001SrchDpstDetail);
							semmrt001Bean.setDpstDetailList(toDpstDetail);

							Mrt001SrchDpstCond mrt001SrchDpstCond = new Mrt001SrchDpstCond();
							mrt001SrchDpstCond.setSiteInfoId(semmrt001Bean.getDisplayFrmRental().getSiteInfoId());
							mrt001SrchDpstCond.setRentalMasterId(semmrt001Bean.getDisplayFrmRental()
									.getRentalMasterId());
							// search by call store procedure
							// sem_sp_mrt001_srch_dpst_cond
							List<Mrt001SrchDpstCond> toDeposit = getSPMrt001SrchDpstCond(mrt001SrchDpstCond);
							List<Mrt001SrchDpstCond> toDepositTmp = new ArrayList<Mrt001SrchDpstCond>();

							if (toDeposit != null) {
								for (Mrt001SrchDpstCond tmp : toDeposit) {
									if (StringUtils.equals(tmp.getDepositCondType(), "01")) {
										if (tmp.getCondBalanceAmt() != null && tmp.getCondBalanceAmt() > 0) {
											tmp.setDisSelect(false);
										} else {
											tmp.setDisSelect(true);
										}
										toDepositTmp.add(tmp);
									}
								}
							}
							//							
							semmrt001Bean.setDpstCondList(toDeposit);
							semmrt001Bean.setDpstCondList(toDepositTmp);
							clearDpstDetail();
							if (semmrt001Bean.getDisplayFrmRental().getDepositCondType().equals("02")) {
								for (int i = 0; i < toDeposit.size(); i++) {
									Mrt001SrchDpstCond temp = toDeposit.get(i);
									if (StringUtils.equals(temp.getDepositCondType(), "02")) {
										if (temp.getDepositType().equals("01")) {
											semmrt001Bean.setDpstCondSpecialBG(temp);
										} else if (temp.getDepositType().equals("02")) {
											semmrt001Bean.setDpstCondSpecial(temp);
										}
									}
								}

								if (semmrt001Bean.getDpstCondSpecialBG() != null
										&& semmrt001Bean.getDpstCondSpecial() != null) {
									semmrt001Bean.setDisChkSpecial(true);
								} else if (semmrt001Bean.getDpstCondSpecialBG() == null) {
									semmrt001Bean.setDisChkSpecial(false);
									semmrt001Bean.getDpstDetail().setDepositType(
											semmrt001Bean.getDpstCondSpecial().getDepositType());
									semmrt001Bean.getDpstDetail().setVatType(
											semmrt001Bean.getDpstCondSpecial().getVatType());
									semmrt001Bean.getDpstDetail().setPeriodStDt(
											semmrt001Bean.getDpstCondSpecial().getPeriodStDt());
									semmrt001Bean.getDpstDetail().setPeriodEndDt(
											semmrt001Bean.getDpstCondSpecial().getPeriodEndDt());
									doCalDate(semmrt001Bean.getDpstCondSpecial().getPeriodStDt(), semmrt001Bean
											.getDpstCondSpecial().getPeriodEndDt());
								} else if (semmrt001Bean.getDpstCondSpecial() == null) {
									semmrt001Bean.setDisChkSpecial(false);
									semmrt001Bean.getDpstDetail().setDepositType(
											semmrt001Bean.getDpstCondSpecialBG().getDepositType());
									semmrt001Bean.getDpstDetail().setPeriodStDt(
											semmrt001Bean.getDpstCondSpecialBG().getPeriodStDt());
									semmrt001Bean.getDpstDetail().setPeriodEndDt(
											semmrt001Bean.getDpstCondSpecialBG().getPeriodEndDt());
									doCalDate(semmrt001Bean.getDpstCondSpecialBG().getPeriodStDt(), semmrt001Bean
											.getDpstCondSpecialBG().getPeriodEndDt());
								}
							}
							addMessageInfo("M0001", "");
						} else {
							// fail store proc
							addMessageError("E0001", "");
						}
					} else {
						// fail store proc
						addMessageError("E0001", "");
					}

				} else {
					// show message fail save
					// addMessageError("incContent:frmAddDeposit:fieldDpstDetail",
					// "E0001", "");
					addMessageError("E0001", "");
				}

			} catch (Exception e) {
				e.printStackTrace();
				LOG.error(e);
				// show message fail save
				// addMessageError("incContent:frmAddDeposit:fieldDpstDetail",
				// "E0001", "");
				addMessageError("E0001", "");
			}
		} else {
			semmrt001Bean.setRenderedMsgFormMiddle(true);
		}
		setSemmrt001Bean(semmrt001Bean);
		return flag;
	}

	private boolean getRentalDetailById() {
		boolean flag = false;
		String rowId = (String) getFacesUtils().getRequestParameter("rowId");
		semmrt001Bean = getSemmrt001Bean();
		IRentalDetailService service = (IRentalDetailService) getBean("rentalDetailService");
		try {
			RentalDetail to = service.queryByRowId(rowId);
			if (to != null) {
				String mode = (String) getFacesUtils().getRequestParameter("mode");
				String amtPerYear = (String) getFacesUtils().getRequestParameter("amtPerYear");
				String amtPerMonth = (String) getFacesUtils().getRequestParameter("amtPerMonth");
				String amtOneTime = (String) getFacesUtils().getRequestParameter("amtOneTime");
				String cntVendor = (String) getFacesUtils().getRequestParameter("cntVendor");

				if (mode.equals("EDIT")) {
					semmrt001Bean.setRentDetail(to);
					semmrt001Bean.getRentDetail().setDefaultVat(to.getVatRate());
					semmrt001Bean.getRentDetail().setDefaultWht(to.getWhtRate());

					if (StringUtils.isEmpty(to.getVatType())) {
						semmrt001Bean.getRentDetail().setVatType("");
					}
					semmrt001Bean.setModeRentalDetail("EDIT");

					// VerifyRentalSearchSiteRentCondSP oSP = new
					// VerifyRentalSearchSiteRentCondSP();
					// oSP.setRentalMasterId(semmrt001Bean.getDisplayFrmRental().getRentalMasterId());
					// oSP.setSiteInfoId(semmrt001Bean.getDisplayFrmRental().getSiteInfoId());
					// LOG.debug("semmrt001Bean.getDisplayFrmRental().getRentalMasterId() = "+semmrt001Bean.getDisplayFrmRental().getRentalMasterId());
					// LOG.debug("semmrt001Bean.getDisplayFrmRental().getSiteInfoId() = "+semmrt001Bean.getDisplayFrmRental().getSiteInfoId());
					// List<VerifyRentalSearchSiteRentCondSP> verifyList =
					// getSPMrt001SrchRentCond(oSP);
					// semmrt001Bean.setTmpRentalDetail(setFirstRentCond(verifyList.get(0)));
					semmrt001Bean.getRentDetail().setAmtPerYear(SemUtils.parseDouble(amtPerYear));
					semmrt001Bean.getRentDetail().setAmtPerMonth(SemUtils.parseDouble(amtPerMonth));
					semmrt001Bean.getRentDetail().setAmtOneTime(SemUtils.parseDouble(amtOneTime));
					semmrt001Bean.getRentDetail().setCntVendor(SemUtils.parseInteger(cntVendor));
					callMrt001BalanceCal();

					if (semmrt001Bean.getRentDetail().getProrateFlag().equals("Y")) {
						semmrt001Bean.getRentDetail().setProrate(true);
					}
					if (semmrt001Bean.getRentDetail().getPayPeriodType().equals("03")) {
						semmrt001Bean.setPayPeriodMonth(semmrt001Bean.getRentDetail().getPayPeriod());
						semmrt001Bean.setPeriod3(semmrt001Bean.getRentDetail().getPayPeriodType());
						semmrt001Bean.setPeriod4(null);
						semmrt001Bean.setPeriod(null);
					} else if (semmrt001Bean.getRentDetail().getPayPeriodType().equals("04")) {
						semmrt001Bean.setPayPeriodYear(semmrt001Bean.getRentDetail().getPayPeriod());
						semmrt001Bean.setPeriod4(semmrt001Bean.getRentDetail().getPayPeriodType());
						semmrt001Bean.setPeriod3(null);
						semmrt001Bean.setPeriod(null);
					} else {
						semmrt001Bean.setPeriod(semmrt001Bean.getRentDetail().getPayPeriodType());
						semmrt001Bean.setPeriod3(null);
						semmrt001Bean.setPeriod4(null);
					}

					if (semmrt001Bean.getDisplayFrmRental().getRentCondType().equals("01")) {
						semmrt001Bean.setCheckMode("NORNAL");
						if (semmrt001Bean.getRentCondList() != null && !semmrt001Bean.getRentCondList().isEmpty()) {
							for (VerifyRentalSearchSiteRentCondSP o : semmrt001Bean.getRentCondList()) {
								o.setSelected(false);
							}
						}
					}

					if (StringUtils.equalsIgnoreCase("01", semmrt001Bean.getRentDetail().getRentalCondType())) {
						semmrt001Bean.setCheckMode("NORMAL");
					} else {
						semmrt001Bean.setCheckMode("SPECIAL");
					}

					// Get dropdown vendor
					Mrt001SrchVendor mrt001SrchVendor = new Mrt001SrchVendor();
					mrt001SrchVendor.setExpenseType(semmrt001Bean.getRentDetail().getExpenseType());
					mrt001SrchVendor.setContractNo(semmrt001Bean.getDisplayFrmRental().getContractNo());
					semmrt001Bean.setVendorList(getDropdownVendor(mrt001SrchVendor));
					if (StringUtils.isNotEmpty(semmrt001Bean.getRentDetail().getPayeeMasterId())) {
						Mrt001SrchPayee mrt001SrchPayee = new Mrt001SrchPayee();
						mrt001SrchPayee.setVendorMasterId(getSemmrt001Bean().getRentDetail().getVendorMasterId());
						mrt001SrchPayee.setContractNo(semmrt001Bean.getDisplayFrmRental().getContractNo());
						mrt001SrchPayee.setExpenseType(semmrt001Bean.getRentDetail().getExpenseType());
						semmrt001Bean.setPayeeList(getDropdownPayee(mrt001SrchPayee));
						// semmrt001Bean.getRentDetail().setBookBankNo(getPayeeBookbank(semmrt001Bean.getRentDetail().getPayeeMasterId()));
						semmrt001Bean.setMrt001BookBank(getPayeeBookBank(semmrt001Bean.getRentDetail()
								.getPayeeMasterId(), "PAYEE"));
					} else {
						// semmrt001Bean.getRentDetail().setBookBankNo(getVendorBookBank(semmrt001Bean.getRentDetail().getVendorMasterId()));
						semmrt001Bean.setMrt001BookBank(getVendorBookBank(semmrt001Bean.getRentDetail()
								.getVendorMasterId(), "VENDOR"));
					}

					viewByEditMode(semmrt001Bean.getRentDetailList().get(0).getRowId());
					// semmrt001Bean.serviceCalTypeIdToCal

					// Add 12-Sep-2018
					semmrt001Bean.setServiceCalTypeId(semmrt001Bean.getRentDetailList().get(0).getServiceId()); // name
					// service
					semmrt001Bean.setServiceCalTypeIdToCal(semmrt001Bean.getRentDetailList().get(0).getRentalCalCode());
					semmrt001Bean.setServiceCalTypeIdToCalName(semmrt001Bean.getRentDetailList().get(0)
							.getServiceCalType());

				} else {
					semmrt001Bean.setRentDetailDel(to);
				}
			}
			LOG.debug("Mode Page = " + semmrt001Bean.getModePage());
			LOG.debug("View Mode = " + semmrt001Bean.isViewMode());

		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e);
		}
		setSemmrt001Bean(semmrt001Bean);
		return flag;
	}

	private boolean getDpstDetailById() {
		boolean flag = false;

		String rowId = (String) getFacesUtils().getRequestParameter("rowId");
		String dpstVerifyAmt = (String) getFacesUtils().getRequestParameter("dpstVerifyAmt");
		semmrt001Bean = getSemmrt001Bean();
		IDepositDetailService service = (IDepositDetailService) getBean("depositDetailService");
		try {
			DepositDetail to = service.queryByRowId(rowId);
			if (to != null) {
				String mode = (String) getFacesUtils().getRequestParameter("mode");
				if (StringUtils.isEmpty(to.getVatType())) {
					to.setVatType("");
				}

				if (mode.equals("EDIT")) {
					semmrt001Bean.setDpstDetail(to);
					if (StringUtils.isNotEmpty(dpstVerifyAmt)) {
						semmrt001Bean.getDpstDetail().setDepositRentAmt(new Double(dpstVerifyAmt));
					}
					semmrt001Bean.setModeDpstDetail("EDIT");

					if (semmrt001Bean.getDisplayFrmRental().getDepositCondType().equals("01")) {
						for (Mrt001SrchDpstCond o : semmrt001Bean.getDpstCondList()) {
							o.setSelected(false);
						}
					}

					// Get dropdown vendor
					Mrt001SrchVendor mrt001SrchVendor = new Mrt001SrchVendor();
					mrt001SrchVendor.setExpenseType(semmrt001Bean.getDpstDetail().getExpenseType());
					mrt001SrchVendor.setContractNo(semmrt001Bean.getDisplayFrmRental().getContractNo());
					semmrt001Bean.setVendorList(getDropdownVendor(mrt001SrchVendor));

					// remove check normal
					semmrt001Bean.setSelectedBGSpecial(false);
					semmrt001Bean.setSelectedCashSpecial(false);
					for (Mrt001SrchDpstCond tmp : semmrt001Bean.getDpstCondList()) {
						tmp.setSelected(false);
					}

				} else {
					semmrt001Bean.setDpstDetailDel(to);
				}
				semmrt001Bean.setDisDepositDetail(true);
			}

		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e);
		}
		setSemmrt001Bean(semmrt001Bean);

		return flag;
	}

	private void clearRentalDetail() {
		semmrt001Bean.setRentDetail(new RentalDetail());
		// semmrt001Bean.getRentDetail().setEffectiveDt(new Date());
		semmrt001Bean.getRentDetail().setPayPeriodType("01");
		semmrt001Bean.getRentDetail().setWhtType("01");
		semmrt001Bean.getRentDetail().setVatType("01");
		semmrt001Bean.setDisWhtRate(false);
		// semmrt001Bean.setPageRentalSetupStatus("ADD");

		//
		semmrt001Bean.setServiceCalTypeId("ALL"); // name service
		semmrt001Bean.setServiceCalTypeIdToCal("01"); // type
		// semmrt001Bean.setServiceCalTypeIdCalName("vvvv");

		semmrt001Bean.setModeRentalDetail("ADD");
		semmrt001Bean.setCountDataSelect(0);
		semmrt001Bean.setVendorList(getEmptyDropDown());
		semmrt001Bean.setPayeeList(getEmptyDropDown());
		semmrt001Bean.setMrt001BookBank(new Mrt001BookBank());
		semmrt001Bean.setDisBtnAdd(false);
		semmrt001Bean.setPeriod("01");
		semmrt001Bean.setPeriod3(null);
		semmrt001Bean.setPeriod4(null);
		semmrt001Bean.setPayPeriodMonth(null);
		semmrt001Bean.setPayPeriodYear(null);
		if (semmrt001Bean.getDisplayFrmRental().getRentCondType().equals("01")) {
			if (semmrt001Bean.getRentCondList() != null && !semmrt001Bean.getRentCondList().isEmpty()) {
				for (VerifyRentalSearchSiteRentCondSP o : semmrt001Bean.getRentCondList()) {
					o.setSelected(false);
				}
			}
		} else {
			if (semmrt001Bean.getRentCondList() != null && !semmrt001Bean.getRentCondList().isEmpty()) {
				for (VerifyRentalSearchSiteRentCondSP o : semmrt001Bean.getRentCondList()) {
					o.setSelected(false);
				}
			}
			semmrt001Bean.getRentDetail().setVatRate(semmrt001Bean.getTmpVatRate());
			semmrt001Bean.setChkBtnAddSpecial(true);
			semmrt001Bean.setSpecialChk1(false);
			semmrt001Bean.setSpecialChk2(false);
			semmrt001Bean.setSpecialChk3(false);
			semmrt001Bean.setSpecialChk4(false);
			semmrt001Bean.setDisabledSpacialChk(true);
		}
	}

	private boolean doClearRentalDetail() {
		boolean flag = false;
		semmrt001Bean = getSemmrt001Bean();
		clearRentalDetail();
		setSemmrt001Bean(semmrt001Bean);
		return flag;
	}

	private void clearDpstDetail() {
		semmrt001Bean.setDpstDetail(new DepositDetail());
		semmrt001Bean.getDpstDetail().setVatType("01");
		semmrt001Bean.getDpstDetail().setVatRate(getVatRate());
		semmrt001Bean.getDpstDetail().setWhtRate(null);
		semmrt001Bean.setDisWhtRate(false);
		semmrt001Bean.setModeDpstDetail("ADD");
		semmrt001Bean.setCountDataSelect(0);
		semmrt001Bean.setVendorList(getEmptyDropDown());
		semmrt001Bean.setPayeeList(getEmptyDropDown());
		semmrt001Bean.setMrt001BookBank(new Mrt001BookBank());
		if (semmrt001Bean.getDisplayFrmRental().getDepositCondType().equals("01")) {
			for (Mrt001SrchDpstCond o : semmrt001Bean.getDpstCondList()) {
				o.setSelected(false);
			}
		} else {
			semmrt001Bean.setSelectedBGSpecial(false);
			semmrt001Bean.setSelectedCashSpecial(false);
		}
	}

	private boolean doClearDpstDetail() {
		boolean flag = false;
		semmrt001Bean = getSemmrt001Bean();
		clearDpstDetail();
		setSemmrt001Bean(semmrt001Bean);
		return flag;
	}

	@SuppressWarnings("unchecked")
	private boolean doDeleteRentalDetail() {
		boolean flag = false;
		semmrt001Bean = getSemmrt001Bean();
		semmrt001Bean.setRenderedMsgFormMiddle(true);
		semmrt001Bean.setRenderedMsgFormSearch(false);
		if (semmrt001Bean.getRentDetailDel() != null) {
			IRentalDetailService service = (IRentalDetailService) getBean("rentalDetailService");
			try {
				Mrt001UpdRentPay updRentPay = new Mrt001UpdRentPay();
				updRentPay.setExpenseType(semmrt001Bean.getRentDetailDel().getExpenseType());
				updRentPay.setRentCondType(semmrt001Bean.getRentDetailDel().getRentalCondType());
				updRentPay.setRentalDetailId(semmrt001Bean.getRentDetailDel().getRowId());
				updRentPay.setMode("DELETE");
				updRentPay.setCurrentUser(getUserLogIn());

				semmrt001Bean.getRentDetailDel().setCurrentUser(getUserLogIn());
				service.deleteRentalDetail(semmrt001Bean.getRentDetailDel());

				// Call store procedure 'SEM_SP_MRT001_UPD_RENT_PAY'
				List<Mrt001UpdRentPay> resultList = service.querySPList(EQueryName.SP_MRT001_UPD_RENT_PAY.name,
						updRentPay);
				if (resultList != null && !resultList.isEmpty()) {
					addMessageInfo("incContent:frmAddRental:fieldRentalDetail", "M0002", "");
					semmrt001Bean.setRentDetailDel(null);

					Mrt001SrchRentDetail rentDetailSP = new Mrt001SrchRentDetail();
					rentDetailSP.setRentalMasterId(semmrt001Bean.getDisplayFrmRental().getRentalMasterId());
					List toDetail = getSPMrt001SrchRentDetail(rentDetailSP);
					semmrt001Bean.setRentDetailList(toDetail);

					// Add 12-Sep-2018
					semmrt001Bean.setServiceCalTypeId("ALL"); // name service
					semmrt001Bean.setServiceCalTypeIdToCal("01"); // type
					// semmrt001Bean.setServiceCalTypeIdToCalName(semmrt001Bean.getRentDetailList().get(0).getServiceCalType());

					VerifyRentalSearchSiteRentCondSP oSP = new VerifyRentalSearchSiteRentCondSP();
					oSP.setRentalMasterId(semmrt001Bean.getDisplayFrmRental().getRentalMasterId());
					oSP.setSiteInfoId(semmrt001Bean.getDisplayFrmRental().getSiteInfoId());
					List<VerifyRentalSearchSiteRentCondSP> to = getSPMrt001SrchRentCond(oSP);

					List<VerifyRentalSearchSiteRentCondSP> rentCondListTmp = new ArrayList<VerifyRentalSearchSiteRentCondSP>();
					for (VerifyRentalSearchSiteRentCondSP tmp : to) {
						if (StringUtils.equals(tmp.getRentCondType(), "01")) {
							if (tmp.getBalanceAmt() != null && tmp.getBalanceAmt().equals(new Double(0))) {
								tmp.setDisSelect(true);
							}
							rentCondListTmp.add(tmp);
						}
					}

					// semmrt001Bean.setRentCondList(to);
					semmrt001Bean.setRentCondList(rentCondListTmp);

					if (semmrt001Bean.getDisplayFrmRental().getRentCondType().equals("02")) {
						for (int i = 0; i < to.size(); i++) {
							VerifyRentalSearchSiteRentCondSP temp = (VerifyRentalSearchSiteRentCondSP) to.get(i);
							if (StringUtils.equals(temp.getRentCondType(), "02")) {
								if (temp.getExpenseType().equals("01")) {
									semmrt001Bean.setRentCondSpecial(temp);
								} else if (temp.getExpenseType().equals("02")) {
									semmrt001Bean.setServCondSpecial(temp);
								}
								// } else if
								// (temp.getExpenseType().equals("03")) {
								// semmrt001Bean.setDonateCondSpecial(temp);
								// }
							}
						}
					}

				}

				clearRentalDetail();
			} catch (Exception e) {
				e.printStackTrace();
				LOG.error(e);
				addMessageError("incContent:frmAddRental:fieldRentalDetail", "E0002", "");
			}
		}
		setSemmrt001Bean(semmrt001Bean);
		return flag;
	}

	@SuppressWarnings("unchecked")
	private boolean doDeleteDpstDetail() {
		boolean flag = false;

		semmrt001Bean = getSemmrt001Bean();
		semmrt001Bean.setRenderedMsgFormMiddle(true);
		semmrt001Bean.setRenderedMsgFormSearch(false);
		if (semmrt001Bean.getDpstDetailDel() != null) {
			IDepositDetailService service = (IDepositDetailService) getBean("depositDetailService");
			try {
				Mrt001UpdDpstPay mrt001UpdDpstPay = new Mrt001UpdDpstPay();
				// mrt001UpdDpstPay.setDepositDetailId(semmrt001Bean.getDpstDetail().getRowId());
				mrt001UpdDpstPay.setDepositDetailId(semmrt001Bean.getDpstDetailDel().getRowId());
				mrt001UpdDpstPay.setExpenseType(semmrt001Bean.getDpstDetailDel().getExpenseType());
				mrt001UpdDpstPay.setDepositCondType(semmrt001Bean.getDpstDetailDel().getDepositCondType());
				mrt001UpdDpstPay.setMode("DELETE");
				mrt001UpdDpstPay.setCurrentUser(getUserLogIn());

				semmrt001Bean.getDpstDetailDel().setCurrentUser(getUserLogIn());
				service.deleteVerifyDepositSetup(semmrt001Bean.getDpstDetailDel());

				// Call store procedure 'SEM_SP_MRT001_UPD_DPST_PAY'
				List resultListPay = service.querySPList(EQueryName.SP_MRT001_UPD_DPST_PAY.name, mrt001UpdDpstPay);
				if (resultListPay != null && !resultListPay.isEmpty()) {
					// addMessageInfo("incContent:frmAddDeposit:fieldDpstDetail",
					// "M0002", "");
					addMessageInfo("M0002", "");
					semmrt001Bean.setRentDetailDel(null);

					Mrt001SrchDpstCond mrt001SrchDpstCond = new Mrt001SrchDpstCond();
					mrt001SrchDpstCond.setSiteInfoId(semmrt001Bean.getDisplayFrmRental().getSiteInfoId());
					mrt001SrchDpstCond.setRentalMasterId(semmrt001Bean.getDisplayFrmRental().getRentalMasterId());
					// Search by call store procedure
					// sem_sp_mrt001_srch_dpst_cond
					List<Mrt001SrchDpstCond> toDeposit = getSPMrt001SrchDpstCond(mrt001SrchDpstCond);
					semmrt001Bean.setDpstCondList(toDeposit);

					Mrt001SrchDpstDetail mrt001SrchDpstDetail = new Mrt001SrchDpstDetail();
					mrt001SrchDpstDetail.setRentalMasterId(semmrt001Bean.getDisplayFrmRental().getRentalMasterId());
					List<Mrt001SrchDpstDetail> toDpstDetail = getSPMrt001SrchDpstDetail(mrt001SrchDpstDetail);
					semmrt001Bean.setDpstDetailList(toDpstDetail);

					initPageDeposit();
				}
			} catch (Exception e) {
				e.printStackTrace();
				LOG.error(e);
				addMessageError("incContent:frmAddDeposit:fieldDpstDetail", "E0002", "");
			}
		}
		setSemmrt001Bean(semmrt001Bean);

		return flag;
	}

	public void getRowIdOnClick() {
		String rowId = (String) getFacesUtils().getRequestParameter("rowId");
		getSemmrt001Bean().setTmpRowId(rowId);
	}

	public void selectRow() {
		semmrt001Bean = getSemmrt001Bean();
		try {
			if (semmrt001Bean.getResultList() != null && semmrt001Bean.getResultList().size() > 0) {
				for (WrapperBeanObject<VerifyRentalSearchSiteInfoSP> to : semmrt001Bean.getResultList()) {
					if (to.isCheckBox()) {
						semmrt001Bean.setRenderedBtnExport(true);
						break;
					} else {
						semmrt001Bean.setRenderedBtnExport(false);
					}
				}
				setSemmrt001Bean(semmrt001Bean);
			}
		} catch (Exception e) {
			LOG.debug(e);
			e.printStackTrace();
		}
	}

	public void selectAllRow() {
		semmrt001Bean = getSemmrt001Bean();
		try {
			if (semmrt001Bean.getResultList() != null && !(semmrt001Bean.getResultList()).isEmpty()) {
				int index = 0;
				for (WrapperBeanObject<VerifyRentalSearchSiteInfoSP> to : semmrt001Bean.getResultList()) {
					VerifyRentalSearchSiteInfoSP vo = (VerifyRentalSearchSiteInfoSP) to.getDataObj();
					// if (StringUtils.isEmpty(vo.getVendorCode()) &&
					// StringUtils.isNotEmpty(vo.getVendorMasterId())) {
					if (StringUtils.isNotEmpty(vo.getVendorMasterId())) {
						if (semmrt001Bean.isChkSelAll()) {
							to.setCheckBox(Boolean.TRUE);
							semmrt001Bean.setRenderedBtnExport(true);
						} else {
							to.setCheckBox(Boolean.FALSE);
							semmrt001Bean.setRenderedBtnExport(false);
						}
						semmrt001Bean.getResultList().set(index, to);
					}
					// else{
					// to.setCheckBox(Boolean.FALSE);
					// }
					// semmrt001Bean.getResultList().set(index, to);
					index++;
				}
				setSemmrt001Bean(semmrt001Bean);
			}
		} catch (NullPointerException ne) {
			LOG.debug(ne);
			ne.printStackTrace();
		} catch (Exception e) {
			LOG.debug(e);
			e.printStackTrace();
		}
	}

	public void checkValueWhtRate() {
		semmrt001Bean = getSemmrt001Bean();
		if (semmrt001Bean.isDisWhtRate()) {
			// Selected
			semmrt001Bean.setTmpWhtRate(semmrt001Bean.getRentDetail().getWhtRate());
		} else {
			// UnSelected
			String type = semmrt001Bean.getRentDetail().getWhtType();
			if (!StringUtils.equalsIgnoreCase(type, "03")) {
				semmrt001Bean.getRentDetail().setWhtRate(semmrt001Bean.getRentDetail().getDefaultWht());
			} else {
				semmrt001Bean.getRentDetail().setWhtRate(new Double(0));
			}
		}
		setSemmrt001Bean(semmrt001Bean);
	}

	public void calculateVat() {
		semmrt001Bean = getSemmrt001Bean();
		try {
			Double depositAmt = semmrt001Bean.getDpstDetail().getDepositAmt();
			if (semmrt001Bean.getModePage().equals("NORMAL")) {
				Double verifyAmt = semmrt001Bean.getDpstDetail().getDepositRentAmt();
				if (verifyAmt.doubleValue() < depositAmt.doubleValue()) {
					// Display error and not clear value 'periodAmt'
					addMessageError("incContent:frmAddDeposit:fieldDpstDetail", "W0034", "");
				}
				semmrt001Bean.getDpstDetail().setDepositRentAmt(semmrt001Bean.getDpstDetail().getDepositAmt());
			}
			if (semmrt001Bean.getDpstDetail().getDepositType().equals("02")) {
				if (semmrt001Bean.getDpstDetail().getVatRate() == null) {
					semmrt001Bean.getDpstDetail().setVatRate(getVatRate());
				}
				Double vatRate = semmrt001Bean.getDpstDetail().getVatRate();

				Double excAmt = 0.0;
				if (StringUtils.isNotEmpty(semmrt001Bean.getDpstDetail().getVatType())
						&& semmrt001Bean.getDpstDetail().getVatType().equals("01")) {
					excAmt = depositAmt / (1 + (vatRate / 100));
				} else {
					excAmt = depositAmt;
				}
				String vatType = semmrt001Bean.getDpstDetail().getVatType();
				boolean condVatType = (StringUtils.isEmpty(vatType)) ? true : (vatType.equals("03")) ? true : false;
				Double vatAmt = (condVatType) ? 0 : excAmt * (vatRate / 100);
				Double incAmt = excAmt + vatAmt;

				semmrt001Bean.getDpstDetail().setVatAmt(vatAmt);
				semmrt001Bean.getDpstDetail().setDepositIncAmt(incAmt);
				semmrt001Bean.getDpstDetail().setDepositExcAmt(excAmt);

			}
		} catch (Exception e) {
			semmrt001Bean.getDpstDetail().setDepositAmt(null);
		}
		setSemmrt001Bean(semmrt001Bean);
	}

	public void checkRentalAmt() {
		semmrt001Bean = getSemmrt001Bean();
		try {
			// Summary amt
			Double rentalAmt = semmrt001Bean.getRentDetail().getRentalAmt();
			// Input amt from user
			Double periodAmt = semmrt001Bean.getRentDetail().getPeriodAmt();
			if (periodAmt.doubleValue() > semmrt001Bean.getRentDetail().getTmpBalanceAmt().doubleValue()) {
				// if (rentalAmt.doubleValue() < periodAmt.doubleValue()) {
				// Display error and not clear value 'periodAmt'
				addMessageError("incContent:frmAddRental:fieldRentalDetail", "W0034", "");
				// addMessageError("W0034", "");
				semmrt001Bean.setDisBtnAdd(true);
			} else {
				// Semmrt001Bean.setBalanceAmt(rentalAmt - periodAmt);
				semmrt001Bean.getRentDetail().setBalanceAmt(
						semmrt001Bean.getRentDetail().getTmpBalanceAmt() - periodAmt);
				semmrt001Bean.setDisBtnAdd(false);
			}
		} catch (Exception e) {
			semmrt001Bean.getRentDetail().setPeriodAmt(null);
		}
		setSemmrt001Bean(semmrt001Bean);
	}

	@SuppressWarnings("unchecked")
	private boolean calDateSpecial(Date periodStDt, Date periodEndDt) {
		boolean flag = false;
		if (periodStDt != null && periodEndDt != null) {
			if (periodStDt.after(periodEndDt)) {
				addMessageErrorWithArgument("W0006", msg("message.periodStDt"), msg("message.periodEndDt"));
				semmrt001Bean.setRenderedMsgFormSearch(false);
			}

			Msi004CalcAgeSP msi004CalcAgeSP = new Msi004CalcAgeSP();
			msi004CalcAgeSP.setEffDate(periodStDt);
			msi004CalcAgeSP.setExpDate(periodEndDt);
			try {
				IRentalDetailService service = (IRentalDetailService) getBean("rentalDetailService");
				List to = service.querySPList(EQueryName.SP_MSI004_CALC_AGE.name, msi004CalcAgeSP);
				if (to != null && !to.isEmpty()) {
					Msi004CalcAgeSP temp = (Msi004CalcAgeSP) to.get(0);
					semmrt001Bean.getRentDetail().setPeriodDay(temp.getAgeDay());
					semmrt001Bean.getRentDetail().setPeriodMonth(temp.getAgeMonth());
					semmrt001Bean.getRentDetail().setPeriodYear(temp.getAgeYear());
					flag = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
				LOG.error(e);
			}
		}
		return flag;
	}

	private boolean doDefaultDate() {
		boolean flag = false;
		semmrt001Bean = getSemmrt001Bean();
		Date periodStDt = getSemmrt001Bean().getRentDetail().getPeriodStartDt();
		Date periodEndDt = getSemmrt001Bean().getRentDetail().getPeriodEndDt();

		if (periodStDt != null)
			if (periodEndDt == null)
				return defaultPeriodStartEndDt(periodStDt);

		if (periodEndDt != null)
			if (periodStDt == null)
				return defaultPeriodStartEndDt(periodEndDt);

		calDateSpecial(periodStDt, periodEndDt);
		setSemmrt001Bean(semmrt001Bean);
		return flag;
	}

	private boolean defaultPeriodStartEndDt(Date selDt) {
		boolean flag = false;
		semmrt001Bean.getRentDetail().setPeriodStartDt(selDt);
		semmrt001Bean.getRentDetail().setPeriodEndDt(selDt);
		return flag;
	}

	@SuppressWarnings("unchecked")
	private void doCalDate(Date periodStDt, Date periodEndDt) {
		Msi004CalcAgeSP msi004CalcAgeSP = new Msi004CalcAgeSP();
		msi004CalcAgeSP.setEffDate(periodStDt);
		msi004CalcAgeSP.setExpDate(periodEndDt);
		try {
			IRentalDetailService service = (IRentalDetailService) getBean("rentalDetailService");
			List to = service.querySPList(EQueryName.SP_MSI004_CALC_AGE.name, msi004CalcAgeSP);
			if (to != null && !to.isEmpty()) {
				Msi004CalcAgeSP temp = (Msi004CalcAgeSP) to.get(0);
				semmrt001Bean.getDpstDetail().setPeriodDay(new Double(temp.getAgeDay()));
				semmrt001Bean.getDpstDetail().setPeriodMonth(new Double(temp.getAgeMonth()));
				semmrt001Bean.getDpstDetail().setPeriodYear(new Double(temp.getAgeYear()));
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e);
		}
	}

	private boolean doDefaultDateDpst() {
		boolean flag = false;
		semmrt001Bean = getSemmrt001Bean();
		Date periodStDt = getSemmrt001Bean().getDpstDetail().getPeriodStDt();
		Date periodEndDt = getSemmrt001Bean().getDpstDetail().getPeriodEndDt();

		if (periodStDt != null && periodEndDt != null) {
			if (periodStDt.after(periodEndDt)) {
				addMessageErrorWithArgument("W0006", msg("message.periodStDt"), msg("message.periodEndDt"));
				semmrt001Bean.setRenderedMsgFormSearch(false);
				semmrt001Bean.setRenderedMsgFormMiddle(true);
				semmrt001Bean.getDpstDetail().setPeriodDay(0.0);
				semmrt001Bean.getDpstDetail().setPeriodMonth(0.0);
				semmrt001Bean.getDpstDetail().setPeriodYear(0.0);
			} else {
				doCalDate(periodStDt, periodEndDt);
			}
		}
		setSemmrt001Bean(semmrt001Bean);
		return flag;
	}

	// private boolean defaultPeriodStartEndDtDpst(Date selDt){
	// boolean flag = false;
	// semmrt001Bean.getRentDetail().setPeriodStartDt(selDt);
	// semmrt001Bean.getRentDetail().setPeriodEndDt(selDt);
	// return flag;
	// }

	public void onClickChkBoxSpecial() {
		semmrt001Bean = getSemmrt001Bean();
		String type = (String) getFacesUtils().getRequestParameter("type");
		if (type.equals("BG")) {
			semmrt001Bean.setSelectedCashSpecial(false);
			semmrt001Bean.getDpstDetail().setDepositType(semmrt001Bean.getDpstCondSpecialBG().getDepositType());
			semmrt001Bean.getDpstDetail().setPeriodStDt(semmrt001Bean.getDpstCondSpecialBG().getPeriodStDt());
			semmrt001Bean.getDpstDetail().setPeriodEndDt(semmrt001Bean.getDpstCondSpecialBG().getPeriodEndDt());
		} else if (type.equals("CASH")) {
			semmrt001Bean.setSelectedBGSpecial(false);
			semmrt001Bean.getDpstDetail().setDepositType(semmrt001Bean.getDpstCondSpecial().getDepositType());
			semmrt001Bean.getDpstDetail().setVatType(semmrt001Bean.getDpstCondSpecial().getVatType());
			semmrt001Bean.getDpstDetail().setPeriodStDt(semmrt001Bean.getDpstCondSpecial().getPeriodStDt());
			semmrt001Bean.getDpstDetail().setPeriodEndDt(semmrt001Bean.getDpstCondSpecial().getPeriodEndDt());
		}

		if (semmrt001Bean.isSelectedBGSpecial() || semmrt001Bean.isSelectedCashSpecial()) {
			// Get dropdown vendor
			Mrt001SrchVendor mrt001SrchVendor = new Mrt001SrchVendor();
			mrt001SrchVendor.setExpenseType(semmrt001Bean.getDpstDetail().getExpenseType());
			mrt001SrchVendor.setContractNo(semmrt001Bean.getDisplayFrmRental().getContractNo());
			semmrt001Bean.setVendorList(getDropdownVendor(mrt001SrchVendor));
		}

		// remove check normal
		if (semmrt001Bean.isSelectedBGSpecial() || semmrt001Bean.isSelectedCashSpecial()) {
			for (Mrt001SrchDpstCond tmp : semmrt001Bean.getDpstCondList()) {
				tmp.setSelected(false);
			}
		}

		semmrt001Bean.getDpstDetail().setDepositAmt(null);

		setSemmrt001Bean(semmrt001Bean);
		doDefaultDateDpst();
	}

	private boolean validateCalRent() {
		boolean validFlag = true;
		semmrt001Bean = getSemmrt001Bean();
		String expenseType = getSemmrt001Bean().getRentDetail().getExpenseType();
		Double rentAmt = getSemmrt001Bean().getRentDetail().getRentalAmt();
		String rentPeriodType = getSemmrt001Bean().getRentDetail().getRentPeriodType();
		Date periodStDt = getSemmrt001Bean().getRentDetail().getPeriodStartDt();
		Date periodEndDt = getSemmrt001Bean().getRentDetail().getPeriodEndDt();

		if (StringUtils.isEmpty(expenseType)) {
			addMessageError("W0001", msg("message.expenseType2"));
			validFlag = false;
		}

		if (null == rentAmt || rentAmt.equals(new Double(0))) {
			addMessageError("W0001", msg("message.totalAmt"));
			validFlag = false;
		}
		if (StringUtils.isEmpty(rentPeriodType)) {
			addMessageError("W0001", msg("message.rentPeriodType"));
			validFlag = false;
		}

		if (periodStDt == null) {
			addMessageError("W0001", msg("message.periodStDt"));
			validFlag = false;
		}

		if (semmrt001Bean.isRequireFlag()) {
			if (periodEndDt == null) {
				addMessageError("W0001", msg("message.periodEndDt"));
				validFlag = false;
			}
		}

		if (periodStDt != null && periodEndDt != null) {
			if (periodStDt.after(periodEndDt)) {
				addMessageErrorWithArgument("W0006", msg("message.periodStDt"), msg("message.periodEndDt"));
				validFlag = false;
			}
		}

		return validFlag;
	}

	@SuppressWarnings("unchecked")
	private boolean doCalculate() {
		boolean flag = false;
		semmrt001Bean = getSemmrt001Bean();
		System.out.println("period " + semmrt001Bean.getRentDetail().getPeriodAmt());
		System.out.println("getSiteRentCondId 6 = " + semmrt001Bean.getRentDetail().getSiteRentCondId());
		if (validateCalRent()) {
			Date periodStDt = getSemmrt001Bean().getRentDetail().getPeriodStartDt();
			Date periodEndDt = getSemmrt001Bean().getRentDetail().getPeriodEndDt();

			if (calDateSpecial(periodStDt, periodEndDt)) {
				Mrt001RentCal mrt001RentCal = new Mrt001RentCal();
				mrt001RentCal.setRentalAmt(semmrt001Bean.getRentDetail().getRentalAmt());
				mrt001RentCal.setRentPeriodType(semmrt001Bean.getRentDetail().getRentPeriodType());
				mrt001RentCal.setPayPeriodType(semmrt001Bean.getRentDetail().getPayPeriodType());
				// check data pay period
				if (semmrt001Bean.getRentDetail().getPayPeriodType().equals("03")) {
					mrt001RentCal.setPayPeriod(semmrt001Bean.getPayPeriodMonth());
				} else if (semmrt001Bean.getRentDetail().getPayPeriodType().equals("04")) {
					mrt001RentCal.setPayPeriod(semmrt001Bean.getPayPeriodYear());
				} else {
					mrt001RentCal.setPayPeriod(null);
				}
				mrt001RentCal.setPeriodYear(semmrt001Bean.getRentDetail().getPeriodYear());
				mrt001RentCal.setPeriodMonth(semmrt001Bean.getRentDetail().getPeriodMonth());
				mrt001RentCal.setPeriodDay(semmrt001Bean.getRentDetail().getPeriodDay());
				System.out.println("getSiteRentCondId 7 = " + semmrt001Bean.getRentDetail().getSiteRentCondId());

				IRentalDetailService service = (IRentalDetailService) getBean("rentalDetailService");
				try {
					List<Mrt001RentCal> list = service.querySPList(EQueryName.SP_MRT001_RENT_CAL.name, mrt001RentCal);
					if (list != null && !list.isEmpty()) {
						Mrt001RentCal temp = list.get(0);
						semmrt001Bean.getRentDetail().setTotPeriodNo(temp.getTotPeriodNo());
						if (semmrt001Bean.getRentDetail().getPeriodAmt() == null
								|| semmrt001Bean.getRentDetail().getPeriodAmt() == 0.0) {
							if (semmrt001Bean.getRentDetail().getPayPeriodType().equals("01")) {
								semmrt001Bean.getRentDetail().setPeriodAmt(
										semmrt001Bean.getRentDetail().getAmtPerMonth());
							} else if (semmrt001Bean.getRentDetail().getPayPeriodType().equals("02")) {
								semmrt001Bean.getRentDetail().setPeriodAmt(
										semmrt001Bean.getRentDetail().getAmtPerYear());
							} else {
								semmrt001Bean.getRentDetail()
										.setPeriodAmt(semmrt001Bean.getRentDetail().getRentalAmt());
							}
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
					LOG.error(e);
				}

			}
			// if(StringUtils.equalsIgnoreCase("NORMAL",
			// semmrt001Bean.getCheckMode())){
			callMrt001BalanceCal();
			// }

		} else {
			semmrt001Bean.setRenderedMsgFormSearch(false);
			semmrt001Bean.setRenderedMsgFormMiddle(true);
		}
		setSemmrt001Bean(semmrt001Bean);

		return flag;
	}

	public void doExportExcel() {
		LOG.info("doExportExcel");

		try {

			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet();
			HSSFRow row = null;

			createHeader(wb, sheet, row);
			createData(wb, sheet, row);
			setCellSize(sheet);

			HttpServletResponse res = FacesUtils.getInstance().getHttpResponse();

			res.setContentType("application/vnd.ms-excel");
			res.setHeader("Content-disposition", "attachment;filename=VERIFY_RENTAL_"
					+ SEMDataUtility.getCurrentDateDefaultForFileName() + ".xls");

			ServletOutputStream out = res.getOutputStream();

			wb.write(out);
			out.flush();
			out.close();

			FacesContext faces = FacesContext.getCurrentInstance();
			faces.responseComplete();

			// doSearch();
		} catch (Exception e) {

		}
	}

	private void createHeader(HSSFWorkbook wb, HSSFSheet sheet, HSSFRow row) {
		short line = 0;
		row = sheet.createRow(line);
		// get cell style from configure.
		Map<String, HSSFCellStyle> styles = createStyles(wb);

		setExcelStyle(styles.get("header"), row, (short) 0, "Action");
		setExcelStyle(styles.get("header"), row, (short) 1, "Reason Mod");
		setExcelStyle(styles.get("header"), row, (short) 2, "Company Code");
		setExcelStyle(styles.get("header"), row, (short) 3, "Copy Company Code");
		setExcelStyle(styles.get("header"), row, (short) 4, "Account Group");
		setExcelStyle(styles.get("header"), row, (short) 5, "SAP Vendor Account Number");
		setExcelStyle(styles.get("header"), row, (short) 6, "Name1");
		setExcelStyle(styles.get("header"), row, (short) 7, "Name2");
		setExcelStyle(styles.get("header"), row, (short) 8, "Name3");
		setExcelStyle(styles.get("header"), row, (short) 9, "Name4");
		setExcelStyle(styles.get("header"), row, (short) 10, "Street");

		setExcelStyle(styles.get("header"), row, (short) 11, "District");
		setExcelStyle(styles.get("header"), row, (short) 12, "City");
		setExcelStyle(styles.get("header"), row, (short) 13, "Postal Code");
		setExcelStyle(styles.get("header"), row, (short) 14, "Country");
		setExcelStyle(styles.get("header"), row, (short) 15, "Search Term");
		setExcelStyle(styles.get("header"), row, (short) 16, "Tel1");
		setExcelStyle(styles.get("header"), row, (short) 17, "Tel2");
		setExcelStyle(styles.get("header"), row, (short) 18, "Mobile Phone");
		setExcelStyle(styles.get("header"), row, (short) 19, "Fax");
		setExcelStyle(styles.get("header"), row, (short) 20, "Email");

		setExcelStyle(styles.get("header"), row, (short) 21, "Data Communication Line No.");
		setExcelStyle(styles.get("header"), row, (short) 22, "Telebox number");
		setExcelStyle(styles.get("header"), row, (short) 23, "Comment");
		setExcelStyle(styles.get("header"), row, (short) 24, "Trading partner");
		setExcelStyle(styles.get("header"), row, (short) 25, "Customer code");
		setExcelStyle(styles.get("header"), row, (short) 26, "Personnel ID");
		setExcelStyle(styles.get("header"), row, (short) 27, "Tax ID");
		setExcelStyle(styles.get("header"), row, (short) 28, "TAX13");
		setExcelStyle(styles.get("header"), row, (short) 29, "Industry Key");
		setExcelStyle(styles.get("header"), row, (short) 30, "Purchasing Org.");
		setExcelStyle(styles.get("header"), row, (short) 31, "Copy Purchasing Org.");

		setExcelStyle(styles.get("header"), row, (short) 32, "Order currency");
		setExcelStyle(styles.get("header"), row, (short) 33, "Payment Term");
		setExcelStyle(styles.get("header"), row, (short) 34, "Goods receipt before Invoice(SSA)");
		setExcelStyle(styles.get("header"), row, (short) 35, "Recon. Acct.");
		setExcelStyle(styles.get("header"), row, (short) 36, "Previous Account");
		setExcelStyle(styles.get("header"), row, (short) 37, "Payment Term");
		setExcelStyle(styles.get("header"), row, (short) 38, "Payment Method");
		setExcelStyle(styles.get("header"), row, (short) 39, "Payment Block");
		setExcelStyle(styles.get("header"), row, (short) 40, "Accounting clerk");
		setExcelStyle(styles.get("header"), row, (short) 41, "Withholding Tax Type");
		setExcelStyle(styles.get("header"), row, (short) 42, "Withholding Code");

		setExcelStyle(styles.get("header"), row, (short) 43, "Recipient Type");
		setExcelStyle(styles.get("header"), row, (short) 44, "Withholding Tax type2");
		setExcelStyle(styles.get("header"), row, (short) 45, "Withholding  Code2");
		setExcelStyle(styles.get("header"), row, (short) 46, "Recipient Type2");
		setExcelStyle(styles.get("header"), row, (short) 47, "Withholding Tax Type3");
		setExcelStyle(styles.get("header"), row, (short) 48, "Withholding  Code3");
		setExcelStyle(styles.get("header"), row, (short) 49, "Recipient Type3");
		setExcelStyle(styles.get("header"), row, (short) 50, "Bank Key");
		setExcelStyle(styles.get("header"), row, (short) 51, "Name of Bank");
		setExcelStyle(styles.get("header"), row, (short) 52, "Bank Account");

		setExcelStyle(styles.get("header"), row, (short) 53, "Account Hoder");
		setExcelStyle(styles.get("header"), row, (short) 54, "Partner Bank Type");
		setExcelStyle(styles.get("header"), row, (short) 55, "Alternative Payee");
	}

	private List<CT001Export> queryCT001Export(String vendorMasterId) throws Exception {
		IVendorMasterService service = (IVendorMasterService) getBean("vendorMasterService");
		return service.queryCT001ForExport(vendorMasterId);
	}

	private void createData(HSSFWorkbook wb, HSSFSheet sheet, HSSFRow row) {

		// get cell style from configure.
		Map<String, HSSFCellStyle> styles = createStyles(wb);
		StringBuffer sb = new StringBuffer();
		semmrt001Bean = getSemmrt001Bean();
		short line = 0;
		try {
			if (semmrt001Bean.getResultList() != null && !(semmrt001Bean.getResultList()).isEmpty()) {
				for (WrapperBeanObject<VerifyRentalSearchSiteInfoSP> to : semmrt001Bean.getResultList()) {
					if (to.isCheckBox()) {
						VerifyRentalSearchSiteInfoSP o = (VerifyRentalSearchSiteInfoSP) to.getDataObj();
						sb.append(",");
						sb.append(o.getVendorMasterId());
					}
				}
			}

			List<CT001Export> l = queryCT001Export(sb.toString());
			if (l != null && l.size() > 0) {
				for (CT001Export o : l) {

					String action = StringUtils.isNotBlank(o.getAction()) ? o.getAction() : "";
					String reasonMod = StringUtils.isNotBlank(o.getReasonMod()) ? o.getReasonMod() : "";
					String company = StringUtils.isNotBlank(o.getCompany()) ? o.getCompany() : "";
					String accGroup = StringUtils.isNotBlank(o.getAccGroup()) ? o.getAccGroup() : "";
					String vendorCode = StringUtils.isNotBlank(o.getVendorCode()) ? o.getVendorCode() : "";
					String name1 = StringUtils.isNotBlank(o.getName1()) ? o.getName1() : "";
					String name2 = StringUtils.isNotBlank(o.getName2()) ? o.getName2() : "";
					String name3 = StringUtils.isNotBlank(o.getName3()) ? o.getName3() : "";
					String name4 = StringUtils.isNotBlank(o.getName4()) ? o.getName4() : "";
					String street = StringUtils.isNotBlank(o.getStreet()) ? o.getStreet() : "";

					row = sheet.createRow(++line);

					setExcelStyle(styles.get("cell_default"), row, (short) 0, action);
					setExcelStyle(styles.get("cell_default"), row, (short) 1, reasonMod);
					setExcelStyle(styles.get("cell_default"), row, (short) 2, company);
					setExcelStyle(styles.get("cell_default"), row, (short) 3, "");
					setExcelStyle(styles.get("cell_default"), row, (short) 4, accGroup);
					setExcelStyle(styles.get("cell_default"), row, (short) 5, vendorCode);
					setExcelStyle(styles.get("cell_default"), row, (short) 6, name1);
					setExcelStyle(styles.get("cell_default"), row, (short) 7, name2);
					setExcelStyle(styles.get("cell_default"), row, (short) 8, name3);
					setExcelStyle(styles.get("cell_default"), row, (short) 9, name4);
					setExcelStyle(styles.get("cell_default"), row, (short) 10, street);

					String district = StringUtils.isNotBlank(o.getDistrict()) ? o.getDistrict() : "";
					String city = StringUtils.isNotBlank(o.getCity()) ? o.getCity() : "";
					String postCode = StringUtils.isNotBlank(o.getPostCode()) ? o.getPostCode() : "";
					String country = StringUtils.isNotBlank(o.getCountry()) ? o.getCountry() : "";
					String searchTerm = StringUtils.isNotBlank(o.getSearchTerm()) ? o.getSearchTerm() : "";
					String tel1 = StringUtils.isNotBlank(o.getTel1()) ? o.getTel1() : "";
					String tel2 = StringUtils.isNotBlank(o.getTel2()) ? o.getTel2() : "";
					String mobile = StringUtils.isNotBlank(o.getMobile()) ? o.getMobile() : "";
					String fax = StringUtils.isNotBlank(o.getFax()) ? o.getFax() : "";
					String email = StringUtils.isNotBlank(o.getEmail()) ? o.getEmail() : "";

					setExcelStyle(styles.get("cell_default"), row, (short) 11, district);
					setExcelStyle(styles.get("cell_default"), row, (short) 12, city);
					setExcelStyle(styles.get("cell_default"), row, (short) 13, postCode);
					setExcelStyle(styles.get("cell_default"), row, (short) 14, country);
					setExcelStyle(styles.get("cell_default"), row, (short) 15, searchTerm);
					setExcelStyle(styles.get("cell_default"), row, (short) 16, tel1);
					setExcelStyle(styles.get("cell_default"), row, (short) 17, tel2);
					setExcelStyle(styles.get("cell_default"), row, (short) 18, mobile);
					setExcelStyle(styles.get("cell_default"), row, (short) 19, fax);
					setExcelStyle(styles.get("cell_default"), row, (short) 20, email);

					String lineNo = StringUtils.isNotBlank(o.getLineNo()) ? o.getLineNo() : "";
					String telebox = StringUtils.isNotBlank(o.getTelebox()) ? o.getTelebox() : "";
					String commentDesc = StringUtils.isNotBlank(o.getCommentDesc()) ? o.getCommentDesc() : "";
					String tradingPartner = StringUtils.isNotBlank(o.getTradingPartner()) ? o.getTradingPartner() : "";
					String customerCode = StringUtils.isNotBlank(o.getCustomerCode()) ? o.getCustomerCode() : "";
					String personelId = StringUtils.isNotBlank(o.getPersonelId()) ? o.getPersonelId() : "";
					String taxId = StringUtils.isNotBlank(o.getTax13()) ? o.getTax13() : "";
					String insustryKey = StringUtils.isNotBlank(o.getIndustryKey()) ? o.getIndustryKey() : "";
					String purchasingOrg = StringUtils.isNotBlank(o.getPurchasingOrg()) ? o.getPurchasingOrg() : "";
					String orderCurrency = StringUtils.isNotBlank(o.getOrderCurrency()) ? o.getOrderCurrency() : "";
					String tax13 = StringUtils.isNotBlank(o.getTax13()) ? o.getOrderCurrency() : "";

					setExcelStyle(styles.get("cell_default"), row, (short) 21, lineNo);
					setExcelStyle(styles.get("cell_default"), row, (short) 22, telebox);
					setExcelStyle(styles.get("cell_default"), row, (short) 23, commentDesc);
					setExcelStyle(styles.get("cell_default"), row, (short) 24, tradingPartner);
					setExcelStyle(styles.get("cell_default"), row, (short) 25, customerCode);
					setExcelStyle(styles.get("cell_default"), row, (short) 26, personelId);
					setExcelStyle(styles.get("cell_default"), row, (short) 27, taxId);
					setExcelStyle(styles.get("cell_default"), row, (short) 28, tax13);
					setExcelStyle(styles.get("cell_default"), row, (short) 29, insustryKey);
					setExcelStyle(styles.get("cell_default"), row, (short) 30, purchasingOrg);
					setExcelStyle(styles.get("cell_default"), row, (short) 31, "");
					setExcelStyle(styles.get("cell_default"), row, (short) 32, orderCurrency);

					String purchasingPaymentTerm = StringUtils.isNotBlank(o.getPurchasingPaymentTerm()) ? o
							.getPurchasingPaymentTerm() : "";
					String goodsReceipt = StringUtils.isNotBlank(o.getGoodsReceipt()) ? o.getGoodsReceipt() : "";
					String reconAcct = StringUtils.isNotBlank(o.getReconAcct()) ? o.getReconAcct() : "";
					String previousAccount = StringUtils.isNotBlank(o.getPreviousAccount()) ? o.getPreviousAccount()
							: "";
					String paymentTerm = StringUtils.isNotBlank(o.getPaymentTerm()) ? o.getPaymentTerm() : "";
					String paymentMethod = StringUtils.isNotBlank(o.getPaymentMethod()) ? o.getPaymentMethod() : "";
					String paymentBlock = StringUtils.isNotBlank(o.getPaymentBlock()) ? o.getPaymentBlock() : "";
					String whtType = StringUtils.isNotBlank(o.getWhtType()) ? o.getWhtType() : "";
					String whtCode = StringUtils.isNotBlank(o.getWhtCode()) ? o.getWhtCode() : "";
					String recipientType = StringUtils.isNotBlank(o.getRecipientType()) ? o.getRecipientType() : "";
					String accclr = StringUtils.isNotBlank(o.getAccclr()) ? o.getRecipientType() : "";

					setExcelStyle(styles.get("cell_default"), row, (short) 33, purchasingPaymentTerm);
					setExcelStyle(styles.get("cell_default"), row, (short) 34, goodsReceipt);
					setExcelStyle(styles.get("cell_default"), row, (short) 35, reconAcct);
					setExcelStyle(styles.get("cell_default"), row, (short) 36, previousAccount);
					setExcelStyle(styles.get("cell_default"), row, (short) 37, paymentTerm);
					setExcelStyle(styles.get("cell_default"), row, (short) 38, paymentMethod);
					setExcelStyle(styles.get("cell_default"), row, (short) 39, paymentBlock);
					setExcelStyle(styles.get("cell_default"), row, (short) 40, accclr);
					setExcelStyle(styles.get("cell_default"), row, (short) 41, whtType);
					setExcelStyle(styles.get("cell_default"), row, (short) 42, whtCode);
					setExcelStyle(styles.get("cell_default"), row, (short) 43, recipientType);

					String whtType2 = StringUtils.isNotBlank(o.getWhtType2()) ? o.getWhtType2() : "";
					String whtCode2 = StringUtils.isNotBlank(o.getWhtCode2()) ? o.getWhtCode2() : "";
					String recipientType2 = StringUtils.isNotBlank(o.getRecipientType2()) ? o.getRecipientType2() : "";
					String whtType3 = StringUtils.isNotBlank(o.getWhtType3()) ? o.getWhtType3() : "";
					String whtCode3 = StringUtils.isNotBlank(o.getWhtCode3()) ? o.getWhtCode3() : "";
					String recipientType3 = StringUtils.isNotBlank(o.getRecipientType3()) ? o.getRecipientType3() : "";
					String bankKey = StringUtils.isNotBlank(o.getBankKey()) ? o.getBankKey() : "";
					String bankName = StringUtils.isNotBlank(o.getBankName()) ? o.getBankName() : "";
					String bankAcc = StringUtils.isNotBlank(o.getBankAcc()) ? o.getBankAcc() : "";
					String bankAccName = StringUtils.isNotBlank(o.getBankAccName()) ? o.getBankAccName() : "";
					String partnerBankType = StringUtils.isNotBlank(o.getPartnerBankType()) ? o.getPartnerBankType()
							: "";
					String alternativePayee = StringUtils.isNotBlank(o.getAlternativePayee()) ? o.getAlternativePayee()
							: "";

					setExcelStyle(styles.get("cell_default"), row, (short) 44, whtType2);
					setExcelStyle(styles.get("cell_default"), row, (short) 45, whtCode2);
					setExcelStyle(styles.get("cell_default"), row, (short) 46, recipientType2);
					setExcelStyle(styles.get("cell_default"), row, (short) 47, whtType3);
					setExcelStyle(styles.get("cell_default"), row, (short) 48, whtCode3);
					setExcelStyle(styles.get("cell_default"), row, (short) 49, recipientType3);
					setExcelStyle(styles.get("cell_default"), row, (short) 50, bankKey);
					setExcelStyle(styles.get("cell_default"), row, (short) 51, bankName);
					setExcelStyle(styles.get("cell_default"), row, (short) 52, bankAcc);
					setExcelStyle(styles.get("cell_default"), row, (short) 53, bankAccName);
					setExcelStyle(styles.get("cell_default"), row, (short) 54, partnerBankType);
					setExcelStyle(styles.get("cell_default"), row, (short) 55, alternativePayee);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e);
		}
	}

	private void setCellSize(HSSFSheet sheet) {
		sheet.autoSizeColumn((short) 0);
		sheet.autoSizeColumn((short) 1);
		sheet.autoSizeColumn((short) 2);
		sheet.autoSizeColumn((short) 3);
		sheet.autoSizeColumn((short) 4);
		sheet.autoSizeColumn((short) 5);
		sheet.autoSizeColumn((short) 6);
		sheet.autoSizeColumn((short) 7);
		sheet.autoSizeColumn((short) 8);
		sheet.autoSizeColumn((short) 9);
		sheet.autoSizeColumn((short) 10);
		sheet.autoSizeColumn((short) 11);
		sheet.autoSizeColumn((short) 12);
		sheet.autoSizeColumn((short) 13);
		sheet.autoSizeColumn((short) 14);
		sheet.autoSizeColumn((short) 15);
		sheet.autoSizeColumn((short) 16);
		sheet.autoSizeColumn((short) 17);
		sheet.autoSizeColumn((short) 18);
		sheet.autoSizeColumn((short) 19);
		sheet.autoSizeColumn((short) 20);
		sheet.autoSizeColumn((short) 21);
		sheet.autoSizeColumn((short) 22);
		sheet.autoSizeColumn((short) 23);
		sheet.autoSizeColumn((short) 24);
		sheet.autoSizeColumn((short) 25);
		sheet.autoSizeColumn((short) 26);
		sheet.autoSizeColumn((short) 27);
		sheet.autoSizeColumn((short) 28);
		sheet.autoSizeColumn((short) 29);
		sheet.autoSizeColumn((short) 30);
		sheet.autoSizeColumn((short) 31);
		sheet.autoSizeColumn((short) 32);
		sheet.autoSizeColumn((short) 33);
		sheet.autoSizeColumn((short) 34);
		sheet.autoSizeColumn((short) 35);
		sheet.autoSizeColumn((short) 36);
		sheet.autoSizeColumn((short) 37);
		sheet.autoSizeColumn((short) 38);
		sheet.autoSizeColumn((short) 39);
		sheet.autoSizeColumn((short) 40);
		sheet.autoSizeColumn((short) 41);
		sheet.autoSizeColumn((short) 42);
		sheet.autoSizeColumn((short) 43);
		sheet.autoSizeColumn((short) 44);
		sheet.autoSizeColumn((short) 45);
		sheet.autoSizeColumn((short) 46);
		sheet.autoSizeColumn((short) 47);
		sheet.autoSizeColumn((short) 48);
		sheet.autoSizeColumn((short) 49);
		sheet.autoSizeColumn((short) 50);
		sheet.autoSizeColumn((short) 51);
		sheet.autoSizeColumn((short) 52);

	}

	public boolean doLoadCheckPremium() {
		boolean flag = false;
		semmrt001Bean = getSemmrt001Bean();
		List<Mrt001SrchRentPay> to = new ArrayList<Mrt001SrchRentPay>();
		IRentalDetailService service = (IRentalDetailService) getBean("rentalDetailService");
		semmrt001Bean.setRentPayList(new ArrayList<Mrt001SrchRentPay>());
		String rentalMasterId = (String) getFacesUtils().getRequestParameter("rentalMasterId");
		semmrt001Bean.setRentalMasterId(rentalMasterId);
		LOG.debug("rentalMasterId = " + rentalMasterId);
		try {
			Mrt001SrchRentPay criteria = new Mrt001SrchRentPay();
			criteria.setRowId(rentalMasterId);
			to = service.querySPList(EQueryName.SP_MRT001_SRCH_RENT_PAY.name, criteria);
			if (to != null && !to.isEmpty()) {
				for (Mrt001SrchRentPay rentPay : to) {
					if (rentPay.getPeriodStartDt() != null)
						rentPay.setPeriodStartDtStr(convertYearENtoTHStr(rentPay.getPeriodStartDt()));
				}
				semmrt001Bean.setRentPayList(to);
			}
			flag = true;
			setSemmrt001Bean(semmrt001Bean);
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e);
		}
		return flag;
	}

	@SuppressWarnings("unchecked")
	private boolean doCalculateBalance() {
		boolean flag = false;
		semmrt001Bean = getSemmrt001Bean();
		flag = callMrt001BalanceCal();
		setSemmrt001Bean(semmrt001Bean);
		return flag;
	}

	private boolean callMrt001BalanceCal() {
		boolean result = true;
		if ("SPECIAL".equals(semmrt001Bean.getModePage())) {
			return result;
		}
		Mrt001BalanceCal mrt001BalanceCal = new Mrt001BalanceCal();
		mrt001BalanceCal.setRentalAmt(semmrt001Bean.getRentDetail().getRentalAmt());
		mrt001BalanceCal.setRentPeriodType(semmrt001Bean.getRentDetail().getRentPeriodType());
		mrt001BalanceCal.setPayPeriodType(semmrt001Bean.getRentDetail().getPayPeriodType());
		// check data pay period
		if (semmrt001Bean.getRentDetail().getPayPeriodType().equals("03")) {
			if (StringUtils.equalsIgnoreCase("EDIT", semmrt001Bean.getModeRentalDetail())) {
				mrt001BalanceCal.setPayPeriod(semmrt001Bean.getRentDetail().getPayPeriod());
			} else {
				mrt001BalanceCal.setPayPeriod(semmrt001Bean.getPayPeriodMonth());
			}
		} else if (semmrt001Bean.getRentDetail().getPayPeriodType().equals("04")) {
			if (StringUtils.equalsIgnoreCase("EDIT", semmrt001Bean.getModeRentalDetail())) {
				mrt001BalanceCal.setPayPeriod(semmrt001Bean.getRentDetail().getPayPeriod());
			} else {
				mrt001BalanceCal.setPayPeriod(semmrt001Bean.getPayPeriodYear());
			}
		} else {
			mrt001BalanceCal.setPayPeriod(null);
		}
		System.out.println("period " + semmrt001Bean.getRentDetail().getPeriodAmt());
		mrt001BalanceCal.setEffectiveDt(semmrt001Bean.getRentDetail().getEffectiveDt());
		mrt001BalanceCal.setExpireDt(semmrt001Bean.getRentDetail().getExpiredDt());
		mrt001BalanceCal.setPeriodStartDt(semmrt001Bean.getRentDetail().getPeriodStartDt());
		mrt001BalanceCal.setPeriodEndDt(semmrt001Bean.getRentDetail().getPeriodEndDt());
		mrt001BalanceCal.setPeriodAmt(semmrt001Bean.getRentDetail().getPeriodAmt());
		mrt001BalanceCal.setSiteRentCondId(semmrt001Bean.getRentDetail().getSiteRentCondId());
		mrt001BalanceCal.setVendorMasterId(semmrt001Bean.getRentDetail().getVendorMasterId());
		mrt001BalanceCal.setPayeeMasterId(semmrt001Bean.getRentDetail().getPayeeMasterId());
		System.out.println("callMrt001BalanceCal getSiteRentCondId = " + mrt001BalanceCal.getSiteRentCondId());
		IRentalDetailService service = (IRentalDetailService) getBean("rentalDetailService");
		try {
			List<Mrt001BalanceCal> list = service.querySPList(EQueryName.SP_MRT001_BALANCE_CAL.name, mrt001BalanceCal);
			if (list != null && !list.isEmpty()) {
				Mrt001BalanceCal tmp = list.get(0);
				if (tmp != null && "Success".equals(tmp.getResult())) {
					semmrt001Bean.getRentDetail().setBalanceAmt(tmp.getBalanceAmt());
				} else {
					semmrt001Bean.setRenderedMsgFormSearch(false);
					semmrt001Bean.setRenderedMsgFormMiddle(true);
					if (tmp != null) {
						semmrt001Bean.getRentDetail().setBalanceAmt(
								(null != tmp.getBalanceAmt()) ? tmp.getBalanceAmt() : null);
						addGeneralMessageError(tmp.getRemark());
					}
					// addMessageError("incContent:frmAddRental:fieldRentalDetail",
					// "W0034", "");
					// FrontMessageUtils.addMessageError(tmp.getRemark());
					result = false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e);
		}
		return result;
	}

	public void checkPendingDt() {
		semmrt001Bean = getSemmrt001Bean();
		if (!getSemmrt001Bean().isDisPendingDt()) {
			getSemmrt001Bean().getDisplayFrmRental().setPendingDate(null);
		}
	}

	public void doNewDepositDetail() {
		getSemmrt001Bean().setDpstDetail(new DepositDetail());
		getSemmrt001Bean().setDisDepositDetail(false);
		getSemmrt001Bean().setDisDpstAmt(false);
		getSemmrt001Bean().setModeDpstDetail("ADD");
		getSemmrt001Bean().setVendorList(new ArrayList<SelectItem>());
		getSemmrt001Bean().getMrt001BookBank().setBankAccNo("");
		getSemmrt001Bean().getMrt001BookBank().setBankName("");
		LOG.debug("isViewMode = " + getSemmrt001Bean().isViewMode());
	}

	public void clickSpecialChk() {
		semmrt001Bean = getSemmrt001Bean();
		List<VerifyRentalSearchSiteRentCondSP> rentCondList = semmrt001Bean.getRentCondList();
		String expenseType = (String) getFacesUtils().getRequestParameter("expenseType");
		String subExpenseType = getFacesUtils().getRequestParameter("subExpenseType") == null ? ""
				: (String) getFacesUtils().getRequestParameter("subExpenseType");
		semmrt001Bean.setCheckMode("SPECIAL");
		for (int i = 0; i < rentCondList.size(); i++) {
			rentCondList.get(i).setSelected(false);
		}
		if ((semmrt001Bean.isSpecialChk1() || semmrt001Bean.isSpecialChk2())
				&& (semmrt001Bean.getRentDetail().getEffectiveDt() == null || semmrt001Bean.getRentDetail()
						.getExpiredDt() == null)) {
			semmrt001Bean.getRentDetail().setEffectiveDt(semmrt001Bean.getDisplayFrmRental().getEffDate());
			semmrt001Bean.getRentDetail().setExpiredDt(semmrt001Bean.getDisplayFrmRental().getExpireDate());

		}

		if (StringUtils.equals("01", expenseType)) {
			semmrt001Bean.setSpecialChk2(false);
			semmrt001Bean.setSpecialChk3(false);
			semmrt001Bean.setSpecialChk4(false);
		} else if (StringUtils.equals("02", expenseType)) {
			if (StringUtils.equals("01", subExpenseType)) {
				semmrt001Bean.setSpecialChk1(false);
				semmrt001Bean.setSpecialChk3(false);
				semmrt001Bean.setSpecialChk4(false);
			} else if (StringUtils.equals("02", subExpenseType)) {
				semmrt001Bean.setSpecialChk1(false);
				semmrt001Bean.setSpecialChk2(false);
				semmrt001Bean.setSpecialChk4(false);
			} else if (StringUtils.equals("03", subExpenseType)) {
				semmrt001Bean.setSpecialChk1(false);
				semmrt001Bean.setSpecialChk2(false);
				semmrt001Bean.setSpecialChk3(false);
			}
		}

		if (StringUtils.isNotEmpty(expenseType)
				&& (semmrt001Bean.isSpecialChk1() || semmrt001Bean.isSpecialChk2() || semmrt001Bean.isSpecialChk3() || semmrt001Bean
						.isSpecialChk4())) {
			onChangeDdlExpenseType();
			// Get dropdown vendor
			semmrt001Bean.getRentDetail().setExpenseType(expenseType);
			semmrt001Bean.setDisabledExpenseType(false);
			Mrt001SrchVendor mrt001SrchVendor = new Mrt001SrchVendor();
			mrt001SrchVendor.setExpenseType(semmrt001Bean.getRentDetail().getExpenseType());
			mrt001SrchVendor.setContractNo(semmrt001Bean.getDisplayFrmRental().getContractNo());
			semmrt001Bean.setVendorList(getDropdownVendor(mrt001SrchVendor));
		} else {
			this.doClearRentalDetail();
		}

		setSemmrt001Bean(semmrt001Bean);
	}

	public void setRentAmtValue() {
		semmrt001Bean = getSemmrt001Bean();
		Double amtMonth = 0.0;
		Double amtYear = 0.0;
		Double amtOnce = 0.0;
		if (semmrt001Bean.getRentDetail().getRentalAmt() == null || semmrt001Bean.getRentDetail().getRentalAmt() == 0.0) {
			semmrt001Bean.getRentDetail().setRentalAmt(0.0);
		} else {
			if (StringUtils.equalsIgnoreCase("M", semmrt001Bean.getRentDetail().getRentPeriodType())) {
				amtMonth = semmrt001Bean.getRentDetail().getRentalAmt();
				amtYear = semmrt001Bean.getRentDetail().getRentalAmt() * 12;
				amtOnce = semmrt001Bean.getRentDetail().getRentalAmt();
			} else if (StringUtils.equalsIgnoreCase("Y", semmrt001Bean.getRentDetail().getRentPeriodType())) {
				amtMonth = semmrt001Bean.getRentDetail().getRentalAmt() / 12;
				amtYear = semmrt001Bean.getRentDetail().getRentalAmt();
				amtOnce = semmrt001Bean.getRentDetail().getRentalAmt();
			} else {
				amtMonth = semmrt001Bean.getRentDetail().getRentalAmt();
				amtYear = semmrt001Bean.getRentDetail().getRentalAmt();
				amtOnce = semmrt001Bean.getRentDetail().getRentalAmt();
			}
		}
		if ("01".equals(semmrt001Bean.getPeriod())) {
			if (amtMonth == 0.0 || amtMonth == null) {
				semmrt001Bean.getRentDetail().setPeriodAmt(0.0);
			} else {
				semmrt001Bean.getRentDetail().setPeriodAmt(calShraePeriodAmt(amtMonth, 1));
			}
		} else if ("02".equals(semmrt001Bean.getPeriod())) {
			if (amtYear == 0.0 || amtYear == null) {
				semmrt001Bean.getRentDetail().setPeriodAmt(0.0);
			} else {
				semmrt001Bean.getRentDetail().setPeriodAmt(calShraePeriodAmt(amtYear, 1));
			}
		} else if ("05".equals(semmrt001Bean.getPeriod())) {
			if (amtOnce == 0.0 || amtOnce == null) {
				semmrt001Bean.getRentDetail().setPeriodAmt(0.0);
			} else {
				semmrt001Bean.getRentDetail().setPeriodAmt(calShraePeriodAmt(amtOnce, 1));
			}
		} else {
			semmrt001Bean.getRentDetail().setPeriodAmt(semmrt001Bean.getRentDetail().getRentalAmt());
		}

		setSemmrt001Bean(semmrt001Bean);
	}

	public void setChangeWht() {
		semmrt001Bean = getSemmrt001Bean();
		String type = semmrt001Bean.getRentDetail().getWhtType();
		if (StringUtils.equalsIgnoreCase(type, "03")) {
			if (!semmrt001Bean.isDisWhtRate()) {
				semmrt001Bean.getRentDetail().setWhtRate(new Double(0));
			} else {
				semmrt001Bean.getRentDetail().setWhtRate(semmrt001Bean.getTmpWhtRate());
			}

		} else {
			if (semmrt001Bean.isDisWhtRate()) {
				semmrt001Bean.getRentDetail().setWhtRate(semmrt001Bean.getTmpWhtRate());
			} else {
				if (semmrt001Bean.getRentDetail().getDefaultWht() != null
						&& semmrt001Bean.getRentDetail().getDefaultWht() > 0) {
					semmrt001Bean.getRentDetail().setWhtRate(semmrt001Bean.getRentDetail().getDefaultWht());
				} else {
					if (semmrt001Bean.getRentDetail().getExpenseType() != null
							&& semmrt001Bean.getRentDetail().getExpenseType().equals("01")) {
						semmrt001Bean.getRentDetail().setWhtRate(new Double(5));
					} else if (semmrt001Bean.getRentDetail().getExpenseType() != null
							&& semmrt001Bean.getRentDetail().getExpenseType().equals("02")) {
						semmrt001Bean.getRentDetail().setWhtRate(new Double(3));
					}
					// Object o =
					// ELUtils.getLOVNameByLOVCode(LOVCacheUtil.getInstance().getByLOVType(ELovType.T_CT_EXPENSE_TYPE.name),
					// semmrt001Bean.getRentDetail().getExpenseType());
					// semmrt001Bean.getRentDetail().setWhtRate(getLovItemsByType(getLovItemsByType(ELovType.T_CT_EXPENSE_TYPE.name,
					// EX_AND, semmrt001Bean.getRentDetail().getExpenseType(),
					// con2, null)));
				}

			}
		}
		setSemmrt001Bean(semmrt001Bean);
	}

	public void setChangeVat() {
		semmrt001Bean = getSemmrt001Bean();
		String type = semmrt001Bean.getRentDetail().getVatType();
		if (StringUtils.equalsIgnoreCase(type, "03")) {
			semmrt001Bean.getRentDetail().setVatRate(new Double(0));
		} else {
			semmrt001Bean.getRentDetail().setVatRate(semmrt001Bean.getDefaultVat());
		}
		setSemmrt001Bean(semmrt001Bean);
	}

	private boolean initEditPeriod() {
		boolean flag = false;
		semmrt001Bean = getSemmrt001Bean();

		String rentalPaymentId = (String) getFacesUtils().getRequestParameter("rentalPaymentId");
		String expenseType = (String) getFacesUtils().getRequestParameter("expenseType");
		String periodStartDt = (String) getFacesUtils().getRequestParameter("periodStartDt");
		String periodType = (String) getFacesUtils().getRequestParameter("periodType");
		String periodNoStart = (String) getFacesUtils().getRequestParameter("periodNoStart");

		try {
			semmrt001Bean.setPeriodStartDt(SEMDataUtility.convertStringToDateByFormat(periodStartDt, "dd/MM/yyyy"));
			semmrt001Bean.setPeriodNo(Double.valueOf(periodNoStart));
			semmrt001Bean.setExpenseType(expenseType);
			semmrt001Bean.setPeriodType(periodType);
			semmrt001Bean.setRentalPaymentId(rentalPaymentId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOG.error(e);
		}
		setSemmrt001Bean(semmrt001Bean);
		return flag;
	}

	private boolean doUpdatePeriod() {
		boolean flag = false;
		semmrt001Bean = getSemmrt001Bean();
		try {

			Mrt001UpdatePeriod mrt001UpdatePeriod = new Mrt001UpdatePeriod();
			mrt001UpdatePeriod.setRentalPaymentId(semmrt001Bean.getRentalPaymentId());
			mrt001UpdatePeriod.setPeriod(String.valueOf(semmrt001Bean.getPeriodNo()));
			mrt001UpdatePeriod.setUserId(getUserLogIn());

			IRentalDetailService service = (IRentalDetailService) getBean("rentalDetailService");

			List<Mrt001UpdatePeriod> to = null;

			to = service.querySPList(EQueryName.SP_UPD_MRT001_UPD_PERIOD.name, mrt001UpdatePeriod);

			if (to.size() > 0 && to != null) {
				List<Mrt001SrchRentPay> rentalPayList = new ArrayList<Mrt001SrchRentPay>();
				try {
					Mrt001SrchRentPay criteria = new Mrt001SrchRentPay();
					criteria.setRowId(semmrt001Bean.getRentalMasterId());
					rentalPayList = service.querySPList(EQueryName.SP_MRT001_SRCH_RENT_PAY.name, criteria);
					if (rentalPayList != null && !rentalPayList.isEmpty()) {
						for (Mrt001SrchRentPay rentPay : rentalPayList) {
							if (rentPay.getPeriodStartDt() != null)
								rentPay.setPeriodStartDtStr(convertYearENtoTHStr(rentPay.getPeriodStartDt()));
						}
						semmrt001Bean.setRentPayList(rentalPayList);
					}
					flag = true;
				} catch (Exception e) {
					e.printStackTrace();
					LOG.error(e);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e);
		}
		setSemmrt001Bean(semmrt001Bean);
		return flag;
	}

	// added by.. YUT
	public boolean doInitialForSearchRental() {
		LOG.info("::: SEMMRT001Action :: doInitialForSearchRental >> BEGIN :::");
		boolean flag = true;

		try {

			semmrt001Bean = getSemmrt001Bean();

			String paramUrl = getFacesUtils().getRequestParameter("paramUrl") == null ? "" : (String) getFacesUtils()
					.getRequestParameter("paramUrl");
			String paramMenuGroup = getFacesUtils().getRequestParameter("paramMenuGroup") == null ? ""
					: (String) getFacesUtils().getRequestParameter("paramMenuGroup");
			String paramMenuSubGroup = getFacesUtils().getRequestParameter("paramMenuSubGroup") == null ? ""
					: (String) getFacesUtils().getRequestParameter("paramMenuSubGroup");
			String paramParameter = getFacesUtils().getRequestParameter("paramParameter") == null ? ""
					: (String) getFacesUtils().getRequestParameter("paramParameter");

			// System.out.println("paramUrl: " + paramUrl);
			// System.out.println("paramMenuGroup: " + paramMenuGroup);
			// System.out.println("paramMenuSubGroup: " + paramMenuSubGroup);
			// System.out.println("paramParameter: " + paramParameter);

			semmrt001Bean.getCriteria().setStrParam(paramParameter);
			semmrt001Bean.setRenderedOnToDoList(true); //

			setSemmrt001Bean(semmrt001Bean);

			this.doSearch();

		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e);
			addMessageError("EL0000", "SEMMRT001Action");
			flag = false;

		} finally {
			LOG.info("::: SEMMRT001Action :: doInitialForSearchRental >> END :::");
		}
		return flag;
	}

	public void doChangeServiceType() {

		SEMMRT001Bean semmrt001Bean = getSemmrt001Bean();
		String serviceName = (String) getFacesUtils().getRequestParameter("serviceTypeId");

		try {
			semmrt001Bean.setServiceCalTypeIdToCal(serviceName);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	private List<SelectItem> getServiceList(String siteInfoId) {
		List<SelectItem> resultList = new ArrayList<SelectItem>();
		try {
			semmrt001Bean = getSemmrt001Bean();

			Mrt001UpdRentPay cri = new Mrt001UpdRentPay();
			cri.setSiteInfoId(siteInfoId);
			cri.setMode("C");
			if (semmrt001Bean.getServiceCalTypeId() != null) {
				cri.setServiceId(semmrt001Bean.getServiceCalTypeId());
			}
			IManagementService manageService = (IManagementService) getBean("managementService");
			List<Mrt001UpdRentPay> serviceList = manageService.querySPList(EQueryName.SEM_SI_SITE_INFO_SERVICES.name,
					cri);

			if (serviceList.size() > 0) {
				SelectItem item = new SelectItem();
				item.setLabel("-- All Service --");
				item.setValue("ALL");
				resultList.add(item);
				for (Mrt001UpdRentPay obj : serviceList) {
					item = new SelectItem();
					item.setLabel(obj.getServiceName());
					item.setValue(obj.getServiceId());
					resultList.add(item);

				}
			} else {
				SelectItem item = new SelectItem();
				item.setLabel("-- No Service --");
				item.setValue("");
				resultList.add(item);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultList;
	}

	private List<Mrt001RentCal> getConfigServiceMaster(String siteInfoId, String serviceId) {
		List<Mrt001RentCal> resultList = new ArrayList<Mrt001RentCal>();
		try {
			Mrt001RentCal cri = new Mrt001RentCal();
			IManagementService manageService = (IManagementService) getBean("managementService");
			cri.setServiceId(serviceId);
			cri.setSiteInfoId(siteInfoId);
			List<Mrt001RentCal> serviceConfig = manageService.querySPList(
					EQueryName.SEM_SP_MRT001_SRCH_CAL_CONFIG.name, cri);

			if (serviceConfig.size() > 0) {
				Mrt001RentCal item = new Mrt001RentCal();
				for (Mrt001RentCal obj : serviceConfig) {
					item = new Mrt001RentCal();
					item.setServiceName(obj.getServiceName());
					item.setServiceId(obj.getServiceId());
					item.setConfigRate(obj.getConfigRate());
					item.setInputAmt(obj.getInputAmt());
					item.setInputPercent(obj.getInputPercent());
					resultList.add(item);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultList;
	}

	public boolean doInitTodoList() {
		boolean flag = true;
		try {
			semmrt001Bean = getSemmrt001Bean();
			loadTree();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOG.error(e);
			flag = false;
		} finally {
			// setSemmrt001Bean(semmrt001Bean);
		}
		return flag;
	}

	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// menu util >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	private TreeNode rootNode = null;
	private List<String> selectedNodeChildren = new ArrayList<String>();

	private String nodeTitle;
	private MenuTreeSP nodeValue;
	private MenuTreeSP menuRoot;

	private void loadTree() {
		semmrt001Bean = getSemmrt001Bean();
		semmrt001Bean.setTreeMacroFlag(false);
		semmrt001Bean.setTreePicoFlag(false);
		semmrt001Bean.setTreeExcFlag(false);
		TreeUtilBean myParam = new TreeUtilBean();
		List<Object> mySendList = new ArrayList<Object>();
		String searchFlag;
		searchFlag = getFacesUtils().getRequestParameter("searchFlag") == null ? "" : (String) getFacesUtils()
				.getRequestParameter("searchFlag");
		String backWard = getFacesUtils().getRequestParameter("backWard") == null ? "" : (String) getFacesUtils()
				.getRequestParameter("backWard");
		IMenuTreeService service = (IMenuTreeService) getBean("menuTreeService");

		String groupType = "RT";
		try {

			// // >>
			if ("Y".equals(searchFlag)) {
				List<MenuTreeSP> menuTreeList = null;
				semmrt001Bean.getTreeUtilBean().setMenuGroup(groupType);
				semmrt001Bean.getTreeUtilBean().setUserLogin(getUserLogIn());
				if (!semmrt001Bean.getTreeUtilBean().getCompany().equals("")
						&& !semmrt001Bean.getTreeUtilBean().getRegion().equals("")) {
					if (!semmrt001Bean.getTreeUtilBean().getMenuSubGroup().equals("")) {
						menuTreeList = service.querySPList(EQueryName.SP_MSI001_GET_TODO_MENU.name, semmrt001Bean
								.getTreeUtilBean());

						Map<String, Object> myMap = new HashMap<String, Object>();

						if (menuTreeList != null && !menuTreeList.isEmpty()) {

							// / >
							for (int j = 0; j < menuTreeList.size(); j++) {
								String mLevel = menuTreeList.get(j).getMenuLevel();
								myMap.put(mLevel, menuTreeList.get(j));
							}
							mySendList.add(myMap);
							// / <

						}
					} else {
						for (int i = 0; i < 3; i++) {
							if (i == 0) {
								semmrt001Bean.getTreeUtilBean().setMenuSubGroup("M");
							}

							menuTreeList = service.querySPList(EQueryName.SP_MSI001_GET_TODO_MENU.name, semmrt001Bean
									.getTreeUtilBean());

							Map<String, Object> myMap = new HashMap<String, Object>();

							if (menuTreeList != null && !menuTreeList.isEmpty()) {

								// / >
								for (int j = 0; j < menuTreeList.size(); j++) {
									String mLevel = menuTreeList.get(j).getMenuLevel();
									myMap.put(mLevel, menuTreeList.get(j));
								}
								mySendList.add(myMap);
								// / <

							}
							if (i == 0) {
								semmrt001Bean.getTreeUtilBean().setMenuSubGroup("P");
							} else {
								semmrt001Bean.getTreeUtilBean().setMenuSubGroup("R");
							}

						}
						semmrt001Bean.getTreeUtilBean().setMenuSubGroup("");
					}
				} else {
					validateToDoList();
				}
			} else {
				if ("Y".equals(backWard)) {
					List<MenuTreeSP> menuTreeList = null;
					semmrt001Bean.getTreeUtilBean().setMenuGroup(groupType);
					semmrt001Bean.getTreeUtilBean().setUserLogin(getUserLogIn());
					if (!semmrt001Bean.getTreeUtilBean().getCompany().equals("")
							&& !semmrt001Bean.getTreeUtilBean().getRegion().equals("")) {
						if (!semmrt001Bean.getTreeUtilBean().getMenuSubGroup().equals("")) {
							menuTreeList = service.querySPList(EQueryName.SP_MSI001_GET_TODO_MENU.name, semmrt001Bean
									.getTreeUtilBean());

							Map<String, Object> myMap = new HashMap<String, Object>();

							if (menuTreeList != null && !menuTreeList.isEmpty()) {

								// / >
								for (int j = 0; j < menuTreeList.size(); j++) {
									String mLevel = menuTreeList.get(j).getMenuLevel();
									myMap.put(mLevel, menuTreeList.get(j));
								}
								mySendList.add(myMap);
								// / <

							}
						} else {
							for (int i = 0; i < 3; i++) {
								if (i == 0) {
									semmrt001Bean.getTreeUtilBean().setMenuSubGroup("M");
								}

								menuTreeList = service.querySPList(EQueryName.SP_MSI001_GET_TODO_MENU.name,
										semmrt001Bean.getTreeUtilBean());

								Map<String, Object> myMap = new HashMap<String, Object>();

								if (menuTreeList != null && !menuTreeList.isEmpty()) {

									// / >
									for (int j = 0; j < menuTreeList.size(); j++) {
										String mLevel = menuTreeList.get(j).getMenuLevel();
										myMap.put(mLevel, menuTreeList.get(j));
									}
									mySendList.add(myMap);
									// / <

								}
								if (i == 0) {
									semmrt001Bean.getTreeUtilBean().setMenuSubGroup("P");
								} else {
									semmrt001Bean.getTreeUtilBean().setMenuSubGroup("R");
								}
							}
							semmrt001Bean.getTreeUtilBean().setMenuSubGroup("");
						}
					} else {
						validateToDoList();
					}
				} else {
					semmrt001Bean.setTreeUtilBean(new TreeUtilBean());
					setSemmrt001Bean(semmrt001Bean);
				}

			}
			semmrt001Bean.setRootNode(new TreeNodeImpl());
			addNodes(semmrt001Bean, mySendList);
			// // <<

		} catch (Exception e) {
			throw new FacesException(e.getMessage(), e);
		} finally {
			// semmrt001Bean = getSemmrt001Bean();
			myParam = null;
			mySendList = null;
			searchFlag = null;
			service = null;
			backWard = null;
			groupType = null;
		}
	}

	public void validateToDoList() {
		try {
			semmrt001Bean = getSemmrt001Bean();
			if (semmrt001Bean.getTreeUtilBean().getCompany().equals("")) {
				addMessageErrorWithArgument("W0001", msg("message.company"));
			}
			if (semmrt001Bean.getTreeUtilBean().getRegion().equals("")) {
				addMessageErrorWithArgument("W0001", msg("message.region"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e);
			// TODO: handle exception
		}
	}

	@SuppressWarnings( { "unused", "unchecked" })
	private void addNodes(SEMMRT001Bean semmrt001Bean, List<Object> propList) {

		for (int i = 0; i < propList.size(); i++) {
			List<WrapperBeanObject<MenuTreeSP>> menuTreeWrapList = new ArrayList<WrapperBeanObject<MenuTreeSP>>();
			// >>
			Map<String, Object> map = (Map<String, Object>) propList.get(i);

			int mapSize = map.keySet().size();
			Object[] mapArr = map.keySet().toArray();

			// for sorting
			Object[] mapArr_ = map.keySet().toArray();
			Arrays.sort(mapArr_);
			// <<

			MenuTreeSP myParent = new MenuTreeSP();

			String _MENU_LABEL = "";
			//		
			String parent1 = mapArr_[i].toString(); // get key by sorting

			MenuTreeSP mapObj1 = (MenuTreeSP) map.get(parent1);

			if (mapObj1.getMenuSubGroup().equals("M")) {
				_MENU_LABEL = "Site Info Non PICO";

				if (mapObj1.getRegion() != null) {
					_MENU_LABEL = _MENU_LABEL + " " + mapObj1.getRegion();
				}

				if (mapObj1.getCompany() != null) {
					_MENU_LABEL = _MENU_LABEL + " " + mapObj1.getCompany();
				}

				for (int x = 0; x < mapSize; x++) {
					TreeNodeImpl<MenuTreeSP> child = new TreeNodeImpl<MenuTreeSP>();

					String parentNode = mapArr_[x].toString(); // get key by
					// sorting

					MenuTreeSP mapObj = (MenuTreeSP) map.get(parentNode);

					// 2015/01/30 fixed.. dynamic URL
					String myUrl = mapObj.getMenuUrl() == null ? "SEMMRT001-0" : mapObj.getMenuUrl().toString();
					String myAction = myUrl.substring(0, myUrl.length() - 2);
					mapObj.setMenuUrl(myUrl);
					mapObj.setMenuAction(myAction);
					// // fixed.. dynamic URL
					//	    			
					WrapperBeanObject<MenuTreeSP> tmpWrapperBean = new WrapperBeanObject<MenuTreeSP>();
					tmpWrapperBean.setDataObj(mapObj);
					tmpWrapperBean.setMessage("");
					menuTreeWrapList.add(tmpWrapperBean);
				}
				semmrt001Bean.setHeaderTreeMacro(_MENU_LABEL);
				semmrt001Bean.setTreeMacroFlag(true);
				semmrt001Bean.setMenuTreeMacroList(menuTreeWrapList);
			} else if (mapObj1.getMenuSubGroup().equals("P")) {
				_MENU_LABEL = "Site Info Pico";

				if (mapObj1.getRegion() != null) {
					_MENU_LABEL = _MENU_LABEL + " " + mapObj1.getRegion();
				}

				if (mapObj1.getCompany() != null) {
					_MENU_LABEL = _MENU_LABEL + " " + mapObj1.getCompany();
				}

				for (int x = 0; x < mapSize; x++) {
					TreeNodeImpl<MenuTreeSP> child = new TreeNodeImpl<MenuTreeSP>();

					String parentNode = mapArr_[x].toString(); // get key by
					// sorting

					MenuTreeSP mapObj = (MenuTreeSP) map.get(parentNode);

					// 2015/01/30 fixed.. dynamic URL
					String myUrl = mapObj.getMenuUrl() == null ? "SEMMRT001-0" : mapObj.getMenuUrl().toString();
					String myAction = myUrl.substring(0, myUrl.length() - 2);
					mapObj.setMenuUrl(myUrl);
					mapObj.setMenuAction(myAction);
					// // fixed.. dynamic URL

					WrapperBeanObject<MenuTreeSP> tmpWrapperBean = new WrapperBeanObject<MenuTreeSP>();
					tmpWrapperBean.setDataObj(mapObj);
					tmpWrapperBean.setMessage("");
					menuTreeWrapList.add(tmpWrapperBean);
				}
				semmrt001Bean.setHeaderTreePico(_MENU_LABEL);
				semmrt001Bean.setTreePicoFlag(true);
				semmrt001Bean.setMenuTreePicoList(menuTreeWrapList);
			} else if (mapObj1.getMenuSubGroup().equals("R")) {
				_MENU_LABEL = "Site Info ชุมสาย";

				if (mapObj1.getRegion() != null) {
					_MENU_LABEL = _MENU_LABEL + " " + mapObj1.getRegion();
				}

				if (mapObj1.getCompany() != null) {
					_MENU_LABEL = _MENU_LABEL + " " + mapObj1.getCompany();
				}

				for (int x = 0; x < mapSize; x++) {
					TreeNodeImpl<MenuTreeSP> child = new TreeNodeImpl<MenuTreeSP>();

					String parentNode = mapArr_[x].toString(); // get key by
					// sorting

					MenuTreeSP mapObj = (MenuTreeSP) map.get(parentNode);

					// 2015/01/30 fixed.. dynamic URL
					String myUrl = mapObj.getMenuUrl() == null ? "SEMMRT001-0" : mapObj.getMenuUrl().toString();
					String myAction = myUrl.substring(0, myUrl.length() - 2);
					mapObj.setMenuUrl(myUrl);
					mapObj.setMenuAction(myAction);
					// // fixed.. dynamic URL

					WrapperBeanObject<MenuTreeSP> tmpWrapperBean = new WrapperBeanObject<MenuTreeSP>();
					tmpWrapperBean.setDataObj(mapObj);
					tmpWrapperBean.setMessage("");
					menuTreeWrapList.add(tmpWrapperBean);
				}
				semmrt001Bean.setHeaderTreeExc(_MENU_LABEL);
				semmrt001Bean.setTreeExcFlag(true);
				semmrt001Bean.setMenuTreeExcList(menuTreeWrapList);
			}
			// <<

			setSemmrt001Bean(semmrt001Bean);
		}
	}

	public void processSelection(NodeSelectedEvent event) {
		HtmlTree tree = (HtmlTree) event.getComponent();
		nodeTitle = ((MenuTreeSP) tree.getRowData()).toString();
		nodeValue = (MenuTreeSP) tree.getRowData();

		selectedNodeChildren.clear();

		TreeNode currentNode = tree.getModelTreeNode(tree.getRowKey());
		if (currentNode.isLeaf()) {
			selectedNodeChildren.add(((MenuTreeSP) currentNode.getData()).toString());
			// System.out.println("selected node Child [y]: " +
			// ((MenuTreeSP)currentNode.getData()).toString());
		} else {
			Iterator<Map.Entry<Object, TreeNode>> it = currentNode.getChildren();
			while (it != null && it.hasNext()) {
				Map.Entry<Object, TreeNode> entry = it.next();
				selectedNodeChildren.add(entry.getValue().getData().toString());
				// System.out.println("selected nod Parent have Childred [x]: "
				// + entry.getValue().getData().toString());
			}
		}
	}

	// fixed 2015/01/27
	public boolean nodeExpandAll(UITree tree) {
		// can do something
		return true;
	}

	public TreeNode getTreeNode() {
		semmrt001Bean = getSemmrt001Bean();
		String searchFlag = getFacesUtils().getRequestParameter("searchFlag") == null ? "" : (String) getFacesUtils()
				.getRequestParameter("searchFlag");
		if (semmrt001Bean.getRootNode() == null || "Y".equals(searchFlag)) {
			loadTree();
		}

		return semmrt001Bean.getRootNode();
	}

	public String getNodeTitle() {
		return nodeTitle;
	}

	public void setNodeTitle(String nodeTitle) {
		this.nodeTitle = nodeTitle;
	}

	public MenuTreeSP getNodeValue() {
		return nodeValue;
	}

	public void setNodeValue(MenuTreeSP nodeValue) {
		this.nodeValue = nodeValue;
	}

	public MenuTreeSP getMenuRoot() {
		return menuRoot;
	}

	public void setMenuRoot(MenuTreeSP menuRoot) {
		this.menuRoot = menuRoot;
	}

	// -> popup add vendor
	public void initAddVendor() {
		LOG.info("-- initPopupAddVendor --");

		SEMMRT001Bean mrt001Bean = getSemmrt001Bean();

		try {

			doClearPopupAddVendor();

		} catch (Exception e) {
			e.printStackTrace();
		}
		setSemmrt001Bean(mrt001Bean);
	}

	public void doSearchPopupAddVendor() {
		LOG.info("-- doSearchPopupAddVendor --");

		SEMMRT001Bean mrt001Bean = getSemmrt001Bean();

		try {

			// String strVendorCode =
			// mrt001Bean.getVendorMasterPopupObjParam().getVendorCode();
			// String strVendorName =
			// mrt001Bean.getVendorMasterPopupObjParam().getVendorName();

			IVendorMasterService service = (IVendorMasterService) getBean("vendorMasterService");
			List<VendorMasterSP> vendorMasterList = null;

			mrt001Bean.setVendorMasterPopupList(new ArrayList<WrapperBeanObject<VendorMasterSP>>());

			vendorMasterList = service.queryVendorMasterSPList(EQueryName.SP_GET_MAP_VENDOR.name, mrt001Bean
					.getVendorMasterPopupObjParam());
			if (vendorMasterList != null && !vendorMasterList.isEmpty()) {
				for (int i = 0; i < vendorMasterList.size(); i++) {
					VendorMasterSP vm = (VendorMasterSP) vendorMasterList.get(i);
					WrapperBeanObject<VendorMasterSP> tmpWrapperBean = new WrapperBeanObject<VendorMasterSP>();

					tmpWrapperBean.setDataObj(vm);
					tmpWrapperBean.setMessage("");
					mrt001Bean.getVendorMasterPopupList().add(tmpWrapperBean);

					mrt001Bean.setRenderedMsgDataNotFound(false);
				}
			} else {
				mrt001Bean.setRenderedMsgDataNotFound(true);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		setSemmrt001Bean(mrt001Bean);
	}

	public void doClearPopupAddVendor() {
		LOG.info("-- doClearPopupAddVendor --");

		SEMMRT001Bean mrt001Bean = getSemmrt001Bean();

		try {

			mrt001Bean.getVendorMasterPopupObjParam().setVendorCode("");
			mrt001Bean.getVendorMasterPopupObjParam().setVendorName("");
			mrt001Bean.setVendorMasterPopupList(new ArrayList<WrapperBeanObject<VendorMasterSP>>());

		} catch (Exception e) {
			e.printStackTrace();
		}
		setSemmrt001Bean(mrt001Bean);
	}

	public void doSelectPopupAddVendor() {
		LOG.info("-- doSelectPopupAddVendor --");

		SEMMRT001Bean mrt001Bean = getSemmrt001Bean();

		try {

			String paramVendorCode = getFacesUtils().getRequestParameter("paramVendorCode") == null ? ""
					: (String) getFacesUtils().getRequestParameter("paramVendorCode");
			String paramVendorName = getFacesUtils().getRequestParameter("paramVendorName") == null ? ""
					: (String) getFacesUtils().getRequestParameter("paramVendorName");

			mrt001Bean.getCriteria().setVendorCode(paramVendorCode);
			// mrt001Bean.getCriteria().setVendorName(paramVendorName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		setSemmrt001Bean(mrt001Bean);
	}

	// <- popup add vendor

	// added by NEW
	public void doCheckRentalStatus() {
		LOG.debug("## START SEMMRT001Action doCheckRentalStatus ##");
		semmrt001Bean = getSemmrt001Bean();
		String rentalJobStatus = semmrt001Bean.getDisplayFrmRental().getRentalJobStatus();
		try {
			if (rentalJobStatus != null && StringUtils.equals("03", rentalJobStatus)) {
				semmrt001Bean.setDisabledVerify(true);
			} else {
				semmrt001Bean.setDisabledVerify(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.debug("ERROR SEMMRT001Action doCheckRentalStatus : " + e);
			// TODO: handle exception
		} finally {
			setSemmrt001Bean(semmrt001Bean);
		}
	}

	public List<Mrt001RentCal> doBeforeAddMain(String rentalDetailId, String siteInfoId) {// PLY
		List<Mrt001RentCal> resultList = new ArrayList<Mrt001RentCal>();
		try {

			semmrt001Bean = getSemmrt001Bean();

			Mrt001RentCal cri = new Mrt001RentCal();
			IManagementService manageService = (IManagementService) getBean("managementService");
			cri.setRentalDetailId(rentalDetailId);
			cri.setSiteInfoId(siteInfoId);
			cri.setRentalCalCode(semmrt001Bean.getServiceCalTypeIdToCal());
			cri.setServiceList(semmrt001Bean.getServiceList());
			cri.setUser(getUserLogIn());
			cri.setServiceId(semmrt001Bean.getServiceCalTypeId());

			List<Mrt001RentCal> serviceConfig = manageService.querySPList(
					EQueryName.SEM_SP_MRT001_RENT_CAL_DETAIL.name, cri);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultList;

	}

	public boolean doSaveServiceCal() {
		boolean result = false;
		try {
			IManagementService manageService = (IManagementService) getBean("managementService");
			String serviceList = "";
			semmrt001Bean = getSemmrt001Bean();
			Mrt001RentCal cri = new Mrt001RentCal();

			cri.setRentalCalCode(semmrt001Bean.getServiceCalTypeIdToCal());
			cri.setPeriodAmt(semmrt001Bean.getRentCondList().get(0).getRentAmt());

			for (int i = 0; i < semmrt001Bean.getServiceNameListShowTbl().size(); i++) {
				String tmp = semmrt001Bean.getServiceNameListShowTbl().get(i).getServiceId();

				if (semmrt001Bean.serviceCalTypeIdToCal.equals("02")) {
					LOG.debug("InputPercent() : " + semmrt001Bean.getServiceNameListShowTbl().get(i).getInputPercent());
					tmp = tmp + "|" + semmrt001Bean.getServiceNameListShowTbl().get(i).getInputPercent() + ",";
					semmrt001Bean.setServiceCalTypeIdToCalName(semmrt001Bean.getServiceTypeToCalList().get(
							Integer.parseInt(semmrt001Bean.getServiceCalTypeIdToCal())).getLabel());
				} else if (semmrt001Bean.serviceCalTypeIdToCal.equals("03")) {
					LOG.debug("InputAmt() : " + semmrt001Bean.getServiceNameListShowTbl().get(i).getInputAmt());
					tmp = tmp + "|" + semmrt001Bean.getServiceNameListShowTbl().get(i).getInputAmt() + ",";
					semmrt001Bean.setServiceCalTypeIdToCalName(semmrt001Bean.getServiceTypeToCalList().get(
							Integer.parseInt(semmrt001Bean.getServiceCalTypeIdToCal())).getLabel());
				} else if (semmrt001Bean.serviceCalTypeIdToCal.equals("04")) {
					LOG.debug("InputAmt() : " + semmrt001Bean.getServiceNameListShowTbl().get(i).getConfigRate());
					tmp = tmp + "|" + semmrt001Bean.getServiceNameListShowTbl().get(i).getConfigRate() + ",";
					semmrt001Bean.setServiceCalTypeIdToCalName(semmrt001Bean.getServiceTypeToCalList().get(
							Integer.parseInt(semmrt001Bean.getServiceCalTypeIdToCal())).getLabel());
				} else if (semmrt001Bean.serviceCalTypeIdToCal.equals("01")) {
					semmrt001Bean.setServiceCalTypeIdToCalName(semmrt001Bean.getServiceTypeToCalList().get(
							Integer.parseInt(semmrt001Bean.getServiceCalTypeIdToCal())).getLabel());
				}
				serviceList = serviceList + tmp;
			}
			// PLY
			serviceList = serviceList.substring(0, serviceList.length() - 1);
			semmrt001Bean.setServiceList(serviceList);
			semmrt001Bean.setServiceShowTbl(semmrt001Bean.getServiceNameListShowTbl().get(0).getServiceName());
			semmrt001Bean.setServiceCalTypeTbl(semmrt001Bean.getServiceCalTypeIdToCalName());
			LOG.debug("serviceList : " + serviceList);
			cri.setServiceList(serviceList);

			List<Mrt001RentCal> recordSuccess = manageService
					.querySPList(EQueryName.SEM_SP_MRT001_CHK_METHOD.name, cri);
			if (recordSuccess.size() == 1) {
				semmrt001Bean.setvResult(recordSuccess.get(0).getvResult());
				semmrt001Bean.setvMessage(recordSuccess.get(0).getvMessage());
				if ((semmrt001Bean.getvMessage().equalsIgnoreCase("01"))
						|| (semmrt001Bean.getvMessage().equalsIgnoreCase("02"))
						|| (semmrt001Bean.getvMessage().equalsIgnoreCase("03"))
						|| (semmrt001Bean.getvMessage().equalsIgnoreCase("04"))) {
					semmrt001Bean.setvMessage(null);
					result = true;
				} else {
					return false;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		// return result;
		return result;
	}

	public void doChangeValue() {
		semmrt001Bean = getSemmrt001Bean();
		semmrt001Bean.setServiceCalTypeIdToCal(semmrt001Bean.getServiceCalTypeIdToCal());
		String siteInfoId = "";
		if (semmrt001Bean.getRentCondSpecial() == null) {
			siteInfoId = semmrt001Bean.getRentCondList().get(0).getSiteInfoId();
		} else {
			siteInfoId = semmrt001Bean.getRentCondSpecial().getSiteInfoId();
		}
		semmrt001Bean.setServiceNameListShowTbl(null);
		semmrt001Bean
				.setServiceNameListShowTbl(getConfigServiceMaster(siteInfoId, semmrt001Bean.getServiceCalTypeId()));
		// semmrt001Bean.setServiceNameListShowTbl(getConfigServiceMaster(siteInfoId,semmrt001Bean.getServiceCalTypeId()));
		semmrt001Bean.setvMessage(null);
		setSemmrt001Bean(semmrt001Bean);

		LOG.debug("test getServiceCalTypeIdToCal : " + semmrt001Bean.getServiceCalTypeIdToCal());
	}

	public void doViewValuebyEdit() {

		semmrt001Bean = getSemmrt001Bean();

	}

	public void doChangeValueService() {

		semmrt001Bean = getSemmrt001Bean();
		String siteInfoId = "";
		if (semmrt001Bean.getRentCondSpecial() == null) {
			siteInfoId = semmrt001Bean.getRentCondList().get(0).getSiteInfoId();
		} else {
			siteInfoId = semmrt001Bean.getRentCondSpecial().getSiteInfoId();
		}
		semmrt001Bean.setServiceCalTypeIdToCal(null);
		semmrt001Bean.setServiceCalTypeId(semmrt001Bean.getServiceCalTypeId());
		semmrt001Bean
				.setServiceNameListShowTbl(getConfigServiceMaster(siteInfoId, semmrt001Bean.getServiceCalTypeId()));
		setSemmrt001Bean(semmrt001Bean);
		LOG.debug("test getServiceCalTypeId : " + semmrt001Bean.getServiceCalTypeId());
	}

	public List<Mrt001RentCal> viewByEditMode(String rentalDetailId) {

		List<Mrt001RentCal> result = new ArrayList<Mrt001RentCal>();
		try {

			semmrt001Bean = getSemmrt001Bean();
			semmrt001Bean.setServiceNameListShowTbl(result);

			Mrt001RentCal cri = new Mrt001RentCal();
			IManagementService manageService = (IManagementService) getBean("managementService");
			cri.setRentalDetailId(rentalDetailId);

			result = manageService.querySPList(EQueryName.SEM_SP_MRT001_SRCH_CAL_DETAIL.name, cri);
			String siteInfoId = "";
			if (semmrt001Bean.getRentCondSpecial() == null) {
				siteInfoId = semmrt001Bean.getRentCondList().get(0).getSiteInfoId();
			} else {
				siteInfoId = semmrt001Bean.getRentCondSpecial().getSiteInfoId();
			}

			semmrt001Bean.setServiceNameListShowTbl(getConfigServiceMaster(siteInfoId, semmrt001Bean
					.getServiceCalTypeId()));

			for (int i = 0; i < result.size(); i++) {
				String serviceIOld = semmrt001Bean.getServiceNameListShowTbl().get(i).getServiceId();

				semmrt001Bean.setServiceCalTypeIdToCal(result.get(i).getRentalCalCode());

				if (result.get(i).getRentalCalCode().equalsIgnoreCase("01")) {
					semmrt001Bean.setShowAmt(result.get(i).getCalAmt().toString());
				} else if (result.get(i).getRentalCalCode().equalsIgnoreCase("02")) {
					for (int k = 0; k < result.size(); k++) {
						String serviceIdResult = result.get(k).getServiceId();
						if (serviceIOld.equalsIgnoreCase(serviceIdResult)) {
							semmrt001Bean.getServiceNameListShowTbl().get(i).setInputPercent(
									result.get(k).getCalAmt().toString());
							break;
						} else {

							continue;
						}
					}
				} else if (result.get(i).getRentalCalCode().equalsIgnoreCase("03")) {
					for (int k = 0; k < result.size(); k++) {
						String serviceIdResult = result.get(k).getServiceId();
						if (serviceIOld.equalsIgnoreCase(serviceIdResult)) {
							semmrt001Bean.getServiceNameListShowTbl().get(i).setInputAmt(
									result.get(k).getCalAmt().toString());
							break;
						} else {

							continue;
						}
					}
				} else if (result.get(i).getRentalCalCode().equalsIgnoreCase("04")) {
					for (int k = 0; k < result.size(); k++) {
						String serviceIdResult = result.get(k).getServiceId();
						if (serviceIOld.equalsIgnoreCase(serviceIdResult)) {
							semmrt001Bean.getServiceNameListShowTbl().get(i).setInputAmt(
									result.get(k).getCalAmt().toString());
							break;
						} else {

							continue;
						}
					}
				}
			}
			setSemmrt001Bean(semmrt001Bean);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}
}
