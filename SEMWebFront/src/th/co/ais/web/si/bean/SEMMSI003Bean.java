package th.co.ais.web.si.bean;

import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.si.PopupContractSearchSP;
import th.co.ais.domain.si.SiteInfoMapLocSP;
import th.co.ais.domain.si.SiteTerminate;
import th.co.ais.domain.si.SiteTerminateSP;
import th.co.ais.web.bean.AbstractBean;

public class SEMMSI003Bean extends AbstractBean {

	private static final long serialVersionUID = 7164670455509692855L;
	
	private List<SelectItem> companyList;
	private List<SelectItem> regionList;
	private List<SiteTerminateSP> siteTerminateSPList;
	private SiteTerminateSP siteTerminateSP;
	private SiteTerminate siteTerminate;
	private PopupContractSearchSP popupContractCriteria;
	private List<PopupContractSearchSP> contractList;
	private Date effDate;
	private Date expDate;
	private SiteInfoMapLocSP siteInfoMapLocSP;
	private List<SiteInfoMapLocSP> siteInfoMapLocSPList;
	private String pageStatus;
	private boolean renderPanelLog;
	private boolean renderBtnBack;
	private boolean renderBtnSave;
	private boolean renderBtnNew;
	private boolean renderBtnPopup;
	private boolean disabledModeView;
	private String confirmDeleteMsg;
	private String confirmResetMsg;
	
	
	public List<SelectItem> getCompanyList() {
		return companyList;
	}
	public void setCompanyList(List<SelectItem> companyList) {
		this.companyList = companyList;
	}
	public List<SelectItem> getRegionList() {
		return regionList;
	}
	public void setRegionList(List<SelectItem> regionList) {
		this.regionList = regionList;
	}
	
	
	public List<SiteTerminateSP> getSiteTerminateSPList() {
		return siteTerminateSPList;
	}
	public void setSiteTerminateSPList(List<SiteTerminateSP> siteTerminateSPList) {
		this.siteTerminateSPList = siteTerminateSPList;
	}
	public SiteTerminateSP getSiteTerminateSP() {
		return siteTerminateSP;
	}
	public void setSiteTerminateSP(SiteTerminateSP siteTerminateSP) {
		this.siteTerminateSP = siteTerminateSP;
	}
	
	public SiteTerminate getSiteTerminate() {
		return siteTerminate;
	}
	public void setSiteTerminate(SiteTerminate siteTerminate) {
		this.siteTerminate = siteTerminate;
	}
	
	public PopupContractSearchSP getPopupContractCriteria() {
		return popupContractCriteria;
	}
	public void setPopupContractCriteria(PopupContractSearchSP popupContractCriteria) {
		this.popupContractCriteria = popupContractCriteria;
	}
	public List<PopupContractSearchSP> getContractList() {
		return contractList;
	}
	public void setContractList(List<PopupContractSearchSP> contractList) {
		this.contractList = contractList;
	}
	
	public Date getEffDate() {
		return effDate;
	}
	public void setEffDate(Date effDate) {
		this.effDate = effDate;
	}
	public Date getExpDate() {
		return expDate;
	}
	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}
	public SiteInfoMapLocSP getSiteInfoMapLocSP() {
		return siteInfoMapLocSP;
	}
	public void setSiteInfoMapLocSP(SiteInfoMapLocSP siteInfoMapLocSP) {
		this.siteInfoMapLocSP = siteInfoMapLocSP;
	}
	public List<SiteInfoMapLocSP> getSiteInfoMapLocSPList() {
		return siteInfoMapLocSPList;
	}
	public void setSiteInfoMapLocSPList(List<SiteInfoMapLocSP> siteInfoMapLocSPList) {
		this.siteInfoMapLocSPList = siteInfoMapLocSPList;
	}
	
	public String getPageStatus() {
		return pageStatus;
	}
	public void setPageStatus(String pageStatus) {
		this.pageStatus = pageStatus;
	}
	
	
	public boolean isRenderPanelLog() {
		return renderPanelLog;
	}
	public void setRenderPanelLog(boolean renderPanelLog) {
		this.renderPanelLog = renderPanelLog;
	}
	
	public boolean isRenderBtnBack() {
		return renderBtnBack;
	}
	public void setRenderBtnBack(boolean renderBtnBack) {
		this.renderBtnBack = renderBtnBack;
	}
	public boolean isRenderBtnSave() {
		return renderBtnSave;
	}
	public void setRenderBtnSave(boolean renderBtnSave) {
		this.renderBtnSave = renderBtnSave;
	}
	public boolean isRenderBtnNew() {
		return renderBtnNew;
	}
	public void setRenderBtnNew(boolean renderBtnNew) {
		this.renderBtnNew = renderBtnNew;
	}
	
	public boolean isRenderBtnPopup() {
		return renderBtnPopup;
	}
	public void setRenderBtnPopup(boolean renderBtnPopup) {
		this.renderBtnPopup = renderBtnPopup;
	}
	
	public boolean isDisabledModeView() {
		return disabledModeView;
	}
	public void setDisabledModeView(boolean disabledModeView) {
		this.disabledModeView = disabledModeView;
	}
	
	public String getConfirmDeleteMsg() {
		return confirmDeleteMsg;
	}
	public void setConfirmDeleteMsg(String confirmDeleteMsg) {
		this.confirmDeleteMsg = confirmDeleteMsg;
	}
	
	public String getConfirmResetMsg() {
		return confirmResetMsg;
	}
	public void setConfirmResetMsg(String confirmResetMsg) {
		this.confirmResetMsg = confirmResetMsg;
	}
	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}
	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}
	
	
}
