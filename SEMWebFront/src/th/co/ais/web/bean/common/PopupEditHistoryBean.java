package th.co.ais.web.bean.common;

import java.util.List;

import th.co.ais.domain.rt.HistoryDetailSP;
import th.co.ais.domain.rt.Mrt003Pop;
import th.co.ais.domain.si.SiteInfoMapLocSP;
import th.co.ais.web.bean.AbstractBean;

public class PopupEditHistoryBean extends AbstractBean {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7760051864638607087L;
	private HistoryDetailSP historyDetailSP;
	private List<HistoryDetailSP> historyDetailSPList;
	
	@Override
	public int getRowPerPage() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setRowPerPage(int rowPerPage) {
		// TODO Auto-generated method stub

	}

	public HistoryDetailSP getHistoryDetailSP() {
		return historyDetailSP;
	}

	public void setHistoryDetailSP(HistoryDetailSP historyDetailSP) {
		this.historyDetailSP = historyDetailSP;
	}

	public List<HistoryDetailSP> getHistoryDetailSPList() {
		return historyDetailSPList;
	}

	public void setHistoryDetailSPList(List<HistoryDetailSP> historyDetailSPList) {
		this.historyDetailSPList = historyDetailSPList;
	}


}
