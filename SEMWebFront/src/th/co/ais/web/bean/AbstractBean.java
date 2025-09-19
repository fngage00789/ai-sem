package th.co.ais.web.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.model.SelectItem;

import th.co.ais.web.util.FacesUtils;
import th.co.ais.web.util.WebUtil;

public abstract class AbstractBean extends AbstractConfiguration {

	private static final long serialVersionUID = -1383641473985943656L;

	public abstract int getRowPerPage();

	public abstract void setRowPerPage(int rowPerPage);

	public String navModuleFrom;
	public String navProgramFrom;
	public String moduleWithNaviFrom;
	public String actionWithNaviFrom;
	public String methodWithNaviFrom;

	public String userLogin;
	public String userTelNo;
	public String tmpRowId;

	public String sortMode;
	public String selectionMode;
	public String tableState;
	public org.richfaces.model.selection.SimpleSelection selection;

	// default scroller page
	public String scrollerPage = "1";
	// set pop up open or close when user save or edit.
	public Boolean popupClose = false;

	// Render Message Data not found
	private boolean renderedMsgDataNotFound = false;

	// Render message form search
	private boolean renderedMsgFormSearch = true;
	// Render message form edit
	private boolean renderedMsgFormTop = true;
	private boolean renderedMsgFormMiddle = true;
	private boolean renderedMsgFormBottom = true;

	private boolean renderedDailog = true;

	private boolean isViewMode = false;

	private String actModeDisplay;

	public String getActModeDisplay() {
		return actModeDisplay;
	}

	public void setActModeDisplay(String actModeDisplay) {
		this.actModeDisplay = actModeDisplay;
	}

	public String getUserLogin() {
		String username = "";

		SsoBean ssoBean = (SsoBean) FacesUtils.getInstance()
				.getSessionMapValue("ssoBean");
		if (ssoBean != null) {
			username = ssoBean.getUserName();
			// LOG.info("getUserLogin() --> " + username);
		}
		return username;
	}

	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;

	}

	public String getUserTelNo() {
		String userTelNo = "";

		SsoBean ssoBean = (SsoBean) FacesUtils.getInstance()
				.getSessionMapValue("ssoBean");
		if (ssoBean != null) {
			if (ssoBean.getEmployee() != null) {
				userTelNo = ssoBean.getEmployee().getTelNo();
			}

			// LOG.info("Employee getTelNo() --> " + userTelNo);
		}
		return userTelNo;
	}

	public void setUserTelNo(String userTelNo) {
		this.userTelNo = userTelNo;
	}

	protected SelectItem setInitDropDown() {
		SelectItem item = new SelectItem("", "-- Select --");
		return item;
	}

	protected List<SelectItem> getEmptyDropDown() {
		List<SelectItem> selList = new ArrayList<SelectItem>();
		selList.add(setInitDropDown());
		return selList;
	}

	public Map<String, Boolean> getRenderer() {
		Map<String, Boolean> map = WebUtil.getRenders();
		return map;
	}
	
	public Map<String, Boolean> getRendererSSO() {
//		System.out.println("abstractBean WebUtil.getRenderSSO() = "+WebUtil.getRenderSSO());
		return WebUtil.getRenderSSO();
	}

	public Map<String, Boolean> getDisabler() {
		Map<String, Boolean> map = WebUtil.getDisables();
		return map;
	}

	public String getTmpRowId() {
		return tmpRowId;
	}

	public void setTmpRowId(String tmpRowId) {
		this.tmpRowId = tmpRowId;
	}

	public String getScrollerPage() {
		return scrollerPage;
	}

	public void setScrollerPage(String scrollerPage) {
		this.scrollerPage = scrollerPage;
	}

	public Boolean getPopupClose() {
		return popupClose;
	}

	public void setPopupClose(Boolean popupClose) {
		this.popupClose = popupClose;
	}

	public boolean isRenderedMsgDataNotFound() {
		return renderedMsgDataNotFound;
	}

	public void setRenderedMsgDataNotFound(boolean renderedMsgDataNotFound) {
		this.renderedMsgDataNotFound = renderedMsgDataNotFound;
	}

	public boolean isRenderedMsgFormSearch() {
		return renderedMsgFormSearch;
	}

	public void setRenderedMsgFormSearch(boolean renderedMsgFormSearch) {
		this.renderedMsgFormSearch = renderedMsgFormSearch;
	}

	public boolean isRenderedDailog() {
		return renderedDailog;
	}

	public void setRenderedDailog(boolean renderedDailog) {
		this.renderedDailog = renderedDailog;
	}

	public boolean isRenderedMsgFormTop() {
		return renderedMsgFormTop;
	}

	public void setRenderedMsgFormTop(boolean renderedMsgFormTop) {
		this.renderedMsgFormTop = renderedMsgFormTop;
	}

	public boolean isRenderedMsgFormMiddle() {
		return renderedMsgFormMiddle;
	}

	public void setRenderedMsgFormMiddle(boolean renderedMsgFormMiddle) {
		this.renderedMsgFormMiddle = renderedMsgFormMiddle;
	}

	public boolean isRenderedMsgFormBottom() {
		return renderedMsgFormBottom;
	}

	public void setRenderedMsgFormBottom(boolean renderedMsgFormBottom) {
		this.renderedMsgFormBottom = renderedMsgFormBottom;
	}

	public String getNavModuleFrom() {
		return navModuleFrom;
	}

	public void setNavModuleFrom(String navModuleFrom) {
		this.navModuleFrom = navModuleFrom;
	}

	public String getNavProgramFrom() {
		return navProgramFrom;
	}

	public void setNavProgramFrom(String navProgramFrom) {
		this.navProgramFrom = navProgramFrom;
	}

	public String getModuleWithNaviFrom() {
		return moduleWithNaviFrom;
	}

	public void setModuleWithNaviFrom(String moduleWithNaviFrom) {
		this.moduleWithNaviFrom = moduleWithNaviFrom;
	}

	public String getActionWithNaviFrom() {
		return actionWithNaviFrom;
	}

	public void setActionWithNaviFrom(String actionWithNaviFrom) {
		this.actionWithNaviFrom = actionWithNaviFrom;
	}

	public String getMethodWithNaviFrom() {
		return methodWithNaviFrom;
	}

	public void setMethodWithNaviFrom(String methodWithNaviFrom) {
		this.methodWithNaviFrom = methodWithNaviFrom;
	}

	public boolean isViewMode() {
		return isViewMode;
	}

	public void setViewMode(boolean isViewMode) {
		this.isViewMode = isViewMode;
	}

	public String getSortMode() {
		return sortMode;
	}

	public void setSortMode(String sortMode) {
		this.sortMode = sortMode;
	}

	public String getSelectionMode() {
		return selectionMode;
	}

	public void setSelectionMode(String selectionMode) {
		this.selectionMode = selectionMode;
	}

	public String getTableState() {
		return tableState;
	}

	public void setTableState(String tableState) {
		this.tableState = tableState;
	}

	public org.richfaces.model.selection.SimpleSelection getSelection() {
		return selection;
	}

	public void setSelection(
			org.richfaces.model.selection.SimpleSelection selection) {
		this.selection = selection;
	}

}
