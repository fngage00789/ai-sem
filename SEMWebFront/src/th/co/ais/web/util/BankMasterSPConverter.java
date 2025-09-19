package th.co.ais.web.util;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import th.co.ais.domain.gm.BankMasterSP;
import th.co.ais.service.gm.IBankMasterService;
import th.co.ais.util.EQueryName;

public class BankMasterSPConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		List<BankMasterSP> bankMasterList = null;
		
		try {
			bankMasterList = findAllBank();
			
			for (BankMasterSP bank : bankMasterList) {
				String valueSelected = getBankValue(bank);
				if(value.equals(valueSelected)) {
					return bank;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@SuppressWarnings("unchecked")
	private List<BankMasterSP> findAllBank() throws Exception {
		Object tmp = FacesUtils.getInstance().getHttpRequest().getAttribute("bankMasterListTmp");
		if(tmp == null) {
			IBankMasterService service = (IBankMasterService)getBean("bankMasterService");
			List<BankMasterSP> bankMasterList = service.querySPList(EQueryName.SP_MCT009_BANKMASTER_SEARCH_DDL_BANK.name, new BankMasterSP());
			FacesUtils.getInstance().getHttpRequest().setAttribute("bankMasterListTmp", bankMasterList);
			return bankMasterList;
		} else {
			return (List<BankMasterSP>) tmp;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		return (String) value;
	}
	
	private String getBankValue(BankMasterSP bank) {
		return bank.getBankGroupCode()+"#"+bank.getBankName();
	}
	
	public Object getBean(String name) {
		return FacesUtils.getInstance().getBean(name);
	}

}
