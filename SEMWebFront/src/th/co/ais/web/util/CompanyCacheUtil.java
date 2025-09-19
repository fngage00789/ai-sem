package th.co.ais.web.util;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.domain.gm.Company;
import th.co.ais.domain.gm.SsoCompanyUser;
import th.co.ais.service.gm.ICompanyService;
import th.co.ais.web.action.AbstractBaseAction;
import th.co.ais.web.bean.SsoBean;

public class CompanyCacheUtil extends AbstractBaseAction{

	private static final long serialVersionUID = -6906025198518100873L;
	private Logger LOG = Logger.getLogger(getClass());
	private static CompanyCacheUtil instance = null;
	private static List<Company> companyByRole;
	private static List<Company> companyALL;
	private HashMap selectItemDataCache = null;
	public static String SESSION_NAME = CompanyCacheUtil.class.getName();
	
	public static void initCompanyByRole(String subModule) {
		if (companyByRole == null) {
			try {
				ICompanyService companyService = (ICompanyService)FacesUtils.getInstance().getBean("companyService");
				if(StringUtils.isNotBlank(subModule)){
					SsoCompanyUser filter = new SsoCompanyUser();
					filter.setSubModule(subModule);
					companyByRole = companyService.getCompanyByRole(filter);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void initCompanyAll() {
		if (companyALL == null) {
			try {
				ICompanyService companyService = (ICompanyService)FacesUtils.getInstance().getBean("companyService");
				companyALL = companyService.searchCompanyAll();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static synchronized CompanyCacheUtil getInstance() {
        if (instance == null) {
            instance = new CompanyCacheUtil();
        }
        return instance;
    }
	
	public List<SelectItem> getCompanySelItemsByRole(){
		
		LOG.info("-- getCompanySelItems --");
		SelectItem selItem = null;
		
		//get role ID from sso bean.
		SsoBean ssoBean = (SsoBean)getFacesUtils().getBean("ssoBean");
		String roleId = ssoBean.getSn();
		
		//init
		initCompanyByRole(roleId);
		//process
		List<SelectItem> selList = new LinkedList<SelectItem>();
		if (selectItemDataCache == null) {
			selectItemDataCache = new HashMap<String, Object>();
		}
		String condition = "byRoleId=" + roleId;
		if (selectItemDataCache.containsKey(condition)) {
			LOG.info("getCompanySelItemsByRole found in hashmap");
			// found hash map
			return (List<SelectItem>)selectItemDataCache.get(condition);
		} else {
			// generate selectItem
			selItem = new SelectItem("" , msg("value.selectItem"));
			selList.add(selItem);
			if(companyByRole != null && !companyByRole.isEmpty()){
				for (Company temp : companyByRole) {
					selItem = new SelectItem();
					selItem.setLabel(temp.getRowId());
					selItem.setValue(temp.getRowId());
					selList.add(selItem);
				}
			}
			selectItemDataCache.put(condition, selList);
		}
		return (List<SelectItem>)selectItemDataCache.get(condition);
	}
	
	public List<SelectItem> getCompanySelItemsALL(){
		
		LOG.info("-- getCompanySelItemsALL --");
		SelectItem selItem = null;
		
		//init
		initCompanyAll();
		
		//process
		List<SelectItem> selList = new LinkedList<SelectItem>();
		if (selectItemDataCache == null) {
			selectItemDataCache = new HashMap<String, Object>();
		}
		String condition = "byALL";
		if (selectItemDataCache.containsKey(condition)) {
			LOG.info("getCompanySelItemsALL found in hashmap");
			// found hash map
			return (List<SelectItem>)selectItemDataCache.get(condition);
		} else {
			// generate selectItem
			selItem = new SelectItem("" , msg("value.selectItem"));
			selList.add(selItem);
			if(companyALL != null && !companyALL.isEmpty()){
				for (Company temp : companyALL) {
					selItem = new SelectItem();
					selItem.setLabel(temp.getRowId());
					selItem.setValue(temp.getRowId());
					selList.add(selItem);
				}
			}
			selectItemDataCache.put(condition, selList);
		}
		return (List<SelectItem>)selectItemDataCache.get(condition);
	}

	public static List<Company> getCompanyALL() {
		return companyALL;
	}

	public static void setCompanyALL(List<Company> companyALL) {
		CompanyCacheUtil.companyALL = companyALL;
	}

	public HashMap getSelectItemDataCache() {
		return selectItemDataCache;
	}

	public void setSelectItemDataCache(HashMap selectItemDataCache) {
		this.selectItemDataCache = selectItemDataCache;
	}
	
}
