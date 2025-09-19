package th.co.ais.web.bean.common;

import java.util.List;

import th.co.ais.domain.rt.Mrt003Pop;
import th.co.ais.domain.si.SiteInfoMapLocSP;
import th.co.ais.web.bean.AbstractBean;

public class PopupRentalPayBean extends AbstractBean {
	
	private Mrt003Pop mrt003PopSP;
	private List<Mrt003Pop> mrt003PopSPList;
	
	@Override
	public int getRowPerPage() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setRowPerPage(int rowPerPage) {
		// TODO Auto-generated method stub

	}

	public Mrt003Pop getMrt003PopSP() {
		return mrt003PopSP;
	}

	public void setMrt003PopSP(Mrt003Pop mrt003PopSP) {
		this.mrt003PopSP = mrt003PopSP;
	}

	public List<Mrt003Pop> getMrt003PopSPList() {
		return mrt003PopSPList;
	}

	public void setMrt003PopSPList(List<Mrt003Pop> mrt003PopSPList) {
		this.mrt003PopSPList = mrt003PopSPList;
	}

}
